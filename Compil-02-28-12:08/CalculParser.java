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
		T__17=18, TYPE=19, NEWLINE=20, WS=21, ENTIER=22, IDENTIFIANT=23, OPERATEUR=24, 
		COMMENTAIRE=25, UNMATCH=26;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_instruction = 2, RULE_expression = 3, 
		RULE_decl = 4, RULE_assignation = 5, RULE_read = 6, RULE_write = 7, RULE_boucle_while = 8, 
		RULE_condition = 9, RULE_finInstruction = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "calcul", "instruction", "expression", "decl", "assignation", 
			"read", "write", "boucle_while", "condition", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'-'", "'*'", "'/'", "'+'", "'('", "')'", "'var'", 
			"':'", "'='", "'+='", "'read('", "'write('", "'while'", "'true'", "'false'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "TYPE", "NEWLINE", "WS", "ENTIER", 
			"IDENTIFIANT", "OPERATEUR", "COMMENTAIRE", "UNMATCH"
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
			setState(22);
			calcul();
			setState(23);
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
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(25);
				((CalculContext)_localctx).decl = decl();
				 _localctx.code += ((CalculContext)_localctx).decl.code; 
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(33);
					match(NEWLINE);
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__6) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << NEWLINE) | (1L << ENTIER) | (1L << IDENTIFIANT))) != 0)) {
				{
				{
				setState(39);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(46);
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
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(T__0);
				((InstructionContext)_localctx).code =  "";
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__6) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << NEWLINE) | (1L << ENTIER) | (1L << IDENTIFIANT))) != 0)) {
					{
					{
					setState(51);
					((InstructionContext)_localctx).a = instruction();
					_localctx.code += ((InstructionContext)_localctx).a.code;
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(59);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				((InstructionContext)_localctx).expression = expression(0);
				setState(61);
				finInstruction();

				          ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code;
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				((InstructionContext)_localctx).boucle_while = boucle_while();

				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).boucle_while.code;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				((InstructionContext)_localctx).condition = condition();
				setState(68);
				finInstruction();

				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).condition.code;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				((InstructionContext)_localctx).assignation = assignation();
				setState(72);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
				((InstructionContext)_localctx).read = read();
				setState(76);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).read.code;
				        
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(79);
				((InstructionContext)_localctx).write = write();
				setState(80);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).write.code;
				        
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(83);
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
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(89);
				match(T__2);
				setState(90);
				((ExpressionContext)_localctx).a = expression(6);
				((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + "PUSHI -1\n" + "MUL\n";
				}
				break;
			case T__6:
				{
				setState(93);
				match(T__6);
				setState(94);
				((ExpressionContext)_localctx).a = expression(0);
				setState(95);
				match(T__7);
				((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				}
				break;
			case ENTIER:
				{
				setState(98);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).ENTIER!=null?Integer.valueOf(((ExpressionContext)_localctx).ENTIER.getText()):0) + "\n";
				}
				break;
			case IDENTIFIANT:
				{
				setState(100);
				((ExpressionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				        AdresseType at = tableSymboles.getAdresseType((((ExpressionContext)_localctx).IDENTIFIANT!=null?((ExpressionContext)_localctx).IDENTIFIANT.getText():null));
				        ((ExpressionContext)_localctx).code =  "PUSHG " + at.adresse + "\n";
				      
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(114);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(105);
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
						setState(106);
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
						setState(109);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(110);
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
						setState(111);
						((ExpressionContext)_localctx).b = expression(5);
						((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + ((ExpressionContext)_localctx).b.code + evalexpr((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						}
						break;
					}
					} 
				}
				setState(118);
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
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(T__8);
				setState(120);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(121);
				match(T__9);
				setState(122);
				match(TYPE);
				setState(123);
				finInstruction();

				            ((DeclContext)_localctx).code =  "PUSHI 0\n";
				            tableSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");//TODO mettre aussi double (changer int)
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(T__8);
				setState(127);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(128);
				match(T__9);
				setState(129);
				match(TYPE);
				setState(130);
				match(T__10);
				setState(131);
				((DeclContext)_localctx).ENTIER = match(ENTIER);
				setState(132);
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
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(138);
				match(T__10);
				setState(139);
				((AssignationContext)_localctx).expression = expression(0);

				            AdresseType at = tableSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code + "STOREG " + at.adresse + "\n";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(143);
				match(T__11);
				setState(144);
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
			setState(149);
			match(T__12);
			setState(150);
			((ReadContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(151);
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
		public Token IDENTIFIANT;
		public TerminalNode IDENTIFIANT() { return getToken(CalculParser.IDENTIFIANT, 0); }
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
			setState(154);
			match(T__13);
			setState(155);
			((WriteContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(156);
			match(T__7);

			        AdresseType at = tableSymboles.getAdresseType((((WriteContext)_localctx).IDENTIFIANT!=null?((WriteContext)_localctx).IDENTIFIANT.getText():null));
			        ((WriteContext)_localctx).code =  "PUSHG " + at.adresse + "\n" + "WRITE\n" + "POP\n";
			      
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
			setState(159);
			match(T__14);
			setState(160);
			match(T__6);
			setState(161);
			((Boucle_whileContext)_localctx).condition = condition();
			setState(162);
			match(T__7);
			setState(163);
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
		public ExpressionContext a;
		public Token op;
		public ExpressionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OPERATEUR() { return getToken(CalculParser.OPERATEUR, 0); }
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
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_condition);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__6:
			case ENTIER:
			case IDENTIFIANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				((ConditionContext)_localctx).a = expression(0);
				setState(167);
				((ConditionContext)_localctx).op = match(OPERATEUR);
				setState(168);
				((ConditionContext)_localctx).b = expression(0);
				((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + evalop((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null));
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(T__15);
				 ((ConditionContext)_localctx).code =  "PUSHI 1\n";
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				match(T__16);
				((ConditionContext)_localctx).code =  "PUSHI 0\n";
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
		enterRule(_localctx, 20, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(177);
					_la = _input.LA(1);
					if ( !(_la==T__17 || _la==NEWLINE) ) {
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
				setState(180); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u00b9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\2\3\3\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3\3\7"+
		"\3%\n\3\f\3\16\3(\13\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\7\49\n\4\f\4\16\4<\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\4Y\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5i\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5u\n\5\f\5\16"+
		"\5x\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6\u008a\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0096\n\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00b2\n\13\3\f\6\f\u00b5"+
		"\n\f\r\f\16\f\u00b6\3\f\2\3\b\r\2\4\6\b\n\f\16\20\22\24\26\2\5\3\2\6\7"+
		"\4\2\5\5\b\b\4\2\24\24\26\26\2\u00c2\2\30\3\2\2\2\4 \3\2\2\2\6X\3\2\2"+
		"\2\bh\3\2\2\2\n\u0089\3\2\2\2\f\u0095\3\2\2\2\16\u0097\3\2\2\2\20\u009c"+
		"\3\2\2\2\22\u00a1\3\2\2\2\24\u00b1\3\2\2\2\26\u00b4\3\2\2\2\30\31\5\4"+
		"\3\2\31\32\7\2\2\3\32\3\3\2\2\2\33\34\5\n\6\2\34\35\b\3\1\2\35\37\3\2"+
		"\2\2\36\33\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!&\3\2\2\2\" \3\2"+
		"\2\2#%\7\26\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'.\3\2\2\2(&"+
		"\3\2\2\2)*\5\6\4\2*+\b\3\1\2+-\3\2\2\2,)\3\2\2\2-\60\3\2\2\2.,\3\2\2\2"+
		"./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\b\3\1\2\62\5\3\2\2\2\63\64\7"+
		"\3\2\2\64:\b\4\1\2\65\66\5\6\4\2\66\67\b\4\1\2\679\3\2\2\28\65\3\2\2\2"+
		"9<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=Y\7\4\2\2>?\5\b\5\2"+
		"?@\5\26\f\2@A\b\4\1\2AY\3\2\2\2BC\5\22\n\2CD\b\4\1\2DY\3\2\2\2EF\5\24"+
		"\13\2FG\5\26\f\2GH\b\4\1\2HY\3\2\2\2IJ\5\f\7\2JK\5\26\f\2KL\b\4\1\2LY"+
		"\3\2\2\2MN\5\16\b\2NO\5\26\f\2OP\b\4\1\2PY\3\2\2\2QR\5\20\t\2RS\5\26\f"+
		"\2ST\b\4\1\2TY\3\2\2\2UV\5\26\f\2VW\b\4\1\2WY\3\2\2\2X\63\3\2\2\2X>\3"+
		"\2\2\2XB\3\2\2\2XE\3\2\2\2XI\3\2\2\2XM\3\2\2\2XQ\3\2\2\2XU\3\2\2\2Y\7"+
		"\3\2\2\2Z[\b\5\1\2[\\\7\5\2\2\\]\5\b\5\b]^\b\5\1\2^i\3\2\2\2_`\7\t\2\2"+
		"`a\5\b\5\2ab\7\n\2\2bc\b\5\1\2ci\3\2\2\2de\7\30\2\2ei\b\5\1\2fg\7\31\2"+
		"\2gi\b\5\1\2hZ\3\2\2\2h_\3\2\2\2hd\3\2\2\2hf\3\2\2\2iv\3\2\2\2jk\f\7\2"+
		"\2kl\t\2\2\2lm\5\b\5\bmn\b\5\1\2nu\3\2\2\2op\f\6\2\2pq\t\3\2\2qr\5\b\5"+
		"\7rs\b\5\1\2su\3\2\2\2tj\3\2\2\2to\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2"+
		"\2w\t\3\2\2\2xv\3\2\2\2yz\7\13\2\2z{\7\31\2\2{|\7\f\2\2|}\7\25\2\2}~\5"+
		"\26\f\2~\177\b\6\1\2\177\u008a\3\2\2\2\u0080\u0081\7\13\2\2\u0081\u0082"+
		"\7\31\2\2\u0082\u0083\7\f\2\2\u0083\u0084\7\25\2\2\u0084\u0085\7\r\2\2"+
		"\u0085\u0086\7\30\2\2\u0086\u0087\5\26\f\2\u0087\u0088\b\6\1\2\u0088\u008a"+
		"\3\2\2\2\u0089y\3\2\2\2\u0089\u0080\3\2\2\2\u008a\13\3\2\2\2\u008b\u008c"+
		"\7\31\2\2\u008c\u008d\7\r\2\2\u008d\u008e\5\b\5\2\u008e\u008f\b\7\1\2"+
		"\u008f\u0096\3\2\2\2\u0090\u0091\7\31\2\2\u0091\u0092\7\16\2\2\u0092\u0093"+
		"\5\b\5\2\u0093\u0094\b\7\1\2\u0094\u0096\3\2\2\2\u0095\u008b\3\2\2\2\u0095"+
		"\u0090\3\2\2\2\u0096\r\3\2\2\2\u0097\u0098\7\17\2\2\u0098\u0099\7\31\2"+
		"\2\u0099\u009a\7\n\2\2\u009a\u009b\b\b\1\2\u009b\17\3\2\2\2\u009c\u009d"+
		"\7\20\2\2\u009d\u009e\7\31\2\2\u009e\u009f\7\n\2\2\u009f\u00a0\b\t\1\2"+
		"\u00a0\21\3\2\2\2\u00a1\u00a2\7\21\2\2\u00a2\u00a3\7\t\2\2\u00a3\u00a4"+
		"\5\24\13\2\u00a4\u00a5\7\n\2\2\u00a5\u00a6\5\6\4\2\u00a6\u00a7\b\n\1\2"+
		"\u00a7\23\3\2\2\2\u00a8\u00a9\5\b\5\2\u00a9\u00aa\7\32\2\2\u00aa\u00ab"+
		"\5\b\5\2\u00ab\u00ac\b\13\1\2\u00ac\u00b2\3\2\2\2\u00ad\u00ae\7\22\2\2"+
		"\u00ae\u00b2\b\13\1\2\u00af\u00b0\7\23\2\2\u00b0\u00b2\b\13\1\2\u00b1"+
		"\u00a8\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\25\3\2\2"+
		"\2\u00b3\u00b5\t\4\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\27\3\2\2\2\16 &.:Xhtv\u0089\u0095\u00b1"+
		"\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}