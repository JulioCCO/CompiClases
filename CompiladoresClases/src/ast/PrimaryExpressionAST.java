package ast;
import org.antlr.v4.runtime.Token;
public class PrimaryExpressionAST extends AST{
    private Token id;
    private ExpressionAST expression;

    public PrimaryExpressionAST(Token id) {
        this.id = id;
    }
    public PrimaryExpressionAST(ExpressionAST expression) {
        this.expression = expression;
    }

    public Token getId() {
        return id;
    }

    public ExpressionAST getExpression() {
        return expression;
    }

    public void setId(Token id) {
        this.id = id;
    }

    public void setExpression(ExpressionAST expression) {
        this.expression = expression;
    }


}
