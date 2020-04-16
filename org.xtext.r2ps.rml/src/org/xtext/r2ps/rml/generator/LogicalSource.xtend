package org.xtext.r2ps.rml.generator

import org.xtext.r2ps.rml.rML.Object
import org.xtext.r2ps.rml.rML.Triples
import org.xtext.r2ps.rml.rML.Verb
import org.xtext.r2ps.rml.rML.iResource
import java.net.URLEncoder

class LogicalSource {
	
	static def String parseLogicalSource(Triples triple) {
		var str = ""
		var uriRef = ""
		var isLogicalSource = false
		var source = ""
		var poList = triple.predicateObjectList.predicateObjects
		for (po : poList) {
			var verb = po.verb.getVerb
			var object = po.objectList.objects.get(0)
			if (!isLogicalSource) {
				if (verb == 'a') {
					var objectString = object.getObject
					if (objectString == NAMESPACE.RML_LOGICAL_SOURCE) {
						// this triple is a logicalSource
						// 'a' 'rr:LogicalSource
						isLogicalSource = true
					}
				} else if (verb.isLogicalSource) {
					isLogicalSource = true
					if (object.resource !== null) {
						// uriref
						// return "<logicalSource uriRef=\""+object.resource.getResource+"\">"
						var tri = RMLGenerator.getTripleByName(object.resource.getResource)
						if (tri !== null) {
							poList = tri.predicateObjectList.predicateObjects
							source = DataRetrieval.dispatchDataSource(triple.predicateObjectList)
						} else {
							uriRef = ''' uriRef="«object.resource.getResource»"'''
						}
					} else if (object.blank !== null) {
						// []
						poList = object.blank.predicateObjectList.predicateObjects
					} else if (object.literal !== null) {
						throw new Exception("syntax error.")
					}
				}
			}
		}
		if (isLogicalSource) {
			// this is a logicalSource
			var iterator = ""
			var refer = ""
			var query = ""
			var sqlversion = ""
			var tableName = ""
			for (po : poList) {
				var verb = po.verb.getVerb
				var objects = po.objectList.objects
				if (verb.isSource) {
					source = DataRetrieval.dispatchDataSource(po.objectList)
				} else if (verb.isIterator) {
					iterator = ''' iterator="«objects.get(0).getObject»"'''
				} else if (verb.isReferenceFormulation) {
					refer = ''' referenceFormulation="«objects.get(0).getObject»"'''
				} else if (verb.isQuery) {
					var strQ = objects.get(0).getObject.escapeQuotes
					query = ''' query="«strQ»"'''
				} else if (verb.isSqlVersion) {
					sqlversion = ''' sqlVersion="«objects.get(0).getObject»"'''
				} else if (verb.isTableName) {
					var name = objects.get(0).getObject.escapeQuotes
					tableName = ''' tableName="«name»"'''
				}
			}
			str = '''
				<logicalSource «uriRef»«iterator»«refer»«query»«sqlversion»«tableName»>
					«source»
				</logicalSource>
			'''
		}
		return str
	}
	
	protected static def escapeQuotes(String str) {
		var name = str.r2pdecode
		name = name.replaceAll('^["](.*)["]$','$1');
		name = URLEncoder.encode(name, 'utf-8')
		name = '"' + name + '"'
		name = name.r2pencode
		return name
	}
	
	static def boolean isQuery(String str) {
		if (str == NAMESPACE.RML_QUERY) {
			return true
		}
		return false
	}

	static def boolean isSqlVersion(String str) {
		if (str == NAMESPACE.RR_SQL_VERSION
		) {
			return true
		}
		return false
	}

	static def boolean isReferenceFormulation(String str) {
		if (str == NAMESPACE.RML_REFERENCE_FORMULATION) {
			return true
		}
		return false
	}

	static def boolean isTableName(String str) {
		if (str == NAMESPACE.RR_TABLE_NAME
		) {
			return true
		}
		return false
	}
	
	static def boolean isIterator(String str) {
		if (str == NAMESPACE.RML_ITERATOR) {
			return true
		}
		return false
	}
	
	static def boolean isSource(String str) {
		if (str == NAMESPACE.RML_SOURCE ||
			str == NAMESPACE.RML_NAME || 
			str == NAMESPACE.RML_SOURCE_NAME
		) {
			return true
		}
		return false
	}
	
	static def boolean isLogicalSource(String str) {
		if (str == NAMESPACE.RML_LOGICAL_SOURCE) {
			return true
		}
		return false
	}
	protected static def String r2pdecode(String str) {
		return Helper.r2pdecode(str)
	}
	protected static def String r2pencode(String str) {
		return Helper.r2pencode(str)
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