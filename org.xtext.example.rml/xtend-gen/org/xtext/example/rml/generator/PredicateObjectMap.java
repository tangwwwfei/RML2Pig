package org.xtext.example.rml.generator;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.xtext.example.rml.generator.Helper;
import org.xtext.example.rml.generator.NAMESPACE;
import org.xtext.example.rml.iRML.ObjectList;
import org.xtext.example.rml.iRML.PredicateObject;
import org.xtext.example.rml.iRML.PredicateObjectList;
import org.xtext.example.rml.iRML.Triples;
import org.xtext.example.rml.iRML.Verb;
import org.xtext.example.rml.iRML.iResource;

@SuppressWarnings("all")
public class PredicateObjectMap {
  public static String DispatchTermMap(final Triples triple) {
    return null;
  }
  
  public static String parsePredicateObjectMap(final Triples triple, final String owner) {
    String str = "";
    PredicateObjectList poList = triple.getPredicateObjectList();
    EList<PredicateObject> _predicateObjects = poList.getPredicateObjects();
    for (final PredicateObject po : _predicateObjects) {
      {
        String verb = PredicateObjectMap.getVerb(po.getVerb());
        org.xtext.example.rml.iRML.Object object = po.getObjectList().getObjects().get(0);
        boolean _equals = Objects.equal(verb, "a");
        if (_equals) {
          String objectString = Helper.getObject(object);
          boolean _isPredicateObjectMap = PredicateObjectMap.isPredicateObjectMap(objectString);
          if (_isPredicateObjectMap) {
            String _str = str;
            String _parseCommonMap = Helper.parseCommonMap(po.getObjectList(), "predicateObjectMaps", null, owner);
            str = (_str + _parseCommonMap);
          }
        } else {
          boolean _isPredicateObjectMap_1 = PredicateObjectMap.isPredicateObjectMap(verb);
          if (_isPredicateObjectMap_1) {
            String _str_1 = str;
            String _parseCommonMap_1 = Helper.parseCommonMap(po.getObjectList(), "predicateObjectMaps", null, owner);
            str = (_str_1 + _parseCommonMap_1);
          }
        }
        String _str_2 = str;
        str = (_str_2 + "\r\n");
      }
    }
    return str.trim();
  }
  
  protected static boolean isPredicateObjectMap(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RR_PREDICATE_OBJECT_MAP);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  protected static boolean isPredicateMap(final String str) {
    if ((Objects.equal(str, NAMESPACE.RR_PREDICATE_MAP) || 
      Objects.equal(str, NAMESPACE.RR_PREDICATE))) {
      return true;
    }
    return false;
  }
  
  protected static boolean isObjectMap(final String str) {
    if ((Objects.equal(str, NAMESPACE.RR_OBJECT_MAP) || 
      Objects.equal(str, NAMESPACE.RR_OBJECT))) {
      return true;
    }
    return false;
  }
  
  protected static boolean isRefObjectMap(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RR_OBJECT_MAP);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isProcessCondition(final String str) {
    return Helper.isProcessCondition(str);
  }
  
  public static boolean isParentTermMap(final String str) {
    return Helper.isParentTermMap(str);
  }
  
  protected static boolean isDCTermType(final String str) {
    return Helper.isDCTermType(str);
  }
  
  protected static boolean isGraphMap(final String str) {
    return Helper.isGraphMap(str);
  }
  
  protected static boolean isFunctionMaps(final String str) {
    return Helper.isfunctionMaps(str);
  }
  
  protected static boolean isEqualCondition(final String str) {
    return Helper.isEqualCondition(str);
  }
  
  protected static String getResource(final iResource r) {
    return Helper.getResource(r);
  }
  
  public static String getObjectList(final ObjectList ol) {
    return Helper.getObjectList(ol);
  }
  
  protected static String getObject(final org.xtext.example.rml.iRML.Object obj) {
    return Helper.getObject(obj);
  }
  
  protected static String getVerb(final Verb verb) {
    return Helper.getVerb(verb);
  }
}
