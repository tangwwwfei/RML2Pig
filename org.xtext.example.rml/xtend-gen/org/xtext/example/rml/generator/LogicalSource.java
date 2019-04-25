package org.xtext.example.rml.generator;

import com.google.common.base.Objects;
import java.net.URLEncoder;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.xtext.example.rml.generator.DataRetrieval;
import org.xtext.example.rml.generator.Helper;
import org.xtext.example.rml.generator.IRMLGenerator;
import org.xtext.example.rml.generator.NAMESPACE;
import org.xtext.example.rml.iRML.Blank;
import org.xtext.example.rml.iRML.Literal;
import org.xtext.example.rml.iRML.PredicateObject;
import org.xtext.example.rml.iRML.Triples;
import org.xtext.example.rml.iRML.Verb;
import org.xtext.example.rml.iRML.iResource;

@SuppressWarnings("all")
public class LogicalSource {
  public static String parseLogicalSource(final Triples triple) {
    try {
      String str = "";
      String uriRef = "";
      boolean isLogicalSource = false;
      String source = "";
      EList<PredicateObject> poList = triple.getPredicateObjectList().getPredicateObjects();
      for (final PredicateObject po : poList) {
        {
          String verb = LogicalSource.getVerb(po.getVerb());
          org.xtext.example.rml.iRML.Object object = po.getObjectList().getObjects().get(0);
          if ((!isLogicalSource)) {
            boolean _equals = Objects.equal(verb, "a");
            if (_equals) {
              String objectString = LogicalSource.getObject(object);
              boolean _equals_1 = Objects.equal(objectString, NAMESPACE.RML_LOGICAL_SOURCE);
              if (_equals_1) {
                isLogicalSource = true;
              }
            } else {
              boolean _isLogicalSource = LogicalSource.isLogicalSource(verb);
              if (_isLogicalSource) {
                isLogicalSource = true;
                iResource _resource = object.getResource();
                boolean _tripleNotEquals = (_resource != null);
                if (_tripleNotEquals) {
                  Triples tri = IRMLGenerator.getTripleByName(LogicalSource.getResource(object.getResource()));
                  if ((tri != null)) {
                    poList = tri.getPredicateObjectList().getPredicateObjects();
                    source = DataRetrieval.dispatchDataSource(triple.getPredicateObjectList());
                  } else {
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append(" ");
                    _builder.append("uriRef=\"");
                    String _resource_1 = LogicalSource.getResource(object.getResource());
                    _builder.append(_resource_1, " ");
                    _builder.append("\"");
                    uriRef = _builder.toString();
                  }
                } else {
                  Blank _blank = object.getBlank();
                  boolean _tripleNotEquals_1 = (_blank != null);
                  if (_tripleNotEquals_1) {
                    poList = object.getBlank().getPredicateObjectList().getPredicateObjects();
                  } else {
                    Literal _literal = object.getLiteral();
                    boolean _tripleNotEquals_2 = (_literal != null);
                    if (_tripleNotEquals_2) {
                      throw new Exception("syntax error.");
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (isLogicalSource) {
        String iterator = "";
        String refer = "";
        String query = "";
        String sqlversion = "";
        String tableName = "";
        for (final PredicateObject po_1 : poList) {
          {
            String verb = LogicalSource.getVerb(po_1.getVerb());
            EList<org.xtext.example.rml.iRML.Object> objects = po_1.getObjectList().getObjects();
            boolean _isSource = LogicalSource.isSource(verb);
            if (_isSource) {
              source = DataRetrieval.dispatchDataSource(po_1.getObjectList());
            } else {
              boolean _isIterator = LogicalSource.isIterator(verb);
              if (_isIterator) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append(" ");
                _builder.append("iterator=\"");
                String _object = LogicalSource.getObject(objects.get(0));
                _builder.append(_object, " ");
                _builder.append("\"");
                iterator = _builder.toString();
              } else {
                boolean _isReferenceFormulation = LogicalSource.isReferenceFormulation(verb);
                if (_isReferenceFormulation) {
                  StringConcatenation _builder_1 = new StringConcatenation();
                  _builder_1.append(" ");
                  _builder_1.append("referenceFormulation=\"");
                  String _object_1 = LogicalSource.getObject(objects.get(0));
                  _builder_1.append(_object_1, " ");
                  _builder_1.append("\"");
                  refer = _builder_1.toString();
                } else {
                  boolean _isQuery = LogicalSource.isQuery(verb);
                  if (_isQuery) {
                    StringConcatenation _builder_2 = new StringConcatenation();
                    _builder_2.append(" ");
                    _builder_2.append("query=\"");
                    String _encode = URLEncoder.encode(LogicalSource.decode(LogicalSource.getObject(objects.get(0))), "utf-8");
                    _builder_2.append(_encode, " ");
                    _builder_2.append("\"");
                    query = _builder_2.toString();
                  } else {
                    boolean _isSqlVersion = LogicalSource.isSqlVersion(verb);
                    if (_isSqlVersion) {
                      StringConcatenation _builder_3 = new StringConcatenation();
                      _builder_3.append(" ");
                      _builder_3.append("sqlVersion=\"");
                      String _object_2 = LogicalSource.getObject(objects.get(0));
                      _builder_3.append(_object_2, " ");
                      _builder_3.append("\"");
                      sqlversion = _builder_3.toString();
                    } else {
                      boolean _isTableName = LogicalSource.isTableName(verb);
                      if (_isTableName) {
                        StringConcatenation _builder_4 = new StringConcatenation();
                        _builder_4.append(" ");
                        _builder_4.append("tableName=\"");
                        String _object_3 = LogicalSource.getObject(objects.get(0));
                        _builder_4.append(_object_3, " ");
                        _builder_4.append("\"");
                        tableName = _builder_4.toString();
                      }
                    }
                  }
                }
              }
            }
          }
        }
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<logicalSource ");
        _builder.append(uriRef);
        _builder.append(iterator);
        _builder.append(refer);
        _builder.append(query);
        _builder.append(sqlversion);
        _builder.append(tableName);
        _builder.append(">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(source, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("</logicalSource>");
        _builder.newLine();
        str = _builder.toString();
      }
      return str;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static boolean isQuery(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RML_QUERY);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isSqlVersion(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RR_SQL_VERSION);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isReferenceFormulation(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RML_REFERENCE_FORMULATION);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isTableName(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RR_TABLE_NAME);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isIterator(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RML_ITERATOR);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public static boolean isSource(final String str) {
    if (((Objects.equal(str, NAMESPACE.RML_SOURCE) || 
      Objects.equal(str, NAMESPACE.RML_NAME)) || 
      Objects.equal(str, NAMESPACE.RML_SOURCE_NAME))) {
      return true;
    }
    return false;
  }
  
  public static boolean isLogicalSource(final String str) {
    boolean _equals = Objects.equal(str, NAMESPACE.RML_LOGICAL_SOURCE);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  protected static String decode(final String str) {
    return Helper.decode(str);
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
