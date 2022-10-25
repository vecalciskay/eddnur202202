package nur.p3.arboles;

public class ArbolAritmetico {
    private Nodo raiz;

    public ArbolAritmetico() {
        raiz = null;
    }

    public ArbolAritmetico(String expresion) throws Exception {
        if (expresion == null || expresion.isEmpty()) {
            raiz = null;
        } else {
            raiz = new Nodo(expresion);
        }
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
        private static int cantidadNodos = 0;
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

        public Nodo(String expresion) throws Exception {
            String expresionOk = expresion.trim();
            int posSimboloPrincipal = 0;

            while(posSimboloPrincipal == 0 && expresionOk.length() > 1) {
                posSimboloPrincipal = encontrarSimboloPrincipal(expresionOk);
                if (posSimboloPrincipal == -1) {
                    // Error fatal, expresion incorrecta
                    throw new Exception("Expresion incorrecta");
                }

                if (expresionOk.length() > 1 && posSimboloPrincipal == 0) {
                    expresionOk = expresionOk.substring(1, expresionOk.length() - 1).trim();
                }
            }

            // expresionOk solamente tiene lo siguiente:
            // 1. Un numero, si es que posSimboloPrincipal == 0
            // 2. Una expresion aritemetica sin parentesis inicial y final

            if (posSimboloPrincipal == 0) {
                // Es un numero
                contenido = new Numero(Double.parseDouble(expresionOk));
                cantidadNodos++;
                identificador = "N" + String.valueOf(cantidadNodos);
                izquierda = null;
                derecha = null;
                padre = null;
                return;
            }

            // Es una operacion
            contenido = new Operacion(leerTipo(expresionOk.charAt(posSimboloPrincipal)));
            cantidadNodos++;
            identificador = "N" + String.valueOf(cantidadNodos);
            izquierda = new Nodo(expresionOk.substring(0, posSimboloPrincipal));
            izquierda.padre = this;
            derecha = new Nodo(expresionOk.substring(posSimboloPrincipal + 1));
            derecha.padre = this;
        }

        private TipoOperacion leerTipo(char c) {
            switch (c) {
                case '+':
                    return TipoOperacion.Suma;
                case '-':
                    return TipoOperacion.Resta;
                case '*':
                    return TipoOperacion.Multiplicacion;
                case '/':
                    return TipoOperacion.Division;
                default:
                    return null;
            }
        }

        /**
         * Si no encuentra y es porque hay parentesis al principio y al final
         * entonces devolver 0. Si no encuentra y conteo de parentesis no es 0
         * entonces expresion incorrecta, devolver -1.
         * Si encuentra entonces devolver la posicion.
         * @param expresionOk
         * @return
         */
        private int encontrarSimboloPrincipal(String expresionOk) {
            int pos = 0;
            int nivel = 0;
            while(pos < expresionOk.length()) {
                char simbolo = expresionOk.charAt(pos);
                if (simbolo == '(') {
                    nivel++;
                }
                if (simbolo == ')') {
                    nivel--;
                }

                if (nivel == 0 && leerTipo(simbolo) != null) {
                    break;
                }
                pos++;
            }
            // Si nivel es 0 y llegamos al final, todo bien y solamente quitar parentesis
            if (nivel == 0 && pos >= expresionOk.length()) {
                return 0;
            }
            // Si nivel es 0 y no llegamos al final, hay un simbolo principal
            if (nivel == 0 && pos < expresionOk.length()) {
                return pos;
            }
            return -1;
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
                case Multiplicacion:
                    return valorIzquierda * valorDerecha;
                case Division:
                    return valorIzquierda / valorDerecha;
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
