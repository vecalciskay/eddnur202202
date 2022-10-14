package nur.p3.qa;

import nur.p3.arboles.Arbol;
import nur.p3.shared.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

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
        Arbol<String> a = new Arbol<>();
        a.anadir("A", "A", null);
        a.anadir("B", "B", "A");
        a.anadir("C", "C", "A");
        a.anadir("E", "E", "B");
        a.anadir("F", "F", "B");

        // Act
        String s =  a.toString();

        // Assert
        Assertions.assertEquals("A->(B->(E,F),C)", s);
    }

    @Test
    void recorrerBFS() {
        Arbol<String> a = new Arbol<>();
        a.anadir("A", "A", null);
        a.anadir("B", "B", "A");
        a.anadir("C", "C", "A");
        a.anadir("D", "D", "A");
        a.anadir("E", "E", "B");
        a.anadir("F", "F", "B");
        a.anadir("G", "G", "B");
        a.anadir("H", "H", "D");
        a.anadir("I", "I", "D");
        a.anadir("J", "J", "H");
        a.anadir("K", "K", "H");

        String bfs = a.bfs();
        Assertions.assertEquals("A,D,C,B,I,H,G,F,E,K,J", bfs);
    }

    @Test
    void recorrerDFS() {
        Arbol<String> a = new Arbol<>();
        a.anadir("A", "A", null);
        a.anadir("B", "B", "A");
        a.anadir("C", "C", "A");
        a.anadir("D", "D", "A");
        a.anadir("E", "E", "B");
        a.anadir("F", "F", "B");
        a.anadir("G", "G", "B");
        a.anadir("H", "H", "D");
        a.anadir("I", "I", "D");
        a.anadir("J", "J", "H");
        a.anadir("K", "K", "H");

        String dfs = a.dfs();
        Assertions.assertEquals("A,B,E,F,G,C,D,H,J,K,I", dfs);
    }
}
