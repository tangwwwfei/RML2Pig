package org.xtext.example.rml.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.xtext.example.rml.services.IRMLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalIRMLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_URIREF", "RULE_INT", "RULE_DOUBLE", "RULE_DECIMAL", "RULE_EXPONENT", "RULE_SL_COMMENT", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'.'", "'@prefix'", "'@base'", "';'", "','", "'@'", "'^^'", "'['", "']'", "'('", "')'", "'_:'", "':'", "'a'", "'[]'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_URIREF=6;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_DOUBLE=8;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_ID=5;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_DECIMAL=9;
    public static final int RULE_EXPONENT=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalIRMLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalIRMLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[215+1];
             
             
        }
        

    public String[] getTokenNames() { return InternalIRMLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalIRML.g"; }


    	private IRMLGrammarAccess grammarAccess;

    	public void setGrammarAccess(IRMLGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleMapping"
    // InternalIRML.g:55:1: entryRuleMapping : ruleMapping EOF ;
    public final void entryRuleMapping() throws RecognitionException {
        int entryRuleMapping_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }
            // InternalIRML.g:56:1: ( ruleMapping EOF )
            // InternalIRML.g:57:1: ruleMapping EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMappingRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMapping();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMappingRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, entryRuleMapping_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleMapping"


    // $ANTLR start "ruleMapping"
    // InternalIRML.g:64:1: ruleMapping : ( ( rule__Mapping__StatementsAssignment )* ) ;
    public final void ruleMapping() throws RecognitionException {
        int ruleMapping_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }
            // InternalIRML.g:68:2: ( ( ( rule__Mapping__StatementsAssignment )* ) )
            // InternalIRML.g:69:2: ( ( rule__Mapping__StatementsAssignment )* )
            {
            // InternalIRML.g:69:2: ( ( rule__Mapping__StatementsAssignment )* )
            // InternalIRML.g:70:3: ( rule__Mapping__StatementsAssignment )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMappingAccess().getStatementsAssignment()); 
            }
            // InternalIRML.g:71:3: ( rule__Mapping__StatementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_URIREF)||(LA1_0>=18 && LA1_0<=19)||LA1_0==24||LA1_0==26||(LA1_0>=28 && LA1_0<=29)||LA1_0==31) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIRML.g:71:4: rule__Mapping__StatementsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Mapping__StatementsAssignment();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMappingAccess().getStatementsAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, ruleMapping_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMapping"


    // $ANTLR start "entryRuleStatement"
    // InternalIRML.g:80:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        int entryRuleStatement_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }
            // InternalIRML.g:81:1: ( ruleStatement EOF )
            // InternalIRML.g:82:1: ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, entryRuleStatement_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalIRML.g:89:1: ruleStatement : ( ( rule__Statement__Group__0 ) ) ;
    public final void ruleStatement() throws RecognitionException {
        int ruleStatement_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }
            // InternalIRML.g:93:2: ( ( ( rule__Statement__Group__0 ) ) )
            // InternalIRML.g:94:2: ( ( rule__Statement__Group__0 ) )
            {
            // InternalIRML.g:94:2: ( ( rule__Statement__Group__0 ) )
            // InternalIRML.g:95:3: ( rule__Statement__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getGroup()); 
            }
            // InternalIRML.g:96:3: ( rule__Statement__Group__0 )
            // InternalIRML.g:96:4: rule__Statement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Statement__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, ruleStatement_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleDirective"
    // InternalIRML.g:105:1: entryRuleDirective : ruleDirective EOF ;
    public final void entryRuleDirective() throws RecognitionException {
        int entryRuleDirective_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }
            // InternalIRML.g:106:1: ( ruleDirective EOF )
            // InternalIRML.g:107:1: ruleDirective EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDirective();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDirectiveRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, entryRuleDirective_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleDirective"


    // $ANTLR start "ruleDirective"
    // InternalIRML.g:114:1: ruleDirective : ( ( rule__Directive__Alternatives ) ) ;
    public final void ruleDirective() throws RecognitionException {
        int ruleDirective_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return ; }
            // InternalIRML.g:118:2: ( ( ( rule__Directive__Alternatives ) ) )
            // InternalIRML.g:119:2: ( ( rule__Directive__Alternatives ) )
            {
            // InternalIRML.g:119:2: ( ( rule__Directive__Alternatives ) )
            // InternalIRML.g:120:3: ( rule__Directive__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDirectiveAccess().getAlternatives()); 
            }
            // InternalIRML.g:121:3: ( rule__Directive__Alternatives )
            // InternalIRML.g:121:4: rule__Directive__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Directive__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDirectiveAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, ruleDirective_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDirective"


    // $ANTLR start "entryRulePrefixID"
    // InternalIRML.g:130:1: entryRulePrefixID : rulePrefixID EOF ;
    public final void entryRulePrefixID() throws RecognitionException {
        int entryRulePrefixID_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return ; }
            // InternalIRML.g:131:1: ( rulePrefixID EOF )
            // InternalIRML.g:132:1: rulePrefixID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixIDRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePrefixID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixIDRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, entryRulePrefixID_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRulePrefixID"


    // $ANTLR start "rulePrefixID"
    // InternalIRML.g:139:1: rulePrefixID : ( ( rule__PrefixID__Group__0 ) ) ;
    public final void rulePrefixID() throws RecognitionException {
        int rulePrefixID_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return ; }
            // InternalIRML.g:143:2: ( ( ( rule__PrefixID__Group__0 ) ) )
            // InternalIRML.g:144:2: ( ( rule__PrefixID__Group__0 ) )
            {
            // InternalIRML.g:144:2: ( ( rule__PrefixID__Group__0 ) )
            // InternalIRML.g:145:3: ( rule__PrefixID__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixIDAccess().getGroup()); 
            }
            // InternalIRML.g:146:3: ( rule__PrefixID__Group__0 )
            // InternalIRML.g:146:4: rule__PrefixID__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PrefixID__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixIDAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, rulePrefixID_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrefixID"


    // $ANTLR start "entryRuleBase"
    // InternalIRML.g:155:1: entryRuleBase : ruleBase EOF ;
    public final void entryRuleBase() throws RecognitionException {
        int entryRuleBase_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return ; }
            // InternalIRML.g:156:1: ( ruleBase EOF )
            // InternalIRML.g:157:1: ruleBase EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBase();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, entryRuleBase_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleBase"


    // $ANTLR start "ruleBase"
    // InternalIRML.g:164:1: ruleBase : ( ( rule__Base__Group__0 ) ) ;
    public final void ruleBase() throws RecognitionException {
        int ruleBase_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return ; }
            // InternalIRML.g:168:2: ( ( ( rule__Base__Group__0 ) ) )
            // InternalIRML.g:169:2: ( ( rule__Base__Group__0 ) )
            {
            // InternalIRML.g:169:2: ( ( rule__Base__Group__0 ) )
            // InternalIRML.g:170:3: ( rule__Base__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseAccess().getGroup()); 
            }
            // InternalIRML.g:171:3: ( rule__Base__Group__0 )
            // InternalIRML.g:171:4: rule__Base__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Base__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, ruleBase_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBase"


    // $ANTLR start "entryRuleTriples"
    // InternalIRML.g:180:1: entryRuleTriples : ruleTriples EOF ;
    public final void entryRuleTriples() throws RecognitionException {
        int entryRuleTriples_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return ; }
            // InternalIRML.g:181:1: ( ruleTriples EOF )
            // InternalIRML.g:182:1: ruleTriples EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTriplesRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleTriples();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTriplesRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, entryRuleTriples_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleTriples"


    // $ANTLR start "ruleTriples"
    // InternalIRML.g:189:1: ruleTriples : ( ( rule__Triples__Group__0 ) ) ;
    public final void ruleTriples() throws RecognitionException {
        int ruleTriples_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return ; }
            // InternalIRML.g:193:2: ( ( ( rule__Triples__Group__0 ) ) )
            // InternalIRML.g:194:2: ( ( rule__Triples__Group__0 ) )
            {
            // InternalIRML.g:194:2: ( ( rule__Triples__Group__0 ) )
            // InternalIRML.g:195:3: ( rule__Triples__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTriplesAccess().getGroup()); 
            }
            // InternalIRML.g:196:3: ( rule__Triples__Group__0 )
            // InternalIRML.g:196:4: rule__Triples__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Triples__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTriplesAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, ruleTriples_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTriples"


    // $ANTLR start "entryRulePredicateObject"
    // InternalIRML.g:205:1: entryRulePredicateObject : rulePredicateObject EOF ;
    public final void entryRulePredicateObject() throws RecognitionException {
        int entryRulePredicateObject_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return ; }
            // InternalIRML.g:206:1: ( rulePredicateObject EOF )
            // InternalIRML.g:207:1: rulePredicateObject EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePredicateObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, entryRulePredicateObject_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRulePredicateObject"


    // $ANTLR start "rulePredicateObject"
    // InternalIRML.g:214:1: rulePredicateObject : ( ( rule__PredicateObject__Group__0 ) ) ;
    public final void rulePredicateObject() throws RecognitionException {
        int rulePredicateObject_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return ; }
            // InternalIRML.g:218:2: ( ( ( rule__PredicateObject__Group__0 ) ) )
            // InternalIRML.g:219:2: ( ( rule__PredicateObject__Group__0 ) )
            {
            // InternalIRML.g:219:2: ( ( rule__PredicateObject__Group__0 ) )
            // InternalIRML.g:220:3: ( rule__PredicateObject__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectAccess().getGroup()); 
            }
            // InternalIRML.g:221:3: ( rule__PredicateObject__Group__0 )
            // InternalIRML.g:221:4: rule__PredicateObject__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PredicateObject__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, rulePredicateObject_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicateObject"


    // $ANTLR start "entryRulePredicateObjectList"
    // InternalIRML.g:230:1: entryRulePredicateObjectList : rulePredicateObjectList EOF ;
    public final void entryRulePredicateObjectList() throws RecognitionException {
        int entryRulePredicateObjectList_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return ; }
            // InternalIRML.g:231:1: ( rulePredicateObjectList EOF )
            // InternalIRML.g:232:1: rulePredicateObjectList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectListRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePredicateObjectList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectListRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, entryRulePredicateObjectList_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRulePredicateObjectList"


    // $ANTLR start "rulePredicateObjectList"
    // InternalIRML.g:239:1: rulePredicateObjectList : ( ( rule__PredicateObjectList__Group__0 ) ) ;
    public final void rulePredicateObjectList() throws RecognitionException {
        int rulePredicateObjectList_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return ; }
            // InternalIRML.g:243:2: ( ( ( rule__PredicateObjectList__Group__0 ) ) )
            // InternalIRML.g:244:2: ( ( rule__PredicateObjectList__Group__0 ) )
            {
            // InternalIRML.g:244:2: ( ( rule__PredicateObjectList__Group__0 ) )
            // InternalIRML.g:245:3: ( rule__PredicateObjectList__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectListAccess().getGroup()); 
            }
            // InternalIRML.g:246:3: ( rule__PredicateObjectList__Group__0 )
            // InternalIRML.g:246:4: rule__PredicateObjectList__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PredicateObjectList__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectListAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, rulePredicateObjectList_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicateObjectList"


    // $ANTLR start "entryRuleObjectList"
    // InternalIRML.g:255:1: entryRuleObjectList : ruleObjectList EOF ;
    public final void entryRuleObjectList() throws RecognitionException {
        int entryRuleObjectList_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return ; }
            // InternalIRML.g:256:1: ( ruleObjectList EOF )
            // InternalIRML.g:257:1: ruleObjectList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectListRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleObjectList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectListRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, entryRuleObjectList_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleObjectList"


    // $ANTLR start "ruleObjectList"
    // InternalIRML.g:264:1: ruleObjectList : ( ( rule__ObjectList__Group__0 ) ) ;
    public final void ruleObjectList() throws RecognitionException {
        int ruleObjectList_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }
            // InternalIRML.g:268:2: ( ( ( rule__ObjectList__Group__0 ) ) )
            // InternalIRML.g:269:2: ( ( rule__ObjectList__Group__0 ) )
            {
            // InternalIRML.g:269:2: ( ( rule__ObjectList__Group__0 ) )
            // InternalIRML.g:270:3: ( rule__ObjectList__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectListAccess().getGroup()); 
            }
            // InternalIRML.g:271:3: ( rule__ObjectList__Group__0 )
            // InternalIRML.g:271:4: rule__ObjectList__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ObjectList__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectListAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, ruleObjectList_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObjectList"


    // $ANTLR start "entryRuleVerb"
    // InternalIRML.g:280:1: entryRuleVerb : ruleVerb EOF ;
    public final void entryRuleVerb() throws RecognitionException {
        int entryRuleVerb_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return ; }
            // InternalIRML.g:281:1: ( ruleVerb EOF )
            // InternalIRML.g:282:1: ruleVerb EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVerbRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleVerb();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVerbRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, entryRuleVerb_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleVerb"


    // $ANTLR start "ruleVerb"
    // InternalIRML.g:289:1: ruleVerb : ( ( rule__Verb__Alternatives ) ) ;
    public final void ruleVerb() throws RecognitionException {
        int ruleVerb_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return ; }
            // InternalIRML.g:293:2: ( ( ( rule__Verb__Alternatives ) ) )
            // InternalIRML.g:294:2: ( ( rule__Verb__Alternatives ) )
            {
            // InternalIRML.g:294:2: ( ( rule__Verb__Alternatives ) )
            // InternalIRML.g:295:3: ( rule__Verb__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVerbAccess().getAlternatives()); 
            }
            // InternalIRML.g:296:3: ( rule__Verb__Alternatives )
            // InternalIRML.g:296:4: rule__Verb__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Verb__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVerbAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, ruleVerb_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVerb"


    // $ANTLR start "entryRuleSubject"
    // InternalIRML.g:305:1: entryRuleSubject : ruleSubject EOF ;
    public final void entryRuleSubject() throws RecognitionException {
        int entryRuleSubject_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return ; }
            // InternalIRML.g:306:1: ( ruleSubject EOF )
            // InternalIRML.g:307:1: ruleSubject EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubjectRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSubject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubjectRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, entryRuleSubject_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleSubject"


    // $ANTLR start "ruleSubject"
    // InternalIRML.g:314:1: ruleSubject : ( ( rule__Subject__Alternatives ) ) ;
    public final void ruleSubject() throws RecognitionException {
        int ruleSubject_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return ; }
            // InternalIRML.g:318:2: ( ( ( rule__Subject__Alternatives ) ) )
            // InternalIRML.g:319:2: ( ( rule__Subject__Alternatives ) )
            {
            // InternalIRML.g:319:2: ( ( rule__Subject__Alternatives ) )
            // InternalIRML.g:320:3: ( rule__Subject__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubjectAccess().getAlternatives()); 
            }
            // InternalIRML.g:321:3: ( rule__Subject__Alternatives )
            // InternalIRML.g:321:4: rule__Subject__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Subject__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubjectAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, ruleSubject_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSubject"


    // $ANTLR start "entryRulePredicate"
    // InternalIRML.g:330:1: entryRulePredicate : rulePredicate EOF ;
    public final void entryRulePredicate() throws RecognitionException {
        int entryRulePredicate_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return ; }
            // InternalIRML.g:331:1: ( rulePredicate EOF )
            // InternalIRML.g:332:1: rulePredicate EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePredicate();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, entryRulePredicate_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRulePredicate"


    // $ANTLR start "rulePredicate"
    // InternalIRML.g:339:1: rulePredicate : ( ruleiResource ) ;
    public final void rulePredicate() throws RecognitionException {
        int rulePredicate_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return ; }
            // InternalIRML.g:343:2: ( ( ruleiResource ) )
            // InternalIRML.g:344:2: ( ruleiResource )
            {
            // InternalIRML.g:344:2: ( ruleiResource )
            // InternalIRML.g:345:3: ruleiResource
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateAccess().getIResourceParserRuleCall()); 
            }
            pushFollow(FOLLOW_2);
            ruleiResource();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateAccess().getIResourceParserRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, rulePredicate_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleObject"
    // InternalIRML.g:355:1: entryRuleObject : ruleObject EOF ;
    public final void entryRuleObject() throws RecognitionException {
        int entryRuleObject_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return ; }
            // InternalIRML.g:356:1: ( ruleObject EOF )
            // InternalIRML.g:357:1: ruleObject EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, entryRuleObject_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleObject"


    // $ANTLR start "ruleObject"
    // InternalIRML.g:364:1: ruleObject : ( ( rule__Object__Alternatives ) ) ;
    public final void ruleObject() throws RecognitionException {
        int ruleObject_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return ; }
            // InternalIRML.g:368:2: ( ( ( rule__Object__Alternatives ) ) )
            // InternalIRML.g:369:2: ( ( rule__Object__Alternatives ) )
            {
            // InternalIRML.g:369:2: ( ( rule__Object__Alternatives ) )
            // InternalIRML.g:370:3: ( rule__Object__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getAlternatives()); 
            }
            // InternalIRML.g:371:3: ( rule__Object__Alternatives )
            // InternalIRML.g:371:4: rule__Object__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Object__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, ruleObject_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleLanguageString"
    // InternalIRML.g:380:1: entryRuleLanguageString : ruleLanguageString EOF ;
    public final void entryRuleLanguageString() throws RecognitionException {
        int entryRuleLanguageString_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return ; }
            // InternalIRML.g:381:1: ( ruleLanguageString EOF )
            // InternalIRML.g:382:1: ruleLanguageString EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageStringRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLanguageString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageStringRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, entryRuleLanguageString_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleLanguageString"


    // $ANTLR start "ruleLanguageString"
    // InternalIRML.g:389:1: ruleLanguageString : ( ( rule__LanguageString__Group__0 ) ) ;
    public final void ruleLanguageString() throws RecognitionException {
        int ruleLanguageString_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return ; }
            // InternalIRML.g:393:2: ( ( ( rule__LanguageString__Group__0 ) ) )
            // InternalIRML.g:394:2: ( ( rule__LanguageString__Group__0 ) )
            {
            // InternalIRML.g:394:2: ( ( rule__LanguageString__Group__0 ) )
            // InternalIRML.g:395:3: ( rule__LanguageString__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageStringAccess().getGroup()); 
            }
            // InternalIRML.g:396:3: ( rule__LanguageString__Group__0 )
            // InternalIRML.g:396:4: rule__LanguageString__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LanguageString__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageStringAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, ruleLanguageString_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLanguageString"


    // $ANTLR start "entryRuleLiteral"
    // InternalIRML.g:405:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        int entryRuleLiteral_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return ; }
            // InternalIRML.g:406:1: ( ruleLiteral EOF )
            // InternalIRML.g:407:1: ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, entryRuleLiteral_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalIRML.g:414:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {
        int ruleLiteral_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return ; }
            // InternalIRML.g:418:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalIRML.g:419:2: ( ( rule__Literal__Alternatives ) )
            {
            // InternalIRML.g:419:2: ( ( rule__Literal__Alternatives ) )
            // InternalIRML.g:420:3: ( rule__Literal__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getAlternatives()); 
            }
            // InternalIRML.g:421:3: ( rule__Literal__Alternatives )
            // InternalIRML.g:421:4: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, ruleLiteral_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleDatatypeString"
    // InternalIRML.g:430:1: entryRuleDatatypeString : ruleDatatypeString EOF ;
    public final void entryRuleDatatypeString() throws RecognitionException {
        int entryRuleDatatypeString_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return ; }
            // InternalIRML.g:431:1: ( ruleDatatypeString EOF )
            // InternalIRML.g:432:1: ruleDatatypeString EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeStringRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDatatypeString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeStringRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, entryRuleDatatypeString_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleDatatypeString"


    // $ANTLR start "ruleDatatypeString"
    // InternalIRML.g:439:1: ruleDatatypeString : ( ( rule__DatatypeString__Group__0 ) ) ;
    public final void ruleDatatypeString() throws RecognitionException {
        int ruleDatatypeString_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return ; }
            // InternalIRML.g:443:2: ( ( ( rule__DatatypeString__Group__0 ) ) )
            // InternalIRML.g:444:2: ( ( rule__DatatypeString__Group__0 ) )
            {
            // InternalIRML.g:444:2: ( ( rule__DatatypeString__Group__0 ) )
            // InternalIRML.g:445:3: ( rule__DatatypeString__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeStringAccess().getGroup()); 
            }
            // InternalIRML.g:446:3: ( rule__DatatypeString__Group__0 )
            // InternalIRML.g:446:4: rule__DatatypeString__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DatatypeString__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeStringAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, ruleDatatypeString_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDatatypeString"


    // $ANTLR start "entryRuleBoolean"
    // InternalIRML.g:455:1: entryRuleBoolean : ruleBoolean EOF ;
    public final void entryRuleBoolean() throws RecognitionException {
        int entryRuleBoolean_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return ; }
            // InternalIRML.g:456:1: ( ruleBoolean EOF )
            // InternalIRML.g:457:1: ruleBoolean EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBoolean();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, entryRuleBoolean_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // InternalIRML.g:464:1: ruleBoolean : ( ( rule__Boolean__Alternatives ) ) ;
    public final void ruleBoolean() throws RecognitionException {
        int ruleBoolean_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return ; }
            // InternalIRML.g:468:2: ( ( ( rule__Boolean__Alternatives ) ) )
            // InternalIRML.g:469:2: ( ( rule__Boolean__Alternatives ) )
            {
            // InternalIRML.g:469:2: ( ( rule__Boolean__Alternatives ) )
            // InternalIRML.g:470:3: ( rule__Boolean__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanAccess().getAlternatives()); 
            }
            // InternalIRML.g:471:3: ( rule__Boolean__Alternatives )
            // InternalIRML.g:471:4: rule__Boolean__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Boolean__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, ruleBoolean_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleBlank"
    // InternalIRML.g:480:1: entryRuleBlank : ruleBlank EOF ;
    public final void entryRuleBlank() throws RecognitionException {
        int entryRuleBlank_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }
            // InternalIRML.g:481:1: ( ruleBlank EOF )
            // InternalIRML.g:482:1: ruleBlank EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBlank();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, entryRuleBlank_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleBlank"


    // $ANTLR start "ruleBlank"
    // InternalIRML.g:489:1: ruleBlank : ( ( rule__Blank__Alternatives ) ) ;
    public final void ruleBlank() throws RecognitionException {
        int ruleBlank_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return ; }
            // InternalIRML.g:493:2: ( ( ( rule__Blank__Alternatives ) ) )
            // InternalIRML.g:494:2: ( ( rule__Blank__Alternatives ) )
            {
            // InternalIRML.g:494:2: ( ( rule__Blank__Alternatives ) )
            // InternalIRML.g:495:3: ( rule__Blank__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankAccess().getAlternatives()); 
            }
            // InternalIRML.g:496:3: ( rule__Blank__Alternatives )
            // InternalIRML.g:496:4: rule__Blank__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Blank__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, ruleBlank_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBlank"


    // $ANTLR start "entryRuleItemList"
    // InternalIRML.g:505:1: entryRuleItemList : ruleItemList EOF ;
    public final void entryRuleItemList() throws RecognitionException {
        int entryRuleItemList_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return ; }
            // InternalIRML.g:506:1: ( ruleItemList EOF )
            // InternalIRML.g:507:1: ruleItemList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getItemListRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleItemList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getItemListRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, entryRuleItemList_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleItemList"


    // $ANTLR start "ruleItemList"
    // InternalIRML.g:514:1: ruleItemList : ( ( rule__ItemList__Group__0 ) ) ;
    public final void ruleItemList() throws RecognitionException {
        int ruleItemList_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return ; }
            // InternalIRML.g:518:2: ( ( ( rule__ItemList__Group__0 ) ) )
            // InternalIRML.g:519:2: ( ( rule__ItemList__Group__0 ) )
            {
            // InternalIRML.g:519:2: ( ( rule__ItemList__Group__0 ) )
            // InternalIRML.g:520:3: ( rule__ItemList__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getItemListAccess().getGroup()); 
            }
            // InternalIRML.g:521:3: ( rule__ItemList__Group__0 )
            // InternalIRML.g:521:4: rule__ItemList__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ItemList__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getItemListAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, ruleItemList_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleItemList"


    // $ANTLR start "entryRuleCollection"
    // InternalIRML.g:530:1: entryRuleCollection : ruleCollection EOF ;
    public final void entryRuleCollection() throws RecognitionException {
        int entryRuleCollection_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return ; }
            // InternalIRML.g:531:1: ( ruleCollection EOF )
            // InternalIRML.g:532:1: ruleCollection EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCollection();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, entryRuleCollection_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleCollection"


    // $ANTLR start "ruleCollection"
    // InternalIRML.g:539:1: ruleCollection : ( ( rule__Collection__Group__0 ) ) ;
    public final void ruleCollection() throws RecognitionException {
        int ruleCollection_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return ; }
            // InternalIRML.g:543:2: ( ( ( rule__Collection__Group__0 ) ) )
            // InternalIRML.g:544:2: ( ( rule__Collection__Group__0 ) )
            {
            // InternalIRML.g:544:2: ( ( rule__Collection__Group__0 ) )
            // InternalIRML.g:545:3: ( rule__Collection__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionAccess().getGroup()); 
            }
            // InternalIRML.g:546:3: ( rule__Collection__Group__0 )
            // InternalIRML.g:546:4: rule__Collection__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Collection__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 40, ruleCollection_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCollection"


    // $ANTLR start "entryRuleiResource"
    // InternalIRML.g:555:1: entryRuleiResource : ruleiResource EOF ;
    public final void entryRuleiResource() throws RecognitionException {
        int entryRuleiResource_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return ; }
            // InternalIRML.g:556:1: ( ruleiResource EOF )
            // InternalIRML.g:557:1: ruleiResource EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIResourceRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleiResource();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIResourceRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, entryRuleiResource_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleiResource"


    // $ANTLR start "ruleiResource"
    // InternalIRML.g:564:1: ruleiResource : ( ( rule__IResource__Alternatives ) ) ;
    public final void ruleiResource() throws RecognitionException {
        int ruleiResource_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return ; }
            // InternalIRML.g:568:2: ( ( ( rule__IResource__Alternatives ) ) )
            // InternalIRML.g:569:2: ( ( rule__IResource__Alternatives ) )
            {
            // InternalIRML.g:569:2: ( ( rule__IResource__Alternatives ) )
            // InternalIRML.g:570:3: ( rule__IResource__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIResourceAccess().getAlternatives()); 
            }
            // InternalIRML.g:571:3: ( rule__IResource__Alternatives )
            // InternalIRML.g:571:4: rule__IResource__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__IResource__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIResourceAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 42, ruleiResource_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleiResource"


    // $ANTLR start "entryRuleNodeID"
    // InternalIRML.g:580:1: entryRuleNodeID : ruleNodeID EOF ;
    public final void entryRuleNodeID() throws RecognitionException {
        int entryRuleNodeID_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return ; }
            // InternalIRML.g:581:1: ( ruleNodeID EOF )
            // InternalIRML.g:582:1: ruleNodeID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNodeIDRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleNodeID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNodeIDRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, entryRuleNodeID_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleNodeID"


    // $ANTLR start "ruleNodeID"
    // InternalIRML.g:589:1: ruleNodeID : ( ( rule__NodeID__Group__0 ) ) ;
    public final void ruleNodeID() throws RecognitionException {
        int ruleNodeID_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return ; }
            // InternalIRML.g:593:2: ( ( ( rule__NodeID__Group__0 ) ) )
            // InternalIRML.g:594:2: ( ( rule__NodeID__Group__0 ) )
            {
            // InternalIRML.g:594:2: ( ( rule__NodeID__Group__0 ) )
            // InternalIRML.g:595:3: ( rule__NodeID__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNodeIDAccess().getGroup()); 
            }
            // InternalIRML.g:596:3: ( rule__NodeID__Group__0 )
            // InternalIRML.g:596:4: rule__NodeID__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NodeID__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNodeIDAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 44, ruleNodeID_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNodeID"


    // $ANTLR start "entryRuleQname"
    // InternalIRML.g:605:1: entryRuleQname : ruleQname EOF ;
    public final void entryRuleQname() throws RecognitionException {
        int entryRuleQname_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return ; }
            // InternalIRML.g:606:1: ( ruleQname EOF )
            // InternalIRML.g:607:1: ruleQname EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQnameRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQname();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQnameRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, entryRuleQname_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleQname"


    // $ANTLR start "ruleQname"
    // InternalIRML.g:614:1: ruleQname : ( ( rule__Qname__Group__0 ) ) ;
    public final void ruleQname() throws RecognitionException {
        int ruleQname_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return ; }
            // InternalIRML.g:618:2: ( ( ( rule__Qname__Group__0 ) ) )
            // InternalIRML.g:619:2: ( ( rule__Qname__Group__0 ) )
            {
            // InternalIRML.g:619:2: ( ( rule__Qname__Group__0 ) )
            // InternalIRML.g:620:3: ( rule__Qname__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQnameAccess().getGroup()); 
            }
            // InternalIRML.g:621:3: ( rule__Qname__Group__0 )
            // InternalIRML.g:621:4: rule__Qname__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Qname__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQnameAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 46, ruleQname_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQname"


    // $ANTLR start "entryRulePrefixName"
    // InternalIRML.g:630:1: entryRulePrefixName : rulePrefixName EOF ;
    public final void entryRulePrefixName() throws RecognitionException {
        int entryRulePrefixName_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return ; }
            // InternalIRML.g:631:1: ( rulePrefixName EOF )
            // InternalIRML.g:632:1: rulePrefixName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixNameRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePrefixName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixNameRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, entryRulePrefixName_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRulePrefixName"


    // $ANTLR start "rulePrefixName"
    // InternalIRML.g:639:1: rulePrefixName : ( ( rule__PrefixName__Group__0 ) ) ;
    public final void rulePrefixName() throws RecognitionException {
        int rulePrefixName_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return ; }
            // InternalIRML.g:643:2: ( ( ( rule__PrefixName__Group__0 ) ) )
            // InternalIRML.g:644:2: ( ( rule__PrefixName__Group__0 ) )
            {
            // InternalIRML.g:644:2: ( ( rule__PrefixName__Group__0 ) )
            // InternalIRML.g:645:3: ( rule__PrefixName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixNameAccess().getGroup()); 
            }
            // InternalIRML.g:646:3: ( rule__PrefixName__Group__0 )
            // InternalIRML.g:646:4: rule__PrefixName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PrefixName__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixNameAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 48, rulePrefixName_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrefixName"


    // $ANTLR start "entryRuleQuotedString"
    // InternalIRML.g:655:1: entryRuleQuotedString : ruleQuotedString EOF ;
    public final void entryRuleQuotedString() throws RecognitionException {
        int entryRuleQuotedString_StartIndex = input.index();
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return ; }
            // InternalIRML.g:656:1: ( ruleQuotedString EOF )
            // InternalIRML.g:657:1: ruleQuotedString EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuotedStringRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleQuotedString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuotedStringRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, entryRuleQuotedString_StartIndex); }
        }
        return ;
    }
    // $ANTLR end "entryRuleQuotedString"


    // $ANTLR start "ruleQuotedString"
    // InternalIRML.g:664:1: ruleQuotedString : ( RULE_STRING ) ;
    public final void ruleQuotedString() throws RecognitionException {
        int ruleQuotedString_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return ; }
            // InternalIRML.g:668:2: ( ( RULE_STRING ) )
            // InternalIRML.g:669:2: ( RULE_STRING )
            {
            // InternalIRML.g:669:2: ( RULE_STRING )
            // InternalIRML.g:670:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQuotedStringAccess().getSTRINGTerminalRuleCall()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQuotedStringAccess().getSTRINGTerminalRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 50, ruleQuotedString_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuotedString"


    // $ANTLR start "rule__Statement__Alternatives_0"
    // InternalIRML.g:679:1: rule__Statement__Alternatives_0 : ( ( ( rule__Statement__DirectiveAssignment_0_0 ) ) | ( ( rule__Statement__TripleAssignment_0_1 ) ) );
    public final void rule__Statement__Alternatives_0() throws RecognitionException {
        int rule__Statement__Alternatives_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return ; }
            // InternalIRML.g:683:1: ( ( ( rule__Statement__DirectiveAssignment_0_0 ) ) | ( ( rule__Statement__TripleAssignment_0_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=18 && LA2_0<=19)) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_URIREF)||LA2_0==24||LA2_0==26||(LA2_0>=28 && LA2_0<=29)||LA2_0==31) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalIRML.g:684:2: ( ( rule__Statement__DirectiveAssignment_0_0 ) )
                    {
                    // InternalIRML.g:684:2: ( ( rule__Statement__DirectiveAssignment_0_0 ) )
                    // InternalIRML.g:685:3: ( rule__Statement__DirectiveAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getDirectiveAssignment_0_0()); 
                    }
                    // InternalIRML.g:686:3: ( rule__Statement__DirectiveAssignment_0_0 )
                    // InternalIRML.g:686:4: rule__Statement__DirectiveAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Statement__DirectiveAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getDirectiveAssignment_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:690:2: ( ( rule__Statement__TripleAssignment_0_1 ) )
                    {
                    // InternalIRML.g:690:2: ( ( rule__Statement__TripleAssignment_0_1 ) )
                    // InternalIRML.g:691:3: ( rule__Statement__TripleAssignment_0_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getStatementAccess().getTripleAssignment_0_1()); 
                    }
                    // InternalIRML.g:692:3: ( rule__Statement__TripleAssignment_0_1 )
                    // InternalIRML.g:692:4: rule__Statement__TripleAssignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Statement__TripleAssignment_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getStatementAccess().getTripleAssignment_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, rule__Statement__Alternatives_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Alternatives_0"


    // $ANTLR start "rule__Directive__Alternatives"
    // InternalIRML.g:700:1: rule__Directive__Alternatives : ( ( ( rule__Directive__PrefixAssignment_0 ) ) | ( ( rule__Directive__BaseAssignment_1 ) ) );
    public final void rule__Directive__Alternatives() throws RecognitionException {
        int rule__Directive__Alternatives_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return ; }
            // InternalIRML.g:704:1: ( ( ( rule__Directive__PrefixAssignment_0 ) ) | ( ( rule__Directive__BaseAssignment_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            else if ( (LA3_0==19) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalIRML.g:705:2: ( ( rule__Directive__PrefixAssignment_0 ) )
                    {
                    // InternalIRML.g:705:2: ( ( rule__Directive__PrefixAssignment_0 ) )
                    // InternalIRML.g:706:3: ( rule__Directive__PrefixAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDirectiveAccess().getPrefixAssignment_0()); 
                    }
                    // InternalIRML.g:707:3: ( rule__Directive__PrefixAssignment_0 )
                    // InternalIRML.g:707:4: rule__Directive__PrefixAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Directive__PrefixAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDirectiveAccess().getPrefixAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:711:2: ( ( rule__Directive__BaseAssignment_1 ) )
                    {
                    // InternalIRML.g:711:2: ( ( rule__Directive__BaseAssignment_1 ) )
                    // InternalIRML.g:712:3: ( rule__Directive__BaseAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getDirectiveAccess().getBaseAssignment_1()); 
                    }
                    // InternalIRML.g:713:3: ( rule__Directive__BaseAssignment_1 )
                    // InternalIRML.g:713:4: rule__Directive__BaseAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Directive__BaseAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getDirectiveAccess().getBaseAssignment_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 52, rule__Directive__Alternatives_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Directive__Alternatives"


    // $ANTLR start "rule__Verb__Alternatives"
    // InternalIRML.g:721:1: rule__Verb__Alternatives : ( ( ( rule__Verb__PredicateAssignment_0 ) ) | ( ( rule__Verb__IsAAssignment_1 ) ) );
    public final void rule__Verb__Alternatives() throws RecognitionException {
        int rule__Verb__Alternatives_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return ; }
            // InternalIRML.g:725:1: ( ( ( rule__Verb__PredicateAssignment_0 ) ) | ( ( rule__Verb__IsAAssignment_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_URIREF)||LA4_0==29) ) {
                alt4=1;
            }
            else if ( (LA4_0==30) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalIRML.g:726:2: ( ( rule__Verb__PredicateAssignment_0 ) )
                    {
                    // InternalIRML.g:726:2: ( ( rule__Verb__PredicateAssignment_0 ) )
                    // InternalIRML.g:727:3: ( rule__Verb__PredicateAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVerbAccess().getPredicateAssignment_0()); 
                    }
                    // InternalIRML.g:728:3: ( rule__Verb__PredicateAssignment_0 )
                    // InternalIRML.g:728:4: rule__Verb__PredicateAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Verb__PredicateAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVerbAccess().getPredicateAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:732:2: ( ( rule__Verb__IsAAssignment_1 ) )
                    {
                    // InternalIRML.g:732:2: ( ( rule__Verb__IsAAssignment_1 ) )
                    // InternalIRML.g:733:3: ( rule__Verb__IsAAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVerbAccess().getIsAAssignment_1()); 
                    }
                    // InternalIRML.g:734:3: ( rule__Verb__IsAAssignment_1 )
                    // InternalIRML.g:734:4: rule__Verb__IsAAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Verb__IsAAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVerbAccess().getIsAAssignment_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 53, rule__Verb__Alternatives_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Verb__Alternatives"


    // $ANTLR start "rule__Subject__Alternatives"
    // InternalIRML.g:742:1: rule__Subject__Alternatives : ( ( ( rule__Subject__ResourceAssignment_0 ) ) | ( ( rule__Subject__BlankAssignment_1 ) ) );
    public final void rule__Subject__Alternatives() throws RecognitionException {
        int rule__Subject__Alternatives_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return ; }
            // InternalIRML.g:746:1: ( ( ( rule__Subject__ResourceAssignment_0 ) ) | ( ( rule__Subject__BlankAssignment_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_URIREF)||LA5_0==29) ) {
                alt5=1;
            }
            else if ( (LA5_0==24||LA5_0==26||LA5_0==28||LA5_0==31) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalIRML.g:747:2: ( ( rule__Subject__ResourceAssignment_0 ) )
                    {
                    // InternalIRML.g:747:2: ( ( rule__Subject__ResourceAssignment_0 ) )
                    // InternalIRML.g:748:3: ( rule__Subject__ResourceAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSubjectAccess().getResourceAssignment_0()); 
                    }
                    // InternalIRML.g:749:3: ( rule__Subject__ResourceAssignment_0 )
                    // InternalIRML.g:749:4: rule__Subject__ResourceAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Subject__ResourceAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSubjectAccess().getResourceAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:753:2: ( ( rule__Subject__BlankAssignment_1 ) )
                    {
                    // InternalIRML.g:753:2: ( ( rule__Subject__BlankAssignment_1 ) )
                    // InternalIRML.g:754:3: ( rule__Subject__BlankAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getSubjectAccess().getBlankAssignment_1()); 
                    }
                    // InternalIRML.g:755:3: ( rule__Subject__BlankAssignment_1 )
                    // InternalIRML.g:755:4: rule__Subject__BlankAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Subject__BlankAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getSubjectAccess().getBlankAssignment_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 54, rule__Subject__Alternatives_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Subject__Alternatives"


    // $ANTLR start "rule__Object__Alternatives"
    // InternalIRML.g:763:1: rule__Object__Alternatives : ( ( ( rule__Object__ResourceAssignment_0 ) ) | ( ( rule__Object__BlankAssignment_1 ) ) | ( ( rule__Object__LiteralAssignment_2 ) ) );
    public final void rule__Object__Alternatives() throws RecognitionException {
        int rule__Object__Alternatives_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return ; }
            // InternalIRML.g:767:1: ( ( ( rule__Object__ResourceAssignment_0 ) ) | ( ( rule__Object__BlankAssignment_1 ) ) | ( ( rule__Object__LiteralAssignment_2 ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_URIREF:
            case 29:
                {
                alt6=1;
                }
                break;
            case 24:
            case 26:
            case 28:
            case 31:
                {
                alt6=2;
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case RULE_DOUBLE:
            case RULE_DECIMAL:
            case 15:
            case 16:
                {
                alt6=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalIRML.g:768:2: ( ( rule__Object__ResourceAssignment_0 ) )
                    {
                    // InternalIRML.g:768:2: ( ( rule__Object__ResourceAssignment_0 ) )
                    // InternalIRML.g:769:3: ( rule__Object__ResourceAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getResourceAssignment_0()); 
                    }
                    // InternalIRML.g:770:3: ( rule__Object__ResourceAssignment_0 )
                    // InternalIRML.g:770:4: rule__Object__ResourceAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Object__ResourceAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getResourceAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:774:2: ( ( rule__Object__BlankAssignment_1 ) )
                    {
                    // InternalIRML.g:774:2: ( ( rule__Object__BlankAssignment_1 ) )
                    // InternalIRML.g:775:3: ( rule__Object__BlankAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getBlankAssignment_1()); 
                    }
                    // InternalIRML.g:776:3: ( rule__Object__BlankAssignment_1 )
                    // InternalIRML.g:776:4: rule__Object__BlankAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Object__BlankAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getBlankAssignment_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalIRML.g:780:2: ( ( rule__Object__LiteralAssignment_2 ) )
                    {
                    // InternalIRML.g:780:2: ( ( rule__Object__LiteralAssignment_2 ) )
                    // InternalIRML.g:781:3: ( rule__Object__LiteralAssignment_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getLiteralAssignment_2()); 
                    }
                    // InternalIRML.g:782:3: ( rule__Object__LiteralAssignment_2 )
                    // InternalIRML.g:782:4: rule__Object__LiteralAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Object__LiteralAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getLiteralAssignment_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, rule__Object__Alternatives_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Alternatives"


    // $ANTLR start "rule__Literal__Alternatives"
    // InternalIRML.g:790:1: rule__Literal__Alternatives : ( ( ( rule__Literal__LanguageStringAssignment_0 ) ) | ( ( rule__Literal__DatatypeStringAssignment_1 ) ) | ( ( rule__Literal__DwordAssignment_2 ) ) | ( ( rule__Literal__RealAssignment_3 ) ) | ( ( rule__Literal__DecimalAssignment_4 ) ) | ( ( rule__Literal__BoolAssignment_5 ) ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {
        int rule__Literal__Alternatives_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return ; }
            // InternalIRML.g:794:1: ( ( ( rule__Literal__LanguageStringAssignment_0 ) ) | ( ( rule__Literal__DatatypeStringAssignment_1 ) ) | ( ( rule__Literal__DwordAssignment_2 ) ) | ( ( rule__Literal__RealAssignment_3 ) ) | ( ( rule__Literal__DecimalAssignment_4 ) ) | ( ( rule__Literal__BoolAssignment_5 ) ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==EOF||(LA7_1>=RULE_STRING && LA7_1<=RULE_DECIMAL)||(LA7_1>=15 && LA7_1<=17)||(LA7_1>=20 && LA7_1<=22)||(LA7_1>=24 && LA7_1<=29)||LA7_1==31) ) {
                    alt7=1;
                }
                else if ( (LA7_1==23) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt7=3;
                }
                break;
            case RULE_DOUBLE:
                {
                alt7=4;
                }
                break;
            case RULE_DECIMAL:
                {
                alt7=5;
                }
                break;
            case 15:
            case 16:
                {
                alt7=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalIRML.g:795:2: ( ( rule__Literal__LanguageStringAssignment_0 ) )
                    {
                    // InternalIRML.g:795:2: ( ( rule__Literal__LanguageStringAssignment_0 ) )
                    // InternalIRML.g:796:3: ( rule__Literal__LanguageStringAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getLanguageStringAssignment_0()); 
                    }
                    // InternalIRML.g:797:3: ( rule__Literal__LanguageStringAssignment_0 )
                    // InternalIRML.g:797:4: rule__Literal__LanguageStringAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__LanguageStringAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getLanguageStringAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:801:2: ( ( rule__Literal__DatatypeStringAssignment_1 ) )
                    {
                    // InternalIRML.g:801:2: ( ( rule__Literal__DatatypeStringAssignment_1 ) )
                    // InternalIRML.g:802:3: ( rule__Literal__DatatypeStringAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getDatatypeStringAssignment_1()); 
                    }
                    // InternalIRML.g:803:3: ( rule__Literal__DatatypeStringAssignment_1 )
                    // InternalIRML.g:803:4: rule__Literal__DatatypeStringAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__DatatypeStringAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getDatatypeStringAssignment_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalIRML.g:807:2: ( ( rule__Literal__DwordAssignment_2 ) )
                    {
                    // InternalIRML.g:807:2: ( ( rule__Literal__DwordAssignment_2 ) )
                    // InternalIRML.g:808:3: ( rule__Literal__DwordAssignment_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getDwordAssignment_2()); 
                    }
                    // InternalIRML.g:809:3: ( rule__Literal__DwordAssignment_2 )
                    // InternalIRML.g:809:4: rule__Literal__DwordAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__DwordAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getDwordAssignment_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalIRML.g:813:2: ( ( rule__Literal__RealAssignment_3 ) )
                    {
                    // InternalIRML.g:813:2: ( ( rule__Literal__RealAssignment_3 ) )
                    // InternalIRML.g:814:3: ( rule__Literal__RealAssignment_3 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getRealAssignment_3()); 
                    }
                    // InternalIRML.g:815:3: ( rule__Literal__RealAssignment_3 )
                    // InternalIRML.g:815:4: rule__Literal__RealAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__RealAssignment_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getRealAssignment_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalIRML.g:819:2: ( ( rule__Literal__DecimalAssignment_4 ) )
                    {
                    // InternalIRML.g:819:2: ( ( rule__Literal__DecimalAssignment_4 ) )
                    // InternalIRML.g:820:3: ( rule__Literal__DecimalAssignment_4 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getDecimalAssignment_4()); 
                    }
                    // InternalIRML.g:821:3: ( rule__Literal__DecimalAssignment_4 )
                    // InternalIRML.g:821:4: rule__Literal__DecimalAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__DecimalAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getDecimalAssignment_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalIRML.g:825:2: ( ( rule__Literal__BoolAssignment_5 ) )
                    {
                    // InternalIRML.g:825:2: ( ( rule__Literal__BoolAssignment_5 ) )
                    // InternalIRML.g:826:3: ( rule__Literal__BoolAssignment_5 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralAccess().getBoolAssignment_5()); 
                    }
                    // InternalIRML.g:827:3: ( rule__Literal__BoolAssignment_5 )
                    // InternalIRML.g:827:4: rule__Literal__BoolAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__Literal__BoolAssignment_5();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralAccess().getBoolAssignment_5()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 56, rule__Literal__Alternatives_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__Boolean__Alternatives"
    // InternalIRML.g:835:1: rule__Boolean__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__Boolean__Alternatives() throws RecognitionException {
        int rule__Boolean__Alternatives_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return ; }
            // InternalIRML.g:839:1: ( ( 'true' ) | ( 'false' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            else if ( (LA8_0==16) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalIRML.g:840:2: ( 'true' )
                    {
                    // InternalIRML.g:840:2: ( 'true' )
                    // InternalIRML.g:841:3: 'true'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanAccess().getTrueKeyword_0()); 
                    }
                    match(input,15,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanAccess().getTrueKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:846:2: ( 'false' )
                    {
                    // InternalIRML.g:846:2: ( 'false' )
                    // InternalIRML.g:847:3: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanAccess().getFalseKeyword_1()); 
                    }
                    match(input,16,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanAccess().getFalseKeyword_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 57, rule__Boolean__Alternatives_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Boolean__Alternatives"


    // $ANTLR start "rule__Blank__Alternatives"
    // InternalIRML.g:856:1: rule__Blank__Alternatives : ( ( ( rule__Blank__NodeIDAssignment_0 ) ) | ( ( rule__Blank__IsSquareAssignment_1 ) ) | ( ( rule__Blank__Group_2__0 ) ) | ( ( rule__Blank__CollectionAssignment_3 ) ) );
    public final void rule__Blank__Alternatives() throws RecognitionException {
        int rule__Blank__Alternatives_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return ; }
            // InternalIRML.g:860:1: ( ( ( rule__Blank__NodeIDAssignment_0 ) ) | ( ( rule__Blank__IsSquareAssignment_1 ) ) | ( ( rule__Blank__Group_2__0 ) ) | ( ( rule__Blank__CollectionAssignment_3 ) ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt9=1;
                }
                break;
            case 31:
                {
                alt9=2;
                }
                break;
            case 24:
                {
                alt9=3;
                }
                break;
            case 26:
                {
                alt9=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalIRML.g:861:2: ( ( rule__Blank__NodeIDAssignment_0 ) )
                    {
                    // InternalIRML.g:861:2: ( ( rule__Blank__NodeIDAssignment_0 ) )
                    // InternalIRML.g:862:3: ( rule__Blank__NodeIDAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBlankAccess().getNodeIDAssignment_0()); 
                    }
                    // InternalIRML.g:863:3: ( rule__Blank__NodeIDAssignment_0 )
                    // InternalIRML.g:863:4: rule__Blank__NodeIDAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Blank__NodeIDAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBlankAccess().getNodeIDAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:867:2: ( ( rule__Blank__IsSquareAssignment_1 ) )
                    {
                    // InternalIRML.g:867:2: ( ( rule__Blank__IsSquareAssignment_1 ) )
                    // InternalIRML.g:868:3: ( rule__Blank__IsSquareAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBlankAccess().getIsSquareAssignment_1()); 
                    }
                    // InternalIRML.g:869:3: ( rule__Blank__IsSquareAssignment_1 )
                    // InternalIRML.g:869:4: rule__Blank__IsSquareAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Blank__IsSquareAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBlankAccess().getIsSquareAssignment_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalIRML.g:873:2: ( ( rule__Blank__Group_2__0 ) )
                    {
                    // InternalIRML.g:873:2: ( ( rule__Blank__Group_2__0 ) )
                    // InternalIRML.g:874:3: ( rule__Blank__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBlankAccess().getGroup_2()); 
                    }
                    // InternalIRML.g:875:3: ( rule__Blank__Group_2__0 )
                    // InternalIRML.g:875:4: rule__Blank__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Blank__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBlankAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalIRML.g:879:2: ( ( rule__Blank__CollectionAssignment_3 ) )
                    {
                    // InternalIRML.g:879:2: ( ( rule__Blank__CollectionAssignment_3 ) )
                    // InternalIRML.g:880:3: ( rule__Blank__CollectionAssignment_3 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBlankAccess().getCollectionAssignment_3()); 
                    }
                    // InternalIRML.g:881:3: ( rule__Blank__CollectionAssignment_3 )
                    // InternalIRML.g:881:4: rule__Blank__CollectionAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Blank__CollectionAssignment_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBlankAccess().getCollectionAssignment_3()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 58, rule__Blank__Alternatives_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Blank__Alternatives"


    // $ANTLR start "rule__IResource__Alternatives"
    // InternalIRML.g:889:1: rule__IResource__Alternatives : ( ( ( rule__IResource__UriRefAssignment_0 ) ) | ( ( rule__IResource__QnameAssignment_1 ) ) );
    public final void rule__IResource__Alternatives() throws RecognitionException {
        int rule__IResource__Alternatives_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return ; }
            // InternalIRML.g:893:1: ( ( ( rule__IResource__UriRefAssignment_0 ) ) | ( ( rule__IResource__QnameAssignment_1 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_URIREF) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_ID||LA10_0==29) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalIRML.g:894:2: ( ( rule__IResource__UriRefAssignment_0 ) )
                    {
                    // InternalIRML.g:894:2: ( ( rule__IResource__UriRefAssignment_0 ) )
                    // InternalIRML.g:895:3: ( rule__IResource__UriRefAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIResourceAccess().getUriRefAssignment_0()); 
                    }
                    // InternalIRML.g:896:3: ( rule__IResource__UriRefAssignment_0 )
                    // InternalIRML.g:896:4: rule__IResource__UriRefAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IResource__UriRefAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIResourceAccess().getUriRefAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:900:2: ( ( rule__IResource__QnameAssignment_1 ) )
                    {
                    // InternalIRML.g:900:2: ( ( rule__IResource__QnameAssignment_1 ) )
                    // InternalIRML.g:901:3: ( rule__IResource__QnameAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getIResourceAccess().getQnameAssignment_1()); 
                    }
                    // InternalIRML.g:902:3: ( rule__IResource__QnameAssignment_1 )
                    // InternalIRML.g:902:4: rule__IResource__QnameAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__IResource__QnameAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getIResourceAccess().getQnameAssignment_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, rule__IResource__Alternatives_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IResource__Alternatives"


    // $ANTLR start "rule__Statement__Group__0"
    // InternalIRML.g:910:1: rule__Statement__Group__0 : rule__Statement__Group__0__Impl rule__Statement__Group__1 ;
    public final void rule__Statement__Group__0() throws RecognitionException {
        int rule__Statement__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return ; }
            // InternalIRML.g:914:1: ( rule__Statement__Group__0__Impl rule__Statement__Group__1 )
            // InternalIRML.g:915:2: rule__Statement__Group__0__Impl rule__Statement__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Statement__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Statement__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 60, rule__Statement__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group__0"


    // $ANTLR start "rule__Statement__Group__0__Impl"
    // InternalIRML.g:922:1: rule__Statement__Group__0__Impl : ( ( rule__Statement__Alternatives_0 ) ) ;
    public final void rule__Statement__Group__0__Impl() throws RecognitionException {
        int rule__Statement__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return ; }
            // InternalIRML.g:926:1: ( ( ( rule__Statement__Alternatives_0 ) ) )
            // InternalIRML.g:927:1: ( ( rule__Statement__Alternatives_0 ) )
            {
            // InternalIRML.g:927:1: ( ( rule__Statement__Alternatives_0 ) )
            // InternalIRML.g:928:2: ( rule__Statement__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getAlternatives_0()); 
            }
            // InternalIRML.g:929:2: ( rule__Statement__Alternatives_0 )
            // InternalIRML.g:929:3: rule__Statement__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Statement__Alternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getAlternatives_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, rule__Statement__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group__0__Impl"


    // $ANTLR start "rule__Statement__Group__1"
    // InternalIRML.g:937:1: rule__Statement__Group__1 : rule__Statement__Group__1__Impl ;
    public final void rule__Statement__Group__1() throws RecognitionException {
        int rule__Statement__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return ; }
            // InternalIRML.g:941:1: ( rule__Statement__Group__1__Impl )
            // InternalIRML.g:942:2: rule__Statement__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Statement__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 62, rule__Statement__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group__1"


    // $ANTLR start "rule__Statement__Group__1__Impl"
    // InternalIRML.g:948:1: rule__Statement__Group__1__Impl : ( '.' ) ;
    public final void rule__Statement__Group__1__Impl() throws RecognitionException {
        int rule__Statement__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return ; }
            // InternalIRML.g:952:1: ( ( '.' ) )
            // InternalIRML.g:953:1: ( '.' )
            {
            // InternalIRML.g:953:1: ( '.' )
            // InternalIRML.g:954:2: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getFullStopKeyword_1()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getFullStopKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 63, rule__Statement__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group__1__Impl"


    // $ANTLR start "rule__PrefixID__Group__0"
    // InternalIRML.g:964:1: rule__PrefixID__Group__0 : rule__PrefixID__Group__0__Impl rule__PrefixID__Group__1 ;
    public final void rule__PrefixID__Group__0() throws RecognitionException {
        int rule__PrefixID__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return ; }
            // InternalIRML.g:968:1: ( rule__PrefixID__Group__0__Impl rule__PrefixID__Group__1 )
            // InternalIRML.g:969:2: rule__PrefixID__Group__0__Impl rule__PrefixID__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__PrefixID__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrefixID__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 64, rule__PrefixID__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixID__Group__0"


    // $ANTLR start "rule__PrefixID__Group__0__Impl"
    // InternalIRML.g:976:1: rule__PrefixID__Group__0__Impl : ( '@prefix' ) ;
    public final void rule__PrefixID__Group__0__Impl() throws RecognitionException {
        int rule__PrefixID__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return ; }
            // InternalIRML.g:980:1: ( ( '@prefix' ) )
            // InternalIRML.g:981:1: ( '@prefix' )
            {
            // InternalIRML.g:981:1: ( '@prefix' )
            // InternalIRML.g:982:2: '@prefix'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixIDAccess().getPrefixKeyword_0()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixIDAccess().getPrefixKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 65, rule__PrefixID__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixID__Group__0__Impl"


    // $ANTLR start "rule__PrefixID__Group__1"
    // InternalIRML.g:991:1: rule__PrefixID__Group__1 : rule__PrefixID__Group__1__Impl rule__PrefixID__Group__2 ;
    public final void rule__PrefixID__Group__1() throws RecognitionException {
        int rule__PrefixID__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return ; }
            // InternalIRML.g:995:1: ( rule__PrefixID__Group__1__Impl rule__PrefixID__Group__2 )
            // InternalIRML.g:996:2: rule__PrefixID__Group__1__Impl rule__PrefixID__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__PrefixID__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrefixID__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 66, rule__PrefixID__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixID__Group__1"


    // $ANTLR start "rule__PrefixID__Group__1__Impl"
    // InternalIRML.g:1003:1: rule__PrefixID__Group__1__Impl : ( ( rule__PrefixID__PrefixNameAssignment_1 ) ) ;
    public final void rule__PrefixID__Group__1__Impl() throws RecognitionException {
        int rule__PrefixID__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return ; }
            // InternalIRML.g:1007:1: ( ( ( rule__PrefixID__PrefixNameAssignment_1 ) ) )
            // InternalIRML.g:1008:1: ( ( rule__PrefixID__PrefixNameAssignment_1 ) )
            {
            // InternalIRML.g:1008:1: ( ( rule__PrefixID__PrefixNameAssignment_1 ) )
            // InternalIRML.g:1009:2: ( rule__PrefixID__PrefixNameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixIDAccess().getPrefixNameAssignment_1()); 
            }
            // InternalIRML.g:1010:2: ( rule__PrefixID__PrefixNameAssignment_1 )
            // InternalIRML.g:1010:3: rule__PrefixID__PrefixNameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PrefixID__PrefixNameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixIDAccess().getPrefixNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, rule__PrefixID__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixID__Group__1__Impl"


    // $ANTLR start "rule__PrefixID__Group__2"
    // InternalIRML.g:1018:1: rule__PrefixID__Group__2 : rule__PrefixID__Group__2__Impl ;
    public final void rule__PrefixID__Group__2() throws RecognitionException {
        int rule__PrefixID__Group__2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return ; }
            // InternalIRML.g:1022:1: ( rule__PrefixID__Group__2__Impl )
            // InternalIRML.g:1023:2: rule__PrefixID__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrefixID__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 68, rule__PrefixID__Group__2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixID__Group__2"


    // $ANTLR start "rule__PrefixID__Group__2__Impl"
    // InternalIRML.g:1029:1: rule__PrefixID__Group__2__Impl : ( ( rule__PrefixID__UriRefAssignment_2 ) ) ;
    public final void rule__PrefixID__Group__2__Impl() throws RecognitionException {
        int rule__PrefixID__Group__2__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return ; }
            // InternalIRML.g:1033:1: ( ( ( rule__PrefixID__UriRefAssignment_2 ) ) )
            // InternalIRML.g:1034:1: ( ( rule__PrefixID__UriRefAssignment_2 ) )
            {
            // InternalIRML.g:1034:1: ( ( rule__PrefixID__UriRefAssignment_2 ) )
            // InternalIRML.g:1035:2: ( rule__PrefixID__UriRefAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixIDAccess().getUriRefAssignment_2()); 
            }
            // InternalIRML.g:1036:2: ( rule__PrefixID__UriRefAssignment_2 )
            // InternalIRML.g:1036:3: rule__PrefixID__UriRefAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__PrefixID__UriRefAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixIDAccess().getUriRefAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, rule__PrefixID__Group__2__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixID__Group__2__Impl"


    // $ANTLR start "rule__Base__Group__0"
    // InternalIRML.g:1045:1: rule__Base__Group__0 : rule__Base__Group__0__Impl rule__Base__Group__1 ;
    public final void rule__Base__Group__0() throws RecognitionException {
        int rule__Base__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return ; }
            // InternalIRML.g:1049:1: ( rule__Base__Group__0__Impl rule__Base__Group__1 )
            // InternalIRML.g:1050:2: rule__Base__Group__0__Impl rule__Base__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Base__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Base__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 70, rule__Base__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Base__Group__0"


    // $ANTLR start "rule__Base__Group__0__Impl"
    // InternalIRML.g:1057:1: rule__Base__Group__0__Impl : ( '@base' ) ;
    public final void rule__Base__Group__0__Impl() throws RecognitionException {
        int rule__Base__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return ; }
            // InternalIRML.g:1061:1: ( ( '@base' ) )
            // InternalIRML.g:1062:1: ( '@base' )
            {
            // InternalIRML.g:1062:1: ( '@base' )
            // InternalIRML.g:1063:2: '@base'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseAccess().getBaseKeyword_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseAccess().getBaseKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, rule__Base__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Base__Group__0__Impl"


    // $ANTLR start "rule__Base__Group__1"
    // InternalIRML.g:1072:1: rule__Base__Group__1 : rule__Base__Group__1__Impl ;
    public final void rule__Base__Group__1() throws RecognitionException {
        int rule__Base__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return ; }
            // InternalIRML.g:1076:1: ( rule__Base__Group__1__Impl )
            // InternalIRML.g:1077:2: rule__Base__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Base__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, rule__Base__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Base__Group__1"


    // $ANTLR start "rule__Base__Group__1__Impl"
    // InternalIRML.g:1083:1: rule__Base__Group__1__Impl : ( ( rule__Base__UriRefAssignment_1 ) ) ;
    public final void rule__Base__Group__1__Impl() throws RecognitionException {
        int rule__Base__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return ; }
            // InternalIRML.g:1087:1: ( ( ( rule__Base__UriRefAssignment_1 ) ) )
            // InternalIRML.g:1088:1: ( ( rule__Base__UriRefAssignment_1 ) )
            {
            // InternalIRML.g:1088:1: ( ( rule__Base__UriRefAssignment_1 ) )
            // InternalIRML.g:1089:2: ( rule__Base__UriRefAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseAccess().getUriRefAssignment_1()); 
            }
            // InternalIRML.g:1090:2: ( rule__Base__UriRefAssignment_1 )
            // InternalIRML.g:1090:3: rule__Base__UriRefAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Base__UriRefAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseAccess().getUriRefAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, rule__Base__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Base__Group__1__Impl"


    // $ANTLR start "rule__Triples__Group__0"
    // InternalIRML.g:1099:1: rule__Triples__Group__0 : rule__Triples__Group__0__Impl rule__Triples__Group__1 ;
    public final void rule__Triples__Group__0() throws RecognitionException {
        int rule__Triples__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return ; }
            // InternalIRML.g:1103:1: ( rule__Triples__Group__0__Impl rule__Triples__Group__1 )
            // InternalIRML.g:1104:2: rule__Triples__Group__0__Impl rule__Triples__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Triples__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Triples__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 74, rule__Triples__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triples__Group__0"


    // $ANTLR start "rule__Triples__Group__0__Impl"
    // InternalIRML.g:1111:1: rule__Triples__Group__0__Impl : ( ( rule__Triples__SubjectAssignment_0 ) ) ;
    public final void rule__Triples__Group__0__Impl() throws RecognitionException {
        int rule__Triples__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return ; }
            // InternalIRML.g:1115:1: ( ( ( rule__Triples__SubjectAssignment_0 ) ) )
            // InternalIRML.g:1116:1: ( ( rule__Triples__SubjectAssignment_0 ) )
            {
            // InternalIRML.g:1116:1: ( ( rule__Triples__SubjectAssignment_0 ) )
            // InternalIRML.g:1117:2: ( rule__Triples__SubjectAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTriplesAccess().getSubjectAssignment_0()); 
            }
            // InternalIRML.g:1118:2: ( rule__Triples__SubjectAssignment_0 )
            // InternalIRML.g:1118:3: rule__Triples__SubjectAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Triples__SubjectAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTriplesAccess().getSubjectAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 75, rule__Triples__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triples__Group__0__Impl"


    // $ANTLR start "rule__Triples__Group__1"
    // InternalIRML.g:1126:1: rule__Triples__Group__1 : rule__Triples__Group__1__Impl ;
    public final void rule__Triples__Group__1() throws RecognitionException {
        int rule__Triples__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return ; }
            // InternalIRML.g:1130:1: ( rule__Triples__Group__1__Impl )
            // InternalIRML.g:1131:2: rule__Triples__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Triples__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 76, rule__Triples__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triples__Group__1"


    // $ANTLR start "rule__Triples__Group__1__Impl"
    // InternalIRML.g:1137:1: rule__Triples__Group__1__Impl : ( ( rule__Triples__PredicateObjectListAssignment_1 ) ) ;
    public final void rule__Triples__Group__1__Impl() throws RecognitionException {
        int rule__Triples__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return ; }
            // InternalIRML.g:1141:1: ( ( ( rule__Triples__PredicateObjectListAssignment_1 ) ) )
            // InternalIRML.g:1142:1: ( ( rule__Triples__PredicateObjectListAssignment_1 ) )
            {
            // InternalIRML.g:1142:1: ( ( rule__Triples__PredicateObjectListAssignment_1 ) )
            // InternalIRML.g:1143:2: ( rule__Triples__PredicateObjectListAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTriplesAccess().getPredicateObjectListAssignment_1()); 
            }
            // InternalIRML.g:1144:2: ( rule__Triples__PredicateObjectListAssignment_1 )
            // InternalIRML.g:1144:3: rule__Triples__PredicateObjectListAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Triples__PredicateObjectListAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTriplesAccess().getPredicateObjectListAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 77, rule__Triples__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triples__Group__1__Impl"


    // $ANTLR start "rule__PredicateObject__Group__0"
    // InternalIRML.g:1153:1: rule__PredicateObject__Group__0 : rule__PredicateObject__Group__0__Impl rule__PredicateObject__Group__1 ;
    public final void rule__PredicateObject__Group__0() throws RecognitionException {
        int rule__PredicateObject__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return ; }
            // InternalIRML.g:1157:1: ( rule__PredicateObject__Group__0__Impl rule__PredicateObject__Group__1 )
            // InternalIRML.g:1158:2: rule__PredicateObject__Group__0__Impl rule__PredicateObject__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__PredicateObject__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PredicateObject__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 78, rule__PredicateObject__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObject__Group__0"


    // $ANTLR start "rule__PredicateObject__Group__0__Impl"
    // InternalIRML.g:1165:1: rule__PredicateObject__Group__0__Impl : ( ( rule__PredicateObject__VerbAssignment_0 ) ) ;
    public final void rule__PredicateObject__Group__0__Impl() throws RecognitionException {
        int rule__PredicateObject__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return ; }
            // InternalIRML.g:1169:1: ( ( ( rule__PredicateObject__VerbAssignment_0 ) ) )
            // InternalIRML.g:1170:1: ( ( rule__PredicateObject__VerbAssignment_0 ) )
            {
            // InternalIRML.g:1170:1: ( ( rule__PredicateObject__VerbAssignment_0 ) )
            // InternalIRML.g:1171:2: ( rule__PredicateObject__VerbAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectAccess().getVerbAssignment_0()); 
            }
            // InternalIRML.g:1172:2: ( rule__PredicateObject__VerbAssignment_0 )
            // InternalIRML.g:1172:3: rule__PredicateObject__VerbAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PredicateObject__VerbAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectAccess().getVerbAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 79, rule__PredicateObject__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObject__Group__0__Impl"


    // $ANTLR start "rule__PredicateObject__Group__1"
    // InternalIRML.g:1180:1: rule__PredicateObject__Group__1 : rule__PredicateObject__Group__1__Impl ;
    public final void rule__PredicateObject__Group__1() throws RecognitionException {
        int rule__PredicateObject__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return ; }
            // InternalIRML.g:1184:1: ( rule__PredicateObject__Group__1__Impl )
            // InternalIRML.g:1185:2: rule__PredicateObject__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PredicateObject__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 80, rule__PredicateObject__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObject__Group__1"


    // $ANTLR start "rule__PredicateObject__Group__1__Impl"
    // InternalIRML.g:1191:1: rule__PredicateObject__Group__1__Impl : ( ( rule__PredicateObject__ObjectListAssignment_1 ) ) ;
    public final void rule__PredicateObject__Group__1__Impl() throws RecognitionException {
        int rule__PredicateObject__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return ; }
            // InternalIRML.g:1195:1: ( ( ( rule__PredicateObject__ObjectListAssignment_1 ) ) )
            // InternalIRML.g:1196:1: ( ( rule__PredicateObject__ObjectListAssignment_1 ) )
            {
            // InternalIRML.g:1196:1: ( ( rule__PredicateObject__ObjectListAssignment_1 ) )
            // InternalIRML.g:1197:2: ( rule__PredicateObject__ObjectListAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectAccess().getObjectListAssignment_1()); 
            }
            // InternalIRML.g:1198:2: ( rule__PredicateObject__ObjectListAssignment_1 )
            // InternalIRML.g:1198:3: rule__PredicateObject__ObjectListAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PredicateObject__ObjectListAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectAccess().getObjectListAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 81, rule__PredicateObject__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObject__Group__1__Impl"


    // $ANTLR start "rule__PredicateObjectList__Group__0"
    // InternalIRML.g:1207:1: rule__PredicateObjectList__Group__0 : rule__PredicateObjectList__Group__0__Impl rule__PredicateObjectList__Group__1 ;
    public final void rule__PredicateObjectList__Group__0() throws RecognitionException {
        int rule__PredicateObjectList__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return ; }
            // InternalIRML.g:1211:1: ( rule__PredicateObjectList__Group__0__Impl rule__PredicateObjectList__Group__1 )
            // InternalIRML.g:1212:2: rule__PredicateObjectList__Group__0__Impl rule__PredicateObjectList__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__PredicateObjectList__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PredicateObjectList__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 82, rule__PredicateObjectList__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObjectList__Group__0"


    // $ANTLR start "rule__PredicateObjectList__Group__0__Impl"
    // InternalIRML.g:1219:1: rule__PredicateObjectList__Group__0__Impl : ( ( rule__PredicateObjectList__PredicateObjectsAssignment_0 ) ) ;
    public final void rule__PredicateObjectList__Group__0__Impl() throws RecognitionException {
        int rule__PredicateObjectList__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return ; }
            // InternalIRML.g:1223:1: ( ( ( rule__PredicateObjectList__PredicateObjectsAssignment_0 ) ) )
            // InternalIRML.g:1224:1: ( ( rule__PredicateObjectList__PredicateObjectsAssignment_0 ) )
            {
            // InternalIRML.g:1224:1: ( ( rule__PredicateObjectList__PredicateObjectsAssignment_0 ) )
            // InternalIRML.g:1225:2: ( rule__PredicateObjectList__PredicateObjectsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectListAccess().getPredicateObjectsAssignment_0()); 
            }
            // InternalIRML.g:1226:2: ( rule__PredicateObjectList__PredicateObjectsAssignment_0 )
            // InternalIRML.g:1226:3: rule__PredicateObjectList__PredicateObjectsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PredicateObjectList__PredicateObjectsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectListAccess().getPredicateObjectsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 83, rule__PredicateObjectList__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObjectList__Group__0__Impl"


    // $ANTLR start "rule__PredicateObjectList__Group__1"
    // InternalIRML.g:1234:1: rule__PredicateObjectList__Group__1 : rule__PredicateObjectList__Group__1__Impl rule__PredicateObjectList__Group__2 ;
    public final void rule__PredicateObjectList__Group__1() throws RecognitionException {
        int rule__PredicateObjectList__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return ; }
            // InternalIRML.g:1238:1: ( rule__PredicateObjectList__Group__1__Impl rule__PredicateObjectList__Group__2 )
            // InternalIRML.g:1239:2: rule__PredicateObjectList__Group__1__Impl rule__PredicateObjectList__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__PredicateObjectList__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PredicateObjectList__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 84, rule__PredicateObjectList__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObjectList__Group__1"


    // $ANTLR start "rule__PredicateObjectList__Group__1__Impl"
    // InternalIRML.g:1246:1: rule__PredicateObjectList__Group__1__Impl : ( ( rule__PredicateObjectList__Group_1__0 )* ) ;
    public final void rule__PredicateObjectList__Group__1__Impl() throws RecognitionException {
        int rule__PredicateObjectList__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return ; }
            // InternalIRML.g:1250:1: ( ( ( rule__PredicateObjectList__Group_1__0 )* ) )
            // InternalIRML.g:1251:1: ( ( rule__PredicateObjectList__Group_1__0 )* )
            {
            // InternalIRML.g:1251:1: ( ( rule__PredicateObjectList__Group_1__0 )* )
            // InternalIRML.g:1252:2: ( rule__PredicateObjectList__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectListAccess().getGroup_1()); 
            }
            // InternalIRML.g:1253:2: ( rule__PredicateObjectList__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==20) ) {
                    int LA11_1 = input.LA(2);

                    if ( ((LA11_1>=RULE_ID && LA11_1<=RULE_URIREF)||(LA11_1>=29 && LA11_1<=30)) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // InternalIRML.g:1253:3: rule__PredicateObjectList__Group_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__PredicateObjectList__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectListAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 85, rule__PredicateObjectList__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObjectList__Group__1__Impl"


    // $ANTLR start "rule__PredicateObjectList__Group__2"
    // InternalIRML.g:1261:1: rule__PredicateObjectList__Group__2 : rule__PredicateObjectList__Group__2__Impl ;
    public final void rule__PredicateObjectList__Group__2() throws RecognitionException {
        int rule__PredicateObjectList__Group__2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return ; }
            // InternalIRML.g:1265:1: ( rule__PredicateObjectList__Group__2__Impl )
            // InternalIRML.g:1266:2: rule__PredicateObjectList__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PredicateObjectList__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 86, rule__PredicateObjectList__Group__2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObjectList__Group__2"


    // $ANTLR start "rule__PredicateObjectList__Group__2__Impl"
    // InternalIRML.g:1272:1: rule__PredicateObjectList__Group__2__Impl : ( ( ';' )? ) ;
    public final void rule__PredicateObjectList__Group__2__Impl() throws RecognitionException {
        int rule__PredicateObjectList__Group__2__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return ; }
            // InternalIRML.g:1276:1: ( ( ( ';' )? ) )
            // InternalIRML.g:1277:1: ( ( ';' )? )
            {
            // InternalIRML.g:1277:1: ( ( ';' )? )
            // InternalIRML.g:1278:2: ( ';' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectListAccess().getSemicolonKeyword_2()); 
            }
            // InternalIRML.g:1279:2: ( ';' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalIRML.g:1279:3: ';'
                    {
                    match(input,20,FOLLOW_2); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectListAccess().getSemicolonKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 87, rule__PredicateObjectList__Group__2__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObjectList__Group__2__Impl"


    // $ANTLR start "rule__PredicateObjectList__Group_1__0"
    // InternalIRML.g:1288:1: rule__PredicateObjectList__Group_1__0 : rule__PredicateObjectList__Group_1__0__Impl rule__PredicateObjectList__Group_1__1 ;
    public final void rule__PredicateObjectList__Group_1__0() throws RecognitionException {
        int rule__PredicateObjectList__Group_1__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return ; }
            // InternalIRML.g:1292:1: ( rule__PredicateObjectList__Group_1__0__Impl rule__PredicateObjectList__Group_1__1 )
            // InternalIRML.g:1293:2: rule__PredicateObjectList__Group_1__0__Impl rule__PredicateObjectList__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__PredicateObjectList__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PredicateObjectList__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 88, rule__PredicateObjectList__Group_1__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObjectList__Group_1__0"


    // $ANTLR start "rule__PredicateObjectList__Group_1__0__Impl"
    // InternalIRML.g:1300:1: rule__PredicateObjectList__Group_1__0__Impl : ( ';' ) ;
    public final void rule__PredicateObjectList__Group_1__0__Impl() throws RecognitionException {
        int rule__PredicateObjectList__Group_1__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return ; }
            // InternalIRML.g:1304:1: ( ( ';' ) )
            // InternalIRML.g:1305:1: ( ';' )
            {
            // InternalIRML.g:1305:1: ( ';' )
            // InternalIRML.g:1306:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectListAccess().getSemicolonKeyword_1_0()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectListAccess().getSemicolonKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 89, rule__PredicateObjectList__Group_1__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObjectList__Group_1__0__Impl"


    // $ANTLR start "rule__PredicateObjectList__Group_1__1"
    // InternalIRML.g:1315:1: rule__PredicateObjectList__Group_1__1 : rule__PredicateObjectList__Group_1__1__Impl ;
    public final void rule__PredicateObjectList__Group_1__1() throws RecognitionException {
        int rule__PredicateObjectList__Group_1__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return ; }
            // InternalIRML.g:1319:1: ( rule__PredicateObjectList__Group_1__1__Impl )
            // InternalIRML.g:1320:2: rule__PredicateObjectList__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PredicateObjectList__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 90, rule__PredicateObjectList__Group_1__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObjectList__Group_1__1"


    // $ANTLR start "rule__PredicateObjectList__Group_1__1__Impl"
    // InternalIRML.g:1326:1: rule__PredicateObjectList__Group_1__1__Impl : ( ( rule__PredicateObjectList__PredicateObjectsAssignment_1_1 ) ) ;
    public final void rule__PredicateObjectList__Group_1__1__Impl() throws RecognitionException {
        int rule__PredicateObjectList__Group_1__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return ; }
            // InternalIRML.g:1330:1: ( ( ( rule__PredicateObjectList__PredicateObjectsAssignment_1_1 ) ) )
            // InternalIRML.g:1331:1: ( ( rule__PredicateObjectList__PredicateObjectsAssignment_1_1 ) )
            {
            // InternalIRML.g:1331:1: ( ( rule__PredicateObjectList__PredicateObjectsAssignment_1_1 ) )
            // InternalIRML.g:1332:2: ( rule__PredicateObjectList__PredicateObjectsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectListAccess().getPredicateObjectsAssignment_1_1()); 
            }
            // InternalIRML.g:1333:2: ( rule__PredicateObjectList__PredicateObjectsAssignment_1_1 )
            // InternalIRML.g:1333:3: rule__PredicateObjectList__PredicateObjectsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PredicateObjectList__PredicateObjectsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectListAccess().getPredicateObjectsAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 91, rule__PredicateObjectList__Group_1__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObjectList__Group_1__1__Impl"


    // $ANTLR start "rule__ObjectList__Group__0"
    // InternalIRML.g:1342:1: rule__ObjectList__Group__0 : rule__ObjectList__Group__0__Impl rule__ObjectList__Group__1 ;
    public final void rule__ObjectList__Group__0() throws RecognitionException {
        int rule__ObjectList__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return ; }
            // InternalIRML.g:1346:1: ( rule__ObjectList__Group__0__Impl rule__ObjectList__Group__1 )
            // InternalIRML.g:1347:2: rule__ObjectList__Group__0__Impl rule__ObjectList__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__ObjectList__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ObjectList__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 92, rule__ObjectList__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectList__Group__0"


    // $ANTLR start "rule__ObjectList__Group__0__Impl"
    // InternalIRML.g:1354:1: rule__ObjectList__Group__0__Impl : ( ( rule__ObjectList__ObjectsAssignment_0 ) ) ;
    public final void rule__ObjectList__Group__0__Impl() throws RecognitionException {
        int rule__ObjectList__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return ; }
            // InternalIRML.g:1358:1: ( ( ( rule__ObjectList__ObjectsAssignment_0 ) ) )
            // InternalIRML.g:1359:1: ( ( rule__ObjectList__ObjectsAssignment_0 ) )
            {
            // InternalIRML.g:1359:1: ( ( rule__ObjectList__ObjectsAssignment_0 ) )
            // InternalIRML.g:1360:2: ( rule__ObjectList__ObjectsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectListAccess().getObjectsAssignment_0()); 
            }
            // InternalIRML.g:1361:2: ( rule__ObjectList__ObjectsAssignment_0 )
            // InternalIRML.g:1361:3: rule__ObjectList__ObjectsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ObjectList__ObjectsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectListAccess().getObjectsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 93, rule__ObjectList__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectList__Group__0__Impl"


    // $ANTLR start "rule__ObjectList__Group__1"
    // InternalIRML.g:1369:1: rule__ObjectList__Group__1 : rule__ObjectList__Group__1__Impl ;
    public final void rule__ObjectList__Group__1() throws RecognitionException {
        int rule__ObjectList__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return ; }
            // InternalIRML.g:1373:1: ( rule__ObjectList__Group__1__Impl )
            // InternalIRML.g:1374:2: rule__ObjectList__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ObjectList__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 94, rule__ObjectList__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectList__Group__1"


    // $ANTLR start "rule__ObjectList__Group__1__Impl"
    // InternalIRML.g:1380:1: rule__ObjectList__Group__1__Impl : ( ( rule__ObjectList__Group_1__0 )* ) ;
    public final void rule__ObjectList__Group__1__Impl() throws RecognitionException {
        int rule__ObjectList__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return ; }
            // InternalIRML.g:1384:1: ( ( ( rule__ObjectList__Group_1__0 )* ) )
            // InternalIRML.g:1385:1: ( ( rule__ObjectList__Group_1__0 )* )
            {
            // InternalIRML.g:1385:1: ( ( rule__ObjectList__Group_1__0 )* )
            // InternalIRML.g:1386:2: ( rule__ObjectList__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectListAccess().getGroup_1()); 
            }
            // InternalIRML.g:1387:2: ( rule__ObjectList__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==21) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalIRML.g:1387:3: rule__ObjectList__Group_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__ObjectList__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectListAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 95, rule__ObjectList__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectList__Group__1__Impl"


    // $ANTLR start "rule__ObjectList__Group_1__0"
    // InternalIRML.g:1396:1: rule__ObjectList__Group_1__0 : rule__ObjectList__Group_1__0__Impl rule__ObjectList__Group_1__1 ;
    public final void rule__ObjectList__Group_1__0() throws RecognitionException {
        int rule__ObjectList__Group_1__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return ; }
            // InternalIRML.g:1400:1: ( rule__ObjectList__Group_1__0__Impl rule__ObjectList__Group_1__1 )
            // InternalIRML.g:1401:2: rule__ObjectList__Group_1__0__Impl rule__ObjectList__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__ObjectList__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ObjectList__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 96, rule__ObjectList__Group_1__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectList__Group_1__0"


    // $ANTLR start "rule__ObjectList__Group_1__0__Impl"
    // InternalIRML.g:1408:1: rule__ObjectList__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ObjectList__Group_1__0__Impl() throws RecognitionException {
        int rule__ObjectList__Group_1__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return ; }
            // InternalIRML.g:1412:1: ( ( ',' ) )
            // InternalIRML.g:1413:1: ( ',' )
            {
            // InternalIRML.g:1413:1: ( ',' )
            // InternalIRML.g:1414:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectListAccess().getCommaKeyword_1_0()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectListAccess().getCommaKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 97, rule__ObjectList__Group_1__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectList__Group_1__0__Impl"


    // $ANTLR start "rule__ObjectList__Group_1__1"
    // InternalIRML.g:1423:1: rule__ObjectList__Group_1__1 : rule__ObjectList__Group_1__1__Impl ;
    public final void rule__ObjectList__Group_1__1() throws RecognitionException {
        int rule__ObjectList__Group_1__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return ; }
            // InternalIRML.g:1427:1: ( rule__ObjectList__Group_1__1__Impl )
            // InternalIRML.g:1428:2: rule__ObjectList__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ObjectList__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 98, rule__ObjectList__Group_1__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectList__Group_1__1"


    // $ANTLR start "rule__ObjectList__Group_1__1__Impl"
    // InternalIRML.g:1434:1: rule__ObjectList__Group_1__1__Impl : ( ( rule__ObjectList__ObjectsAssignment_1_1 ) ) ;
    public final void rule__ObjectList__Group_1__1__Impl() throws RecognitionException {
        int rule__ObjectList__Group_1__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return ; }
            // InternalIRML.g:1438:1: ( ( ( rule__ObjectList__ObjectsAssignment_1_1 ) ) )
            // InternalIRML.g:1439:1: ( ( rule__ObjectList__ObjectsAssignment_1_1 ) )
            {
            // InternalIRML.g:1439:1: ( ( rule__ObjectList__ObjectsAssignment_1_1 ) )
            // InternalIRML.g:1440:2: ( rule__ObjectList__ObjectsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectListAccess().getObjectsAssignment_1_1()); 
            }
            // InternalIRML.g:1441:2: ( rule__ObjectList__ObjectsAssignment_1_1 )
            // InternalIRML.g:1441:3: rule__ObjectList__ObjectsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ObjectList__ObjectsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectListAccess().getObjectsAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 99, rule__ObjectList__Group_1__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectList__Group_1__1__Impl"


    // $ANTLR start "rule__LanguageString__Group__0"
    // InternalIRML.g:1450:1: rule__LanguageString__Group__0 : rule__LanguageString__Group__0__Impl rule__LanguageString__Group__1 ;
    public final void rule__LanguageString__Group__0() throws RecognitionException {
        int rule__LanguageString__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return ; }
            // InternalIRML.g:1454:1: ( rule__LanguageString__Group__0__Impl rule__LanguageString__Group__1 )
            // InternalIRML.g:1455:2: rule__LanguageString__Group__0__Impl rule__LanguageString__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__LanguageString__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LanguageString__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 100, rule__LanguageString__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageString__Group__0"


    // $ANTLR start "rule__LanguageString__Group__0__Impl"
    // InternalIRML.g:1462:1: rule__LanguageString__Group__0__Impl : ( ( rule__LanguageString__QutoedStringAssignment_0 ) ) ;
    public final void rule__LanguageString__Group__0__Impl() throws RecognitionException {
        int rule__LanguageString__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return ; }
            // InternalIRML.g:1466:1: ( ( ( rule__LanguageString__QutoedStringAssignment_0 ) ) )
            // InternalIRML.g:1467:1: ( ( rule__LanguageString__QutoedStringAssignment_0 ) )
            {
            // InternalIRML.g:1467:1: ( ( rule__LanguageString__QutoedStringAssignment_0 ) )
            // InternalIRML.g:1468:2: ( rule__LanguageString__QutoedStringAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageStringAccess().getQutoedStringAssignment_0()); 
            }
            // InternalIRML.g:1469:2: ( rule__LanguageString__QutoedStringAssignment_0 )
            // InternalIRML.g:1469:3: rule__LanguageString__QutoedStringAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__LanguageString__QutoedStringAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageStringAccess().getQutoedStringAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 101, rule__LanguageString__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageString__Group__0__Impl"


    // $ANTLR start "rule__LanguageString__Group__1"
    // InternalIRML.g:1477:1: rule__LanguageString__Group__1 : rule__LanguageString__Group__1__Impl ;
    public final void rule__LanguageString__Group__1() throws RecognitionException {
        int rule__LanguageString__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return ; }
            // InternalIRML.g:1481:1: ( rule__LanguageString__Group__1__Impl )
            // InternalIRML.g:1482:2: rule__LanguageString__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LanguageString__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 102, rule__LanguageString__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageString__Group__1"


    // $ANTLR start "rule__LanguageString__Group__1__Impl"
    // InternalIRML.g:1488:1: rule__LanguageString__Group__1__Impl : ( ( rule__LanguageString__Group_1__0 )? ) ;
    public final void rule__LanguageString__Group__1__Impl() throws RecognitionException {
        int rule__LanguageString__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return ; }
            // InternalIRML.g:1492:1: ( ( ( rule__LanguageString__Group_1__0 )? ) )
            // InternalIRML.g:1493:1: ( ( rule__LanguageString__Group_1__0 )? )
            {
            // InternalIRML.g:1493:1: ( ( rule__LanguageString__Group_1__0 )? )
            // InternalIRML.g:1494:2: ( rule__LanguageString__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageStringAccess().getGroup_1()); 
            }
            // InternalIRML.g:1495:2: ( rule__LanguageString__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalIRML.g:1495:3: rule__LanguageString__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__LanguageString__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageStringAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 103, rule__LanguageString__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageString__Group__1__Impl"


    // $ANTLR start "rule__LanguageString__Group_1__0"
    // InternalIRML.g:1504:1: rule__LanguageString__Group_1__0 : rule__LanguageString__Group_1__0__Impl rule__LanguageString__Group_1__1 ;
    public final void rule__LanguageString__Group_1__0() throws RecognitionException {
        int rule__LanguageString__Group_1__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 104) ) { return ; }
            // InternalIRML.g:1508:1: ( rule__LanguageString__Group_1__0__Impl rule__LanguageString__Group_1__1 )
            // InternalIRML.g:1509:2: rule__LanguageString__Group_1__0__Impl rule__LanguageString__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__LanguageString__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LanguageString__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 104, rule__LanguageString__Group_1__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageString__Group_1__0"


    // $ANTLR start "rule__LanguageString__Group_1__0__Impl"
    // InternalIRML.g:1516:1: rule__LanguageString__Group_1__0__Impl : ( '@' ) ;
    public final void rule__LanguageString__Group_1__0__Impl() throws RecognitionException {
        int rule__LanguageString__Group_1__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return ; }
            // InternalIRML.g:1520:1: ( ( '@' ) )
            // InternalIRML.g:1521:1: ( '@' )
            {
            // InternalIRML.g:1521:1: ( '@' )
            // InternalIRML.g:1522:2: '@'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageStringAccess().getCommercialAtKeyword_1_0()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageStringAccess().getCommercialAtKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 105, rule__LanguageString__Group_1__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageString__Group_1__0__Impl"


    // $ANTLR start "rule__LanguageString__Group_1__1"
    // InternalIRML.g:1531:1: rule__LanguageString__Group_1__1 : rule__LanguageString__Group_1__1__Impl ;
    public final void rule__LanguageString__Group_1__1() throws RecognitionException {
        int rule__LanguageString__Group_1__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return ; }
            // InternalIRML.g:1535:1: ( rule__LanguageString__Group_1__1__Impl )
            // InternalIRML.g:1536:2: rule__LanguageString__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LanguageString__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 106, rule__LanguageString__Group_1__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageString__Group_1__1"


    // $ANTLR start "rule__LanguageString__Group_1__1__Impl"
    // InternalIRML.g:1542:1: rule__LanguageString__Group_1__1__Impl : ( ( rule__LanguageString__LangAssignment_1_1 ) ) ;
    public final void rule__LanguageString__Group_1__1__Impl() throws RecognitionException {
        int rule__LanguageString__Group_1__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return ; }
            // InternalIRML.g:1546:1: ( ( ( rule__LanguageString__LangAssignment_1_1 ) ) )
            // InternalIRML.g:1547:1: ( ( rule__LanguageString__LangAssignment_1_1 ) )
            {
            // InternalIRML.g:1547:1: ( ( rule__LanguageString__LangAssignment_1_1 ) )
            // InternalIRML.g:1548:2: ( rule__LanguageString__LangAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageStringAccess().getLangAssignment_1_1()); 
            }
            // InternalIRML.g:1549:2: ( rule__LanguageString__LangAssignment_1_1 )
            // InternalIRML.g:1549:3: rule__LanguageString__LangAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__LanguageString__LangAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageStringAccess().getLangAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 107, rule__LanguageString__Group_1__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageString__Group_1__1__Impl"


    // $ANTLR start "rule__DatatypeString__Group__0"
    // InternalIRML.g:1558:1: rule__DatatypeString__Group__0 : rule__DatatypeString__Group__0__Impl rule__DatatypeString__Group__1 ;
    public final void rule__DatatypeString__Group__0() throws RecognitionException {
        int rule__DatatypeString__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return ; }
            // InternalIRML.g:1562:1: ( rule__DatatypeString__Group__0__Impl rule__DatatypeString__Group__1 )
            // InternalIRML.g:1563:2: rule__DatatypeString__Group__0__Impl rule__DatatypeString__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__DatatypeString__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DatatypeString__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 108, rule__DatatypeString__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DatatypeString__Group__0"


    // $ANTLR start "rule__DatatypeString__Group__0__Impl"
    // InternalIRML.g:1570:1: rule__DatatypeString__Group__0__Impl : ( ( rule__DatatypeString__QutoedStringAssignment_0 ) ) ;
    public final void rule__DatatypeString__Group__0__Impl() throws RecognitionException {
        int rule__DatatypeString__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 109) ) { return ; }
            // InternalIRML.g:1574:1: ( ( ( rule__DatatypeString__QutoedStringAssignment_0 ) ) )
            // InternalIRML.g:1575:1: ( ( rule__DatatypeString__QutoedStringAssignment_0 ) )
            {
            // InternalIRML.g:1575:1: ( ( rule__DatatypeString__QutoedStringAssignment_0 ) )
            // InternalIRML.g:1576:2: ( rule__DatatypeString__QutoedStringAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeStringAccess().getQutoedStringAssignment_0()); 
            }
            // InternalIRML.g:1577:2: ( rule__DatatypeString__QutoedStringAssignment_0 )
            // InternalIRML.g:1577:3: rule__DatatypeString__QutoedStringAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DatatypeString__QutoedStringAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeStringAccess().getQutoedStringAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 109, rule__DatatypeString__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DatatypeString__Group__0__Impl"


    // $ANTLR start "rule__DatatypeString__Group__1"
    // InternalIRML.g:1585:1: rule__DatatypeString__Group__1 : rule__DatatypeString__Group__1__Impl rule__DatatypeString__Group__2 ;
    public final void rule__DatatypeString__Group__1() throws RecognitionException {
        int rule__DatatypeString__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 110) ) { return ; }
            // InternalIRML.g:1589:1: ( rule__DatatypeString__Group__1__Impl rule__DatatypeString__Group__2 )
            // InternalIRML.g:1590:2: rule__DatatypeString__Group__1__Impl rule__DatatypeString__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__DatatypeString__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DatatypeString__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 110, rule__DatatypeString__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DatatypeString__Group__1"


    // $ANTLR start "rule__DatatypeString__Group__1__Impl"
    // InternalIRML.g:1597:1: rule__DatatypeString__Group__1__Impl : ( '^^' ) ;
    public final void rule__DatatypeString__Group__1__Impl() throws RecognitionException {
        int rule__DatatypeString__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 111) ) { return ; }
            // InternalIRML.g:1601:1: ( ( '^^' ) )
            // InternalIRML.g:1602:1: ( '^^' )
            {
            // InternalIRML.g:1602:1: ( '^^' )
            // InternalIRML.g:1603:2: '^^'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeStringAccess().getCircumflexAccentCircumflexAccentKeyword_1()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeStringAccess().getCircumflexAccentCircumflexAccentKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 111, rule__DatatypeString__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DatatypeString__Group__1__Impl"


    // $ANTLR start "rule__DatatypeString__Group__2"
    // InternalIRML.g:1612:1: rule__DatatypeString__Group__2 : rule__DatatypeString__Group__2__Impl ;
    public final void rule__DatatypeString__Group__2() throws RecognitionException {
        int rule__DatatypeString__Group__2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 112) ) { return ; }
            // InternalIRML.g:1616:1: ( rule__DatatypeString__Group__2__Impl )
            // InternalIRML.g:1617:2: rule__DatatypeString__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DatatypeString__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 112, rule__DatatypeString__Group__2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DatatypeString__Group__2"


    // $ANTLR start "rule__DatatypeString__Group__2__Impl"
    // InternalIRML.g:1623:1: rule__DatatypeString__Group__2__Impl : ( ( rule__DatatypeString__ResourceAssignment_2 ) ) ;
    public final void rule__DatatypeString__Group__2__Impl() throws RecognitionException {
        int rule__DatatypeString__Group__2__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 113) ) { return ; }
            // InternalIRML.g:1627:1: ( ( ( rule__DatatypeString__ResourceAssignment_2 ) ) )
            // InternalIRML.g:1628:1: ( ( rule__DatatypeString__ResourceAssignment_2 ) )
            {
            // InternalIRML.g:1628:1: ( ( rule__DatatypeString__ResourceAssignment_2 ) )
            // InternalIRML.g:1629:2: ( rule__DatatypeString__ResourceAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeStringAccess().getResourceAssignment_2()); 
            }
            // InternalIRML.g:1630:2: ( rule__DatatypeString__ResourceAssignment_2 )
            // InternalIRML.g:1630:3: rule__DatatypeString__ResourceAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DatatypeString__ResourceAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeStringAccess().getResourceAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 113, rule__DatatypeString__Group__2__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DatatypeString__Group__2__Impl"


    // $ANTLR start "rule__Blank__Group_2__0"
    // InternalIRML.g:1639:1: rule__Blank__Group_2__0 : rule__Blank__Group_2__0__Impl rule__Blank__Group_2__1 ;
    public final void rule__Blank__Group_2__0() throws RecognitionException {
        int rule__Blank__Group_2__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 114) ) { return ; }
            // InternalIRML.g:1643:1: ( rule__Blank__Group_2__0__Impl rule__Blank__Group_2__1 )
            // InternalIRML.g:1644:2: rule__Blank__Group_2__0__Impl rule__Blank__Group_2__1
            {
            pushFollow(FOLLOW_7);
            rule__Blank__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Blank__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 114, rule__Blank__Group_2__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Blank__Group_2__0"


    // $ANTLR start "rule__Blank__Group_2__0__Impl"
    // InternalIRML.g:1651:1: rule__Blank__Group_2__0__Impl : ( '[' ) ;
    public final void rule__Blank__Group_2__0__Impl() throws RecognitionException {
        int rule__Blank__Group_2__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 115) ) { return ; }
            // InternalIRML.g:1655:1: ( ( '[' ) )
            // InternalIRML.g:1656:1: ( '[' )
            {
            // InternalIRML.g:1656:1: ( '[' )
            // InternalIRML.g:1657:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankAccess().getLeftSquareBracketKeyword_2_0()); 
            }
            match(input,24,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankAccess().getLeftSquareBracketKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 115, rule__Blank__Group_2__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Blank__Group_2__0__Impl"


    // $ANTLR start "rule__Blank__Group_2__1"
    // InternalIRML.g:1666:1: rule__Blank__Group_2__1 : rule__Blank__Group_2__1__Impl rule__Blank__Group_2__2 ;
    public final void rule__Blank__Group_2__1() throws RecognitionException {
        int rule__Blank__Group_2__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 116) ) { return ; }
            // InternalIRML.g:1670:1: ( rule__Blank__Group_2__1__Impl rule__Blank__Group_2__2 )
            // InternalIRML.g:1671:2: rule__Blank__Group_2__1__Impl rule__Blank__Group_2__2
            {
            pushFollow(FOLLOW_16);
            rule__Blank__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Blank__Group_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 116, rule__Blank__Group_2__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Blank__Group_2__1"


    // $ANTLR start "rule__Blank__Group_2__1__Impl"
    // InternalIRML.g:1678:1: rule__Blank__Group_2__1__Impl : ( ( rule__Blank__PredicateObjectListAssignment_2_1 ) ) ;
    public final void rule__Blank__Group_2__1__Impl() throws RecognitionException {
        int rule__Blank__Group_2__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 117) ) { return ; }
            // InternalIRML.g:1682:1: ( ( ( rule__Blank__PredicateObjectListAssignment_2_1 ) ) )
            // InternalIRML.g:1683:1: ( ( rule__Blank__PredicateObjectListAssignment_2_1 ) )
            {
            // InternalIRML.g:1683:1: ( ( rule__Blank__PredicateObjectListAssignment_2_1 ) )
            // InternalIRML.g:1684:2: ( rule__Blank__PredicateObjectListAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankAccess().getPredicateObjectListAssignment_2_1()); 
            }
            // InternalIRML.g:1685:2: ( rule__Blank__PredicateObjectListAssignment_2_1 )
            // InternalIRML.g:1685:3: rule__Blank__PredicateObjectListAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Blank__PredicateObjectListAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankAccess().getPredicateObjectListAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 117, rule__Blank__Group_2__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Blank__Group_2__1__Impl"


    // $ANTLR start "rule__Blank__Group_2__2"
    // InternalIRML.g:1693:1: rule__Blank__Group_2__2 : rule__Blank__Group_2__2__Impl ;
    public final void rule__Blank__Group_2__2() throws RecognitionException {
        int rule__Blank__Group_2__2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 118) ) { return ; }
            // InternalIRML.g:1697:1: ( rule__Blank__Group_2__2__Impl )
            // InternalIRML.g:1698:2: rule__Blank__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Blank__Group_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 118, rule__Blank__Group_2__2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Blank__Group_2__2"


    // $ANTLR start "rule__Blank__Group_2__2__Impl"
    // InternalIRML.g:1704:1: rule__Blank__Group_2__2__Impl : ( ']' ) ;
    public final void rule__Blank__Group_2__2__Impl() throws RecognitionException {
        int rule__Blank__Group_2__2__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 119) ) { return ; }
            // InternalIRML.g:1708:1: ( ( ']' ) )
            // InternalIRML.g:1709:1: ( ']' )
            {
            // InternalIRML.g:1709:1: ( ']' )
            // InternalIRML.g:1710:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankAccess().getRightSquareBracketKeyword_2_2()); 
            }
            match(input,25,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankAccess().getRightSquareBracketKeyword_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 119, rule__Blank__Group_2__2__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Blank__Group_2__2__Impl"


    // $ANTLR start "rule__ItemList__Group__0"
    // InternalIRML.g:1720:1: rule__ItemList__Group__0 : rule__ItemList__Group__0__Impl rule__ItemList__Group__1 ;
    public final void rule__ItemList__Group__0() throws RecognitionException {
        int rule__ItemList__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 120) ) { return ; }
            // InternalIRML.g:1724:1: ( rule__ItemList__Group__0__Impl rule__ItemList__Group__1 )
            // InternalIRML.g:1725:2: rule__ItemList__Group__0__Impl rule__ItemList__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__ItemList__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ItemList__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 120, rule__ItemList__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemList__Group__0"


    // $ANTLR start "rule__ItemList__Group__0__Impl"
    // InternalIRML.g:1732:1: rule__ItemList__Group__0__Impl : ( ( rule__ItemList__ObjectsAssignment_0 ) ) ;
    public final void rule__ItemList__Group__0__Impl() throws RecognitionException {
        int rule__ItemList__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 121) ) { return ; }
            // InternalIRML.g:1736:1: ( ( ( rule__ItemList__ObjectsAssignment_0 ) ) )
            // InternalIRML.g:1737:1: ( ( rule__ItemList__ObjectsAssignment_0 ) )
            {
            // InternalIRML.g:1737:1: ( ( rule__ItemList__ObjectsAssignment_0 ) )
            // InternalIRML.g:1738:2: ( rule__ItemList__ObjectsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getItemListAccess().getObjectsAssignment_0()); 
            }
            // InternalIRML.g:1739:2: ( rule__ItemList__ObjectsAssignment_0 )
            // InternalIRML.g:1739:3: rule__ItemList__ObjectsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ItemList__ObjectsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getItemListAccess().getObjectsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 121, rule__ItemList__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemList__Group__0__Impl"


    // $ANTLR start "rule__ItemList__Group__1"
    // InternalIRML.g:1747:1: rule__ItemList__Group__1 : rule__ItemList__Group__1__Impl ;
    public final void rule__ItemList__Group__1() throws RecognitionException {
        int rule__ItemList__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 122) ) { return ; }
            // InternalIRML.g:1751:1: ( rule__ItemList__Group__1__Impl )
            // InternalIRML.g:1752:2: rule__ItemList__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ItemList__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 122, rule__ItemList__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemList__Group__1"


    // $ANTLR start "rule__ItemList__Group__1__Impl"
    // InternalIRML.g:1758:1: rule__ItemList__Group__1__Impl : ( ( rule__ItemList__ObjectsAssignment_1 )* ) ;
    public final void rule__ItemList__Group__1__Impl() throws RecognitionException {
        int rule__ItemList__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 123) ) { return ; }
            // InternalIRML.g:1762:1: ( ( ( rule__ItemList__ObjectsAssignment_1 )* ) )
            // InternalIRML.g:1763:1: ( ( rule__ItemList__ObjectsAssignment_1 )* )
            {
            // InternalIRML.g:1763:1: ( ( rule__ItemList__ObjectsAssignment_1 )* )
            // InternalIRML.g:1764:2: ( rule__ItemList__ObjectsAssignment_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getItemListAccess().getObjectsAssignment_1()); 
            }
            // InternalIRML.g:1765:2: ( rule__ItemList__ObjectsAssignment_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_STRING && LA15_0<=RULE_DECIMAL)||(LA15_0>=15 && LA15_0<=16)||LA15_0==24||LA15_0==26||(LA15_0>=28 && LA15_0<=29)||LA15_0==31) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalIRML.g:1765:3: rule__ItemList__ObjectsAssignment_1
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__ItemList__ObjectsAssignment_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getItemListAccess().getObjectsAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 123, rule__ItemList__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemList__Group__1__Impl"


    // $ANTLR start "rule__Collection__Group__0"
    // InternalIRML.g:1774:1: rule__Collection__Group__0 : rule__Collection__Group__0__Impl rule__Collection__Group__1 ;
    public final void rule__Collection__Group__0() throws RecognitionException {
        int rule__Collection__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 124) ) { return ; }
            // InternalIRML.g:1778:1: ( rule__Collection__Group__0__Impl rule__Collection__Group__1 )
            // InternalIRML.g:1779:2: rule__Collection__Group__0__Impl rule__Collection__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Collection__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Collection__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 124, rule__Collection__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collection__Group__0"


    // $ANTLR start "rule__Collection__Group__0__Impl"
    // InternalIRML.g:1786:1: rule__Collection__Group__0__Impl : ( () ) ;
    public final void rule__Collection__Group__0__Impl() throws RecognitionException {
        int rule__Collection__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 125) ) { return ; }
            // InternalIRML.g:1790:1: ( ( () ) )
            // InternalIRML.g:1791:1: ( () )
            {
            // InternalIRML.g:1791:1: ( () )
            // InternalIRML.g:1792:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionAccess().getCollectionAction_0()); 
            }
            // InternalIRML.g:1793:2: ()
            // InternalIRML.g:1793:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionAccess().getCollectionAction_0()); 
            }

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 125, rule__Collection__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collection__Group__0__Impl"


    // $ANTLR start "rule__Collection__Group__1"
    // InternalIRML.g:1801:1: rule__Collection__Group__1 : rule__Collection__Group__1__Impl rule__Collection__Group__2 ;
    public final void rule__Collection__Group__1() throws RecognitionException {
        int rule__Collection__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 126) ) { return ; }
            // InternalIRML.g:1805:1: ( rule__Collection__Group__1__Impl rule__Collection__Group__2 )
            // InternalIRML.g:1806:2: rule__Collection__Group__1__Impl rule__Collection__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__Collection__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Collection__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 126, rule__Collection__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collection__Group__1"


    // $ANTLR start "rule__Collection__Group__1__Impl"
    // InternalIRML.g:1813:1: rule__Collection__Group__1__Impl : ( '(' ) ;
    public final void rule__Collection__Group__1__Impl() throws RecognitionException {
        int rule__Collection__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 127) ) { return ; }
            // InternalIRML.g:1817:1: ( ( '(' ) )
            // InternalIRML.g:1818:1: ( '(' )
            {
            // InternalIRML.g:1818:1: ( '(' )
            // InternalIRML.g:1819:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionAccess().getLeftParenthesisKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 127, rule__Collection__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collection__Group__1__Impl"


    // $ANTLR start "rule__Collection__Group__2"
    // InternalIRML.g:1828:1: rule__Collection__Group__2 : rule__Collection__Group__2__Impl rule__Collection__Group__3 ;
    public final void rule__Collection__Group__2() throws RecognitionException {
        int rule__Collection__Group__2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 128) ) { return ; }
            // InternalIRML.g:1832:1: ( rule__Collection__Group__2__Impl rule__Collection__Group__3 )
            // InternalIRML.g:1833:2: rule__Collection__Group__2__Impl rule__Collection__Group__3
            {
            pushFollow(FOLLOW_19);
            rule__Collection__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Collection__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 128, rule__Collection__Group__2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collection__Group__2"


    // $ANTLR start "rule__Collection__Group__2__Impl"
    // InternalIRML.g:1840:1: rule__Collection__Group__2__Impl : ( ( rule__Collection__ItemListAssignment_2 )? ) ;
    public final void rule__Collection__Group__2__Impl() throws RecognitionException {
        int rule__Collection__Group__2__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 129) ) { return ; }
            // InternalIRML.g:1844:1: ( ( ( rule__Collection__ItemListAssignment_2 )? ) )
            // InternalIRML.g:1845:1: ( ( rule__Collection__ItemListAssignment_2 )? )
            {
            // InternalIRML.g:1845:1: ( ( rule__Collection__ItemListAssignment_2 )? )
            // InternalIRML.g:1846:2: ( rule__Collection__ItemListAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionAccess().getItemListAssignment_2()); 
            }
            // InternalIRML.g:1847:2: ( rule__Collection__ItemListAssignment_2 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_STRING && LA16_0<=RULE_DECIMAL)||(LA16_0>=15 && LA16_0<=16)||LA16_0==24||LA16_0==26||(LA16_0>=28 && LA16_0<=29)||LA16_0==31) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalIRML.g:1847:3: rule__Collection__ItemListAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Collection__ItemListAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionAccess().getItemListAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 129, rule__Collection__Group__2__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collection__Group__2__Impl"


    // $ANTLR start "rule__Collection__Group__3"
    // InternalIRML.g:1855:1: rule__Collection__Group__3 : rule__Collection__Group__3__Impl ;
    public final void rule__Collection__Group__3() throws RecognitionException {
        int rule__Collection__Group__3_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 130) ) { return ; }
            // InternalIRML.g:1859:1: ( rule__Collection__Group__3__Impl )
            // InternalIRML.g:1860:2: rule__Collection__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Collection__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 130, rule__Collection__Group__3_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collection__Group__3"


    // $ANTLR start "rule__Collection__Group__3__Impl"
    // InternalIRML.g:1866:1: rule__Collection__Group__3__Impl : ( ')' ) ;
    public final void rule__Collection__Group__3__Impl() throws RecognitionException {
        int rule__Collection__Group__3__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 131) ) { return ; }
            // InternalIRML.g:1870:1: ( ( ')' ) )
            // InternalIRML.g:1871:1: ( ')' )
            {
            // InternalIRML.g:1871:1: ( ')' )
            // InternalIRML.g:1872:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionAccess().getRightParenthesisKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 131, rule__Collection__Group__3__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collection__Group__3__Impl"


    // $ANTLR start "rule__NodeID__Group__0"
    // InternalIRML.g:1882:1: rule__NodeID__Group__0 : rule__NodeID__Group__0__Impl rule__NodeID__Group__1 ;
    public final void rule__NodeID__Group__0() throws RecognitionException {
        int rule__NodeID__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 132) ) { return ; }
            // InternalIRML.g:1886:1: ( rule__NodeID__Group__0__Impl rule__NodeID__Group__1 )
            // InternalIRML.g:1887:2: rule__NodeID__Group__0__Impl rule__NodeID__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__NodeID__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NodeID__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 132, rule__NodeID__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeID__Group__0"


    // $ANTLR start "rule__NodeID__Group__0__Impl"
    // InternalIRML.g:1894:1: rule__NodeID__Group__0__Impl : ( '_:' ) ;
    public final void rule__NodeID__Group__0__Impl() throws RecognitionException {
        int rule__NodeID__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 133) ) { return ; }
            // InternalIRML.g:1898:1: ( ( '_:' ) )
            // InternalIRML.g:1899:1: ( '_:' )
            {
            // InternalIRML.g:1899:1: ( '_:' )
            // InternalIRML.g:1900:2: '_:'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNodeIDAccess().get_Keyword_0()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNodeIDAccess().get_Keyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 133, rule__NodeID__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeID__Group__0__Impl"


    // $ANTLR start "rule__NodeID__Group__1"
    // InternalIRML.g:1909:1: rule__NodeID__Group__1 : rule__NodeID__Group__1__Impl ;
    public final void rule__NodeID__Group__1() throws RecognitionException {
        int rule__NodeID__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 134) ) { return ; }
            // InternalIRML.g:1913:1: ( rule__NodeID__Group__1__Impl )
            // InternalIRML.g:1914:2: rule__NodeID__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NodeID__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 134, rule__NodeID__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeID__Group__1"


    // $ANTLR start "rule__NodeID__Group__1__Impl"
    // InternalIRML.g:1920:1: rule__NodeID__Group__1__Impl : ( ( rule__NodeID__NameAssignment_1 ) ) ;
    public final void rule__NodeID__Group__1__Impl() throws RecognitionException {
        int rule__NodeID__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 135) ) { return ; }
            // InternalIRML.g:1924:1: ( ( ( rule__NodeID__NameAssignment_1 ) ) )
            // InternalIRML.g:1925:1: ( ( rule__NodeID__NameAssignment_1 ) )
            {
            // InternalIRML.g:1925:1: ( ( rule__NodeID__NameAssignment_1 ) )
            // InternalIRML.g:1926:2: ( rule__NodeID__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNodeIDAccess().getNameAssignment_1()); 
            }
            // InternalIRML.g:1927:2: ( rule__NodeID__NameAssignment_1 )
            // InternalIRML.g:1927:3: rule__NodeID__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__NodeID__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNodeIDAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 135, rule__NodeID__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeID__Group__1__Impl"


    // $ANTLR start "rule__Qname__Group__0"
    // InternalIRML.g:1936:1: rule__Qname__Group__0 : rule__Qname__Group__0__Impl rule__Qname__Group__1 ;
    public final void rule__Qname__Group__0() throws RecognitionException {
        int rule__Qname__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 136) ) { return ; }
            // InternalIRML.g:1940:1: ( rule__Qname__Group__0__Impl rule__Qname__Group__1 )
            // InternalIRML.g:1941:2: rule__Qname__Group__0__Impl rule__Qname__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Qname__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Qname__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 136, rule__Qname__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qname__Group__0"


    // $ANTLR start "rule__Qname__Group__0__Impl"
    // InternalIRML.g:1948:1: rule__Qname__Group__0__Impl : ( () ) ;
    public final void rule__Qname__Group__0__Impl() throws RecognitionException {
        int rule__Qname__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 137) ) { return ; }
            // InternalIRML.g:1952:1: ( ( () ) )
            // InternalIRML.g:1953:1: ( () )
            {
            // InternalIRML.g:1953:1: ( () )
            // InternalIRML.g:1954:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQnameAccess().getQnameAction_0()); 
            }
            // InternalIRML.g:1955:2: ()
            // InternalIRML.g:1955:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQnameAccess().getQnameAction_0()); 
            }

            }


            }

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 137, rule__Qname__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qname__Group__0__Impl"


    // $ANTLR start "rule__Qname__Group__1"
    // InternalIRML.g:1963:1: rule__Qname__Group__1 : rule__Qname__Group__1__Impl rule__Qname__Group__2 ;
    public final void rule__Qname__Group__1() throws RecognitionException {
        int rule__Qname__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 138) ) { return ; }
            // InternalIRML.g:1967:1: ( rule__Qname__Group__1__Impl rule__Qname__Group__2 )
            // InternalIRML.g:1968:2: rule__Qname__Group__1__Impl rule__Qname__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__Qname__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__Qname__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 138, rule__Qname__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qname__Group__1"


    // $ANTLR start "rule__Qname__Group__1__Impl"
    // InternalIRML.g:1975:1: rule__Qname__Group__1__Impl : ( ( rule__Qname__PrefixNameAssignment_1 ) ) ;
    public final void rule__Qname__Group__1__Impl() throws RecognitionException {
        int rule__Qname__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 139) ) { return ; }
            // InternalIRML.g:1979:1: ( ( ( rule__Qname__PrefixNameAssignment_1 ) ) )
            // InternalIRML.g:1980:1: ( ( rule__Qname__PrefixNameAssignment_1 ) )
            {
            // InternalIRML.g:1980:1: ( ( rule__Qname__PrefixNameAssignment_1 ) )
            // InternalIRML.g:1981:2: ( rule__Qname__PrefixNameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQnameAccess().getPrefixNameAssignment_1()); 
            }
            // InternalIRML.g:1982:2: ( rule__Qname__PrefixNameAssignment_1 )
            // InternalIRML.g:1982:3: rule__Qname__PrefixNameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Qname__PrefixNameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQnameAccess().getPrefixNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 139, rule__Qname__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qname__Group__1__Impl"


    // $ANTLR start "rule__Qname__Group__2"
    // InternalIRML.g:1990:1: rule__Qname__Group__2 : rule__Qname__Group__2__Impl ;
    public final void rule__Qname__Group__2() throws RecognitionException {
        int rule__Qname__Group__2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 140) ) { return ; }
            // InternalIRML.g:1994:1: ( rule__Qname__Group__2__Impl )
            // InternalIRML.g:1995:2: rule__Qname__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Qname__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 140, rule__Qname__Group__2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qname__Group__2"


    // $ANTLR start "rule__Qname__Group__2__Impl"
    // InternalIRML.g:2001:1: rule__Qname__Group__2__Impl : ( ( rule__Qname__NameAssignment_2 )? ) ;
    public final void rule__Qname__Group__2__Impl() throws RecognitionException {
        int rule__Qname__Group__2__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 141) ) { return ; }
            // InternalIRML.g:2005:1: ( ( ( rule__Qname__NameAssignment_2 )? ) )
            // InternalIRML.g:2006:1: ( ( rule__Qname__NameAssignment_2 )? )
            {
            // InternalIRML.g:2006:1: ( ( rule__Qname__NameAssignment_2 )? )
            // InternalIRML.g:2007:2: ( rule__Qname__NameAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQnameAccess().getNameAssignment_2()); 
            }
            // InternalIRML.g:2008:2: ( rule__Qname__NameAssignment_2 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (synpred24_InternalIRML()) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // InternalIRML.g:2008:3: rule__Qname__NameAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Qname__NameAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQnameAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 141, rule__Qname__Group__2__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qname__Group__2__Impl"


    // $ANTLR start "rule__PrefixName__Group__0"
    // InternalIRML.g:2017:1: rule__PrefixName__Group__0 : rule__PrefixName__Group__0__Impl rule__PrefixName__Group__1 ;
    public final void rule__PrefixName__Group__0() throws RecognitionException {
        int rule__PrefixName__Group__0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 142) ) { return ; }
            // InternalIRML.g:2021:1: ( rule__PrefixName__Group__0__Impl rule__PrefixName__Group__1 )
            // InternalIRML.g:2022:2: rule__PrefixName__Group__0__Impl rule__PrefixName__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__PrefixName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PrefixName__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 142, rule__PrefixName__Group__0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixName__Group__0"


    // $ANTLR start "rule__PrefixName__Group__0__Impl"
    // InternalIRML.g:2029:1: rule__PrefixName__Group__0__Impl : ( ( RULE_ID )? ) ;
    public final void rule__PrefixName__Group__0__Impl() throws RecognitionException {
        int rule__PrefixName__Group__0__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 143) ) { return ; }
            // InternalIRML.g:2033:1: ( ( ( RULE_ID )? ) )
            // InternalIRML.g:2034:1: ( ( RULE_ID )? )
            {
            // InternalIRML.g:2034:1: ( ( RULE_ID )? )
            // InternalIRML.g:2035:2: ( RULE_ID )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixNameAccess().getIDTerminalRuleCall_0()); 
            }
            // InternalIRML.g:2036:2: ( RULE_ID )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalIRML.g:2036:3: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixNameAccess().getIDTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 143, rule__PrefixName__Group__0__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixName__Group__0__Impl"


    // $ANTLR start "rule__PrefixName__Group__1"
    // InternalIRML.g:2044:1: rule__PrefixName__Group__1 : rule__PrefixName__Group__1__Impl ;
    public final void rule__PrefixName__Group__1() throws RecognitionException {
        int rule__PrefixName__Group__1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 144) ) { return ; }
            // InternalIRML.g:2048:1: ( rule__PrefixName__Group__1__Impl )
            // InternalIRML.g:2049:2: rule__PrefixName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrefixName__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 144, rule__PrefixName__Group__1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixName__Group__1"


    // $ANTLR start "rule__PrefixName__Group__1__Impl"
    // InternalIRML.g:2055:1: rule__PrefixName__Group__1__Impl : ( ':' ) ;
    public final void rule__PrefixName__Group__1__Impl() throws RecognitionException {
        int rule__PrefixName__Group__1__Impl_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 145) ) { return ; }
            // InternalIRML.g:2059:1: ( ( ':' ) )
            // InternalIRML.g:2060:1: ( ':' )
            {
            // InternalIRML.g:2060:1: ( ':' )
            // InternalIRML.g:2061:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixNameAccess().getColonKeyword_1()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixNameAccess().getColonKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 145, rule__PrefixName__Group__1__Impl_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixName__Group__1__Impl"


    // $ANTLR start "rule__Mapping__StatementsAssignment"
    // InternalIRML.g:2071:1: rule__Mapping__StatementsAssignment : ( ruleStatement ) ;
    public final void rule__Mapping__StatementsAssignment() throws RecognitionException {
        int rule__Mapping__StatementsAssignment_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 146) ) { return ; }
            // InternalIRML.g:2075:1: ( ( ruleStatement ) )
            // InternalIRML.g:2076:2: ( ruleStatement )
            {
            // InternalIRML.g:2076:2: ( ruleStatement )
            // InternalIRML.g:2077:3: ruleStatement
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMappingAccess().getStatementsStatementParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleStatement();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMappingAccess().getStatementsStatementParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 146, rule__Mapping__StatementsAssignment_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mapping__StatementsAssignment"


    // $ANTLR start "rule__Statement__DirectiveAssignment_0_0"
    // InternalIRML.g:2086:1: rule__Statement__DirectiveAssignment_0_0 : ( ruleDirective ) ;
    public final void rule__Statement__DirectiveAssignment_0_0() throws RecognitionException {
        int rule__Statement__DirectiveAssignment_0_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 147) ) { return ; }
            // InternalIRML.g:2090:1: ( ( ruleDirective ) )
            // InternalIRML.g:2091:2: ( ruleDirective )
            {
            // InternalIRML.g:2091:2: ( ruleDirective )
            // InternalIRML.g:2092:3: ruleDirective
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getDirectiveDirectiveParserRuleCall_0_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDirective();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getDirectiveDirectiveParserRuleCall_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 147, rule__Statement__DirectiveAssignment_0_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__DirectiveAssignment_0_0"


    // $ANTLR start "rule__Statement__TripleAssignment_0_1"
    // InternalIRML.g:2101:1: rule__Statement__TripleAssignment_0_1 : ( ruleTriples ) ;
    public final void rule__Statement__TripleAssignment_0_1() throws RecognitionException {
        int rule__Statement__TripleAssignment_0_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 148) ) { return ; }
            // InternalIRML.g:2105:1: ( ( ruleTriples ) )
            // InternalIRML.g:2106:2: ( ruleTriples )
            {
            // InternalIRML.g:2106:2: ( ruleTriples )
            // InternalIRML.g:2107:3: ruleTriples
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStatementAccess().getTripleTriplesParserRuleCall_0_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleTriples();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStatementAccess().getTripleTriplesParserRuleCall_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 148, rule__Statement__TripleAssignment_0_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__TripleAssignment_0_1"


    // $ANTLR start "rule__Directive__PrefixAssignment_0"
    // InternalIRML.g:2116:1: rule__Directive__PrefixAssignment_0 : ( rulePrefixID ) ;
    public final void rule__Directive__PrefixAssignment_0() throws RecognitionException {
        int rule__Directive__PrefixAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 149) ) { return ; }
            // InternalIRML.g:2120:1: ( ( rulePrefixID ) )
            // InternalIRML.g:2121:2: ( rulePrefixID )
            {
            // InternalIRML.g:2121:2: ( rulePrefixID )
            // InternalIRML.g:2122:3: rulePrefixID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDirectiveAccess().getPrefixPrefixIDParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrefixID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDirectiveAccess().getPrefixPrefixIDParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 149, rule__Directive__PrefixAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Directive__PrefixAssignment_0"


    // $ANTLR start "rule__Directive__BaseAssignment_1"
    // InternalIRML.g:2131:1: rule__Directive__BaseAssignment_1 : ( ruleBase ) ;
    public final void rule__Directive__BaseAssignment_1() throws RecognitionException {
        int rule__Directive__BaseAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 150) ) { return ; }
            // InternalIRML.g:2135:1: ( ( ruleBase ) )
            // InternalIRML.g:2136:2: ( ruleBase )
            {
            // InternalIRML.g:2136:2: ( ruleBase )
            // InternalIRML.g:2137:3: ruleBase
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDirectiveAccess().getBaseBaseParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleBase();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDirectiveAccess().getBaseBaseParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 150, rule__Directive__BaseAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Directive__BaseAssignment_1"


    // $ANTLR start "rule__PrefixID__PrefixNameAssignment_1"
    // InternalIRML.g:2146:1: rule__PrefixID__PrefixNameAssignment_1 : ( rulePrefixName ) ;
    public final void rule__PrefixID__PrefixNameAssignment_1() throws RecognitionException {
        int rule__PrefixID__PrefixNameAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 151) ) { return ; }
            // InternalIRML.g:2150:1: ( ( rulePrefixName ) )
            // InternalIRML.g:2151:2: ( rulePrefixName )
            {
            // InternalIRML.g:2151:2: ( rulePrefixName )
            // InternalIRML.g:2152:3: rulePrefixName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixIDAccess().getPrefixNamePrefixNameParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrefixName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixIDAccess().getPrefixNamePrefixNameParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 151, rule__PrefixID__PrefixNameAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixID__PrefixNameAssignment_1"


    // $ANTLR start "rule__PrefixID__UriRefAssignment_2"
    // InternalIRML.g:2161:1: rule__PrefixID__UriRefAssignment_2 : ( RULE_URIREF ) ;
    public final void rule__PrefixID__UriRefAssignment_2() throws RecognitionException {
        int rule__PrefixID__UriRefAssignment_2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 152) ) { return ; }
            // InternalIRML.g:2165:1: ( ( RULE_URIREF ) )
            // InternalIRML.g:2166:2: ( RULE_URIREF )
            {
            // InternalIRML.g:2166:2: ( RULE_URIREF )
            // InternalIRML.g:2167:3: RULE_URIREF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrefixIDAccess().getUriRefURIREFTerminalRuleCall_2_0()); 
            }
            match(input,RULE_URIREF,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrefixIDAccess().getUriRefURIREFTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 152, rule__PrefixID__UriRefAssignment_2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixID__UriRefAssignment_2"


    // $ANTLR start "rule__Base__UriRefAssignment_1"
    // InternalIRML.g:2176:1: rule__Base__UriRefAssignment_1 : ( RULE_URIREF ) ;
    public final void rule__Base__UriRefAssignment_1() throws RecognitionException {
        int rule__Base__UriRefAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 153) ) { return ; }
            // InternalIRML.g:2180:1: ( ( RULE_URIREF ) )
            // InternalIRML.g:2181:2: ( RULE_URIREF )
            {
            // InternalIRML.g:2181:2: ( RULE_URIREF )
            // InternalIRML.g:2182:3: RULE_URIREF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBaseAccess().getUriRefURIREFTerminalRuleCall_1_0()); 
            }
            match(input,RULE_URIREF,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBaseAccess().getUriRefURIREFTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 153, rule__Base__UriRefAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Base__UriRefAssignment_1"


    // $ANTLR start "rule__Triples__SubjectAssignment_0"
    // InternalIRML.g:2191:1: rule__Triples__SubjectAssignment_0 : ( ruleSubject ) ;
    public final void rule__Triples__SubjectAssignment_0() throws RecognitionException {
        int rule__Triples__SubjectAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 154) ) { return ; }
            // InternalIRML.g:2195:1: ( ( ruleSubject ) )
            // InternalIRML.g:2196:2: ( ruleSubject )
            {
            // InternalIRML.g:2196:2: ( ruleSubject )
            // InternalIRML.g:2197:3: ruleSubject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTriplesAccess().getSubjectSubjectParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleSubject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTriplesAccess().getSubjectSubjectParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 154, rule__Triples__SubjectAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triples__SubjectAssignment_0"


    // $ANTLR start "rule__Triples__PredicateObjectListAssignment_1"
    // InternalIRML.g:2206:1: rule__Triples__PredicateObjectListAssignment_1 : ( rulePredicateObjectList ) ;
    public final void rule__Triples__PredicateObjectListAssignment_1() throws RecognitionException {
        int rule__Triples__PredicateObjectListAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 155) ) { return ; }
            // InternalIRML.g:2210:1: ( ( rulePredicateObjectList ) )
            // InternalIRML.g:2211:2: ( rulePredicateObjectList )
            {
            // InternalIRML.g:2211:2: ( rulePredicateObjectList )
            // InternalIRML.g:2212:3: rulePredicateObjectList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTriplesAccess().getPredicateObjectListPredicateObjectListParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePredicateObjectList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTriplesAccess().getPredicateObjectListPredicateObjectListParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 155, rule__Triples__PredicateObjectListAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Triples__PredicateObjectListAssignment_1"


    // $ANTLR start "rule__PredicateObject__VerbAssignment_0"
    // InternalIRML.g:2221:1: rule__PredicateObject__VerbAssignment_0 : ( ruleVerb ) ;
    public final void rule__PredicateObject__VerbAssignment_0() throws RecognitionException {
        int rule__PredicateObject__VerbAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 156) ) { return ; }
            // InternalIRML.g:2225:1: ( ( ruleVerb ) )
            // InternalIRML.g:2226:2: ( ruleVerb )
            {
            // InternalIRML.g:2226:2: ( ruleVerb )
            // InternalIRML.g:2227:3: ruleVerb
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectAccess().getVerbVerbParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleVerb();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectAccess().getVerbVerbParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 156, rule__PredicateObject__VerbAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObject__VerbAssignment_0"


    // $ANTLR start "rule__PredicateObject__ObjectListAssignment_1"
    // InternalIRML.g:2236:1: rule__PredicateObject__ObjectListAssignment_1 : ( ruleObjectList ) ;
    public final void rule__PredicateObject__ObjectListAssignment_1() throws RecognitionException {
        int rule__PredicateObject__ObjectListAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 157) ) { return ; }
            // InternalIRML.g:2240:1: ( ( ruleObjectList ) )
            // InternalIRML.g:2241:2: ( ruleObjectList )
            {
            // InternalIRML.g:2241:2: ( ruleObjectList )
            // InternalIRML.g:2242:3: ruleObjectList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectAccess().getObjectListObjectListParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleObjectList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectAccess().getObjectListObjectListParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 157, rule__PredicateObject__ObjectListAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObject__ObjectListAssignment_1"


    // $ANTLR start "rule__PredicateObjectList__PredicateObjectsAssignment_0"
    // InternalIRML.g:2251:1: rule__PredicateObjectList__PredicateObjectsAssignment_0 : ( rulePredicateObject ) ;
    public final void rule__PredicateObjectList__PredicateObjectsAssignment_0() throws RecognitionException {
        int rule__PredicateObjectList__PredicateObjectsAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 158) ) { return ; }
            // InternalIRML.g:2255:1: ( ( rulePredicateObject ) )
            // InternalIRML.g:2256:2: ( rulePredicateObject )
            {
            // InternalIRML.g:2256:2: ( rulePredicateObject )
            // InternalIRML.g:2257:3: rulePredicateObject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectListAccess().getPredicateObjectsPredicateObjectParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePredicateObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectListAccess().getPredicateObjectsPredicateObjectParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 158, rule__PredicateObjectList__PredicateObjectsAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObjectList__PredicateObjectsAssignment_0"


    // $ANTLR start "rule__PredicateObjectList__PredicateObjectsAssignment_1_1"
    // InternalIRML.g:2266:1: rule__PredicateObjectList__PredicateObjectsAssignment_1_1 : ( rulePredicateObject ) ;
    public final void rule__PredicateObjectList__PredicateObjectsAssignment_1_1() throws RecognitionException {
        int rule__PredicateObjectList__PredicateObjectsAssignment_1_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 159) ) { return ; }
            // InternalIRML.g:2270:1: ( ( rulePredicateObject ) )
            // InternalIRML.g:2271:2: ( rulePredicateObject )
            {
            // InternalIRML.g:2271:2: ( rulePredicateObject )
            // InternalIRML.g:2272:3: rulePredicateObject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPredicateObjectListAccess().getPredicateObjectsPredicateObjectParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePredicateObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPredicateObjectListAccess().getPredicateObjectsPredicateObjectParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 159, rule__PredicateObjectList__PredicateObjectsAssignment_1_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicateObjectList__PredicateObjectsAssignment_1_1"


    // $ANTLR start "rule__ObjectList__ObjectsAssignment_0"
    // InternalIRML.g:2281:1: rule__ObjectList__ObjectsAssignment_0 : ( ruleObject ) ;
    public final void rule__ObjectList__ObjectsAssignment_0() throws RecognitionException {
        int rule__ObjectList__ObjectsAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 160) ) { return ; }
            // InternalIRML.g:2285:1: ( ( ruleObject ) )
            // InternalIRML.g:2286:2: ( ruleObject )
            {
            // InternalIRML.g:2286:2: ( ruleObject )
            // InternalIRML.g:2287:3: ruleObject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectListAccess().getObjectsObjectParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectListAccess().getObjectsObjectParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 160, rule__ObjectList__ObjectsAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectList__ObjectsAssignment_0"


    // $ANTLR start "rule__ObjectList__ObjectsAssignment_1_1"
    // InternalIRML.g:2296:1: rule__ObjectList__ObjectsAssignment_1_1 : ( ruleObject ) ;
    public final void rule__ObjectList__ObjectsAssignment_1_1() throws RecognitionException {
        int rule__ObjectList__ObjectsAssignment_1_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 161) ) { return ; }
            // InternalIRML.g:2300:1: ( ( ruleObject ) )
            // InternalIRML.g:2301:2: ( ruleObject )
            {
            // InternalIRML.g:2301:2: ( ruleObject )
            // InternalIRML.g:2302:3: ruleObject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectListAccess().getObjectsObjectParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectListAccess().getObjectsObjectParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 161, rule__ObjectList__ObjectsAssignment_1_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectList__ObjectsAssignment_1_1"


    // $ANTLR start "rule__Verb__PredicateAssignment_0"
    // InternalIRML.g:2311:1: rule__Verb__PredicateAssignment_0 : ( rulePredicate ) ;
    public final void rule__Verb__PredicateAssignment_0() throws RecognitionException {
        int rule__Verb__PredicateAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 162) ) { return ; }
            // InternalIRML.g:2315:1: ( ( rulePredicate ) )
            // InternalIRML.g:2316:2: ( rulePredicate )
            {
            // InternalIRML.g:2316:2: ( rulePredicate )
            // InternalIRML.g:2317:3: rulePredicate
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVerbAccess().getPredicatePredicateParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePredicate();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVerbAccess().getPredicatePredicateParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 162, rule__Verb__PredicateAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Verb__PredicateAssignment_0"


    // $ANTLR start "rule__Verb__IsAAssignment_1"
    // InternalIRML.g:2326:1: rule__Verb__IsAAssignment_1 : ( ( 'a' ) ) ;
    public final void rule__Verb__IsAAssignment_1() throws RecognitionException {
        int rule__Verb__IsAAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 163) ) { return ; }
            // InternalIRML.g:2330:1: ( ( ( 'a' ) ) )
            // InternalIRML.g:2331:2: ( ( 'a' ) )
            {
            // InternalIRML.g:2331:2: ( ( 'a' ) )
            // InternalIRML.g:2332:3: ( 'a' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVerbAccess().getIsAAKeyword_1_0()); 
            }
            // InternalIRML.g:2333:3: ( 'a' )
            // InternalIRML.g:2334:4: 'a'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVerbAccess().getIsAAKeyword_1_0()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getVerbAccess().getIsAAKeyword_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVerbAccess().getIsAAKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 163, rule__Verb__IsAAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Verb__IsAAssignment_1"


    // $ANTLR start "rule__Subject__ResourceAssignment_0"
    // InternalIRML.g:2345:1: rule__Subject__ResourceAssignment_0 : ( ruleiResource ) ;
    public final void rule__Subject__ResourceAssignment_0() throws RecognitionException {
        int rule__Subject__ResourceAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 164) ) { return ; }
            // InternalIRML.g:2349:1: ( ( ruleiResource ) )
            // InternalIRML.g:2350:2: ( ruleiResource )
            {
            // InternalIRML.g:2350:2: ( ruleiResource )
            // InternalIRML.g:2351:3: ruleiResource
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubjectAccess().getResourceIResourceParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleiResource();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubjectAccess().getResourceIResourceParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 164, rule__Subject__ResourceAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Subject__ResourceAssignment_0"


    // $ANTLR start "rule__Subject__BlankAssignment_1"
    // InternalIRML.g:2360:1: rule__Subject__BlankAssignment_1 : ( ruleBlank ) ;
    public final void rule__Subject__BlankAssignment_1() throws RecognitionException {
        int rule__Subject__BlankAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 165) ) { return ; }
            // InternalIRML.g:2364:1: ( ( ruleBlank ) )
            // InternalIRML.g:2365:2: ( ruleBlank )
            {
            // InternalIRML.g:2365:2: ( ruleBlank )
            // InternalIRML.g:2366:3: ruleBlank
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSubjectAccess().getBlankBlankParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleBlank();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSubjectAccess().getBlankBlankParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 165, rule__Subject__BlankAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Subject__BlankAssignment_1"


    // $ANTLR start "rule__Object__ResourceAssignment_0"
    // InternalIRML.g:2375:1: rule__Object__ResourceAssignment_0 : ( ruleiResource ) ;
    public final void rule__Object__ResourceAssignment_0() throws RecognitionException {
        int rule__Object__ResourceAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 166) ) { return ; }
            // InternalIRML.g:2379:1: ( ( ruleiResource ) )
            // InternalIRML.g:2380:2: ( ruleiResource )
            {
            // InternalIRML.g:2380:2: ( ruleiResource )
            // InternalIRML.g:2381:3: ruleiResource
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getResourceIResourceParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleiResource();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getResourceIResourceParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 166, rule__Object__ResourceAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__ResourceAssignment_0"


    // $ANTLR start "rule__Object__BlankAssignment_1"
    // InternalIRML.g:2390:1: rule__Object__BlankAssignment_1 : ( ruleBlank ) ;
    public final void rule__Object__BlankAssignment_1() throws RecognitionException {
        int rule__Object__BlankAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 167) ) { return ; }
            // InternalIRML.g:2394:1: ( ( ruleBlank ) )
            // InternalIRML.g:2395:2: ( ruleBlank )
            {
            // InternalIRML.g:2395:2: ( ruleBlank )
            // InternalIRML.g:2396:3: ruleBlank
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getBlankBlankParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleBlank();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getBlankBlankParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 167, rule__Object__BlankAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__BlankAssignment_1"


    // $ANTLR start "rule__Object__LiteralAssignment_2"
    // InternalIRML.g:2405:1: rule__Object__LiteralAssignment_2 : ( ruleLiteral ) ;
    public final void rule__Object__LiteralAssignment_2() throws RecognitionException {
        int rule__Object__LiteralAssignment_2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 168) ) { return ; }
            // InternalIRML.g:2409:1: ( ( ruleLiteral ) )
            // InternalIRML.g:2410:2: ( ruleLiteral )
            {
            // InternalIRML.g:2410:2: ( ruleLiteral )
            // InternalIRML.g:2411:3: ruleLiteral
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getLiteralLiteralParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleLiteral();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getLiteralLiteralParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 168, rule__Object__LiteralAssignment_2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__LiteralAssignment_2"


    // $ANTLR start "rule__LanguageString__QutoedStringAssignment_0"
    // InternalIRML.g:2420:1: rule__LanguageString__QutoedStringAssignment_0 : ( ruleQuotedString ) ;
    public final void rule__LanguageString__QutoedStringAssignment_0() throws RecognitionException {
        int rule__LanguageString__QutoedStringAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 169) ) { return ; }
            // InternalIRML.g:2424:1: ( ( ruleQuotedString ) )
            // InternalIRML.g:2425:2: ( ruleQuotedString )
            {
            // InternalIRML.g:2425:2: ( ruleQuotedString )
            // InternalIRML.g:2426:3: ruleQuotedString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageStringAccess().getQutoedStringQuotedStringParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQuotedString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageStringAccess().getQutoedStringQuotedStringParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 169, rule__LanguageString__QutoedStringAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageString__QutoedStringAssignment_0"


    // $ANTLR start "rule__LanguageString__LangAssignment_1_1"
    // InternalIRML.g:2435:1: rule__LanguageString__LangAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__LanguageString__LangAssignment_1_1() throws RecognitionException {
        int rule__LanguageString__LangAssignment_1_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 170) ) { return ; }
            // InternalIRML.g:2439:1: ( ( RULE_ID ) )
            // InternalIRML.g:2440:2: ( RULE_ID )
            {
            // InternalIRML.g:2440:2: ( RULE_ID )
            // InternalIRML.g:2441:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLanguageStringAccess().getLangIDTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLanguageStringAccess().getLangIDTerminalRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 170, rule__LanguageString__LangAssignment_1_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageString__LangAssignment_1_1"


    // $ANTLR start "rule__Literal__LanguageStringAssignment_0"
    // InternalIRML.g:2450:1: rule__Literal__LanguageStringAssignment_0 : ( ruleLanguageString ) ;
    public final void rule__Literal__LanguageStringAssignment_0() throws RecognitionException {
        int rule__Literal__LanguageStringAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 171) ) { return ; }
            // InternalIRML.g:2454:1: ( ( ruleLanguageString ) )
            // InternalIRML.g:2455:2: ( ruleLanguageString )
            {
            // InternalIRML.g:2455:2: ( ruleLanguageString )
            // InternalIRML.g:2456:3: ruleLanguageString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getLanguageStringLanguageStringParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleLanguageString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getLanguageStringLanguageStringParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 171, rule__Literal__LanguageStringAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__LanguageStringAssignment_0"


    // $ANTLR start "rule__Literal__DatatypeStringAssignment_1"
    // InternalIRML.g:2465:1: rule__Literal__DatatypeStringAssignment_1 : ( ruleDatatypeString ) ;
    public final void rule__Literal__DatatypeStringAssignment_1() throws RecognitionException {
        int rule__Literal__DatatypeStringAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 172) ) { return ; }
            // InternalIRML.g:2469:1: ( ( ruleDatatypeString ) )
            // InternalIRML.g:2470:2: ( ruleDatatypeString )
            {
            // InternalIRML.g:2470:2: ( ruleDatatypeString )
            // InternalIRML.g:2471:3: ruleDatatypeString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getDatatypeStringDatatypeStringParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleDatatypeString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getDatatypeStringDatatypeStringParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 172, rule__Literal__DatatypeStringAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__DatatypeStringAssignment_1"


    // $ANTLR start "rule__Literal__DwordAssignment_2"
    // InternalIRML.g:2480:1: rule__Literal__DwordAssignment_2 : ( RULE_INT ) ;
    public final void rule__Literal__DwordAssignment_2() throws RecognitionException {
        int rule__Literal__DwordAssignment_2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 173) ) { return ; }
            // InternalIRML.g:2484:1: ( ( RULE_INT ) )
            // InternalIRML.g:2485:2: ( RULE_INT )
            {
            // InternalIRML.g:2485:2: ( RULE_INT )
            // InternalIRML.g:2486:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getDwordINTTerminalRuleCall_2_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getDwordINTTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 173, rule__Literal__DwordAssignment_2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__DwordAssignment_2"


    // $ANTLR start "rule__Literal__RealAssignment_3"
    // InternalIRML.g:2495:1: rule__Literal__RealAssignment_3 : ( RULE_DOUBLE ) ;
    public final void rule__Literal__RealAssignment_3() throws RecognitionException {
        int rule__Literal__RealAssignment_3_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 174) ) { return ; }
            // InternalIRML.g:2499:1: ( ( RULE_DOUBLE ) )
            // InternalIRML.g:2500:2: ( RULE_DOUBLE )
            {
            // InternalIRML.g:2500:2: ( RULE_DOUBLE )
            // InternalIRML.g:2501:3: RULE_DOUBLE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getRealDOUBLETerminalRuleCall_3_0()); 
            }
            match(input,RULE_DOUBLE,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getRealDOUBLETerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 174, rule__Literal__RealAssignment_3_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__RealAssignment_3"


    // $ANTLR start "rule__Literal__DecimalAssignment_4"
    // InternalIRML.g:2510:1: rule__Literal__DecimalAssignment_4 : ( RULE_DECIMAL ) ;
    public final void rule__Literal__DecimalAssignment_4() throws RecognitionException {
        int rule__Literal__DecimalAssignment_4_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 175) ) { return ; }
            // InternalIRML.g:2514:1: ( ( RULE_DECIMAL ) )
            // InternalIRML.g:2515:2: ( RULE_DECIMAL )
            {
            // InternalIRML.g:2515:2: ( RULE_DECIMAL )
            // InternalIRML.g:2516:3: RULE_DECIMAL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getDecimalDECIMALTerminalRuleCall_4_0()); 
            }
            match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getDecimalDECIMALTerminalRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 175, rule__Literal__DecimalAssignment_4_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__DecimalAssignment_4"


    // $ANTLR start "rule__Literal__BoolAssignment_5"
    // InternalIRML.g:2525:1: rule__Literal__BoolAssignment_5 : ( ruleBoolean ) ;
    public final void rule__Literal__BoolAssignment_5() throws RecognitionException {
        int rule__Literal__BoolAssignment_5_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 176) ) { return ; }
            // InternalIRML.g:2529:1: ( ( ruleBoolean ) )
            // InternalIRML.g:2530:2: ( ruleBoolean )
            {
            // InternalIRML.g:2530:2: ( ruleBoolean )
            // InternalIRML.g:2531:3: ruleBoolean
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralAccess().getBoolBooleanParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleBoolean();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralAccess().getBoolBooleanParserRuleCall_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 176, rule__Literal__BoolAssignment_5_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__BoolAssignment_5"


    // $ANTLR start "rule__DatatypeString__QutoedStringAssignment_0"
    // InternalIRML.g:2540:1: rule__DatatypeString__QutoedStringAssignment_0 : ( ruleQuotedString ) ;
    public final void rule__DatatypeString__QutoedStringAssignment_0() throws RecognitionException {
        int rule__DatatypeString__QutoedStringAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 177) ) { return ; }
            // InternalIRML.g:2544:1: ( ( ruleQuotedString ) )
            // InternalIRML.g:2545:2: ( ruleQuotedString )
            {
            // InternalIRML.g:2545:2: ( ruleQuotedString )
            // InternalIRML.g:2546:3: ruleQuotedString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeStringAccess().getQutoedStringQuotedStringParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQuotedString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeStringAccess().getQutoedStringQuotedStringParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 177, rule__DatatypeString__QutoedStringAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DatatypeString__QutoedStringAssignment_0"


    // $ANTLR start "rule__DatatypeString__ResourceAssignment_2"
    // InternalIRML.g:2555:1: rule__DatatypeString__ResourceAssignment_2 : ( ruleiResource ) ;
    public final void rule__DatatypeString__ResourceAssignment_2() throws RecognitionException {
        int rule__DatatypeString__ResourceAssignment_2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 178) ) { return ; }
            // InternalIRML.g:2559:1: ( ( ruleiResource ) )
            // InternalIRML.g:2560:2: ( ruleiResource )
            {
            // InternalIRML.g:2560:2: ( ruleiResource )
            // InternalIRML.g:2561:3: ruleiResource
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeStringAccess().getResourceIResourceParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleiResource();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeStringAccess().getResourceIResourceParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 178, rule__DatatypeString__ResourceAssignment_2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DatatypeString__ResourceAssignment_2"


    // $ANTLR start "rule__Blank__NodeIDAssignment_0"
    // InternalIRML.g:2570:1: rule__Blank__NodeIDAssignment_0 : ( ruleNodeID ) ;
    public final void rule__Blank__NodeIDAssignment_0() throws RecognitionException {
        int rule__Blank__NodeIDAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 179) ) { return ; }
            // InternalIRML.g:2574:1: ( ( ruleNodeID ) )
            // InternalIRML.g:2575:2: ( ruleNodeID )
            {
            // InternalIRML.g:2575:2: ( ruleNodeID )
            // InternalIRML.g:2576:3: ruleNodeID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankAccess().getNodeIDNodeIDParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleNodeID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankAccess().getNodeIDNodeIDParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 179, rule__Blank__NodeIDAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Blank__NodeIDAssignment_0"


    // $ANTLR start "rule__Blank__IsSquareAssignment_1"
    // InternalIRML.g:2585:1: rule__Blank__IsSquareAssignment_1 : ( ( '[]' ) ) ;
    public final void rule__Blank__IsSquareAssignment_1() throws RecognitionException {
        int rule__Blank__IsSquareAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 180) ) { return ; }
            // InternalIRML.g:2589:1: ( ( ( '[]' ) ) )
            // InternalIRML.g:2590:2: ( ( '[]' ) )
            {
            // InternalIRML.g:2590:2: ( ( '[]' ) )
            // InternalIRML.g:2591:3: ( '[]' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankAccess().getIsSquareLeftSquareBracketRightSquareBracketKeyword_1_0()); 
            }
            // InternalIRML.g:2592:3: ( '[]' )
            // InternalIRML.g:2593:4: '[]'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankAccess().getIsSquareLeftSquareBracketRightSquareBracketKeyword_1_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankAccess().getIsSquareLeftSquareBracketRightSquareBracketKeyword_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankAccess().getIsSquareLeftSquareBracketRightSquareBracketKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 180, rule__Blank__IsSquareAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Blank__IsSquareAssignment_1"


    // $ANTLR start "rule__Blank__PredicateObjectListAssignment_2_1"
    // InternalIRML.g:2604:1: rule__Blank__PredicateObjectListAssignment_2_1 : ( rulePredicateObjectList ) ;
    public final void rule__Blank__PredicateObjectListAssignment_2_1() throws RecognitionException {
        int rule__Blank__PredicateObjectListAssignment_2_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 181) ) { return ; }
            // InternalIRML.g:2608:1: ( ( rulePredicateObjectList ) )
            // InternalIRML.g:2609:2: ( rulePredicateObjectList )
            {
            // InternalIRML.g:2609:2: ( rulePredicateObjectList )
            // InternalIRML.g:2610:3: rulePredicateObjectList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankAccess().getPredicateObjectListPredicateObjectListParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePredicateObjectList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankAccess().getPredicateObjectListPredicateObjectListParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 181, rule__Blank__PredicateObjectListAssignment_2_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Blank__PredicateObjectListAssignment_2_1"


    // $ANTLR start "rule__Blank__CollectionAssignment_3"
    // InternalIRML.g:2619:1: rule__Blank__CollectionAssignment_3 : ( ruleCollection ) ;
    public final void rule__Blank__CollectionAssignment_3() throws RecognitionException {
        int rule__Blank__CollectionAssignment_3_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 182) ) { return ; }
            // InternalIRML.g:2623:1: ( ( ruleCollection ) )
            // InternalIRML.g:2624:2: ( ruleCollection )
            {
            // InternalIRML.g:2624:2: ( ruleCollection )
            // InternalIRML.g:2625:3: ruleCollection
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBlankAccess().getCollectionCollectionParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCollection();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBlankAccess().getCollectionCollectionParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 182, rule__Blank__CollectionAssignment_3_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Blank__CollectionAssignment_3"


    // $ANTLR start "rule__ItemList__ObjectsAssignment_0"
    // InternalIRML.g:2634:1: rule__ItemList__ObjectsAssignment_0 : ( ruleObject ) ;
    public final void rule__ItemList__ObjectsAssignment_0() throws RecognitionException {
        int rule__ItemList__ObjectsAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 183) ) { return ; }
            // InternalIRML.g:2638:1: ( ( ruleObject ) )
            // InternalIRML.g:2639:2: ( ruleObject )
            {
            // InternalIRML.g:2639:2: ( ruleObject )
            // InternalIRML.g:2640:3: ruleObject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getItemListAccess().getObjectsObjectParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getItemListAccess().getObjectsObjectParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 183, rule__ItemList__ObjectsAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemList__ObjectsAssignment_0"


    // $ANTLR start "rule__ItemList__ObjectsAssignment_1"
    // InternalIRML.g:2649:1: rule__ItemList__ObjectsAssignment_1 : ( ruleObject ) ;
    public final void rule__ItemList__ObjectsAssignment_1() throws RecognitionException {
        int rule__ItemList__ObjectsAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 184) ) { return ; }
            // InternalIRML.g:2653:1: ( ( ruleObject ) )
            // InternalIRML.g:2654:2: ( ruleObject )
            {
            // InternalIRML.g:2654:2: ( ruleObject )
            // InternalIRML.g:2655:3: ruleObject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getItemListAccess().getObjectsObjectParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getItemListAccess().getObjectsObjectParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 184, rule__ItemList__ObjectsAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ItemList__ObjectsAssignment_1"


    // $ANTLR start "rule__Collection__ItemListAssignment_2"
    // InternalIRML.g:2664:1: rule__Collection__ItemListAssignment_2 : ( ruleItemList ) ;
    public final void rule__Collection__ItemListAssignment_2() throws RecognitionException {
        int rule__Collection__ItemListAssignment_2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 185) ) { return ; }
            // InternalIRML.g:2668:1: ( ( ruleItemList ) )
            // InternalIRML.g:2669:2: ( ruleItemList )
            {
            // InternalIRML.g:2669:2: ( ruleItemList )
            // InternalIRML.g:2670:3: ruleItemList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionAccess().getItemListItemListParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleItemList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionAccess().getItemListItemListParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 185, rule__Collection__ItemListAssignment_2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Collection__ItemListAssignment_2"


    // $ANTLR start "rule__IResource__UriRefAssignment_0"
    // InternalIRML.g:2679:1: rule__IResource__UriRefAssignment_0 : ( RULE_URIREF ) ;
    public final void rule__IResource__UriRefAssignment_0() throws RecognitionException {
        int rule__IResource__UriRefAssignment_0_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 186) ) { return ; }
            // InternalIRML.g:2683:1: ( ( RULE_URIREF ) )
            // InternalIRML.g:2684:2: ( RULE_URIREF )
            {
            // InternalIRML.g:2684:2: ( RULE_URIREF )
            // InternalIRML.g:2685:3: RULE_URIREF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIResourceAccess().getUriRefURIREFTerminalRuleCall_0_0()); 
            }
            match(input,RULE_URIREF,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIResourceAccess().getUriRefURIREFTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 186, rule__IResource__UriRefAssignment_0_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IResource__UriRefAssignment_0"


    // $ANTLR start "rule__IResource__QnameAssignment_1"
    // InternalIRML.g:2694:1: rule__IResource__QnameAssignment_1 : ( ruleQname ) ;
    public final void rule__IResource__QnameAssignment_1() throws RecognitionException {
        int rule__IResource__QnameAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 187) ) { return ; }
            // InternalIRML.g:2698:1: ( ( ruleQname ) )
            // InternalIRML.g:2699:2: ( ruleQname )
            {
            // InternalIRML.g:2699:2: ( ruleQname )
            // InternalIRML.g:2700:3: ruleQname
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIResourceAccess().getQnameQnameParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleQname();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIResourceAccess().getQnameQnameParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 187, rule__IResource__QnameAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IResource__QnameAssignment_1"


    // $ANTLR start "rule__NodeID__NameAssignment_1"
    // InternalIRML.g:2709:1: rule__NodeID__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__NodeID__NameAssignment_1() throws RecognitionException {
        int rule__NodeID__NameAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 188) ) { return ; }
            // InternalIRML.g:2713:1: ( ( RULE_ID ) )
            // InternalIRML.g:2714:2: ( RULE_ID )
            {
            // InternalIRML.g:2714:2: ( RULE_ID )
            // InternalIRML.g:2715:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNodeIDAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNodeIDAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 188, rule__NodeID__NameAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeID__NameAssignment_1"


    // $ANTLR start "rule__Qname__PrefixNameAssignment_1"
    // InternalIRML.g:2724:1: rule__Qname__PrefixNameAssignment_1 : ( rulePrefixName ) ;
    public final void rule__Qname__PrefixNameAssignment_1() throws RecognitionException {
        int rule__Qname__PrefixNameAssignment_1_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 189) ) { return ; }
            // InternalIRML.g:2728:1: ( ( rulePrefixName ) )
            // InternalIRML.g:2729:2: ( rulePrefixName )
            {
            // InternalIRML.g:2729:2: ( rulePrefixName )
            // InternalIRML.g:2730:3: rulePrefixName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQnameAccess().getPrefixNamePrefixNameParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrefixName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQnameAccess().getPrefixNamePrefixNameParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 189, rule__Qname__PrefixNameAssignment_1_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qname__PrefixNameAssignment_1"


    // $ANTLR start "rule__Qname__NameAssignment_2"
    // InternalIRML.g:2739:1: rule__Qname__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Qname__NameAssignment_2() throws RecognitionException {
        int rule__Qname__NameAssignment_2_StartIndex = input.index();

        		int stackSize = keepStackSize();
        	
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 190) ) { return ; }
            // InternalIRML.g:2743:1: ( ( RULE_ID ) )
            // InternalIRML.g:2744:2: ( RULE_ID )
            {
            // InternalIRML.g:2744:2: ( RULE_ID )
            // InternalIRML.g:2745:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQnameAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQnameAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 190, rule__Qname__NameAssignment_2_StartIndex); }

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Qname__NameAssignment_2"

    // $ANTLR start synpred24_InternalIRML
    public final void synpred24_InternalIRML_fragment() throws RecognitionException {   
        // InternalIRML.g:2008:3: ( rule__Qname__NameAssignment_2 )
        // InternalIRML.g:2008:3: rule__Qname__NameAssignment_2
        {
        pushFollow(FOLLOW_2);
        rule__Qname__NameAssignment_2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_InternalIRML

    // Delegated rules

    public final boolean synpred24_InternalIRML() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalIRML_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000B50C0062L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000020000060L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000060000060L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000B50D83F0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000000B50D83F2L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000000B50C0060L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000BD0D83F0L});

}