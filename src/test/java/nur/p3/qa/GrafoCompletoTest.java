package nur.p3.qa;

import nur.p3.grafos.GrafoCompleto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrafoCompletoTest {
    @Test
    void construirGrafoCompletoCon2Nodos() {
        GrafoCompleto<String> g = new GrafoCompleto<>();
        g.anadirNodo("A", "Nodo A");
        g.anadirNodo("B", "Nodo B");
        g.conectar("A", "B");

        String resultado = g.toString();

        Assertions.assertEquals("A-1->B\n", resultado);
    }

    @Test
    void construirGrafoCompletoCon2ComponentesConexas() {
        GrafoCompleto<String> g = new GrafoCompleto<>();
        g.anadirNodo("A", "Nodo A");
        g.anadirNodo("I", "Nodo I");
        g.anadirNodo("X", "Nodo X");
        g.anadirNodo("U", "Nodo U");
        g.anadirNodo("B", "Nodo B");
        g.anadirNodo("M", "Nodo M");
        g.anadirNodo("S", "Nodo S");
        g.anadirNodo("R", "Nodo R");

        g.conectar("A", "I");
        g.conectar("I", "A", 4);
        g.conectar("X", "U", 2);
        g.conectar("X", "B", 5);
        g.conectar("M", "X");
        g.conectar("M", "U");
        g.conectar("M", "B", 2);
        g.conectar("M", "S", 3);
        g.conectar("R", "X", 3);
        g.conectar("S", "R");
        g.conectar("B", "U");

        String resultado = g.toString();

        Assertions.assertEquals("A-1->I\nB-1->U\nR-3->X\nS-1->R\nX-5->B\nX-2->U\nI-4->A\nM-3->S\nM-2->B\nM-1->U\nM-1->X\n", resultado);
    }
}
