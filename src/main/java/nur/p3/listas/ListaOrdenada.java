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
}
