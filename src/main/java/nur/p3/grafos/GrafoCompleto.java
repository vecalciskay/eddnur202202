package nur.p3.grafos;

import nur.p3.listas.Lista;

import java.util.HashMap;

public class GrafoCompleto<E> {
    private HashMap<String, Nodo<E>> nodos;

    public GrafoCompleto() {
        nodos = new HashMap<>();
    }

    public void anadirNodo(String id, E contenido) {
        Nodo<E> nuevo = new Nodo<>(id, contenido);
        nodos.put(id, nuevo);
    }

    public void conectar(String idDesde, String idHacia) {
        conectar(idDesde, idHacia, 1);
    }

    public void conectar(String idDesde, String idHacia, int peso) {
        Nodo<E> desde = nodos.get(idDesde);
        Nodo<E> hacia = nodos.get(idHacia);
        desde.anadirSaliente(hacia, peso);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Nodo<E> nodo: nodos.values()) {
            sb.append(nodo.toString());
        }
        return sb.toString();
    }

    class Nodo<E> {
        private String id;
        private E contenido;
        private Lista<Arco<E>> salientes;

        public Nodo(String id, E contenido) {
            this.contenido = contenido;
            this.id = id;
            salientes = new Lista<>();
        }

        public void anadirSaliente(Nodo<E> hacia, int peso) {
            Arco<E> nuevo = null;
            for(Arco<E> arco : salientes) {
                if (arco.getHacia() == hacia) {
                    nuevo = arco;
                    break;
                }
            }
            if (nuevo != null) {
                return;
            }

            nuevo = new Arco<>(this, hacia, peso);
            salientes.insertar(nuevo);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Arco<E> arco: salientes) {
                sb.append(arco.getDesde().getId());
                sb.append("-");
                sb.append(arco.getPeso());
                sb.append("->");
                sb.append(arco.getHacia().getId());
                sb.append("\n");
            }
            return sb.toString();
        }

        public String getId() {
            return id;
        }
    }

    class Arco<E> {
        private Nodo<E> desde;
        private Nodo<E> hacia;
        private int peso;

        public Arco(Nodo<E> desde, Nodo<E> hacia, int peso) {
            this.desde = desde;
            this.hacia = hacia;
            this.peso = peso;
        }

        public Nodo<E> getDesde() {
            return desde;
        }

        public Nodo<E> getHacia() {
            return hacia;
        }

        public int getPeso() {
            return peso;
        }

        public void setDesde(Nodo<E> desde) {
            this.desde = desde;
        }

        public void setHacia(Nodo<E> hacia) {
            this.hacia = hacia;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }
    }
}
