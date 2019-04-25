/*
 * generated by Xtext 2.16.0
 */
package org.xtext.example.rml.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.example.rml.iRML.Base;
import org.xtext.example.rml.iRML.Blank;
import org.xtext.example.rml.iRML.Collection;
import org.xtext.example.rml.iRML.DatatypeString;
import org.xtext.example.rml.iRML.Directive;
import org.xtext.example.rml.iRML.IRMLPackage;
import org.xtext.example.rml.iRML.ItemList;
import org.xtext.example.rml.iRML.LanguageString;
import org.xtext.example.rml.iRML.Literal;
import org.xtext.example.rml.iRML.Mapping;
import org.xtext.example.rml.iRML.NodeID;
import org.xtext.example.rml.iRML.ObjectList;
import org.xtext.example.rml.iRML.PredicateObject;
import org.xtext.example.rml.iRML.PredicateObjectList;
import org.xtext.example.rml.iRML.PrefixID;
import org.xtext.example.rml.iRML.Qname;
import org.xtext.example.rml.iRML.Statement;
import org.xtext.example.rml.iRML.Subject;
import org.xtext.example.rml.iRML.Triples;
import org.xtext.example.rml.iRML.Verb;
import org.xtext.example.rml.iRML.iResource;
import org.xtext.example.rml.services.IRMLGrammarAccess;

@SuppressWarnings("all")
public class IRMLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private IRMLGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == IRMLPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case IRMLPackage.BASE:
				sequence_Base(context, (Base) semanticObject); 
				return; 
			case IRMLPackage.BLANK:
				sequence_Blank(context, (Blank) semanticObject); 
				return; 
			case IRMLPackage.COLLECTION:
				sequence_Collection(context, (Collection) semanticObject); 
				return; 
			case IRMLPackage.DATATYPE_STRING:
				sequence_DatatypeString(context, (DatatypeString) semanticObject); 
				return; 
			case IRMLPackage.DIRECTIVE:
				sequence_Directive(context, (Directive) semanticObject); 
				return; 
			case IRMLPackage.ITEM_LIST:
				sequence_ItemList(context, (ItemList) semanticObject); 
				return; 
			case IRMLPackage.LANGUAGE_STRING:
				sequence_LanguageString(context, (LanguageString) semanticObject); 
				return; 
			case IRMLPackage.LITERAL:
				sequence_Literal(context, (Literal) semanticObject); 
				return; 
			case IRMLPackage.MAPPING:
				sequence_Mapping(context, (Mapping) semanticObject); 
				return; 
			case IRMLPackage.NODE_ID:
				sequence_NodeID(context, (NodeID) semanticObject); 
				return; 
			case IRMLPackage.OBJECT:
				sequence_Object(context, (org.xtext.example.rml.iRML.Object) semanticObject); 
				return; 
			case IRMLPackage.OBJECT_LIST:
				sequence_ObjectList(context, (ObjectList) semanticObject); 
				return; 
			case IRMLPackage.PREDICATE_OBJECT:
				sequence_PredicateObject(context, (PredicateObject) semanticObject); 
				return; 
			case IRMLPackage.PREDICATE_OBJECT_LIST:
				sequence_PredicateObjectList(context, (PredicateObjectList) semanticObject); 
				return; 
			case IRMLPackage.PREFIX_ID:
				sequence_PrefixID(context, (PrefixID) semanticObject); 
				return; 
			case IRMLPackage.QNAME:
				sequence_Qname(context, (Qname) semanticObject); 
				return; 
			case IRMLPackage.STATEMENT:
				sequence_Statement(context, (Statement) semanticObject); 
				return; 
			case IRMLPackage.SUBJECT:
				sequence_Subject(context, (Subject) semanticObject); 
				return; 
			case IRMLPackage.TRIPLES:
				sequence_Triples(context, (Triples) semanticObject); 
				return; 
			case IRMLPackage.VERB:
				sequence_Verb(context, (Verb) semanticObject); 
				return; 
			case IRMLPackage.IRESOURCE:
				sequence_iResource(context, (iResource) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Base returns Base
	 *
	 * Constraint:
	 *     uriRef=URIREF
	 */
	protected void sequence_Base(ISerializationContext context, Base semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IRMLPackage.Literals.BASE__URI_REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IRMLPackage.Literals.BASE__URI_REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBaseAccess().getUriRefURIREFTerminalRuleCall_1_0(), semanticObject.getUriRef());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Blank returns Blank
	 *
	 * Constraint:
	 *     (nodeID=NodeID | isSquare?='[]' | predicateObjectList=PredicateObjectList | collection=Collection)
	 */
	protected void sequence_Blank(ISerializationContext context, Blank semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Collection returns Collection
	 *
	 * Constraint:
	 *     itemList=ItemList?
	 */
	protected void sequence_Collection(ISerializationContext context, Collection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DatatypeString returns DatatypeString
	 *
	 * Constraint:
	 *     (qutoedString=QuotedString resource=iResource)
	 */
	protected void sequence_DatatypeString(ISerializationContext context, DatatypeString semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IRMLPackage.Literals.DATATYPE_STRING__QUTOED_STRING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IRMLPackage.Literals.DATATYPE_STRING__QUTOED_STRING));
			if (transientValues.isValueTransient(semanticObject, IRMLPackage.Literals.DATATYPE_STRING__RESOURCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IRMLPackage.Literals.DATATYPE_STRING__RESOURCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDatatypeStringAccess().getQutoedStringQuotedStringParserRuleCall_0_0(), semanticObject.getQutoedString());
		feeder.accept(grammarAccess.getDatatypeStringAccess().getResourceIResourceParserRuleCall_2_0(), semanticObject.getResource());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Directive returns Directive
	 *
	 * Constraint:
	 *     (prefix=PrefixID | base=Base)
	 */
	protected void sequence_Directive(ISerializationContext context, Directive semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ItemList returns ItemList
	 *
	 * Constraint:
	 *     (objects+=Object objects+=Object*)
	 */
	protected void sequence_ItemList(ISerializationContext context, ItemList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     LanguageString returns LanguageString
	 *
	 * Constraint:
	 *     (qutoedString=QuotedString lang=ID?)
	 */
	protected void sequence_LanguageString(ISerializationContext context, LanguageString semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Literal returns Literal
	 *
	 * Constraint:
	 *     (
	 *         languageString=LanguageString | 
	 *         datatypeString=DatatypeString | 
	 *         dword=INT | 
	 *         real=DOUBLE | 
	 *         decimal=DECIMAL | 
	 *         bool=Boolean
	 *     )
	 */
	protected void sequence_Literal(ISerializationContext context, Literal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Mapping returns Mapping
	 *
	 * Constraint:
	 *     statements+=Statement+
	 */
	protected void sequence_Mapping(ISerializationContext context, Mapping semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NodeID returns NodeID
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_NodeID(ISerializationContext context, NodeID semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IRMLPackage.Literals.NODE_ID__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IRMLPackage.Literals.NODE_ID__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNodeIDAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     ObjectList returns ObjectList
	 *
	 * Constraint:
	 *     (objects+=Object objects+=Object*)
	 */
	protected void sequence_ObjectList(ISerializationContext context, ObjectList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Object returns Object
	 *
	 * Constraint:
	 *     (resource=iResource | blank=Blank | literal=Literal)
	 */
	protected void sequence_Object(ISerializationContext context, org.xtext.example.rml.iRML.Object semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PredicateObjectList returns PredicateObjectList
	 *
	 * Constraint:
	 *     (predicateObjects+=PredicateObject predicateObjects+=PredicateObject*)
	 */
	protected void sequence_PredicateObjectList(ISerializationContext context, PredicateObjectList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     PredicateObject returns PredicateObject
	 *
	 * Constraint:
	 *     (verb=Verb objectList=ObjectList)
	 */
	protected void sequence_PredicateObject(ISerializationContext context, PredicateObject semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IRMLPackage.Literals.PREDICATE_OBJECT__VERB) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IRMLPackage.Literals.PREDICATE_OBJECT__VERB));
			if (transientValues.isValueTransient(semanticObject, IRMLPackage.Literals.PREDICATE_OBJECT__OBJECT_LIST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IRMLPackage.Literals.PREDICATE_OBJECT__OBJECT_LIST));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPredicateObjectAccess().getVerbVerbParserRuleCall_0_0(), semanticObject.getVerb());
		feeder.accept(grammarAccess.getPredicateObjectAccess().getObjectListObjectListParserRuleCall_1_0(), semanticObject.getObjectList());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PrefixID returns PrefixID
	 *
	 * Constraint:
	 *     (prefixName=PrefixName uriRef=URIREF)
	 */
	protected void sequence_PrefixID(ISerializationContext context, PrefixID semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IRMLPackage.Literals.PREFIX_ID__PREFIX_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IRMLPackage.Literals.PREFIX_ID__PREFIX_NAME));
			if (transientValues.isValueTransient(semanticObject, IRMLPackage.Literals.PREFIX_ID__URI_REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IRMLPackage.Literals.PREFIX_ID__URI_REF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrefixIDAccess().getPrefixNamePrefixNameParserRuleCall_1_0(), semanticObject.getPrefixName());
		feeder.accept(grammarAccess.getPrefixIDAccess().getUriRefURIREFTerminalRuleCall_2_0(), semanticObject.getUriRef());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Qname returns Qname
	 *
	 * Constraint:
	 *     (prefixName=PrefixName name=ID?)
	 */
	protected void sequence_Qname(ISerializationContext context, Qname semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns Statement
	 *
	 * Constraint:
	 *     (directive=Directive | triple=Triples)
	 */
	protected void sequence_Statement(ISerializationContext context, Statement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Subject returns Subject
	 *
	 * Constraint:
	 *     (resource=iResource | blank=Blank)
	 */
	protected void sequence_Subject(ISerializationContext context, Subject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Triples returns Triples
	 *
	 * Constraint:
	 *     (subject=Subject predicateObjectList=PredicateObjectList)
	 */
	protected void sequence_Triples(ISerializationContext context, Triples semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IRMLPackage.Literals.TRIPLES__SUBJECT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IRMLPackage.Literals.TRIPLES__SUBJECT));
			if (transientValues.isValueTransient(semanticObject, IRMLPackage.Literals.TRIPLES__PREDICATE_OBJECT_LIST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IRMLPackage.Literals.TRIPLES__PREDICATE_OBJECT_LIST));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTriplesAccess().getSubjectSubjectParserRuleCall_0_0(), semanticObject.getSubject());
		feeder.accept(grammarAccess.getTriplesAccess().getPredicateObjectListPredicateObjectListParserRuleCall_1_0(), semanticObject.getPredicateObjectList());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Verb returns Verb
	 *
	 * Constraint:
	 *     (predicate=Predicate | isA?='a')
	 */
	protected void sequence_Verb(ISerializationContext context, Verb semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Predicate returns iResource
	 *     iResource returns iResource
	 *
	 * Constraint:
	 *     (uriRef=URIREF | qname=Qname)
	 */
	protected void sequence_iResource(ISerializationContext context, iResource semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
