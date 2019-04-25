package loadfunc;

import java.util.List;

public class DataRetrieval {

    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SPARQL getSparql() {
        return sparql;
    }

    public void setSparql(SPARQL sparql) {
        this.sparql = sparql;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    public WebAPI getWebAPI() {
        return webAPI;
    }

    public void setWebAPI(WebAPI webAPI) {
        this.webAPI = webAPI;
    }

    public PagedCollection getPagedCollection() {
        return pagedCollection;
    }

    public void setPagedCollection(PagedCollection pagedCollection) {
        this.pagedCollection = pagedCollection;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public CsvOnWeb getCsvOnWeb() {
        return csvOnWeb;
    }

    public void setCsvOnWeb(CsvOnWeb csvOnWeb) {
        this.csvOnWeb = csvOnWeb;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    public String getIterator() {
        return iterator;
    }

    public void setIterator(String iterator) {
        this.iterator = iterator;
    }

    public String getReferenceFormulation() {
        return referenceFormulation;
    }

    public void setReferenceFormulation(String referenceFormulation) {
        this.referenceFormulation = referenceFormulation;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getSqlVersion() {
        return sqlVersion;
    }

    public void setSqlVersion(String sqlVersion) {
        this.sqlVersion = sqlVersion;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


    public class SPARQL{
        private String endpoint;
        private String supportedLanguage;
        private String resultFormat;

        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        public String getSupportedLanguage() {
            return supportedLanguage;
        }

        public void setSupportedLanguage(String supportedLanguage) {
            this.supportedLanguage = supportedLanguage;
        }

        public String getResultFormat() {
            return resultFormat;
        }

        public void setResultFormat(String resultFormat) {
            this.resultFormat = resultFormat;
        }
    }

    class Distribution {
        private String downloadURL;

        public String getDownloadURL() {
            return downloadURL;
        }

        public void setDownloadURL(String downloadURL) {
            this.downloadURL = downloadURL;
        }
    }

    public class Dataset{
        private List<Distribution> distribution;

        public List<Distribution> getDistribution() {
            return distribution;
        }

        public void setDistribution(List<Distribution> distribution) {
            this.distribution = distribution;
        }
    }

    class HydraMapping{
        private String variable;
        private String required;
    }

    public class WebAPI{
        private String template;
        private List<HydraMapping> hydraMapping;

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public List<HydraMapping> getHydraMapping() {
            return hydraMapping;
        }

        public void setHydraMapping(List<HydraMapping> hydraMapping) {
            this.hydraMapping = hydraMapping;
        }
    }

    public class PagedCollection{
        private String itemsPerPage;
        private String firstPage;
        private String nextPage;

        public String getItemsPerPage() {
            return itemsPerPage;
        }

        public void setItemsPerPage(String itemsPerPage) {
            this.itemsPerPage = itemsPerPage;
        }

        public String getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(String firstPage) {
            this.firstPage = firstPage;
        }

        public String getNextPage() {
            return nextPage;
        }

        public void setNextPage(String nextPage) {
            this.nextPage = nextPage;
        }
    }

    public class Database{
        private String jdbcDSN;
        private String jdbcDriver;
        private String username;
        private String password;

        public String getJdbcDSN() {
            return jdbcDSN;
        }

        public void setJdbcDSN(String jdbcDSN) {
            this.jdbcDSN = jdbcDSN;
        }

        public String getJdbcDriver() {
            return jdbcDriver;
        }

        public void setJdbcDriver(String jdbcDriver) {
            this.jdbcDriver = jdbcDriver;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public class Dialect{
        private String delimiter;
        private String encoding;
        private String header;
        private String headerRowCount;
        private String trim;

        public String getDelimiter() {
            return delimiter;
        }

        public void setDelimiter(String delimiter) {
            this.delimiter = delimiter;
        }

        public String getEncoding() {
            return encoding;
        }

        public void setEncoding(String encoding) {
            this.encoding = encoding;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getHeaderRowCount() {
            return headerRowCount;
        }

        public void setHeaderRowCount(String headerRowCount) {
            this.headerRowCount = headerRowCount;
        }

        public String getTrim() {
            return trim;
        }

        public void setTrim(String trim) {
            this.trim = trim;
        }
    }

    public class CsvOnWeb{
        private String url;
        private Dialect dialect;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Dialect getDialect() {
            return dialect;
        }

        public void setDialect(Dialect dialect) {
            this.dialect = dialect;
        }
    }

    public class Function{
        private String name;
        private String label;
        private String description;
        private String expects;
        private String returns;
        private String providedBy;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getExpects() {
            return expects;
        }

        public void setExpects(String expects) {
            this.expects = expects;
        }

        public String getReturns() {
            return returns;
        }

        public void setReturns(String returns) {
            this.returns = returns;
        }

        public String getProvidedBy() {
            return providedBy;
        }

        public void setProvidedBy(String providedBy) {
            this.providedBy = providedBy;
        }
    }

    public class Parameter{
        private String name;
        private String label;
        private String type;
        private String predicate;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPredicate() {
            return predicate;
        }

        public void setPredicate(String predicate) {
            this.predicate = predicate;
        }
    }
}


