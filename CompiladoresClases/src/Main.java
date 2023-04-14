import generated.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Tree;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        AlphaScanner inst = null;
        AlphaParser parser = null;
        //Parser2 parser2 = null;
        CharStream input = null;
        CommonTokenStream tokens = null;
        MyErrorListener errorListener = null;

        ParseTree tree;

        try {
            input = CharStreams.fromFileName("test.txt");

            inst = new AlphaScanner(input);
            //inst = new AlphaParser((TokenStream) input);

            tokens = new CommonTokenStream(inst);
            //tokens = new CommonTokenStream((TokenSource) inst);

            parser = new AlphaParser(tokens);
            //parser2 = new Parser2(inst);


            // error listener
            errorListener = new MyErrorListener();

            // removiendo el error por defecto del Scanner agregando el errorListener de la libreria
            inst.removeErrorListeners();
            inst.addErrorListener(errorListener);
            // removiendo el error por defecto del Parser agregando el errorListener de la libreria
            parser.removeErrorListeners();
            //parser.addErrorListener(errorListener);

            // program
            tree=parser.program();

            // se instancia la clase visitor
            //MyVisitor mv = new MyVisitor();
            //mv.visit(tree);

            //parser2.parseProgram();

            if(!errorListener.hasErrors()){
                System.out.println("Compilacion exitosa.\n");
                //java.util.concurrent.Future<JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(tree, parser);
                //treeGUI.get().setVisible(true);
                AContextual mv = new AContextual();
                mv.visit(tree);
            }else{
                System.out.println("Compilación fallida.");
            }

        }
        catch(Exception e){System.out.println("No hay archivo");e.printStackTrace();}

    }
}