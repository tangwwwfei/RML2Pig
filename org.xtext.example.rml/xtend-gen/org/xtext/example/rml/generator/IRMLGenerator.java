/**
 * generated by Xtext 2.16.0
 */
package org.xtext.example.rml.generator;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.example.rml.generator.Helper;
import org.xtext.example.rml.generator.LogicalSource;
import org.xtext.example.rml.generator.PredicateObjectMap;
import org.xtext.example.rml.generator.SubjectMap;
import org.xtext.example.rml.iRML.Base;
import org.xtext.example.rml.iRML.Directive;
import org.xtext.example.rml.iRML.Mapping;
import org.xtext.example.rml.iRML.PrefixID;
import org.xtext.example.rml.iRML.Statement;
import org.xtext.example.rml.iRML.Subject;
import org.xtext.example.rml.iRML.Triples;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class IRMLGenerator extends AbstractGenerator {
  public static Map<String, Triples> m_NameTriple = new HashMap<String, Triples>();
  
  public static Map<String, Boolean> m_UsedTriple = new HashMap<String, Boolean>();
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    String _className = this.className(resource);
    String path = (_className + ".xmi");
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    fsa.generateFile(path, this.toXMI(((Mapping) _head)));
  }
  
  protected String toXMI(final Mapping m) {
    EList<Statement> _statements = m.getStatements();
    for (final Statement s : _statements) {
      Triples _triple = s.getTriple();
      boolean _tripleNotEquals = (_triple != null);
      if (_tripleNotEquals) {
        String name = this.getSubject(s.getTriple().getSubject());
        IRMLGenerator.m_NameTriple.put(name, s.getTriple());
        IRMLGenerator.m_UsedTriple.put(name, Boolean.valueOf(false));
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"ASCII\"?>");
    _builder.newLine();
    _builder.append("<rml:Mapping xmi:version=\"2.0\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:xmi=\"http://www.omg.org/XMI\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:rml=\"http://www.xtext.org/example/rml/RML\">");
    _builder.newLine();
    {
      EList<Statement> _statements_1 = m.getStatements();
      for(final Statement s_1 : _statements_1) {
        {
          Directive _directive = s_1.getDirective();
          boolean _tripleNotEquals_1 = (_directive != null);
          if (_tripleNotEquals_1) {
            _builder.append("\t");
            String _generateNamespace = this.generateNamespace(s_1.getDirective());
            _builder.append(_generateNamespace, "\t");
            _builder.newLineIfNotEmpty();
          } else {
            Triples _triple_1 = s_1.getTriple();
            boolean _tripleNotEquals_2 = (_triple_1 != null);
            if (_tripleNotEquals_2) {
              _builder.append("\t");
              String _generateTriple = this.generateTriple(s_1.getTriple());
              _builder.append(_generateTriple, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
    }
    _builder.append("</rml:Mapping>");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String generateNamespace(final Directive ns) {
    String pf = "";
    String iri = "";
    PrefixID _prefix = ns.getPrefix();
    boolean _tripleNotEquals = (_prefix != null);
    if (_tripleNotEquals) {
      String _prefixName = ns.getPrefix().getPrefixName();
      boolean _tripleNotEquals_1 = (_prefixName != null);
      if (_tripleNotEquals_1) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(" ");
        _builder.append("prefix=\"");
        String _prefixName_1 = ns.getPrefix().getPrefixName();
        _builder.append(_prefixName_1, " ");
        _builder.append("\"");
        pf = _builder.toString();
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(" ");
      _builder_1.append("iri=\"");
      String _TrimName = this.TrimName(ns.getPrefix().getUriRef());
      _builder_1.append(_TrimName, " ");
      _builder_1.append("\"");
      iri = _builder_1.toString();
    } else {
      Base _base = ns.getBase();
      boolean _tripleNotEquals_2 = (_base != null);
      if (_tripleNotEquals_2) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(" ");
        _builder_2.append("base=\"");
        String _TrimName_1 = this.TrimName(ns.getBase().getUriRef());
        _builder_2.append(_TrimName_1, " ");
        _builder_2.append("\"");
        iri = _builder_2.toString();
      }
    }
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("<directives");
    _builder_3.append(pf);
    _builder_3.append(iri);
    _builder_3.append("/>");
    String result = _builder_3.toString();
    return result;
  }
  
  protected String TrimName(final String string) {
    return Helper.TrimName(string);
  }
  
  public static Triples getTripleByName(final String name) {
    IRMLGenerator.m_UsedTriple.put(name, Boolean.valueOf(true));
    return IRMLGenerator.m_NameTriple.get(name);
  }
  
  protected String generateTriple(final Triples triple) {
    String name = this.getSubject(triple.getSubject());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("name=\"");
    _builder.append(name, " ");
    _builder.append("\"");
    String tripleName = _builder.toString();
    String ls = this.parseLogicalSource(triple);
    String sm = this.parseSubjectMap(triple);
    String pom = this.parsePredicateObjectMap(triple, name);
    String result = "";
    if ((ls.isEmpty() && sm.isEmpty())) {
      return "";
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<triplesMaps");
    _builder_1.append(tripleName);
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
    _builder_1.append("</triplesMaps>");
    _builder_1.newLine();
    result = _builder_1.toString();
    return result;
  }
  
  public String getSubject(final Subject subject) {
    return Helper.getSubject(subject);
  }
  
  protected String parseSubjectMap(final Triples triples) {
    return SubjectMap.parseSubjectMap(triples);
  }
  
  protected String parseLogicalSource(final Triples triples) {
    return LogicalSource.parseLogicalSource(triples);
  }
  
  protected String parsePredicateObjectMap(final Triples triple, final String owner) {
    return PredicateObjectMap.parsePredicateObjectMap(triple, owner);
  }
  
  protected String className(final Resource res) {
    String name = res.getURI().lastSegment();
    return StringExtensions.toFirstUpper(name.substring(0, name.indexOf(".")));
  }
  
  protected String RemoveAngleBrackets(final String s) {
    String ret = s.replaceAll("%3c|%3e", "");
    return ret;
  }
}
