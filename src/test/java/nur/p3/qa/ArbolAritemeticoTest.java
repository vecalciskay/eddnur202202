package nur.p3.qa;

import nur.p3.arboles.ArbolAritmetico;
import nur.p3.arboles.Numero;
import nur.p3.arboles.Operacion;
import nur.p3.arboles.TipoOperacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArbolAritemeticoTest {
    @Test
    void CargaExpresionSimpleEImprime() {
        ArbolAritmetico a = new ArbolAritmetico();
        a.anadir(new Operacion(TipoOperacion.Suma), "A",null,true);
        a.anadir(new Numero(3.0),"A1","A", true);
        a.anadir(new Operacion(TipoOperacion.Resta),"B","A", false);
        a.anadir(new Numero(7.0),"B1","B", true);
        a.anadir(new Numero(5.0),"B2","B", false);

        String expresion = a.toString();

        Assertions.assertEquals("(3.0+(7.0-5.0))",expresion);
    }

    @Test
    void CargaExpresionSimpleYEvaluar() {
        ArbolAritmetico a = new ArbolAritmetico();
        a.anadir(new Operacion(TipoOperacion.Suma), "A",null,true);
        a.anadir(new Numero(3.0),"A1","A", true);
        a.anadir(new Operacion(TipoOperacion.Resta),"B","A", false);
        a.anadir(new Numero(7.0),"B1","B", true);
        a.anadir(new Numero(5.0),"B2","B", false);

        String expresion = a.toString();
        double resultado = 0;
        try {
            resultado = a.evaluar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String completo = expresion + "=" + String.valueOf(resultado);

        Assertions.assertEquals("(3.0+(7.0-5.0))=5.0",completo);
    }
}
