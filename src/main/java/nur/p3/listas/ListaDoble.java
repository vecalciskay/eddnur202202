package nur.p3.listas;

import java.util.Iterator;

public class ListaDoble<E> implements Iterable<E>{

    private Nodo<E> raiz;
    private Nodo<E> cola;
    private int tamano;

    @Override
    public Iterator<E> iterator() {
        return new IteradorLista<>(raiz);
    }

    class Nodo<E> {
        private Nodo<E> siguiente;
        private Nodo<E> anterior;
        private E contenido;

        public Nodo(E o) {
            siguiente = null;
            anterior = null;
            contenido = o;
        }

        @Override
        public String toString() {
            return contenido.toString();
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }

        public E getContenido() {
            return contenido;
        }

        public void setContenido(E contenido) {
            this.contenido = contenido;
        }

        public Nodo<E> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<E> anterior) {
            this.anterior = anterior;
        }
    }

    class IteradorLista<E> implements Iterator<E> {

        private Nodo<E> siguiente;

        public IteradorLista(Nodo<E> actual) {
            this.siguiente = actual;
        }


        @Override
        public boolean hasNext() {
            return siguiente != null;
        }

        @Override
        public E next() {
            E c = siguiente.getContenido();
            siguiente = siguiente.getSiguiente();
            return c;
        }

        @Override
        public void remove() {
        }
    }

    public ListaDoble() {
        this.tamano = 0;
        this.raiz = null;
        this.cola = null;
    }

    public void insertar(E o) {
        Nodo<E> nuevo = new Nodo(o);
        nuevo.setSiguiente(raiz);
        if (raiz != null)
            raiz.setAnterior(nuevo);
        raiz = nuevo;
        tamano++;
    }

    public void adicionar(E o) {
        Nodo<E> nuevo = new Nodo(o);
        nuevo.setAnterior(cola);
        if (cola != null)
            cola.setSiguiente(nuevo);
        cola = nuevo;
        tamano++;
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }

    public int getTamano() {
        return tamano;
    }


    public void eliminar(int pos) {
        if (pos == 0) {
            raiz = raiz.getSiguiente();
            if (raiz != null)
                raiz.setAnterior(null);
            tamano--;
            return;
        }

        int i = 0;
        Nodo<E> actual = raiz;
        while(i < pos-1) {
            actual = actual.getSiguiente();
            i++;
        }

        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        if (actual.getSiguiente() != null)
            actual.getSiguiente().setAnterior(actual);
        tamano--;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();

        if (tamano == 0) {
            return "[VACIA]";
        }

        String conector = "";
        Nodo<E> actual = raiz;
        while(actual != null) {
            E c = actual.getContenido();

            resultado.append(conector).append(c);
            conector = " -> ";

            actual = actual.getSiguiente();
        }

        return resultado.toString();
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
}
