package nur.p3.listas;

public class NodoAmateur {
    private Object contenido;
    private NodoAmateur siguiente;

    public NodoAmateur(Object o) {
        this.contenido = o;
        this.siguiente = null;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public NodoAmateur getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoAmateur siguiente) {
        this.siguiente = siguiente;
    }
}
