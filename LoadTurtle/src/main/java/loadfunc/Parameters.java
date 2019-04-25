package loadfunc;

public class Parameters {
    private String iterator;
    private String referenceFormulation;
    private String query;
    private String sqlVersion;
    private String tableName;

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
}
