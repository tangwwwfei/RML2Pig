package org.xtext.example.rml.generator;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.xtext.example.rml.generator.IRMLGenerator;
import org.xtext.example.rml.generator.LogicalSource;
import org.xtext.example.rml.generator.NAMESPACE;
import org.xtext.example.rml.iRML.Blank;
import org.xtext.example.rml.iRML.Collection;
import org.xtext.example.rml.iRML.DatatypeString;
import org.xtext.example.rml.iRML.LanguageString;
import org.xtext.example.rml.iRML.Literal;
import org.xtext.example.rml.iRML.NodeID;
import org.xtext.example.rml.iRML.ObjectList;
import org.xtext.example.rml.iRML.PredicateObject;
import org.xtext.example.rml.iRML.PredicateObjectList;
import org.xtext.example.rml.iRML.Qname;
import org.xtext.example.rml.iRML.Subject;
import org.xtext.example.rml.iRML.Triples;
import org.xtext.example.rml.iRML.Verb;
import org.xtext.example.rml.iRML.iResource;

@SuppressWarnings("all")
public final class Helper {
  public static String parseClass() {
    return null;
  }
  
  public static String parseProperties() {
    return null;
  }
  
  public static String parseTermMap(final PredicateObjectList predicateObjectList) {
    String refer = "";
    String constant = "";
    String template = "";
    String datatype = "";
    String termtype = "";
    EList<PredicateObject> _predicateObjects = predicateObjectList.getPredicateObjects();
    for (final PredicateObject pol : _predicateObjects) {
      {
        String verb = Helper.getVerb(pol.getVerb());
        EList<org.xtext.example.rml.iRML.Object> objects = pol.getObjectList().getObjects();
        boolean _equals = Objects.equal(verb, NAMESPACE.RML_REFERENCE);
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("<reference value=\"");
          String _object = Helper.getObject(objects.get(0));
          _builder.append(_object);
          _builder.append("\"/>");
          refer = _builder.toString();
        } else {
          boolean _equals_1 = Objects.equal(verb, NAMESPACE.RR_CONSTANT);
          if (_equals_1) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("<constant value=\"");
            String _object_1 = Helper.getObject(objects.get(0));
            _builder_1.append(_object_1);
            _builder_1.append("\"/>");
            constant = _builder_1.toString();
          } else {
            boolean _equals_2 = Objects.equal(verb, NAMESPACE.RR_TEMPLATE);
            if (_equals_2) {
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("<template value=\"");
              String _object_2 = Helper.getObject(objects.get(0));
              _builder_2.append(_object_2);
              _builder_2.append("\"/>");
              template = _builder_2.toString();
            } else {
              boolean _equals_3 = Objects.equal(verb, NAMESPACE.RR_DATATYPE);
              if (_equals_3) {
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append("<datatype value=\"");
                String _object_3 = Helper.getObject(objects.get(0));
                _builder_3.append(_object_3);
                _builder_3.append("\"/>");
                datatype = _builder_3.toString();
              } else {
                boolean _equals_4 = Objects.equal(verb, NAMESPACE.RR_TERM_TYPE);
                if (_equals_4) {
                  StringConcatenation _builder_4 = new StringConcatenation();
                  _builder_4.append("<termtype value=\"");
                  String _object_4 = Helper.getObject(objects.get(0));
                  _builder_4.append(_object_4);
                  _builder_4.append("\"/>");
                  termtype = _builder_4.toString();
                } else {
                }
              }
            }
          }
        }
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(refer);
    _builder.newLineIfNotEmpty();
    _builder.append(constant);
    _builder.newLineIfNotEmpty();
    _builder.append(template);
    _builder.newLineIfNotEmpty();
    _builder.append(datatype);
    _builder.newLineIfNotEmpty();
    _builder.append(termtype);
    _builder.newLineIfNotEmpty();
    String str = _builder.toString();
    return str;
  }
  
  public static String parseCommonMap(final PredicateObjectList pol, final String termName, final String owner) {
    String str = "";
    String ls = "";
    String sm = "";
    String classes = "";
    String pom = "";
    String graphMap = "";
    String termMap = "";
    String functionMaps = "";
    String dctermType = "";
    String parentTermMap = "";
    String processCondition = "";
    String condition = "";
    String parentTriplesMap = "";
    String joinCondition = "";
    String parent = "";
    String child = "";
    String predicateMap = "";
    String refObjectMap = "";
    String objectMap = "";
    String crmlCondition = "";
    String crmlBinding = "";
    String crmlVariable = "";
    String equalCondition = "";
    String fallbackMap = "";
    String boolCondition = "";
    String langMap = "";
    String ownTriplesMap = "";
    String functionTriplesMap = "";
    EList<PredicateObject> _predicateObjects = pol.getPredicateObjects();
    for (final PredicateObject po : _predicateObjects) {
      {
        String verb = Helper.getVerb(po.getVerb());
        boolean _isLogicalSource = Helper.isLogicalSource(verb);
        if (_isLogicalSource) {
          ls = Helper.parseCommonMap(po.getObjectList(), "logicalSource", null, owner);
        } else {
          boolean _isSubjectMap = Helper.isSubjectMap(verb);
          if (_isSubjectMap) {
            String _sm = sm;
            String _parseCommonMap = Helper.parseCommonMap(po.getObjectList(), "subjectMap", null, owner);
            sm = (_sm + _parseCommonMap);
          } else {
            boolean _isPredicateObjectMap = Helper.isPredicateObjectMap(verb);
            if (_isPredicateObjectMap) {
              String _pom = pom;
              String _parseCommonMap_1 = Helper.parseCommonMap(po.getObjectList(), "predicateObjectMaps", null, owner);
              pom = (_pom + _parseCommonMap_1);
              ownTriplesMap = owner;
            } else {
              boolean _isPredicateMap = Helper.isPredicateMap(verb);
              if (_isPredicateMap) {
                String _predicateMap = predicateMap;
                String _parseCommonMap_2 = Helper.parseCommonMap(po.getObjectList(), "predicateMaps", "predicates", owner);
                predicateMap = (_predicateMap + _parseCommonMap_2);
                ownTriplesMap = owner;
              } else {
                boolean _isObjectMap = Helper.isObjectMap(verb);
                if (_isObjectMap) {
                  String _objectMap = objectMap;
                  String _parseCommonMap_3 = Helper.parseCommonMap(po.getObjectList(), "objectMaps", "objects", owner);
                  objectMap = (_objectMap + _parseCommonMap_3);
                  ownTriplesMap = owner;
                } else {
                  boolean _isRefObjectMap = Helper.isRefObjectMap(verb);
                  if (_isRefObjectMap) {
                    String _refObjectMap = refObjectMap;
                    String _parseCommonMap_4 = Helper.parseCommonMap(po.getObjectList(), "refObjectMaps", "refObjecets", owner);
                    refObjectMap = (_refObjectMap + _parseCommonMap_4);
                    ownTriplesMap = owner;
                  } else {
                    boolean _isGraphMap = Helper.isGraphMap(verb);
                    if (_isGraphMap) {
                      String _graphMap = graphMap;
                      String _parseCommonMap_5 = Helper.parseCommonMap(po.getObjectList(), "graphMaps", "graphs", owner);
                      graphMap = (_graphMap + _parseCommonMap_5);
                    } else {
                      boolean _isDCTermType = Helper.isDCTermType(verb);
                      if (_isDCTermType) {
                        StringConcatenation _builder = new StringConcatenation();
                        _builder.append(" ");
                        _builder.append("dctermType=\"");
                        String _objectList = Helper.getObjectList(po.getObjectList());
                        _builder.append(_objectList, " ");
                        _builder.append("\"");
                        dctermType = _builder.toString();
                      } else {
                        boolean _isfunctionMaps = Helper.isfunctionMaps(verb);
                        if (_isfunctionMaps) {
                          org.xtext.example.rml.iRML.Object object = po.getObjectList().getObjects().get(0);
                          iResource _resource = object.getResource();
                          boolean _tripleNotEquals = (_resource != null);
                          if (_tripleNotEquals) {
                            StringConcatenation _builder_1 = new StringConcatenation();
                            _builder_1.append(" ");
                            _builder_1.append("functionTriplesMap=\"");
                            String _object = Helper.getObject(object);
                            _builder_1.append(_object, " ");
                            _builder_1.append("\"");
                            functionTriplesMap = _builder_1.toString();
                          }
                          String tmp = Helper.parseCommonMap(po.getObjectList(), "functionMaps", null, owner);
                          String _functionMaps = functionMaps;
                          String _replaceAll = tmp.replaceAll("^<functionMaps", ("<functionMaps" + functionTriplesMap));
                          functionMaps = (_functionMaps + _replaceAll);
                        } else {
                          boolean _isParentTermMap = Helper.isParentTermMap(verb);
                          if (_isParentTermMap) {
                            String _parentTermMap = parentTermMap;
                            String _parseCommonMap_6 = Helper.parseCommonMap(po.getObjectList(), "parentTermMap", null, owner);
                            parentTermMap = (_parentTermMap + _parseCommonMap_6);
                          } else {
                            boolean _isProcessCondition = Helper.isProcessCondition(verb);
                            if (_isProcessCondition) {
                              String _processCondition = processCondition;
                              String _parseCommonMap_7 = Helper.parseCommonMap(po.getObjectList(), "processCondition", null, owner);
                              processCondition = (_processCondition + _parseCommonMap_7);
                            } else {
                              boolean _isCondition = Helper.isCondition(verb);
                              if (_isCondition) {
                                String _condition = condition;
                                String _parseCommonMap_8 = Helper.parseCommonMap(po.getObjectList(), "condition", null, owner);
                                condition = (_condition + _parseCommonMap_8);
                              } else {
                                boolean _isJoinCondition = Helper.isJoinCondition(verb);
                                if (_isJoinCondition) {
                                  String _joinCondition = joinCondition;
                                  String _parseCommonMap_9 = Helper.parseCommonMap(po.getObjectList(), "joinConditions", null, owner);
                                  joinCondition = (_joinCondition + _parseCommonMap_9);
                                } else {
                                  boolean _isParentTriplesMap = Helper.isParentTriplesMap(verb);
                                  if (_isParentTriplesMap) {
                                    StringConcatenation _builder_2 = new StringConcatenation();
                                    _builder_2.append(" ");
                                    _builder_2.append("parentTriplesMap=\"");
                                    String _objectList_1 = Helper.getObjectList(po.getObjectList());
                                    _builder_2.append(_objectList_1, " ");
                                    _builder_2.append("\"");
                                    parentTriplesMap = _builder_2.toString();
                                  } else {
                                    boolean _isParent = Helper.isParent(verb);
                                    if (_isParent) {
                                      StringConcatenation _builder_3 = new StringConcatenation();
                                      _builder_3.append(" ");
                                      _builder_3.append("parent=\"");
                                      String _objectList_2 = Helper.getObjectList(po.getObjectList());
                                      _builder_3.append(_objectList_2, " ");
                                      _builder_3.append("\"");
                                      parent = _builder_3.toString();
                                    } else {
                                      boolean _isChild = Helper.isChild(verb);
                                      if (_isChild) {
                                        StringConcatenation _builder_4 = new StringConcatenation();
                                        _builder_4.append(" ");
                                        _builder_4.append("child=\"");
                                        String _objectList_3 = Helper.getObjectList(po.getObjectList());
                                        _builder_4.append(_objectList_3, " ");
                                        _builder_4.append("\"");
                                        child = _builder_4.toString();
                                      } else {
                                        boolean _isCrmlCondition = Helper.isCrmlCondition(verb);
                                        if (_isCrmlCondition) {
                                          crmlCondition = Helper.parseCommonMap(po.getObjectList(), "condition", null, owner);
                                        } else {
                                          boolean _isCrmlBinding = Helper.isCrmlBinding(verb);
                                          if (_isCrmlBinding) {
                                            crmlBinding = Helper.parseCommonMap(po.getObjectList(), "binding", null, owner);
                                          } else {
                                            boolean _isCrmlVariable = Helper.isCrmlVariable(verb);
                                            if (_isCrmlVariable) {
                                              crmlVariable = Helper.parseCommonMap(po.getObjectList(), "variable", null, owner);
                                            } else {
                                              boolean _isFallbackMap = Helper.isFallbackMap(verb);
                                              if (_isFallbackMap) {
                                                fallbackMap = Helper.parseCommonMap(po.getObjectList(), "fallbackMaps", null, owner);
                                              } else {
                                                boolean _isBooleanCondition = Helper.isBooleanCondition(verb);
                                                if (_isBooleanCondition) {
                                                  String _boolCondition = boolCondition;
                                                  String _parseCommonMap_10 = Helper.parseCommonMap(po.getObjectList(), "booleanConditions", null, owner);
                                                  boolCondition = (_boolCondition + _parseCommonMap_10);
                                                } else {
                                                  boolean _isEqualCondition = Helper.isEqualCondition(verb);
                                                  if (_isEqualCondition) {
                                                    String _equalCondition = equalCondition;
                                                    String _parseCommonMap_11 = Helper.parseCommonMap(po.getObjectList(), "equalConditions", null, owner);
                                                    equalCondition = (_equalCondition + _parseCommonMap_11);
                                                  } else {
                                                    boolean _isClass = Helper.isClass(verb);
                                                    if (_isClass) {
                                                      String _classes = classes;
                                                      StringConcatenation _builder_5 = new StringConcatenation();
                                                      _builder_5.append("<class>");
                                                      String _objectList_4 = Helper.getObjectList(po.getObjectList());
                                                      _builder_5.append(_objectList_4);
                                                      _builder_5.append("</class>");
                                                      classes = (_classes + _builder_5);
                                                    } else {
                                                      boolean _isLanguageMap = Helper.isLanguageMap(verb);
                                                      if (_isLanguageMap) {
                                                        langMap = Helper.parseCommonMap(po.getObjectList(), "languageTag", null, owner);
                                                      } else {
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    termMap = Helper.parseTermMap(pol);
    if ((owner != null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append("ownTriplesMap=\"");
      _builder.append(owner, " ");
      _builder.append("\"");
      ownTriplesMap = _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<");
    _builder_1.append(termName);
    _builder_1.append(ownTriplesMap);
    _builder_1.append(dctermType);
    _builder_1.append(parentTriplesMap);
    _builder_1.append(parent);
    _builder_1.append(child);
    _builder_1.append(">");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(ls, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(sm, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(pom, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(predicateMap, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(refObjectMap, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(objectMap, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(termMap, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(classes, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(graphMap, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(functionMaps, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(parentTermMap, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(processCondition, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(crmlCondition, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(condition, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(crmlVariable, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(joinCondition, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(crmlBinding, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(equalCondition, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(fallbackMap, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(boolCondition, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append(langMap, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("</");
    _builder_1.append(termName);
    _builder_1.append(">");
    _builder_1.newLineIfNotEmpty();
    str = _builder_1.toString();
    return str;
  }
  
  public static String parseCommonMap(final ObjectList objectList, final String termName, final String shortName, final String owner) {
    String str = "";
    org.xtext.example.rml.iRML.Object obj = objectList.getObjects().get(0);
    boolean inside = false;
    EList<org.xtext.example.rml.iRML.Object> _objects = objectList.getObjects();
    for (final org.xtext.example.rml.iRML.Object o : _objects) {
      Blank _blank = obj.getBlank();
      boolean _tripleNotEquals = (_blank != null);
      if (_tripleNotEquals) {
        String _str = str;
        String _parseCommonMap = Helper.parseCommonMap(obj.getBlank().getPredicateObjectList(), termName, owner);
        str = (_str + _parseCommonMap);
      } else {
        iResource _resource = obj.getResource();
        boolean _tripleNotEquals_1 = (_resource != null);
        if (_tripleNotEquals_1) {
          String _uriRef = obj.getResource().getUriRef();
          boolean _tripleNotEquals_2 = (_uriRef != null);
          if (_tripleNotEquals_2) {
            Triples refTriple = IRMLGenerator.getTripleByName(Helper.getResource(obj.getResource()));
            if ((refTriple != null)) {
              String _str_1 = str;
              String _parseCommonMap_1 = Helper.parseCommonMap(refTriple.getPredicateObjectList(), termName, owner);
              str = (_str_1 + _parseCommonMap_1);
            } else {
              if ((shortName == null)) {
                inside = true;
                String _str_2 = str;
                String _resource_1 = Helper.getResource(obj.getResource());
                str = (_str_2 + _resource_1);
              } else {
                String _str_3 = str;
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("<");
                _builder.append(termName);
                _builder.append(">");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("<constant value=\"");
                String _resource_2 = Helper.getResource(obj.getResource());
                _builder.append(_resource_2, "\t");
                _builder.append("\"/>");
                _builder.newLineIfNotEmpty();
                _builder.append("</");
                _builder.append(termName);
                _builder.append(">");
                _builder.newLineIfNotEmpty();
                str = (_str_3 + _builder);
              }
            }
          } else {
            Triples refTriple_1 = IRMLGenerator.getTripleByName(Helper.getResource(obj.getResource()));
            if ((refTriple_1 != null)) {
              String _str_4 = str;
              String _parseCommonMap_2 = Helper.parseCommonMap(refTriple_1.getPredicateObjectList(), termName, owner);
              str = (_str_4 + _parseCommonMap_2);
            } else {
              if ((shortName == null)) {
                inside = true;
                String _str_5 = str;
                String _object = Helper.getObject(o);
                str = (_str_5 + _object);
              } else {
                String _str_6 = str;
                StringConcatenation _builder_1 = new StringConcatenation();
                _builder_1.append("<");
                _builder_1.append(termName);
                _builder_1.append(">");
                _builder_1.newLineIfNotEmpty();
                _builder_1.append("\t");
                _builder_1.append("<constant value=\"");
                String _object_1 = Helper.getObject(o);
                _builder_1.append(_object_1, "\t");
                _builder_1.append("\"/>");
                _builder_1.newLineIfNotEmpty();
                _builder_1.append("</");
                _builder_1.append(termName);
                _builder_1.append(">");
                _builder_1.newLineIfNotEmpty();
                str = (_str_6 + _builder_1);
              }
            }
          }
        } else {
          if ((shortName == null)) {
            inside = true;
            String _str_7 = str;
            String _literal = Helper.getLiteral(obj.getLiteral());
            str = (_str_7 + _literal);
          } else {
            String _str_8 = str;
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("<");
            _builder_2.append(termName);
            _builder_2.append(">");
            _builder_2.newLineIfNotEmpty();
            _builder_2.append("\t");
            _builder_2.append("<constant value=\"");
            String _literal_1 = Helper.getLiteral(obj.getLiteral());
            _builder_2.append(_literal_1, "\t");
            _builder_2.append("\"/>");
            _builder_2.newLineIfNotEmpty();
            _builder_2.append("</");
            _builder_2.append(termName);
            _builder_2.append(">");
            _builder_2.newLineIfNotEmpty();
            str = (_str_8 + _builder_2);
          }
        }
      }
    }
    str = str.trim();
    if (inside) {
      if ((shortName == null)) {
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("<");
        _builder_3.append(termName);
        _builder_3.append(">");
        _builder_3.append(str);
        _builder_3.append("</");
        _builder_3.append(termName);
        _builder_3.append(">");
        return _builder_3.toString();
      }
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("<");
      _builder_4.append(termName);
      _builder_4.append(">");
      _builder_4.newLineIfNotEmpty();
      _builder_4.append("\t");
      _builder_4.append(str, "\t");
      _builder_4.newLineIfNotEmpty();
      _builder_4.append("</");
      _builder_4.append(termName);
      _builder_4.append(">");
      _builder_4.newLineIfNotEmpty();
      return _builder_4.toString();
    }
    return str;
  }
  
  public static boolean FindRefObjectMap(final EList<PredicateObject> poList) {
    for (final PredicateObject po : poList) {
      {
        String verb = Helper.getVerb(po.getVerb());
        org.xtext.example.rml.iRML.Object object = po.getObjectList().getObjects().get(0);
        boolean _equals = Objects.equal(verb, "a");
        if (_equals) {
          String objectString = Helper.getObject(object);
          boolean _isRefObjectMap = Helper.isRefObjectMap(objectString);
          if (_isRefObjectMap) {
            return true;
          }
        } else {
          boolean _isParentTriplesMap = Helper.isParentTriplesMap(verb);
          if (_isParentTriplesMap) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean FindRefObejctMap(final ObjectList ol) {
    org.xtext.example.rml.iRML.Object obj = ol.getObjects().get(0);
    Blank _blank = obj.getBlank();
    boolean _tripleNotEquals = (_blank != null);
    if (_tripleNotEquals) {
      return Helper.FindRefObjectMap(obj.getBlank().getPredicateObjectList().getPredicateObjects());
    } else {
      String refName = Helper.getResource(obj.getResource());
      Triples triple = IRMLGenerator.m_NameTriple.get(refName);
      if (((triple != null) && (triple.getPredicateObjectList() != null))) {
        return Helper.FindRefObjectMap(triple.getPredicateObjectList().getPredicateObjects());
      } else {
        return false;
      }
    }
  }
  
  public static boolean isClass(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RR_CLASS);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  protected static boolean isSubjectMap(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RR_SUBJECT_MAP);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  protected static boolean isRMLReference(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RML_REFERENCE);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  protected static boolean isCrmlCondition(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.CRML_CONDITION);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  protected static boolean isCrmlBinding(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.CRML_BINDING);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  protected static boolean isCrmlVariable(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.CRML_VARIABLE);
    if (_equals) {
      return true;
    }
    return false;
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
    boolean _equals = Objects.equal(str, NAMESPACE.RR_REF_OBJECT_MAP_CLASS);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  protected static boolean isParentTriplesMap(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RR_PARENT_TRIPLES_MAP);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  protected static boolean isParent(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RR_PARENT);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  protected static boolean isChild(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RR_CHILD);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  protected static boolean isJoinCondition(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RR_JOIN_CONDITION);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  protected static boolean isLogicalSource(final String str) {
    return LogicalSource.isLogicalSource(str);
  }
  
  protected static boolean isDCTermType(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.DCTERMS_TYPE);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  protected static boolean isEqualCondition(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.CRML_EQUAL_CONDITION);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isLanguageMap(final String str) {
    if (((Objects.equal(str, NAMESPACE.RR_LANGUAGE_MAP) || 
      Objects.equal(str, NAMESPACE.RR_LANGUAGE)) || 
      Objects.equal(str, NAMESPACE.RML_LANGUAGE_MAP))) {
      return true;
    }
    return false;
  }
  
  public static boolean isGraphMap(final String str) {
    if ((Objects.equal(str, NAMESPACE.RR_GRAPH_MAP) || 
      Objects.equal(str, NAMESPACE.RR_GRAPH))) {
      return true;
    }
    return false;
  }
  
  public static boolean isfunctionMaps(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.FNML_FUNCTION_VALUE);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isCondition(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RML_CONDITION);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isFallbackMap(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.CRML_FALLBACK_MAP);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isBooleanCondition(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.CRML_BOOLEAN_CONDITION);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isProcessCondition(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.CRML_PROCESS_CONDITION);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isParentTermMap(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RML_PARENT_TERM_MAP);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static String getObjectList(final ObjectList ol) {
    String str = "";
    EList<org.xtext.example.rml.iRML.Object> _objects = ol.getObjects();
    for (final org.xtext.example.rml.iRML.Object o : _objects) {
      String _str = str;
      String _object = Helper.getObject(o);
      String _plus = (_object + ",");
      str = (_str + _plus);
    }
    int _length = str.length();
    int _minus = (_length - 1);
    return str.substring(0, _minus);
  }
  
  protected static String getObject(final org.xtext.example.rml.iRML.Object object) {
    iResource _resource = object.getResource();
    boolean _tripleNotEquals = (_resource != null);
    if (_tripleNotEquals) {
      return Helper.getResource(object.getResource());
    } else {
      Blank _blank = object.getBlank();
      boolean _tripleNotEquals_1 = (_blank != null);
      if (_tripleNotEquals_1) {
        return Helper.getBlank(object.getBlank());
      } else {
        Literal _literal = object.getLiteral();
        boolean _tripleNotEquals_2 = (_literal != null);
        if (_tripleNotEquals_2) {
          return Helper.getLiteral(object.getLiteral());
        }
      }
    }
    return null;
  }
  
  protected static String getVerb(final Verb verb) {
    boolean _isIsA = verb.isIsA();
    if (_isIsA) {
      return "a";
    } else {
      return Helper.getResource(verb.getPredicate());
    }
  }
  
  protected static String getLiteral(final Literal literal) {
    String str = "";
    LanguageString _languageString = literal.getLanguageString();
    boolean _tripleNotEquals = (_languageString != null);
    if (_tripleNotEquals) {
      str = Helper.getLanguageString(literal.getLanguageString());
    } else {
      DatatypeString _datatypeString = literal.getDatatypeString();
      boolean _tripleNotEquals_1 = (_datatypeString != null);
      if (_tripleNotEquals_1) {
        str = Helper.getDatatypeString(literal.getDatatypeString());
      } else {
        String _real = literal.getReal();
        boolean _tripleNotEquals_2 = (_real != null);
        if (_tripleNotEquals_2) {
          str = literal.getReal().toString();
        } else {
          String _decimal = literal.getDecimal();
          boolean _tripleNotEquals_3 = (_decimal != null);
          if (_tripleNotEquals_3) {
            str = literal.getDecimal().toString();
          } else {
            String _bool = literal.getBool();
            boolean _tripleNotEquals_4 = (_bool != null);
            if (_tripleNotEquals_4) {
              str = literal.getBool().toString();
            } else {
              str = Integer.valueOf(literal.getDword()).toString();
            }
          }
        }
      }
    }
    return Helper.TrimName(str);
  }
  
  public static String encode(final String str) {
    String result = str.replaceAll("\"", "%22");
    result = result.replaceAll("<", "%3c");
    result = result.replaceAll(">", "%3e");
    return result;
  }
  
  public static String decode(final String str) {
    String result = str.replaceAll("%22", "\"");
    result = str.replaceAll("%3c", "<");
    result = result.replaceAll("%3e", ">");
    return result;
  }
  
  public static String getDatatypeString(final DatatypeString datatype) {
    String _qutoedString = datatype.getQutoedString();
    String _plus = (_qutoedString + "^^");
    String _resource = Helper.getResource(datatype.getResource());
    return (_plus + _resource);
  }
  
  public static String TrimName(final String name) {
    String str = name.trim();
    str = str.replaceAll("\"\"\"", "");
    str = str.trim();
    String result = str.replaceAll("^(<|\")#?(.*)(>|\")$", "$2");
    return Helper.encode(result);
  }
  
  public static String getSubject(final Subject subject) {
    iResource _resource = subject.getResource();
    boolean _tripleNotEquals = (_resource != null);
    if (_tripleNotEquals) {
      return Helper.getResource(subject.getResource());
    } else {
      Blank _blank = subject.getBlank();
      boolean _tripleNotEquals_1 = (_blank != null);
      if (_tripleNotEquals_1) {
        return Helper.getBlank(subject.getBlank());
      }
    }
    return null;
  }
  
  protected static String getBlank(final Blank blank) {
    Object _xifexpression = null;
    NodeID _nodeID = blank.getNodeID();
    boolean _tripleNotEquals = (_nodeID != null);
    if (_tripleNotEquals) {
      return Helper.getNodeID(blank.getNodeID());
    } else {
      Object _xifexpression_1 = null;
      boolean _isIsSquare = blank.isIsSquare();
      if (_isIsSquare) {
        return "[]";
      } else {
        Object _xifexpression_2 = null;
        PredicateObjectList _predicateObjectList = blank.getPredicateObjectList();
        boolean _tripleNotEquals_1 = (_predicateObjectList != null);
        if (_tripleNotEquals_1) {
          _xifexpression_2 = null;
        } else {
          Object _xifexpression_3 = null;
          Collection _collection = blank.getCollection();
          boolean _tripleNotEquals_2 = (_collection != null);
          if (_tripleNotEquals_2) {
            _xifexpression_3 = null;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return ((String)_xifexpression);
  }
  
  protected static String getResource(final iResource r) {
    String _uriRef = r.getUriRef();
    boolean _tripleNotEquals = (_uriRef != null);
    if (_tripleNotEquals) {
      return Helper.TrimName(r.getUriRef());
    } else {
      Qname _qname = r.getQname();
      boolean _tripleNotEquals_1 = (_qname != null);
      if (_tripleNotEquals_1) {
        return Helper.getQname(r.getQname());
      }
    }
    return null;
  }
  
  public static String getQname(final Qname qname) {
    String str = "";
    String _prefixName = qname.getPrefixName();
    boolean _tripleNotEquals = (_prefixName != null);
    if (_tripleNotEquals) {
      String _str = str;
      String _prefixName_1 = qname.getPrefixName();
      str = (_str + _prefixName_1);
    }
    String _name = qname.getName();
    boolean _tripleNotEquals_1 = (_name != null);
    if (_tripleNotEquals_1) {
      String _str_1 = str;
      String _name_1 = qname.getName();
      str = (_str_1 + _name_1);
    }
    return str;
  }
  
  protected static String getLanguageString(final LanguageString l) {
    String str = l.getQutoedString();
    String _lang = l.getLang();
    boolean _tripleNotEquals = (_lang != null);
    if (_tripleNotEquals) {
      String _str = str;
      String _lang_1 = l.getLang();
      String _plus = ("@" + _lang_1);
      str = (_str + _plus);
    }
    return Helper.TrimName(str);
  }
  
  protected static String getNodeID(final NodeID node) {
    String _name = node.getName();
    return ("_:" + _name);
  }
  
  protected static String getProperty(final String p) {
    return Helper.TrimName(p);
  }
}
