package r2ps.parser;

import com.alibaba.fastjson.JSONArray;
import com.csvreader.CsvReader;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import lombok.Getter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;
import org.jsfr.json.JsonSurfer;
import org.jsfr.json.JsonSurferJackson;
import org.jsfr.json.SurfingConfiguration;
import org.xml.sax.XMLFilter;
import r2ps.loadfunc.DataRetrieval;

import javax.xml.stream.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static r2ps.parser.ParseTutle.*;

public class ParseData {
    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());

    public enum SourceType {
        XML,
        JSON,
        CSV,
        MySQL,
        SQLServer,
        SPARQL,
        Postgresql,
        RDB
    }

    public static class Param {
        public InputStream input;
        public OutputStream output;
        public String prefix;
        //public int size;
        public String[] paths;
        public String outPath;
        public SourceType sourceType;
        public String resultFormat;
        public List<String> header = new ArrayList<>();
    }

    @Getter
    public enum SPARQLResultFormat {

        XML("XMLRecordFactory", "http://www.w3.org/ns/formats/SPARQL_Results_XML", "application/sparql-results+xml",
                // referenceFormulations:
                "http://semweb.mmlab.be/ns/ql#XPath"
        ),
        JSON("JSONRecordFactory", "http://www.w3.org/ns/formats/SPARQL_Results_JSON", "application/sparql-results+json",
                // referenceFormulations:
                "http://semweb.mmlab.be/ns/ql#JSONPath"
        ),
        CSV("CSV", "http://www.w3.org/ns/formats/SPARQL_Results_CSV", "text/csv",
                // referenceFormulations:
                "http://semweb.mmlab.be/ns/ql#CSV"
        );

        private final String name;
        private final String uri;
        private final String contentType;
        private final Set<String> referenceFormulations;

        SPARQLResultFormat(String name, String uri, String contentType, String... referenceFormulations) {
            this.name = name;
            this.uri = uri;
            this.contentType = contentType;
            this.referenceFormulations = new HashSet<>(Arrays.asList(referenceFormulations));
        }
    }

    public static void Nested2Flatten(DataRetrieval dataRetrieval) {

        try {
            JSONArray paths = dataRetrieval.getJsonArray();
            SourceType type = SourceType.CSV;
            //InputStream inputStream = null;
            List<String> lstStrPaths = null;
            String strResultFomat = "";
            if (paths != null) {
                //inputStream = LoadData(dataRetrieval);
                String formul = dataRetrieval.getReferenceFormulation().toLowerCase();
                LinkedHashSet<String> lsPaths = new LinkedHashSet<>();
                List<Object> resultFormat = new ArrayList<>();
                if (formul.equalsIgnoreCase("ql:xpath")) {
                    type = SourceType.XML;
                    String iterator = dataRetrieval.getIterator();
                    if (!iterator.endsWith("/")) {
                        iterator = iterator + "/";
                    }
                    for (Object o : paths) {
                        List<String> ps = ((JSONArray) o).toJavaList(String.class);
                        ps = ParseTutle.extractValueFromTemplate(ps);
                        for (int j = 0; j < ps.size(); ++j) {
                            String path = ps.get(j);
                            if (!path.startsWith("/")) {
                                path = iterator + path;
                            } else {
                                path = FixXMLpath(path);
                            }
                            ps.set(j, path);
                        }
                        resultFormat.add(ps);
                        lsPaths.addAll(ps);
                    }
                } else if (formul.equalsIgnoreCase("ql:jsonpath")) {
                    type = SourceType.JSON;
                    String iterator = dataRetrieval.getIterator();
                    if (!iterator.endsWith(".")) {
                        iterator = iterator + ".";
                    }
                    for (Object o : paths) {
                        List<String> ps = ((JSONArray) o).toJavaList(String.class);
                        ps = ParseTutle.extractValueFromTemplate(ps);
                        for (int j = 0; j < ps.size(); ++j) {
                            String path = ps.get(j);
                            if (!path.startsWith("$")) {
                                path = iterator + path;
                            } else {
                                path = FixJsonpath(path);
                            }
                            ps.set(j, path);
                        }
                        resultFormat.add(ps);
                        lsPaths.addAll(ps);
                    }
                } else {
                    type = SourceType.CSV;
                    for (Object path : paths) {
                        List<String> ps = ((JSONArray) path).toJavaList(String.class);
                        ps = ParseTutle.extractValueFromTemplate(ps);
                        resultFormat.add(ps);
                        lsPaths.addAll(ps);
                    }
                }

                lstStrPaths = new ArrayList<>(lsPaths);
                strResultFomat = ListFormat2StringFormat(lstStrPaths, resultFormat);
            }

            new ParseData().GenerateData(dataRetrieval ,type, lstStrPaths, strResultFomat);
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static String ListFormat2StringFormat(List<String> lstStrPaths, List<Object> resultFormat) {
        StringBuilder strResultFomat = new StringBuilder();
        for (Object obj : resultFormat) {
            StringBuilder cell = new StringBuilder();
            if (obj instanceof String) {
                String s = (String) obj;
                cell.append("{").append(lstStrPaths.indexOf(s)).append("},");
            } else {
                List<String> ls = cast(obj);
                for (String s : ls) {
                    String ss = "{" + lstStrPaths.indexOf(s) + "},";
                    cell.append(ss);
                }
            }
            strResultFomat.append(cell.substring(0, cell.length() - 1)).append("|");
        }
        strResultFomat = new StringBuilder(strResultFomat.substring(0, strResultFomat.length() - 1) + "\r\n");
        return strResultFomat.toString();
    }

    public static boolean LoadData(DataRetrieval dataRetrieval, Param param) throws IOException {
        boolean bContinue = true;
        boolean bRet = true;
        DataRetrieval.SPARQL sparql = dataRetrieval.getSparql();
        DataRetrieval.Database db = dataRetrieval.getDatabase();
        DataRetrieval.CsvOnWeb csvOnWeb = dataRetrieval.getCsvOnWeb();
        DataRetrieval.WebAPI webAPI = dataRetrieval.getWebAPI();
        DataRetrieval.Dataset dataset = dataRetrieval.getDataset();
        dataRetrieval.setQuery(URLDecoder.decode(dataRetrieval.getQuery(), "utf-8"));
        dataRetrieval.setTableName(URLDecoder.decode(dataRetrieval.getTableName(), "utf-8"));
        try {
            if (sparql != null) {
                param.input = dataRetrieval.ReadFromSPARQL_SD(param);
                bContinue = true;
            } else if (db != null) {
                bRet = dataRetrieval.ReadFromD2RQ(param);
                bContinue = false;
            } else if (csvOnWeb != null) {
                param.input = dataRetrieval.ReadFromCSVW(param);
            } else if (dataset != null) {
                param.input = dataRetrieval.ReadFromDCAT(param);
            } else if (webAPI != null) {
                param.input = dataRetrieval.ReadFromWebAPI(param);
            } else if (IsURL(dataRetrieval.getName())) {
                param.input = dataRetrieval.ReadFromURL(dataRetrieval.getName());
            }
            else {
                //Local file
                Path fspath = new Path(dataRetrieval.getName());
                Configuration conf = new Configuration();
                FileSystem fs = FileSystem.get(fspath.toUri(), conf);
                LOG.info("Localfile:" + fspath.toString());
                param.input = fs.open(fspath);
            }

            if (!bRet) {
                //Read failed
                //invalid table name or source path, etc
                param.output.write("none\nnone".getBytes());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return bContinue;
    }

    public static boolean IsURL(String url) {
        String regex = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url.trim());
        return matcher.matches();
    }

    public void GenerateData(DataRetrieval dr, SourceType type, List<String> paths, String strResultFomat) throws IOException, DocumentException {
        Param para = new Param();
        para.outPath = dr.getOutPath();
        para.sourceType = type;
        para.resultFormat = strResultFomat;

        Configuration conf = new Configuration();
        Path fspath = new Path(para.outPath);
        FileSystem fs = FileSystem.get(fspath.toUri(), conf);
        para.output = fs.create(fspath);

        if (paths == null) {
            para.output.write("none\nnone".getBytes());
            para.output.close();
            return;
        }

        para.paths = new String[paths.size()];
        para.header.addAll(Collections.nCopies(paths.size(), DataRetrieval.RMLType.LITERAL.getType()));
        String prefix = GetCommonPrefix(paths);
        if (type == SourceType.XML) {
            int p = prefix.lastIndexOf("/");
            prefix = prefix.substring(0, p);
            prefix = ParseTutle.FixXMLpath(prefix);
            para.prefix = prefix;

            for (int i = 0; i < paths.size(); i++) {
                String xpath = paths.get(i);
                if (!xpath.equals(prefix)) {
                    xpath = xpath.substring(para.prefix.length());
                    if (xpath.startsWith("/")) xpath = xpath.substring(1);
                    para.paths[i] = xpath;
                }
            }
            if (LoadData(dr, para)) {
                WriteHeader(para);
                ParseXML(para, strResultFomat);
            }
        } else if (type == SourceType.JSON) {
            int p = prefix.lastIndexOf(".");
            prefix = prefix.substring(0, p);
            prefix = ParseTutle.FixJsonpath(prefix);
            para.prefix = prefix;

            for (int i = 0; i < paths.size(); i++) {
                String xpath = paths.get(i);
                if (!xpath.equals(prefix)) {
                    xpath = xpath.substring(para.prefix.length());
                    if (xpath.startsWith(".")) xpath = xpath.substring(1);
                    para.paths[i] = xpath;
                }
            }
            if (LoadData(dr, para)) {
                WriteHeader(para);
                ParseJSON(para, strResultFomat);
            }
        } else if (type == SourceType.CSV) {
            para.prefix = prefix;
            para.paths = new String[paths.size()];
            para.paths = paths.toArray(para.paths);
            if (LoadData(dr, para)) {
                WriteHeader(para);
                ParseCSV(para, strResultFomat);
            }
        } else {
            assert (false);
        }

        //fs.close(); cause Filesystem closed
        assert(para.output != null);
        para.output.close();
        if (para.input != null) {
            para.input.close();
        }
    }

    protected void ParseXML(Param para, String resultFormat) throws DocumentException, ClassCastException, IOException {
        LOG.info("----------------------ParseXML:Begin----------------------");
        List<Object> line = Arrays.asList(new Object[para.paths.length]);
        String[] result = new String[line.size()];
        for (int i = 0; i < line.size(); ++i) {
            line.set(i, new ArrayList<>());
        }
        SAXReader reader = SAXReader.createDefault();
        reader.addHandler(para.prefix, new ElementHandler() {
            @Override
            public void onStart(ElementPath elementPath) {
                //Do Nothing
            }

            @Override
            public void onEnd(ElementPath elementPath) {
                Element n = elementPath.getCurrent();
                for (int k = 0; k < para.paths.length; ++k) {
                    List<Object> cell = cast(line.get(k));
                    String path = para.paths[k];
                    String str;
                    if (!path.equals(para.prefix)) {
                        List<org.dom4j.Node> o = n.selectNodes(path);
                        for (Object value : o) {
                            if (value instanceof DefaultAttribute) {
                                DefaultAttribute da = (DefaultAttribute) value;
                                str = da.getValue();
                            } else {
                                Element e = (Element) value;
                                str = e.getTextTrim();
                            }
                            cell.add(str.trim());
                        }
                    } else {
                        str = n.getTextTrim();
                        cell.add(str);
                    }
                }
                TravelTuple(result, line, 0, para.output, resultFormat);
                for (Object o : line) {
                    ArrayList<Object> los = cast(o);
                    los.clear();
                }
                //n.getParent().content().clear();
                n.detach();
            }
        });

        R2PInputStreamFilter filter = new R2PInputStreamFilter(para.input);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(filter);

        reader.read(bufferedInputStream);

        LOG.info("----------------------ParseXML:End----------------------");
    }

    protected void ParseJSON(Param para, String resultFormat) throws ClassCastException {
        LOG.info("ParseJSON:Begin");
        List<Object> line = Arrays.asList(new Object[para.paths.length]);
        String[] result = new String[line.size()];
        for (int i = 0; i < line.size(); ++i) {
            line.set(i, new ArrayList<>());
        }
        com.jayway.jsonpath.Configuration.ConfigurationBuilder jsonConf = com.jayway.jsonpath.Configuration.builder().options(Option.SUPPRESS_EXCEPTIONS);
        JsonSurfer surfer = JsonSurferJackson.INSTANCE;
        SurfingConfiguration config = surfer.configBuilder()
                .bind(para.prefix, (value, context) -> {
                    ObjectNode n = (ObjectNode) value;
                    String subJson = n.toString();
                    DocumentContext documentContext = JsonPath.using(jsonConf.build()).parse(subJson);
                    for (int k = 0; k < para.paths.length; ++k) {
                        List<Object> cell = cast(line.get(k));
                        String path = para.paths[k];
                        String str;
                        if (!path.equals(para.prefix)) {
                            Object o = documentContext.read(path);
                            if (o == null) {
                                cell.add("");
                            }
                            else{
                                Collection coll = new ArrayList();
                                if (o instanceof Collection) {
                                    coll = cast(o);
                                }
                                else{
                                    coll.add(o);
                                }
                                for (Object item : coll) {
                                    str = item.toString();
                                    cell.add(str.trim());
                                }
                            }
                        } else {
                            str = JsonPath.read(subJson, path);
                            cell.add(str);
                        }
                    }
                    TravelTuple(result, line, 0, para.output, resultFormat);
                    for (Object o : line) {
                        ArrayList<Object> los = cast(o);
                        los.clear();
                    }
                })
                .build();
        surfer.surf(para.input, config);
        LOG.info("ParseJSON:End");
    }

    protected void ParseCSV(Param para, String resultFormat) throws IOException, ClassCastException {
        LOG.info("ParseCSV:Begin");
        if (para.input == null) {
            return;
        }
        CsvReader csvReader = new CsvReader(para.input, Charset.defaultCharset());
        csvReader.readHeaders();
        ArrayList<String> line = new ArrayList<>();
        while (csvReader.readRecord()) {
            for (String path : para.paths) {
                line.add(R2PEncode(csvReader.get(path)));
            }
            para.output.write(MessageFormat.format(resultFormat, line.toArray()).getBytes());
            line.clear();
        }
        LOG.info("ParseCSV:End");
    }

    public static void WriteHeader(Param param) throws IOException {
        param.output.write(MessageFormat.format(param.resultFormat, param.header.toArray()).getBytes());
    }

    private static void TravelTuple(String[] result, List<Object> line, int i, OutputStream output, String resultFormat) throws ClassCastException {
        List<Object> field = cast(line.get(i));
        if (i + 1 >= line.size()) {
            if (field.isEmpty()) {
                field.add("");
            }
            for (Object o : field) {
                result[i] = R2PEncode((String) o);
                String t = MessageFormat.format(resultFormat, result);
                try {
                    output.write(t.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (Object o : field) {
                result[i] = R2PEncode((String) o);
                TravelTuple(result, line, i + 1, output, resultFormat);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }

    public static String transformDatatypeString(String input, String datatype) {
        switch (datatype) {
            case "hexBinary":
                // TODO
                return input;
            case "decimal":
                return "" + Double.parseDouble(input);
            case "integer":
                return "" + Integer.parseInt(input);
            case "double":
                return formatToScientific(Double.parseDouble(input));
            case "boolean":
                switch (input) {
                    case "t":
                    case "true":
                    case "TRUE":
                    case "1":
                        return "true";
                    default:
                        return "false";
                }
//            case "date":
//            case "time":
//                return input;
            case "dateTime":
                input = input.replaceAll("(.*)\\.(\\d)+$","$1");
                return input.replace(" ", "T");
            default:
                return input;
        }
    }

    private static String formatToScientific(Double d) {
        BigDecimal input = BigDecimal.valueOf(d).stripTrailingZeros();
        int precision = input.scale() < 0
                ? input.precision() - input.scale()
                : input.precision();
        StringBuilder s = new StringBuilder("0.0");
        for (int i = 2; i < precision; i++) {
            s.append("#");
        }
        s.append("E0");
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat df = (DecimalFormat) nf;
        df.applyPattern(s.toString());
        return df.format(d);
    }
}