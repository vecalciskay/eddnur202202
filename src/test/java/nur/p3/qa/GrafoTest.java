package nur.p3.qa;

import nur.p3.grafos.Grafo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrafoTest {

    @Test
    void construirGrafoCon2Nodos() {
        Grafo<String> g = new Grafo<>();
        g.anadirNodo("A", "Nodo A");
        g.anadirNodo("B", "Nodo B");
        g.conectar("A", "B");

        String resultado = g.toString();

        Assertions.assertEquals("A->B\n", resultado);
    }
}
