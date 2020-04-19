import ch.vorburger.exec.ManagedProcessException;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.fs.Path;
import org.apache.jena.fuseki.main.FusekiServer;
import org.apache.jena.query.*;
import org.apache.jena.rdfconnection.RDFConnectionFuseki;
import org.apache.jena.rdfconnection.RDFConnectionRemoteBuilder;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.sparql.core.DatasetGraph;
import org.apache.jena.sparql.core.DatasetGraphFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.pig.ExecType;
import org.apache.pig.backend.hadoop.datastorage.HDataStorage;
import org.apache.pig.backend.hadoop.datastorage.HDirectory;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.apache.pig.impl.PigContext;
import org.apache.pig.pigunit.Cluster;
import org.apache.pig.pigunit.PigTest;
import org.apache.pig.pigunit.pig.PigServer;
import org.apache.pig.tools.parameters.ParseException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PigStdTest {

    @BeforeClass
    public static void initTest() throws IOException {
        BasicConfigurator.configure();
        cleanup();
    }

    @AfterClass
    public static void cleanup() throws IOException {
        //DBUtil.stopDBs();
        List<File> files = TestUtil.listAllFiles("../test/resources/passed/test-cases/", "^(158|\\.158).*");
        for(File file : files) {
            System.out.println("Delete file：" + file.getCanonicalPath());
            FileUtils.deleteQuietly(new File(file.getCanonicalPath()));
        }
    }

    static void setCurrentDir(PigContext pigContext, String path) {
        HDataStorage dfs = (HDataStorage) pigContext.getDfs();
        dfs.getHFS().setWorkingDirectory(new Path(path));
        HDirectory desc = (HDirectory) dfs.getActiveContainer();
        return;
    }

    @Test
    public void test_sqlserver() throws IOException, SQLException, ManagedProcessException, ParseException {
        String startFrom = "RMLTC0015a-MySQL";
        boolean bSkip = true;
        DBUtil dbUtil = null;
        List<File> files = TestUtil.listAllFiles("../test/resources/passed/test-cases", ".*\\.pig$");
        for(File pigScriptFile : files) {
            boolean bStartDBs = false;
            String pigScript = pigScriptFile.getCanonicalPath();
            if (pigScript.contains(startFrom)) {
                bSkip = false;
            }
            if (bSkip || pigScript.contains("XML") || pigScript.contains("CSV") || pigScript.contains("JSON") || pigScript.contains("SPARQL")) {
                continue;
            }
            System.out.println("runScript:" + pigScript);
            if (pigScript.contains("SQLServer")) {
                //run sql script
                dbUtil = new SQLServerUtil();
                bStartDBs = true;
            }
            else if (pigScript.contains("MySQL")){
                dbUtil =new MySQLUtil();
                bStartDBs = true;
            }
            else if (pigScript.contains("PostgreSQL")) {
                dbUtil =new PostgreSQLUtil();
                bStartDBs = true;
            }
            else if (pigScript.contains("SPARQL")) {
                dbUtil = new SPARQLUtil();
                bStartDBs = true;
            }

            if (bStartDBs) {
                dbUtil.startDB();
                List<File> sqls = TestUtil.listAllFiles(pigScriptFile.getParent(), "resource(\\d?\\.(ttl|sql)$)");
                for (File sql : sqls) {
                    dbUtil.runScript(sql.getCanonicalPath(), dbUtil.getConnectionString());
                }
                pigScript = dbUtil.readPigScriptAndReplaceDSNString(pigScript);
            }

            //Set current directory
            String curDir = pigScriptFile.getParentFile().getCanonicalPath();
            String oldDir = System.setProperty("user.dir", curDir);

            Cluster cluster = PigTest.getCluster();
            PigServer pigServer = new PigServer(ExecType.LOCAL);
            if (PigTest.getPigServer() != null) {
                setCurrentDir(PigTest.getPigServer().getPigContext(), curDir);
            }
            //run pig script
            PigTest pigTest = new PigTest(pigScript, null, pigServer, cluster);

            //PigTest.getPigServer().getPigContext().set
            //load expected results
            String[] expected = TestUtil.loadResult(curDir);
            //pigTest.runScript();
            pigTest.assertOutputAnyOrder("result", expected);
            pigServer.shutdown();
            System.setProperty("user.dir", oldDir);
            if (bStartDBs) {
                dbUtil.stopDB();
            }
        }
    }

    @org.junit.Test
    public void test_cases() throws Exception {
        String startFrom = "RMLTC1009";
        boolean bSkip = false;
        List<File> files = TestUtil.listAllFiles("../test/resources/passed/test-cases", ".*\\.pig$");
        for(File pigScriptFile : files) {
            String pigScript = pigScriptFile.getCanonicalPath();
            if (pigScript.contains(startFrom)) {
                bSkip = false;
            }
            if (bSkip || pigScript.contains("SQL") || pigScript.contains("SPARQL")) {

                continue;
            }

            System.out.println("runScript:" + pigScript);
            //Set current directory
            String curDir = pigScriptFile.getParentFile().getCanonicalPath();
            String oldDir = System.setProperty("user.dir", curDir);

            Cluster cluster = PigTest.getCluster();
            PigServer pigServer = new PigServer(ExecType.LOCAL);
            if (PigTest.getPigServer() != null) {
                setCurrentDir(PigTest.getPigServer().getPigContext(), curDir);
            }
            //run pig script
            PigTest pigTest = new PigTest(pigScript, null, pigServer, cluster);
            //PigTest.getPigServer().getPigContext().set
            //load expected results
            String[] expected = TestUtil.loadResult(curDir);
            //pigTest.runScript();
            pigTest.assertOutputAnyOrder("result", expected);
            pigServer.shutdown();
            System.setProperty("user.dir", oldDir);
        }

    }
}
