package ast;
import org.antlr.v4.runtime.Token;
public class TypeAST extends AST{
    private Token type;

    public TypeAST(Token type) {
        this.type = type;
    }

    public Token getType() {
        return type;
    }

    public void setType(Token type) {
        this.type = type;
    }
}
