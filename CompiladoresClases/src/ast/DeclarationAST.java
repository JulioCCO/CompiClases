package ast;

import java.util.LinkedList;

public class DeclarationAST extends AST{

   private SingleDeclarationAST singleDeclaration;
    private LinkedList<SingleDeclarationAST> singleDeclarations;

    public DeclarationAST(SingleDeclarationAST singleDeclaration, LinkedList<SingleDeclarationAST> singleDeclarations) {
        this.singleDeclaration = singleDeclaration;
        this.singleDeclarations = singleDeclarations;
    }

    public SingleDeclarationAST getSingleDeclaration() {
        return singleDeclaration;
    }

    public LinkedList<SingleDeclarationAST> getSingleDeclarations() {
        return singleDeclarations;
    }

    public void setSingleDeclaration(SingleDeclarationAST singleDeclaration) {
        this.singleDeclaration = singleDeclaration;
    }

    public void setSingleDeclarations(LinkedList<SingleDeclarationAST> singleDeclarations) {
        this.singleDeclarations = singleDeclarations;
    }

}
