package nur.p3.shared;

import java.util.Date;

public class Persona implements Comparable<Persona> {
    private long ci;
    private String nombre;
    private Date fechaNacimiento;
    private int alturaCm;

    public Persona(long c, String n, Date fn, int a) {
        ci = c;
        nombre = n;
        fechaNacimiento = fn;
        alturaCm = a;
    }

    public long getCi() {
        return ci;
    }

    public void setCi(long ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getAlturaCm() {
        return alturaCm;
    }

    public void setAlturaCm(int alturaCm) {
        this.alturaCm = alturaCm;
    }

    @Override
    public int compareTo(Persona o) {
        if (this.ci < o.getCi()) {
            return -1;
        }
        if (this.ci > o.getCi()) {
            return 1;
        }
        // si es igual
        return 0;
    }

    @Override
    public String toString() {
        return nombre + " (" + ci + ")";
    }
}
