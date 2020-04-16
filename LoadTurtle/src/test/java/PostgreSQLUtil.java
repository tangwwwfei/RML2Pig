import ch.vorburger.exec.ManagedProcessException;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class PostgreSQLUtil extends DBUtil{
    private static Logger logger = LoggerFactory.getLogger(PostgreSQLUtil.class);
    private static final Boolean LOCAL_TESTING = !Boolean.valueOf(System.getenv("CI"));
    private static String CONNECTIONSTRING = LOCAL_TESTING ?
            "jdbc:postgresql://dia.test.iminds.be:8970/postgres?user=postgres&password=YourSTRONG!Passw0rd" :
            "jdbc:postgresql://postgres/postgres?user=postgres&password=YourSTRONG!Passw0rd";
    private static HashSet<String> tempFiles = new HashSet<String>();

    private static PostgreSQLUtil.DockerDBInfo remoteDB;

    private static class DockerDBInfo {
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

    @Override
    public void startDB() throws ManagedProcessException {
        remoteDB = new PostgreSQLUtil.DockerDBInfo(CONNECTIONSTRING);
    }

    @Override
    public void stopDB() throws ManagedProcessException {
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

    private void closeDocker(PostgreSQLUtil.DockerDBInfo dockerDBInfo) {
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

    @Override
    public void runScript(String path, String connectionString) throws IOException, SQLException, ManagedProcessException {
        String sql = new String(Files.readAllBytes(Paths.get(path)));
        sql = sql.replaceAll("\r\n", "");
        String[] statements = sql.split(";");
        final Connection conn = DriverManager.getConnection(connectionString);
        for (String statement : statements) {
            conn.createStatement().execute(statement);
        }
    }

    @Override
    public String readPigScriptAndReplaceDSNString(String scriptPath) throws IOException {
        FileReader fr=new FileReader(scriptPath);
        BufferedReader br=new BufferedReader(fr);
        ArrayList<String> lines = new ArrayList<>();
        String line="";
        while ((line=br.readLine())!=null) {
            line = line.replace("CONNECTIONDSN", "dia.test.iminds.be:8970/postgres?user=postgres&password=YourSTRONG!Passw0rd");
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
