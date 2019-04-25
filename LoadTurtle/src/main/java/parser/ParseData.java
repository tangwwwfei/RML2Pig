package parser;

import be.ugent.mmlab.rml.input.processor.ApiProcessor;
import be.ugent.mmlab.rml.input.processor.SparqlProcessor;
import be.ugent.mmlab.rml.input.std.StdSparqlSdSource;
import be.ugent.mmlab.rml.model.LogicalSource;
import be.ugent.mmlab.rml.model.source.std.StdApiSource;
import be.ugent.mmlab.rml.model.source.std.StdSparqlEndpointSource;
import be.ugent.mmlab.rml.model.std.StdLogicalSource;
import be.ugent.mmlab.rml.vocabularies.QLVocabulary;
import be.ugent.mmlab.rml.vocabularies.QLVocabulary.QLTerm;
import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPath;
import com.csvreader.CsvReader;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.io.ByteStreams;
import loadfunc.DataRetrieval;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.Text;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.BagFactory;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.apache.jena.fuseki.embedded.FusekiServer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.sql.ResultSet;
import java.util.*;

import java.io.InputStream;
import java.net.URI;





import static parser.ParseTutle.GetCommonPrefix;
import static parser.ParseTutle.IsURL;

public class ParseData {
    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());
    static int datasetNumber = 1;
    public enum SourceType{
        XML,
        JSON,
        CSV,
        MySQL,
        SQLServer,
        SPARQL,
        Postgresql,
        RDB
    }
    public class Paramter{
        public InputStream input;
        public String prefix;
        //public int size;
        public String[] pathes;
        public String url;
        public String endpoint;
        public String query;
        public String resultFormat;
        public String iterator;
        public String referenceFormulation;
    }

    public DataBag ParseData(String path, SourceType type, List<String> pathes, Tuple resultFormat) throws IOException {

        Paramter para = new Paramter();
        Configuration conf = new Configuration();
        if (IsURL(path)){
            URL url = new URL(path);
            path = url.getFile().substring(1);
            para.input= new java.io.BufferedInputStream(
                    url.openStream());
        }
        else {
            Path fspath = new Path(path);
            FileSystem fs = FileSystem.get(fspath.toUri(), conf);
            FSDataInputStream inputStream = fs.open(fspath);
            para.input = inputStream;
        }
        para.pathes = new String[pathes.size()];
        String prefix = GetCommonPrefix(pathes);
        DataBag parseResult = BagFactory.getInstance().newDistinctBag();
        if (type == SourceType.XML) {
            int p = prefix.lastIndexOf("/");
            prefix = prefix.substring(0, p);
            prefix = ParseTutle.FixXMLpath(prefix);
            para.prefix = prefix;

            for (int i = 0; i < pathes.size() ; i++) {
                String xpath = pathes.get(i);
                if (!xpath.equals(prefix)) {
                    xpath = xpath.substring(para.prefix.length());
                    if (xpath.startsWith("/")) xpath = xpath.substring(1);
                    para.pathes[i] = xpath;
                }
            }
            try {
                parseResult = ParseXML(para);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (XPathFactoryConfigurationException e) {
                e.printStackTrace();
            }
        }
        else if (type == SourceType.JSON) {
            int p = prefix.lastIndexOf(".");
            prefix = prefix.substring(0, p);
            prefix = ParseTutle.FixJsonpath(prefix);
            para.prefix = prefix;

            for (int i = 0; i < pathes.size() ; i++) {
                String xpath = pathes.get(i);
                if (!xpath.equals(prefix)) {
                    xpath = xpath.substring(para.prefix.length());
                    if (xpath.startsWith(".")) xpath = xpath.substring(1);
                    para.pathes[i] = xpath;
                }
            }

            try {
                parseResult = ParseJSON(para);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else if (type == SourceType.CSV) {
            para.prefix = prefix;
            para.pathes = new String[pathes.size()];
            para.pathes = pathes.toArray(para.pathes);
            try {
                parseResult = ParseCSV(para);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type == SourceType.RDB) {

        }
        /*else if (type == SourceType.MySQL) {
            parseResult = ParseMySQL(para);
        }
        else if (type == SourceType.SQLServer) {
            parseResult = ParseSQLServer(para);
        }
        else if (type == SourceType.SPARQL) {
            parseResult = ParseSPARQL(para);
        }
        else if (type == SourceType.Postgresql) {
            parseResult = ParsePostgresql(para);
        }*/
        else {
            //fs.close();
            return BagFactory.getInstance().newDistinctBag();
        }

        DataBag ret = BagFactory.getInstance().newDistinctBag();
        Iterator lineItr = parseResult.iterator();
        while(lineItr.hasNext()) {
            Tuple line = (Tuple)lineItr.next();
            Tuple newl = TupleFactory.getInstance().newTuple();
            for (int i = 0; i < resultFormat.size(); ++i) {
                List<String> ls = ParseTutle.toStringList(resultFormat.get(i));
                Tuple cell = TupleFactory.getInstance().newTuple();
                for (String s : ls) {
                    Object o = line.get(pathes.indexOf(s));
                    String ss = (String)o;
                    cell.append(ss);
                }
                newl.append(cell);
            }
            ret.add(newl);
        }

        //fs.close();
        return ret;
    }

    protected static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

    protected DataBag MultiValue2Rows(Tuple line) throws IOException, ClassNotFoundException {
        DataBag bag = BagFactory.getInstance().newDistinctBag();
        List<Tuple> lstTuple = new ArrayList<Tuple>();
        for (int k = 0; k < line.size(); ++k) {
            Tuple t = (Tuple)line.get(k);
            if (t.size() > 0) {
                if (lstTuple.isEmpty()) {
                    Tuple newline = TupleFactory.getInstance().newTuple(line.size());
                    newline.set(k, t.get(0));
                    lstTuple.add(newline);
                }
                else{
                    for (Tuple lt : lstTuple) {
                        lt.set(k, t.get(0));
                    }
                }
            }
            for (int p = 1; p < t.size(); ++p) {
                int pos = lstTuple.size();
                lstTuple.addAll(deepCopy(lstTuple));
                for (int q = pos; q < lstTuple.size(); ++q) {
                    lstTuple.get(q).set(k,t.get(p));
                }
            }
        }

        for (Tuple v : lstTuple) {
            bag.add(v);
        }
        return bag;
    }

    protected DataBag ParseXML(Paramter para) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, ClassNotFoundException, XPathFactoryConfigurationException {
        DataBag bag = BagFactory.getInstance().newDistinctBag();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(para.input);
        XPathFactory factory = XPathFactory.newInstance(
                XPathFactory.DEFAULT_OBJECT_MODEL_URI,
                "net.sf.saxon.xpath.XPathFactoryImpl",
                ClassLoader.getSystemClassLoader());
        //XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        NodeList nodeList = (NodeList) xpath.evaluate(para.prefix, doc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Tuple line = TupleFactory.getInstance().newTuple();
            for (String path : para.pathes) {
                Node n = nodeList.item(i);
                String str = "";
                Tuple cell = TupleFactory.getInstance().newTuple();
                if (!path.equals(para.prefix)) {
                    NodeList o = (NodeList) xpath.evaluate(path, n, XPathConstants.NODESET);
                    for(int j =0; j < o.getLength(); ++j) {
                        str = o.item(j).getNodeValue();
                        if (str == null) str = o.item(j).getTextContent();
                        cell.append(str.trim());
                    }

                } else {
                    str = n.getTextContent();
                    cell.append(str.trim());
                }
                line.append(cell);
            }

            bag.addAll(MultiValue2Rows(line));
        }
        return bag;
    }

    protected DataBag ParseJSON(Paramter para) throws IOException, ClassNotFoundException, ParseException {
        DataBag bag = BagFactory.getInstance().newDistinctBag();
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(
                new InputStreamReader(para.input, "UTF-8"));
        //Object obj = JSON.parse(json, FixJsonpath(prefix));
        //List<Object> lstobj = new ArrayList<Object>();
        Object obj = JSONPath.eval(jsonObject, para.prefix);
        if (obj instanceof JSONArray) {
            JSONArray jarr = (JSONArray)obj;
            for (Object node : jarr) {
                Tuple line = TupleFactory.getInstance().newTuple();
                for (String path : para.pathes) {
                    String str = "";
                    Tuple cell = TupleFactory.getInstance().newTuple();
                    if (!path.equals(para.prefix)) {
                        Object o = JSONPath.eval(node, path);
                        if (o instanceof String) {
                            cell.append(o);
                        }
                        else if (o instanceof JSONArray) {
                            JSONArray arr = (JSONArray)o;
                            for (int j = 0; j < arr.size(); ++j) {
                                cell.append(arr.get(j));
                            }
                        }

                    } else {
                        str = node.toString();
                        cell.append(str);
                    }
                    line.append(cell);
                }
                bag.addAll(MultiValue2Rows(line));
            }
        }
        return bag;
    }

    protected DataBag ParseCSV(Paramter para) throws IOException {
        DataBag bag = BagFactory.getInstance().newDistinctBag();
        CsvReader csvReader = new CsvReader(para.input, Charset.defaultCharset());
        csvReader.readHeaders();
        while (csvReader.readRecord()) {
            Tuple line = TupleFactory.getInstance().newTuple();
            for (String path : para.pathes) {
                String str = csvReader.get(path);
                line.append(str);
            }
            bag.add(line);
        }
        return bag;
    }

    public static String getSPARQL(String endpoint, String query, String referenceFormulation) {
        String format = referenceFormulation.toLowerCase();
        QueryExecution q = QueryExecutionFactory.sparqlService(endpoint, query);
        org.apache.jena.query.ResultSet results = q.execSelect();
        List<String> headers = results.getResultVars();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        if (format.contains("json")) {
            ResultSetFormatter.outputAsJSON(os, results);
        }
        else if (format.contains("xpath")) {
            ResultSetFormatter.outputAsXML(os, results);
        }
        else{
            ResultSetFormatter.outputAsCSV(os, results);
        }
        return os.toString();
    }
    public static SourceType getSourceType(String str) {
        str = str.toLowerCase();
        if (str.contains("mysql")) {
            return SourceType.MySQL;
        } else if (str.contains("postgres")) {
            return SourceType.Postgresql;
        } else if (str.contains("sqlserver")) {
            return SourceType.SQLServer;
        } else{
            throw new Error("Can not find:" + str);
        }
    }
    public static String getDBDriver(SourceType type) {
        String driver = "";
        switch (type){
            case MySQL:
                driver = "com.mysql.jdbc.Driver";
                break;
            case SQLServer:
                driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                break;
            case Postgresql:
                driver = "org.postgresql.Driver";
                break;
        }
        return driver;
    }
    //"com.mysql.jdbc.Driver";
    //"jdbc:mysql://localhost:3306/RUNOOB";
    //"jdbc:sqlserver://localhost:1433;databaseName=test";
    //com.microsoft.sqlserver.jdbc.SQLServerDriver
    public static String getRDB(String jdbcDriver, String jdbcDSN, String tableName,String username, String password, String query, String referenceFormulation) {
        SourceType database = getSourceType(jdbcDriver);
        String csv="";
        if (query.isEmpty()) {
            query = "select * from " + tableName;
        }

        if (referenceFormulation.isEmpty()) {
            referenceFormulation = "ql:CSV";
        }
        Connection connection = null;
        Statement statement = null;
        jdbcDriver = getDBDriver(database);
        jdbcDSN = "jdbc:" + database.toString() + "://" + jdbcDSN;
        //records to csv format
        try {
            // Register JDBC driver
            Class.forName(jdbcDriver);

            // Open connection
            String connectionString = jdbcDSN;
            if (!connectionString.contains("user=")) {
                connectionString += "?user=" + username + "&password=" + password;
            }
            if (database == SourceType.MySQL) {
                connectionString += "&serverTimezone=UTC&useSSL=false";
            }
            if (database == SourceType.SQLServer) {
                connectionString = connectionString.replaceAll("\\?|&", ";");
                if (!connectionString.endsWith(";")) {
                    connectionString += ";";
                }
            }
            connection = DriverManager.getConnection(connectionString);

            // Execute query
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            csv = RDBtoCSV(rs);

            // Clean-up environment
            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            // finally block used to close resources
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return csv;
    }

    public static String RDBtoCSV(ResultSet rs) throws SQLException {

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        String table = "";
        String header = rsmd.getColumnName(1);
        for (int i = 2; i <= columnCount; ++i) {
            header += "," + rsmd.getColumnName(i);
        }
        table = header;
        while(rs.next()) {
           String line = rs.getString(1);
            for (int j = 2; j <= columnCount; ++j) {
                line += "," + rs.getString(j);
            }
            table += "\r\n" + line;
        }
        return table;
    }

    public static String getAPI(StdApiSource apiSource, Map<String, String> parameters) throws IOException {
        ApiProcessor apiProcessor = new ApiProcessor();
        InputStream inputStream = apiProcessor.getInputStream((LogicalSource) apiSource, parameters);
        String str = new String(ByteStreams.toByteArray(inputStream));
        return str;
    }

    public static String LoadData(DataRetrieval dataRetrieval) throws IOException {
        String all = "";
        DataRetrieval.SPARQL sparql = dataRetrieval.getSparql();
        DataRetrieval.Database db = dataRetrieval.getDatabase();
        DataRetrieval.CsvOnWeb csvOnWeb = dataRetrieval.getCsvOnWeb();
        DataRetrieval.WebAPI webAPI = dataRetrieval.getWebAPI();
        LogicalSource logicalSource = new StdLogicalSource(null, null);
        logicalSource.setQuery(dataRetrieval.getQuery());
        logicalSource.setIterator(dataRetrieval.getIterator());
        logicalSource.setTableName(dataRetrieval.getTableName());
        if (dataRetrieval.getReferenceFormulation().equalsIgnoreCase("ql:xpath")) {
            logicalSource.setReferenceFormulation(QLTerm.XPATH_CLASS);
        }
        else if (dataRetrieval.getReferenceFormulation().equalsIgnoreCase("ql:jsonpath")) {
            logicalSource.setReferenceFormulation(QLTerm.JSONPATH_CLASS);
        }
        else {
            logicalSource.setReferenceFormulation(QLTerm.CSV_CLASS);
        }

        if (sparql != null) {
            String endpoint = sparql.getEndpoint();
            if (endpoint.startsWith("http")) {
                StdSparqlEndpointSource stdSparqlEndpointSource = new StdSparqlEndpointSource("","");
                Map<String, String> parameters = new HashMap<String, String>();
                SparqlProcessor inputProcessor = new SparqlProcessor();
                logicalSource.setSource(stdSparqlEndpointSource);
                InputStream inputStream = inputProcessor.
                        getInputStream(logicalSource, parameters);
                all = new String(ByteStreams.toByteArray(inputStream));
            }
            else {
                String qs = URLDecoder.decode(dataRetrieval.getQuery(), "utf-8");
                qs = qs.replaceAll("\"\"\"", "");
                qs = qs.replaceAll("%3c", "<");
                qs = qs.replaceAll("%3e", ">");
                all = getSPARQL(endpoint, qs, dataRetrieval.getReferenceFormulation());
            }
        }
        else if (db != null) {
            all = ParseData.getRDB(db.getJdbcDriver(), db.getJdbcDSN(), dataRetrieval.getTableName(), db.getUsername(),db.getPassword(), dataRetrieval.getQuery(), dataRetrieval.getReferenceFormulation());
        }
        else if (csvOnWeb != null) {

        }
        else if (webAPI != null) {
            StdApiSource apiSource = new StdApiSource("","");
            Map<String ,String> parameters = new HashMap<String, String>();
            all = getAPI(apiSource, parameters);
        }
        else{
            LOG.info("Localfile:" + dataRetrieval.getName());
            all = dataRetrieval.getName();
        }


        return all;
    }

    /*public static InputStream getInputStream(String filepath) throws IOException {

        //IOUtils.copyBytes(inputStream, System.out, 4096, false);
        return inputStream;
    }*/
}
