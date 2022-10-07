package nur.p3.graficoarboles;

import javax.swing.*;
import java.awt.*;

public class ArbolPanel extends JPanel {

    private DibujoArbol<String> modelo;

    public ArbolPanel(DibujoArbol<String> src) {
        modelo = src;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        modelo.dibujar(0,0, g);
    }
}
