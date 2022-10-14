package nur.p3.listas;

public class Pila<E> extends Lista<E> {

    public Pila() {
        super();
    }

    public void push(E o) {
        insertar(o);
    }

    public E pop() {
        E result = raiz.getContenido();
        raiz = raiz.getSiguiente();
        tamano--;

        return result;
    }
}
