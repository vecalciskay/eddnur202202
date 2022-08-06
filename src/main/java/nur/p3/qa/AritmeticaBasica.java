package nur.p3.qa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AritmeticaBasica {

    private static final Logger logger = LogManager.getLogger(AritmeticaBasica.class);

    public static void main(String[] args) {

        logger.debug("Test para ver si funciona la aritmetica");

        AritmeticaBasica obj = new AritmeticaBasica();

        ExpresionBasica exp1 = obj.suma(3,8);
        System.out.println(exp1);
    }

    public AritmeticaBasica() {
        logger.debug("Constructor de la clase AritmeticaBasica");
    }

    public ExpresionBasica suma(float a, float b) {
        logger.debug("Suma de dos numeros: " + a + " + " + b);
        ExpresionBasica resultado = new ExpresionBasica(a, b, OperacionEnum.SUMA);

        float c = a + b;
        resultado.setResultado(c);

        return resultado;
    }
}
