package org.xtext.r2ps.rml.generator

import org.eclipse.emf.common.util.EList
import org.xtext.r2ps.rml.rML.Blank
import org.xtext.r2ps.rml.rML.DatatypeString
import org.xtext.r2ps.rml.rML.LanguageString
import org.xtext.r2ps.rml.rML.Literal
import org.xtext.r2ps.rml.rML.NodeID
import org.xtext.r2ps.rml.rML.Object
import org.xtext.r2ps.rml.rML.ObjectList
import org.xtext.r2ps.rml.rML.PredicateObject
import org.xtext.r2ps.rml.rML.PredicateObjectList
import org.xtext.r2ps.rml.rML.Qname
import org.xtext.r2ps.rml.rML.Subject
import org.xtext.r2ps.rml.rML.Verb
import org.xtext.r2ps.rml.rML.iResource
import org.apache.commons.lang3.StringEscapeUtils;
import java.util.regex.Pattern

final class Helper {
	
	static def String parseClass() {
		
	}
	
	static def String parseProperties() {
		
	}
	
	static def String parseTermMap(PredicateObjectList predicateObjectList) {
		var refer=""
		var constant=""
		var template=""
		var datatype=""
		var termtype=""
		for (pol : predicateObjectList.predicateObjects) {
			var verb = pol.verb.getVerb
			var objects = pol.objectList.objects
			if (verb == NAMESPACE.RML_REFERENCE) {
				refer='''<reference value="«objects.get(0).getObject»"/>'''
			}
			else if (verb == NAMESPACE.RR_CONSTANT) {
				constant='''<constant value="«objects.get(0).getObject»"/>'''
			}
			else if (verb == NAMESPACE.RR_TEMPLATE) {
				template='''<template value="«objects.get(0).getObject»"/>'''
			}
			else if (verb == NAMESPACE.RR_DATATYPE) {
				datatype='''<datatype value="«objects.get(0).getObject»"/>'''
			}
			else if (verb == NAMESPACE.RR_TERM_TYPE) {
				termtype='''<termtype value="«objects.get(0).getObject»"/>'''
			}
			else{
				//System.out.print('没有处理：'+verb);
			}
		}
		var str = '''
		«refer»
		«constant»
		«template»
		«datatype»
		«termtype»
		'''
		return str
	}
	
	static def String parseCommonMap(PredicateObjectList pol, String termName, String owner) {
		var str = ""
		var ls=""
		var sm=""
		var classes=""
		var pom=""
		var graphMap=""
		var termMap=""
		var functionMaps=""
		var dctermType=""
		var parentTermMap=""
		var processCondition=""
		var condition=""
		var parentTriplesMap=""
		var joinCondition=""
		var parent=""
		var child=""
		var predicateMap=""
		var refObjectMap=""
		var objectMap=""
		var crmlCondition=""
		var crmlBinding=""
		var crmlVariable=""
		var equalCondition=""
		var fallbackMap=""
		var boolCondition=""
		var langMap=""
		var ownTriplesMap=""
		var functionTriplesMap = ""
		//var reference=""
		for (po : pol.predicateObjects) {
			var verb = po.verb.getVerb
			if (verb.isLogicalSource) {
				ls=parseCommonMap(po.objectList, "logicalSource", null, owner)
			}
			else if (verb.isSubjectMap) {
				sm += parseCommonMap(po.objectList, "subjectMap", null, owner)
			}
			else if (verb.isPredicateObjectMap) {
				pom+=parseCommonMap(po.objectList, "predicateObjectMaps", null, owner)
				ownTriplesMap = owner;
			}
			else if (verb.isPredicateMap) {
				predicateMap+=parseCommonMap(po.objectList, "predicateMaps", "predicates", owner)
				ownTriplesMap = owner;
			}
			else if (verb.isObjectMap) {
				objectMap+=parseCommonMap(po.objectList, "objectMaps", "objects", owner)
				ownTriplesMap = owner;
			}
			else if (verb.isRefObjectMap) {
				refObjectMap+=parseCommonMap(po.objectList, "refObjectMaps", "refObjecets", owner)
				ownTriplesMap = owner;
			}
			else if (verb.isGraphMap) {
				graphMap+=po.objectList.parseCommonMap("graphMaps", "graphs", owner)
			}
			else if (verb.isDCTermType){
				dctermType=''' dctermType="«po.objectList.getObjectList»"'''
			}
			else if (verb.isfunctionMaps) {
				var object = po.objectList.objects.get(0);
				if (object.resource !== null) {
					functionTriplesMap=''' functionTriplesMap="«object.getObject»"'''
				}
				var tmp = po.objectList.parseCommonMap("functionMaps", null, owner)
				functionMaps += tmp.replaceAll("^<functionMaps", "<functionMaps" + functionTriplesMap);
			}
			else if (verb.isParentTermMap) {
				parentTermMap += po.objectList.parseCommonMap("parentTermMap", null, owner)
			}
			else if (verb.isProcessCondition) {
				processCondition += po.objectList.parseCommonMap("processCondition", null, owner)
			}
			else if (verb.isCondition) {
				condition += po.objectList.parseCommonMap("condition", null, owner)
			}
			else if (verb.isJoinCondition) {
				joinCondition+=po.objectList.parseCommonMap("joinConditions", null, owner)
			}
			else if (verb.isParentTriplesMap) {
				parentTriplesMap=''' parentTriplesMap="«po.objectList.getObjectList»"'''
				//joinCondition+=po.objectList.parseCommonMap("joinCondition", null, owner)
			}
			else if (verb.isParent) {
				parent=''' parent="«po.objectList.getObjectList»"'''
			}
			else if (verb.isChild) {
				child=''' child="«po.objectList.getObjectList»"'''
			}
			else if (verb.isCrmlCondition) {
				crmlCondition=po.objectList.parseCommonMap("condition", null, owner)
			}
			else if (verb.isCrmlBinding) {
				crmlBinding=po.objectList.parseCommonMap("binding", null, owner)
			}
			else if (verb.isCrmlVariable) {
				crmlVariable=po.objectList.parseCommonMap("variable", null, owner)
			}
			else if (verb.isFallbackMap) {
				fallbackMap=po.objectList.parseCommonMap("fallbackMaps", null, owner)//'''<fallbackMap>«po.objectList.getObjectList»</fallbackMap>'''//po.objectList.parseCommonMap("fallbackMap", null, owner)
				//xml parse
				//if fallback includes logicalSource
				//	as a iriref
			}
			else if (verb.isBooleanCondition) {
				boolCondition+=po.objectList.parseCommonMap("booleanConditions", null, owner)
			}
			else if (verb.isEqualCondition) {
				equalCondition+=po.objectList.parseCommonMap("equalConditions", null, owner)//''' <equalCondition>«pol.objectList.getObjectList»</equalCondition>'''
			}
			else if (verb.isClass) {
				classes += '''<class>«po.objectList.getObjectList»</class>'''
			}
			else if (verb.isLanguageMap){
				//uriref
				//[]
				//language
				langMap=po.objectList.parseCommonMap("languageMap",null, owner)
			}
			else if (verb.isLanguageTag){
				//uriref
				//[]
				//language
				langMap=po.objectList.parseCommonMap("languageTag",null, owner)
			}
			else{
				//None
				//System.out.print('未处理：'+verb);
			}
		}
		termMap = Helper.parseTermMap(pol)
		if (owner !== null){
			ownTriplesMap = ''' ownTriplesMap="«owner»"''';
		}
		str = '''
		<«termName»«ownTriplesMap»«dctermType»«parentTriplesMap»«parent»«child»>
			«ls»
			«sm»
			«pom»
			«predicateMap»
			«refObjectMap»
			«objectMap»
			«termMap»
			«classes»
			«graphMap»
			«functionMaps»
			«parentTermMap»
			«processCondition»
			«crmlCondition»
			«condition»
			«crmlVariable»
			«joinCondition»
			«crmlBinding»
			«equalCondition»
			«fallbackMap»
			«boolCondition»
			«langMap»
		</«termName»>
		'''
		return str
	}
	
	static def String parseCommonMap(ObjectList objectList, String termName, String shortName, String owner) {
		var str = ""
		//var obj = objectList.objects.get(0)
		var inside = false
		for(obj : objectList.objects) {
			if (obj.blank !== null) {
				//[]
				str += obj.blank.predicateObjectList.parseCommonMap(termName, owner)
			}
			else if (obj.resource !== null) {
				//language
				if (obj.resource.uriRef !== null) {
					//uriref
					var refTriple = RMLGenerator.getTripleByName(obj.resource.getResource)
					if (refTriple !== null){
						str += refTriple.predicateObjectList.parseCommonMap(termName, owner)
					}
					else{
						//str = obj.resource.getResource
						if (shortName === null) {
							inside = true
							str+=obj.resource.getResource
						}
						else{
							str += '''
									<«termName»>
										<constant value="«obj.resource.getResource»"/>
									</«termName»>
									'''
						}
					}
				}
				else{
					
					var refTriple = RMLGenerator.getTripleByName(obj.resource.getResource)
					if (refTriple !== null){
							str += refTriple.predicateObjectList.parseCommonMap(termName, owner)
					}
					else{
						if (shortName === null) {
							inside=true
							str+=obj.getObject
						}
						else{
							str += '''
									<«termName»>
										<constant value="«obj.getObject»"/>
									</«termName»>
									'''
							//str += '''<«shortName»>«o.getObject»</«shortName»>''' + "\r\n"
						}
					}
					
				}
			}
			else{
				//str = obj.literal.getLiteral
				if (shortName === null) {
					inside=true
					str+=obj.literal.getLiteral
				}
				else{
					str += '''
							<«termName»>
								<constant value="«obj.literal.getLiteral»"/>
							</«termName»>
							'''
					//str+= '''<«shortName»>«obj.literal.getLiteral»</«shortName»>'''	
				}
			}
		}
		str=str.trim
		if (inside) {
			if (shortName === null) {
				return '''<«termName»>«str»</«termName»>'''
			}
			return '''
					<«termName»>
						«str»
					</«termName»>
					'''
		}
		return str
	}
	
	static def boolean FindRefObjectMap(EList<PredicateObject> poList) {
		for(po : poList) {
			var verb = po.verb.getVerb
			var object = po.objectList.objects.get(0)
			if (verb == 'a') {
				var objectString = object.getObject
				if (objectString.isRefObjectMap) {
					//this triple is a logicalSource
					//'a' 'rr:LogicalSource
					return true
 				}
			}
			else if (verb.isParentTriplesMap) {
				return true
			}
		}
		return false
	}
	
	static def boolean FindRefObejctMap(ObjectList ol) {
		var obj = ol.objects.get(0)
		//var poList = new EObjectContainmentEList<PredicateObject>()
		if (obj.blank !== null) {
			//[]
			return obj.blank.predicateObjectList.predicateObjects.FindRefObjectMap
		}
		else {
			var refName = obj.resource.getResource
			var triple = RMLGenerator.m_NameTriple.get(refName)
			if (triple !== null && triple.predicateObjectList !== null) {
				return triple.predicateObjectList.predicateObjects.FindRefObjectMap
			}
			else{
				return false;
			}
		}
		
	}
	//properties
	static def boolean isClass(String str) {
		if (str == NAMESPACE.RR_CLASS) {
			return true
		}
		return false
	}
	protected static def boolean isSubjectMap(String str) {
		if (str == NAMESPACE.RR_SUBJECT_MAP) {
			return true
		}
		return false
	}
	
	protected static def boolean isRMLReference(String str) {
		if (str == NAMESPACE.RML_REFERENCE) {
			return true
		}
		return false
	}
	protected static def boolean isCrmlCondition(String str) {
		if (str == NAMESPACE.CRML_CONDITION) {
			return true
		}
		return false
	}
	protected static def boolean isCrmlBinding(String str) {
		if (str == NAMESPACE.CRML_BINDING) {
			return true
		}
		return false
	}
	protected static def boolean isCrmlVariable(String str) {
		if (str == NAMESPACE.CRML_VARIABLE) {
			return true
		}
		return false
	}
	protected static def boolean isPredicateObjectMap(String str) {
		if (str == NAMESPACE.RR_PREDICATE_OBJECT_MAP) {
			return true
		}
		return false
	}
	protected static def boolean isPredicateMap(String str) {
		if (str == NAMESPACE.RR_PREDICATE_MAP ||
			str == NAMESPACE.RR_PREDICATE
		) {
			return true
		}
		return false
	}
	protected static def boolean isObjectMap(String str) {
		if (str == NAMESPACE.RR_OBJECT_MAP ||
			str == NAMESPACE.RR_OBJECT
		) {
			return true
		}
		return false
	}
	protected static def boolean isRefObjectMap(String str) {
		if (str == NAMESPACE.RR_REF_OBJECT_MAP_CLASS
		) {
			return true
		}
		return false
	}
	protected static def boolean isParentTriplesMap(String str) {
		if (str == NAMESPACE.RR_PARENT_TRIPLES_MAP
		) {
			return true
		}
		return false
	}
	protected static def boolean isParent(String str) {
		if (str == NAMESPACE.RR_PARENT
		) {
			return true
		}
		return false
	}
	protected static def boolean isChild(String str) {
		if (str == NAMESPACE.RR_CHILD
		) {
			return true
		}
		return false
	}
	protected static def boolean isJoinCondition(String str) {
		if (str == NAMESPACE.RR_JOIN_CONDITION || str == NAMESPACE.RML_JOIN_CONDITION
		) {
			return true
		}
		return false
	}
	protected static def boolean isLogicalSource(String str) {
		return LogicalSource.isLogicalSource(str)
	}
	protected static def boolean isDCTermType(String str) {
		if (str == NAMESPACE.DCTERMS_TYPE) {
			return true
		}
		return false
	}
	protected static def boolean isEqualCondition(String str) {
		if (str == NAMESPACE.CRML_EQUAL_CONDITION) {
			return true
		}
		return false
	}
	static def boolean isLanguageMap(String str) {
		if (str == NAMESPACE.RR_LANGUAGE_MAP || 
			str == NAMESPACE.RML_LANGUAGE_MAP
		) {
			return true
		}
		return false
	}
	static def boolean isLanguageTag(String str) {
		if (str == NAMESPACE.RR_LANGUAGE
		) {
			return true
		}
		return false
	}
	static def boolean isGraphMap(String str) {
		if (str == NAMESPACE.RR_GRAPH_MAP ||
			str == NAMESPACE.RR_GRAPH
		) {
			return true
		}
		return false
	}
	
	static def boolean isfunctionMaps(String str) {
		if (str == NAMESPACE.FNML_FUNCTION_VALUE) {
			return true
		}
		return false
	}
	
	static def boolean isCondition(String str) {
		if (str == NAMESPACE.RML_CONDITION) {
			return true
		}
		return false
	}
	
	static def boolean isFallbackMap(String str) {
		if (str == NAMESPACE.CRML_FALLBACK_MAP) {
			return true
		}
		return false
	}
	static def boolean isBooleanCondition(String str) {
		if (str == NAMESPACE.CRML_BOOLEAN_CONDITION) {
			return true
		}
		return false
	}
	static def boolean isProcessCondition(String str) {
		if (str == NAMESPACE.CRML_PROCESS_CONDITION) {
			return true
		}
		return false
	}
	static def boolean isParentTermMap(String str) {
		if (str == NAMESPACE.RML_PARENT_TERM_MAP) {
			return true
		}
		return false
	}
	
	static def String getObjectList(ObjectList ol) {
		var str = ""
		for(o : ol.objects) {
			str += o.getObject + ","	
		}
		return str.substring(0, str.length-1)
	}
	
	protected static def String getObject(Object object) {
		if (object.resource !== null) {
			return object.resource.getResource
		}
		else if (object.blank !== null) {
			return object.blank.getBlank	
		}
		else if (object.literal !== null) {
			return object.literal.getLiteral
		}
	}
	
	protected static def String getVerb(Verb verb) {
		if (verb.isA) {
			return 'a'
		}
		else{
			return verb.predicate.getResource
		}
	}
	
	protected static def String getLiteral(Literal literal) {
		var str = ""
		if (literal.languageString !== null) {
			str = literal.languageString.getLanguageString
		}
		else if (literal.datatypeString !== null) {
			str = literal.datatypeString.getDatatypeString
		}
		else if (literal.real !== null) {
			str = literal.real.toString()
		}
		else if (literal.decimal !== null) {
			str = literal.decimal.toString()
		}
		else if (literal.bool !== null) {
			str = literal.bool.toString()
		}
		else{
			//int
			str = literal.dword.toString()
		}

		return str.TrimName
	}
	
	static def r2pencode(String str) {
		var result = str
		result = StringEscapeUtils.escapeXml(result);
		result = StringEscapeUtils.escapeJava(result);
		return result
	}
	
	static def r2pdecode(String str) {
		var result = str
		result = StringEscapeUtils.unescapeJava(result);
		result = StringEscapeUtils.unescapeXml(result);
		return result
	}
	
	static def getDatatypeString(DatatypeString datatype) {
		return datatype.qutoedString + '^^' + datatype.resource.getResource
	}
	
	static def TrimName(String name) {
		var str = name.trim()
		//str = str.replaceAll("^(<|\")#?(.*)(>|\")$","$2")
		str = str.replaceAll('"""','').replaceAll('\\\\','')
		str = str.replaceAll('\\\\(")','$1').replaceAll('[\\f\\n\\r\\t\\v]', ' ').replaceAll(' +', ' ');
		str = str.trim()
		return str.r2pencode
	}
	
	static def getSubject(Subject subject) {
		if (subject.resource !== null) {
			return subject.resource.getResource
		}
		else if (subject.blank !== null){
			return subject.blank.getBlank
		}
	}
	
	protected static def getBlank(Blank blank) {
		if (blank.nodeID !== null) {
			return blank.nodeID.getNodeID
		}
		else if (blank.isSquare) {
			return '[]'
		}
		else if (blank.predicateObjectList !== null) {
			//Do nothing
		}
		else if (blank.collection !== null) {
			//Do nothing
		}
	}
	
	protected static def getResource(iResource r){
		if (r.uriRef !== null) {
			return r.uriRef.TrimName
		}
		else if (r.qname !== null) {
			return r.qname.getQname
		}
	}
	
	static def String getQname(Qname qname) {
		var str = ""
		if (qname.prefixName !== null) {
//			var longNS = NAMESPACE.NSMapping(qname.prefixName);
//			if (longNS !== null) {
//				str = longNS
//			}
//			else{
			str = qname.prefixName
			//}
		}
		if (qname.name !== null) {
			str += qname.name
		}
		//Abbreviated form to the complete form.
			
		return str
	}
	
	protected static def getLanguageString(LanguageString l) {
		var str=l.qutoedString 
		if (l.lang !== null) {
			str += '@' + l.lang 
		}
		return  str
	}
	
	protected static def getNodeID(NodeID node) {
		return '_:' + node.name
	}
	
	protected static def getProperty(String p) {
		return p.TrimName
	}
	
	public static def IsURI(String uri) {
        var regexUri = "^([a-z][a-z0-9+.-]*):.*";
        return Pattern.matches(regexUri, uri);
    }
}