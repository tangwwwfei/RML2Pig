import ch.vorburger.exec.ManagedProcessException;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;
import org.apache.pig.ExecType;
import org.apache.pig.backend.hadoop.datastorage.HDataStorage;
import org.apache.pig.backend.hadoop.datastorage.HDirectory;
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
import java.sql.SQLException;
import java.util.List;

public class PigStdTest {

    @BeforeClass
    public static void initTest() throws IOException {
        BasicConfigurator.configure();
        cleanup();
    }

    @AfterClass
    public static void cleanup() throws IOException {
        //DBUtil.stopDBs();
        List<File> files = TestUtil.listAllFiles("../test-cases/resources/passed/test-cases/", "^(158|\\.158).*");
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
        String startFrom = "RMLTC0008b";
        boolean bSkip = false;
        DBUtil dbUtil = null;
        List<File> files = TestUtil.listAllFiles("../test-cases/resources/passed/", ".*\\.pig$");
        for(File pigScriptFile : files) {
            boolean bStartDBs = false;
            String pigScript = pigScriptFile.getCanonicalPath();
            if (pigScript.contains(startFrom)) {
                bSkip = false;
            }
            if (bSkip || !pigScript.contains("SPARQL")) {
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
                List<File> sqls = TestUtil.listAllFiles(pigScriptFile.getParent(), "resource\\d?\\.ttl$");
                for (File sql : sqls) {
                    dbUtil.runScript(sql.getCanonicalPath(), dbUtil.getConnectionString());
                }
                dbUtil.startDB();
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
        String startFrom = "RMLTC1003-CSV";
        boolean bSkip = true
                ;
        List<File> files = TestUtil.listAllFiles("../test/resources/passed/", ".*\\.pig$");
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
            //load expected results
            String[] expected = TestUtil.loadResult(curDir);
            pigTest.assertOutputAnyOrder("result", expected);
            pigServer.shutdown();
            System.setProperty("user.dir", oldDir);
        }

    }
}
