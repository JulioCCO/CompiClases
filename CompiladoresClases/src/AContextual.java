import generated.AlphaParser;
import generated.AlphaParserBaseVisitor;
import org.antlr.v4.runtime.Token;

public class AContextual extends AlphaParserBaseVisitor<Object> {
    private TablaSimbolos laTabla;

    public AContextual() {
        this.laTabla = new TablaSimbolos();
    }
    private String showType(int type){
        switch(type){
            case 0: return "int";
            case 1: return "char";
            case 2: return "void";
            default: return "none";
        }
    }
    private String showErrorPosition(Token t){
        return " Fila: "+t.getLine() + " , Columna: " + (t.getCharPositionInLine()+1);
    }
    private boolean isMultitype(String op){
        switch (op){
            case "==": return true;
            case "!=": return true;
            default:  return false;
        }
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
        try {
            TablaSimbolos.Ident i = this.laTabla.buscar(ctx.ID().getText());
            if (i == null)
                System.out.println("Error de alcances, identificador \"" + ctx.ID().getText() + "\" no declarado en asignación." + showErrorPosition(ctx.ID().getSymbol()));
            else {
                int tipoID = i.type;
                int tipoExpr = (int) visit(ctx.expression());
                if (tipoID != tipoExpr)//o al menos compatibles
                    System.out.println("Error de tipos: \""+ showType(tipoID) + "\" y \"" + showType(tipoExpr) + "\" no son compatibles." + showErrorPosition(ctx.Assign().getSymbol()));
            }
        }
        catch (RuntimeException e) {}

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
        if (ctx.singleCommand().size()>1)
            visit(ctx.singleCommand(1));
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
        laTabla.openScope();
        visit(ctx.declaration());
        laTabla.imprimir();
        visit(ctx.singleCommand());
        laTabla.closeScope();
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
        /*
            try {
            Token id = ctx.ID().getSymbol();
            if(this.laTabla.buscar(ctx.ID().getText()) != null){
                System.out.println("Error de alcances, variable "+ctx.ID().getText()+" ya declarada." + showErrorPosition(ctx.ID().getSymbol()));
                throw new RuntimeException();
            }
            int idType = (int) visit(ctx.typeDenoter());
            this.laTabla.insertar(id, idType,false);
        } catch (Exception e){}
    * */

    @Override
    public Object visitConstDeclarationAST(AlphaParser.ConstDeclarationASTContext ctx) {
        try {
            int result = (int) visit(ctx.expression());
            Token id = ctx.ID().getSymbol();
            if(this.laTabla.buscar(ctx.ID().getText()) != null){
                System.out.println("Error de alcances, variable "+ctx.ID().getText()+" ya declarada." + showErrorPosition(ctx.ID().getSymbol()));
                throw new RuntimeException();
            }else{
                if (result == 0)
                    this.laTabla.insertar(id, result, false);
                else if (result == 1)
                    this.laTabla.insertar(id, result, false);
                else
                    System.out.println("Error de tipos: Tipo de constante no válido." + showErrorPosition(ctx.ID().getSymbol()));
            }
        }catch (Exception e){}
        return null;
    }

    @Override
    public Object visitVarDeclarationAST(AlphaParser.VarDeclarationASTContext ctx) {

        visit(ctx.idDeclaration());
        return null;
    }


    @Override
    public Object visitTypeDenoterAST(AlphaParser.TypeDenoterASTContext ctx) {
        int result=-1;
        if (ctx.ID().getText().equals("int"))
            result = 0;
        else if (ctx.ID().getText().equals("char"))
            result = 1;
        else {
            System.out.println("Error de tipos: Tipo: \"" + ctx.ID().getText() + "\" no es un tipo válido." + showErrorPosition(ctx.ID().getSymbol()));
            throw new RuntimeException();
        }
        return result;
    }

    @Override
    public Object visitExpressionAST(AlphaParser.ExpressionASTContext ctx) {
        int result = -1;
        String op="";
        result = (int) visit(ctx.primaryExpression(0));
        for (int i = 1; ctx.primaryExpression().size() > i; i++) {
            op = (String) visit(ctx.operator(i-1));
            int type2 = (int) visit(ctx.primaryExpression(i));
            if (isMultitype(op)){ //el operador es multitipo (char, int ...)
                if ((result==0&&type2==0) || (result==1&&type2==1))
                    result= type2; //si el operador recibiera dos tipos iguales pero devolviera otro, debe de cambiarse
                else
                    System.out.println("Error de tipos: "+showType(result)+ " y " + showType(type2) + " no son compatibles para el operador "+ op + "." + showErrorPosition(ctx.operator(i-1).start));
            }
            else { //el operador es solo para int
                if ((result==0&&type2==0))
                    result= type2;
                else
                    System.out.println("Error de tipos: "+showType(result)+ " y " + showType(type2) + " no son compatibles para el operador "+ op + "." + showErrorPosition(ctx.operator(i-1).start));
            }

        }
        return result;
    }

    @Override
    public Object visitNumPrimaryExpressionAST(AlphaParser.NumPrimaryExpressionASTContext ctx) {
        return 0; // 0 es entero(Int)
    }

    @Override
    public Object visitIdPrimaryExpressionAST(AlphaParser.IdPrimaryExpressionASTContext ctx) {
        int tipo=-1;
        TablaSimbolos.Ident id = laTabla.buscar(ctx.ID().getText());
        if (id!=null){
            if (!id.isMethod)
                tipo = id.type;
            else {
                System.out.println("Error de tipos: " + ctx.ID().getText() + " no es una variable/constante." + showErrorPosition(ctx.ID().getSymbol()));
                throw new RuntimeException();
            }
        }
        else {
            System.out.println("Error de Alcances: \""+ ctx.ID().getText() + "\" no declarado." + showErrorPosition(ctx.ID().getSymbol()));
            throw new RuntimeException();
        }
        return tipo;
    }

    @Override
    public Object visitGroupPrimaryExpressionAST(AlphaParser.GroupPrimaryExpressionASTContext ctx) {

        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitOperator(AlphaParser.OperatorContext ctx) {
        return ctx.getChild(0).getText(); //solo hay un hijo independientemente del operador que sea
    }

    @Override
    public Object visitActualParamAST(AlphaParser.ActualParamASTContext ctx) {
        return null;
    }

    @Override
    public Object visitMethodDeclarationAST(AlphaParser.MethodDeclarationASTContext ctx) {
        try {
            Token id = ctx.ID().getSymbol();
            int idType = 2;
            if (ctx.Void() == null)
                idType = (int) visit(ctx.typeDenoter());
            this.laTabla.insertar(id, idType,true);

            //TODO: visita de parámetros

            //TODO: visita de cuerpo de metodo
        } catch (Exception e){}
        return null;
    }



    @Override
    public Object visitIdDeclAST(AlphaParser.IdDeclASTContext ctx) {
        try {
            Token id = ctx.ID().getSymbol();
            if(this.laTabla.buscar(ctx.ID().getText()) != null){
                System.out.println("Error de alcances, variable "+ctx.ID().getText()+" ya declarada." + showErrorPosition(ctx.ID().getSymbol()));
                throw new RuntimeException();
            }
            int idType = (int) visit(ctx.typeDenoter());
            this.laTabla.insertar(id, idType,false);
        } catch (Exception e){}
        return null;
    }

    @Override
    public Object visitParamDeclsAST(AlphaParser.ParamDeclsASTContext ctx) {
        return null;
    }

    @Override
    public Object visitMethodCallAST(AlphaParser.MethodCallASTContext ctx) {
        int type = -1;
        TablaSimbolos.Ident i = this.laTabla.buscar(ctx.ID().getSymbol().getText());
        if (i == null) {
            System.out.println("Error de alcance, metodo "+ctx.ID().getText() + " no declarado en asignacion");
        } else {
            type = i.type;
            //TODO: Verificar cantidad y tipo de parametros
        }
        return type;
    }

    @Override
    public Object visitCallPrimaryExpressionAST(AlphaParser.CallPrimaryExpressionASTContext ctx) {
        visit(ctx.methodCall());
        return null;
    }
    @Override
    public Object visitCharPrimaryExpressionAST(AlphaParser.CharPrimaryExpressionASTContext ctx) {
        return 1; // 1 es char
    }

}

