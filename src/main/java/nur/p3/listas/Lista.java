package nur.p3.listas;

import java.util.Iterator;

public class Lista<E> implements Iterable<E> {
    protected Nodo<E> raiz;
    protected int tamano;
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

    public void adicionar(E o) {
        if (tamano == 0) {
            insertar(o);
            return;
        }
        Nodo<E> nuevo = new Nodo(o);
        Nodo<E> actual = raiz;
        while(actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        actual.setSiguiente(nuevo);
        tamano++;
    }

    public void eliminar(int pos) {
        if (pos == 0) {
            raiz = raiz.getSiguiente();
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
        tamano--;
    }

    public E buscar(E o) {
        Nodo<E> actual = raiz;
        while(actual != null) {
            if (actual.getContenido() == o)
                break;
            actual = actual.getSiguiente();
        }

        if(actual != null)
            return actual.getContenido();

        return null;
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

    @Override
    public Iterator<E> iterator() {
        return new IteradorLista<>(raiz);
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
}
