package nur.p3.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArbolTest {

    @Test
    void insertar3NodosEmprimir() {
        // Arrange
        /*Nodo A
                Nodo B debajo de A
                Nodo C debajo de A
                Nodo E debajo de B
                Nodo F debajo de B
        */

        // Act
        String s =  a.toString();

        Assertions.assertEquals("A->(B->(E , F) , C)", s);
    }
}
