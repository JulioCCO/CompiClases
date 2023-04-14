package ast;

public class LetSCAST extends SingleCommandAST{

    private DeclarationAST declaration;
    private SingleCommandAST singleCommand;

    public LetSCAST(DeclarationAST declaration, SingleCommandAST singleCommand){
        this.declaration = declaration;
        this.singleCommand = singleCommand;
    }

    public DeclarationAST getDeclaration() {
        return declaration;
    }

    public SingleCommandAST getSingleCommand() {
        return singleCommand;
    }

    public void setDeclaration(DeclarationAST declaration) {
        this.declaration = declaration;
    }

    public void setSingleCommand(SingleCommandAST singleCommand) {
        this.singleCommand = singleCommand;
    }

}
