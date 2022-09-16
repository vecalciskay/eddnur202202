package nur.p3.listas;

public class ListaAmateur {
    private NodoAmateur raiz;
    private int tamano;
    public ListaAmateur() {
        raiz = null;
        tamano = 0;
    }

    public NodoAmateur getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAmateur raiz) {
        this.raiz = raiz;
    }

    public void insertar(Object o) {

        NodoAmateur nuevo = new NodoAmateur(o);
        nuevo.setSiguiente(this.raiz);
        raiz = nuevo;
        tamano++;
    }

    @Override
    public String toString() {
        if (raiz == null)
            return "[VACIA]";

        StringBuilder resultado = new StringBuilder();
        NodoAmateur actual = raiz;
        String conector = "";
        while(actual != null) {
            resultado.append(conector).append(actual.getContenido());
            conector = " -> ";
            actual = actual.getSiguiente();
        }

        return resultado.toString();
    }

    public int getTamano() {
        /*if (raiz == null)
            return 0;

        NodoAmateur actual = raiz;
        int tamano = 0;
        while(actual != null) {
            tamano++;
            actual = actual.getSiguiente();
        }
*/
        return tamano;
    }

    public Object get(int i) {
        if (i == 0)
            return raiz.getContenido();

        NodoAmateur actual = raiz;
        int posActual = 0;
        while(posActual < i) {
            posActual++;
            actual = actual.getSiguiente();
        }

        return actual.getContenido();
    }
}
