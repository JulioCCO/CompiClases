import generated.AlphaParser;
import generated.AlphaParserBaseVisitor;
import org.antlr.v4.runtime.Token;

public class AContextual extends AlphaParserBaseVisitor<Object> {
    private TablaSimbolos laTabla;

    public AContextual() {
        this. laTabla = new TablaSimbolos();
    }
    @Override
    public Object visitProgramAST(AlphaParser.ProgramASTContext ctx) {
        visit(ctx.singleCommand());
        return null;
    }

    @Override
    public Object visitCommandAST(AlphaParser.CommandASTContext ctx) {
        visit(ctx.singleCommand(0));
        for (int i = 1;ctx.singleCommand().size()>i;i++){
            visit(ctx.singleCommand(i));
        }
        return null;
    }

    @Override
    public Object visitAssingnSingleCommandAST(AlphaParser.AssingnSingleCommandASTContext ctx) {
        TablaSimbolos.Ident i = laTabla.buscar(ctx.ID().getText());
        if(i==null){
            System.out.println("Error: la variable "+ctx.ID().getText()+" no ha sido declarada");
        }
        else{
            int tipoID = i.type;
            int tipoExp = (int) visit(ctx.expression());
            if(tipoExp!=i.type){
                System.out.println("Error: la variable "+ctx.ID().getText()+" no es del mismo tipo que la expresión");
            }
        }

        return null;
    }

    @Override
    public Object visitCallSingleCommandAST(AlphaParser.CallSingleCommandASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitIfSingleCommandAST(AlphaParser.IfSingleCommandASTContext ctx) {
        visit(ctx.expression());
        visit(ctx.singleCommand(0));
        if(ctx.singleCommand().size()>1){
            visit(ctx.singleCommand(1));
        }
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
        for (int i = 1;ctx.singleDeclaration().size()>i;i++){
            visit(ctx.singleDeclaration(i));
        }
        return null;
    }

    @Override
    public Object visitConstDeclarationAST(AlphaParser.ConstDeclarationASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitVarDeclarationAST(AlphaParser.VarDeclarationASTContext ctx) {
        //TODO se debe agregar try catch para controlar que no se repitan los identificadores
        try {
            Token id = ctx.ID().getSymbol();
            int idType = (int) visit(ctx.typeDenoter());
            laTabla.insertar(id, idType);
        }
        catch (Exception e){}

        return null;
    }

    @Override
    public Object visitTypeDenoterAST(AlphaParser.TypeDenoterASTContext ctx) {
        int resutl=-1;
        if(ctx.ID().getText().equals("int")){
            resutl = 0;
        }
        else{
            System.out.println("Error de tipos: "+ctx.ID().getText()+" no es un tipo válido"
                    + ctx.ID().getSymbol().getLine()+":"+ctx.ID().getSymbol().getCharPositionInLine()+")");
            throw new RuntimeException();
        }
        return resutl;
    }

    @Override
    public Object visitExpressionAST(AlphaParser.ExpressionASTContext ctx) {
        int result = -1;
        result = (int) visit(ctx.primaryExpression(0));

        visit(ctx.primaryExpression(0));
        for (int i = 1;ctx.primaryExpression().size()>i;i++){
            visit(ctx.operator(i-1));
            visit(ctx.primaryExpression(i));
        }
        return result;
    }

    @Override
    public Object visitNumPrimaryExpressionAST(AlphaParser.NumPrimaryExpressionASTContext ctx) {
        return 0;
    }

    @Override
    public Object visitIdPrimaryExpressionAST(AlphaParser.IdPrimaryExpressionASTContext ctx) {
        return null;
    }

    @Override
    public Object visitGroupPrimaryExpressionAST(AlphaParser.GroupPrimaryExpressionASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitOperator(AlphaParser.OperatorContext ctx) {
        return null;
    }
}
