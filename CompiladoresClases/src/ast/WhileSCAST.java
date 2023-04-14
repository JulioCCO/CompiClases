package ast;

public class WhileSCAST extends SingleCommandAST{
    private ExpressionAST expression;
    private SingleCommandAST singleCommand;

    public WhileSCAST(ExpressionAST expression, SingleCommandAST singleCommand){
        this.expression = expression;
        this.singleCommand = singleCommand;
    }

    public ExpressionAST getExpression() {
        return expression;
    }

    public void setExpression(ExpressionAST expression) {
        this.expression = expression;
    }

    public SingleCommandAST getSingleCommand() {
        return singleCommand;
    }

    public void setSingleCommand(SingleCommandAST singleCommand) {
        this.singleCommand = singleCommand;
    }

}
