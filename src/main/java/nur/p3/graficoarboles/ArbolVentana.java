package nur.p3.graficoarboles;

import nur.p3.arboles.Arbol;

import javax.swing.*;
import java.awt.*;

public class ArbolVentana extends JFrame {

    public ArbolVentana() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        DibujoArbol<String> modelo = inicializarArbol();
        ArbolPanel pnl = new ArbolPanel(modelo);

        this.getContentPane().add(pnl, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ArbolVentana();
    }

    private DibujoArbol<String> inicializarArbol() {
        Arbol<String> a = new Arbol<>();
        a.anadir("A", "A", null);
        a.anadir("B", "B", "A");
        a.anadir("C", "C", "A");
        a.anadir("D", "D", "A");
        a.anadir("E", "E", "B");
        a.anadir("F", "F", "B");
        a.anadir("G", "G", "B");
        a.anadir("H", "H", "D");
        a.anadir("I", "I", "D");
        a.anadir("J", "J", "H");
        a.anadir("K", "K", "H");

        DibujoArbol<String> resultado = new DibujoArbol<>(a);
        return resultado;
    }
}
