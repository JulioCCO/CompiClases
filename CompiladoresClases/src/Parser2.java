
import ast.*;
import generated.AlphaScanner;
import org.antlr.v4.runtime.Token;

import java.util.LinkedList;

public class Parser2 {
    private AlphaScanner elScanner;
    private Token tokenActual;
    public Parser2(AlphaScanner scanner){
        this.elScanner=scanner;
        this.tokenActual=elScanner.nextToken();
    }
    private void accept(int expected){
        if(this.tokenActual.getType() == expected){
            acceptIt();
        }
        else{
            throw new Error("Error accept: " + "Lo que se espera:" + expected
                    + " Lo que llego: " + this.tokenActual.getText()
                    + " Linea:" + this.tokenActual.getLine()
                    +" Columna" + this.tokenActual.getCharPositionInLine());
        }

    }

    private void acceptIt(){
        this.tokenActual=this.elScanner.nextToken();

    }

    //program ::=singleCommand
    public ProgramAST parseProgram(){
        try {
            SingleCommandAST sc = parseSingleCommand();
            ProgramAST result = new ProgramAST(sc);
            System.out.println(result);
            return result;
        } catch (Error er){
            System.err.println("Error de tipo: parseProgram, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
            return null;
        }
    }

    public CommandAST parseCommand(){
        CommandAST result = null ;
        try {
            SingleCommandAST sc1 = parseSingleCommand();
            LinkedList<SingleCommandAST> scs = new LinkedList<SingleCommandAST>();

            //parseSingleCommand();
            while (this.tokenActual.getType() == AlphaScanner.Semicolon) {
                acceptIt();
                scs.add(parseSingleCommand());
            }
            result = new CommandAST(sc1,scs);
        }catch (Error er){
            System.err.println("Error de tipo: parseCommand, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
        }
        return  result;
    }

    public SingleCommandAST parseSingleCommand(){
        SingleCommandAST result = null;
        if(this.tokenActual.getType()==AlphaScanner.ID) {
            acceptIt();
            Token id = this.tokenActual;
            if (this.tokenActual.getType() == AlphaScanner.Assign) {
                acceptIt();
                ExpressionAST expr =  parseExpression();
                result = new AsignSCAST( id, expr);

            } else if (this.tokenActual.getType() == AlphaScanner.LeftParen) {
                acceptIt();
                ExpressionAST expr = parseExpression();
                result = new AsignSCAST( id, expr);
                accept(AlphaScanner.RightParen);

            }else {
                System.out.println("Error parseSingleCommand: en ID "
                        + "Lo que se espera es:" + AlphaScanner.Assign
                        + " o "+ AlphaScanner.LeftParen
                        + " Lo que llego: " + this.tokenActual.getText()
                        + " Linea: " + this.tokenActual.getLine()
                        + " Columna: " + this.tokenActual.getCharPositionInLine());

            }
        } else if (this.tokenActual.getType() == AlphaScanner.If) {
            acceptIt();
            ExpressionAST exp = parseExpression();
            accept(AlphaScanner.Then);
            SingleCommandAST sc = parseSingleCommand();
            accept(AlphaScanner.Else);
            SingleCommandAST sc2 =parseSingleCommand();
            result = new IfSCAST(exp,sc,sc2);
        } else if (this.tokenActual.getType() == AlphaScanner.While) {
            acceptIt();
            ExpressionAST exp = parseExpression();
            accept(AlphaScanner.Do);
            SingleCommandAST sc = parseSingleCommand();
            result = new WhileSCAST(exp,sc);
        } else if (this.tokenActual.getType() == AlphaScanner.Let) {
            acceptIt();
            DeclarationAST decla = parseDeclaration();
            accept(AlphaScanner.In);
            SingleCommandAST sc = parseSingleCommand();
            result = new LetSCAST(decla,sc);
        } else if (this.tokenActual.getType() == AlphaScanner.Begin) {
            acceptIt();
            CommandAST command = parseCommand();
            accept(AlphaScanner.End);
            result = new BeginSCAST(command);
        }else if (this.tokenActual.getType() == AlphaScanner.Switch) {
            acceptIt();
            accept(AlphaScanner.LeftParen);
            accept(AlphaScanner.ID);
            accept(AlphaScanner.RightParen);
            accept(AlphaScanner.LeftBracket);
            if(this.tokenActual.getType() == AlphaScanner.Case){
                while (this.tokenActual.getType() == AlphaScanner.Case){
                    acceptIt();
                    if(this.tokenActual.getType() == AlphaScanner.Num || this.tokenActual.getType() == AlphaScanner.String ){
                        acceptIt();
                        accept(AlphaScanner.Colon);
                        parseCommand();
                        accept(AlphaScanner.Break);
                        accept(AlphaScanner.Semicolon);

                    }
                }
                accept(AlphaScanner.RightBracket);
            }
        }else {
            System.out.println("Error parseSingleCommand: " + "Lo que se espera es cualquier de estos ( ID, if, while, let, begin,Switch ) "
                    + " Lo que llego: " + this.tokenActual.getText()
                    + " Linea:" + this.tokenActual.getLine()
                    + " Columna: " + this.tokenActual.getCharPositionInLine());
        }
        return result;
    }
    public DeclarationAST parseDeclaration(){
        try {
            SingleDeclarationAST sd = parseSingleDeclaration();
            LinkedList<SingleDeclarationAST> sds = new LinkedList<SingleDeclarationAST>();
            while (this.tokenActual.getType() == AlphaScanner.Semicolon) {
                acceptIt();
                sds.add(parseSingleDeclaration());
            }
            return new DeclarationAST(sd,sds);
        }catch (Error er){
            System.err.println("Error de tipo: parseDeclaration, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
            return null;
        }
    }

    public SingleDeclarationAST parseSingleDeclaration(){
        SingleDeclarationAST result = null;
        Token id = this.tokenActual;
        if(this.tokenActual.getType() == AlphaScanner.Const){
            acceptIt();
            accept(AlphaScanner.ID);
            accept(AlphaScanner.Tilde);
            ExpressionAST exp = parseExpression();
            result = new ConstSDAST(id, exp);
            return result;
        } else if(this.tokenActual.getType() == AlphaScanner.Var){
            acceptIt();
            accept(AlphaScanner.ID);
            accept(AlphaScanner.Colon);
            TypeAST type = parseTypeDenoter();
            result = new VarSDAST(id, type);
            return result;
        }
        return null;
    }
    public TypeAST parseTypeDenoter(){
        try{
            accept(AlphaScanner.ID);
            return new TypeAST(this.tokenActual);
        }catch (Error er){
            System.err.println("Error de tipo: parseTypeDenoter, en la linea: "
                    + this.tokenActual.getLine() + ", columna: "
                    + this.tokenActual.getCharPositionInLine());
            return null;
        }
    }

    public ExpressionAST parseExpression(){
        ExpressionAST result = null;
        try {
            PrimaryExpressionAST pe = parsePrimaryExpression();
            LinkedList<PrimaryExpressionAST> pes = new LinkedList<PrimaryExpressionAST>();
            LinkedList<Token> ops = new LinkedList<Token>();
            while(this.tokenActual.getType() == AlphaScanner.Plus ||
                    this.tokenActual.getType() == AlphaScanner.Minus ||
                    this.tokenActual.getType() == AlphaScanner.Mult ||
                    this.tokenActual.getType() == AlphaScanner.Div ||
                    this.tokenActual.getType() == AlphaScanner.Mod ||
                    this.tokenActual.getType() == AlphaScanner.LessThan ||
                    this.tokenActual.getType() == AlphaScanner.GreaterThan ||
                    this.tokenActual.getType() == AlphaScanner.Equals ||
                    this.tokenActual.getType() == AlphaScanner.NotEquals ||
                    this.tokenActual.getType() == AlphaScanner.LessThanOrEquals ||
                    this.tokenActual.getType() == AlphaScanner.GreaterThanOrEquals){
                Token id = this.tokenActual;
                ops.add(id);
                acceptIt();
                pes.add(parsePrimaryExpression());
            }
            return new ExpressionAST(pe,pes,ops);
        } catch (Error err){
            System.err.println("Error de tipo: parseExpression, en la linea: "+ this.tokenActual.getLine() + ", columna: "+ this.tokenActual.getCharPositionInLine());
            return null;
        }
    }
    public PrimaryExpressionAST parsePrimaryExpression(){
        try {
            Token id = this.tokenActual;
            if (this.tokenActual.getType() == AlphaScanner.Num) {
                acceptIt();
                return new PrimaryExpressionAST(id);
            } else if (this.tokenActual.getType() == AlphaScanner.ID) {
                acceptIt();
                return new PrimaryExpressionAST(id);
            } else if (this.tokenActual.getType() == AlphaScanner.String) {
                acceptIt();
                return new PrimaryExpressionAST(id);
            } else if (this.tokenActual.getType() == AlphaScanner.LeftParen) {
                acceptIt();
                ExpressionAST exp = parseExpression();
                accept(AlphaScanner.RightParen);
                return new PrimaryExpressionAST(exp);
            }
            return null;
          }
        catch (Error er){
            System.err.println("Error de tipo: parsePrimaryExpression, en la linea: "
                    + this.tokenActual.getLine() + ", columna: "
                    + this.tokenActual.getCharPositionInLine());
            return null;
        }
    }
}
