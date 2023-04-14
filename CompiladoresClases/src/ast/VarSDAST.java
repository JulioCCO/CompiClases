package ast;
import org.antlr.v4.runtime.Token;
public class VarSDAST extends SingleDeclarationAST{

    private Token id;
    private TypeAST type;

    public VarSDAST(Token id, TypeAST type){
        this.id = id;
        this.type = type;
    }

    public Token getId() {
        return id;
    }

    public void setId(Token id) {
        this.id = id;
    }

    public TypeAST getType() {
        return type;
    }

    public void setType(TypeAST type) {
        this.type = type;
    }

}
