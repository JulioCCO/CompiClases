package astPKG;

public class WhileSCAST extends SingleCommandAST{
    ExpressionAST expression;
    SingleCommandAST singleCommand;

    public WhileSCAST(ExpressionAST expression, SingleCommandAST singleCommand) {
        this.expression = expression;
        this.singleCommand = singleCommand;
    }

}
