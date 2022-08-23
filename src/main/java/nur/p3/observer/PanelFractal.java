package nur.p3.observer;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelFractal extends JPanel implements PropertyChangeListener {
    private int ancho = 600;

    private int alto = 400;

    private static final long serialVersionUID = 1L;

    private Fractal objeto;

    public PanelFractal(Fractal o) {
        objeto = o;
        objeto.addListener(this);
        setPreferredSize(new Dimension(ancho, alto));
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        if (objeto != null)
            objeto.dibujar(gc);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
    }
}
