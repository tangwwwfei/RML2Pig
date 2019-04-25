package org.xtext.example.rml.generator;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.xtext.example.rml.generator.Helper;
import org.xtext.example.rml.generator.IRMLGenerator;
import org.xtext.example.rml.generator.NAMESPACE;
import org.xtext.example.rml.iRML.Blank;
import org.xtext.example.rml.iRML.ObjectList;
import org.xtext.example.rml.iRML.PredicateObject;
import org.xtext.example.rml.iRML.PredicateObjectList;
import org.xtext.example.rml.iRML.Triples;
import org.xtext.example.rml.iRML.Verb;
import org.xtext.example.rml.iRML.iResource;

@SuppressWarnings("all")
public class DataRetrieval {
  public static String dispatchDataSource(final PredicateObjectList pol) {
    String str = "";
    String termName = "";
    EList<PredicateObject> _predicateObjects = pol.getPredicateObjects();
    for (final PredicateObject po : _predicateObjects) {
      {
        String verb = DataRetrieval.getVerb(po.getVerb());
        String compareString = verb;
        String object = DataRetrieval.getObjectList(po.getObjectList());
        boolean _equals = Objects.equal(verb, "a");
        if (_equals) {
          compareString = object;
        }
        boolean _isDcatDataset = DataRetrieval.isDcatDataset(compareString);
        if (_isDcatDataset) {
          termName = "dataset";
        } else {
          boolean _isHydraIriTemplate = DataRetrieval.isHydraIriTemplate(compareString);
          if (_isHydraIriTemplate) {
            termName = "webAPI";
          } else {
            boolean _isD2rqDatabase = DataRetrieval.isD2rqDatabase(compareString);
            if (_isD2rqDatabase) {
              termName = "database";
            } else {
              boolean _isSDService = DataRetrieval.isSDService(compareString);
              if (_isSDService) {
                termName = "sparql";
              } else {
                boolean _isCsvwTable = DataRetrieval.isCsvwTable(compareString);
                if (_isCsvwTable) {
                  termName = "csvonWeb";
                } else {
                  boolean _isHydraPagedCollection = DataRetrieval.isHydraPagedCollection(compareString);
                  if (_isHydraPagedCollection) {
                    termName = "pagedCollection";
                  } else {
                    boolean _isFnoFunction = DataRetrieval.isFnoFunction(compareString);
                    if (_isFnoFunction) {
                      termName = "function";
                    } else {
                      if ((DataRetrieval.isFnoParameter(compareString) || DataRetrieval.isFnoOutput(compareString))) {
                        termName = "paramter";
                      } else {
                        boolean _isDcatDistribution = DataRetrieval.isDcatDistribution(compareString);
                        if (_isDcatDistribution) {
                          termName = "distribution";
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
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<source>");
    _builder.newLine();
    _builder.append("\t");
    String _parseDataRetrieval = DataRetrieval.parseDataRetrieval(pol, termName);
    _builder.append(_parseDataRetrieval, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</source>");
    _builder.newLine();
    str = _builder.toString();
    return str;
  }
  
  public static String dispatchDataSource(final ObjectList ol) {
    String str = "";
    org.xtext.example.rml.iRML.Object obj = ol.getObjects().get(0);
    Blank _blank = obj.getBlank();
    boolean _tripleNotEquals = (_blank != null);
    if (_tripleNotEquals) {
      str = DataRetrieval.dispatchDataSource(obj.getBlank().getPredicateObjectList());
    } else {
      str = DataRetrieval.parseDataRetrieval(ol, "source", null);
    }
    return str;
  }
  
  public static String parseDataRetrieval(final PredicateObjectList pol, final String termName) {
    String str = "";
    String d2rqPassword = "";
    String d2rqUsername = "";
    String d2rqJdbcDriver = "";
    String d2rqJdbcDSN = "";
    String d2rqDatabase = "";
    String hydraDistribution = "";
    String hydraDownloadurl = "";
    String hydraTemplate = "";
    String hydraMapping = "";
    String hydraVariable = "";
    String hydraRequired = "";
    String hydraItemsPerPage = "";
    String hydraFirstPage = "";
    String hydraNextPage = "";
    String sdEndpoint = "";
    String sdResultFormat = "";
    String sdSupportedLanguage = "";
    String csvwTrim = "";
    String csvwHeaderRowCount = "";
    String csvwHeader = "";
    String csvwEnconding = "";
    String csvwDelimiter = "";
    String csvwDialect = "";
    String csvwUrl = "";
    EList<PredicateObject> _predicateObjects = pol.getPredicateObjects();
    for (final PredicateObject po : _predicateObjects) {
      {
        String verb = DataRetrieval.getVerb(po.getVerb());
        boolean _isDcatDistribution = DataRetrieval.isDcatDistribution(verb);
        if (_isDcatDistribution) {
          String _hydraDistribution = hydraDistribution;
          String _parseDataRetrieval = DataRetrieval.parseDataRetrieval(po.getObjectList(), "distribution", null);
          hydraDistribution = (_hydraDistribution + _parseDataRetrieval);
        } else {
          boolean _isDcatDataset = DataRetrieval.isDcatDataset(verb);
          if (_isDcatDataset) {
          } else {
            boolean _isDcatDownloadURL = DataRetrieval.isDcatDownloadURL(verb);
            if (_isDcatDownloadURL) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append(" ");
              _builder.append("downloadURL=\"");
              String _objectList = DataRetrieval.getObjectList(po.getObjectList());
              _builder.append(_objectList, " ");
              _builder.append("\"");
              hydraDownloadurl = _builder.toString();
            } else {
              boolean _isHydraIriTemplate = DataRetrieval.isHydraIriTemplate(verb);
              if (_isHydraIriTemplate) {
              } else {
                boolean _isHydraTemplate = DataRetrieval.isHydraTemplate(verb);
                if (_isHydraTemplate) {
                  StringConcatenation _builder_1 = new StringConcatenation();
                  _builder_1.append(" ");
                  _builder_1.append("template=\"");
                  String _objectList_1 = DataRetrieval.getObjectList(po.getObjectList());
                  _builder_1.append(_objectList_1, " ");
                  _builder_1.append("\"");
                  hydraTemplate = _builder_1.toString();
                } else {
                  boolean _isHydraMapping = DataRetrieval.isHydraMapping(verb);
                  if (_isHydraMapping) {
                    String _hydraMapping = hydraMapping;
                    String _parseDataRetrieval_1 = DataRetrieval.parseDataRetrieval(po.getObjectList(), "hydraMapping", null);
                    hydraMapping = (_hydraMapping + _parseDataRetrieval_1);
                  } else {
                    boolean _isHydraTemplateMapping = DataRetrieval.isHydraTemplateMapping(verb);
                    if (_isHydraTemplateMapping) {
                    } else {
                      boolean _isHydraVariable = DataRetrieval.isHydraVariable(verb);
                      if (_isHydraVariable) {
                        StringConcatenation _builder_2 = new StringConcatenation();
                        _builder_2.append(" ");
                        _builder_2.append("variable=\"");
                        String _objectList_2 = DataRetrieval.getObjectList(po.getObjectList());
                        _builder_2.append(_objectList_2, " ");
                        _builder_2.append("\"");
                        hydraVariable = _builder_2.toString();
                      } else {
                        boolean _isHydraRequired = DataRetrieval.isHydraRequired(verb);
                        if (_isHydraRequired) {
                          StringConcatenation _builder_3 = new StringConcatenation();
                          _builder_3.append(" ");
                          _builder_3.append("required=\"");
                          String _objectList_3 = DataRetrieval.getObjectList(po.getObjectList());
                          _builder_3.append(_objectList_3, " ");
                          _builder_3.append("\"");
                          hydraRequired = _builder_3.toString();
                        } else {
                          boolean _isHydraPagedCollection = DataRetrieval.isHydraPagedCollection(verb);
                          if (_isHydraPagedCollection) {
                          } else {
                            boolean _isHydraItemsPerPage = DataRetrieval.isHydraItemsPerPage(verb);
                            if (_isHydraItemsPerPage) {
                              StringConcatenation _builder_4 = new StringConcatenation();
                              _builder_4.append(" ");
                              _builder_4.append("itemsPerPage=\"");
                              String _objectList_4 = DataRetrieval.getObjectList(po.getObjectList());
                              _builder_4.append(_objectList_4, " ");
                              _builder_4.append("\"");
                              hydraItemsPerPage = _builder_4.toString();
                            } else {
                              boolean _isHydraFirstPage = DataRetrieval.isHydraFirstPage(verb);
                              if (_isHydraFirstPage) {
                                StringConcatenation _builder_5 = new StringConcatenation();
                                _builder_5.append(" ");
                                _builder_5.append("firstPage=\"");
                                String _objectList_5 = DataRetrieval.getObjectList(po.getObjectList());
                                _builder_5.append(_objectList_5, " ");
                                _builder_5.append("\"");
                                hydraFirstPage = _builder_5.toString();
                              } else {
                                boolean _isHydraNextPage = DataRetrieval.isHydraNextPage(verb);
                                if (_isHydraNextPage) {
                                  StringConcatenation _builder_6 = new StringConcatenation();
                                  _builder_6.append(" ");
                                  _builder_6.append("nextPage=\"");
                                  String _objectList_6 = DataRetrieval.getObjectList(po.getObjectList());
                                  _builder_6.append(_objectList_6, " ");
                                  _builder_6.append("\"");
                                  hydraNextPage = _builder_6.toString();
                                } else {
                                  boolean _isD2rqDatabase = DataRetrieval.isD2rqDatabase(verb);
                                  if (_isD2rqDatabase) {
                                    StringConcatenation _builder_7 = new StringConcatenation();
                                    _builder_7.append(" ");
                                    _builder_7.append("Database=\"");
                                    String _objectList_7 = DataRetrieval.getObjectList(po.getObjectList());
                                    _builder_7.append(_objectList_7, " ");
                                    _builder_7.append("\"");
                                    d2rqDatabase = _builder_7.toString();
                                  } else {
                                    boolean _isD2rqJdbcDSN = DataRetrieval.isD2rqJdbcDSN(verb);
                                    if (_isD2rqJdbcDSN) {
                                      StringConcatenation _builder_8 = new StringConcatenation();
                                      _builder_8.append(" ");
                                      _builder_8.append("jdbcDSN=\"");
                                      String _objectList_8 = DataRetrieval.getObjectList(po.getObjectList());
                                      _builder_8.append(_objectList_8, " ");
                                      _builder_8.append("\"");
                                      d2rqJdbcDSN = _builder_8.toString();
                                    } else {
                                      boolean _isD2rqJdbcDriver = DataRetrieval.isD2rqJdbcDriver(verb);
                                      if (_isD2rqJdbcDriver) {
                                        StringConcatenation _builder_9 = new StringConcatenation();
                                        _builder_9.append(" ");
                                        _builder_9.append("jdbcDriver=\"");
                                        String _objectList_9 = DataRetrieval.getObjectList(po.getObjectList());
                                        _builder_9.append(_objectList_9, " ");
                                        _builder_9.append("\"");
                                        d2rqJdbcDriver = _builder_9.toString();
                                      } else {
                                        boolean _isD2rqUsername = DataRetrieval.isD2rqUsername(verb);
                                        if (_isD2rqUsername) {
                                          StringConcatenation _builder_10 = new StringConcatenation();
                                          _builder_10.append(" ");
                                          _builder_10.append("username=\"");
                                          String _objectList_10 = DataRetrieval.getObjectList(po.getObjectList());
                                          _builder_10.append(_objectList_10, " ");
                                          _builder_10.append("\"");
                                          d2rqUsername = _builder_10.toString();
                                        } else {
                                          boolean _isD2rqPassword = DataRetrieval.isD2rqPassword(verb);
                                          if (_isD2rqPassword) {
                                            StringConcatenation _builder_11 = new StringConcatenation();
                                            _builder_11.append(" ");
                                            _builder_11.append("password=\"");
                                            String _objectList_11 = DataRetrieval.getObjectList(po.getObjectList());
                                            _builder_11.append(_objectList_11, " ");
                                            _builder_11.append("\"");
                                            d2rqPassword = _builder_11.toString();
                                          } else {
                                            boolean _isSDService = DataRetrieval.isSDService(verb);
                                            if (_isSDService) {
                                            } else {
                                              boolean _isSDEndpoint = DataRetrieval.isSDEndpoint(verb);
                                              if (_isSDEndpoint) {
                                                StringConcatenation _builder_12 = new StringConcatenation();
                                                _builder_12.append(" ");
                                                _builder_12.append("endpoint=\"");
                                                String _objectList_12 = DataRetrieval.getObjectList(po.getObjectList());
                                                _builder_12.append(_objectList_12, " ");
                                                _builder_12.append("\"");
                                                sdEndpoint = _builder_12.toString();
                                              } else {
                                                boolean _isSDSupportedLanguage = DataRetrieval.isSDSupportedLanguage(verb);
                                                if (_isSDSupportedLanguage) {
                                                  StringConcatenation _builder_13 = new StringConcatenation();
                                                  _builder_13.append(" ");
                                                  _builder_13.append("supportedLanguage=\"");
                                                  String _objectList_13 = DataRetrieval.getObjectList(po.getObjectList());
                                                  _builder_13.append(_objectList_13, " ");
                                                  _builder_13.append("\"");
                                                  sdSupportedLanguage = _builder_13.toString();
                                                } else {
                                                  boolean _isSDResultFormat = DataRetrieval.isSDResultFormat(verb);
                                                  if (_isSDResultFormat) {
                                                    StringConcatenation _builder_14 = new StringConcatenation();
                                                    _builder_14.append(" ");
                                                    _builder_14.append("resultFormat=\"");
                                                    String _objectList_14 = DataRetrieval.getObjectList(po.getObjectList());
                                                    _builder_14.append(_objectList_14, " ");
                                                    _builder_14.append("\"");
                                                    sdResultFormat = _builder_14.toString();
                                                  } else {
                                                    boolean _isCsvwTable = DataRetrieval.isCsvwTable(verb);
                                                    if (_isCsvwTable) {
                                                    } else {
                                                      boolean _isCsvwURL = DataRetrieval.isCsvwURL(verb);
                                                      if (_isCsvwURL) {
                                                        StringConcatenation _builder_15 = new StringConcatenation();
                                                        _builder_15.append(" ");
                                                        _builder_15.append("url=\"");
                                                        String _objectList_15 = DataRetrieval.getObjectList(po.getObjectList());
                                                        _builder_15.append(_objectList_15, " ");
                                                        _builder_15.append("\"");
                                                        csvwUrl = _builder_15.toString();
                                                      } else {
                                                        boolean _isCsvwDialect = DataRetrieval.isCsvwDialect(verb);
                                                        if (_isCsvwDialect) {
                                                          String _csvwDialect = csvwDialect;
                                                          String _parseDataRetrieval_2 = DataRetrieval.parseDataRetrieval(po.getObjectList(), "dialect", null);
                                                          csvwDialect = (_csvwDialect + _parseDataRetrieval_2);
                                                        } else {
                                                          boolean _isCsvwDelimiter = DataRetrieval.isCsvwDelimiter(verb);
                                                          if (_isCsvwDelimiter) {
                                                            StringConcatenation _builder_16 = new StringConcatenation();
                                                            _builder_16.append(" ");
                                                            _builder_16.append("delimiter=\"");
                                                            String _objectList_16 = DataRetrieval.getObjectList(po.getObjectList());
                                                            _builder_16.append(_objectList_16, " ");
                                                            _builder_16.append("\"");
                                                            csvwDelimiter = _builder_16.toString();
                                                          } else {
                                                            boolean _isCsvwEncoding = DataRetrieval.isCsvwEncoding(verb);
                                                            if (_isCsvwEncoding) {
                                                              StringConcatenation _builder_17 = new StringConcatenation();
                                                              _builder_17.append(" ");
                                                              _builder_17.append("encoding=\"");
                                                              String _objectList_17 = DataRetrieval.getObjectList(po.getObjectList());
                                                              _builder_17.append(_objectList_17, " ");
                                                              _builder_17.append("\"");
                                                              csvwEnconding = _builder_17.toString();
                                                            } else {
                                                              boolean _isCsvwHeader = DataRetrieval.isCsvwHeader(verb);
                                                              if (_isCsvwHeader) {
                                                                StringConcatenation _builder_18 = new StringConcatenation();
                                                                _builder_18.append(" ");
                                                                _builder_18.append("header=\"");
                                                                String _objectList_18 = DataRetrieval.getObjectList(po.getObjectList());
                                                                _builder_18.append(_objectList_18, " ");
                                                                _builder_18.append("\"");
                                                                csvwHeader = _builder_18.toString();
                                                              } else {
                                                                boolean _isCsvwHeaderRowCount = DataRetrieval.isCsvwHeaderRowCount(verb);
                                                                if (_isCsvwHeaderRowCount) {
                                                                  StringConcatenation _builder_19 = new StringConcatenation();
                                                                  _builder_19.append(" ");
                                                                  _builder_19.append("headerRowCount=\"");
                                                                  String _objectList_19 = DataRetrieval.getObjectList(po.getObjectList());
                                                                  _builder_19.append(_objectList_19, " ");
                                                                  _builder_19.append("\"");
                                                                  csvwHeaderRowCount = _builder_19.toString();
                                                                } else {
                                                                  boolean _isCsvwTrim = DataRetrieval.isCsvwTrim(verb);
                                                                  if (_isCsvwTrim) {
                                                                    StringConcatenation _builder_20 = new StringConcatenation();
                                                                    _builder_20.append(" ");
                                                                    _builder_20.append("trim=\"");
                                                                    String _objectList_20 = DataRetrieval.getObjectList(po.getObjectList());
                                                                    _builder_20.append(_objectList_20, " ");
                                                                    _builder_20.append("\"");
                                                                    csvwTrim = _builder_20.toString();
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
              }
            }
          }
        }
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<");
    _builder.append(termName);
    _builder.append(d2rqUsername);
    _builder.append(d2rqPassword);
    _builder.append(d2rqJdbcDriver);
    _builder.append(d2rqJdbcDSN);
    _builder.append(d2rqDatabase);
    _builder.append(hydraDownloadurl);
    _builder.append(hydraTemplate);
    _builder.append(hydraVariable);
    _builder.append(hydraRequired);
    _builder.append(hydraItemsPerPage);
    _builder.append(hydraFirstPage);
    _builder.append(hydraNextPage);
    _builder.append(sdEndpoint);
    _builder.append(sdResultFormat);
    _builder.append(sdSupportedLanguage);
    _builder.append(csvwTrim);
    _builder.append(csvwHeaderRowCount);
    _builder.append(csvwHeader);
    _builder.append(csvwEnconding);
    _builder.append(csvwDelimiter);
    _builder.append(csvwUrl);
    _builder.append(">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(hydraDistribution, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(csvwDialect, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(hydraMapping, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</");
    _builder.append(termName);
    _builder.append(">");
    _builder.newLineIfNotEmpty();
    str = _builder.toString();
    return str;
  }
  
  public static String parseDataRetrieval(final ObjectList objectList, final String termName, final String shortName) {
    String str = "";
    org.xtext.example.rml.iRML.Object obj = objectList.getObjects().get(0);
    Blank _blank = obj.getBlank();
    boolean _tripleNotEquals = (_blank != null);
    if (_tripleNotEquals) {
      str = DataRetrieval.parseDataRetrieval(obj.getBlank().getPredicateObjectList(), termName);
    } else {
      iResource _resource = obj.getResource();
      boolean _tripleNotEquals_1 = (_resource != null);
      if (_tripleNotEquals_1) {
        String _uriRef = obj.getResource().getUriRef();
        boolean _tripleNotEquals_2 = (_uriRef != null);
        if (_tripleNotEquals_2) {
          Triples refTriple = IRMLGenerator.getTripleByName(DataRetrieval.getResource(obj.getResource()));
          if ((refTriple != null)) {
            str = DataRetrieval.dispatchDataSource(refTriple.getPredicateObjectList());
          } else {
            str = DataRetrieval.getResource(obj.getResource());
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("<");
            _builder.append(termName);
            _builder.append(" path=\"");
            _builder.append(str);
            _builder.append("\"/>");
            _builder.newLineIfNotEmpty();
            return _builder.toString();
          }
        } else {
          EList<org.xtext.example.rml.iRML.Object> _objects = objectList.getObjects();
          for (final org.xtext.example.rml.iRML.Object o : _objects) {
            String _str = str;
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("<");
            _builder_1.append(shortName);
            _builder_1.append(">");
            String _object = DataRetrieval.getObject(o);
            _builder_1.append(_object);
            _builder_1.append("</");
            _builder_1.append(shortName);
            _builder_1.append(">");
            String _plus = (_builder_1.toString() + "\r\n");
            str = (_str + _plus);
          }
          str.trim();
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("<");
          _builder_2.append(termName);
          _builder_2.append(" path=\"");
          _builder_2.append(str);
          _builder_2.append("\"/>");
          _builder_2.newLineIfNotEmpty();
          return _builder_2.toString();
        }
      } else {
        str = Helper.getLiteral(obj.getLiteral());
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("<");
        _builder_3.append(termName);
        _builder_3.append(" path=\"");
        _builder_3.append(str);
        _builder_3.append("\"/>");
        _builder_3.newLineIfNotEmpty();
        return _builder_3.toString();
      }
    }
    str.trim();
    return str;
  }
  
  public static boolean isFnoPredicate(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.FNO_PREDICATE);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isFnoType(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.FNO_TYPE);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isFnoMethod(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.FNO_METHOD);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isFnoClass(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.FNO_CLASS);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isFnoLocalLibrary(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.FNO_LOCAL_LIBRARY);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isFnoProvidedBy(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.FNO_PROVIDED_BY);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isFnoReturns(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.FNO_RETURNS);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isFnoExpects(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.FNO_EXPECTS);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isFnoName(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.FNO_NAME);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isRdfsLabel(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.RDFS_LABEL);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isFnoFunction(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.FNO_FUNCTION);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isFnoParameter(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.FNO_PARAMETER);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isFnoOutput(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.FNO_OUTPUT);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isDctermsDescription(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.DCTERMS_DESCRIPTION);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isDcatDistribution(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.DCAT_DISTRIBUTION);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isDcatDataset(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.DCAT_DATASET);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isDcatDownloadURL(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.DCAT_DOWNLOAD_URL);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isHydraIriTemplate(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.HYDRA_IRITEMPLATE_CLASS);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isHydraTemplate(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.HYDRA_TEMPLATE);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isHydraMapping(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.HYDRA_MAPPING);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isHydraTemplateMapping(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.HYDRA_TEMPLATE_MAPPING);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isHydraVariable(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.HYDRA_VARIABLE);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isHydraRequired(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.HYDRA_REQUIRED);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isHydraPagedCollection(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.HYDRA_PAGED_COLLECTION_CLASS);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isHydraItemsPerPage(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.HYDRA_ITEM_PER_PAGE);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isHydraFirstPage(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.HYDRA_FIRST_PAGE);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isHydraNextPage(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.HYDRA_NEXT_PAGE);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isD2rqDatabase(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.D2RQ_DATABASE_CLASS);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isD2rqJdbcDSN(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.D2RQ_JDBC_DSN);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isD2rqJdbcDriver(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.D2RQ_JDBC_DRIVER);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isD2rqUsername(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.D2RQ_USERNAME);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isD2rqPassword(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.D2RQ_PASSWORD);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isSDService(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.SD_SERVICE_CLASS);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isSDEndpoint(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.SD_ENDPOINT);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isSDSupportedLanguage(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.SD_SUPPORTED_LANGUAGE);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isSDResultFormat(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.SD_RESULT_FORMAT);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isCsvwTable(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.CSVW_TABLE_CLASS);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isCsvwURL(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.CSVW_URL);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isCsvwDialect(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.CSVW_DIALECT);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isCsvwDelimiter(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.CSVW_DELIMITER);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isCsvwEncoding(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.CSVW_ENCODING);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isCsvwHeader(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.CSVW_HEADER);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isCsvwHeaderRowCount(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.CSVW_HEADER_ROW_COUNT);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  public static boolean isCsvwTrim(final String str) {
    boolean _equalsIgnoreCase = str.equalsIgnoreCase(NAMESPACE.CSVW_TRIM);
    if (_equalsIgnoreCase) {
      return true;
    }
    return false;
  }
  
  protected static String getObjectList(final ObjectList ol) {
    return Helper.getObjectList(ol);
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
