package nur.p3.imagenes.modelo;

import nur.p3.imagenes.serviicios.IDibujable;
import nur.p3.imagenes.vista.PanelImagen;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Escena implements IDibujable {
    private Imagen imagen;
    private ArrayList<Figura> objetos;
private PropertyChangeSupport observado;

    public Escena() {
        imagen = new Imagen(400,400);
        objetos = new ArrayList<>();
        observado = new PropertyChangeSupport(this);
    }

    @Override
    public void dibujar(Graphics g) {

        if (imagen != null) {
            BufferedImage rsm = new BufferedImage(
                    imagen.getAncho(), imagen.getAlto(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = rsm.createGraphics();

            imagen.dibujar(g2d);
            g.drawImage(rsm, 0, 0, null);
        }

        for (IFigura c : objetos) {
            c.dibujar(g);
        }
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public void addFigura(Figura c) {
        objetos.add(c);
        observado.firePropertyChange("ESCENA", true, false);
    }

    public void addListener(PanelImagen panelImagen) {
        observado.addPropertyChangeListener(panelImagen);
        this.imagen.addListener(panelImagen);
        for (IFigura c:
             objetos) {
            c.addListener(panelImagen);
        }
    }

    public IFigura getObjetoSeleccionado() {
        for (IFigura c:
             objetos) {
            if (c.isSeleccionado()) return c;
        }
        return null;
    }

    public void soltarObjeto() {
        for (IFigura c:
                objetos) {
            c.setSeleccionado(false);
        }
    }

    public void seleccionarObjeto(int x, int y) {
        for (IFigura c:
             objetos) {
            if (c.estaDentroDeLaFigura(x, y))
                c.setSeleccionado(true);
        }
    }
}
