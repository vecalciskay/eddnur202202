package nur.p3.listas;

public class Lista<E> {
    private Nodo<E> raiz;
    private int tamano;
    public Lista() {
        raiz = null;
        tamano = 0;
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }

    public void insertar(E o) {

        Nodo<E> nuevo = new Nodo(o);
        nuevo.setSiguiente(this.raiz);
        raiz = nuevo;
        tamano++;
    }

    @Override
    public String toString() {
        if (raiz == null)
            return "[VACIA]";

        StringBuilder resultado = new StringBuilder();
        Nodo<E> actual = raiz;
        String conector = "";
        while(actual != null) {
            resultado.append(conector).append(actual.getContenido());
            conector = " -> ";
            actual = actual.getSiguiente();
        }

        return resultado.toString();
    }

    public int getTamano() {
        return tamano;
    }

    public E get(int i) {
        if (i == 0)
            return raiz.getContenido();

        Nodo<E> actual = raiz;
        int posActual = 0;
        while(posActual < i) {
            posActual++;
            actual = actual.getSiguiente();
        }

        return actual.getContenido();
    }

    class Nodo<E> {
        private E contenido;
        private Nodo<E> siguiente;

        public Nodo(E o) {
            this.contenido = o;
            this.siguiente = null;
        }

        public E getContenido() {
            return contenido;
        }

        public void setContenido(E contenido) {
            this.contenido = contenido;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }
    }
}
