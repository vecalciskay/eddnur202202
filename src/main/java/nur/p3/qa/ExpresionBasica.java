package nur.p3.qa;

public class ExpresionBasica {
    private float operadorIzquierda;
    private float operadorDerecha;
    private OperacionEnum operacion;
    private float resultado;
    private boolean resultadoCalculado;

    public ExpresionBasica(float operadorIzquierda, float operadorDerecha, OperacionEnum operacion) {
        this.operadorIzquierda = operadorIzquierda;
        this.operadorDerecha = operadorDerecha;
        this.operacion = operacion;
        this.resultadoCalculado = false;
        this.resultado = Float.MIN_VALUE;
    }

    public float getOperadorIzquierda() {
        return operadorIzquierda;
    }

    public float getOperadorDerecha() {
        return operadorDerecha;
    }

    public OperacionEnum getOperacion() {
        return operacion;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
        this.resultadoCalculado = true;
    }

    public boolean isResultadoCalculado() {
        return resultadoCalculado;
    }

    @Override
    public String toString() {
        String operacionsinResultado = operadorIzquierda + " " + operadorToString(operacion) + " " + operadorDerecha;
        if (resultadoCalculado) {
            return operacionsinResultado + " = " + resultado;
        } else {
            return operacionsinResultado;
        }
    }

    private String operadorToString(OperacionEnum operacion) {
        switch(operacion) {
            case SUMA:
                return "+";
            default:
                return "??";
        }
    }
}
