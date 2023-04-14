import astPKG.*;
import generated.AlphaScanner;
import org.antlr.v4.runtime.Token;

import java.util.LinkedList;

public class AlphaParser2
{
    private AlphaScanner elScanner;
    private Token tokenActual;

    public AlphaParser2(AlphaScanner _scanner) {
        this.elScanner = _scanner;
        this.tokenActual = elScanner.nextToken();

    }
    // Revisa si el token es el esperado
    private void accept(int expected){
        if(this.tokenActual.getType() == expected ){
            acceptIt();
            //this.tokenActual = elScanner.nextToken();
        }else {
            throw new Error("Error, token no esperado, se recibió un: "+ expected + "en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
        }
    }
    private void acceptIt(){
        this.tokenActual = this.elScanner.nextToken();
    }

    // program ::= singleCommand
    public ProgramAST parseProgram(){
        try {
            SingleCommandAST sc = parseSingleCommand();
            ProgramAST result = new ProgramAST(sc);
            System.out.println(result);
            return result;
        } catch (Error err){
            System.err.println("Error de tipo: parseProgram, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
            return null;
        }
    }

    // command ::= singleCommand (; singleCommand)*
    public CommandAST parseCommand(){
            try {
                SingleCommandAST sc = parseSingleCommand();
                LinkedList<SingleCommandAST> scs = new LinkedList<>();
                while (this.tokenActual.getType() == AlphaScanner.Semicolon) {
                    acceptIt();
                    scs.add(parseSingleCommand());
                }
                CommandAST result = new CommandAST(sc, scs);
                return result;
            } catch (Error err){
                System.err.println("Error de tipo: parseCommand, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
                return null;
            }

    }


    public DeclarationAST parseDeclaration(){
        try {

            SingleDeclarationAST singleDeclarationAST = parseSingleDeclaration();
            LinkedList<SingleDeclarationAST> singleDeclarationASTS = new LinkedList<>();
            while (this.tokenActual.getType() == AlphaScanner.Semicolon) {
                acceptIt();
                SingleDeclarationAST singleDeclarationAST1 = parseSingleDeclaration();
                singleDeclarationASTS.add(singleDeclarationAST1);

            }
            DeclarationAST declaration = new DeclarationAST(singleDeclarationAST, singleDeclarationASTS);
            return declaration;
        }catch (Error er){
            System.err.println("Error de tipo: parseDeclaration, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
            return null;
        }
    }

    public SingleDeclarationAST parseSingleDeclaration(){
        //ocupo identifier y expression
        SingleDeclarationAST result = null;
        if(this.tokenActual.getType() == AlphaScanner.Const){
            acceptIt();
            accept(AlphaScanner.ID);
            accept(AlphaScanner.Tilde);
            Token id = this.tokenActual;
            ExpressionAST expr = parseExpression();
            result = new ConstSDAST(id, expr);

        } else if (this.tokenActual.getType() == AlphaScanner.Var){
            acceptIt();
            accept(AlphaScanner.ID);
            accept(AlphaScanner.Semicolon);
            Token id = this.tokenActual;
            TypeDenoterAST expr = parseTypeDenoter();
            result = new VarSDAST(id, expr);
        } else {
            System.err.println("Error de tipo: parseSingleDeclaration, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
            return null;
        }
        return result;
    }

    public TypeDenoterAST parseTypeDenoter(){
        if(this.tokenActual.getType() == AlphaScanner.ID){
            TypeDenoterAST typeDenoterAST = new TypeDenoterAST(this.tokenActual);
            acceptIt();
            return typeDenoterAST;
        } else {
            System.err.println("Error de tipo: parseTypeDenoter, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
            return null;
        }

    }
    public ExpressionAST parseExpression(){
        try {
            PrimaryExpressionAST expr = parsePrimaryExpression();
            LinkedList<Token> ops = new LinkedList<>();
            LinkedList<PrimaryExpressionAST> peast = new LinkedList<>();

            while(this.tokenActual.getType() == AlphaScanner.Plus || this.tokenActual.getType() == AlphaScanner.Minus
            ||this.tokenActual.getType() == AlphaScanner.Mult || this.tokenActual.getType() == AlphaScanner.Div || this.tokenActual.getType() == AlphaScanner.Mod
            || this.tokenActual.getType() == AlphaScanner.Equals || this.tokenActual.getType() == AlphaScanner.NotEquals ||this.tokenActual.getType() == AlphaScanner.LessThan
            ||this.tokenActual.getType() == AlphaScanner.GreaterThan || this.tokenActual.getType() == AlphaScanner.GreaterThanOrEquals || this.tokenActual.getType() == AlphaScanner.LessThanOrEquals){
                ops.add(this.tokenActual);
                acceptIt();
                PrimaryExpressionAST primaryExpressionAST = parsePrimaryExpression();
                peast.add(primaryExpressionAST);
            }
            return new ExpressionAST(expr, ops, peast);
        } catch (Error err){
            System.err.println("Error de tipo: parseExpression, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
            return null;
        }

    }

    public PrimaryExpressionAST parsePrimaryExpression(){
        Token id = this.tokenActual;
        if(this.tokenActual.getType() == AlphaScanner.PLAIN_TEXT){
            acceptIt();
            return new PrimaryExpressionAST(id);
        }
        else if(this.tokenActual.getType() == AlphaScanner.NUM ){
            acceptIt();
            return new PrimaryExpressionAST(id);
        }
        else if (this.tokenActual.getType() == AlphaScanner.ID){
            acceptIt();
            return new PrimaryExpressionAST(id);
        }else if(this.tokenActual.getType() == AlphaScanner.LeftParen){
            acceptIt();
            ExpressionAST expr = parseExpression();
            accept(AlphaScanner.RightParen);
            return new PrimaryExpressionAST(expr);
        }else {
            System.err.println("Error de tipo: parsePrimaryExpression, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
            return null;
        }
    }

    public void parseControlBody(){
        if(this.tokenActual.getType() == AlphaScanner.Cover){
            while(this.tokenActual.getType() == AlphaScanner.Cover){
                acceptIt();
                if(this.tokenActual.getType() == AlphaScanner.NUM || this.tokenActual.getType() == AlphaScanner.PLAIN_TEXT || this.tokenActual.getType() == AlphaScanner.Colon){
                    if(this.tokenActual.getType() != AlphaScanner.Colon){
                        acceptIt();
                        accept(AlphaScanner.Colon);
                    } else {
                        acceptIt();
                    }
                    parseCommand();
                    accept(AlphaScanner.Break);
                    accept(AlphaScanner.Semicolon);
                } else {
                    System.err.println("Error de tipo: parseControlBody, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
                }
            }
        } else {
            System.err.println("Error de tipo: parseControlBody, [Control no puede estar vacio] en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
        }

    }

    public SingleCommandAST parseSingleCommand(){
        SingleCommandAST result = null;
        if(this.tokenActual.getType() == AlphaScanner.ID){
            acceptIt();
            Token id = this.tokenActual;
            if(this.tokenActual.getType() == AlphaScanner.Assign){
                acceptIt();
                ExpressionAST expr = parseExpression();
                result = new AssignSCAST(id, expr);

            }
            else if (this.tokenActual.getType() == AlphaScanner.LeftParen) {
                acceptIt();
                ExpressionAST expr = parseExpression();
                result = new AssignSCAST(id, expr);
                accept(AlphaScanner.RightParen);
            }
            else {
                System.err.println("Error de tipo: parseSingleCommand 1, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
            }
        }
        else if(this.tokenActual.getType() == AlphaScanner.If){
            acceptIt();
            ExpressionAST expr = parseExpression();
            accept(AlphaScanner.Then);
            SingleCommandAST singleCommand1 = parseSingleCommand();
            accept(AlphaScanner.Else);
            SingleCommandAST singleCommand2 =parseSingleCommand();
            result = new IfSCAST(expr, singleCommand1, singleCommand2);
        }
        else if(this.tokenActual.getType() == AlphaScanner.While){
            acceptIt();
            ExpressionAST expr = parseExpression();
            accept(AlphaScanner.Do);
            SingleCommandAST singleCommand =parseSingleCommand();
            result = new WhileSCAST(expr, singleCommand);


        }
        else if(this.tokenActual.getType() == AlphaScanner.Let){
            acceptIt();
            DeclarationAST declarationAST = parseDeclaration();
            accept(AlphaScanner.In);
            SingleCommandAST singleCommandAST = parseSingleCommand();
            result = new LetSCAST(declarationAST, singleCommandAST);
        }
        else if(this.tokenActual.getType() == AlphaScanner.Begin){
            acceptIt();
            CommandAST command = parseCommand();
            accept(AlphaScanner.End);
            result = new BeginSCAST(command);
        }
        else if(this.tokenActual.getType() == AlphaScanner.Control){
            acceptIt();
            accept(AlphaScanner.ID);
            accept(AlphaScanner.Colon);
            parseControlBody();
        }
        else{
            System.err.println("Error de tipo: parseSingleCommand 2, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
        }


        return result;
    }


}
