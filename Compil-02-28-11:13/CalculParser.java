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
			null, "'-'", "'*'", "'/'", "'+'", "'('", "')'", "'var'", "':'", "'='", 
			"'+='", "'read('", "'write('", "'while('", "'){'", "'}'", "'true'", "'false'", 
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
			while (_la==T__6) {
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << NEWLINE) | (1L << ENTIER) | (1L << IDENTIFIANT))) != 0)) {
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
		public ExpressionContext expression;
		public AssignationContext assignation;
		public ReadContext read;
		public WriteContext write;
		public Boucle_whileContext boucle_while;
		public ConditionContext condition;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
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
		public Boucle_whileContext boucle_while() {
			return getRuleContext(Boucle_whileContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
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
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				((InstructionContext)_localctx).expression = expression(0);
				setState(50);
				finInstruction();

				          ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expression.code;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				finInstruction();

				            ((InstructionContext)_localctx).code = "";
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				((InstructionContext)_localctx).assignation = assignation();
				setState(57);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				((InstructionContext)_localctx).read = read();
				setState(61);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).read.code;
				        
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(64);
				((InstructionContext)_localctx).write = write();
				setState(65);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).write.code;
				        
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(68);
				((InstructionContext)_localctx).boucle_while = boucle_while();
				setState(69);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).boucle_while.code;
				        
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(72);
				((InstructionContext)_localctx).condition = condition();
				setState(73);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).condition.code;
				        
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
		public Token op;
		public ExpressionContext b;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(CalculParser.ENTIER, 0); }
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
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(79);
				match(T__0);
				setState(80);
				((ExpressionContext)_localctx).a = expression(5);
				((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + "PUSHI -1\n" + "MUL\n";
				}
				break;
			case T__4:
				{
				setState(83);
				match(T__4);
				setState(84);
				((ExpressionContext)_localctx).a = expression(0);
				setState(85);
				match(T__5);
				((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code;
				}
				break;
			case ENTIER:
				{
				setState(88);
				((ExpressionContext)_localctx).ENTIER = match(ENTIER);
				((ExpressionContext)_localctx).code =  "PUSHI " + (((ExpressionContext)_localctx).ENTIER!=null?Integer.valueOf(((ExpressionContext)_localctx).ENTIER.getText()):0) + "\n";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(102);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(93);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__2) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(94);
						((ExpressionContext)_localctx).b = expression(5);
						((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + ((ExpressionContext)_localctx).b.code + evalexpr((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(97);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(98);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__3) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(99);
						((ExpressionContext)_localctx).b = expression(4);
						((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).a.code + ((ExpressionContext)_localctx).b.code + evalexpr((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						}
						break;
					}
					} 
				}
				setState(106);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(T__6);
				setState(108);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(109);
				match(T__7);
				setState(110);
				match(TYPE);
				setState(111);
				finInstruction();

				            ((DeclContext)_localctx).code =  "PUSHI 0\n";
				            tableSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null),"int");
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(T__6);
				setState(115);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(116);
				match(T__7);
				setState(117);
				match(TYPE);
				setState(118);
				match(T__8);
				setState(119);
				((DeclContext)_localctx).ENTIER = match(ENTIER);
				setState(120);
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
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(126);
				match(T__8);
				setState(127);
				((AssignationContext)_localctx).expression = expression(0);

				            AdresseType at = tableSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));
				            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expression.code + "STOREG " + at.adresse + "\n";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(131);
				match(T__9);
				setState(132);
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
			setState(137);
			match(T__10);
			setState(138);
			((ReadContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(139);
			match(T__5);

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
			setState(142);
			match(T__11);
			setState(143);
			((WriteContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(144);
			match(T__5);

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
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(T__12);
				setState(148);
				((Boucle_whileContext)_localctx).condition = condition();
				setState(149);
				match(T__13);
				setState(150);
				((Boucle_whileContext)_localctx).instruction = instruction();
				setState(151);
				match(T__14);

				        String debut = getNewLabel();
				        String fin = getNewLabel();
				        ((Boucle_whileContext)_localctx).code =  "LABEL " + debut + "\n" + ((Boucle_whileContext)_localctx).condition.code + "JUMPF " + fin + "\n" + ((Boucle_whileContext)_localctx).instruction.code + "JUMP " + debut + "\n" + "LABEL " + fin + "\n";
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				match(T__12);
				setState(155);
				((Boucle_whileContext)_localctx).condition = condition();
				setState(156);
				match(T__5);
				setState(157);
				((Boucle_whileContext)_localctx).instruction = instruction();

				        String debut = getNewLabel();
				        String fin = getNewLabel();
				        ((Boucle_whileContext)_localctx).code =  "LABEL " + debut + "\n" + ((Boucle_whileContext)_localctx).condition.code + "JUMPF " + fin + "\n" + ((Boucle_whileContext)_localctx).instruction.code + "JUMP " + debut + "\n" + "LABEL " + fin + "\n";
				      
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
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__4:
			case ENTIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				((ConditionContext)_localctx).a = expression(0);
				setState(163);
				((ConditionContext)_localctx).op = match(OPERATEUR);
				setState(164);
				((ConditionContext)_localctx).b = expression(0);
				((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).a.code + ((ConditionContext)_localctx).b.code + evalop((((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null));
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				match(T__15);
				 ((ConditionContext)_localctx).code =  "PUSHI 1\n";
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
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
			setState(174); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(173);
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
				setState(176); 
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
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u00b5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\2\3\3\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3\3\7"+
		"\3%\n\3\f\3\16\3(\13\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4O\n\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5]\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\7\5i\n\5\f\5\16\5l\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\5\6~\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\5\7\u008a\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a3\n\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ae\n\13\3\f\6\f\u00b1\n\f\r\f\16"+
		"\f\u00b2\3\f\2\3\b\r\2\4\6\b\n\f\16\20\22\24\26\2\5\3\2\4\5\4\2\3\3\6"+
		"\6\4\2\24\24\26\26\2\u00bc\2\30\3\2\2\2\4 \3\2\2\2\6N\3\2\2\2\b\\\3\2"+
		"\2\2\n}\3\2\2\2\f\u0089\3\2\2\2\16\u008b\3\2\2\2\20\u0090\3\2\2\2\22\u00a2"+
		"\3\2\2\2\24\u00ad\3\2\2\2\26\u00b0\3\2\2\2\30\31\5\4\3\2\31\32\7\2\2\3"+
		"\32\3\3\2\2\2\33\34\5\n\6\2\34\35\b\3\1\2\35\37\3\2\2\2\36\33\3\2\2\2"+
		"\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!&\3\2\2\2\" \3\2\2\2#%\7\26\2\2$#"+
		"\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'.\3\2\2\2(&\3\2\2\2)*\5\6\4\2"+
		"*+\b\3\1\2+-\3\2\2\2,)\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2"+
		"\2\2\60.\3\2\2\2\61\62\b\3\1\2\62\5\3\2\2\2\63\64\5\b\5\2\64\65\5\26\f"+
		"\2\65\66\b\4\1\2\66O\3\2\2\2\678\5\26\f\289\b\4\1\29O\3\2\2\2:;\5\f\7"+
		"\2;<\5\26\f\2<=\b\4\1\2=O\3\2\2\2>?\5\16\b\2?@\5\26\f\2@A\b\4\1\2AO\3"+
		"\2\2\2BC\5\20\t\2CD\5\26\f\2DE\b\4\1\2EO\3\2\2\2FG\5\22\n\2GH\5\26\f\2"+
		"HI\b\4\1\2IO\3\2\2\2JK\5\24\13\2KL\5\26\f\2LM\b\4\1\2MO\3\2\2\2N\63\3"+
		"\2\2\2N\67\3\2\2\2N:\3\2\2\2N>\3\2\2\2NB\3\2\2\2NF\3\2\2\2NJ\3\2\2\2O"+
		"\7\3\2\2\2PQ\b\5\1\2QR\7\3\2\2RS\5\b\5\7ST\b\5\1\2T]\3\2\2\2UV\7\7\2\2"+
		"VW\5\b\5\2WX\7\b\2\2XY\b\5\1\2Y]\3\2\2\2Z[\7\30\2\2[]\b\5\1\2\\P\3\2\2"+
		"\2\\U\3\2\2\2\\Z\3\2\2\2]j\3\2\2\2^_\f\6\2\2_`\t\2\2\2`a\5\b\5\7ab\b\5"+
		"\1\2bi\3\2\2\2cd\f\5\2\2de\t\3\2\2ef\5\b\5\6fg\b\5\1\2gi\3\2\2\2h^\3\2"+
		"\2\2hc\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\t\3\2\2\2lj\3\2\2\2mn\7"+
		"\t\2\2no\7\31\2\2op\7\n\2\2pq\7\25\2\2qr\5\26\f\2rs\b\6\1\2s~\3\2\2\2"+
		"tu\7\t\2\2uv\7\31\2\2vw\7\n\2\2wx\7\25\2\2xy\7\13\2\2yz\7\30\2\2z{\5\26"+
		"\f\2{|\b\6\1\2|~\3\2\2\2}m\3\2\2\2}t\3\2\2\2~\13\3\2\2\2\177\u0080\7\31"+
		"\2\2\u0080\u0081\7\13\2\2\u0081\u0082\5\b\5\2\u0082\u0083\b\7\1\2\u0083"+
		"\u008a\3\2\2\2\u0084\u0085\7\31\2\2\u0085\u0086\7\f\2\2\u0086\u0087\5"+
		"\b\5\2\u0087\u0088\b\7\1\2\u0088\u008a\3\2\2\2\u0089\177\3\2\2\2\u0089"+
		"\u0084\3\2\2\2\u008a\r\3\2\2\2\u008b\u008c\7\r\2\2\u008c\u008d\7\31\2"+
		"\2\u008d\u008e\7\b\2\2\u008e\u008f\b\b\1\2\u008f\17\3\2\2\2\u0090\u0091"+
		"\7\16\2\2\u0091\u0092\7\31\2\2\u0092\u0093\7\b\2\2\u0093\u0094\b\t\1\2"+
		"\u0094\21\3\2\2\2\u0095\u0096\7\17\2\2\u0096\u0097\5\24\13\2\u0097\u0098"+
		"\7\20\2\2\u0098\u0099\5\6\4\2\u0099\u009a\7\21\2\2\u009a\u009b\b\n\1\2"+
		"\u009b\u00a3\3\2\2\2\u009c\u009d\7\17\2\2\u009d\u009e\5\24\13\2\u009e"+
		"\u009f\7\b\2\2\u009f\u00a0\5\6\4\2\u00a0\u00a1\b\n\1\2\u00a1\u00a3\3\2"+
		"\2\2\u00a2\u0095\3\2\2\2\u00a2\u009c\3\2\2\2\u00a3\23\3\2\2\2\u00a4\u00a5"+
		"\5\b\5\2\u00a5\u00a6\7\32\2\2\u00a6\u00a7\5\b\5\2\u00a7\u00a8\b\13\1\2"+
		"\u00a8\u00ae\3\2\2\2\u00a9\u00aa\7\22\2\2\u00aa\u00ae\b\13\1\2\u00ab\u00ac"+
		"\7\23\2\2\u00ac\u00ae\b\13\1\2\u00ad\u00a4\3\2\2\2\u00ad\u00a9\3\2\2\2"+
		"\u00ad\u00ab\3\2\2\2\u00ae\25\3\2\2\2\u00af\u00b1\t\4\2\2\u00b0\u00af"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\27\3\2\2\2\16 &.N\\hj}\u0089\u00a2\u00ad\u00b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}