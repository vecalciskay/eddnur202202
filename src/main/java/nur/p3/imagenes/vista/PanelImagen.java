package nur.p3.imagenes.vista;

import nur.p3.imagenes.modelo.Imagen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelImagen extends JPanel implements PropertyChangeListener {

    private Imagen modelo;

    public PanelImagen(Imagen img) {

        modelo = img;
        modelo.addListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(modelo.getAncho(), modelo.getAlto());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo == null)
            return;

        BufferedImage rsm = new BufferedImage(
                modelo.getAncho(), modelo.getAlto(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rsm.createGraphics();

        modelo.dibujar(g2d);
        g.drawImage(rsm, 0, 0, null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
    }
}
