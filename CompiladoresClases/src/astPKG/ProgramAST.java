package astPKG;

public class ProgramAST extends AST{
    public SingleCommandAST singleCommand;

    public ProgramAST(SingleCommandAST singleCommand) {
        this.singleCommand = singleCommand;
    }
}
