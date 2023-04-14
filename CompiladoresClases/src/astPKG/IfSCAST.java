package astPKG;

public class IfSCAST extends SingleCommandAST {
    private ExpressionAST expression1;
    private SingleCommandAST singleCommand1;
    private SingleCommandAST singleCommand2;

    public IfSCAST(ExpressionAST expression1, SingleCommandAST singleCommand1, SingleCommandAST singleCommand2) {
        this.expression1 = expression1;
        this.singleCommand1 = singleCommand1;
        this.singleCommand2 = singleCommand2;
    }

    public ExpressionAST getExpression1() {
        return expression1;
    }

    public void setExpression1(ExpressionAST expression1) {
        this.expression1 = expression1;
    }

    public SingleCommandAST getSingleCommand1() {
        return singleCommand1;
    }

    public void setSingleCommand1(SingleCommandAST singleCommand1) {
        this.singleCommand1 = singleCommand1;
    }

    public SingleCommandAST getSingleCommand2() {
        return singleCommand2;
    }

    public void setSingleCommand2(SingleCommandAST singleCommand2) {
        this.singleCommand2 = singleCommand2;
    }
}
