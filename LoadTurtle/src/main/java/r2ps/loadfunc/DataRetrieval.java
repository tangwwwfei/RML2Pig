package r2ps.loadfunc;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.io.IOUtils;
import org.apache.jena.query.*;
import r2ps.parser.ParseData;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static r2ps.parser.ParseTutle.R2PEncode;

public @Data class DataRetrieval {

    private String name;
    private String path;
    private String iterator;
    private String referenceFormulation;
    private String query;
    private String sqlVersion;
    private String tableName;

    private SPARQL sparql;
    private Dataset dataset;
    private WebAPI webAPI;
    private PagedCollection pagedCollection;
    private Database database;
    private CsvOnWeb csvOnWeb;
    private Function function;
    private Parameter parameter;
    private Distribution distribution;

    private String outPath;
    private JSONArray jsonArray;

    public @Data
    static class SPARQL{

        private String endpoint;
        private String supportedLanguage;
        private String resultFormat;
    }

    public @Data
    static class Distribution {
        private String downloadURL;
    }

    public @Data
    static class Dataset{
        private List<Distribution> distribution;
    }

    public @Data
    static class HydraMapping{
        private String variable;
        private String required;
    }

    public static @Data class WebAPI{
        private String template;
        private List<HydraMapping> hydraMapping;
    }

    static @Data class PagedCollection{
        private String itemsPerPage;
        private String firstPage;
        private String nextPage;
    }

    public static @Data class Database{
        private String jdbcDSN;
        private String jdbcDriver;
        private String username;
        private String password;
    }

    static @Data class Dialect{
        private String delimiter;
        private String encoding;
        private String header;
        private String headerRowCount;
        private String trim;
    }

    public static @Data class CsvOnWeb{
        private String url;
        private Dialect dialect;
    }

    static @Data class Function{
        private String name;
        private String label;
        private String description;
        private String expects;
        private String returns;
        private String providedBy;
    }

    static @Data class Parameter{
        private String name;
        private String label;
        private String type;
        private String predicate;
    }

    public InputStream ReadFromDCAT(ParseData.Param param) throws IOException {
        if (dataset == null) {
            return null;
        }
        String urlStr = dataset.distribution.get(0).getDownloadURL();
        return ReadFromURL(urlStr);
    }

    public boolean ReadFromD2RQ(ParseData.Param param) throws IOException {
        boolean ret = getRDB(param);
        return ret;
    }

    public InputStream ReadFromSPARQL_SD(ParseData.Param param) throws IOException {
        String sp = getSPARQL(param);
        return IOUtils.toInputStream(sp, StandardCharsets.UTF_8.name());
    }

    public InputStream ReadFromCSVW(ParseData.Param param) throws IOException {
        return ReadFromURL(csvOnWeb.url);
    }

    public InputStream ReadFromWebAPI(ParseData.Param param) {
        //TODO: implement
        return null;
    }

    public InputStream ReadFromURL(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3 * 1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        return conn.getInputStream();
    }

    public String getSPARQL(ParseData.Param param) {
        ParseData.SourceType type = param.sourceType;
        QueryExecution q = QueryExecutionFactory.sparqlService(sparql.endpoint, query);
        org.apache.jena.query.ResultSet results = q.execSelect();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        if (type == ParseData.SourceType.JSON) {
            ResultSetFormatter.outputAsJSON(os, results);
        } else if (type == ParseData.SourceType.XML) {
            ResultSetFormatter.outputAsXML(os, results);
        } else {
            ResultSetFormatter.outputAsCSV(os, results);
        }
        return os.toString();
    }


    public static ParseData.SourceType getSourceType(String str) {
        str = str.toLowerCase();
        if (str.contains("mysql")) {
            return ParseData.SourceType.MySQL;
        } else if (str.contains("postgres")) {
            return ParseData.SourceType.Postgresql;
        } else if (str.contains("sqlserver")) {
            return ParseData.SourceType.SQLServer;
        } else {
            throw new Error("Can not find:" + str);
        }
    }

    public static String getDBDriver(ParseData.SourceType type) {
        String driver = "";
        switch (type) {
            case MySQL:
                driver = "com.mysql.cj.jdbc.Driver";
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
    public boolean getRDB(ParseData.Param param) {
        boolean ret = false;
        String jdbcDriver = database.getJdbcDriver();
        String jdbcDSN = database.getJdbcDSN();
        String username = database.getUsername();
        String password = database.getPassword();
        ParseData.SourceType database = getSourceType(jdbcDriver);
        String csv = "";
        if (query.isEmpty()) {
            query = "select * from " + tableName;
        }

        if (referenceFormulation.isEmpty()) {
            referenceFormulation = "ql:CSV";
        }
        Connection connection = null;
        Statement statement = null;
        jdbcDriver = getDBDriver(database);
        jdbcDSN = "jdbc:" + database.toString().toLowerCase() + "://" + jdbcDSN;
        //records to csv format
        try {
            // Register JDBC driver
            Class.forName(jdbcDriver);
            // Open connection
            String connectionString = jdbcDSN;
            if (!connectionString.contains("user=")) {
                connectionString += "?user=" + username + "&password=" + password;
            }
            if (database == ParseData.SourceType.MySQL) {
                connectionString += "&serverTimezone=UTC&useSSL=false";
            }
            if (database == ParseData.SourceType.SQLServer) {
                connectionString = connectionString.replaceAll("[?&]", ";");
                if (!connectionString.endsWith(";")) {
                    connectionString += ";";
                }
            }
            //jdbc:postgresql://dia.test.iminds.be:8970/postgres?user=postgres&password=YourSTRONG!Passw0rd
            connection = DriverManager.getConnection(connectionString);

            // Execute query
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            RDBtoCSV(param, rs);

            // Clean-up environment
            rs.close();
            statement.close();
            connection.close();
            ret = true;
        } catch (Exception sqlE) {
            ret = true;
            sqlE.printStackTrace();
        } finally {

            // finally block used to close resources
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ignored) {
            }// nothing we can do

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return ret;
    }

    @Getter
    public enum RMLType{
        HEXBINARY("hexBinary"),
        DECIMAL("decimal"),
        INTEGER("integer"),
        DOUBLE("double"),
        BOOLEAN("boolean"),
        DATE("date"),
        TIME("time"),
        DATETIME("dateTime"),
        LITERAL("literal");

        private final String type;
        RMLType(String type) {
            this.type = type;
        }
    }

    public String SQLTypes2String(int sqlType) {
        switch (sqlType){
            case Types.BINARY:
            case Types.LONGVARBINARY:
            case Types.VARBINARY:
                return RMLType.HEXBINARY.type;
            case Types.DECIMAL:
            case Types.NUMERIC:
                return RMLType.DECIMAL.type;
            case Types.INTEGER:
            case Types.BIGINT:
            case Types.SMALLINT:
            case Types.TINYINT:
                return RMLType.INTEGER.type;
            case Types.DOUBLE:
            case Types.FLOAT:
            case Types.REAL:
                return RMLType.DOUBLE.type;
            case Types.BOOLEAN:
            case Types.BIT:
                return RMLType.BOOLEAN.type;
            case Types.DATE:
                return RMLType.DATE.type;
            case Types.TIME:
            case Types.TIME_WITH_TIMEZONE:
                return RMLType.TIME.type;
            case Types.TIMESTAMP:
            case Types.TIMESTAMP_WITH_TIMEZONE:
                return RMLType.DATETIME.type;
            default:
                return RMLType.LITERAL.type;
        }
    }

    public void RDBtoCSV(ParseData.Param param, ResultSet rs) throws SQLException, IOException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        HashMap<String, Integer> existPath = new HashMap<>();
        for (int i = 1; i <= columnCount; ++i) {
            String columnName = rsmd.getColumnName(i).toLowerCase();
            existPath.put(columnName, i);
            //param.header.set(i-1, SQLTypes2String(rsmd.getColumnType(i)));
        }

        List<Integer> colIndex = new ArrayList<>();
        for(int j = 0; j < param.paths.length; ++j) {
            String path = param.paths[j].toLowerCase();
            Integer iCol = existPath.get(path);
            if (iCol != null) {
                colIndex.add(iCol);
                param.header.set(j, SQLTypes2String(rsmd.getColumnType(iCol)));
            }
            else{
                colIndex.add(-1);
            }
        }
        ParseData.WriteHeader(param);
        ArrayList<String> line = new ArrayList<>();
        while (rs.next()) {
            for (int idx : colIndex) {
                String s;
                if (idx < 1) {
                    s = "";
                }
                else {
                    s = rs.getString(idx);
                    if (s == null) {
                        s = "";
                    }
                    s = R2PEncode(s);
                }
                line.add(s);
            }
            param.output.write(MessageFormat.format(param.resultFormat, line.toArray()).getBytes());
            line.clear();
        }
    }
}


