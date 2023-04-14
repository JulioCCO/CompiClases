import generated.AlphaParser;
import generated.AlphaParserBaseVisitor;

public class MyVisitor extends AlphaParserBaseVisitor<Object> {

    @Override
    public Object visitProgramAST(AlphaParser.ProgramASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        visit(ctx.singleCommand());
        return null;
    }

    @Override
    public Object visitCommandAST(AlphaParser.CommandASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        visit(ctx.singleCommand(0));
        for (int i = 1;ctx.singleCommand().size()>i;i++){
            visit(ctx.singleCommand(i));
        }
        return null;
    }

    @Override
    public Object visitAssingnSingleCommandAST(AlphaParser.AssingnSingleCommandASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        System.out.println(ctx.ID().getSymbol().getText()+":"
                +ctx.ID().getSymbol().getLine());
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitCallSingleCommandAST(AlphaParser.CallSingleCommandASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitIfSingleCommandAST(AlphaParser.IfSingleCommandASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        visit(ctx.expression());
        visit(ctx.singleCommand(0));
        if(ctx.singleCommand().size()>1){
            visit(ctx.singleCommand(1));
        }
        return null;
    }

    @Override
    public Object visitWhileSingleCommandAST(AlphaParser.WhileSingleCommandASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        visit(ctx.expression());
        visit(ctx.singleCommand());
        return null;
    }

    @Override
    public Object visitLetSingleCommandAST(AlphaParser.LetSingleCommandASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        visit(ctx.declaration());
        visit(ctx.singleCommand());
        return null;
    }

    @Override
    public Object visitBlockSingleCommandAST(AlphaParser.BlockSingleCommandASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        visit(ctx.command());
        return null;
    }

    @Override
    public Object visitDeclarationAST(AlphaParser.DeclarationASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        visit(ctx.singleDeclaration(0));
        for (int i = 1;ctx.singleDeclaration().size()>i;i++){
            visit(ctx.singleDeclaration(i));
        }
        return null;
    }

    @Override
    public Object visitConstDeclarationAST(AlphaParser.ConstDeclarationASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitVarDeclarationAST(AlphaParser.VarDeclarationASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        visit(ctx.typeDenoter());
        return null;
    }

    @Override
    public Object visitTypeDenoterAST(AlphaParser.TypeDenoterASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        return null;
    }

    @Override
    public Object visitExpressionAST(AlphaParser.ExpressionASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        visit(ctx.primaryExpression(0));
        for (int i = 1;ctx.primaryExpression().size()>i;i++){
            visit(ctx.operator(i-1));
            visit(ctx.primaryExpression(i));
        }
        return null;
    }

    @Override
    public Object visitNumPrimaryExpressionAST(AlphaParser.NumPrimaryExpressionASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName() +"-"+ctx.Num().getSymbol().getText());
        return null;
    }

    @Override
    public Object visitIdPrimaryExpressionAST(AlphaParser.IdPrimaryExpressionASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName() +"-"+ctx.ID().getSymbol().getText());
        return null;
    }

    @Override
    public Object visitGroupPrimaryExpressionAST(AlphaParser.GroupPrimaryExpressionASTContext ctx) {
        System.out.println(ctx.getClass().getSimpleName());
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitOperator(AlphaParser.OperatorContext ctx) {
        switch (ctx.getClass().getSimpleName()) {
            case "+" -> System.out.println(ctx.getClass().getSimpleName() + "-" + ctx.Plus().getSymbol().getText());
            case "-" -> System.out.println(ctx.getClass().getSimpleName() + "-" + ctx.Minus().getSymbol().getText());
            case "*" -> System.out.println(ctx.getClass().getSimpleName() + "-" + ctx.Mult().getSymbol().getText());
            case "/" -> System.out.println(ctx.getClass().getSimpleName() + "-" + ctx.Div().getText());
            case "%" -> System.out.println(ctx.getClass().getSimpleName() + "-" + ctx.Mod().getText());
            case "==" -> System.out.println(ctx.getClass().getSimpleName() + "-" + ctx.Equals().getText());
            case "!=" -> System.out.println(ctx.getClass().getSimpleName() + "-" + ctx.NotEquals().getText());
            case "<" -> System.out.println(ctx.getClass().getSimpleName() + "-" + ctx.LessThan().getText());
            case "<=" -> System.out.println(ctx.getClass().getSimpleName() + "-" + ctx.LessThanOrEquals().getText());
            case ">" -> System.out.println(ctx.getClass().getSimpleName() + "-" + ctx.GreaterThan().getText());
            case ">=" -> System.out.println(ctx.getClass().getSimpleName() + "-" + ctx.GreaterThanOrEquals().getText());
        }
        return null;
    }
}

