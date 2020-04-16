package org.xtext.r2ps.rml.generator

import org.xtext.r2ps.rml.rML.Object
import org.xtext.r2ps.rml.rML.ObjectList
import org.xtext.r2ps.rml.rML.Triples
import org.xtext.r2ps.rml.rML.Verb
import org.xtext.r2ps.rml.rML.iResource

class PredicateObjectMap {
	static def String DispatchTermMap(Triples triple) {
		
	}
	
	static def String parsePredicateObjectMap(Triples triple, String owner) {
		var str = ""
		var poList = triple.predicateObjectList
		for(po : poList.predicateObjects) {
			var verb = po.verb.getVerb
			var object = po.objectList.objects.get(0)
			if (verb == 'a') {
				var objectString = Helper.getObject(object)
				if (objectString.isPredicateObjectMap) {
					//this triple is a predicateObjectMap
					//'a' 'rr:LogicalSource
					str+=Helper.parseCommonMap(po.objectList, "predicateObjectMaps", null, owner)
 				}
			}
			else if (verb.isPredicateObjectMap) {
				str+=Helper.parseCommonMap(po.objectList, "predicateObjectMaps", null, owner)
			}
			str+="\r\n"
		}
		return str.trim
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
		if (str == NAMESPACE.RR_OBJECT_MAP) {
			//parentTriplesMap
			return true
		}
		return false
	}
	static def boolean isProcessCondition(String str) {
		return Helper.isProcessCondition(str)
	}
	static def boolean isParentTermMap(String str) {
		return Helper.isParentTermMap(str)
	}
	protected static def boolean isDCTermType(String str) {
		return Helper.isDCTermType(str)
	}
	protected static def boolean isGraphMap(String str) {
		return Helper.isGraphMap(str)
	}
	protected static def boolean isFunctionMaps(String str) {
		return Helper.isfunctionMaps(str)
	}
	protected static def boolean isEqualCondition(String str) {
		return Helper.isEqualCondition(str)
	}
	protected static def String getResource(iResource r) {
		return Helper.getResource(r)
	}
	static def String getObjectList(ObjectList ol) {
		return Helper.getObjectList(ol)
	}
	protected static def String getObject(Object obj) {
		return Helper.getObject(obj)
	}
	protected static def String getVerb(Verb verb) {
		return Helper.getVerb(verb)
	}
}