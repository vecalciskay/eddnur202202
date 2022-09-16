package nur.p3.imagenes.modelo;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Figura implements IFigura {
    protected int x;
    protected int y;
    protected PropertyChangeSupport observado;
    protected boolean seleccionado;

    @Override
    public void setSeleccionado(boolean s) {
seleccionado = s;
    }

    @Override
    public boolean isSeleccionado() {
        return seleccionado;
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
