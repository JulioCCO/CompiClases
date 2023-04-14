package ast;

public class ProgramAST extends AST{
    private SingleCommandAST singleCommand;

    public ProgramAST(SingleCommandAST singleCommand) {
        this.singleCommand = singleCommand;
    }

    public SingleCommandAST getSingleCommand() {
        return singleCommand;
    }

    public void setSingleCommand(SingleCommandAST singleCommand) {
        this.singleCommand = singleCommand;
    }
}
