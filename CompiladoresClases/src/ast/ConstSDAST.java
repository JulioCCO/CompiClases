package ast;
import org.antlr.v4.runtime.Token;
public class ConstSDAST extends SingleDeclarationAST {
    private Token id;
    private ExpressionAST expression;

    public ConstSDAST(Token id, ExpressionAST expression){
        this.id = id;
        this.expression = expression;
    }

    public Token getId() {
        return id;
    }

    public void setId(Token id) {
        this.id = id;
    }

    public ExpressionAST getExpression() {
        return expression;
    }

    public void setExpression(ExpressionAST expression) {
        this.expression = expression;
    }


}
