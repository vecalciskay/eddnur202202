package nur.p3.qa;

import nur.p3.listas.Lista;
import nur.p3.listas.ListaOrdenada;
import nur.p3.shared.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class ListaOrdenadaTest {

    @Test
    void InsertarTres() {
        // Arrange
        ListaOrdenada<String> l = new ListaOrdenada();

        l.insertar("Hugo");
        l.insertar("Paco");
        l.insertar("Luis");
        l.insertar("Lucas");
        l.insertar("Donald");

        // Assert
        Assertions.assertEquals(5, l.getTamano());
        Assertions.assertEquals("Donald -> Hugo -> Lucas -> Luis -> Paco", l.toString());
    }

    @Test
    void insertar3Personas() {
        ListaOrdenada<Persona> l = new ListaOrdenada<>();

        l.insertar(new Persona(6584626,"Hugo McPato", new Date(), 110));
        l.insertar(new Persona(3321584,"Paco McPato", new Date(), 120));
        l.insertar(new Persona(7654213,"Luis McPato", new Date(), 115));

        Assertions.assertEquals(3, l.getTamano());
        Assertions.assertEquals("Paco McPato (3321584) -> Hugo McPato (6584626) -> Luis McPato (7654213)", l.toString());
    }

    @Test
    void buscarEntre10Personas() {
        // Arrange
        ListaOrdenada<Persona> l = new ListaOrdenada<>();

        l.insertar(new Persona(6584626,"Hugo McPato", new Date(), 110));
        l.insertar(new Persona(3321584,"Paco McPato", new Date(), 120));
        l.insertar(new Persona(7654213,"Luis McPato", new Date(), 115));
        l.insertar(new Persona(5367541,"Alvaro McPato", new Date(), 110));
        l.insertar(new Persona(2357154,"Maria McPato", new Date(), 120));
        l.insertar(new Persona(8854241,"Carlos McPato", new Date(), 115));
        l.insertar(new Persona(6378524,"Daniela McPato", new Date(), 110));
        l.insertar(new Persona(1125478,"Jorge McPato", new Date(), 120));
        l.insertar(new Persona(3695824,"Malena McPato", new Date(), 115));
        l.insertar(new Persona(4554786,"Lucia McPato", new Date(), 115));

        // Act
        Persona p = l.buscar(new Persona(3695824,"", new Date(),0));

        Assertions.assertNotNull(p);
        Assertions.assertEquals("Malena McPato", p.getNombre());
    }
}
