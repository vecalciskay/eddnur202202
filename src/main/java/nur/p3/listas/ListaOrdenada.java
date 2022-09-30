package nur.p3.listas;

public class ListaOrdenada<E> extends Lista<E> {

    public ListaOrdenada() {
        super();
    }

    @Override
    public void adicionar(E o) {
        insertar(o);
    }

    @Override
    public void insertar(E o) {
        if (tamano == 0) {
            super.insertar(o);
            return;
        }

        if (!(o instanceof Comparable)) {
            super.insertar(o);
            return;
        }

        if (((Comparable)o).compareTo(raiz.getContenido()) < 0) {
            super.insertar(o);
            return;
        }

        Nodo<E> actual = raiz;
        while(actual.getSiguiente() != null &&
                ((Comparable)o).compareTo(actual.getSiguiente().getContenido()) > 0) {
            actual = actual.getSiguiente();
        }

        Nodo<E> nuevo = new Nodo(o);
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
        tamano++;
    }

    @Override
    public E buscar(E o) {
        /*
        Nodo<E> actual = raiz;

        while(actual != null) {
            if (((Comparable)o).compareTo(actual.getContenido()) == 0)
                break;
            actual = actual.getSiguiente();
        }

        if(actual != null)
            return actual.getContenido();

        return null;
        */
        return dicotomica(0, tamano, o);
    }

    public E dicotomica(int min, int max, E o)
    {
        if (min >= max) {
            return null;
        }
        // tomando en cuenta que empezamos en 0 y terminamos en tamano
        int mitad = min + (max - min) / 2;
        E p = get(mitad);

        int comparacion = ((Comparable)o).compareTo(p);
        if (comparacion < 0) {
            return dicotomica(min, mitad, o);
        }
        if (comparacion > 0) {
            return dicotomica(mitad, max, o);
        }
        return p;
    }
}
