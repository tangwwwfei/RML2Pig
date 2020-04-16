//import com.github.jsonldjava.core.RDFDataset;
import lombok.Data;
//import org.apache.jena.fuseki.servlets.REST_Quads;
//import org.apache.jena.graph.Graph;
//import org.apache.jena.graph.GraphUtil;
//import org.apache.jena.graph.Node;
//import org.apache.jena.graph.Triple;
//import org.apache.jena.query.Dataset;
//import org.apache.jena.rdf.model.*;
//import org.apache.jena.riot.Lang;
//import org.apache.jena.riot.RDFDataMgr;
//import org.apache.jena.sparql.core.DatasetGraph;
//import org.apache.jena.sparql.sse.writers.WriterNode;
import org.apache.commons.lang.LocaleUtils;
import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.datatypes.TypeMapper;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.ext.xerces.impl.dv.XSSimpleType;
import org.apache.jena.ext.xerces.impl.dv.xs.XSSimpleTypeDecl;
import org.apache.jena.graph.*;
import org.apache.jena.graph.Graph;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.system.FactoryRDFCaching;
import org.apache.jena.riot.system.FactoryRDFStd;
import org.apache.jena.riot.system.ParserProfileStd;
import org.apache.jena.sparql.core.DatasetGraph;
import org.apache.jena.sparql.util.Context;
import org.apache.jena.sparql.util.LabelToNodeMap;
import org.apache.jena.sparql.util.Symbol;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import org.eclipse.rdf4j.model.*;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.rio.*;
import org.eclipse.rdf4j.rio.helpers.BasicParserSettings;
import org.eclipse.rdf4j.rio.helpers.StatementCollector;
import sun.util.locale.LanguageTag;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.jena.tdb.TDBFactory.createDatasetGraph;

public class TestUtil {

    static @Data
    class SPO {
        private String subject = "";
        private String predicate = "";
        private String object = "";
        private String graph = "";

        private  Resource rs;
        private  IRI rp;
        private  Value ro;
        private  Resource rg;

        private  Node s;
        private  Node p;
        private  Node o;
        private  Node g;


        public SPO(Node s, Node p, Node o, Node g) {
            this.s = s;
            this.p = p;
            this.o = o;
            this.g = g;

            if (s.isURI()) {
                subject = "<" + s.toString() + ">";
            }
            else{
                subject = s.toString();
            }
            if (p.isURI()) {
                predicate = "<" + p.toString() + ">";
            }
            else{
                predicate = p.toString();
            }

            if (o.isURI()) {
                object = "<" + o.toString() + ">";
            }
            else{
                object = o.toString();
            }

            if (g != null && g.isURI()) {
                graph = "<" + g.toString() + ">";
            }
        }

        public SPO(Resource s, IRI p, Value o, Resource g) {
            this.rs = s;
            this.rp = p;
            this.ro = o;
            this.rg = g;

            subject = s.toString();
            predicate = p.toString();
            object = o.toString();
            if (g != null) {
                graph = g.toString();
            }
        }

        public SPO(String[] spog) {
            if (spog.length == 2) {
                //S O
                //@base
                subject = spog[0];
                object = spog[1];
            } else if (spog.length == 3) {
                //S P O
                subject = spog[0];
                predicate = spog[1];
                object = spog[2];
            } else if (spog.length == 4) {
                //S P O G
                subject = spog[0];
                predicate = spog[1];
                object = spog[2];
                graph = spog[3];
            } else {
                assert (false);
            }
        }

        @Override
        public String toString() {
            String ret = "(" + subject + "," + predicate + "," + object;
            if (!graph.isEmpty()) {
                ret += "," + graph;
            }
            ret += ")";
            return ret;
        }
    }

    public static List<File> listAllFiles(String path, String regex) throws IOException {
        List<File> files = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        java.nio.file.Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String str = file.getFileName().toString();
                Matcher matcher = pattern.matcher(str);
                if (matcher.matches()) {
                    files.add(file.toFile());
                }
                return super.visitFile(file, attrs);
            }
        });
        return files;
    }

    private static Node createNode(String str) {
        Node n = null;
        if (str.startsWith("_:")) {
            n = NodeFactory.createBlankNode(str);
        }
        else if (str.startsWith("\"")) {
            if (str.contains("@")) {
                String[] lexlan = str.split("@");
                n = NodeFactory.createLiteral(lexlan[0].substring(1, lexlan[0].length()-1),lexlan[1]);
            }
            else if (str.contains("^^")) {
                String[] strdt = str.split("\\^\\^");
                RDFDatatype rdfDatatype = TypeMapper.getInstance().getTypeByName(strdt[1].substring(1, strdt[1].length()-1));
                n =NodeFactory.createLiteral(strdt[0].substring(1, strdt[0].length()-1), rdfDatatype);
            }
            else{
                n = NodeFactory.createLiteral(str.substring(1, str.length()-1));
            }
        }
        else{
            n = NodeFactory.createURI(str);
        }
        return n;
    }

    public static void addTriples(ArrayList<String> lines, TreeModel model, ArrayList<SPO> namespaces, String dir) {
        Iterator<Statement> itr = model.iterator();
        for ( ; itr.hasNext() ; )
        {
            Statement st = itr.next();
            String ss = st.getSubject().toString();
            String sp = st.getPredicate().toString();
            String so = st.getObject().toString();

            Node s = createNode(st.getSubject().toString());
            Node p = createNode(st.getPredicate().toString());
            Node o = createNode(st.getObject().toString());
            Resource cxt = st.getContext();
            Node g = null;
            if (cxt != null) {
                g = createNode(st.getContext().toString());
            }
            SPO line = new SPO(s, p, o, g);
            lines.add(Turtle2PigFormat(line, namespaces, dir));
        }
    }

    public static void addTriples(ArrayList<String> lines, Graph graph, Node g,ArrayList<SPO> namespaces, String dir) {
        Iterator<Triple> itr = GraphUtil.findAll(graph);
        for ( ; itr.hasNext() ; )
        {
            Triple st = itr.next();
            Node s = st.getSubject();
            Node p = st.getPredicate();
            Node o = st.getObject();
            SPO line = new SPO(s, p, o, g);
            lines.add(Turtle2PigFormat(line, namespaces, dir));
        }
    }

    public static String[] loadResult(String curDir) {
        ArrayList<String> lines = new ArrayList<>();
        String path = curDir;
        try {
            path = curDir + "\\output.nq";
            File file = new File(path);
            if (!file.exists()) {
                path = curDir + "\\output.ttl";
                file = new File(path);
            }
            ArrayList<SPO> namespaces = loadPrefix(file.getParentFile().getCanonicalPath() + "\\mapping.ttl");
            SPO rdf = new SPO(new String[]{"@prefix", "rdf:", RDF.getURI()});
            SPO rdfs = new SPO(new String[]{"@prefix", "rdfs:", RDFS.getURI()});
            SPO foaf = new SPO(new String[]{"@prefix", "foaf:", FOAF.getURI()});
            namespaces.add(rdf);
            namespaces.add(rdfs);
            namespaces.add(foaf);

            RDFParser parser = Rio.createParser(RDFFormat.NQUADS);
            Model rdf4jModel = new TreeModel();
            parser.set(BasicParserSettings.PRESERVE_BNODE_IDS, true);
            parser.setRDFHandler(new StatementCollector(rdf4jModel));
            parser.parse(new FileInputStream(path), "");

            addTriples(lines, (TreeModel) rdf4jModel, namespaces, file.getParent());

            namespaces.remove(rdf);
            namespaces.remove(rdfs);
            namespaces.remove(foaf);
            if (!lines.isEmpty()) {
                for (SPO spo : namespaces) {
                    spo.object = "<" + spo.object + ">";
                    lines.add(spo.toString());
                }
            }
        } catch (IOException e) {
            System.err.println("Skip:" + path);
        }
        return lines.toArray(new String[0]);
    }

    public static ArrayList<SPO> loadPrefix(String path) throws IOException {
        ArrayList<SPO> lines = new ArrayList<>();
        File file = new File(path);
        InputStreamReader read = new InputStreamReader(
                new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(read);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.isEmpty() && (line.startsWith("@prefix") || line.startsWith("@base"))) {
                line = line.trim().substring(0, line.length() - 1);
                SPO spo = new SPO(line.split("[\\t ]+"));
                spo.object = spo.object.substring(1, spo.object.length() - 1);
                lines.add(spo);
            }
        }
        bufferedReader.close();
        read.close();
        return lines;
    }

    private static boolean SkipSubjectException(String except) {
        boolean ret = false;
        String[] arr = {"RMLTC0006a"};
        for(String s : arr) {
            if (except.contains(s)) {
                return true;
            }
        }
        return false;
    }

    private static boolean NotSkipGraph(String except) {
        boolean ret = false;
        String[] arr = {"RMLTC0006a", "RMLTC0008a"};
        for(String s : arr) {
            if (except.contains(s)) {
                return false;
            }
        }
        return true;
    }

    private static String Turtle2PigFormat(SPO spo, ArrayList<SPO> namespaces, String except) {
        if (SkipSubjectException(except)) {
            spo.subject = longForm2ShortForm(spo.subject, spo.s.getNameSpace(), spo.s.getLocalName(), namespaces);
        }

        spo.predicate = longForm2ShortForm(spo.predicate, spo.p.getNameSpace(),  spo.p.getLocalName(), namespaces);
        if (spo.o.isURI()) {
            if (except.contains("RMLTC0008b") && spo.object.contains("Tennis")) {
                //Do nothing
            }
            else {
                spo.object = longForm2ShortForm(spo.object, spo.o.getNameSpace(), spo.o.getLocalName(), namespaces);
            }
        }
        else{
            spo.object = spo.o.toString();
            if (spo.object.contains("^^")) {
                spo.object = "\"" + spo.o.getLiteralLexicalForm() + "\"";
                XSSimpleTypeDecl type = (XSSimpleTypeDecl) spo.o.getLiteralDatatype().extendedTypeDefinition();
                spo.object += "^^xsd:" + type.getTypeName();
            }
        }

        if (NotSkipGraph(except)) {
            if (spo.g != null && spo.g.isURI()) {
                spo.graph = longForm2ShortForm(spo.graph, spo.g.getNameSpace(), spo.g.getLocalName(), namespaces);
            }
        }

        return spo.toString();
    }

    public static String longForm2ShortForm(String ori, String ns, String localName, ArrayList<SPO> namespaces) {
        String ret = ori;
        if (ns.equalsIgnoreCase("http://example.com/base/")) {
            return ret;

        }
        for (SPO prefix : namespaces) {
            if (ns.equalsIgnoreCase(prefix.object)) {
                ret = prefix.predicate + localName;
                //ret = ret.replaceAll("[<>]", "");
                break;
            }
        }
        return ret;
    }
}
