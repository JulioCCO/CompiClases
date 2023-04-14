package ast;

import java.util.LinkedList;

import org.antlr.v4.runtime.Token;
public class ExpressionAST extends AST{

    private PrimaryExpressionAST primaryExpression;

    private LinkedList<PrimaryExpressionAST> primaryExpressions;

    private LinkedList<Token> operators;

    public ExpressionAST(PrimaryExpressionAST primaryExpression, LinkedList<PrimaryExpressionAST> primaryExpressions, LinkedList<Token> operators) {
        this.primaryExpression = primaryExpression;
        this.primaryExpressions = primaryExpressions;
        this.operators = operators;
    }

    public PrimaryExpressionAST getPrimaryExpression() {
        return primaryExpression;
    }

    public LinkedList<PrimaryExpressionAST> getPrimaryExpressions() {
        return primaryExpressions;
    }

    public LinkedList<Token> getOperators() {
        return operators;
    }

    public void setPrimaryExpression(PrimaryExpressionAST primaryExpression) {
        this.primaryExpression = primaryExpression;
    }

    public void setPrimaryExpressions(LinkedList<PrimaryExpressionAST> primaryExpressions) {
        this.primaryExpressions = primaryExpressions;
    }

    public void setOperators(LinkedList<Token> operators) {
        this.operators = operators;
    }



}
