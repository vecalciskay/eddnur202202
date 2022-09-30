package nur.p3.arboles;

import nur.p3.listas.Lista;

public class Arbol<E> {
    private Nodo<E> raiz;

    public Arbol() {
        raiz = null;
    }

    class Nodo<E> {
        private E contenido;
        private Lista<Nodo<E>> hijos;

        public Nodo(E o) {
            contenido = o;
            hijos = new Lista<>();
        }
    }
}
