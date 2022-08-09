package nur.p3.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AritmeticaBasicaTest {

    @Test
    void testSuma_dos_enteros() {
        AritmeticaBasica obj = new AritmeticaBasica();
        ExpresionBasica exp1 = obj.suma(3,8);
        Assertions.assertEquals(11, exp1.getResultado());
    }

    @Test
    void testSuma_positivos_y_negativos() {
        AritmeticaBasica obj = new AritmeticaBasica();
        ExpresionBasica exp1 = obj.suma(3, -8);
        Assertions.assertEquals(-5, exp1.getResultado());
    }
}
