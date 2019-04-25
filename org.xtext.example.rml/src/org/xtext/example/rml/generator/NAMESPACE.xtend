package org.xtext.example.rml.generator

class NAMESPACE {
	public static final String RML = "rml:";
	public static final String R2RML = "rr:";
    public static final String RR = "rr:";
    public static final String RDF = "rdf:";
    public static final String RDFS = "rdfs:";
    public static final String EX = "ex:";
    public static final String FNML = "fnml:";
    public static final String QL = "ql:";
    public static final String D2RQ = "d2rq:";
    public static final String SD = "sd:";
    public static final String FNO = "fno:";
    public static final String PROV = "prov:";
    public static final String VOID = "void:";
    public static final String XSD = "xsd:";
    public static final String DCTerm = "dcterm:";
    public static final String DCTERMS = "dcterms:";
    public static final String CRML = "crml:";
    public static final String DCAT = "dcat:";
    public static final String HYDRA = "hydra:";
    public static final String CSVW = "csvw:";
    public static final String CO = "co:";
    
    //R2RML
    //R2RML classes
    public static final String RR_GRAPH_MAP_CLASS = RR + "GraphMap";
    public static final String RR_JOIN_CLASS = RR + "Join";
    public static final String RR_LOGICAL_TABLE_CLASS = RR + "LogicalTable";
    public static final String RR_OBJECT_MAP_CLASS = RR + "ObjectMap";
    public static final String RR_PREDICATE_MAP_CLASS = RR + "PredicateMap";
    public static final String RR_PREDICATE_OBJECT_MAP_CLASS = RR + "PredicateObjectMap";
    public static final String RR_REF_OBJECT_MAP_CLASS = RR + "RefObjectMap";
    public static final String RR_SUBJECT_MAP_CLASS = RR + "SubjectMap";
    public static final String RR_TRIPLES_MAP_CLASS = RR + "TriplesMap";
    //R2RML properties
    public static final String RR_CLASS = RR + "class";
    public static final String RR_CHILD = RR + "child";
    public static final String RR_COLUMN = RR + "column";
    public static final String RR_DATATYPE = RR + "datatype";
    public static final String RR_CONSTANT = RR + "constant";
    public static final String RR_GRAPH = RR + "graph";
    public static final String RR_GRAPH_MAP = RR + "graphMap";
    public static final String RR_GRAPH_COLUMN = RR + "graphColumn";
    public static final String RR_GRAPH_TEMPLATE = RR + "graphTemplate";
    public static final String RR_INVERSE_EXPRESSION = RR + "inverseExpression";
    public static final String RR_JOIN_CONDITION = RR + "joinCondition";
    public static final String RR_LANGUAGE_MAP = RR + "languageMap";
    public static final String RR_LANGUAGE = RR + "language";
    public static final String RR_LOGICAL_TABLE = RR + "logicalTable";
    public static final String RR_OBJECT = RR + "object";
    public static final String RR_OBJECT_MAP = RR + "objectMap";
    public static final String RR_PARENT = RR + "parent";
    public static final String RR_PARENT_TRIPLES_MAP = RR + "parentTriplesMap";
    public static final String RR_PREDICATE = RR + "predicate";
    public static final String RR_PREDICATE_MAP = RR + "predicateMap";
    public static final String RR_PREDICATE_OBJECT_MAP = RR + "predicateObjectMap";
    public static final String RR_SQL_QUERY = RR + "sqlQuery";
    public static final String RR_SQL_VERSION = RR + "sqlVersion";
    public static final String RR_SUBJECT = RR + "subject";
    public static final String RR_SUBJECT_MAP = RR + "subjectMap";
    public static final String RR_TABLE_NAME = RR + "tableName";
    public static final String RR_TEMPLATE = RR + "template";
    public static final String RR_TERM_TYPE = RR + "termType";
    //SPECIAL
    public static final String RR_DEFAULT_GRAPH = RR + "defaultGraph";
    public static final String RR_IRI = RR + "IRI";
    public static final String RR_BLANK_NODE = RR + "BlankNode";
    public static final String RR_LITERAL = RR + "Literal";
    public static final String RR_SQL2008 = RR + "SQL2008";
    //
    public static final String RR_TYPE = RR + "type";
    //undefined
    public static final String RR_VERSION = RR + "sqlVersion";
    
    //RML
    //RML class
    public static final String RML_LOGICAL_SOURCE_CLASS = RML + "LogicalSource";
    //RML properties
    public static final String RML_REFERENCE_FORMULATION = RML + "referenceFormulation";
    public static final String RML_LOGICAL_SOURCE = RML + "logicalSource";
    public static final String RML_REFERENCE = RML + "reference";
    public static final String RML_ITERATOR = RML + "iterator";
    public static final String RML_VERSION = RML + "version";
    public static final String RML_QUERY = RML + "query";
    public static final String RML_SOURCE = RML + "source";
    public static final String RML_PROCESS = RML + "process";
    public static final String RML_REPLACE = RML + "replace";
    public static final String RML_SPLIT = RML + "split";
    //undefined
    public static final String RML_CONDITION = RML + "condition";
    public static final String RML_PARENT_TERM_MAP = RML + "parentTermMap";
    public static final String RML_NAME = RML + "name";
    public static final String RML_SOURCE_NAME = RML + "sourceName";
    public static final String RML_LANGUAGE_MAP = RML + "languageMap";
    //QL
    public static final String QL_XPATH_CLASS = QL + "XPath";
    public static final String QL_SQL_CLASS = QL + "SQL";
    public static final String QL_JSONPATH_CLASS = QL + "JSONPath";
    public static final String QL_CSV_CLASS = QL + "CSV";
    public static final String QL_XLS_CLASS = QL + "XLS";
    public static final String QL_XLSX_CLASS = QL + "XLSX";
    public static final String QL_WIKITEXT_CLASS = QL + "wikitext";
    public static final String QL_CSS3_CLASS = QL + "CSS3";
    
    //CO
    public static final String CO_VERIFICATION_CLASS = CO + "Verification";
    public static final String CO_COMPLETION_CLASS = CO + "Completion";
    public static final String CO_REQUIRES = CO + "requires";
    
    //CRML
    public static final String CRML_BINDING_CLASS = CRML + "BindingCondition";
    public static final String CRML_EQUAL_CLASS = CRML + "EqualCondition";
    public static final String CRML_PROCESS_CLASS = CRML + "ProcessCondition";
    public static final String CRML_SPLIT_CLASS = CRML + "SplitCondition";
    //crml Properties
    public static final String CRML_BINDING = CRML + "binding";
    public static final String CRML_EQUAL_CONDITION = CRML + "equalCondition";
    public static final String CRML_BOOLEAN_CONDITION = CRML + "booleanCondition";
    public static final String CRML_NEGATIONOF = CRML + "negationOf";
    public static final String CRML_PROCESS_CONDITION = CRML + "processCondition";
    public static final String CRML_SPLIT_CONDTION = CRML + "splitCondition";
    public static final String CRML_FALLBACK_MAP = CRML + "fallbackMap";
    public static final String CRML_CONDITION = CRML + "condition";
    public static final String CRML_EXPRESSION = CRML + "expression";
    public static final String CRML_VALUE = CRML + "value";
    public static final String CRML_VARIABLE = CRML + "variable";
    public static final String CRML_REPLACE = CRML + "replace";
    
    //PROV
    public static final String PROV_ENTITY_CLASS = PROV + "Entity";
    public static final String PROV_ACTIVITY_CLASS = PROV + "Activity";
    //prov properties
    public static final String PROV_WASGENERATEDBY = PROV + "wasGeneratedBy";
    public static final String PROV_WASDERIVEDFROM = PROV + "wasDerivedFrom";
    public static final String PROV_WASATTRIBUTEDTO = PROV + "wasAttributedTo";
    public static final String PROV_STARTEDATTIME = PROV + "startedAtTime";
    public static final String PROV_USED = PROV + "used";
    public static final String PROV_WASINFORMEDBY = PROV + "wasInformedBy";
    public static final String PROV_ENDDATETIME = PROV + "endedAtTime";
    public static final String PROV_WASASSOCIATEDWITH = PROV + "wasAssociatedWith";
    public static final String PROV_ACTEDONBEHALFOF = PROV + "actedOnBehalfOf";
    
    //DCAT
    public static final String DCAT_DATASET = DCAT + "Dataset";
    public static final String DCAT_DISTRIBUTION_CLASS = DCAT + "Distribution";
    //DCAT properties
    public static final String DCAT_DISTRIBUTION = DCAT + "distribution";
    public static final String DCAT_DOWNLOAD_URL = DCAT + "downloadURL";
    public static final String DCAT_ACCESS_URL = DCAT + "accessURL";
    
    //HYDRA
    public static final String HYDRA_IRITEMPLATE_CLASS = HYDRA + "IriTemplate";
    public static final String HYDRA_API_DOCUMENTATION_CLASS = HYDRA + "ApiDocumentation";
    public static final String HYDRA_PAGED_COLLECTION_CLASS = HYDRA + "PagedCollection";
    //IriTemplate properties
    public static final String HYDRA_TEMPLATE = HYDRA + "template";
    public static final String HYDRA_MAPPING = HYDRA + "mapping";
    //IriTemplateMapping properties
    public static final String HYDRA_TEMPLATE_MAPPING = HYDRA + "TemplateMapping";
    public static final String HYDRA_VARIABLE = HYDRA + "variable";
    public static final String HYDRA_REQUIRED = HYDRA + "required";
    //PagedCollection properties
    public static final String HYDRA_ITEM_PER_PAGE = HYDRA + "itemsPerPage";
    public static final String HYDRA_FIRST_PAGE = HYDRA + "firstPage";
    public static final String HYDRA_NEXT_PAGE = HYDRA + "nextPage";
    public static final String HYDRA_PREVIOUS_PAGE = HYDRA + "previousPage";
    public static final String HYDRA_LAST_PAGE = HYDRA + "lastPage";
    public static final String HYDRA_TOTALITEM_PAGE = HYDRA + "totalItems";
    public static final String HYDRA_SEARCH_PAGE = HYDRA + "search";
    
    //D2RQ
    public static final String D2RQ_DATABASE_CLASS = D2RQ + "Database";
    public static final String D2RQ_JDBC_DSN = D2RQ + "jdbcDSN";
    public static final String D2RQ_JDBC_DRIVER = D2RQ + "jdbcDriver";
    public static final String D2RQ_USERNAME = D2RQ + "username";
    public static final String D2RQ_PASSWORD = D2RQ + "password";
    
    //SPARQL-SD
    public static final String SD_SERVICE_CLASS = SD + "Service";
    public static final String SD_DATASET_CLASS = SD + "Dataset";
    public static final String SD_GRAPH_CLASS = SD + "Graph";
    public static final String SD_NAMEDGRAPH_CLASS = SD + "NamedGraph";
    //SPARQL-SD Properties   
    public static final String SD_QUERY_TEMPLATE = SD + "sparqlQueryTemplate";
    public static final String SD_SUPPORTED_LANGUAGE = SD + "supportedLanguage";
    public static final String SD_RESULT_FORMAT = SD + "resultFormat";
    //SPARQL -SD Instances
    public static final String SD_ENDPOINT = SD + "endpoint";
    public static final String SD_GRAPH = SD + "graph";
    public static final String SD_10QUERY = SD + "SPARQL10Query";
    public static final String SD_11QUERY = SD + "SPARQL11Query";
    public static final String SD_11UPDATE = SD + "SPARQL11Update";
    public static final String SD_RESULTS_XML = SD + "SPARQL_Results_XML";
    public static final String SD_RESULTS_JSON = SD + "SPARQL_Results_JSON";
    public static final String SD_RESULTS_CSV = SD + "SPARQL_Results_CSV";
    
    //CSVW
    public static final String CSVW_TABLE_CLASS = CSVW + "Table";
    public static final String CSVW_DIALECT_CLASS = CSVW + "Dialect";
    public static final String CSVW_FOREIGNKEY_CLASS = CSVW + "ForeignKey";
    public static final String CSVW_SCHEMA_CLASS = CSVW + "Schema";
    public static final String CSVW_TABLEGROUP_CLASS = CSVW + "TableGroup";
    public static final String CSVW_TABLEREFERENCE_CLASS = CSVW + "TableReference";
    public static final String CSVW_TRANSFORMATION_CLASS = CSVW + "Transformation";
    //CSVW Properties
    public static final String CSVW_URL = CSVW + "url";
    public static final String CSVW_TABLESCHEMA = CSVW + "tableSchema";
    public static final String CSVW_DIALECT = CSVW + "dialect";
    public static final String CSVW_COLUMNS = CSVW + "columns";
    public static final String CSVW_NAME = CSVW + "name";
    public static final String CSVW_TITLES = CSVW + "titles";
    public static final String CSVW_DATATYPE = CSVW + "datatype";
    public static final String CSVW_PRIMARYKEY = CSVW + "primaryKey";
    public static final String CSVW_ABOUTURL = CSVW + "aboutUrl";
    public static final String CSVW_QUOTECHAR = CSVW + "quoteChar";
    public static final String CSVW_PROPERTYURL = CSVW + "propertyUrl";
    public static final String CSVW_DELIMITER = CSVW + "delimiter";
    public static final String CSVW_ENCODING = CSVW + "encoding";
    public static final String CSVW_HEADER = CSVW + "header";
    public static final String CSVW_HEADER_ROW_COUNT= CSVW + "headerRowCount";
    public static final String CSVW_TRIM = CSVW + "trim";
    
    //FNML
    public static final String FNML_FUNCTION_TERM_MAP_CLASS = FNML + "FunctionTermMap";
    //FNML properties
    public static final String FNML_FUNCTION_VALUE = FNML + "functionValue";
    //FNO properties
    public static final String FNO_EXECUTES = FNO + "executes";
    public static final String FNML_CTERMS_TYPE = FNML + "type";
    //FNO
    public static final String FNO_FUNCTION = FNO + "Function";
    public static final String FNO_NAME = FNO + "name";
    public static final String FNO_EXPECTS = FNO + "expects";
    public static final String FNO_RETURNS = FNO + "returns";
    public static final String FNO_PROVIDED_BY = FNO + "providedBy";
    public static final String FNO_LOCAL_LIBRARY = FNO + "localLibrary";
    public static final String FNO_CLASS = FNO + "class";
    public static final String FNO_METHOD = FNO + "method";
    public static final String FNO_TYPE = FNO + "type";
    public static final String FNO_PREDICATE = FNO + "predicate";
    public static final String FNO_PARAMETER = FNO + "Parameter";
    public static final String FNO_OUTPUT = FNO + "Output";
    public static final String DCTERMS_TYPE = DCTERMS + "type";
    public static final String DCTERMS_DESCRIPTION = DCTERMS + "description";
	public static final String RDFS_LABEL = RDFS + "label";
}
