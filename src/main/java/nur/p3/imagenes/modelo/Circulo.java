package nur.p3.imagenes.modelo;

import nur.p3.imagenes.serviicios.IDibujable;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Circulo extends Figura {


    protected int tamano;

    public Circulo(int m, int n, int t){
        x = m;
        y = n;
        tamano = t;
        observado = new PropertyChangeSupport(this);
    }

    public void addListener(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    @Override
    public void dibujar(Graphics g) {
        g.fillOval(x,y,tamano,tamano);
    }



    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public void moverA(int x, int y) {
        this.x = x;
        this.y = y;
        observado.firePropertyChange("CUADRADO", false, true);
    }

    /**
     * (x-a)^2 + (y-b)^2 < r^2
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean estaDentroDeLaFigura(int x, int y) {
        double radio = (double)tamano / 2.0;
        double cx = (double)this.x + radio;
        double cy = (double)this.y + radio;

        double izq = ((double)x - cx)*((double)x - cx) + ((double)y - cy)*((double)y - cy);
        double der = radio * radio;
        return (izq < der);
    }
}
