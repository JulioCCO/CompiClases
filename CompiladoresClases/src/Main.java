import generated.AlphaParser;
import generated.AlphaScanner;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {


    public static void main(String[] args) {
        AlphaScanner inst = null;
        AlphaParser parser = null;
        //AlphaParser2 parser2 = null;
        CharStream input=null;
        CommonTokenStream tokens = null;
        MyErrorListener errorListener = null;
        ParseTree tree = null;
        

        try {
            //input = CharStreams.fromFileName("control_test.txt");
            input = CharStreams.fromFileName("test.txt");
            inst = new AlphaScanner(input);
            tokens = new CommonTokenStream(inst);
            parser = new AlphaParser(tokens);
            //parser2 = new AlphaParser2(inst);

            errorListener = new MyErrorListener();
            //MyErrorHandler
            inst.removeErrorListeners();
            inst.addErrorListener(errorListener);
            parser.removeErrorListeners();
            //
            //
            parser.addErrorListener(errorListener);
            //parser2.parseProgram();
            //System.out.println("Compilación exitosa");
            tree = parser.program();

            if(!errorListener.hasErrors()){
                System.out.println("Compilación exitosa");
               // java.util.concurrent.Future<JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(tree, parser);
                //treeGUI.get().setVisible(true);
                //MyVisitor visitor = new MyVisitor();
                //visitor.visit(tree);
                AContextual visitor = new AContextual();
                visitor.visit(tree);
            } else {
                System.out.println("Compilacion fallida");
                System.out.println(errorListener.toString());
            }

/*            List<Token> listaTokens = (List<Token>) inst.getAllTokens();

            for (Token token : listaTokens) {
                System.out.println(token.toString());
            }*/
        }
        catch(Exception e){System.out.println("No hay archivo");e.printStackTrace();}

    }
}