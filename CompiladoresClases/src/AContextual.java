import generated.AlphaParser;
import generated.AlphaParserBaseVisitor;
import org.antlr.v4.runtime.Token;

public class AContextual extends AlphaParserBaseVisitor<Object> {
    private TablaSimbolos tabla;

    public AContextual() {
        this.tabla = new TablaSimbolos();
    }

    @Override
    public Object visitProgramAST(AlphaParser.ProgramASTContext ctx) {


        visit(ctx.singleCommand());
        return null;
    }

    @Override
    public Object visitCommandAST(AlphaParser.CommandASTContext ctx) {

        visit(ctx.singleCommand(0));
        for (int i = 1; i < ctx.singleCommand().size(); i++) {
            visit(ctx.singleCommand(i));
        }

        return null;
    }

    @Override
    public Object visitAssignSingleCommandAST(AlphaParser.AssignSingleCommandASTContext ctx) {
        TablaSimbolos.Ident i = this.tabla.buscar(ctx.ID().getSymbol().getText());
        if (i == null) {
            System.out.println("Error de alcance, identificador no declarado en asignacion");
        } else {
            int tipoId = i.type;
            int tipoExpr = (int) visit(ctx.expression());
            if (tipoExpr != tipoId) {
                System.out.println("Error de tipos: Tipo de identificador: " + ctx.ID().getSymbol().getText() + " no es igual al tipo de la expresion"
                        + " en la linea: " + ctx.ID().getSymbol().getLine() + " y columna: " + ctx.ID().getSymbol().getCharPositionInLine());
            }
        }
        return null;
    }

    @Override
    public Object visitCallSingleCommandAST(AlphaParser.CallSingleCommandASTContext ctx) {

        visit(ctx.methodCall());
        return null;
    }

    @Override
    public Object visitIfSingleCommandAST(AlphaParser.IfSingleCommandASTContext ctx) {

        visit(ctx.expression());
        visit(ctx.singleCommand(0));
        if (ctx.singleCommand(1) != null) visit(ctx.singleCommand(1));

        return null;
    }

    @Override
    public Object visitWhileSingleCommandAST(AlphaParser.WhileSingleCommandASTContext ctx) {

        visit(ctx.expression());
        visit(ctx.singleCommand());
        return null;
    }

    @Override
    public Object visitLetSingleCommandAST(AlphaParser.LetSingleCommandASTContext ctx) {
        tabla.openScope();
        visit(ctx.declaration());
        tabla.imprimir();
        visit(ctx.singleCommand());
        tabla.closeScope();
        return null;
    }

    @Override
    public Object visitBlockSingleCommandAST(AlphaParser.BlockSingleCommandASTContext ctx) {

        visit(ctx.command());
        return null;
    }

    @Override
    public Object visitDeclarationAST(AlphaParser.DeclarationASTContext ctx) {

        visit(ctx.singleDeclaration(0));
        for (int i = 1; i < ctx.singleDeclaration().size(); i++) {
            visit(ctx.singleDeclaration(i));
        }
        return null;
    }

    @Override
    public Object visitConstSingleDeclarationAST(AlphaParser.ConstSingleDeclarationASTContext ctx) {

        visit(ctx.expression());
        return null;

    }

    @Override
    public Object visitVarDeclarationAST(AlphaParser.VarDeclarationASTContext ctx) {
        try {
            Token idName = ctx.ID().getSymbol();
            int idTipo = (int) visit(ctx.typeDenoter());
            this.tabla.insertar(idName, idTipo, true);
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public Object visitTypeDenoterAST(AlphaParser.TypeDenoterASTContext ctx) {
        int result = -1;
        if (ctx.ID().getText().equals("int")) result = 0;
        else if(ctx.ID().getText().equals("char")) result = 1;
        else {

            System.out.println("Error de tipos: Tipo: " + ctx.ID().getText() + " no es un tipo valido"
                    + " en la linea: " + ctx.ID().getSymbol().getLine() + " y columna: " + ctx.ID().getSymbol().getCharPositionInLine());
            throw new RuntimeException();
        }
        //visit(ctx.ID());
        return result;
    }

    @Override
    public Object visitExpressionAST(AlphaParser.ExpressionASTContext ctx) {
        int result = -1;
        result = (int) visit(ctx.primaryExpression(0));

        //HAY QEU VALIDAR LOS TIPOS DE LAS EXPERSIONES CON RESPECTO AL TIPO DEL OPERADOR
        for (int i = 1; i < ctx.primaryExpression().size(); i++) {
            visit(ctx.operator(i - 1));
            visit(ctx.primaryExpression(i));
        }

        return result;
    }

    @Override
    public Object visitNumPrimaryExpressionAST(AlphaParser.NumPrimaryExpressionASTContext ctx) {


        return 0; // 0 es entero(Int)
    }

    @Override
    public Object visitIdPrimaryExpressionAST(AlphaParser.IdPrimaryExpressionASTContext ctx) {

        return (Object) tabla.buscar(ctx.ID().getText());
    }

    @Override
    public Object visitParenthesisPrimaryExpressionAST(AlphaParser.ParenthesisPrimaryExpressionASTContext ctx) {

        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitOperator(AlphaParser.OperatorContext ctx) {

        //switch case for all operators
        switch (ctx.getClass().getSimpleName()) {
            case "+":
                System.out.println(ctx.Plus().getText());
                break;
            case "-":
                System.out.println(ctx.Minus().getText());
                break;
            case "*":
                System.out.println(ctx.Mult().getText());
                break;
            case "/":
                System.out.println(ctx.Div().getText());
                break;
            case "%":
                System.out.println(ctx.Mod().getText());
                break;
            case "==":
                System.out.println(ctx.Equals().getText());
                break;
            case "!=":
                System.out.println(ctx.NotEquals().getText());
                break;
            case "<":
                System.out.println(ctx.LessThan().getText());
                break;
            case "<=":
                System.out.println(ctx.LessThanOrEquals().getText());
                break;
            case ">":
                System.out.println(ctx.GreaterThan().getText());
                break;
            case ">=":
                System.out.println(ctx.GreaterThanOrEquals().getText());
                break;
            /*case "&&":
                System.out.println(ctx.And().getText());
                break;
            case "||":
                System.out.println(ctx.Or().getText());
                break;*/

        }
        return null;
    }

    @Override
    public Object visitActualParamAST(AlphaParser.ActualParamASTContext ctx) {
        return null;
    }

    @Override
    public Object visitMethodSingleDeclaration(AlphaParser.MethodSingleDeclarationContext ctx) {

        try {
            Token id = ctx.ID().getSymbol();
            int idType = 2;
            if(ctx.VOID() == null) idType = (int) visit(ctx.typeDenoter());
            this.tabla.insertar(id, idType, true);
            //TODO: Visita de parametros
            //TODO: Visita de cuerpo de metodo
        } catch (Exception e) {}
        return null;
    }

    @Override
    public Object visitIdDeclAST(AlphaParser.IdDeclASTContext ctx) {
        try {
            Token id = ctx.ID().getSymbol();
            int idType = (int) visit(ctx.typeDenoter());
            this.tabla.insertar(id, idType, false);
        } catch (Exception e) {}
        return null;
    }

    @Override
    public Object visitParamDeclsAST(AlphaParser.ParamDeclsASTContext ctx) {
        return null;
    }

    @Override
    public Object visitMethodCallAST(AlphaParser.MethodCallASTContext ctx) {
        int type = -1;
        TablaSimbolos.Ident i = this.tabla.buscar(ctx.ID().getSymbol().getText());
        if (i == null) {
            System.out.println("Error de alcance, metodo "+ctx.ID().getText() + " no declarado en asignacion");
        } else {
            type = i.type;
            //TODO: Verificar cantidad y tipo de parametros
        }


        return type;
    }

    @Override
    public Object visitMethodCallPrimaryExpressionAST(AlphaParser.MethodCallPrimaryExpressionASTContext ctx) {
        return super.visitMethodCallPrimaryExpressionAST(ctx);
    }

    @Override
    public Object visitCharPrimaryExpressionAST(AlphaParser.CharPrimaryExpressionASTContext ctx) {
        return 1; // 1 es char
    }

}



/*
*  void | tipo fact (id:int, id:int, id:int) begin ... end
*
* */
