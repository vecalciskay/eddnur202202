package nur.p3.imagenes.modelo;

import nur.p3.imagenes.serviicios.IDibujable;

import java.beans.PropertyChangeListener;

public interface IFigura extends IDibujable {


    public boolean estaDentroDeLaFigura(int x, int y);
    public void setSeleccionado(boolean s);
    public boolean isSeleccionado();
    public void addListener(PropertyChangeListener listener);
    public void moverA(int x, int y);
}
