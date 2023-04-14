package astPKG;

import org.antlr.v4.runtime.Token;

import java.util.LinkedList;

public class ExpressionAST extends AST {
    private PrimaryExpressionAST primaryExpression;
    private LinkedList<Token> operators;
    private LinkedList<PrimaryExpressionAST> primaryExpressions;

    public ExpressionAST(PrimaryExpressionAST primaryExpression, LinkedList<Token> operators, LinkedList<PrimaryExpressionAST> primaryExpressions) {
        this.primaryExpression = primaryExpression;
        this.operators = operators;
        this.primaryExpressions = primaryExpressions;
    }
}
