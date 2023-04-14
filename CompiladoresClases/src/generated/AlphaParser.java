// Generated from java-escape by ANTLR 4.11.1
package generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AlphaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Plus=1, Minus=2, Mult=3, Div=4, Mod=5, Equals=6, NotEquals=7, LessThan=8, 
		GreaterThan=9, LessThanOrEquals=10, GreaterThanOrEquals=11, Colon=12, 
		Semicolon=13, Tilde=14, Comma=15, LeftParen=16, RightParen=17, Assign=18, 
		If=19, Then=20, Else=21, While=22, Do=23, Let=24, In=25, Begin=26, End=27, 
		Const=28, Var=29, Control=30, Cover=31, Break=32, PLAIN_TEXT=33, VOID=34, 
		NUM=35, ID=36, Char=37, COMMENT=38, WS=39;
	public static final int
		RULE_program = 0, RULE_command = 1, RULE_singleCommand = 2, RULE_methodCall = 3, 
		RULE_actualParam = 4, RULE_declaration = 5, RULE_singleDeclaration = 6, 
		RULE_idDeclaration = 7, RULE_paramDecls = 8, RULE_typeDenoter = 9, RULE_expression = 10, 
		RULE_primaryExpression = 11, RULE_operator = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "command", "singleCommand", "methodCall", "actualParam", "declaration", 
			"singleDeclaration", "idDeclaration", "paramDecls", "typeDenoter", "expression", 
			"primaryExpression", "operator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'<'", "'>'", 
			"'<='", "'>='", "':'", "';'", "'~'", "','", "'('", "')'", "':='", "'if'", 
			"'then'", "'else'", "'while'", "'do'", "'let'", "'in'", "'begin'", "'end'", 
			"'const'", "'var'", "'control'", "'cover'", "'break'", null, "'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Plus", "Minus", "Mult", "Div", "Mod", "Equals", "NotEquals", "LessThan", 
			"GreaterThan", "LessThanOrEquals", "GreaterThanOrEquals", "Colon", "Semicolon", 
			"Tilde", "Comma", "LeftParen", "RightParen", "Assign", "If", "Then", 
			"Else", "While", "Do", "Let", "In", "Begin", "End", "Const", "Var", "Control", 
			"Cover", "Break", "PLAIN_TEXT", "VOID", "NUM", "ID", "Char", "COMMENT", 
			"WS"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AlphaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProgramASTContext extends ProgramContext {
		public SingleCommandContext singleCommand() {
			return getRuleContext(SingleCommandContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AlphaParser.EOF, 0); }
		public ProgramASTContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitProgramAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			_localctx = new ProgramASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			singleCommand();
			setState(27);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CommandContext extends ParserRuleContext {
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	 
		public CommandContext() { }
		public void copyFrom(CommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CommandASTContext extends CommandContext {
		public List<SingleCommandContext> singleCommand() {
			return getRuleContexts(SingleCommandContext.class);
		}
		public SingleCommandContext singleCommand(int i) {
			return getRuleContext(SingleCommandContext.class,i);
		}
		public List<TerminalNode> Semicolon() { return getTokens(AlphaParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(AlphaParser.Semicolon, i);
		}
		public CommandASTContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		int _la;
		try {
			_localctx = new CommandASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			singleCommand();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semicolon) {
				{
				{
				setState(30);
				match(Semicolon);
				setState(31);
				singleCommand();
				}
				}
				setState(36);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SingleCommandContext extends ParserRuleContext {
		public SingleCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleCommand; }
	 
		public SingleCommandContext() { }
		public void copyFrom(SingleCommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfSingleCommandASTContext extends SingleCommandContext {
		public TerminalNode If() { return getToken(AlphaParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Then() { return getToken(AlphaParser.Then, 0); }
		public List<SingleCommandContext> singleCommand() {
			return getRuleContexts(SingleCommandContext.class);
		}
		public SingleCommandContext singleCommand(int i) {
			return getRuleContext(SingleCommandContext.class,i);
		}
		public TerminalNode Else() { return getToken(AlphaParser.Else, 0); }
		public IfSingleCommandASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitIfSingleCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignSingleCommandASTContext extends SingleCommandContext {
		public TerminalNode ID() { return getToken(AlphaParser.ID, 0); }
		public TerminalNode Assign() { return getToken(AlphaParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignSingleCommandASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitAssignSingleCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileSingleCommandASTContext extends SingleCommandContext {
		public TerminalNode While() { return getToken(AlphaParser.While, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Do() { return getToken(AlphaParser.Do, 0); }
		public SingleCommandContext singleCommand() {
			return getRuleContext(SingleCommandContext.class,0);
		}
		public WhileSingleCommandASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitWhileSingleCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetSingleCommandASTContext extends SingleCommandContext {
		public TerminalNode Let() { return getToken(AlphaParser.Let, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode In() { return getToken(AlphaParser.In, 0); }
		public SingleCommandContext singleCommand() {
			return getRuleContext(SingleCommandContext.class,0);
		}
		public LetSingleCommandASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitLetSingleCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockSingleCommandASTContext extends SingleCommandContext {
		public TerminalNode Begin() { return getToken(AlphaParser.Begin, 0); }
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public TerminalNode End() { return getToken(AlphaParser.End, 0); }
		public BlockSingleCommandASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitBlockSingleCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallSingleCommandASTContext extends SingleCommandContext {
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public CallSingleCommandASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitCallSingleCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleCommandContext singleCommand() throws RecognitionException {
		SingleCommandContext _localctx = new SingleCommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_singleCommand);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new AssignSingleCommandASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(ID);
				setState(38);
				match(Assign);
				setState(39);
				expression();
				}
				break;
			case 2:
				_localctx = new CallSingleCommandASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				methodCall();
				}
				break;
			case 3:
				_localctx = new IfSingleCommandASTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				match(If);
				setState(42);
				expression();
				setState(43);
				match(Then);
				setState(44);
				singleCommand();
				setState(47);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(45);
					match(Else);
					setState(46);
					singleCommand();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new WhileSingleCommandASTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				match(While);
				setState(50);
				expression();
				setState(51);
				match(Do);
				setState(52);
				singleCommand();
				}
				break;
			case 5:
				_localctx = new LetSingleCommandASTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(54);
				match(Let);
				setState(55);
				declaration();
				setState(56);
				match(In);
				setState(57);
				singleCommand();
				}
				break;
			case 6:
				_localctx = new BlockSingleCommandASTContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(59);
				match(Begin);
				setState(60);
				command();
				setState(61);
				match(End);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends ParserRuleContext {
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
	 
		public MethodCallContext() { }
		public void copyFrom(MethodCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallASTContext extends MethodCallContext {
		public TerminalNode ID() { return getToken(AlphaParser.ID, 0); }
		public TerminalNode LeftParen() { return getToken(AlphaParser.LeftParen, 0); }
		public ActualParamContext actualParam() {
			return getRuleContext(ActualParamContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(AlphaParser.RightParen, 0); }
		public MethodCallASTContext(MethodCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitMethodCallAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_methodCall);
		try {
			_localctx = new MethodCallASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(ID);
			setState(66);
			match(LeftParen);
			setState(67);
			actualParam();
			setState(68);
			match(RightParen);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ActualParamContext extends ParserRuleContext {
		public ActualParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualParam; }
	 
		public ActualParamContext() { }
		public void copyFrom(ActualParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ActualParamASTContext extends ActualParamContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(AlphaParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(AlphaParser.Comma, i);
		}
		public ActualParamASTContext(ActualParamContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitActualParamAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualParamContext actualParam() throws RecognitionException {
		ActualParamContext _localctx = new ActualParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_actualParam);
		int _la;
		try {
			_localctx = new ActualParamASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			expression();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(71);
				match(Comma);
				setState(72);
				expression();
				}
				}
				setState(77);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationASTContext extends DeclarationContext {
		public List<SingleDeclarationContext> singleDeclaration() {
			return getRuleContexts(SingleDeclarationContext.class);
		}
		public SingleDeclarationContext singleDeclaration(int i) {
			return getRuleContext(SingleDeclarationContext.class,i);
		}
		public List<TerminalNode> Semicolon() { return getTokens(AlphaParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(AlphaParser.Semicolon, i);
		}
		public DeclarationASTContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitDeclarationAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaration);
		int _la;
		try {
			_localctx = new DeclarationASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			singleDeclaration();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semicolon) {
				{
				{
				setState(79);
				match(Semicolon);
				setState(80);
				singleDeclaration();
				}
				}
				setState(85);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SingleDeclarationContext extends ParserRuleContext {
		public SingleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleDeclaration; }
	 
		public SingleDeclarationContext() { }
		public void copyFrom(SingleDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclarationASTContext extends SingleDeclarationContext {
		public TerminalNode Var() { return getToken(AlphaParser.Var, 0); }
		public TerminalNode ID() { return getToken(AlphaParser.ID, 0); }
		public TerminalNode Colon() { return getToken(AlphaParser.Colon, 0); }
		public TypeDenoterContext typeDenoter() {
			return getRuleContext(TypeDenoterContext.class,0);
		}
		public VarDeclarationASTContext(SingleDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitVarDeclarationAST(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstSingleDeclarationASTContext extends SingleDeclarationContext {
		public TerminalNode Const() { return getToken(AlphaParser.Const, 0); }
		public TerminalNode ID() { return getToken(AlphaParser.ID, 0); }
		public TerminalNode Tilde() { return getToken(AlphaParser.Tilde, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstSingleDeclarationASTContext(SingleDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitConstSingleDeclarationAST(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodSingleDeclarationContext extends SingleDeclarationContext {
		public TerminalNode ID() { return getToken(AlphaParser.ID, 0); }
		public TerminalNode LeftParen() { return getToken(AlphaParser.LeftParen, 0); }
		public ParamDeclsContext paramDecls() {
			return getRuleContext(ParamDeclsContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(AlphaParser.RightParen, 0); }
		public SingleCommandContext singleCommand() {
			return getRuleContext(SingleCommandContext.class,0);
		}
		public TypeDenoterContext typeDenoter() {
			return getRuleContext(TypeDenoterContext.class,0);
		}
		public TerminalNode VOID() { return getToken(AlphaParser.VOID, 0); }
		public MethodSingleDeclarationContext(SingleDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitMethodSingleDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleDeclarationContext singleDeclaration() throws RecognitionException {
		SingleDeclarationContext _localctx = new SingleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_singleDeclaration);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Const:
				_localctx = new ConstSingleDeclarationASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(Const);
				setState(87);
				match(ID);
				setState(88);
				match(Tilde);
				setState(89);
				expression();
				}
				break;
			case Var:
				_localctx = new VarDeclarationASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				match(Var);
				setState(91);
				match(ID);
				setState(92);
				match(Colon);
				setState(93);
				typeDenoter();
				}
				break;
			case VOID:
			case ID:
				_localctx = new MethodSingleDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(94);
					typeDenoter();
					}
					break;
				case VOID:
					{
					setState(95);
					match(VOID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(98);
				match(ID);
				setState(99);
				match(LeftParen);
				setState(100);
				paramDecls();
				setState(101);
				match(RightParen);
				setState(102);
				singleCommand();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdDeclarationContext extends ParserRuleContext {
		public IdDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idDeclaration; }
	 
		public IdDeclarationContext() { }
		public void copyFrom(IdDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdDeclASTContext extends IdDeclarationContext {
		public TerminalNode ID() { return getToken(AlphaParser.ID, 0); }
		public TerminalNode Colon() { return getToken(AlphaParser.Colon, 0); }
		public TypeDenoterContext typeDenoter() {
			return getRuleContext(TypeDenoterContext.class,0);
		}
		public IdDeclASTContext(IdDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitIdDeclAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdDeclarationContext idDeclaration() throws RecognitionException {
		IdDeclarationContext _localctx = new IdDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_idDeclaration);
		try {
			_localctx = new IdDeclASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(ID);
			setState(107);
			match(Colon);
			setState(108);
			typeDenoter();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamDeclsContext extends ParserRuleContext {
		public ParamDeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramDecls; }
	 
		public ParamDeclsContext() { }
		public void copyFrom(ParamDeclsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamDeclsASTContext extends ParamDeclsContext {
		public List<IdDeclarationContext> idDeclaration() {
			return getRuleContexts(IdDeclarationContext.class);
		}
		public IdDeclarationContext idDeclaration(int i) {
			return getRuleContext(IdDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(AlphaParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(AlphaParser.Comma, i);
		}
		public ParamDeclsASTContext(ParamDeclsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitParamDeclsAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamDeclsContext paramDecls() throws RecognitionException {
		ParamDeclsContext _localctx = new ParamDeclsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_paramDecls);
		int _la;
		try {
			_localctx = new ParamDeclsASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			idDeclaration();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(111);
				match(Comma);
				setState(112);
				idDeclaration();
				}
				}
				setState(117);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDenoterContext extends ParserRuleContext {
		public TypeDenoterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDenoter; }
	 
		public TypeDenoterContext() { }
		public void copyFrom(TypeDenoterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeDenoterASTContext extends TypeDenoterContext {
		public TerminalNode ID() { return getToken(AlphaParser.ID, 0); }
		public TypeDenoterASTContext(TypeDenoterContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitTypeDenoterAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDenoterContext typeDenoter() throws RecognitionException {
		TypeDenoterContext _localctx = new TypeDenoterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeDenoter);
		try {
			_localctx = new TypeDenoterASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionASTContext extends ExpressionContext {
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public ExpressionASTContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		int _la;
		try {
			_localctx = new ExpressionASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			primaryExpression();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4094L) != 0) {
				{
				{
				setState(121);
				operator();
				setState(122);
				primaryExpression();
				}
				}
				setState(128);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	 
		public PrimaryExpressionContext() { }
		public void copyFrom(PrimaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharPrimaryExpressionASTContext extends PrimaryExpressionContext {
		public TerminalNode Char() { return getToken(AlphaParser.Char, 0); }
		public CharPrimaryExpressionASTContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitCharPrimaryExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallPrimaryExpressionASTContext extends PrimaryExpressionContext {
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public MethodCallPrimaryExpressionASTContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitMethodCallPrimaryExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisPrimaryExpressionASTContext extends PrimaryExpressionContext {
		public TerminalNode LeftParen() { return getToken(AlphaParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(AlphaParser.RightParen, 0); }
		public ParenthesisPrimaryExpressionASTContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitParenthesisPrimaryExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumPrimaryExpressionASTContext extends PrimaryExpressionContext {
		public TerminalNode NUM() { return getToken(AlphaParser.NUM, 0); }
		public NumPrimaryExpressionASTContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitNumPrimaryExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdPrimaryExpressionASTContext extends PrimaryExpressionContext {
		public TerminalNode ID() { return getToken(AlphaParser.ID, 0); }
		public IdPrimaryExpressionASTContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitIdPrimaryExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_primaryExpression);
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new NumPrimaryExpressionASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(NUM);
				}
				break;
			case 2:
				_localctx = new IdPrimaryExpressionASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(ID);
				}
				break;
			case 3:
				_localctx = new CharPrimaryExpressionASTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(Char);
				}
				break;
			case 4:
				_localctx = new ParenthesisPrimaryExpressionASTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				match(LeftParen);
				setState(133);
				expression();
				setState(134);
				match(RightParen);
				}
				break;
			case 5:
				_localctx = new MethodCallPrimaryExpressionASTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(136);
				methodCall();
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

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(AlphaParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(AlphaParser.Minus, 0); }
		public TerminalNode Mult() { return getToken(AlphaParser.Mult, 0); }
		public TerminalNode Div() { return getToken(AlphaParser.Div, 0); }
		public TerminalNode Mod() { return getToken(AlphaParser.Mod, 0); }
		public TerminalNode Equals() { return getToken(AlphaParser.Equals, 0); }
		public TerminalNode NotEquals() { return getToken(AlphaParser.NotEquals, 0); }
		public TerminalNode LessThan() { return getToken(AlphaParser.LessThan, 0); }
		public TerminalNode GreaterThan() { return getToken(AlphaParser.GreaterThan, 0); }
		public TerminalNode LessThanOrEquals() { return getToken(AlphaParser.LessThanOrEquals, 0); }
		public TerminalNode GreaterThanOrEquals() { return getToken(AlphaParser.GreaterThanOrEquals, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlphaParserVisitor ) return ((AlphaParserVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 4094L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001\'\u008e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001!\b\u0001\n\u0001\f\u0001$\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00020\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002@\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"J\b\u0004\n\u0004\f\u0004M\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005R\b\u0005\n\u0005\f\u0005U\t\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006a\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006i\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0005\br\b\b\n\b\f\bu\t\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0005\n}\b\n\n\n\f\n\u0080\t\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u008a\b\u000b\u0001\f\u0001\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0001\u0001\u0000"+
		"\u0001\u000b\u0092\u0000\u001a\u0001\u0000\u0000\u0000\u0002\u001d\u0001"+
		"\u0000\u0000\u0000\u0004?\u0001\u0000\u0000\u0000\u0006A\u0001\u0000\u0000"+
		"\u0000\bF\u0001\u0000\u0000\u0000\nN\u0001\u0000\u0000\u0000\fh\u0001"+
		"\u0000\u0000\u0000\u000ej\u0001\u0000\u0000\u0000\u0010n\u0001\u0000\u0000"+
		"\u0000\u0012v\u0001\u0000\u0000\u0000\u0014x\u0001\u0000\u0000\u0000\u0016"+
		"\u0089\u0001\u0000\u0000\u0000\u0018\u008b\u0001\u0000\u0000\u0000\u001a"+
		"\u001b\u0003\u0004\u0002\u0000\u001b\u001c\u0005\u0000\u0000\u0001\u001c"+
		"\u0001\u0001\u0000\u0000\u0000\u001d\"\u0003\u0004\u0002\u0000\u001e\u001f"+
		"\u0005\r\u0000\u0000\u001f!\u0003\u0004\u0002\u0000 \u001e\u0001\u0000"+
		"\u0000\u0000!$\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001"+
		"\u0000\u0000\u0000#\u0003\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000"+
		"\u0000%&\u0005$\u0000\u0000&\'\u0005\u0012\u0000\u0000\'@\u0003\u0014"+
		"\n\u0000(@\u0003\u0006\u0003\u0000)*\u0005\u0013\u0000\u0000*+\u0003\u0014"+
		"\n\u0000+,\u0005\u0014\u0000\u0000,/\u0003\u0004\u0002\u0000-.\u0005\u0015"+
		"\u0000\u0000.0\u0003\u0004\u0002\u0000/-\u0001\u0000\u0000\u0000/0\u0001"+
		"\u0000\u0000\u00000@\u0001\u0000\u0000\u000012\u0005\u0016\u0000\u0000"+
		"23\u0003\u0014\n\u000034\u0005\u0017\u0000\u000045\u0003\u0004\u0002\u0000"+
		"5@\u0001\u0000\u0000\u000067\u0005\u0018\u0000\u000078\u0003\n\u0005\u0000"+
		"89\u0005\u0019\u0000\u00009:\u0003\u0004\u0002\u0000:@\u0001\u0000\u0000"+
		"\u0000;<\u0005\u001a\u0000\u0000<=\u0003\u0002\u0001\u0000=>\u0005\u001b"+
		"\u0000\u0000>@\u0001\u0000\u0000\u0000?%\u0001\u0000\u0000\u0000?(\u0001"+
		"\u0000\u0000\u0000?)\u0001\u0000\u0000\u0000?1\u0001\u0000\u0000\u0000"+
		"?6\u0001\u0000\u0000\u0000?;\u0001\u0000\u0000\u0000@\u0005\u0001\u0000"+
		"\u0000\u0000AB\u0005$\u0000\u0000BC\u0005\u0010\u0000\u0000CD\u0003\b"+
		"\u0004\u0000DE\u0005\u0011\u0000\u0000E\u0007\u0001\u0000\u0000\u0000"+
		"FK\u0003\u0014\n\u0000GH\u0005\u000f\u0000\u0000HJ\u0003\u0014\n\u0000"+
		"IG\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000"+
		"\u0000KL\u0001\u0000\u0000\u0000L\t\u0001\u0000\u0000\u0000MK\u0001\u0000"+
		"\u0000\u0000NS\u0003\f\u0006\u0000OP\u0005\r\u0000\u0000PR\u0003\f\u0006"+
		"\u0000QO\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000T\u000b\u0001\u0000\u0000\u0000"+
		"US\u0001\u0000\u0000\u0000VW\u0005\u001c\u0000\u0000WX\u0005$\u0000\u0000"+
		"XY\u0005\u000e\u0000\u0000Yi\u0003\u0014\n\u0000Z[\u0005\u001d\u0000\u0000"+
		"[\\\u0005$\u0000\u0000\\]\u0005\f\u0000\u0000]i\u0003\u0012\t\u0000^a"+
		"\u0003\u0012\t\u0000_a\u0005\"\u0000\u0000`^\u0001\u0000\u0000\u0000`"+
		"_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0005$\u0000\u0000"+
		"cd\u0005\u0010\u0000\u0000de\u0003\u0010\b\u0000ef\u0005\u0011\u0000\u0000"+
		"fg\u0003\u0004\u0002\u0000gi\u0001\u0000\u0000\u0000hV\u0001\u0000\u0000"+
		"\u0000hZ\u0001\u0000\u0000\u0000h`\u0001\u0000\u0000\u0000i\r\u0001\u0000"+
		"\u0000\u0000jk\u0005$\u0000\u0000kl\u0005\f\u0000\u0000lm\u0003\u0012"+
		"\t\u0000m\u000f\u0001\u0000\u0000\u0000ns\u0003\u000e\u0007\u0000op\u0005"+
		"\u000f\u0000\u0000pr\u0003\u000e\u0007\u0000qo\u0001\u0000\u0000\u0000"+
		"ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000t\u0011\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0005"+
		"$\u0000\u0000w\u0013\u0001\u0000\u0000\u0000x~\u0003\u0016\u000b\u0000"+
		"yz\u0003\u0018\f\u0000z{\u0003\u0016\u000b\u0000{}\u0001\u0000\u0000\u0000"+
		"|y\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000"+
		"\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0015\u0001\u0000\u0000"+
		"\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u008a\u0005#\u0000\u0000\u0082"+
		"\u008a\u0005$\u0000\u0000\u0083\u008a\u0005%\u0000\u0000\u0084\u0085\u0005"+
		"\u0010\u0000\u0000\u0085\u0086\u0003\u0014\n\u0000\u0086\u0087\u0005\u0011"+
		"\u0000\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u008a\u0003\u0006"+
		"\u0003\u0000\u0089\u0081\u0001\u0000\u0000\u0000\u0089\u0082\u0001\u0000"+
		"\u0000\u0000\u0089\u0083\u0001\u0000\u0000\u0000\u0089\u0084\u0001\u0000"+
		"\u0000\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u0017\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0007\u0000\u0000\u0000\u008c\u0019\u0001\u0000"+
		"\u0000\u0000\n\"/?KS`hs~\u0089";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}