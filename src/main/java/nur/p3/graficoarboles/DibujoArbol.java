package nur.p3.graficoarboles;

import nur.p3.arboles.Arbol;

import java.awt.*;

public class DibujoArbol<E> {

    public static final int ANCHO_NODO = 50;
    public static final int ESPACIO_HORIZONTAL = 20;
    public static final int ESPACIO_VERTICAL = 20;
    private Arbol<E> modelo;
    private DibujoNodoArbol<E> raiz;

    public DibujoArbol(Arbol<E> src) {
        modelo = src;
        raiz = new DibujoNodoArbol<>(src.getRaiz());
    }

    public void dibujar(int x, int y, Graphics g) {

        raiz.dibujar(x, y, g);
    }

    static class DibujoNodoArbol<E> {
        private Arbol.Nodo<E> modelo;

        DibujoNodoArbol(Arbol.Nodo<E> src) {
            this.modelo = src;
        }

        public void dibujar(int x, int y, Graphics g) {
            if (modelo == null) {
                g.drawString("[VACIO]", x, y);
                return;
            }
            dibujarNodo(modelo, x, y, g);
        }

        private int dibujarNodo(Arbol.Nodo<E> nodo, int x, int y, Graphics g) {
            int anchoTotal = getAnchoTotal(nodo);

            int xNodo = x + anchoTotal / 2;
            int yNodo = y;



            int xHijo = x;
            int yHijo = y + ANCHO_NODO + ESPACIO_VERTICAL;
            for(Arbol.Nodo<E> hijo : nodo.getHijos()) {
                int anchoHijo = getAnchoTotal(hijo);
                g.drawLine(xNodo, yNodo + ANCHO_NODO / 2,
                        xHijo + anchoHijo / 2, yHijo + ANCHO_NODO / 2);
                dibujarNodo(hijo, xHijo, yHijo, g);
                xHijo += (anchoHijo + ESPACIO_HORIZONTAL);
            }

            g.setColor(Color.white);
            g.fillOval(xNodo - ANCHO_NODO / 2, yNodo, ANCHO_NODO, ANCHO_NODO);
            g.setColor(Color.black);
            g.drawOval(xNodo - ANCHO_NODO / 2, yNodo, ANCHO_NODO, ANCHO_NODO);
            g.drawString(nodo.getIdentificador(), xNodo , yNodo + ANCHO_NODO / 2);

            return anchoTotal;
        }

        public int getAnchoTotal(Arbol.Nodo<E> nodo) {
            if (nodo.getHijos().getTamano() == 0) {
                return ANCHO_NODO;
            }

            int ancho = 0;
            int espacio = 0;
            for(Arbol.Nodo<E> hijo : nodo.getHijos()) {
                int anchoHijo = getAnchoTotal(hijo);
                ancho = ancho + espacio + anchoHijo;
                espacio = ESPACIO_HORIZONTAL;
            }

            return ancho;
        }
    }
}
