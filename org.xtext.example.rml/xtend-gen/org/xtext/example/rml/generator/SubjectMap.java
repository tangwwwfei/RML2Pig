package org.xtext.example.rml.generator;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.xtext.example.rml.generator.Helper;
import org.xtext.example.rml.generator.NAMESPACE;
import org.xtext.example.rml.iRML.PredicateObject;
import org.xtext.example.rml.iRML.PredicateObjectList;
import org.xtext.example.rml.iRML.Triples;
import org.xtext.example.rml.iRML.Verb;
import org.xtext.example.rml.iRML.iResource;

@SuppressWarnings("all")
public class SubjectMap {
  public static String parseSubjectMap(final Triples triple) {
    String str = "";
    boolean isSubjectMap = false;
    PredicateObjectList poList = triple.getPredicateObjectList();
    EList<PredicateObject> _predicateObjects = poList.getPredicateObjects();
    for (final PredicateObject po : _predicateObjects) {
      {
        String verb = SubjectMap.getVerb(po.getVerb());
        org.xtext.example.rml.iRML.Object object = po.getObjectList().getObjects().get(0);
        if ((!isSubjectMap)) {
          boolean _equals = Objects.equal(verb, "a");
          if (_equals) {
            String objectString = Helper.getObject(object);
            boolean _isSubjectMap = SubjectMap.isSubjectMap(objectString);
            if (_isSubjectMap) {
              String _str = str;
              String _parseCommonMap = Helper.parseCommonMap(po.getObjectList(), "subjectMap", null, null);
              str = (_str + _parseCommonMap);
            }
          } else {
            boolean _isSubjectMap_1 = SubjectMap.isSubjectMap(verb);
            if (_isSubjectMap_1) {
              String _str_1 = str;
              String _parseCommonMap_1 = Helper.parseCommonMap(po.getObjectList(), "subjectMap", null, null);
              str = (_str_1 + _parseCommonMap_1);
            }
          }
        }
      }
    }
    return str;
  }
  
  public static boolean isClass(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RR_CLASS);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isSubjectMap(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RR_SUBJECT_MAP);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isGraphMap(final String str) {
    return Helper.isGraphMap(str);
  }
  
  public static boolean isFunctionMaps(final String str) {
    return Helper.isfunctionMaps(str);
  }
  
  public static boolean isCondition(final String str) {
    return Helper.isCondition(str);
  }
  
  protected static String getResource(final iResource r) {
    return Helper.getResource(r);
  }
  
  protected static String getObject(final org.xtext.example.rml.iRML.Object obj) {
    return Helper.getObject(obj);
  }
  
  protected static String getVerb(final Verb verb) {
    return Helper.getVerb(verb);
  }
}
