package astPKG;

import org.antlr.v4.runtime.Token;

public class VarSDAST extends SingleDeclarationAST {
    Token id;
    TypeDenoterAST type;

    public VarSDAST(Token id, TypeDenoterAST type) {
        this.id = id;
        this.type = type;
    }

}
