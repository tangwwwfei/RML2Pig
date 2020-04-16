import ch.vorburger.exec.ManagedProcessException;
import lombok.Getter;

import java.io.IOException;
import java.sql.SQLException;

public abstract class DBUtil {
    private static String CONNECTIONSTRING;
    public abstract String getConnectionString();
    public abstract void startDB() throws ManagedProcessException, IOException;
    public abstract void stopDB() throws ManagedProcessException;
    public abstract void runScript(String path, String connectionString) throws IOException, SQLException, ManagedProcessException;
    public abstract String readPigScriptAndReplaceDSNString(String scriptPath) throws IOException;
}
