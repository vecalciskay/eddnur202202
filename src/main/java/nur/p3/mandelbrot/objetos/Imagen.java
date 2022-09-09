package nur.p3.mandelbrot.objetos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;

public class Imagen {
    private int ancho;
    private int alto;

    private int[][] pixeles;

    private PropertyChangeSupport observado;
    private static Logger logger = LogManager.getRootLogger();

    public Imagen(int w, int h) {
        ancho = w;
        alto = h;
        pixeles = new int[ancho][alto];
        observado = new PropertyChangeSupport(this);
    }

    public Imagen(nur.p3.imagenes.modelo.Imagen img) {
        ancho = img.getAncho();
        alto = img.getAlto();

        pixeles = new int[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                pixeles[i][j] = img.get(i,j);
            }
        }
        observado = new PropertyChangeSupport(this);
    }

    public int[][] getPixeles() {
        return pixeles;
    }

    public void setPixeles(int[][] nuevos, int w, int h) {
        pixeles = nuevos;
        ancho = w;
        alto = h;

        observado.firePropertyChange("IMAGEN", true, false);
    }

    public void cambiosRelizados() {
        observado.firePropertyChange("IMAGEN", true, false);
    }

    public int get(int i, int j) {
        return pixeles[i][j];
    }

    public void addListener(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    public void setColor(int x, int y, int r, int g, int b) {
        //pixeles[x][y] = r + g*256 + b*256*256;
        pixeles[x][y] = b | (g << 8) | (r << 16);
    }

    public void dibujar(Graphics g) {
        for (int i=0; i<ancho; i++) {
            for (int j = 0; j < alto; j++) {
                g.setColor(new Color(pixeles[i][j]));
                g.drawLine(i,j,i,j);
            }
        }
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void cargarImagen(File archivoConImagen) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(archivoConImagen);
        } catch (Exception q) {
            logger.error("No pudo cargar la imagen", q);
            return;
        }

        ancho = bi.getWidth();
        alto = bi.getHeight();

        pixeles = new int[ancho][alto];
        for (int j = 0; j < alto; j++) {
            for (int i = 0; i < ancho; i++) {
                int bgr = bi.getRGB(i, j);
                pixeles[i][j] = bgr;
            }
        }

        observado.firePropertyChange("IMAGEN", true, false);
    }
}
