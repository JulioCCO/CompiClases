import org.antlr.v4.runtime.*;
import java.util.LinkedList;

public class TablaSimbolos {
    LinkedList<Object> tabla;

    private int nivelActual;

    class Ident{
        Token tok;
        int type; //esto probablemente cambie a un tipo más estructurado
        int nivel;
        int valor;
        boolean isMethod;

        public Ident(Token t, int tp, boolean ism){
            tok = t;
            type = tp;
            nivel=nivelActual;
            valor = 0;
            isMethod = ism;
        }

        public void setValue(int v){
            valor = v;
        }

    }

    public TablaSimbolos() {
        tabla = new LinkedList<Object>();
        this.nivelActual=-1;
    }

    public void insertar(Token id, int tipo, boolean ism)
    {
        Ident i = new Ident(id,tipo, ism);
        tabla.addFirst(i);
    }

    public Ident buscar(String nombre)
    {
        //debe buscarse en otro orden... de atrás para adelante
        Ident temp=null;
        for(Object id : tabla)
            if (((Ident)id).tok.getText().equals(nombre))
                temp = ((Ident)id);
        return temp;
    }

    public void openScope(){
        nivelActual++;
    }

    public void closeScope(){
        //hay que sacar todos los ident del nivel que se está cerrando
        tabla.removeIf(n -> ((Ident)n).nivel == nivelActual);
        nivelActual--;
    }

    public void imprimir() {
        System.out.println("----- INICIO TABLA ------");
        for (int i = 0; i < tabla.size(); i++) {
            Token s = (Token) ((Ident) tabla.get(i)).tok;
            System.out.println("Nombre: " + s.getText() + " - " + ((Ident) tabla.get(i)).nivel + " - " + ((Ident) tabla.get(i)).type);
/*            if (s.getType() == 0) System.out.println("\tTipo: Indefinido");
            else if (s.getType() == 1) System.out.println("\tTipo: Integer\n");
            else if (s.getType() == 2) System.out.println("\tTipo: String\n");*/
        }
        System.out.println("----- FIN TABLA ------");
    }
}
