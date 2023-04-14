package astPKG;

public class BeginSCAST extends SingleCommandAST {

    CommandAST command;

    public BeginSCAST(CommandAST command) {
        this.command = command;
    }

    public CommandAST getCommand() {
        return command;
    }

    public void setCommand(CommandAST command) {
        this.command = command;
    }

}
