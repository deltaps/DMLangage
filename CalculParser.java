// Generated from Calcul.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, RETURN=26, TYPE=27, NEWLINE=28, WS=29, ENTIER=30, DOUBLE=31, 
		IDENTIFIANT=32, OPERATEUR=33, AND=34, OR=35, NOT=36, COMMENTAIRE=37, UNMATCH=38;
	public static final int
		RULE_start = 0, RULE_fonction = 1, RULE_params = 2, RULE_args = 3, RULE_retourne = 4, 
		RULE_calcul = 5, RULE_instruction = 6, RULE_bloc = 7, RULE_expression = 8, 
		RULE_decl = 9, RULE_assignation = 10, RULE_read = 11, RULE_write = 12, 
		RULE_boucle_while = 13, RULE_repetition = 14, RULE_condition = 15, RULE_branchement = 16, 
		RULE_finInstruction = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "fonction", "params", "args", "retourne", "calcul", "instruction", 
			"bloc", "expression", "decl", "assignation", "read", "write", "boucle_while", 
			"repetition", "condition", "branchement", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fun'", "':'", "'('", "')'", "','", "'{'", "'}'", "'-'", "'*'", 
			"'/'", "'+'", "'var'", "'='", "'+='", "'read('", "'write('", "'while'", 
			"'for'", "';'", "'repeat'", "'until'", "'true'", "'false'", "'if'", "'else'", 
			"'return'", null, null, null, null, null, null, null, "'&&'", "'||'", 
			"'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "RETURN", "TYPE", "NEWLINE", "WS", "ENTIER", "DOUBLE", "IDENTIFIANT", 
			"OPERATEUR", "AND", "OR", "NOT", "COMMENTAIRE", "UNMATCH"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Calcul.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	    private int _cur_label = 1;
	    /** générateur de nom d'étiquettes pour les boucles */
	    private String getNewLabel() { return "Label" +(_cur_label++); }

	    private TablesSymboles tableSymboles = new TablesSymboles();

	    private String evalexpr (String op) { // On utilise evalexpr pour la priorité (on ne peu pas déroulé les opération)
	        if ( op.equals("*") ){
	            return "MUL\n";
	        } else if ( op.equals("+") ){
	            return "ADD\n";
	        } else if ( op.equals("-") ){
	            return "SUB\n";
	        } else if ( op.equals("/") ){
	            return "DIV\n";
	        } else {
	           System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
	           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
	        }
	    }
	    private String evalop (String op) { //evalop est utilsé pour les opérateur relationnels
	      if ( op.equals("==")){
	        return "EQUAL\n";
	      } else if( op.equals("!=")){
	        return "NEQ\n";
	      } else if( op.equals(">")){
	        return "SUP\n";
	      } else if( op.equals(">=")){
	        return "SUPEQ\n";
	      } else if( op.equals("<")){
	        return "INF\n";
	      } else if (op.equals("<=")){
	        return "INFEQ\n";
	      } else {
	        System.err.println("Opérateur relationnels incorrect : '"+op+"'");
	        throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
	      }
	    }
	    private String evallogique(String op){ // Fonction utilisé pour les expressions logique
	      if(op.equals("!")){
	        return "PUSHI 1\n" + "NEQ\n"; //Pour inverser on regarde si c'est différent de 1
	      }
	      else if(op.equals("&&")){
	        return "ADD\n" + "PUSHI 2\n" + "EQUAL\n";
	      }
	      else if(op.equals("||")){
	        return "ADD\n" + "PUSHI 1\n" + "SUPEQ\n";
	      }
	      else {
	        System.err.println("Opérateur relationnels incorrect : '"+op+"'");
	        throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
	      }
	    }

	    private String evalPush(String id,String type){
	      AdresseType at = tableSymboles.getAdresseType(id);  //Adresses positives : variables globales,
	      System.out.println(type);
	      if(type.equals("double")){
	        return (at.adresse >= 0) ? ("PUSHG " + at.adresse + "\nPUSHG " + (at.adresse+1) + "\n") : ("PUSHL " + at.adresse + "\n PUSHL " + (at.adresse+1) + "\n");
	      }
	      else{
	        return (at.adresse >= 0) ? "PUSHG " + at.adresse + "\n" : "PUSHL " + at.adresse + "\n";  //Adresses negatives : variables locales
	      }
	    }

	    //Renvoie STOREG ou STOREL + l'adresse suivant le type de l'id
	    private String evalStore(String id){
	      AdresseType at = tableSymboles.getAdresseType(id);        //Adresses positives : variables globales,
	      return (at.adresse >= 0) ? "STOREG " : "STOREL "; //Adresses negatives : variables locales
	    }

	    private String pushIOrF(String type){
	      String res = "";
	      if(!type.equals("double")){
	        res = "PUSHI ";
	      }else{
	        res = "PUSHF ";
	      }
	      return res;
	    }

	public CalculParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CalculParser.EOF, 0); }
		public CalculContext calcul() {
			return getRuleContext(CalculContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(36);
				calcul();
				}
				break;
			}
			setState(39);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FonctionContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public Token TYPE;
		public BlocContext bloc;
		public TerminalNode IDENTIFIANT() { return getToken(CalculParser.IDENTIFIANT, 0); }
		public TerminalNode TYPE() { return getToken(CalculParser.TYPE, 0); }
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterFonction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitFonction(this);
		}
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_fonction);

		    tableSymboles.newTableLocale();
		      
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__0);
			setState(42);
			((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(43);
			match(T__1);
			setState(44);
			((FonctionContext)_localctx).TYPE = match(TYPE);

			            ((FonctionContext)_localctx).code =  "LABEL " + (((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null) + "\n";
			            tableSymboles.newFunction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null),(((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
			            tableSymboles.putVar("return",(((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
				      
			setState(46);
			match(T__2);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(47);
				params();
				}
			}

			setState(50);
			match(T__3);
			setState(51);
			((FonctionContext)_localctx).bloc = bloc();

			           _localctx.code += ((FonctionContext)_localctx).bloc.code;
			        
			}
			_ctx.stop = _input.LT(-1);

			    tableSymboles.dropTableLocale();
			   
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public Token at;
		public Token ai;
		public Token bt;
		public Token bi;
		public List<TerminalNode> TYPE() { return getTokens(CalculParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CalculParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIANT() { return getTokens(CalculParser.IDENTIFIANT); }
		public TerminalNode IDENTIFIANT(int i) {
			return getToken(CalculParser.IDENTIFIANT, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			((ParamsContext)_localctx).at = match(TYPE);
			setState(55);
			((ParamsContext)_localctx).ai = match(IDENTIFIANT);

			          tableSymboles.putVar((((ParamsContext)_localctx).ai!=null?((ParamsContext)_localctx).ai.getText():null),(((ParamsContext)_localctx).at!=null?((ParamsContext)_localctx).at.getText():null));
			            // code java gérant une variable locale (arg0)
			        
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(57);
				match(T__4);
				setState(58);
				((ParamsContext)_localctx).bt = match(TYPE);
				setState(59);
				((ParamsContext)_localctx).bi = match(IDENTIFIANT);

				              tableSymboles.putVar((((ParamsContext)_localctx).bi!=null?((ParamsContext)_localctx).bi.getText():null),(((ParamsContext)_localctx).bt!=null?((ParamsContext)_localctx).bt.getText():null));
				                // code java gérant une variable locale (argi)
				            
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public String code;
		public int size;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_args);
		 ((ArgsContext)_localctx).code =  new String(); ((ArgsContext)_localctx).size =  0; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << ENTIER) | (1L << DOUBLE) | (1L << IDENTIFIANT))) != 0)) {
				{
				setState(66);
				((ArgsContext)_localctx).e1 = expression(0);

				      _localctx.size++;
				      _localctx.code += ((ArgsContext)_localctx).e1.code;
				        // code java pour première expression pour arg
				    
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(68);
					match(T__4);
					setState(69);
					((ArgsContext)_localctx).e2 = expression(0);

					      _localctx.size++;
					      _localctx.code += ((ArgsContext)_localctx).e2.code;
					        // code java pour expression suivante pour arg
					    
					}
					}
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetourneContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public TerminalNode RETURN() { return getToken(CalculParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RetourneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retourne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterRetourne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitRetourne(this);
		}
	}

	public final RetourneContext retourne() throws RecognitionException {
		RetourneContext _localctx = new RetourneContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_retourne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(RETURN);
			setState(80);
			((RetourneContext)_localctx).expression = expression(0);

			      AdresseType at = tableSymboles.getAdresseType("return");
			      ((RetourneContext)_localctx).code =  ((RetourneContext)_localctx).expression.code + "STOREL " + at.adresse + "\n" + "RETURN\n";
			  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public FonctionContext fonction;
		public InstructionContext instruction;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculParser.NEWLINE, i);
		}
		public List<FonctionContext> fonction() {
			return getRuleContexts(FonctionContext.class);
		}
		public FonctionContext fonction(int i) {
			return getRuleContext(FonctionContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitCalcul(this);
		}
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(83);
				((CalculContext)_localctx).decl = decl();
				 ((CalculContext)_localctx).code =  ((CalculContext)_localctx).decl.code; 
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			_localctx.code += "JUMP " + "Main\n";
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(92);
					match(NEWLINE);
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(98);
				((CalculContext)_localctx).fonction = fonction();
				 _localctx.code += ((CalculContext)_localctx).fonction.code; 
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(106);
					match(NEWLINE);
					}
					} 
				}
				setState(111);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			_localctx.code += "LABEL " + "Main\n";
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__7) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << RETURN) | (1L << NEWLINE) | (1L << ENTIER) | (1L << DOUBLE) | (1L << IDENTIFIANT) | (1L << NOT))) != 0)) {
				{
				{
				setState(113);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "HALT\n"; 
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public Boucle_whileContext boucle_while;
		public BranchementContext branchement;
		public RepetitionContext repetition;
		public ConditionContext condition;
		public AssignationContext assignation;
		public ReadContext read;
		public WriteContext write;
		public BlocContext bloc;
		public RetourneContext retourne;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public Boucle_whileContext boucle_while() {
			return getRuleContext(Boucle_whileContext.class,0);
		}
		public BranchementContext branchement() {
			return getRuleContext(BranchementContext.class,0);
		}
		public RepetitionContext repetition() {
			return getRuleContext(RepetitionContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public AssignationContext assignation() {
			return getRuleContext(AssignationContext.class,0);
		}
		public ReadContext read() {
			return getRuleContext(ReadContext.class,0);
		}
		public WriteContext write() {
			return getRuleContext(WriteContext.class,0);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public RetourneContext retourne() {
			return getRuleContext(RetourneContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_instruction);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				((InstructionContext)_localctx).expression = expression(0);
				setState(124);
				finInstruction();

				          ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				((InstructionContext)_localctx).boucle_while = boucle_while();

				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).boucle_while.code;
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				((InstructionContext)_localctx).branchement = branchement();

				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).branchement.code;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				((InstructionContext)_localctx).repetition = repetition();

				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).repetition.code;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(136);
				((InstructionContext)_localctx).condition = condition(0);
				setState(137);
				finInstruction();

				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).condition.code;
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(140);
				((InstructionContext)_localctx).assignation = assignation();
				setState(141);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(144);
				((InstructionContext)_localctx).read = read();
				setState(145);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).read.code;
				        
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(148);
				((InstructionContext)_localctx).write = write();
				setState(149);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).write.code;
				        
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(152);
				((InstructionContext)_localctx).bloc = bloc();
				setState(153);
				finInstruction();

				          ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).bloc.code;
				        
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(156);
				((InstructionContext)_localctx).retourne = retourne();
				setState(157);
				finInstruction();

				          ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).retourne.code;
				        
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(160);
				finInstruction();

				      ((InstructionContext)_localctx).code = "";
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<TerminalNode> NEWLINE() { return getTokens(CalculParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculParser.NEWLINE, i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BlocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterBloc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitBloc(this);
		}
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bloc);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((BlocContext)_localctx).code =  "";
			setState(166);
			match(T__5);
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(167);
				match(NEWLINE);
				}
				break;
			}
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__7) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << RETURN) | (1L << NEWLINE) | (1L << ENTIER) | (1L << DOUBLE) | (1L << IDENTIFIANT) | (1L << NOT))) != 0)) {
				{
				{
				setState(170);
				((BlocContext)_localctx).instruction = instruction();
				_localctx.code += ((BlocContext)_localctx).instruction.code;
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
			match(T__6);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(179);
					match(NEWLINE);
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public String type;
		public ExpressionContext a;
		public Token ENTIER;
		public Token DOUBLE;
		public Token IDENTIFIANT;
		public ArgsContext args;
		public Token op;
		public ExpressionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(CalculParser.ENTIER, 0); }
		public TerminalNode DOUBLE() { return getToken(CalculParser.DOUBLE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculParser.IDENTIFIANT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(186);
				match(T__7);
				setState(187);
				((ExpressionContext)_localctx).a = expression(8);

				      ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + "PUSHI -1\n" + "MUL\n";
				      ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).a.type;
				    
				}
				break;
			case 2:
				{
				setState(190);
				match(T__2);
				setState(191);
				((ExpressionContext)_localctx).a = expression(0);
				setState(192);
				match(T__3);

				      ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				      ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).a.type;
				    
				}
				break;
			case 3:
				{
				setState(195);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);

				      ((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).ENTIER!=null?Integer.valueOf(((ExpressionContext)_localctx).ENTIER.getText()):0) + "\n";
				      ((ExpressionContext)_localctx).type =  "int";
				            
				}
				break;
			case 4:
				{
				setState(197);
				((ExpressionContext)_localctx).DOUBLE = match(DOUBLE);

				      ((ExpressionContext)_localctx).code =  "PUSHF " + (((ExpressionContext)_localctx).DOUBLE!=null?((ExpressionContext)_localctx).DOUBLE.getText():null) + "\n";
				      ((ExpressionContext)_localctx).type =  "double";
				    
				}
				break;
			case 5:
				{
				setState(199);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				        AdresseType at = tableSymboles.getAdresseType((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				        ((ExpressionContext)_localctx).code =  evalPush((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null),at.type);  //Gérer mes variable LOCAL
				        ((ExpressionContext)_localctx).type =  at.type;
				      
				}
				break;
			case 6:
				{
				setState(201);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(202);
				match(T__2);
				setState(203);
				((ExpressionContext)_localctx).args = args();
				setState(204);
				match(T__3);

				            //AdresseType at = tableSymboles.getAdresseType((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				            //((ExpressionContext)_localctx).type =  at.type;
				            ((ExpressionContext)_localctx).code =  "PUSHI 0\n" + ((ExpressionContext)_localctx).args.code + "CALL " + (((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null) + "\n";
				            for(int i = 0; i < ((ExpressionContext)_localctx).args.size; i++){
				              _localctx.code += "POP \n";
				            }
				        
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(221);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(219);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(209);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(210);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__9) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(211);
						((ExpressionContext)_localctx).b = expression(8);

						                ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + ((ExpressionContext)_localctx).b.code + evalexpr((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).a.type;
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(214);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(215);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__7 || _la==T__10) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(216);
						((ExpressionContext)_localctx).b = expression(7);

						                ((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + ((ExpressionContext)_localctx).b.code + evalexpr((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                ((ExpressionContext)_localctx).type =  ((ExpressionContext)_localctx).a.type;
						              
						}
						break;
					}
					} 
				}
				setState(223);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public Token TYPE;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIANT() { return getToken(CalculParser.IDENTIFIANT, 0); }
		public TerminalNode TYPE() { return getToken(CalculParser.TYPE, 0); }
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_decl);
		try {
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				match(T__11);
				setState(225);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(226);
				match(T__1);
				setState(227);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(228);
				finInstruction();

				            tableSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),(((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				            if(!(((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("double")){
				              ((DeclContext)_localctx).code =  "PUSHI 0\n";
				            }else{
				              ((DeclContext)_localctx).code =  "PUSHF 0.0\n";
				            }
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				match(T__11);
				setState(232);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(233);
				match(T__1);
				setState(234);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(235);
				match(T__12);
				setState(236);
				((DeclContext)_localctx).expression = expression(0);
				setState(237);
				finInstruction();

				            tableSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),(((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				            //AdresseType at = tableSymboles.getAdresseType((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null));
				            ((DeclContext)_localctx).code =  ((DeclContext)_localctx).expression.code;//$code = "PUSHI " + $ENTIER.text + "\n";
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignationContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExpressionContext expression;
		public TerminalNode IDENTIFIANT() { return getToken(CalculParser.IDENTIFIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignation);
		try {
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(243);
				match(T__12);
				setState(244);
				((AssignationContext)_localctx).expression = expression(0);

				            AdresseType at = tableSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code + evalStore((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null)) + at.adresse + "\n";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(248);
				match(T__13);
				setState(249);
				((AssignationContext)_localctx).expression = expression(0);

				          AdresseType at = tableSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				          ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code + evalPush((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null),((AssignationContext)_localctx).expression.type) + "ADD\n" + evalStore((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null)) + at.adresse + "\n";
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public TerminalNode IDENTIFIANT() { return getToken(CalculParser.IDENTIFIANT, 0); }
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitRead(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(T__14);
			setState(255);
			((ReadContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(256);
			match(T__3);

			        AdresseType at = tableSymboles.getAdresseType((((ReadContext)_localctx).IDENTIFIANT!=null?((ReadContext)_localctx).IDENTIFIANT.getText():null));
			        if(at.type.equals("int")){
			          ((ReadContext)_localctx).code =  "READ\n" + evalStore((((ReadContext)_localctx).IDENTIFIANT!=null?((ReadContext)_localctx).IDENTIFIANT.getText():null)) + at.adresse + "\n";
			        }
			        else if(at.type.equals("double")){
			          ((ReadContext)_localctx).code =  "READF\n" + evalStore((((ReadContext)_localctx).IDENTIFIANT!=null?((ReadContext)_localctx).IDENTIFIANT.getText():null)) + at.adresse + "\n";
			        }
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WriteContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitWrite(this);
		}
	}

	public final WriteContext write() throws RecognitionException {
		WriteContext _localctx = new WriteContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_write);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(T__15);
			setState(260);
			((WriteContext)_localctx).expression = expression(0);
			setState(261);
			match(T__3);

			        if(((WriteContext)_localctx).expression.type.equals("int")){
			          ((WriteContext)_localctx).code =  ((WriteContext)_localctx).expression.code + "WRITE\n" + "POP\n";
			        }
			        else if(((WriteContext)_localctx).expression.type.equals("double")){
			          ((WriteContext)_localctx).code =  ((WriteContext)_localctx).expression.code + "WRITEF\n" + "POP\n" + "POP\n";
			        }
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boucle_whileContext extends ParserRuleContext {
		public String code;
		public ConditionContext condition;
		public InstructionContext instruction;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public Boucle_whileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boucle_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterBoucle_while(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitBoucle_while(this);
		}
	}

	public final Boucle_whileContext boucle_while() throws RecognitionException {
		Boucle_whileContext _localctx = new Boucle_whileContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_boucle_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(T__16);
			setState(265);
			match(T__2);
			setState(266);
			((Boucle_whileContext)_localctx).condition = condition(0);
			setState(267);
			match(T__3);
			setState(268);
			((Boucle_whileContext)_localctx).instruction = instruction();

			        String debut = getNewLabel();
			        String fin = getNewLabel();
			        ((Boucle_whileContext)_localctx).code =  "LABEL " + debut + "\n" +
			          ((Boucle_whileContext)_localctx).condition.code +
			          "JUMPF " + fin + "\n" +
			          ((Boucle_whileContext)_localctx).instruction.code +
			          "JUMP " + debut + "\n" +
			          "LABEL " + fin + "\n";
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepetitionContext extends ParserRuleContext {
		public String code;
		public AssignationContext i;
		public ConditionContext condition;
		public AssignationContext inc;
		public InstructionContext instruction;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public List<AssignationContext> assignation() {
			return getRuleContexts(AssignationContext.class);
		}
		public AssignationContext assignation(int i) {
			return getRuleContext(AssignationContext.class,i);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public RepetitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repetition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterRepetition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitRepetition(this);
		}
	}

	public final RepetitionContext repetition() throws RecognitionException {
		RepetitionContext _localctx = new RepetitionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_repetition);
		int _la;
		try {
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				match(T__17);
				setState(272);
				match(T__2);
				setState(273);
				((RepetitionContext)_localctx).i = assignation();
				setState(274);
				match(T__18);
				setState(275);
				((RepetitionContext)_localctx).condition = condition(0);
				setState(276);
				match(T__18);
				setState(277);
				((RepetitionContext)_localctx).inc = assignation();
				setState(278);
				match(T__3);
				setState(279);
				((RepetitionContext)_localctx).instruction = instruction();

				      String debut = getNewLabel();
				      String fin = getNewLabel();
				      ((RepetitionContext)_localctx).code =  ((RepetitionContext)_localctx).i.code +
				      "LABEL " + debut + "\n" +
				      ((RepetitionContext)_localctx).condition.code +
				      "JUMPF " + fin + "\n" +
				      ((RepetitionContext)_localctx).instruction.code +
				      ((RepetitionContext)_localctx).inc.code +
				      "JUMP " + debut + "\n" +
				      "LABEL " + fin + "\n"
				      ;
				    
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				match(T__19);
				setState(283);
				((RepetitionContext)_localctx).instruction = instruction();
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__18 || _la==NEWLINE) {
					{
					setState(284);
					finInstruction();
					}
				}

				setState(287);
				match(T__20);
				setState(288);
				match(T__2);
				setState(289);
				((RepetitionContext)_localctx).condition = condition(0);
				setState(290);
				match(T__3);

				      String debut = getNewLabel();
				      String fin = getNewLabel();
				      ((RepetitionContext)_localctx).code =  "LABEL " + debut + "\n" +
				      ((RepetitionContext)_localctx).condition.code + evallogique("!") +
				      "JUMPF " + fin + "\n" +
				      ((RepetitionContext)_localctx).instruction.code +
				      "JUMP " + debut + "\n" +
				      "LABEL " + fin + "\n";
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public String code;
		public ConditionContext a;
		public Token NOT;
		public ConditionContext condition;
		public ExpressionContext c;
		public Token op;
		public ExpressionContext d;
		public Token AND;
		public ConditionContext b;
		public Token OR;
		public TerminalNode NOT() { return getToken(CalculParser.NOT, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OPERATEUR() { return getToken(CalculParser.OPERATEUR, 0); }
		public TerminalNode AND() { return getToken(CalculParser.AND, 0); }
		public TerminalNode OR() { return getToken(CalculParser.OR, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(296);
				((ConditionContext)_localctx).NOT = match(NOT);
				setState(297);
				((ConditionContext)_localctx).condition = condition(6);
				((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).condition.code + evallogique((((ConditionContext)_localctx).NOT!=null?((ConditionContext)_localctx).NOT.getText():null));
				}
				break;
			case T__2:
			case T__7:
			case ENTIER:
			case DOUBLE:
			case IDENTIFIANT:
				{
				setState(300);
				((ConditionContext)_localctx).c = expression(0);
				setState(301);
				((ConditionContext)_localctx).op = match(OPERATEUR);
				setState(302);
				((ConditionContext)_localctx).d = expression(0);
				((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).c.code + ((ConditionContext)_localctx).d.code + evalop((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null));
				}
				break;
			case T__21:
				{
				setState(305);
				match(T__21);
				 ((ConditionContext)_localctx).code =  "PUSHI 1\n";
				}
				break;
			case T__22:
				{
				setState(307);
				match(T__22);
				((ConditionContext)_localctx).code =  "PUSHI 0\n";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(323);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(321);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(311);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(312);
						((ConditionContext)_localctx).AND = match(AND);
						setState(313);
						((ConditionContext)_localctx).b = ((ConditionContext)_localctx).condition = condition(6);
						((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + evallogique((((ConditionContext)_localctx).AND!=null?((ConditionContext)_localctx).AND.getText():null));
						}
						break;
					case 2:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(316);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(317);
						((ConditionContext)_localctx).OR = match(OR);
						setState(318);
						((ConditionContext)_localctx).b = ((ConditionContext)_localctx).condition = condition(5);
						((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + evallogique((((ConditionContext)_localctx).OR!=null?((ConditionContext)_localctx).OR.getText():null));
						}
						break;
					}
					} 
				}
				setState(325);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BranchementContext extends ParserRuleContext {
		public String code;
		public ConditionContext condition;
		public InstructionContext a;
		public InstructionContext b;
		public InstructionContext instruction;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public BranchementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterBranchement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitBranchement(this);
		}
	}

	public final BranchementContext branchement() throws RecognitionException {
		BranchementContext _localctx = new BranchementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_branchement);
		int _la;
		try {
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(326);
				match(T__23);
				setState(327);
				match(T__2);
				setState(328);
				((BranchementContext)_localctx).condition = condition(0);
				setState(329);
				match(T__3);
				setState(330);
				((BranchementContext)_localctx).a = instruction();
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__18 || _la==NEWLINE) {
					{
					setState(331);
					finInstruction();
					}
				}

				setState(334);
				match(T__24);
				setState(335);
				((BranchementContext)_localctx).b = instruction();

				      String finIf = getNewLabel();
				      String finElse = getNewLabel();

				      ((BranchementContext)_localctx).code =  ((BranchementContext)_localctx).condition.code +
				      "JUMPF " + finIf + "\n" +
				      ((BranchementContext)_localctx).a.code +
				      "JUMP " + finElse + "\n"+
				      "LABEL " + finIf + "\n" +
				      ((BranchementContext)_localctx).b.code +
				      "LABEL " + finElse + "\n";
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				match(T__23);
				setState(339);
				match(T__2);
				setState(340);
				((BranchementContext)_localctx).condition = condition(0);
				setState(341);
				match(T__3);
				setState(342);
				((BranchementContext)_localctx).instruction = instruction();

				        String fin = getNewLabel();
				        ((BranchementContext)_localctx).code =  ((BranchementContext)_localctx).condition.code +
				          "JUMPF " + fin + "\n" +
				          ((BranchementContext)_localctx).instruction.code +
				          "LABEL " + fin + "\n";
				      
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(CalculParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculListener ) ((CalculListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(348); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(347);
					_la = _input.LA(1);
					if ( !(_la==T__18 || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(350); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 15:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u0163\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\5\2(\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\63\n\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4@\n\4\f\4\16\4C\13\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\7\5K\n\5\f\5\16\5N\13\5\5\5P\n\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\7\3\7\7\7`\n\7\f\7\16\7c\13"+
		"\7\3\7\3\7\3\7\7\7h\n\7\f\7\16\7k\13\7\3\7\7\7n\n\7\f\7\16\7q\13\7\3\7"+
		"\3\7\3\7\3\7\7\7w\n\7\f\7\16\7z\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a6"+
		"\n\b\3\t\3\t\3\t\5\t\u00ab\n\t\3\t\3\t\3\t\7\t\u00b0\n\t\f\t\16\t\u00b3"+
		"\13\t\3\t\3\t\7\t\u00b7\n\t\f\t\16\t\u00ba\13\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u00d2\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00de\n\n\f\n\16"+
		"\n\u00e1\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13\u00f3\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u00ff\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0120\n\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u0128\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u0138\n\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\7\21\u0144\n\21\f\21\16\21\u0147\13\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u014f\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u015c\n\22\3\23\6\23\u015f\n\23\r\23\16\23\u0160"+
		"\3\23\2\4\22 \24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\5\3\2\13"+
		"\f\4\2\n\n\r\r\4\2\25\25\36\36\2\u017a\2\'\3\2\2\2\4+\3\2\2\2\68\3\2\2"+
		"\2\bO\3\2\2\2\nQ\3\2\2\2\fZ\3\2\2\2\16\u00a5\3\2\2\2\20\u00a7\3\2\2\2"+
		"\22\u00d1\3\2\2\2\24\u00f2\3\2\2\2\26\u00fe\3\2\2\2\30\u0100\3\2\2\2\32"+
		"\u0105\3\2\2\2\34\u010a\3\2\2\2\36\u0127\3\2\2\2 \u0137\3\2\2\2\"\u015b"+
		"\3\2\2\2$\u015e\3\2\2\2&(\5\f\7\2\'&\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\7"+
		"\2\2\3*\3\3\2\2\2+,\7\3\2\2,-\7\"\2\2-.\7\4\2\2./\7\35\2\2/\60\b\3\1\2"+
		"\60\62\7\5\2\2\61\63\5\6\4\2\62\61\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2"+
		"\64\65\7\6\2\2\65\66\5\20\t\2\66\67\b\3\1\2\67\5\3\2\2\289\7\35\2\29:"+
		"\7\"\2\2:A\b\4\1\2;<\7\7\2\2<=\7\35\2\2=>\7\"\2\2>@\b\4\1\2?;\3\2\2\2"+
		"@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\7\3\2\2\2CA\3\2\2\2DE\5\22\n\2EL\b\5\1"+
		"\2FG\7\7\2\2GH\5\22\n\2HI\b\5\1\2IK\3\2\2\2JF\3\2\2\2KN\3\2\2\2LJ\3\2"+
		"\2\2LM\3\2\2\2MP\3\2\2\2NL\3\2\2\2OD\3\2\2\2OP\3\2\2\2P\t\3\2\2\2QR\7"+
		"\34\2\2RS\5\22\n\2ST\b\6\1\2T\13\3\2\2\2UV\5\24\13\2VW\b\7\1\2WY\3\2\2"+
		"\2XU\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]a\b\7"+
		"\1\2^`\7\36\2\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bi\3\2\2\2ca\3"+
		"\2\2\2de\5\4\3\2ef\b\7\1\2fh\3\2\2\2gd\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3"+
		"\2\2\2jo\3\2\2\2ki\3\2\2\2ln\7\36\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op"+
		"\3\2\2\2pr\3\2\2\2qo\3\2\2\2rx\b\7\1\2st\5\16\b\2tu\b\7\1\2uw\3\2\2\2"+
		"vs\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\b\7\1\2"+
		"|\r\3\2\2\2}~\5\22\n\2~\177\5$\23\2\177\u0080\b\b\1\2\u0080\u00a6\3\2"+
		"\2\2\u0081\u0082\5\34\17\2\u0082\u0083\b\b\1\2\u0083\u00a6\3\2\2\2\u0084"+
		"\u0085\5\"\22\2\u0085\u0086\b\b\1\2\u0086\u00a6\3\2\2\2\u0087\u0088\5"+
		"\36\20\2\u0088\u0089\b\b\1\2\u0089\u00a6\3\2\2\2\u008a\u008b\5 \21\2\u008b"+
		"\u008c\5$\23\2\u008c\u008d\b\b\1\2\u008d\u00a6\3\2\2\2\u008e\u008f\5\26"+
		"\f\2\u008f\u0090\5$\23\2\u0090\u0091\b\b\1\2\u0091\u00a6\3\2\2\2\u0092"+
		"\u0093\5\30\r\2\u0093\u0094\5$\23\2\u0094\u0095\b\b\1\2\u0095\u00a6\3"+
		"\2\2\2\u0096\u0097\5\32\16\2\u0097\u0098\5$\23\2\u0098\u0099\b\b\1\2\u0099"+
		"\u00a6\3\2\2\2\u009a\u009b\5\20\t\2\u009b\u009c\5$\23\2\u009c\u009d\b"+
		"\b\1\2\u009d\u00a6\3\2\2\2\u009e\u009f\5\n\6\2\u009f\u00a0\5$\23\2\u00a0"+
		"\u00a1\b\b\1\2\u00a1\u00a6\3\2\2\2\u00a2\u00a3\5$\23\2\u00a3\u00a4\b\b"+
		"\1\2\u00a4\u00a6\3\2\2\2\u00a5}\3\2\2\2\u00a5\u0081\3\2\2\2\u00a5\u0084"+
		"\3\2\2\2\u00a5\u0087\3\2\2\2\u00a5\u008a\3\2\2\2\u00a5\u008e\3\2\2\2\u00a5"+
		"\u0092\3\2\2\2\u00a5\u0096\3\2\2\2\u00a5\u009a\3\2\2\2\u00a5\u009e\3\2"+
		"\2\2\u00a5\u00a2\3\2\2\2\u00a6\17\3\2\2\2\u00a7\u00a8\b\t\1\2\u00a8\u00aa"+
		"\7\b\2\2\u00a9\u00ab\7\36\2\2\u00aa\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2"+
		"\u00ab\u00b1\3\2\2\2\u00ac\u00ad\5\16\b\2\u00ad\u00ae\b\t\1\2\u00ae\u00b0"+
		"\3\2\2\2\u00af\u00ac\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b8\7\t"+
		"\2\2\u00b5\u00b7\7\36\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\21\3\2\2\2\u00ba\u00b8\3\2\2"+
		"\2\u00bb\u00bc\b\n\1\2\u00bc\u00bd\7\n\2\2\u00bd\u00be\5\22\n\n\u00be"+
		"\u00bf\b\n\1\2\u00bf\u00d2\3\2\2\2\u00c0\u00c1\7\5\2\2\u00c1\u00c2\5\22"+
		"\n\2\u00c2\u00c3\7\6\2\2\u00c3\u00c4\b\n\1\2\u00c4\u00d2\3\2\2\2\u00c5"+
		"\u00c6\7 \2\2\u00c6\u00d2\b\n\1\2\u00c7\u00c8\7!\2\2\u00c8\u00d2\b\n\1"+
		"\2\u00c9\u00ca\7\"\2\2\u00ca\u00d2\b\n\1\2\u00cb\u00cc\7\"\2\2\u00cc\u00cd"+
		"\7\5\2\2\u00cd\u00ce\5\b\5\2\u00ce\u00cf\7\6\2\2\u00cf\u00d0\b\n\1\2\u00d0"+
		"\u00d2\3\2\2\2\u00d1\u00bb\3\2\2\2\u00d1\u00c0\3\2\2\2\u00d1\u00c5\3\2"+
		"\2\2\u00d1\u00c7\3\2\2\2\u00d1\u00c9\3\2\2\2\u00d1\u00cb\3\2\2\2\u00d2"+
		"\u00df\3\2\2\2\u00d3\u00d4\f\t\2\2\u00d4\u00d5\t\2\2\2\u00d5\u00d6\5\22"+
		"\n\n\u00d6\u00d7\b\n\1\2\u00d7\u00de\3\2\2\2\u00d8\u00d9\f\b\2\2\u00d9"+
		"\u00da\t\3\2\2\u00da\u00db\5\22\n\t\u00db\u00dc\b\n\1\2\u00dc\u00de\3"+
		"\2\2\2\u00dd\u00d3\3\2\2\2\u00dd\u00d8\3\2\2\2\u00de\u00e1\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\23\3\2\2\2\u00e1\u00df\3\2\2"+
		"\2\u00e2\u00e3\7\16\2\2\u00e3\u00e4\7\"\2\2\u00e4\u00e5\7\4\2\2\u00e5"+
		"\u00e6\7\35\2\2\u00e6\u00e7\5$\23\2\u00e7\u00e8\b\13\1\2\u00e8\u00f3\3"+
		"\2\2\2\u00e9\u00ea\7\16\2\2\u00ea\u00eb\7\"\2\2\u00eb\u00ec\7\4\2\2\u00ec"+
		"\u00ed\7\35\2\2\u00ed\u00ee\7\17\2\2\u00ee\u00ef\5\22\n\2\u00ef\u00f0"+
		"\5$\23\2\u00f0\u00f1\b\13\1\2\u00f1\u00f3\3\2\2\2\u00f2\u00e2\3\2\2\2"+
		"\u00f2\u00e9\3\2\2\2\u00f3\25\3\2\2\2\u00f4\u00f5\7\"\2\2\u00f5\u00f6"+
		"\7\17\2\2\u00f6\u00f7\5\22\n\2\u00f7\u00f8\b\f\1\2\u00f8\u00ff\3\2\2\2"+
		"\u00f9\u00fa\7\"\2\2\u00fa\u00fb\7\20\2\2\u00fb\u00fc\5\22\n\2\u00fc\u00fd"+
		"\b\f\1\2\u00fd\u00ff\3\2\2\2\u00fe\u00f4\3\2\2\2\u00fe\u00f9\3\2\2\2\u00ff"+
		"\27\3\2\2\2\u0100\u0101\7\21\2\2\u0101\u0102\7\"\2\2\u0102\u0103\7\6\2"+
		"\2\u0103\u0104\b\r\1\2\u0104\31\3\2\2\2\u0105\u0106\7\22\2\2\u0106\u0107"+
		"\5\22\n\2\u0107\u0108\7\6\2\2\u0108\u0109\b\16\1\2\u0109\33\3\2\2\2\u010a"+
		"\u010b\7\23\2\2\u010b\u010c\7\5\2\2\u010c\u010d\5 \21\2\u010d\u010e\7"+
		"\6\2\2\u010e\u010f\5\16\b\2\u010f\u0110\b\17\1\2\u0110\35\3\2\2\2\u0111"+
		"\u0112\7\24\2\2\u0112\u0113\7\5\2\2\u0113\u0114\5\26\f\2\u0114\u0115\7"+
		"\25\2\2\u0115\u0116\5 \21\2\u0116\u0117\7\25\2\2\u0117\u0118\5\26\f\2"+
		"\u0118\u0119\7\6\2\2\u0119\u011a\5\16\b\2\u011a\u011b\b\20\1\2\u011b\u0128"+
		"\3\2\2\2\u011c\u011d\7\26\2\2\u011d\u011f\5\16\b\2\u011e\u0120\5$\23\2"+
		"\u011f\u011e\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122"+
		"\7\27\2\2\u0122\u0123\7\5\2\2\u0123\u0124\5 \21\2\u0124\u0125\7\6\2\2"+
		"\u0125\u0126\b\20\1\2\u0126\u0128\3\2\2\2\u0127\u0111\3\2\2\2\u0127\u011c"+
		"\3\2\2\2\u0128\37\3\2\2\2\u0129\u012a\b\21\1\2\u012a\u012b\7&\2\2\u012b"+
		"\u012c\5 \21\b\u012c\u012d\b\21\1\2\u012d\u0138\3\2\2\2\u012e\u012f\5"+
		"\22\n\2\u012f\u0130\7#\2\2\u0130\u0131\5\22\n\2\u0131\u0132\b\21\1\2\u0132"+
		"\u0138\3\2\2\2\u0133\u0134\7\30\2\2\u0134\u0138\b\21\1\2\u0135\u0136\7"+
		"\31\2\2\u0136\u0138\b\21\1\2\u0137\u0129\3\2\2\2\u0137\u012e\3\2\2\2\u0137"+
		"\u0133\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0145\3\2\2\2\u0139\u013a\f\7"+
		"\2\2\u013a\u013b\7$\2\2\u013b\u013c\5 \21\b\u013c\u013d\b\21\1\2\u013d"+
		"\u0144\3\2\2\2\u013e\u013f\f\6\2\2\u013f\u0140\7%\2\2\u0140\u0141\5 \21"+
		"\7\u0141\u0142\b\21\1\2\u0142\u0144\3\2\2\2\u0143\u0139\3\2\2\2\u0143"+
		"\u013e\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2"+
		"\2\2\u0146!\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0149\7\32\2\2\u0149\u014a"+
		"\7\5\2\2\u014a\u014b\5 \21\2\u014b\u014c\7\6\2\2\u014c\u014e\5\16\b\2"+
		"\u014d\u014f\5$\23\2\u014e\u014d\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150"+
		"\3\2\2\2\u0150\u0151\7\33\2\2\u0151\u0152\5\16\b\2\u0152\u0153\b\22\1"+
		"\2\u0153\u015c\3\2\2\2\u0154\u0155\7\32\2\2\u0155\u0156\7\5\2\2\u0156"+
		"\u0157\5 \21\2\u0157\u0158\7\6\2\2\u0158\u0159\5\16\b\2\u0159\u015a\b"+
		"\22\1\2\u015a\u015c\3\2\2\2\u015b\u0148\3\2\2\2\u015b\u0154\3\2\2\2\u015c"+
		"#\3\2\2\2\u015d\u015f\t\4\2\2\u015e\u015d\3\2\2\2\u015f\u0160\3\2\2\2"+
		"\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161%\3\2\2\2\35\'\62ALOZai"+
		"ox\u00a5\u00aa\u00b1\u00b8\u00d1\u00dd\u00df\u00f2\u00fe\u011f\u0127\u0137"+
		"\u0143\u0145\u014e\u015b\u0160";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}