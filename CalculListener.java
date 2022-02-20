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