package astPKG;

public class LetSCAST extends SingleCommandAST {
    DeclarationAST declaration;
    SingleCommandAST singleCommand;

    public LetSCAST(DeclarationAST declaration, SingleCommandAST singleCommand) {
        this.declaration = declaration;
        this.singleCommand = singleCommand;
    }
}
