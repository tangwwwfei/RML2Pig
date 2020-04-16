package org.xtext.r2ps.rml.generator

import org.xtext.r2ps.rml.rML.Object
import org.xtext.r2ps.rml.rML.ObjectList
import org.xtext.r2ps.rml.rML.PredicateObjectList
import org.xtext.r2ps.rml.rML.Verb
import org.xtext.r2ps.rml.rML.iResource

class DataRetrieval {
	static def String dispatchDataSource(PredicateObjectList pol) {
		var str = ""
		var termName = ""
		for (po : pol.predicateObjects) {
			var verb = po.verb.getVerb
			var compareString = verb
			var object = po.objectList.getObjectList
			if (verb == 'a') {
				compareString = object
			}
			if (compareString.isDcatDataset) {
				termName = "dataset"
			} else if (compareString.isHydraIriTemplate) {
				termName = "webAPI"
			} else if (compareString.isD2rqDatabase) {
				termName = "database"
			} else if (compareString.isSDService) {
				termName = "sparql"
			} else if (compareString.isCsvwTable) {
				termName = "csvonWeb"
			} else if (compareString.isHydraPagedCollection) {
				termName = "pagedCollection"
			} else if (compareString.isFnoFunction) {
				termName = "function"
			} else if (compareString.isFnoParameter || compareString.isFnoOutput) {
				termName = "paramter"
			} else if (compareString.isDcatDistribution) {
				termName = "distribution"
			}
		}
		str = '''
			<source>
				«pol.parseDataRetrieval(termName)»
			</source>
		'''
		return str
	}

	static def String dispatchDataSource(ObjectList ol) {
		var str = ""
		var obj = ol.objects.get(0)
		if (obj.blank !== null) {
			str = obj.blank.predicateObjectList.dispatchDataSource
		} else {
			str = ol.parseDataRetrieval("source", null)
		}
		return str
	}
	
	static def String parseDataRetrieval(PredicateObjectList pol, String termName) {
		var str = ""
		var d2rqPassword = ""
		var d2rqUsername = ""
		var d2rqJdbcDriver = ""
		var d2rqJdbcDSN = ""
		var d2rqDatabase = ""
		var hydraDistribution = ""
		var hydraDownloadurl = ""
		var hydraTemplate = ""
		var hydraMapping = ""
		var hydraVariable = ""
		var hydraRequired = ""
		var hydraItemsPerPage = ""
		var hydraFirstPage = ""
		var hydraNextPage = ""
		var sdEndpoint = ""
		var sdResultFormat = ""
		var sdSupportedLanguage = ""
		var csvwTrim = ""
		var csvwHeaderRowCount = ""
		var csvwHeader = ""
		var csvwEnconding = ""
		var csvwDelimiter = ""
		var csvwDialect = ""
		var csvwUrl = ""
		for (po : pol.predicateObjects) {
			var verb = po.verb.getVerb
			if (verb.isDcatDistribution) {
				hydraDistribution += po.objectList.parseDataRetrieval("distribution", null)
			} else if (verb.isDcatDataset) {
				// None
			} else if (verb.isDcatDownloadURL) {
				hydraDownloadurl = ''' downloadURL="«po.objectList.getObjectList»"'''
			} else if (verb.isHydraIriTemplate) {
				// None
			} else if (verb.isHydraTemplate) {
				// «»
				hydraTemplate = ''' template="«po.objectList.getObjectList»"'''
			} else if (verb.isHydraMapping) {
				hydraMapping += po.objectList.parseDataRetrieval("hydraMapping", null)
			} else if (verb.isHydraTemplateMapping) {
				// None
			} else if (verb.isHydraVariable) {
				hydraVariable = ''' variable="«po.objectList.getObjectList»"'''
			} else if (verb.isHydraRequired) {
				hydraRequired = ''' required="«po.objectList.getObjectList»"'''
			} else if (verb.isHydraPagedCollection) {
				// None
			} else if (verb.isHydraItemsPerPage) {
				hydraItemsPerPage = ''' itemsPerPage="«po.objectList.getObjectList»"'''
			} else if (verb.isHydraFirstPage) {
				hydraFirstPage = ''' firstPage="«po.objectList.getObjectList»"'''
			} else if (verb.isHydraNextPage) {
				hydraNextPage = ''' nextPage="«po.objectList.getObjectList»"'''
			} else if (verb.isD2rqDatabase) {
				d2rqDatabase = ''' Database="«po.objectList.getObjectList»"'''
			} else if (verb.isD2rqJdbcDSN) {
				d2rqJdbcDSN = ''' jdbcDSN="«po.objectList.getObjectList»"'''
			} else if (verb.isD2rqJdbcDriver) {
				d2rqJdbcDriver = ''' jdbcDriver="«po.objectList.getObjectList»"'''
			} else if (verb.isD2rqUsername) {
				d2rqUsername = ''' username="«po.objectList.getObjectList»"'''
			} else if (verb.isD2rqPassword) {
				d2rqPassword = ''' password="«po.objectList.getObjectList»"'''
			} else if (verb.isSDService) {
				// None//sdService=''' service="«po.objectList.getObjectList»"'''
			} else if (verb.isSDEndpoint) {
				sdEndpoint = ''' endpoint="«po.objectList.getObjectList»"'''
			} else if (verb.isSDSupportedLanguage) {
				sdSupportedLanguage = ''' supportedLanguage="«po.objectList.getObjectList»"'''
			} else if (verb.isSDResultFormat) {
				sdResultFormat = ''' resultFormat="«po.objectList.getObjectList»"'''
			} else if (verb.isCsvwTable) {
				// None
			} else if (verb.isCsvwURL) {
				csvwUrl = ''' url="«po.objectList.getObjectList»"'''
			} else if (verb.isCsvwDialect) {
				csvwDialect += po.objectList.parseDataRetrieval("dialect", null)
			} else if (verb.isCsvwDelimiter) {
				csvwDelimiter = ''' delimiter="«po.objectList.getObjectList»"'''
			} else if (verb.isCsvwEncoding) {
				csvwEnconding = ''' encoding="«po.objectList.getObjectList»"'''
			} else if (verb.isCsvwHeader) {
				csvwHeader = ''' header="«po.objectList.getObjectList»"'''
			} else if (verb.isCsvwHeaderRowCount) {
				csvwHeaderRowCount = ''' headerRowCount="«po.objectList.getObjectList»"'''
			} else if (verb.isCsvwTrim) {
				csvwTrim = ''' trim="«po.objectList.getObjectList»"'''
			}
		}
		// termMap = Helper.parseTermMap(pol)
		str = '''
			<«termName»«d2rqUsername»«d2rqPassword»«d2rqJdbcDriver»«d2rqJdbcDSN»«d2rqDatabase»«hydraDownloadurl»«hydraTemplate»«hydraVariable»«hydraRequired»«hydraItemsPerPage»«hydraFirstPage»«hydraNextPage»«sdEndpoint»«sdResultFormat»«sdSupportedLanguage»«csvwTrim»«csvwHeaderRowCount»«csvwHeader»«csvwEnconding»«csvwDelimiter»«csvwUrl»>
				«hydraDistribution»
				«csvwDialect»
				«hydraMapping»
			</«termName»>
		'''
		return str
	}
	
	static def String parseDataRetrieval(ObjectList objectList, String termName, String shortName) {
		var str = ""
		var obj = objectList.objects.get(0)
		if (obj.blank !== null) {
			//[]
			str = obj.blank.predicateObjectList.parseDataRetrieval(termName)
		}
		else if (obj.resource !== null) {
			//language
			if (obj.resource.uriRef !== null) {
				//uriref
				var refTriple = RMLGenerator.getTripleByName(obj.resource.getResource)
				if (refTriple !== null){
					str = refTriple.predicateObjectList.dispatchDataSource
				}
				else{
					str = obj.resource.getResource
					return '''
					<«termName» path="«str»"/>
					'''
				}
			}
			else{
				for (o : objectList.objects) {
					str += '''<«shortName»>«o.getObject»</«shortName»>''' + "\r\n"
				}
				str.trim
				return'''
					<«termName» path="«str»"/>
					'''
			}
		}
		else{
			str = Helper.getLiteral(obj.literal)
			return'''
					<«termName» path="«str»"/>
					'''
		}
		str.trim
		return str
	}
	
	static def boolean isFnoPredicate(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.FNO_PREDICATE)) {
			return true
		}
		return false
	}
	static def boolean isFnoType(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.FNO_TYPE)) {
			return true
		}
		return false
	}
	static def boolean isFnoMethod(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.FNO_METHOD)) {
			return true
		}
		return false
	}
	static def boolean isFnoClass(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.FNO_CLASS)) {
			return true
		}
		return false
	}
	static def boolean isFnoLocalLibrary(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.FNO_LOCAL_LIBRARY)) {
			return true
		}
		return false
	}
	static def boolean isFnoProvidedBy(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.FNO_PROVIDED_BY)) {
			return true
		}
		return false
	}
	static def boolean isFnoReturns(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.FNO_RETURNS)) {
			return true
		}
		return false
	}
	static def boolean isFnoExpects(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.FNO_EXPECTS)) {
			return true
		}
		return false
	}
	static def boolean isFnoName(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.FNO_NAME)) {
			return true
		}
		return false
	}
	static def boolean isRdfsLabel(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.RDFS_LABEL)) {
			return true
		}
		return false
	}
	static def boolean isFnoFunction(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.FNO_FUNCTION)) {
			return true
		}
		return false
	}
	static def boolean isFnoParameter(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.FNO_PARAMETER)) {
			return true
		}
		return false
	}
	static def boolean isFnoOutput(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.FNO_OUTPUT)) {
			return true
		}
		return false
	}
	static def boolean isDctermsDescription(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.DCTERMS_DESCRIPTION)) {
			return true
		}
		return false
	}
	static def boolean isDcatDistribution(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.DCAT_DISTRIBUTION)) {
			return true
		}
		return false
	}
	static def boolean isDcatDataset(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.DCAT_DATASET)) {
			return true
		}
		return false
	}
	static def boolean isDcatDownloadURL(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.DCAT_DOWNLOAD_URL)) {
			return true
		}
		return false
	}
	static def boolean isHydraIriTemplate(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.HYDRA_IRITEMPLATE_CLASS)) {
			return true
		}
		return false
	}
	static def boolean isHydraTemplate(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.HYDRA_TEMPLATE)) {
			return true
		}
		return false
	}
	static def boolean isHydraMapping(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.HYDRA_MAPPING)) {
			return true
		}
		return false
	}
	static def boolean isHydraTemplateMapping(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.HYDRA_TEMPLATE_MAPPING)) {
			return true
		}
		return false
	}
	static def boolean isHydraVariable(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.HYDRA_VARIABLE)) {
			return true
		}
		return false
	}
	static def boolean isHydraRequired(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.HYDRA_REQUIRED)) {
			return true
		}
		return false
	}
	static def boolean isHydraPagedCollection(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.HYDRA_PAGED_COLLECTION_CLASS)) {
			return true
		}
		return false
	}
	static def boolean isHydraItemsPerPage(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.HYDRA_ITEM_PER_PAGE)) {
			return true
		}
		return false
	}
	static def boolean isHydraFirstPage(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.HYDRA_FIRST_PAGE)) {
			return true
		}
		return false
	}
	static def boolean isHydraNextPage(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.HYDRA_NEXT_PAGE)) {
			return true
		}
		return false
	}
	static def boolean isD2rqDatabase(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.D2RQ_DATABASE_CLASS)) {
			return true
		}
		return false
	}
	static def boolean isD2rqJdbcDSN(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.D2RQ_JDBC_DSN)) {
			return true
		}
		return false
	}
	static def boolean isD2rqJdbcDriver(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.D2RQ_JDBC_DRIVER)) {
			return true
		}
		return false
	}
	static def boolean isD2rqUsername(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.D2RQ_USERNAME)) {
			return true
		}
		return false
	}
	static def boolean isD2rqPassword(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.D2RQ_PASSWORD)) {
			return true
		}
		return false
	}
	static def boolean isSDService(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.SD_SERVICE_CLASS)) {
			return true
		}
		return false
	}
	static def boolean isSDEndpoint(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.SD_ENDPOINT)) {
			return true
		}
		return false
	}
	static def boolean isSDSupportedLanguage(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.SD_SUPPORTED_LANGUAGE)) {
			return true
		}
		return false
	}
	static def boolean isSDResultFormat(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.SD_RESULT_FORMAT)) {
			return true
		}
		return false
	}
	static def boolean isCsvwTable(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.CSVW_TABLE_CLASS)) {
			return true
		}
		return false
	}
	static def boolean isCsvwURL(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.CSVW_URL)) {
			return true
		}
		return false
	}
	static def boolean isCsvwDialect(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.CSVW_DIALECT)) {
			return true
		}
		return false
	}
	static def boolean isCsvwDelimiter(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.CSVW_DELIMITER)) {
			return true
		}
		return false
	}
	static def boolean isCsvwEncoding(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.CSVW_ENCODING)) {
			return true
		}
		return false
	}
	static def boolean isCsvwHeader(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.CSVW_HEADER)) {
			return true
		}
		return false
	}
	static def boolean isCsvwHeaderRowCount(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.CSVW_HEADER_ROW_COUNT)) {
			return true
		}
		return false
	}
	static def boolean isCsvwTrim(String str) {
		if (str.equalsIgnoreCase(NAMESPACE.CSVW_TRIM)) {
			return true
		}
		return false
	}
	
	protected static def String getObjectList(ObjectList ol) {
		return Helper.getObjectList(ol)
	}
	protected static def String getResource(iResource r) {
		return Helper.getResource(r)
	}
	protected static def String getObject(Object obj) {
		return Helper.getObject(obj)
	}
	protected static def String getVerb(Verb verb) {
		return Helper.getVerb(verb)
	}
}