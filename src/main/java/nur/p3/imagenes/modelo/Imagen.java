package nur.p3.imagenes.modelo;

import java.awt.*;

public class Imagen {
    private int ancho;
    private int alto;

    private int[][] pixeles;

    public Imagen(int w, int h) {
        ancho = w;
        alto = h;
        pixeles = new int[ancho][alto];
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
}
