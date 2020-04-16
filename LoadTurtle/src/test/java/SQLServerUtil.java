import ch.vorburger.exec.ManagedProcessException;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerException;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.AfterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;

public class SQLServerUtil extends DBUtil {

    private static final Boolean LOCAL_TESTING = !Boolean.valueOf(System.getenv("CI"));

    private static Logger logger = LoggerFactory.getLogger(SQLTest.class);

    private static String CONNECTIONSTRING = LOCAL_TESTING ?
            "jdbc:sqlserver://dia.test.iminds.be:8971;user=sa;password=YourSTRONG!Passw0rd;databaseName=TestDB;" :
            "jdbc:sqlserver://sqlserver;user=sa;password=YourSTRONG!Passw0rd;databaseName=TestDB;";

    private static HashSet<String> tempFiles = new HashSet<>();

    @Getter
    private SQLTest.DockerDBInfo remoteDB;

    private class DockerDBInfo {
        String connectionString;
        String containerID;
        DockerClient docker;

        public DockerDBInfo(DockerClient docker, String connectionString, String containerID) {
            this.docker = docker;
            this.connectionString = connectionString;
            this.containerID = containerID;
        }

        DockerDBInfo(String connectionString) {
            this.connectionString = connectionString;
        }
    }


    @Override
    public String getConnectionString() {
        return CONNECTIONSTRING;
    }

    public void startDB() {
        remoteDB = new SQLTest.DockerDBInfo(CONNECTIONSTRING);
        try {
            final Connection conn = DriverManager.getConnection(remoteDB.connectionString.substring(0, remoteDB.connectionString.lastIndexOf("databaseName=")));
            conn.createStatement().execute("CREATE DATABASE TestDB");
            conn.close();
        } catch (SQLException ex) {
            // Doesn't matter
        }
    }

    public void stopDB() {
        if (!LOCAL_TESTING) {
            closeDocker(remoteDB);
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


    private void closeDocker(SQLTest.DockerDBInfo dockerDBInfo) {
        if (dockerDBInfo != null && dockerDBInfo.docker != null) {
            try {
                // Kill container
                dockerDBInfo.docker.killContainer(dockerDBInfo.containerID);

                // Remove container
                dockerDBInfo.docker.removeContainer(dockerDBInfo.containerID);

                // Close the docker client
                dockerDBInfo.docker.close();
            } catch (DockerException | InterruptedException ex) {
                logger.warn("Could not kill the database container with connection string: " + dockerDBInfo.connectionString + "!", ex);
            }
        }
    }

    public void runScript(String file_name, String connectionString) throws IOException, SQLException {
        String sql = new String(Files.readAllBytes(Paths.get(file_name)));
        sql = sql.replaceAll("\r\n", "");
        String[] statements = sql.split(";");
        final Connection conn = DriverManager.getConnection(connectionString);
        for (String statement : statements) {
            conn.createStatement().execute(statement + ";");
        }
        conn.close();
    }

    public String readPigScriptAndReplaceDSNString(String scriptPath) throws IOException {
        FileReader fr=new FileReader(scriptPath);
        BufferedReader br=new BufferedReader(fr);
        ArrayList<String> lines = new ArrayList<>();
        String line="";
        while ((line=br.readLine())!=null) {
            line = line.replace("CONNECTIONDSN", "dia.test.iminds.be:8971;user=sa;password=YourSTRONG!Passw0rd;databaseName=TestDB;");
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
