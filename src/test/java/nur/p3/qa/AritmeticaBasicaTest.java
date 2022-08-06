package nur.p3.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AritmeticaBasicaTest {

    @Test
    void testSuma() {
        AritmeticaBasica obj = new AritmeticaBasica();
        ExpresionBasica exp1 = obj.suma(3,8);
        Assertions.assertEquals(11, exp1.getResultado());
    }
}
