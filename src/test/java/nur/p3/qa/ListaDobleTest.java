package nur.p3.qa;

import nur.p3.listas.ListaDoble;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListaDobleTest {

    @Test
    void insertarObjetoEnLista() {

        // Arrange
        ListaDoble<String> l = new ListaDoble<>();

        // Act
        l.insertar("Hugo");

        // Assert
        Assertions.assertEquals(1, l.getTamano());
    }

    @Test
    void insertarTresObjetosEnLista() {

        // Arrange
        ListaDoble<String> l = new ListaDoble<>();

        // Act
        l.insertar("Hugo");
        l.insertar("Paco");
        l.insertar("Luis");

        // Assert
        Assertions.assertEquals(3, l.getTamano());
        Assertions.assertEquals("Luis -> Paco -> Hugo", l.toString());
    }
}
