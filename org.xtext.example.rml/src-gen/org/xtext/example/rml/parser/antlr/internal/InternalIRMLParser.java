package org.xtext.example.rml.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.rml.services.IRMLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalIRMLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_URIREF", "RULE_ID", "RULE_INT", "RULE_DOUBLE", "RULE_DECIMAL", "RULE_STRING", "RULE_EXPONENT", "RULE_SL_COMMENT", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'", "'@prefix'", "'@base'", "';'", "','", "'a'", "'@'", "'^^'", "'true'", "'false'", "'[]'", "'['", "']'", "'('", "')'", "'_:'", "':'"
    };
    public static final int RULE_STRING=9;
    public static final int RULE_URIREF=4;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_DOUBLE=7;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_ID=5;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int RULE_DECIMAL=8;
    public static final int RULE_EXPONENT=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
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
            this.state.ruleMemo = new HashMap[52+1];
             
             
        }
        

    public String[] getTokenNames() { return InternalIRMLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalIRML.g"; }



     	private IRMLGrammarAccess grammarAccess;

        public InternalIRMLParser(TokenStream input, IRMLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Mapping";
       	}

       	@Override
       	protected IRMLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleMapping"
    // InternalIRML.g:65:1: entryRuleMapping returns [EObject current=null] : iv_ruleMapping= ruleMapping EOF ;
    public final EObject entryRuleMapping() throws RecognitionException {
        EObject current = null;
        int entryRuleMapping_StartIndex = input.index();
        EObject iv_ruleMapping = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return current; }
            // InternalIRML.g:65:48: (iv_ruleMapping= ruleMapping EOF )
            // InternalIRML.g:66:2: iv_ruleMapping= ruleMapping EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMappingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMapping=ruleMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapping; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, entryRuleMapping_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleMapping"


    // $ANTLR start "ruleMapping"
    // InternalIRML.g:72:1: ruleMapping returns [EObject current=null] : ( (lv_statements_0_0= ruleStatement ) )* ;
    public final EObject ruleMapping() throws RecognitionException {
        EObject current = null;
        int ruleMapping_StartIndex = input.index();
        EObject lv_statements_0_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return current; }
            // InternalIRML.g:78:2: ( ( (lv_statements_0_0= ruleStatement ) )* )
            // InternalIRML.g:79:2: ( (lv_statements_0_0= ruleStatement ) )*
            {
            // InternalIRML.g:79:2: ( (lv_statements_0_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_URIREF && LA1_0<=RULE_ID)||(LA1_0>=16 && LA1_0<=17)||(LA1_0>=25 && LA1_0<=26)||LA1_0==28||(LA1_0>=30 && LA1_0<=31)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIRML.g:80:3: (lv_statements_0_0= ruleStatement )
            	    {
            	    // InternalIRML.g:80:3: (lv_statements_0_0= ruleStatement )
            	    // InternalIRML.g:81:4: lv_statements_0_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getMappingAccess().getStatementsStatementParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_statements_0_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getMappingRule());
            	      				}
            	      				add(
            	      					current,
            	      					"statements",
            	      					lv_statements_0_0,
            	      					"org.xtext.example.rml.IRML.Statement");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, ruleMapping_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleMapping"


    // $ANTLR start "entryRuleStatement"
    // InternalIRML.g:101:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;
        int entryRuleStatement_StartIndex = input.index();
        EObject iv_ruleStatement = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return current; }
            // InternalIRML.g:101:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalIRML.g:102:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, entryRuleStatement_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalIRML.g:108:1: ruleStatement returns [EObject current=null] : ( ( ( (lv_directive_0_0= ruleDirective ) ) | ( (lv_triple_1_0= ruleTriples ) ) ) otherlv_2= '.' ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;
        int ruleStatement_StartIndex = input.index();
        Token otherlv_2=null;
        EObject lv_directive_0_0 = null;

        EObject lv_triple_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // InternalIRML.g:114:2: ( ( ( ( (lv_directive_0_0= ruleDirective ) ) | ( (lv_triple_1_0= ruleTriples ) ) ) otherlv_2= '.' ) )
            // InternalIRML.g:115:2: ( ( ( (lv_directive_0_0= ruleDirective ) ) | ( (lv_triple_1_0= ruleTriples ) ) ) otherlv_2= '.' )
            {
            // InternalIRML.g:115:2: ( ( ( (lv_directive_0_0= ruleDirective ) ) | ( (lv_triple_1_0= ruleTriples ) ) ) otherlv_2= '.' )
            // InternalIRML.g:116:3: ( ( (lv_directive_0_0= ruleDirective ) ) | ( (lv_triple_1_0= ruleTriples ) ) ) otherlv_2= '.'
            {
            // InternalIRML.g:116:3: ( ( (lv_directive_0_0= ruleDirective ) ) | ( (lv_triple_1_0= ruleTriples ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=16 && LA2_0<=17)) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=RULE_URIREF && LA2_0<=RULE_ID)||(LA2_0>=25 && LA2_0<=26)||LA2_0==28||(LA2_0>=30 && LA2_0<=31)) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalIRML.g:117:4: ( (lv_directive_0_0= ruleDirective ) )
                    {
                    // InternalIRML.g:117:4: ( (lv_directive_0_0= ruleDirective ) )
                    // InternalIRML.g:118:5: (lv_directive_0_0= ruleDirective )
                    {
                    // InternalIRML.g:118:5: (lv_directive_0_0= ruleDirective )
                    // InternalIRML.g:119:6: lv_directive_0_0= ruleDirective
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getStatementAccess().getDirectiveDirectiveParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_directive_0_0=ruleDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getStatementRule());
                      						}
                      						set(
                      							current,
                      							"directive",
                      							lv_directive_0_0,
                      							"org.xtext.example.rml.IRML.Directive");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:137:4: ( (lv_triple_1_0= ruleTriples ) )
                    {
                    // InternalIRML.g:137:4: ( (lv_triple_1_0= ruleTriples ) )
                    // InternalIRML.g:138:5: (lv_triple_1_0= ruleTriples )
                    {
                    // InternalIRML.g:138:5: (lv_triple_1_0= ruleTriples )
                    // InternalIRML.g:139:6: lv_triple_1_0= ruleTriples
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getStatementAccess().getTripleTriplesParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_triple_1_0=ruleTriples();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getStatementRule());
                      						}
                      						set(
                      							current,
                      							"triple",
                      							lv_triple_1_0,
                      							"org.xtext.example.rml.IRML.Triples");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getStatementAccess().getFullStopKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, ruleStatement_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleDirective"
    // InternalIRML.g:165:1: entryRuleDirective returns [EObject current=null] : iv_ruleDirective= ruleDirective EOF ;
    public final EObject entryRuleDirective() throws RecognitionException {
        EObject current = null;
        int entryRuleDirective_StartIndex = input.index();
        EObject iv_ruleDirective = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // InternalIRML.g:165:50: (iv_ruleDirective= ruleDirective EOF )
            // InternalIRML.g:166:2: iv_ruleDirective= ruleDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDirective=ruleDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, entryRuleDirective_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleDirective"


    // $ANTLR start "ruleDirective"
    // InternalIRML.g:172:1: ruleDirective returns [EObject current=null] : ( ( (lv_prefix_0_0= rulePrefixID ) ) | ( (lv_base_1_0= ruleBase ) ) ) ;
    public final EObject ruleDirective() throws RecognitionException {
        EObject current = null;
        int ruleDirective_StartIndex = input.index();
        EObject lv_prefix_0_0 = null;

        EObject lv_base_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return current; }
            // InternalIRML.g:178:2: ( ( ( (lv_prefix_0_0= rulePrefixID ) ) | ( (lv_base_1_0= ruleBase ) ) ) )
            // InternalIRML.g:179:2: ( ( (lv_prefix_0_0= rulePrefixID ) ) | ( (lv_base_1_0= ruleBase ) ) )
            {
            // InternalIRML.g:179:2: ( ( (lv_prefix_0_0= rulePrefixID ) ) | ( (lv_base_1_0= ruleBase ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            else if ( (LA3_0==17) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalIRML.g:180:3: ( (lv_prefix_0_0= rulePrefixID ) )
                    {
                    // InternalIRML.g:180:3: ( (lv_prefix_0_0= rulePrefixID ) )
                    // InternalIRML.g:181:4: (lv_prefix_0_0= rulePrefixID )
                    {
                    // InternalIRML.g:181:4: (lv_prefix_0_0= rulePrefixID )
                    // InternalIRML.g:182:5: lv_prefix_0_0= rulePrefixID
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveAccess().getPrefixPrefixIDParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_prefix_0_0=rulePrefixID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDirectiveRule());
                      					}
                      					set(
                      						current,
                      						"prefix",
                      						lv_prefix_0_0,
                      						"org.xtext.example.rml.IRML.PrefixID");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:200:3: ( (lv_base_1_0= ruleBase ) )
                    {
                    // InternalIRML.g:200:3: ( (lv_base_1_0= ruleBase ) )
                    // InternalIRML.g:201:4: (lv_base_1_0= ruleBase )
                    {
                    // InternalIRML.g:201:4: (lv_base_1_0= ruleBase )
                    // InternalIRML.g:202:5: lv_base_1_0= ruleBase
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDirectiveAccess().getBaseBaseParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_base_1_0=ruleBase();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDirectiveRule());
                      					}
                      					set(
                      						current,
                      						"base",
                      						lv_base_1_0,
                      						"org.xtext.example.rml.IRML.Base");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, ruleDirective_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleDirective"


    // $ANTLR start "entryRulePrefixID"
    // InternalIRML.g:223:1: entryRulePrefixID returns [EObject current=null] : iv_rulePrefixID= rulePrefixID EOF ;
    public final EObject entryRulePrefixID() throws RecognitionException {
        EObject current = null;
        int entryRulePrefixID_StartIndex = input.index();
        EObject iv_rulePrefixID = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // InternalIRML.g:223:49: (iv_rulePrefixID= rulePrefixID EOF )
            // InternalIRML.g:224:2: iv_rulePrefixID= rulePrefixID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixIDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrefixID=rulePrefixID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixID; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, entryRulePrefixID_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixID"


    // $ANTLR start "rulePrefixID"
    // InternalIRML.g:230:1: rulePrefixID returns [EObject current=null] : (otherlv_0= '@prefix' ( (lv_prefixName_1_0= rulePrefixName ) ) ( (lv_uriRef_2_0= RULE_URIREF ) ) ) ;
    public final EObject rulePrefixID() throws RecognitionException {
        EObject current = null;
        int rulePrefixID_StartIndex = input.index();
        Token otherlv_0=null;
        Token lv_uriRef_2_0=null;
        AntlrDatatypeRuleToken lv_prefixName_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return current; }
            // InternalIRML.g:236:2: ( (otherlv_0= '@prefix' ( (lv_prefixName_1_0= rulePrefixName ) ) ( (lv_uriRef_2_0= RULE_URIREF ) ) ) )
            // InternalIRML.g:237:2: (otherlv_0= '@prefix' ( (lv_prefixName_1_0= rulePrefixName ) ) ( (lv_uriRef_2_0= RULE_URIREF ) ) )
            {
            // InternalIRML.g:237:2: (otherlv_0= '@prefix' ( (lv_prefixName_1_0= rulePrefixName ) ) ( (lv_uriRef_2_0= RULE_URIREF ) ) )
            // InternalIRML.g:238:3: otherlv_0= '@prefix' ( (lv_prefixName_1_0= rulePrefixName ) ) ( (lv_uriRef_2_0= RULE_URIREF ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPrefixIDAccess().getPrefixKeyword_0());
              		
            }
            // InternalIRML.g:242:3: ( (lv_prefixName_1_0= rulePrefixName ) )
            // InternalIRML.g:243:4: (lv_prefixName_1_0= rulePrefixName )
            {
            // InternalIRML.g:243:4: (lv_prefixName_1_0= rulePrefixName )
            // InternalIRML.g:244:5: lv_prefixName_1_0= rulePrefixName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPrefixIDAccess().getPrefixNamePrefixNameParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_prefixName_1_0=rulePrefixName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPrefixIDRule());
              					}
              					set(
              						current,
              						"prefixName",
              						lv_prefixName_1_0,
              						"org.xtext.example.rml.IRML.PrefixName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalIRML.g:261:3: ( (lv_uriRef_2_0= RULE_URIREF ) )
            // InternalIRML.g:262:4: (lv_uriRef_2_0= RULE_URIREF )
            {
            // InternalIRML.g:262:4: (lv_uriRef_2_0= RULE_URIREF )
            // InternalIRML.g:263:5: lv_uriRef_2_0= RULE_URIREF
            {
            lv_uriRef_2_0=(Token)match(input,RULE_URIREF,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_uriRef_2_0, grammarAccess.getPrefixIDAccess().getUriRefURIREFTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPrefixIDRule());
              					}
              					setWithLastConsumed(
              						current,
              						"uriRef",
              						lv_uriRef_2_0,
              						"org.xtext.example.rml.IRML.URIREF");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, rulePrefixID_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePrefixID"


    // $ANTLR start "entryRuleBase"
    // InternalIRML.g:283:1: entryRuleBase returns [EObject current=null] : iv_ruleBase= ruleBase EOF ;
    public final EObject entryRuleBase() throws RecognitionException {
        EObject current = null;
        int entryRuleBase_StartIndex = input.index();
        EObject iv_ruleBase = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return current; }
            // InternalIRML.g:283:45: (iv_ruleBase= ruleBase EOF )
            // InternalIRML.g:284:2: iv_ruleBase= ruleBase EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBaseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBase=ruleBase();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBase; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, entryRuleBase_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleBase"


    // $ANTLR start "ruleBase"
    // InternalIRML.g:290:1: ruleBase returns [EObject current=null] : (otherlv_0= '@base' ( (lv_uriRef_1_0= RULE_URIREF ) ) ) ;
    public final EObject ruleBase() throws RecognitionException {
        EObject current = null;
        int ruleBase_StartIndex = input.index();
        Token otherlv_0=null;
        Token lv_uriRef_1_0=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return current; }
            // InternalIRML.g:296:2: ( (otherlv_0= '@base' ( (lv_uriRef_1_0= RULE_URIREF ) ) ) )
            // InternalIRML.g:297:2: (otherlv_0= '@base' ( (lv_uriRef_1_0= RULE_URIREF ) ) )
            {
            // InternalIRML.g:297:2: (otherlv_0= '@base' ( (lv_uriRef_1_0= RULE_URIREF ) ) )
            // InternalIRML.g:298:3: otherlv_0= '@base' ( (lv_uriRef_1_0= RULE_URIREF ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBaseAccess().getBaseKeyword_0());
              		
            }
            // InternalIRML.g:302:3: ( (lv_uriRef_1_0= RULE_URIREF ) )
            // InternalIRML.g:303:4: (lv_uriRef_1_0= RULE_URIREF )
            {
            // InternalIRML.g:303:4: (lv_uriRef_1_0= RULE_URIREF )
            // InternalIRML.g:304:5: lv_uriRef_1_0= RULE_URIREF
            {
            lv_uriRef_1_0=(Token)match(input,RULE_URIREF,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_uriRef_1_0, grammarAccess.getBaseAccess().getUriRefURIREFTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBaseRule());
              					}
              					setWithLastConsumed(
              						current,
              						"uriRef",
              						lv_uriRef_1_0,
              						"org.xtext.example.rml.IRML.URIREF");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, ruleBase_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleBase"


    // $ANTLR start "entryRuleTriples"
    // InternalIRML.g:324:1: entryRuleTriples returns [EObject current=null] : iv_ruleTriples= ruleTriples EOF ;
    public final EObject entryRuleTriples() throws RecognitionException {
        EObject current = null;
        int entryRuleTriples_StartIndex = input.index();
        EObject iv_ruleTriples = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return current; }
            // InternalIRML.g:324:48: (iv_ruleTriples= ruleTriples EOF )
            // InternalIRML.g:325:2: iv_ruleTriples= ruleTriples EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTriplesRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTriples=ruleTriples();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTriples; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, entryRuleTriples_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTriples"


    // $ANTLR start "ruleTriples"
    // InternalIRML.g:331:1: ruleTriples returns [EObject current=null] : ( ( (lv_subject_0_0= ruleSubject ) ) ( (lv_predicateObjectList_1_0= rulePredicateObjectList ) ) ) ;
    public final EObject ruleTriples() throws RecognitionException {
        EObject current = null;
        int ruleTriples_StartIndex = input.index();
        EObject lv_subject_0_0 = null;

        EObject lv_predicateObjectList_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return current; }
            // InternalIRML.g:337:2: ( ( ( (lv_subject_0_0= ruleSubject ) ) ( (lv_predicateObjectList_1_0= rulePredicateObjectList ) ) ) )
            // InternalIRML.g:338:2: ( ( (lv_subject_0_0= ruleSubject ) ) ( (lv_predicateObjectList_1_0= rulePredicateObjectList ) ) )
            {
            // InternalIRML.g:338:2: ( ( (lv_subject_0_0= ruleSubject ) ) ( (lv_predicateObjectList_1_0= rulePredicateObjectList ) ) )
            // InternalIRML.g:339:3: ( (lv_subject_0_0= ruleSubject ) ) ( (lv_predicateObjectList_1_0= rulePredicateObjectList ) )
            {
            // InternalIRML.g:339:3: ( (lv_subject_0_0= ruleSubject ) )
            // InternalIRML.g:340:4: (lv_subject_0_0= ruleSubject )
            {
            // InternalIRML.g:340:4: (lv_subject_0_0= ruleSubject )
            // InternalIRML.g:341:5: lv_subject_0_0= ruleSubject
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTriplesAccess().getSubjectSubjectParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_7);
            lv_subject_0_0=ruleSubject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTriplesRule());
              					}
              					set(
              						current,
              						"subject",
              						lv_subject_0_0,
              						"org.xtext.example.rml.IRML.Subject");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalIRML.g:358:3: ( (lv_predicateObjectList_1_0= rulePredicateObjectList ) )
            // InternalIRML.g:359:4: (lv_predicateObjectList_1_0= rulePredicateObjectList )
            {
            // InternalIRML.g:359:4: (lv_predicateObjectList_1_0= rulePredicateObjectList )
            // InternalIRML.g:360:5: lv_predicateObjectList_1_0= rulePredicateObjectList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTriplesAccess().getPredicateObjectListPredicateObjectListParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_predicateObjectList_1_0=rulePredicateObjectList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTriplesRule());
              					}
              					set(
              						current,
              						"predicateObjectList",
              						lv_predicateObjectList_1_0,
              						"org.xtext.example.rml.IRML.PredicateObjectList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, ruleTriples_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTriples"


    // $ANTLR start "entryRulePredicateObject"
    // InternalIRML.g:381:1: entryRulePredicateObject returns [EObject current=null] : iv_rulePredicateObject= rulePredicateObject EOF ;
    public final EObject entryRulePredicateObject() throws RecognitionException {
        EObject current = null;
        int entryRulePredicateObject_StartIndex = input.index();
        EObject iv_rulePredicateObject = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return current; }
            // InternalIRML.g:381:56: (iv_rulePredicateObject= rulePredicateObject EOF )
            // InternalIRML.g:382:2: iv_rulePredicateObject= rulePredicateObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPredicateObjectRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePredicateObject=rulePredicateObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePredicateObject; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, entryRulePredicateObject_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePredicateObject"


    // $ANTLR start "rulePredicateObject"
    // InternalIRML.g:388:1: rulePredicateObject returns [EObject current=null] : ( ( (lv_verb_0_0= ruleVerb ) ) ( (lv_objectList_1_0= ruleObjectList ) ) ) ;
    public final EObject rulePredicateObject() throws RecognitionException {
        EObject current = null;
        int rulePredicateObject_StartIndex = input.index();
        EObject lv_verb_0_0 = null;

        EObject lv_objectList_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return current; }
            // InternalIRML.g:394:2: ( ( ( (lv_verb_0_0= ruleVerb ) ) ( (lv_objectList_1_0= ruleObjectList ) ) ) )
            // InternalIRML.g:395:2: ( ( (lv_verb_0_0= ruleVerb ) ) ( (lv_objectList_1_0= ruleObjectList ) ) )
            {
            // InternalIRML.g:395:2: ( ( (lv_verb_0_0= ruleVerb ) ) ( (lv_objectList_1_0= ruleObjectList ) ) )
            // InternalIRML.g:396:3: ( (lv_verb_0_0= ruleVerb ) ) ( (lv_objectList_1_0= ruleObjectList ) )
            {
            // InternalIRML.g:396:3: ( (lv_verb_0_0= ruleVerb ) )
            // InternalIRML.g:397:4: (lv_verb_0_0= ruleVerb )
            {
            // InternalIRML.g:397:4: (lv_verb_0_0= ruleVerb )
            // InternalIRML.g:398:5: lv_verb_0_0= ruleVerb
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPredicateObjectAccess().getVerbVerbParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_verb_0_0=ruleVerb();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPredicateObjectRule());
              					}
              					set(
              						current,
              						"verb",
              						lv_verb_0_0,
              						"org.xtext.example.rml.IRML.Verb");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalIRML.g:415:3: ( (lv_objectList_1_0= ruleObjectList ) )
            // InternalIRML.g:416:4: (lv_objectList_1_0= ruleObjectList )
            {
            // InternalIRML.g:416:4: (lv_objectList_1_0= ruleObjectList )
            // InternalIRML.g:417:5: lv_objectList_1_0= ruleObjectList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPredicateObjectAccess().getObjectListObjectListParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_objectList_1_0=ruleObjectList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPredicateObjectRule());
              					}
              					set(
              						current,
              						"objectList",
              						lv_objectList_1_0,
              						"org.xtext.example.rml.IRML.ObjectList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, rulePredicateObject_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePredicateObject"


    // $ANTLR start "entryRulePredicateObjectList"
    // InternalIRML.g:438:1: entryRulePredicateObjectList returns [EObject current=null] : iv_rulePredicateObjectList= rulePredicateObjectList EOF ;
    public final EObject entryRulePredicateObjectList() throws RecognitionException {
        EObject current = null;
        int entryRulePredicateObjectList_StartIndex = input.index();
        EObject iv_rulePredicateObjectList = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return current; }
            // InternalIRML.g:438:60: (iv_rulePredicateObjectList= rulePredicateObjectList EOF )
            // InternalIRML.g:439:2: iv_rulePredicateObjectList= rulePredicateObjectList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPredicateObjectListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePredicateObjectList=rulePredicateObjectList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePredicateObjectList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, entryRulePredicateObjectList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePredicateObjectList"


    // $ANTLR start "rulePredicateObjectList"
    // InternalIRML.g:445:1: rulePredicateObjectList returns [EObject current=null] : ( ( (lv_predicateObjects_0_0= rulePredicateObject ) ) (otherlv_1= ';' ( (lv_predicateObjects_2_0= rulePredicateObject ) ) )* (otherlv_3= ';' )? ) ;
    public final EObject rulePredicateObjectList() throws RecognitionException {
        EObject current = null;
        int rulePredicateObjectList_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_predicateObjects_0_0 = null;

        EObject lv_predicateObjects_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return current; }
            // InternalIRML.g:451:2: ( ( ( (lv_predicateObjects_0_0= rulePredicateObject ) ) (otherlv_1= ';' ( (lv_predicateObjects_2_0= rulePredicateObject ) ) )* (otherlv_3= ';' )? ) )
            // InternalIRML.g:452:2: ( ( (lv_predicateObjects_0_0= rulePredicateObject ) ) (otherlv_1= ';' ( (lv_predicateObjects_2_0= rulePredicateObject ) ) )* (otherlv_3= ';' )? )
            {
            // InternalIRML.g:452:2: ( ( (lv_predicateObjects_0_0= rulePredicateObject ) ) (otherlv_1= ';' ( (lv_predicateObjects_2_0= rulePredicateObject ) ) )* (otherlv_3= ';' )? )
            // InternalIRML.g:453:3: ( (lv_predicateObjects_0_0= rulePredicateObject ) ) (otherlv_1= ';' ( (lv_predicateObjects_2_0= rulePredicateObject ) ) )* (otherlv_3= ';' )?
            {
            // InternalIRML.g:453:3: ( (lv_predicateObjects_0_0= rulePredicateObject ) )
            // InternalIRML.g:454:4: (lv_predicateObjects_0_0= rulePredicateObject )
            {
            // InternalIRML.g:454:4: (lv_predicateObjects_0_0= rulePredicateObject )
            // InternalIRML.g:455:5: lv_predicateObjects_0_0= rulePredicateObject
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPredicateObjectListAccess().getPredicateObjectsPredicateObjectParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_predicateObjects_0_0=rulePredicateObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPredicateObjectListRule());
              					}
              					add(
              						current,
              						"predicateObjects",
              						lv_predicateObjects_0_0,
              						"org.xtext.example.rml.IRML.PredicateObject");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalIRML.g:472:3: (otherlv_1= ';' ( (lv_predicateObjects_2_0= rulePredicateObject ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    int LA4_1 = input.LA(2);

                    if ( ((LA4_1>=RULE_URIREF && LA4_1<=RULE_ID)||LA4_1==20||LA4_1==31) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // InternalIRML.g:473:4: otherlv_1= ';' ( (lv_predicateObjects_2_0= rulePredicateObject ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getPredicateObjectListAccess().getSemicolonKeyword_1_0());
            	      			
            	    }
            	    // InternalIRML.g:477:4: ( (lv_predicateObjects_2_0= rulePredicateObject ) )
            	    // InternalIRML.g:478:5: (lv_predicateObjects_2_0= rulePredicateObject )
            	    {
            	    // InternalIRML.g:478:5: (lv_predicateObjects_2_0= rulePredicateObject )
            	    // InternalIRML.g:479:6: lv_predicateObjects_2_0= rulePredicateObject
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPredicateObjectListAccess().getPredicateObjectsPredicateObjectParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_predicateObjects_2_0=rulePredicateObject();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPredicateObjectListRule());
            	      						}
            	      						add(
            	      							current,
            	      							"predicateObjects",
            	      							lv_predicateObjects_2_0,
            	      							"org.xtext.example.rml.IRML.PredicateObject");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalIRML.g:497:3: (otherlv_3= ';' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalIRML.g:498:4: otherlv_3= ';'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getPredicateObjectListAccess().getSemicolonKeyword_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, rulePredicateObjectList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePredicateObjectList"


    // $ANTLR start "entryRuleObjectList"
    // InternalIRML.g:507:1: entryRuleObjectList returns [EObject current=null] : iv_ruleObjectList= ruleObjectList EOF ;
    public final EObject entryRuleObjectList() throws RecognitionException {
        EObject current = null;
        int entryRuleObjectList_StartIndex = input.index();
        EObject iv_ruleObjectList = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return current; }
            // InternalIRML.g:507:51: (iv_ruleObjectList= ruleObjectList EOF )
            // InternalIRML.g:508:2: iv_ruleObjectList= ruleObjectList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleObjectList=ruleObjectList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, entryRuleObjectList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectList"


    // $ANTLR start "ruleObjectList"
    // InternalIRML.g:514:1: ruleObjectList returns [EObject current=null] : ( ( (lv_objects_0_0= ruleObject ) ) (otherlv_1= ',' ( (lv_objects_2_0= ruleObject ) ) )* ) ;
    public final EObject ruleObjectList() throws RecognitionException {
        EObject current = null;
        int ruleObjectList_StartIndex = input.index();
        Token otherlv_1=null;
        EObject lv_objects_0_0 = null;

        EObject lv_objects_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return current; }
            // InternalIRML.g:520:2: ( ( ( (lv_objects_0_0= ruleObject ) ) (otherlv_1= ',' ( (lv_objects_2_0= ruleObject ) ) )* ) )
            // InternalIRML.g:521:2: ( ( (lv_objects_0_0= ruleObject ) ) (otherlv_1= ',' ( (lv_objects_2_0= ruleObject ) ) )* )
            {
            // InternalIRML.g:521:2: ( ( (lv_objects_0_0= ruleObject ) ) (otherlv_1= ',' ( (lv_objects_2_0= ruleObject ) ) )* )
            // InternalIRML.g:522:3: ( (lv_objects_0_0= ruleObject ) ) (otherlv_1= ',' ( (lv_objects_2_0= ruleObject ) ) )*
            {
            // InternalIRML.g:522:3: ( (lv_objects_0_0= ruleObject ) )
            // InternalIRML.g:523:4: (lv_objects_0_0= ruleObject )
            {
            // InternalIRML.g:523:4: (lv_objects_0_0= ruleObject )
            // InternalIRML.g:524:5: lv_objects_0_0= ruleObject
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getObjectListAccess().getObjectsObjectParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_10);
            lv_objects_0_0=ruleObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getObjectListRule());
              					}
              					add(
              						current,
              						"objects",
              						lv_objects_0_0,
              						"org.xtext.example.rml.IRML.Object");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalIRML.g:541:3: (otherlv_1= ',' ( (lv_objects_2_0= ruleObject ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalIRML.g:542:4: otherlv_1= ',' ( (lv_objects_2_0= ruleObject ) )
            	    {
            	    otherlv_1=(Token)match(input,19,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getObjectListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalIRML.g:546:4: ( (lv_objects_2_0= ruleObject ) )
            	    // InternalIRML.g:547:5: (lv_objects_2_0= ruleObject )
            	    {
            	    // InternalIRML.g:547:5: (lv_objects_2_0= ruleObject )
            	    // InternalIRML.g:548:6: lv_objects_2_0= ruleObject
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getObjectListAccess().getObjectsObjectParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_objects_2_0=ruleObject();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getObjectListRule());
            	      						}
            	      						add(
            	      							current,
            	      							"objects",
            	      							lv_objects_2_0,
            	      							"org.xtext.example.rml.IRML.Object");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, ruleObjectList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleObjectList"


    // $ANTLR start "entryRuleVerb"
    // InternalIRML.g:570:1: entryRuleVerb returns [EObject current=null] : iv_ruleVerb= ruleVerb EOF ;
    public final EObject entryRuleVerb() throws RecognitionException {
        EObject current = null;
        int entryRuleVerb_StartIndex = input.index();
        EObject iv_ruleVerb = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return current; }
            // InternalIRML.g:570:45: (iv_ruleVerb= ruleVerb EOF )
            // InternalIRML.g:571:2: iv_ruleVerb= ruleVerb EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVerbRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVerb=ruleVerb();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVerb; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, entryRuleVerb_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleVerb"


    // $ANTLR start "ruleVerb"
    // InternalIRML.g:577:1: ruleVerb returns [EObject current=null] : ( ( (lv_predicate_0_0= rulePredicate ) ) | ( (lv_isA_1_0= 'a' ) ) ) ;
    public final EObject ruleVerb() throws RecognitionException {
        EObject current = null;
        int ruleVerb_StartIndex = input.index();
        Token lv_isA_1_0=null;
        EObject lv_predicate_0_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return current; }
            // InternalIRML.g:583:2: ( ( ( (lv_predicate_0_0= rulePredicate ) ) | ( (lv_isA_1_0= 'a' ) ) ) )
            // InternalIRML.g:584:2: ( ( (lv_predicate_0_0= rulePredicate ) ) | ( (lv_isA_1_0= 'a' ) ) )
            {
            // InternalIRML.g:584:2: ( ( (lv_predicate_0_0= rulePredicate ) ) | ( (lv_isA_1_0= 'a' ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_URIREF && LA7_0<=RULE_ID)||LA7_0==31) ) {
                alt7=1;
            }
            else if ( (LA7_0==20) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalIRML.g:585:3: ( (lv_predicate_0_0= rulePredicate ) )
                    {
                    // InternalIRML.g:585:3: ( (lv_predicate_0_0= rulePredicate ) )
                    // InternalIRML.g:586:4: (lv_predicate_0_0= rulePredicate )
                    {
                    // InternalIRML.g:586:4: (lv_predicate_0_0= rulePredicate )
                    // InternalIRML.g:587:5: lv_predicate_0_0= rulePredicate
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getVerbAccess().getPredicatePredicateParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_predicate_0_0=rulePredicate();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getVerbRule());
                      					}
                      					set(
                      						current,
                      						"predicate",
                      						lv_predicate_0_0,
                      						"org.xtext.example.rml.IRML.Predicate");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:605:3: ( (lv_isA_1_0= 'a' ) )
                    {
                    // InternalIRML.g:605:3: ( (lv_isA_1_0= 'a' ) )
                    // InternalIRML.g:606:4: (lv_isA_1_0= 'a' )
                    {
                    // InternalIRML.g:606:4: (lv_isA_1_0= 'a' )
                    // InternalIRML.g:607:5: lv_isA_1_0= 'a'
                    {
                    lv_isA_1_0=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_isA_1_0, grammarAccess.getVerbAccess().getIsAAKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getVerbRule());
                      					}
                      					setWithLastConsumed(current, "isA", true, "a");
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, ruleVerb_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleVerb"


    // $ANTLR start "entryRuleSubject"
    // InternalIRML.g:623:1: entryRuleSubject returns [EObject current=null] : iv_ruleSubject= ruleSubject EOF ;
    public final EObject entryRuleSubject() throws RecognitionException {
        EObject current = null;
        int entryRuleSubject_StartIndex = input.index();
        EObject iv_ruleSubject = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return current; }
            // InternalIRML.g:623:48: (iv_ruleSubject= ruleSubject EOF )
            // InternalIRML.g:624:2: iv_ruleSubject= ruleSubject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubjectRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSubject=ruleSubject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubject; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, entryRuleSubject_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleSubject"


    // $ANTLR start "ruleSubject"
    // InternalIRML.g:630:1: ruleSubject returns [EObject current=null] : ( ( (lv_resource_0_0= ruleiResource ) ) | ( (lv_blank_1_0= ruleBlank ) ) ) ;
    public final EObject ruleSubject() throws RecognitionException {
        EObject current = null;
        int ruleSubject_StartIndex = input.index();
        EObject lv_resource_0_0 = null;

        EObject lv_blank_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return current; }
            // InternalIRML.g:636:2: ( ( ( (lv_resource_0_0= ruleiResource ) ) | ( (lv_blank_1_0= ruleBlank ) ) ) )
            // InternalIRML.g:637:2: ( ( (lv_resource_0_0= ruleiResource ) ) | ( (lv_blank_1_0= ruleBlank ) ) )
            {
            // InternalIRML.g:637:2: ( ( (lv_resource_0_0= ruleiResource ) ) | ( (lv_blank_1_0= ruleBlank ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_URIREF && LA8_0<=RULE_ID)||LA8_0==31) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=25 && LA8_0<=26)||LA8_0==28||LA8_0==30) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalIRML.g:638:3: ( (lv_resource_0_0= ruleiResource ) )
                    {
                    // InternalIRML.g:638:3: ( (lv_resource_0_0= ruleiResource ) )
                    // InternalIRML.g:639:4: (lv_resource_0_0= ruleiResource )
                    {
                    // InternalIRML.g:639:4: (lv_resource_0_0= ruleiResource )
                    // InternalIRML.g:640:5: lv_resource_0_0= ruleiResource
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSubjectAccess().getResourceIResourceParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_resource_0_0=ruleiResource();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSubjectRule());
                      					}
                      					set(
                      						current,
                      						"resource",
                      						lv_resource_0_0,
                      						"org.xtext.example.rml.IRML.iResource");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:658:3: ( (lv_blank_1_0= ruleBlank ) )
                    {
                    // InternalIRML.g:658:3: ( (lv_blank_1_0= ruleBlank ) )
                    // InternalIRML.g:659:4: (lv_blank_1_0= ruleBlank )
                    {
                    // InternalIRML.g:659:4: (lv_blank_1_0= ruleBlank )
                    // InternalIRML.g:660:5: lv_blank_1_0= ruleBlank
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSubjectAccess().getBlankBlankParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_blank_1_0=ruleBlank();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSubjectRule());
                      					}
                      					set(
                      						current,
                      						"blank",
                      						lv_blank_1_0,
                      						"org.xtext.example.rml.IRML.Blank");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, ruleSubject_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleSubject"


    // $ANTLR start "entryRulePredicate"
    // InternalIRML.g:681:1: entryRulePredicate returns [EObject current=null] : iv_rulePredicate= rulePredicate EOF ;
    public final EObject entryRulePredicate() throws RecognitionException {
        EObject current = null;
        int entryRulePredicate_StartIndex = input.index();
        EObject iv_rulePredicate = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return current; }
            // InternalIRML.g:681:50: (iv_rulePredicate= rulePredicate EOF )
            // InternalIRML.g:682:2: iv_rulePredicate= rulePredicate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPredicateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePredicate=rulePredicate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePredicate; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, entryRulePredicate_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePredicate"


    // $ANTLR start "rulePredicate"
    // InternalIRML.g:688:1: rulePredicate returns [EObject current=null] : this_iResource_0= ruleiResource ;
    public final EObject rulePredicate() throws RecognitionException {
        EObject current = null;
        int rulePredicate_StartIndex = input.index();
        EObject this_iResource_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return current; }
            // InternalIRML.g:694:2: (this_iResource_0= ruleiResource )
            // InternalIRML.g:695:2: this_iResource_0= ruleiResource
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getPredicateAccess().getIResourceParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_iResource_0=ruleiResource();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_iResource_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, rulePredicate_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleObject"
    // InternalIRML.g:706:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;
        int entryRuleObject_StartIndex = input.index();
        EObject iv_ruleObject = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return current; }
            // InternalIRML.g:706:47: (iv_ruleObject= ruleObject EOF )
            // InternalIRML.g:707:2: iv_ruleObject= ruleObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleObject=ruleObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObject; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, entryRuleObject_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleObject"


    // $ANTLR start "ruleObject"
    // InternalIRML.g:713:1: ruleObject returns [EObject current=null] : ( ( (lv_resource_0_0= ruleiResource ) ) | ( (lv_blank_1_0= ruleBlank ) ) | ( (lv_literal_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleObject() throws RecognitionException {
        EObject current = null;
        int ruleObject_StartIndex = input.index();
        EObject lv_resource_0_0 = null;

        EObject lv_blank_1_0 = null;

        EObject lv_literal_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return current; }
            // InternalIRML.g:719:2: ( ( ( (lv_resource_0_0= ruleiResource ) ) | ( (lv_blank_1_0= ruleBlank ) ) | ( (lv_literal_2_0= ruleLiteral ) ) ) )
            // InternalIRML.g:720:2: ( ( (lv_resource_0_0= ruleiResource ) ) | ( (lv_blank_1_0= ruleBlank ) ) | ( (lv_literal_2_0= ruleLiteral ) ) )
            {
            // InternalIRML.g:720:2: ( ( (lv_resource_0_0= ruleiResource ) ) | ( (lv_blank_1_0= ruleBlank ) ) | ( (lv_literal_2_0= ruleLiteral ) ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case RULE_URIREF:
            case RULE_ID:
            case 31:
                {
                alt9=1;
                }
                break;
            case 25:
            case 26:
            case 28:
            case 30:
                {
                alt9=2;
                }
                break;
            case RULE_INT:
            case RULE_DOUBLE:
            case RULE_DECIMAL:
            case RULE_STRING:
            case 23:
            case 24:
                {
                alt9=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalIRML.g:721:3: ( (lv_resource_0_0= ruleiResource ) )
                    {
                    // InternalIRML.g:721:3: ( (lv_resource_0_0= ruleiResource ) )
                    // InternalIRML.g:722:4: (lv_resource_0_0= ruleiResource )
                    {
                    // InternalIRML.g:722:4: (lv_resource_0_0= ruleiResource )
                    // InternalIRML.g:723:5: lv_resource_0_0= ruleiResource
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getObjectAccess().getResourceIResourceParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_resource_0_0=ruleiResource();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getObjectRule());
                      					}
                      					set(
                      						current,
                      						"resource",
                      						lv_resource_0_0,
                      						"org.xtext.example.rml.IRML.iResource");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:741:3: ( (lv_blank_1_0= ruleBlank ) )
                    {
                    // InternalIRML.g:741:3: ( (lv_blank_1_0= ruleBlank ) )
                    // InternalIRML.g:742:4: (lv_blank_1_0= ruleBlank )
                    {
                    // InternalIRML.g:742:4: (lv_blank_1_0= ruleBlank )
                    // InternalIRML.g:743:5: lv_blank_1_0= ruleBlank
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getObjectAccess().getBlankBlankParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_blank_1_0=ruleBlank();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getObjectRule());
                      					}
                      					set(
                      						current,
                      						"blank",
                      						lv_blank_1_0,
                      						"org.xtext.example.rml.IRML.Blank");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIRML.g:761:3: ( (lv_literal_2_0= ruleLiteral ) )
                    {
                    // InternalIRML.g:761:3: ( (lv_literal_2_0= ruleLiteral ) )
                    // InternalIRML.g:762:4: (lv_literal_2_0= ruleLiteral )
                    {
                    // InternalIRML.g:762:4: (lv_literal_2_0= ruleLiteral )
                    // InternalIRML.g:763:5: lv_literal_2_0= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getObjectAccess().getLiteralLiteralParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_literal_2_0=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getObjectRule());
                      					}
                      					set(
                      						current,
                      						"literal",
                      						lv_literal_2_0,
                      						"org.xtext.example.rml.IRML.Literal");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, ruleObject_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleLanguageString"
    // InternalIRML.g:784:1: entryRuleLanguageString returns [EObject current=null] : iv_ruleLanguageString= ruleLanguageString EOF ;
    public final EObject entryRuleLanguageString() throws RecognitionException {
        EObject current = null;
        int entryRuleLanguageString_StartIndex = input.index();
        EObject iv_ruleLanguageString = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return current; }
            // InternalIRML.g:784:55: (iv_ruleLanguageString= ruleLanguageString EOF )
            // InternalIRML.g:785:2: iv_ruleLanguageString= ruleLanguageString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLanguageStringRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLanguageString=ruleLanguageString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLanguageString; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, entryRuleLanguageString_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLanguageString"


    // $ANTLR start "ruleLanguageString"
    // InternalIRML.g:791:1: ruleLanguageString returns [EObject current=null] : ( ( (lv_qutoedString_0_0= ruleQuotedString ) ) (otherlv_1= '@' ( (lv_lang_2_0= RULE_ID ) ) )? ) ;
    public final EObject ruleLanguageString() throws RecognitionException {
        EObject current = null;
        int ruleLanguageString_StartIndex = input.index();
        Token otherlv_1=null;
        Token lv_lang_2_0=null;
        AntlrDatatypeRuleToken lv_qutoedString_0_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return current; }
            // InternalIRML.g:797:2: ( ( ( (lv_qutoedString_0_0= ruleQuotedString ) ) (otherlv_1= '@' ( (lv_lang_2_0= RULE_ID ) ) )? ) )
            // InternalIRML.g:798:2: ( ( (lv_qutoedString_0_0= ruleQuotedString ) ) (otherlv_1= '@' ( (lv_lang_2_0= RULE_ID ) ) )? )
            {
            // InternalIRML.g:798:2: ( ( (lv_qutoedString_0_0= ruleQuotedString ) ) (otherlv_1= '@' ( (lv_lang_2_0= RULE_ID ) ) )? )
            // InternalIRML.g:799:3: ( (lv_qutoedString_0_0= ruleQuotedString ) ) (otherlv_1= '@' ( (lv_lang_2_0= RULE_ID ) ) )?
            {
            // InternalIRML.g:799:3: ( (lv_qutoedString_0_0= ruleQuotedString ) )
            // InternalIRML.g:800:4: (lv_qutoedString_0_0= ruleQuotedString )
            {
            // InternalIRML.g:800:4: (lv_qutoedString_0_0= ruleQuotedString )
            // InternalIRML.g:801:5: lv_qutoedString_0_0= ruleQuotedString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLanguageStringAccess().getQutoedStringQuotedStringParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_qutoedString_0_0=ruleQuotedString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLanguageStringRule());
              					}
              					set(
              						current,
              						"qutoedString",
              						lv_qutoedString_0_0,
              						"org.xtext.example.rml.IRML.QuotedString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalIRML.g:818:3: (otherlv_1= '@' ( (lv_lang_2_0= RULE_ID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalIRML.g:819:4: otherlv_1= '@' ( (lv_lang_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getLanguageStringAccess().getCommercialAtKeyword_1_0());
                      			
                    }
                    // InternalIRML.g:823:4: ( (lv_lang_2_0= RULE_ID ) )
                    // InternalIRML.g:824:5: (lv_lang_2_0= RULE_ID )
                    {
                    // InternalIRML.g:824:5: (lv_lang_2_0= RULE_ID )
                    // InternalIRML.g:825:6: lv_lang_2_0= RULE_ID
                    {
                    lv_lang_2_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_lang_2_0, grammarAccess.getLanguageStringAccess().getLangIDTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getLanguageStringRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"lang",
                      							lv_lang_2_0,
                      							"org.xtext.example.rml.IRML.ID");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, ruleLanguageString_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleLanguageString"


    // $ANTLR start "entryRuleLiteral"
    // InternalIRML.g:846:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;
        int entryRuleLiteral_StartIndex = input.index();
        EObject iv_ruleLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return current; }
            // InternalIRML.g:846:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalIRML.g:847:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, entryRuleLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalIRML.g:853:1: ruleLiteral returns [EObject current=null] : ( ( (lv_languageString_0_0= ruleLanguageString ) ) | ( (lv_datatypeString_1_0= ruleDatatypeString ) ) | ( (lv_dword_2_0= RULE_INT ) ) | ( (lv_real_3_0= RULE_DOUBLE ) ) | ( (lv_decimal_4_0= RULE_DECIMAL ) ) | ( (lv_bool_5_0= ruleBoolean ) ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;
        int ruleLiteral_StartIndex = input.index();
        Token lv_dword_2_0=null;
        Token lv_real_3_0=null;
        Token lv_decimal_4_0=null;
        EObject lv_languageString_0_0 = null;

        EObject lv_datatypeString_1_0 = null;

        AntlrDatatypeRuleToken lv_bool_5_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return current; }
            // InternalIRML.g:859:2: ( ( ( (lv_languageString_0_0= ruleLanguageString ) ) | ( (lv_datatypeString_1_0= ruleDatatypeString ) ) | ( (lv_dword_2_0= RULE_INT ) ) | ( (lv_real_3_0= RULE_DOUBLE ) ) | ( (lv_decimal_4_0= RULE_DECIMAL ) ) | ( (lv_bool_5_0= ruleBoolean ) ) ) )
            // InternalIRML.g:860:2: ( ( (lv_languageString_0_0= ruleLanguageString ) ) | ( (lv_datatypeString_1_0= ruleDatatypeString ) ) | ( (lv_dword_2_0= RULE_INT ) ) | ( (lv_real_3_0= RULE_DOUBLE ) ) | ( (lv_decimal_4_0= RULE_DECIMAL ) ) | ( (lv_bool_5_0= ruleBoolean ) ) )
            {
            // InternalIRML.g:860:2: ( ( (lv_languageString_0_0= ruleLanguageString ) ) | ( (lv_datatypeString_1_0= ruleDatatypeString ) ) | ( (lv_dword_2_0= RULE_INT ) ) | ( (lv_real_3_0= RULE_DOUBLE ) ) | ( (lv_decimal_4_0= RULE_DECIMAL ) ) | ( (lv_bool_5_0= ruleBoolean ) ) )
            int alt11=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==EOF||(LA11_1>=RULE_URIREF && LA11_1<=RULE_STRING)||LA11_1==15||(LA11_1>=18 && LA11_1<=19)||LA11_1==21||(LA11_1>=23 && LA11_1<=31)) ) {
                    alt11=1;
                }
                else if ( (LA11_1==22) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt11=3;
                }
                break;
            case RULE_DOUBLE:
                {
                alt11=4;
                }
                break;
            case RULE_DECIMAL:
                {
                alt11=5;
                }
                break;
            case 23:
            case 24:
                {
                alt11=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalIRML.g:861:3: ( (lv_languageString_0_0= ruleLanguageString ) )
                    {
                    // InternalIRML.g:861:3: ( (lv_languageString_0_0= ruleLanguageString ) )
                    // InternalIRML.g:862:4: (lv_languageString_0_0= ruleLanguageString )
                    {
                    // InternalIRML.g:862:4: (lv_languageString_0_0= ruleLanguageString )
                    // InternalIRML.g:863:5: lv_languageString_0_0= ruleLanguageString
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLiteralAccess().getLanguageStringLanguageStringParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_languageString_0_0=ruleLanguageString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getLiteralRule());
                      					}
                      					set(
                      						current,
                      						"languageString",
                      						lv_languageString_0_0,
                      						"org.xtext.example.rml.IRML.LanguageString");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:881:3: ( (lv_datatypeString_1_0= ruleDatatypeString ) )
                    {
                    // InternalIRML.g:881:3: ( (lv_datatypeString_1_0= ruleDatatypeString ) )
                    // InternalIRML.g:882:4: (lv_datatypeString_1_0= ruleDatatypeString )
                    {
                    // InternalIRML.g:882:4: (lv_datatypeString_1_0= ruleDatatypeString )
                    // InternalIRML.g:883:5: lv_datatypeString_1_0= ruleDatatypeString
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLiteralAccess().getDatatypeStringDatatypeStringParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_datatypeString_1_0=ruleDatatypeString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getLiteralRule());
                      					}
                      					set(
                      						current,
                      						"datatypeString",
                      						lv_datatypeString_1_0,
                      						"org.xtext.example.rml.IRML.DatatypeString");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIRML.g:901:3: ( (lv_dword_2_0= RULE_INT ) )
                    {
                    // InternalIRML.g:901:3: ( (lv_dword_2_0= RULE_INT ) )
                    // InternalIRML.g:902:4: (lv_dword_2_0= RULE_INT )
                    {
                    // InternalIRML.g:902:4: (lv_dword_2_0= RULE_INT )
                    // InternalIRML.g:903:5: lv_dword_2_0= RULE_INT
                    {
                    lv_dword_2_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_dword_2_0, grammarAccess.getLiteralAccess().getDwordINTTerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getLiteralRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"dword",
                      						lv_dword_2_0,
                      						"org.eclipse.xtext.common.Terminals.INT");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalIRML.g:920:3: ( (lv_real_3_0= RULE_DOUBLE ) )
                    {
                    // InternalIRML.g:920:3: ( (lv_real_3_0= RULE_DOUBLE ) )
                    // InternalIRML.g:921:4: (lv_real_3_0= RULE_DOUBLE )
                    {
                    // InternalIRML.g:921:4: (lv_real_3_0= RULE_DOUBLE )
                    // InternalIRML.g:922:5: lv_real_3_0= RULE_DOUBLE
                    {
                    lv_real_3_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_real_3_0, grammarAccess.getLiteralAccess().getRealDOUBLETerminalRuleCall_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getLiteralRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"real",
                      						lv_real_3_0,
                      						"org.xtext.example.rml.IRML.DOUBLE");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalIRML.g:939:3: ( (lv_decimal_4_0= RULE_DECIMAL ) )
                    {
                    // InternalIRML.g:939:3: ( (lv_decimal_4_0= RULE_DECIMAL ) )
                    // InternalIRML.g:940:4: (lv_decimal_4_0= RULE_DECIMAL )
                    {
                    // InternalIRML.g:940:4: (lv_decimal_4_0= RULE_DECIMAL )
                    // InternalIRML.g:941:5: lv_decimal_4_0= RULE_DECIMAL
                    {
                    lv_decimal_4_0=(Token)match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_decimal_4_0, grammarAccess.getLiteralAccess().getDecimalDECIMALTerminalRuleCall_4_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getLiteralRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"decimal",
                      						lv_decimal_4_0,
                      						"org.xtext.example.rml.IRML.DECIMAL");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalIRML.g:958:3: ( (lv_bool_5_0= ruleBoolean ) )
                    {
                    // InternalIRML.g:958:3: ( (lv_bool_5_0= ruleBoolean ) )
                    // InternalIRML.g:959:4: (lv_bool_5_0= ruleBoolean )
                    {
                    // InternalIRML.g:959:4: (lv_bool_5_0= ruleBoolean )
                    // InternalIRML.g:960:5: lv_bool_5_0= ruleBoolean
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLiteralAccess().getBoolBooleanParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_bool_5_0=ruleBoolean();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getLiteralRule());
                      					}
                      					set(
                      						current,
                      						"bool",
                      						lv_bool_5_0,
                      						"org.xtext.example.rml.IRML.Boolean");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, ruleLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleDatatypeString"
    // InternalIRML.g:981:1: entryRuleDatatypeString returns [EObject current=null] : iv_ruleDatatypeString= ruleDatatypeString EOF ;
    public final EObject entryRuleDatatypeString() throws RecognitionException {
        EObject current = null;
        int entryRuleDatatypeString_StartIndex = input.index();
        EObject iv_ruleDatatypeString = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return current; }
            // InternalIRML.g:981:55: (iv_ruleDatatypeString= ruleDatatypeString EOF )
            // InternalIRML.g:982:2: iv_ruleDatatypeString= ruleDatatypeString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDatatypeStringRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDatatypeString=ruleDatatypeString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDatatypeString; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, entryRuleDatatypeString_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleDatatypeString"


    // $ANTLR start "ruleDatatypeString"
    // InternalIRML.g:988:1: ruleDatatypeString returns [EObject current=null] : ( ( (lv_qutoedString_0_0= ruleQuotedString ) ) otherlv_1= '^^' ( (lv_resource_2_0= ruleiResource ) ) ) ;
    public final EObject ruleDatatypeString() throws RecognitionException {
        EObject current = null;
        int ruleDatatypeString_StartIndex = input.index();
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_qutoedString_0_0 = null;

        EObject lv_resource_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return current; }
            // InternalIRML.g:994:2: ( ( ( (lv_qutoedString_0_0= ruleQuotedString ) ) otherlv_1= '^^' ( (lv_resource_2_0= ruleiResource ) ) ) )
            // InternalIRML.g:995:2: ( ( (lv_qutoedString_0_0= ruleQuotedString ) ) otherlv_1= '^^' ( (lv_resource_2_0= ruleiResource ) ) )
            {
            // InternalIRML.g:995:2: ( ( (lv_qutoedString_0_0= ruleQuotedString ) ) otherlv_1= '^^' ( (lv_resource_2_0= ruleiResource ) ) )
            // InternalIRML.g:996:3: ( (lv_qutoedString_0_0= ruleQuotedString ) ) otherlv_1= '^^' ( (lv_resource_2_0= ruleiResource ) )
            {
            // InternalIRML.g:996:3: ( (lv_qutoedString_0_0= ruleQuotedString ) )
            // InternalIRML.g:997:4: (lv_qutoedString_0_0= ruleQuotedString )
            {
            // InternalIRML.g:997:4: (lv_qutoedString_0_0= ruleQuotedString )
            // InternalIRML.g:998:5: lv_qutoedString_0_0= ruleQuotedString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDatatypeStringAccess().getQutoedStringQuotedStringParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_qutoedString_0_0=ruleQuotedString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDatatypeStringRule());
              					}
              					set(
              						current,
              						"qutoedString",
              						lv_qutoedString_0_0,
              						"org.xtext.example.rml.IRML.QuotedString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDatatypeStringAccess().getCircumflexAccentCircumflexAccentKeyword_1());
              		
            }
            // InternalIRML.g:1019:3: ( (lv_resource_2_0= ruleiResource ) )
            // InternalIRML.g:1020:4: (lv_resource_2_0= ruleiResource )
            {
            // InternalIRML.g:1020:4: (lv_resource_2_0= ruleiResource )
            // InternalIRML.g:1021:5: lv_resource_2_0= ruleiResource
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDatatypeStringAccess().getResourceIResourceParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_resource_2_0=ruleiResource();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDatatypeStringRule());
              					}
              					set(
              						current,
              						"resource",
              						lv_resource_2_0,
              						"org.xtext.example.rml.IRML.iResource");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, ruleDatatypeString_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleDatatypeString"


    // $ANTLR start "entryRuleBoolean"
    // InternalIRML.g:1042:1: entryRuleBoolean returns [String current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final String entryRuleBoolean() throws RecognitionException {
        String current = null;
        int entryRuleBoolean_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleBoolean = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return current; }
            // InternalIRML.g:1042:47: (iv_ruleBoolean= ruleBoolean EOF )
            // InternalIRML.g:1043:2: iv_ruleBoolean= ruleBoolean EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoolean.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, entryRuleBoolean_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // InternalIRML.g:1049:1: ruleBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleBoolean_StartIndex = input.index();
        Token kw=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return current; }
            // InternalIRML.g:1055:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalIRML.g:1056:2: (kw= 'true' | kw= 'false' )
            {
            // InternalIRML.g:1056:2: (kw= 'true' | kw= 'false' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            else if ( (LA12_0==24) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalIRML.g:1057:3: kw= 'true'
                    {
                    kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBooleanAccess().getTrueKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalIRML.g:1063:3: kw= 'false'
                    {
                    kw=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBooleanAccess().getFalseKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, ruleBoolean_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleBlank"
    // InternalIRML.g:1072:1: entryRuleBlank returns [EObject current=null] : iv_ruleBlank= ruleBlank EOF ;
    public final EObject entryRuleBlank() throws RecognitionException {
        EObject current = null;
        int entryRuleBlank_StartIndex = input.index();
        EObject iv_ruleBlank = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return current; }
            // InternalIRML.g:1072:46: (iv_ruleBlank= ruleBlank EOF )
            // InternalIRML.g:1073:2: iv_ruleBlank= ruleBlank EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlankRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlank=ruleBlank();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlank; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, entryRuleBlank_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleBlank"


    // $ANTLR start "ruleBlank"
    // InternalIRML.g:1079:1: ruleBlank returns [EObject current=null] : ( ( (lv_nodeID_0_0= ruleNodeID ) ) | ( (lv_isSquare_1_0= '[]' ) ) | (otherlv_2= '[' ( (lv_predicateObjectList_3_0= rulePredicateObjectList ) ) otherlv_4= ']' ) | ( (lv_collection_5_0= ruleCollection ) ) ) ;
    public final EObject ruleBlank() throws RecognitionException {
        EObject current = null;
        int ruleBlank_StartIndex = input.index();
        Token lv_isSquare_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_nodeID_0_0 = null;

        EObject lv_predicateObjectList_3_0 = null;

        EObject lv_collection_5_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return current; }
            // InternalIRML.g:1085:2: ( ( ( (lv_nodeID_0_0= ruleNodeID ) ) | ( (lv_isSquare_1_0= '[]' ) ) | (otherlv_2= '[' ( (lv_predicateObjectList_3_0= rulePredicateObjectList ) ) otherlv_4= ']' ) | ( (lv_collection_5_0= ruleCollection ) ) ) )
            // InternalIRML.g:1086:2: ( ( (lv_nodeID_0_0= ruleNodeID ) ) | ( (lv_isSquare_1_0= '[]' ) ) | (otherlv_2= '[' ( (lv_predicateObjectList_3_0= rulePredicateObjectList ) ) otherlv_4= ']' ) | ( (lv_collection_5_0= ruleCollection ) ) )
            {
            // InternalIRML.g:1086:2: ( ( (lv_nodeID_0_0= ruleNodeID ) ) | ( (lv_isSquare_1_0= '[]' ) ) | (otherlv_2= '[' ( (lv_predicateObjectList_3_0= rulePredicateObjectList ) ) otherlv_4= ']' ) | ( (lv_collection_5_0= ruleCollection ) ) )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt13=1;
                }
                break;
            case 25:
                {
                alt13=2;
                }
                break;
            case 26:
                {
                alt13=3;
                }
                break;
            case 28:
                {
                alt13=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalIRML.g:1087:3: ( (lv_nodeID_0_0= ruleNodeID ) )
                    {
                    // InternalIRML.g:1087:3: ( (lv_nodeID_0_0= ruleNodeID ) )
                    // InternalIRML.g:1088:4: (lv_nodeID_0_0= ruleNodeID )
                    {
                    // InternalIRML.g:1088:4: (lv_nodeID_0_0= ruleNodeID )
                    // InternalIRML.g:1089:5: lv_nodeID_0_0= ruleNodeID
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getBlankAccess().getNodeIDNodeIDParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_nodeID_0_0=ruleNodeID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getBlankRule());
                      					}
                      					set(
                      						current,
                      						"nodeID",
                      						lv_nodeID_0_0,
                      						"org.xtext.example.rml.IRML.NodeID");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:1107:3: ( (lv_isSquare_1_0= '[]' ) )
                    {
                    // InternalIRML.g:1107:3: ( (lv_isSquare_1_0= '[]' ) )
                    // InternalIRML.g:1108:4: (lv_isSquare_1_0= '[]' )
                    {
                    // InternalIRML.g:1108:4: (lv_isSquare_1_0= '[]' )
                    // InternalIRML.g:1109:5: lv_isSquare_1_0= '[]'
                    {
                    lv_isSquare_1_0=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_isSquare_1_0, grammarAccess.getBlankAccess().getIsSquareLeftSquareBracketRightSquareBracketKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBlankRule());
                      					}
                      					setWithLastConsumed(current, "isSquare", true, "[]");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIRML.g:1122:3: (otherlv_2= '[' ( (lv_predicateObjectList_3_0= rulePredicateObjectList ) ) otherlv_4= ']' )
                    {
                    // InternalIRML.g:1122:3: (otherlv_2= '[' ( (lv_predicateObjectList_3_0= rulePredicateObjectList ) ) otherlv_4= ']' )
                    // InternalIRML.g:1123:4: otherlv_2= '[' ( (lv_predicateObjectList_3_0= rulePredicateObjectList ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,26,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getBlankAccess().getLeftSquareBracketKeyword_2_0());
                      			
                    }
                    // InternalIRML.g:1127:4: ( (lv_predicateObjectList_3_0= rulePredicateObjectList ) )
                    // InternalIRML.g:1128:5: (lv_predicateObjectList_3_0= rulePredicateObjectList )
                    {
                    // InternalIRML.g:1128:5: (lv_predicateObjectList_3_0= rulePredicateObjectList )
                    // InternalIRML.g:1129:6: lv_predicateObjectList_3_0= rulePredicateObjectList
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBlankAccess().getPredicateObjectListPredicateObjectListParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_14);
                    lv_predicateObjectList_3_0=rulePredicateObjectList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBlankRule());
                      						}
                      						set(
                      							current,
                      							"predicateObjectList",
                      							lv_predicateObjectList_3_0,
                      							"org.xtext.example.rml.IRML.PredicateObjectList");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getBlankAccess().getRightSquareBracketKeyword_2_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalIRML.g:1152:3: ( (lv_collection_5_0= ruleCollection ) )
                    {
                    // InternalIRML.g:1152:3: ( (lv_collection_5_0= ruleCollection ) )
                    // InternalIRML.g:1153:4: (lv_collection_5_0= ruleCollection )
                    {
                    // InternalIRML.g:1153:4: (lv_collection_5_0= ruleCollection )
                    // InternalIRML.g:1154:5: lv_collection_5_0= ruleCollection
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getBlankAccess().getCollectionCollectionParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_collection_5_0=ruleCollection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getBlankRule());
                      					}
                      					set(
                      						current,
                      						"collection",
                      						lv_collection_5_0,
                      						"org.xtext.example.rml.IRML.Collection");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, ruleBlank_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleBlank"


    // $ANTLR start "entryRuleItemList"
    // InternalIRML.g:1175:1: entryRuleItemList returns [EObject current=null] : iv_ruleItemList= ruleItemList EOF ;
    public final EObject entryRuleItemList() throws RecognitionException {
        EObject current = null;
        int entryRuleItemList_StartIndex = input.index();
        EObject iv_ruleItemList = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return current; }
            // InternalIRML.g:1175:49: (iv_ruleItemList= ruleItemList EOF )
            // InternalIRML.g:1176:2: iv_ruleItemList= ruleItemList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getItemListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleItemList=ruleItemList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleItemList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, entryRuleItemList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleItemList"


    // $ANTLR start "ruleItemList"
    // InternalIRML.g:1182:1: ruleItemList returns [EObject current=null] : ( ( (lv_objects_0_0= ruleObject ) ) ( (lv_objects_1_0= ruleObject ) )* ) ;
    public final EObject ruleItemList() throws RecognitionException {
        EObject current = null;
        int ruleItemList_StartIndex = input.index();
        EObject lv_objects_0_0 = null;

        EObject lv_objects_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return current; }
            // InternalIRML.g:1188:2: ( ( ( (lv_objects_0_0= ruleObject ) ) ( (lv_objects_1_0= ruleObject ) )* ) )
            // InternalIRML.g:1189:2: ( ( (lv_objects_0_0= ruleObject ) ) ( (lv_objects_1_0= ruleObject ) )* )
            {
            // InternalIRML.g:1189:2: ( ( (lv_objects_0_0= ruleObject ) ) ( (lv_objects_1_0= ruleObject ) )* )
            // InternalIRML.g:1190:3: ( (lv_objects_0_0= ruleObject ) ) ( (lv_objects_1_0= ruleObject ) )*
            {
            // InternalIRML.g:1190:3: ( (lv_objects_0_0= ruleObject ) )
            // InternalIRML.g:1191:4: (lv_objects_0_0= ruleObject )
            {
            // InternalIRML.g:1191:4: (lv_objects_0_0= ruleObject )
            // InternalIRML.g:1192:5: lv_objects_0_0= ruleObject
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getItemListAccess().getObjectsObjectParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_objects_0_0=ruleObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getItemListRule());
              					}
              					add(
              						current,
              						"objects",
              						lv_objects_0_0,
              						"org.xtext.example.rml.IRML.Object");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalIRML.g:1209:3: ( (lv_objects_1_0= ruleObject ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=RULE_URIREF && LA14_0<=RULE_STRING)||(LA14_0>=23 && LA14_0<=26)||LA14_0==28||(LA14_0>=30 && LA14_0<=31)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalIRML.g:1210:4: (lv_objects_1_0= ruleObject )
            	    {
            	    // InternalIRML.g:1210:4: (lv_objects_1_0= ruleObject )
            	    // InternalIRML.g:1211:5: lv_objects_1_0= ruleObject
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getItemListAccess().getObjectsObjectParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_objects_1_0=ruleObject();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getItemListRule());
            	      					}
            	      					add(
            	      						current,
            	      						"objects",
            	      						lv_objects_1_0,
            	      						"org.xtext.example.rml.IRML.Object");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, ruleItemList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleItemList"


    // $ANTLR start "entryRuleCollection"
    // InternalIRML.g:1232:1: entryRuleCollection returns [EObject current=null] : iv_ruleCollection= ruleCollection EOF ;
    public final EObject entryRuleCollection() throws RecognitionException {
        EObject current = null;
        int entryRuleCollection_StartIndex = input.index();
        EObject iv_ruleCollection = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return current; }
            // InternalIRML.g:1232:51: (iv_ruleCollection= ruleCollection EOF )
            // InternalIRML.g:1233:2: iv_ruleCollection= ruleCollection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCollection=ruleCollection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollection; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, entryRuleCollection_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleCollection"


    // $ANTLR start "ruleCollection"
    // InternalIRML.g:1239:1: ruleCollection returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_itemList_2_0= ruleItemList ) )? otherlv_3= ')' ) ;
    public final EObject ruleCollection() throws RecognitionException {
        EObject current = null;
        int ruleCollection_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_itemList_2_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return current; }
            // InternalIRML.g:1245:2: ( ( () otherlv_1= '(' ( (lv_itemList_2_0= ruleItemList ) )? otherlv_3= ')' ) )
            // InternalIRML.g:1246:2: ( () otherlv_1= '(' ( (lv_itemList_2_0= ruleItemList ) )? otherlv_3= ')' )
            {
            // InternalIRML.g:1246:2: ( () otherlv_1= '(' ( (lv_itemList_2_0= ruleItemList ) )? otherlv_3= ')' )
            // InternalIRML.g:1247:3: () otherlv_1= '(' ( (lv_itemList_2_0= ruleItemList ) )? otherlv_3= ')'
            {
            // InternalIRML.g:1247:3: ()
            // InternalIRML.g:1248:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCollectionAccess().getCollectionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCollectionAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalIRML.g:1258:3: ( (lv_itemList_2_0= ruleItemList ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_URIREF && LA15_0<=RULE_STRING)||(LA15_0>=23 && LA15_0<=26)||LA15_0==28||(LA15_0>=30 && LA15_0<=31)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalIRML.g:1259:4: (lv_itemList_2_0= ruleItemList )
                    {
                    // InternalIRML.g:1259:4: (lv_itemList_2_0= ruleItemList )
                    // InternalIRML.g:1260:5: lv_itemList_2_0= ruleItemList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getCollectionAccess().getItemListItemListParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_17);
                    lv_itemList_2_0=ruleItemList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getCollectionRule());
                      					}
                      					set(
                      						current,
                      						"itemList",
                      						lv_itemList_2_0,
                      						"org.xtext.example.rml.IRML.ItemList");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getCollectionAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 40, ruleCollection_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleCollection"


    // $ANTLR start "entryRuleiResource"
    // InternalIRML.g:1285:1: entryRuleiResource returns [EObject current=null] : iv_ruleiResource= ruleiResource EOF ;
    public final EObject entryRuleiResource() throws RecognitionException {
        EObject current = null;
        int entryRuleiResource_StartIndex = input.index();
        EObject iv_ruleiResource = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return current; }
            // InternalIRML.g:1285:50: (iv_ruleiResource= ruleiResource EOF )
            // InternalIRML.g:1286:2: iv_ruleiResource= ruleiResource EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIResourceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleiResource=ruleiResource();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleiResource; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, entryRuleiResource_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleiResource"


    // $ANTLR start "ruleiResource"
    // InternalIRML.g:1292:1: ruleiResource returns [EObject current=null] : ( ( (lv_uriRef_0_0= RULE_URIREF ) ) | ( (lv_qname_1_0= ruleQname ) ) ) ;
    public final EObject ruleiResource() throws RecognitionException {
        EObject current = null;
        int ruleiResource_StartIndex = input.index();
        Token lv_uriRef_0_0=null;
        EObject lv_qname_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return current; }
            // InternalIRML.g:1298:2: ( ( ( (lv_uriRef_0_0= RULE_URIREF ) ) | ( (lv_qname_1_0= ruleQname ) ) ) )
            // InternalIRML.g:1299:2: ( ( (lv_uriRef_0_0= RULE_URIREF ) ) | ( (lv_qname_1_0= ruleQname ) ) )
            {
            // InternalIRML.g:1299:2: ( ( (lv_uriRef_0_0= RULE_URIREF ) ) | ( (lv_qname_1_0= ruleQname ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_URIREF) ) {
                alt16=1;
            }
            else if ( (LA16_0==RULE_ID||LA16_0==31) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalIRML.g:1300:3: ( (lv_uriRef_0_0= RULE_URIREF ) )
                    {
                    // InternalIRML.g:1300:3: ( (lv_uriRef_0_0= RULE_URIREF ) )
                    // InternalIRML.g:1301:4: (lv_uriRef_0_0= RULE_URIREF )
                    {
                    // InternalIRML.g:1301:4: (lv_uriRef_0_0= RULE_URIREF )
                    // InternalIRML.g:1302:5: lv_uriRef_0_0= RULE_URIREF
                    {
                    lv_uriRef_0_0=(Token)match(input,RULE_URIREF,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_uriRef_0_0, grammarAccess.getIResourceAccess().getUriRefURIREFTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getIResourceRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"uriRef",
                      						lv_uriRef_0_0,
                      						"org.xtext.example.rml.IRML.URIREF");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIRML.g:1319:3: ( (lv_qname_1_0= ruleQname ) )
                    {
                    // InternalIRML.g:1319:3: ( (lv_qname_1_0= ruleQname ) )
                    // InternalIRML.g:1320:4: (lv_qname_1_0= ruleQname )
                    {
                    // InternalIRML.g:1320:4: (lv_qname_1_0= ruleQname )
                    // InternalIRML.g:1321:5: lv_qname_1_0= ruleQname
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getIResourceAccess().getQnameQnameParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_qname_1_0=ruleQname();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getIResourceRule());
                      					}
                      					set(
                      						current,
                      						"qname",
                      						lv_qname_1_0,
                      						"org.xtext.example.rml.IRML.Qname");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 42, ruleiResource_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleiResource"


    // $ANTLR start "entryRuleNodeID"
    // InternalIRML.g:1342:1: entryRuleNodeID returns [EObject current=null] : iv_ruleNodeID= ruleNodeID EOF ;
    public final EObject entryRuleNodeID() throws RecognitionException {
        EObject current = null;
        int entryRuleNodeID_StartIndex = input.index();
        EObject iv_ruleNodeID = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return current; }
            // InternalIRML.g:1342:47: (iv_ruleNodeID= ruleNodeID EOF )
            // InternalIRML.g:1343:2: iv_ruleNodeID= ruleNodeID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNodeIDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNodeID=ruleNodeID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNodeID; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, entryRuleNodeID_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleNodeID"


    // $ANTLR start "ruleNodeID"
    // InternalIRML.g:1349:1: ruleNodeID returns [EObject current=null] : (otherlv_0= '_:' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNodeID() throws RecognitionException {
        EObject current = null;
        int ruleNodeID_StartIndex = input.index();
        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return current; }
            // InternalIRML.g:1355:2: ( (otherlv_0= '_:' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalIRML.g:1356:2: (otherlv_0= '_:' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalIRML.g:1356:2: (otherlv_0= '_:' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalIRML.g:1357:3: otherlv_0= '_:' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getNodeIDAccess().get_Keyword_0());
              		
            }
            // InternalIRML.g:1361:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalIRML.g:1362:4: (lv_name_1_0= RULE_ID )
            {
            // InternalIRML.g:1362:4: (lv_name_1_0= RULE_ID )
            // InternalIRML.g:1363:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getNodeIDAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getNodeIDRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.xtext.example.rml.IRML.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 44, ruleNodeID_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleNodeID"


    // $ANTLR start "entryRuleQname"
    // InternalIRML.g:1383:1: entryRuleQname returns [EObject current=null] : iv_ruleQname= ruleQname EOF ;
    public final EObject entryRuleQname() throws RecognitionException {
        EObject current = null;
        int entryRuleQname_StartIndex = input.index();
        EObject iv_ruleQname = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return current; }
            // InternalIRML.g:1383:46: (iv_ruleQname= ruleQname EOF )
            // InternalIRML.g:1384:2: iv_ruleQname= ruleQname EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQnameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQname=ruleQname();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQname; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, entryRuleQname_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleQname"


    // $ANTLR start "ruleQname"
    // InternalIRML.g:1390:1: ruleQname returns [EObject current=null] : ( () ( ( ( rulePrefixName ) )=> (lv_prefixName_1_0= rulePrefixName ) ) ( ( ( RULE_ID ) )=> (lv_name_2_0= RULE_ID ) )? ) ;
    public final EObject ruleQname() throws RecognitionException {
        EObject current = null;
        int ruleQname_StartIndex = input.index();
        Token lv_name_2_0=null;
        AntlrDatatypeRuleToken lv_prefixName_1_0 = null;



        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return current; }
            // InternalIRML.g:1396:2: ( ( () ( ( ( rulePrefixName ) )=> (lv_prefixName_1_0= rulePrefixName ) ) ( ( ( RULE_ID ) )=> (lv_name_2_0= RULE_ID ) )? ) )
            // InternalIRML.g:1397:2: ( () ( ( ( rulePrefixName ) )=> (lv_prefixName_1_0= rulePrefixName ) ) ( ( ( RULE_ID ) )=> (lv_name_2_0= RULE_ID ) )? )
            {
            // InternalIRML.g:1397:2: ( () ( ( ( rulePrefixName ) )=> (lv_prefixName_1_0= rulePrefixName ) ) ( ( ( RULE_ID ) )=> (lv_name_2_0= RULE_ID ) )? )
            // InternalIRML.g:1398:3: () ( ( ( rulePrefixName ) )=> (lv_prefixName_1_0= rulePrefixName ) ) ( ( ( RULE_ID ) )=> (lv_name_2_0= RULE_ID ) )?
            {
            // InternalIRML.g:1398:3: ()
            // InternalIRML.g:1399:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getQnameAccess().getQnameAction_0(),
              					current);
              			
            }

            }

            // InternalIRML.g:1405:3: ( ( ( rulePrefixName ) )=> (lv_prefixName_1_0= rulePrefixName ) )
            // InternalIRML.g:1406:4: ( ( rulePrefixName ) )=> (lv_prefixName_1_0= rulePrefixName )
            {
            // InternalIRML.g:1410:4: (lv_prefixName_1_0= rulePrefixName )
            // InternalIRML.g:1411:5: lv_prefixName_1_0= rulePrefixName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getQnameAccess().getPrefixNamePrefixNameParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_prefixName_1_0=rulePrefixName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getQnameRule());
              					}
              					set(
              						current,
              						"prefixName",
              						lv_prefixName_1_0,
              						"org.xtext.example.rml.IRML.PrefixName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalIRML.g:1428:3: ( ( ( RULE_ID ) )=> (lv_name_2_0= RULE_ID ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (synpred2_InternalIRML()) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // InternalIRML.g:1429:4: ( ( RULE_ID ) )=> (lv_name_2_0= RULE_ID )
                    {
                    // InternalIRML.g:1433:4: (lv_name_2_0= RULE_ID )
                    // InternalIRML.g:1434:5: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_name_2_0, grammarAccess.getQnameAccess().getNameIDTerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getQnameRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"name",
                      						lv_name_2_0,
                      						"org.xtext.example.rml.IRML.ID");
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 46, ruleQname_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleQname"


    // $ANTLR start "entryRulePrefixName"
    // InternalIRML.g:1454:1: entryRulePrefixName returns [String current=null] : iv_rulePrefixName= rulePrefixName EOF ;
    public final String entryRulePrefixName() throws RecognitionException {
        String current = null;
        int entryRulePrefixName_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_rulePrefixName = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return current; }
            // InternalIRML.g:1454:50: (iv_rulePrefixName= rulePrefixName EOF )
            // InternalIRML.g:1455:2: iv_rulePrefixName= rulePrefixName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrefixName=rulePrefixName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, entryRulePrefixName_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixName"


    // $ANTLR start "rulePrefixName"
    // InternalIRML.g:1461:1: rulePrefixName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID )? kw= ':' ) ;
    public final AntlrDatatypeRuleToken rulePrefixName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int rulePrefixName_StartIndex = input.index();
        Token this_ID_0=null;
        Token kw=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return current; }
            // InternalIRML.g:1467:2: ( ( (this_ID_0= RULE_ID )? kw= ':' ) )
            // InternalIRML.g:1468:2: ( (this_ID_0= RULE_ID )? kw= ':' )
            {
            // InternalIRML.g:1468:2: ( (this_ID_0= RULE_ID )? kw= ':' )
            // InternalIRML.g:1469:3: (this_ID_0= RULE_ID )? kw= ':'
            {
            // InternalIRML.g:1469:3: (this_ID_0= RULE_ID )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalIRML.g:1470:4: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_0, grammarAccess.getPrefixNameAccess().getIDTerminalRuleCall_0());
                      			
                    }

                    }
                    break;

            }

            kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getPrefixNameAccess().getColonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 48, rulePrefixName_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePrefixName"


    // $ANTLR start "entryRuleQuotedString"
    // InternalIRML.g:1487:1: entryRuleQuotedString returns [String current=null] : iv_ruleQuotedString= ruleQuotedString EOF ;
    public final String entryRuleQuotedString() throws RecognitionException {
        String current = null;
        int entryRuleQuotedString_StartIndex = input.index();
        AntlrDatatypeRuleToken iv_ruleQuotedString = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return current; }
            // InternalIRML.g:1487:52: (iv_ruleQuotedString= ruleQuotedString EOF )
            // InternalIRML.g:1488:2: iv_ruleQuotedString= ruleQuotedString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQuotedStringRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQuotedString=ruleQuotedString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQuotedString.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, entryRuleQuotedString_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleQuotedString"


    // $ANTLR start "ruleQuotedString"
    // InternalIRML.g:1494:1: ruleQuotedString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleQuotedString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();
        int ruleQuotedString_StartIndex = input.index();
        Token this_STRING_0=null;


        	enterRule();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return current; }
            // InternalIRML.g:1500:2: (this_STRING_0= RULE_STRING )
            // InternalIRML.g:1501:2: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_STRING_0, grammarAccess.getQuotedStringAccess().getSTRINGTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 50, ruleQuotedString_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleQuotedString"

    // $ANTLR start synpred2_InternalIRML
    public final void synpred2_InternalIRML_fragment() throws RecognitionException {   
        // InternalIRML.g:1429:4: ( ( RULE_ID ) )
        // InternalIRML.g:1429:5: ( RULE_ID )
        {
        // InternalIRML.g:1429:5: ( RULE_ID )
        // InternalIRML.g:1430:5: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalIRML

    // Delegated rules

    public final boolean synpred2_InternalIRML() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalIRML_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000D6030032L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000080000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000080100030L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000D78303F0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00000000D78303F2L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000000F78303F0L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080000000L});

}