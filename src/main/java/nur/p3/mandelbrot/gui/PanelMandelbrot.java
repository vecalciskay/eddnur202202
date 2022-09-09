package nur.p3.mandelbrot.gui;

import nur.p3.mandelbrot.objetos.Imagen;
import nur.p3.mandelbrot.objetos.Mandelbrot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelMandelbrot extends JPanel implements PropertyChangeListener, MouseListener {

    private Imagen modelo;
    private Mandelbrot mandelbrot;


    public PanelMandelbrot(Mandelbrot m) {
        this.modelo = m.getImagen();
        modelo.addListener(this);

        mandelbrot = m;

        this.addMouseListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(modelo.getAncho(), modelo.getAlto());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo == null) {
            return;
        }

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

    @Override
    public void mouseClicked(MouseEvent e) {
        mandelbrot.zoomEnPlanoReal(e.getX(), e.getY());
        mandelbrot.calcularImagen();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
