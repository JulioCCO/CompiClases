import generated.AlphaParser;
import generated.AlphaScanner;
import org.antlr.v4.runtime.*;

import java.util.ArrayList;


/**
 * Created by oviquez on 5/3/2018.
 */
public class MyErrorListener extends BaseErrorListener {

    public ArrayList<String> errorMsgs;

    public MyErrorListener ( )
    {
        this.errorMsgs = new ArrayList<String>();
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, // quien?, el objeto que reporta el error
                            Object offendingSymbol,
                            int line, // fila
                            int charPositionInLine, // columna
                            String msg, // mensaje de error // en ingles
                            RecognitionException re) {
            if (recognizer instanceof AlphaParser)
            errorMsgs.add(new String("ERROR DE PARSER - Linea "+line+":"+charPositionInLine + " " + msg));
        else if (recognizer instanceof AlphaScanner)
            errorMsgs.add(new String("ERROR DE SCANNER - Linea "+line+":"+charPositionInLine + " " + msg ));
        else
            errorMsgs.add(new String("Error excluyente"));
    }

    public boolean hasErrors ( )
    {
        return this.errorMsgs.size() > 0;
    }

    @Override
    public String toString ( )
    {
        if ( !hasErrors() ) return "0 errors";
        StringBuilder builder = new StringBuilder();
        for ( String s : errorMsgs )
        {
            builder.append ( String.format( "%s\n", s ) );
        }
        return builder.toString();
    }


}