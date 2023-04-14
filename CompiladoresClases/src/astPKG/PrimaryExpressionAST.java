package astPKG;

import org.antlr.v4.runtime.Token;

public class PrimaryExpressionAST extends AST{

    private Token id;
    private ExpressionAST expression;

    public PrimaryExpressionAST(ExpressionAST expression) {
        this.expression = expression;
    }
    public PrimaryExpressionAST(Token id) {
        this.id = id;
    }


}
