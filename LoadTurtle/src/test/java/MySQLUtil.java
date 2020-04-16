import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.BasicConfigurator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;

public class MySQLUtil extends DBUtil {
    private static DB mysqlDB;
    private static String CONNECTIONSTRING = "jdbc:mysql://localhost:%d/test";
    private static HashSet<String> tempFiles = new HashSet<String>();

    @Override
    public String getConnectionString() {
        return CONNECTIONSTRING;
    }

    public void startDB() throws ManagedProcessException {
        BasicConfigurator.configure();
        int PORTNUMBER_MYSQL;
        try {
            PORTNUMBER_MYSQL = 3306;//getFreePortNumber();
        } catch (Exception ex) {
            throw new Error("Could not find a free port number for RDBs testing.");
        }

        CONNECTIONSTRING = String.format(CONNECTIONSTRING, PORTNUMBER_MYSQL);

        DBConfigurationBuilder configBuilder = DBConfigurationBuilder.newBuilder();
        configBuilder.setPort(PORTNUMBER_MYSQL);
        configBuilder.addArg("--user=root");
        mysqlDB = DB.newEmbeddedDB(configBuilder.build());
        mysqlDB.start();
    }

    public void stopDB() throws ManagedProcessException {
        if (mysqlDB != null) {
            mysqlDB.stop();
        }

        // Make sure all tempFiles are removed
        int counter = 0;
        while (!tempFiles.isEmpty()) {
            for (Iterator<String> i = tempFiles.iterator(); i.hasNext(); ) {
                try {
                    if (new File(i.next()).delete()) {
                        i.remove();
                    }
                } catch (Exception ex) {
                    counter++;
                    ex.printStackTrace();
                    // Prevent infinity loops
                    if (counter > 100) {
                        throw new Error("Could not remove all temp mapping files.");
                    }
                }
            }
        }
    }

    @Override
    public void runScript(String path, String connectionString) throws IOException, ManagedProcessException, SQLException {
        String sql = new String(Files.readAllBytes(Paths.get(path)));
        sql = sql.replaceAll("\r\n", "");
        String[] statements = sql.split(";");
        //final Connection conn = DriverManager.getConnection(connectionString);
        for (String statement : statements) {
            //conn.createStatement().execute(statement);
            mysqlDB.run(statement, "root", "", "test");
        }
    }

    @Override
    public String readPigScriptAndReplaceDSNString(String scriptPath) throws IOException {
        FileReader fr=new FileReader(scriptPath);
        BufferedReader br=new BufferedReader(fr);
        ArrayList<String> lines = new ArrayList<>();
        String line="";
        while ((line=br.readLine())!=null) {
            line = line.replace("CONNECTIONDSN", "localhost:3306/test");
            lines.add(line);
        }
        br.close();
        fr.close();
        File f = File.createTempFile("pig"+Long.toString(Calendar.getInstance().getTimeInMillis()), ".pig");
        Files.write(Paths.get(f.getCanonicalPath()), StringUtils.join(lines.toArray(new String[0]), "\n").getBytes());
        f.deleteOnExit();
        return f.getCanonicalPath();
    }
}
