package org.xtext.r2ps.rml.generator

import org.xtext.r2ps.rml.rML.Triples
import org.xtext.r2ps.rml.rML.Object
import org.xtext.r2ps.rml.rML.iResource
import org.xtext.r2ps.rml.rML.Verb

class SubjectMap {
	static def String parseSubjectMap(Triples triple) {
		var str = ""
		var isSubjectMap = false
		var poList = triple.predicateObjectList
		for(po : poList.predicateObjects) {
			var verb = po.verb.getVerb
			var object = po.objectList.objects.get(0)
			if (!isSubjectMap) {
				if (verb == 'a') {
					var objectString = Helper.getObject(object)
					if (objectString.isSubjectMap) {
						//this triple is a logicalSource
						//'a' 'rr:LogicalSource
						str+=Helper.parseCommonMap(po.objectList, "subjectMap", null, null)
	 				}
				}
				else if (verb.isSubjectMap) {
					str+=Helper.parseCommonMap(po.objectList, "subjectMap", null, null)
				}
			}
		}
		return str
	}
	
	static def boolean isClass(String str) {
		if (str == NAMESPACE.RR_CLASS) {
			return true
		}
		return false
	}
	
	static def boolean isSubjectMap(String str) {
		if (str == NAMESPACE.RR_SUBJECT_MAP) {
			return true
		}
		return false
	}
	
	static def boolean isGraphMap(String str) {
		return Helper.isGraphMap(str)
	}
	
	static def boolean isFunctionMaps(String str) {
		return Helper.isfunctionMaps(str)
	}
	
	static def boolean isCondition(String str) {
		return Helper.isCondition(str)
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