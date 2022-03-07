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
		T__17=18, T__18=19, T__19=20, TYPE=21, NEWLINE=22, WS=23, ENTIER=24, IDENTIFIANT=25, 
		OPERATEUR=26, AND=27, OR=28, NOT=29, COMMENTAIRE=30, UNMATCH=31;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_instruction = 2, RULE_expression = 3, 
		RULE_decl = 4, RULE_assignation = 5, RULE_read = 6, RULE_write = 7, RULE_boucle_while = 8, 
		RULE_condition = 9, RULE_branchement = 10, RULE_finInstruction = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "calcul", "instruction", "expression", "decl", "assignation", 
			"read", "write", "boucle_while", "condition", "branchement", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'-'", "'*'", "'/'", "'+'", "'('", "')'", "'var'", 
			"':'", "'='", "'+='", "'read('", "'write('", "'while'", "'true'", "'false'", 
			"'if'", "'else'", "';'", null, null, null, null, null, null, "'&&'", 
			"'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "TYPE", "NEWLINE", 
			"WS", "ENTIER", "IDENTIFIANT", "OPERATEUR", "AND", "OR", "NOT", "COMMENTAIRE", 
			"UNMATCH"
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

	    private TableSymboles tableSymboles = new TableSymboles();

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
	    private String evalop (String op) {
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
	    private String evallogique(String op){
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

	public CalculParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public CalculContext calcul() {
			return getRuleContext(CalculContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CalculParser.EOF, 0); }
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
			setState(24);
			calcul();
			setState(25);
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

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
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
		enterRule(_localctx, 2, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(27);
				((CalculContext)_localctx).decl = decl();
				 _localctx.code += ((CalculContext)_localctx).decl.code; 
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(35);
					match(NEWLINE);
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__6) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << NEWLINE) | (1L << ENTIER) | (1L << IDENTIFIANT) | (1L << NOT))) != 0)) {
				{
				{
				setState(41);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(48);
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
		public InstructionContext a;
		public ExpressionContext expression;
		public Boucle_whileContext boucle_while;
		public BranchementContext branchement;
		public ConditionContext condition;
		public AssignationContext assignation;
		public ReadContext read;
		public WriteContext write;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
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
		enterRule(_localctx, 4, RULE_instruction);
		int _la;
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(T__0);
				((InstructionContext)_localctx).code =  "";
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__6) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << NEWLINE) | (1L << ENTIER) | (1L << IDENTIFIANT) | (1L << NOT))) != 0)) {
					{
					{
					setState(53);
					((InstructionContext)_localctx).a = instruction();
					_localctx.code += ((InstructionContext)_localctx).a.code;
					}
					}
					setState(60);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(61);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				((InstructionContext)_localctx).expression = expression(0);
				setState(63);
				finInstruction();

				          ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code;
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				((InstructionContext)_localctx).boucle_while = boucle_while();

				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).boucle_while.code;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				((InstructionContext)_localctx).branchement = branchement();

				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).branchement.code;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				((InstructionContext)_localctx).condition = condition(0);
				setState(73);
				finInstruction();

				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).condition.code;
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				((InstructionContext)_localctx).assignation = assignation();
				setState(77);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(80);
				((InstructionContext)_localctx).read = read();
				setState(81);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).read.code;
				        
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(84);
				((InstructionContext)_localctx).write = write();
				setState(85);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).write.code;
				        
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(88);
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

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public ExpressionContext a;
		public Token ENTIER;
		public Token IDENTIFIANT;
		public Token op;
		public ExpressionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(CalculParser.ENTIER, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculParser.IDENTIFIANT, 0); }
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(94);
				match(T__2);
				setState(95);
				((ExpressionContext)_localctx).a = expression(6);
				((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + "PUSHI -1\n" + "MUL\n";
				}
				break;
			case T__6:
				{
				setState(98);
				match(T__6);
				setState(99);
				((ExpressionContext)_localctx).a = expression(0);
				setState(100);
				match(T__7);
				((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				}
				break;
			case ENTIER:
				{
				setState(103);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).ENTIER!=null?Integer.valueOf(((ExpressionContext)_localctx).ENTIER.getText()):0) + "\n";
				}
				break;
			case IDENTIFIANT:
				{
				setState(105);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				        AdresseType at = tableSymboles.getAdresseType((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				        ((ExpressionContext)_localctx).code =  "PUSHG " + at.adresse + "\n";
				      
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(119);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(109);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(110);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__4) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(111);
						((ExpressionContext)_localctx).b = expression(6);
						((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + ((ExpressionContext)_localctx).b.code + evalexpr((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(114);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(115);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__5) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(116);
						((ExpressionContext)_localctx).b = expression(5);
						((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + ((ExpressionContext)_localctx).b.code + evalexpr((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						}
						break;
					}
					} 
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public Token ENTIER;
		public TerminalNode IDENTIFIANT() { return getToken(CalculParser.IDENTIFIANT, 0); }
		public TerminalNode TYPE() { return getToken(CalculParser.TYPE, 0); }
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public TerminalNode ENTIER() { return getToken(CalculParser.ENTIER, 0); }
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
		enterRule(_localctx, 8, RULE_decl);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(T__8);
				setState(125);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(126);
				match(T__9);
				setState(127);
				match(TYPE);
				setState(128);
				finInstruction();

				            ((DeclContext)_localctx).code =  "PUSHI 0\n";
				            tableSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");//TODO mettre aussi double (changer int)
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(T__8);
				setState(132);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(133);
				match(T__9);
				setState(134);
				match(TYPE);
				setState(135);
				match(T__10);
				setState(136);
				((DeclContext)_localctx).ENTIER = match(ENTIER);
				setState(137);
				finInstruction();

				            ((DeclContext)_localctx).code =  "PUSHI " + (((DeclContext)_localctx).ENTIER!=null?((DeclContext)_localctx).ENTIER.getText():null) + "\n";
				            tableSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");
				        
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
		enterRule(_localctx, 10, RULE_assignation);
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(143);
				match(T__10);
				setState(144);
				((AssignationContext)_localctx).expression = expression(0);

				            AdresseType at = tableSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code + "STOREG " + at.adresse + "\n";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(148);
				match(T__11);
				setState(149);
				((AssignationContext)_localctx).expression = expression(0);

				          AdresseType at = tableSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				          ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code + "PUSHG " + at.adresse + "\n" + "ADD\n" + "STOREG " + at.adresse + "\n";
				        
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
		enterRule(_localctx, 12, RULE_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__12);
			setState(155);
			((ReadContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(156);
			match(T__7);

			        AdresseType at = tableSymboles.getAdresseType((((ReadContext)_localctx).IDENTIFIANT!=null?((ReadContext)_localctx).IDENTIFIANT.getText():null));
			        ((ReadContext)_localctx).code =  "READ\n" + "STOREG " + at.adresse + "\n";
			      
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
		enterRule(_localctx, 14, RULE_write);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__13);
			setState(160);
			((WriteContext)_localctx).expression = expression(0);
			setState(161);
			match(T__7);

			        ((WriteContext)_localctx).code =  ((WriteContext)_localctx).expression.code + "WRITE\n" + "POP\n";
			      
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
		enterRule(_localctx, 16, RULE_boucle_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(T__14);
			setState(165);
			match(T__6);
			setState(166);
			((Boucle_whileContext)_localctx).condition = condition(0);
			setState(167);
			match(T__7);
			setState(168);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(172);
				((ConditionContext)_localctx).NOT = match(NOT);
				setState(173);
				((ConditionContext)_localctx).condition = condition(6);
				((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).condition.code + evallogique((((ConditionContext)_localctx).NOT!=null?((ConditionContext)_localctx).NOT.getText():null));
				}
				break;
			case T__2:
			case T__6:
			case ENTIER:
			case IDENTIFIANT:
				{
				setState(176);
				((ConditionContext)_localctx).c = expression(0);
				setState(177);
				((ConditionContext)_localctx).op = match(OPERATEUR);
				setState(178);
				((ConditionContext)_localctx).d = expression(0);
				((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).c.code + ((ConditionContext)_localctx).d.code + evalop((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null));
				}
				break;
			case T__15:
				{
				setState(181);
				match(T__15);
				 ((ConditionContext)_localctx).code =  "PUSHI 1\n";
				}
				break;
			case T__16:
				{
				setState(183);
				match(T__16);
				((ConditionContext)_localctx).code =  "PUSHI 0\n";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(197);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(187);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(188);
						((ConditionContext)_localctx).AND = match(AND);
						setState(189);
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
						setState(192);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(193);
						((ConditionContext)_localctx).OR = match(OR);
						setState(194);
						((ConditionContext)_localctx).b = ((ConditionContext)_localctx).condition = condition(5);
						((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + evallogique((((ConditionContext)_localctx).OR!=null?((ConditionContext)_localctx).OR.getText():null));
						}
						break;
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		enterRule(_localctx, 20, RULE_branchement);
		int _la;
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				match(T__17);
				setState(203);
				match(T__6);
				setState(204);
				((BranchementContext)_localctx).condition = condition(0);
				setState(205);
				match(T__7);
				setState(206);
				((BranchementContext)_localctx).a = instruction();
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19 || _la==NEWLINE) {
					{
					setState(207);
					finInstruction();
					}
				}

				setState(210);
				match(T__18);
				setState(211);
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
				setState(214);
				match(T__17);
				setState(215);
				match(T__6);
				setState(216);
				((BranchementContext)_localctx).condition = condition(0);
				setState(217);
				match(T__7);
				setState(218);
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
		enterRule(_localctx, 22, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(224); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(223);
					_la = _input.LA(1);
					if ( !(_la==T__19 || _la==NEWLINE) ) {
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
				setState(226); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 9:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00e7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3\3"+
		"\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\3\7\3/\n\3\f\3\16\3\62\13\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\7\4;\n\4\f\4\16\4>\13\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4^\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5n\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\7\5z\n\5\f\5\16\5}\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\5\6\u008f\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u009b\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u00bc\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u00c8\n\13\f\13\16\13\u00cb\13\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00d3\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u00e0\n\f\3\r\6\r\u00e3\n\r\r\r\16\r\u00e4\3\r\2\4\b\24\16\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\2\5\3\2\6\7\4\2\5\5\b\b\4\2\26\26\30\30\2\u00f5\2"+
		"\32\3\2\2\2\4\"\3\2\2\2\6]\3\2\2\2\bm\3\2\2\2\n\u008e\3\2\2\2\f\u009a"+
		"\3\2\2\2\16\u009c\3\2\2\2\20\u00a1\3\2\2\2\22\u00a6\3\2\2\2\24\u00bb\3"+
		"\2\2\2\26\u00df\3\2\2\2\30\u00e2\3\2\2\2\32\33\5\4\3\2\33\34\7\2\2\3\34"+
		"\3\3\2\2\2\35\36\5\n\6\2\36\37\b\3\1\2\37!\3\2\2\2 \35\3\2\2\2!$\3\2\2"+
		"\2\" \3\2\2\2\"#\3\2\2\2#(\3\2\2\2$\"\3\2\2\2%\'\7\30\2\2&%\3\2\2\2\'"+
		"*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\60\3\2\2\2*(\3\2\2\2+,\5\6\4\2,-\b\3\1"+
		"\2-/\3\2\2\2.+\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\63\3\2"+
		"\2\2\62\60\3\2\2\2\63\64\b\3\1\2\64\5\3\2\2\2\65\66\7\3\2\2\66<\b\4\1"+
		"\2\678\5\6\4\289\b\4\1\29;\3\2\2\2:\67\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3"+
		"\2\2\2=?\3\2\2\2><\3\2\2\2?^\7\4\2\2@A\5\b\5\2AB\5\30\r\2BC\b\4\1\2C^"+
		"\3\2\2\2DE\5\22\n\2EF\b\4\1\2F^\3\2\2\2GH\5\26\f\2HI\b\4\1\2I^\3\2\2\2"+
		"JK\5\24\13\2KL\5\30\r\2LM\b\4\1\2M^\3\2\2\2NO\5\f\7\2OP\5\30\r\2PQ\b\4"+
		"\1\2Q^\3\2\2\2RS\5\16\b\2ST\5\30\r\2TU\b\4\1\2U^\3\2\2\2VW\5\20\t\2WX"+
		"\5\30\r\2XY\b\4\1\2Y^\3\2\2\2Z[\5\30\r\2[\\\b\4\1\2\\^\3\2\2\2]\65\3\2"+
		"\2\2]@\3\2\2\2]D\3\2\2\2]G\3\2\2\2]J\3\2\2\2]N\3\2\2\2]R\3\2\2\2]V\3\2"+
		"\2\2]Z\3\2\2\2^\7\3\2\2\2_`\b\5\1\2`a\7\5\2\2ab\5\b\5\bbc\b\5\1\2cn\3"+
		"\2\2\2de\7\t\2\2ef\5\b\5\2fg\7\n\2\2gh\b\5\1\2hn\3\2\2\2ij\7\32\2\2jn"+
		"\b\5\1\2kl\7\33\2\2ln\b\5\1\2m_\3\2\2\2md\3\2\2\2mi\3\2\2\2mk\3\2\2\2"+
		"n{\3\2\2\2op\f\7\2\2pq\t\2\2\2qr\5\b\5\brs\b\5\1\2sz\3\2\2\2tu\f\6\2\2"+
		"uv\t\3\2\2vw\5\b\5\7wx\b\5\1\2xz\3\2\2\2yo\3\2\2\2yt\3\2\2\2z}\3\2\2\2"+
		"{y\3\2\2\2{|\3\2\2\2|\t\3\2\2\2}{\3\2\2\2~\177\7\13\2\2\177\u0080\7\33"+
		"\2\2\u0080\u0081\7\f\2\2\u0081\u0082\7\27\2\2\u0082\u0083\5\30\r\2\u0083"+
		"\u0084\b\6\1\2\u0084\u008f\3\2\2\2\u0085\u0086\7\13\2\2\u0086\u0087\7"+
		"\33\2\2\u0087\u0088\7\f\2\2\u0088\u0089\7\27\2\2\u0089\u008a\7\r\2\2\u008a"+
		"\u008b\7\32\2\2\u008b\u008c\5\30\r\2\u008c\u008d\b\6\1\2\u008d\u008f\3"+
		"\2\2\2\u008e~\3\2\2\2\u008e\u0085\3\2\2\2\u008f\13\3\2\2\2\u0090\u0091"+
		"\7\33\2\2\u0091\u0092\7\r\2\2\u0092\u0093\5\b\5\2\u0093\u0094\b\7\1\2"+
		"\u0094\u009b\3\2\2\2\u0095\u0096\7\33\2\2\u0096\u0097\7\16\2\2\u0097\u0098"+
		"\5\b\5\2\u0098\u0099\b\7\1\2\u0099\u009b\3\2\2\2\u009a\u0090\3\2\2\2\u009a"+
		"\u0095\3\2\2\2\u009b\r\3\2\2\2\u009c\u009d\7\17\2\2\u009d\u009e\7\33\2"+
		"\2\u009e\u009f\7\n\2\2\u009f\u00a0\b\b\1\2\u00a0\17\3\2\2\2\u00a1\u00a2"+
		"\7\20\2\2\u00a2\u00a3\5\b\5\2\u00a3\u00a4\7\n\2\2\u00a4\u00a5\b\t\1\2"+
		"\u00a5\21\3\2\2\2\u00a6\u00a7\7\21\2\2\u00a7\u00a8\7\t\2\2\u00a8\u00a9"+
		"\5\24\13\2\u00a9\u00aa\7\n\2\2\u00aa\u00ab\5\6\4\2\u00ab\u00ac\b\n\1\2"+
		"\u00ac\23\3\2\2\2\u00ad\u00ae\b\13\1\2\u00ae\u00af\7\37\2\2\u00af\u00b0"+
		"\5\24\13\b\u00b0\u00b1\b\13\1\2\u00b1\u00bc\3\2\2\2\u00b2\u00b3\5\b\5"+
		"\2\u00b3\u00b4\7\34\2\2\u00b4\u00b5\5\b\5\2\u00b5\u00b6\b\13\1\2\u00b6"+
		"\u00bc\3\2\2\2\u00b7\u00b8\7\22\2\2\u00b8\u00bc\b\13\1\2\u00b9\u00ba\7"+
		"\23\2\2\u00ba\u00bc\b\13\1\2\u00bb\u00ad\3\2\2\2\u00bb\u00b2\3\2\2\2\u00bb"+
		"\u00b7\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00c9\3\2\2\2\u00bd\u00be\f\7"+
		"\2\2\u00be\u00bf\7\35\2\2\u00bf\u00c0\5\24\13\b\u00c0\u00c1\b\13\1\2\u00c1"+
		"\u00c8\3\2\2\2\u00c2\u00c3\f\6\2\2\u00c3\u00c4\7\36\2\2\u00c4\u00c5\5"+
		"\24\13\7\u00c5\u00c6\b\13\1\2\u00c6\u00c8\3\2\2\2\u00c7\u00bd\3\2\2\2"+
		"\u00c7\u00c2\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\25\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7\24\2\2\u00cd"+
		"\u00ce\7\t\2\2\u00ce\u00cf\5\24\13\2\u00cf\u00d0\7\n\2\2\u00d0\u00d2\5"+
		"\6\4\2\u00d1\u00d3\5\30\r\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d5\7\25\2\2\u00d5\u00d6\5\6\4\2\u00d6\u00d7\b"+
		"\f\1\2\u00d7\u00e0\3\2\2\2\u00d8\u00d9\7\24\2\2\u00d9\u00da\7\t\2\2\u00da"+
		"\u00db\5\24\13\2\u00db\u00dc\7\n\2\2\u00dc\u00dd\5\6\4\2\u00dd\u00de\b"+
		"\f\1\2\u00de\u00e0\3\2\2\2\u00df\u00cc\3\2\2\2\u00df\u00d8\3\2\2\2\u00e0"+
		"\27\3\2\2\2\u00e1\u00e3\t\4\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2\2"+
		"\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\31\3\2\2\2\22\"(\60<"+
		"]my{\u008e\u009a\u00bb\u00c7\u00c9\u00d2\u00df\u00e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}