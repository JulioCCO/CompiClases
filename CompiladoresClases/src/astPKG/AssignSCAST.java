package astPKG;
import org.antlr.v4.runtime.Token;

//AssingSingleCommandAST
public class AssignSCAST extends SingleCommandAST {
    private Token id;
    private ExpressionAST expression;

    public AssignSCAST(Token id, ExpressionAST expression) {
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
