package nur.p3.grafos;

import nur.p3.listas.Lista;
import java.util.HashMap;

public class Grafo<E> {
    private HashMap<String, Nodo<E>> nodos;

    public Grafo() {
        nodos = new HashMap<>();
    }

    public void anadirNodo(String id, E contenido) {
        Nodo<E> nuevo = new Nodo<>(id, contenido);
        nodos.put(id, nuevo);
    }

    public void conectar(String idDesde, String idHacia) {
        Nodo<E> desde = nodos.get(idDesde);
        Nodo<E> hacia = nodos.get(idHacia);
        desde.anadirAdyacente(hacia);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Nodo<E> nodo:
             nodos.values()) {
            sb.append(nodo.toString());
        }
        return sb.toString();
    }

    class Nodo<E> {
        private String id;
        private E contenido;
        private Lista<Nodo<E>> adyacentes;

        public Nodo(String id, E contenido) {
            this.contenido = contenido;
            this.id = id;
            adyacentes = new Lista<>();
        }

        public void anadirAdyacente(Nodo<E> hacia) {
            adyacentes.insertar(hacia);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Nodo<E> adyacente:
                 adyacentes) {
                sb.append(id);
                sb.append("->");
                sb.append(adyacente.id);
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}
