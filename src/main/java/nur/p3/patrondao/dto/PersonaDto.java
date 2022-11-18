package nur.p3.patrondao.dto;

import java.sql.Date;

public class PersonaDto {
    private int id;
    private String nombre;
    private float altura;
    private Date fechaNacimiento;

    public PersonaDto(int id, String nombre, float altura, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.altura = altura;
        this.fechaNacimiento = fechaNacimiento;
    }

    public PersonaDto(String nombre, float altura, Date fechaNacimiento) {
        this(0, nombre, altura, fechaNacimiento);
    }

    @Override
    public String toString() {
        return "PersonaDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", altura=" + altura +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getFechaSql() {
        return fechaNacimiento.getYear() + "-" + (fechaNacimiento.getMonth()+1) + "-" + (fechaNacimiento.getDay()+1);
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
