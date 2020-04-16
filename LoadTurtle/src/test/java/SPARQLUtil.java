import ch.vorburger.exec.ManagedProcessException;


import org.apache.commons.lang3.StringUtils;
import org.apache.jena.fuseki.main.FusekiServer;
import org.apache.jena.query.*;
import org.apache.jena.rdfconnection.RDFConnectionFuseki;
import org.apache.jena.rdfconnection.RDFConnectionRemoteBuilder;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.sparql.core.DatasetGraph;
import org.apache.jena.sparql.core.DatasetGraphFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SPARQLUtil extends DBUtil {

    FusekiServer server;
    FusekiServer.Builder builder;
    DatasetGraph dsg;

    static int i = 0;

    public SPARQLUtil() throws IOException {
        i = 0;
        builder = FusekiServer.create();
    }

    @Override
    public String getConnectionString() {
        return null;
    }

    @Override
    public void startDB() throws IOException {
        try {
            server = builder.build();
            server.start();
            assertTrue(server.getDataAccessPointRegistry().isRegistered("/ds1"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            //socket.close();

        }
    }

    @Override
    public void stopDB() throws ManagedProcessException {
        if (server != null){
            server.stop();
        }
    }

    @Override
    public void runScript(String path, String connectionString) throws IOException, SQLException, ManagedProcessException {
        Dataset ds = RDFDataMgr.loadDataset(path);
        builder.add("/ds"+(i+1), ds, true);
        ++i;
    }

    @Override
    public String readPigScriptAndReplaceDSNString(String scriptPath) throws IOException {
        FileReader fr=new FileReader(scriptPath);
        BufferedReader br=new BufferedReader(fr);
        ArrayList<String> lines = new ArrayList<>();
        String line="";
        while ((line=br.readLine())!=null) {
            line = line.replace("PORT", String.valueOf(server.getPort()));
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
