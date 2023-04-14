package astPKG;

import org.antlr.v4.runtime.Token;

public class ConstSDAST extends SingleDeclarationAST {
    private Token id;
    private ExpressionAST expression;

    public ConstSDAST(Token id, ExpressionAST expression) {
        this.id = id;
        this.expression = expression;
    }
}
