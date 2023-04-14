package ast;

public class IfSCAST extends SingleCommandAST{

    // que hago con el then y con else
    private ExpressionAST expression;
    private SingleCommandAST singleCommand1;
    private SingleCommandAST singleCommand2;

    public IfSCAST(ExpressionAST expression, SingleCommandAST singleCommand1, SingleCommandAST singleCommand2){
        this.expression = expression;
        this.singleCommand1 = singleCommand1;
        this.singleCommand2 = singleCommand2;
    }

    public ExpressionAST getExpression() {
        return expression;
    }

    public void setExpression(ExpressionAST expression) {
        this.expression = expression;
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
