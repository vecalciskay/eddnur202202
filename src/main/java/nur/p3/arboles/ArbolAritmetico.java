package nur.p3.arboles;

public class ArbolAritmetico {
    private Nodo raiz;

    public ArbolAritmetico() {
        raiz = null;
    }

    public void anadir(Termino o, String id, String idpadre, boolean izquierda) {
        Nodo nuevo = new Nodo(id, o);

        if (idpadre == null) {
            raiz = nuevo;
            return;
        }

        Nodo padre = raiz.buscar(idpadre);
        if (padre == null) {
            // excepcion horrible
            return;
        }

        if (izquierda)
            padre.setIzquierda(nuevo);
        else
            padre.setDerecha(nuevo);
    }

    @Override
    public String toString() {
        if (raiz == null)
            return "[VACIO]";
        return raiz.toString();
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public double evaluar() throws Exception {
        return raiz.evaluar();
    }


    public static class Nodo {
        private Termino contenido;
        private String identificador;
        private Nodo izquierda;
        private Nodo derecha;
        private Nodo padre;

        public Nodo(String id, Termino o) {
            identificador = id;
            contenido = o;
            izquierda = null;
            derecha = null;
            padre = null;
        }


        public Termino getContenido() {
            return contenido;
        }

        public void setContenido(Termino contenido) {
            this.contenido = contenido;
        }

        public String getIdentificador() {
            return identificador;
        }

        public Nodo getPadre() {
            return padre;
        }

        public void setPadre(Nodo padre) {
            this.padre = padre;
        }

        public Nodo getIzquierda() {
            return izquierda;
        }

        public void setIzquierda(Nodo izquierda) {
            this.izquierda = izquierda;
        }

        public Nodo getDerecha() {
            return derecha;
        }

        public void setDerecha(Nodo derecha) {
            this.derecha = derecha;
        }

        public Nodo buscar(String idpadre) {
            if (this.identificador.equals(idpadre)) {
                return this;
            }

            Nodo encontrado = null;

            if (izquierda != null) {
                encontrado = izquierda.buscar(idpadre);
                if (encontrado != null)
                    return encontrado;
            }

            if (derecha != null) {
                encontrado = derecha.buscar(idpadre);
                if (encontrado != null)
                    return encontrado;
            }
            return null;

        }

        public double evaluar() throws Exception {
            if (contenido instanceof Numero) {
                return ((Numero) contenido).getValor();
            }

            double valorIzquierda = izquierda.evaluar();
            double valorDerecha = derecha.evaluar();

            TipoOperacion op = ((Operacion)contenido).getTipo();
            switch(op) {
                case Suma:
                    return valorIzquierda + valorDerecha;
                case Resta:
                    return valorIzquierda - valorDerecha;
                default:
                    throw new Exception("No implementado");
            }
        }

        @Override
        public String toString() {
            StringBuilder resultado = new StringBuilder();


            if (izquierda == null && derecha == null) {
                resultado.append(contenido);
                return resultado.toString();
            }


            resultado.append("(");
            resultado.append(izquierda.toString());
            resultado.append(contenido);
            resultado.append(derecha.toString());
            resultado.append(")");

            return resultado.toString();
        }

    }
}
