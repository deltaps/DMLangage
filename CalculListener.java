// Generated from Calcul.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculParser}.
 */
public interface CalculListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculParser#calcul}.
	 * @param ctx the parse tree
	 */
	void enterCalcul(CalculParser.CalculContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculParser#calcul}.
	 * @param ctx the parse tree
	 */
	void exitCalcul(CalculParser.CalculContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(CalculParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(CalculParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CalculParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CalculParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(CalculParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(CalculParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculParser#assignation}.
	 * @param ctx the parse tree
	 */
	void enterAssignation(CalculParser.AssignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculParser#assignation}.
	 * @param ctx the parse tree
	 */
	void exitAssignation(CalculParser.AssignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(CalculParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(CalculParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculParser#write}.
	 * @param ctx the parse tree
	 */
	void enterWrite(CalculParser.WriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculParser#write}.
	 * @param ctx the parse tree
	 */
	void exitWrite(CalculParser.WriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculParser#boucle_while}.
	 * @param ctx the parse tree
	 */
	void enterBoucle_while(CalculParser.Boucle_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculParser#boucle_while}.
	 * @param ctx the parse tree
	 */
	void exitBoucle_while(CalculParser.Boucle_whileContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(CalculParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(CalculParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFinInstruction(CalculParser.FinInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFinInstruction(CalculParser.FinInstructionContext ctx);
}