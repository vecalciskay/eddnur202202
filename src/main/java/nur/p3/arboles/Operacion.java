package nur.p3.arboles;

public class Operacion extends Termino{
    private TipoOperacion tipo;

    public Operacion(TipoOperacion op) {
        tipo = op;
    }

    @Override
    public String toString() {
        switch(tipo) {
            case Suma:
                return "+";
            case Resta:
                return "-";
            case Multiplicacion:
                return "*";
            case Division:
                return "/";
            default:
                return "err";
        }
    }

    public TipoOperacion getTipo() {
        return tipo;
    }
}
