package nur.p3.qa;

import nur.p3.listas.Lista;
import nur.p3.listas.ListaOrdenada;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
