package astPKG;

import java.util.LinkedList;

public class CommandAST extends AST{
    public SingleCommandAST singleCommandCommand;
    public LinkedList<SingleCommandAST> singleCommands;

    public CommandAST(SingleCommandAST singleCommandCommand, LinkedList<SingleCommandAST> singleCommands) {
        this.singleCommandCommand = singleCommandCommand;
        this.singleCommands = singleCommands;
    }
}
