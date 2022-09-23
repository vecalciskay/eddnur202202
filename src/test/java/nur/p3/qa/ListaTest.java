package nur.p3.qa;

import nur.p3.listas.Lista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListaTest {

    @Test
    void adicionarTres() {
        // Arrange
        Lista<String> l = new Lista();

        l.adicionar("Hugo");
        l.adicionar("Paco");
        l.adicionar("Luis");

        // Assert
        Assertions.assertEquals(3, l.getTamano());
        Assertions.assertEquals("Hugo -> Paco -> Luis", l.toString());
    }

    @Test
    void InsertarTresYEloiminarUno() {
        // Arrange
        Lista<String> l = new Lista();

        l.insertar("Hugo");
        l.insertar("Paco");
        l.insertar("Luis");

        // Act
        l.eliminar(1);

        // Assert
        Assertions.assertEquals(2, l.getTamano());
        Assertions.assertEquals("Luis -> Hugo", l.toString());
    }

    @Test
    void InsertarTresYEloiminarElPrimero() {
        // Arrange
        Lista<String> l = new Lista();

        l.insertar("Hugo");
        l.insertar("Paco");
        l.insertar("Luis");

        // Act
        l.eliminar(0);

        // Assert
        Assertions.assertEquals(2, l.getTamano());
        Assertions.assertEquals("Paco -> Hugo", l.toString());
    }

    @Test
    void InsertarTresYEloiminarUltimo() {
        // Arrange
        Lista<String> l = new Lista();

        l.insertar("Hugo");
        l.insertar("Paco");
        l.insertar("Luis");

        // Act
        l.eliminar(2);

        // Assert
        Assertions.assertEquals(2, l.getTamano());
        Assertions.assertEquals("Luis -> Paco", l.toString());
    }
}
