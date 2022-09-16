package nur.p3.listas;

public class TestListaAmateur {
    public static void main(String[] args) {
        ListaAmateur l = new ListaAmateur();

        System.out.println(l);

        l.insertar("Hugo");
        l.insertar("Paco");
        l.insertar("Luis");
        l.insertar(new Integer(5));

        System.out.println(l);
        System.out.println(l.getTamano());

        System.out.println("POsiscion 1: " + l.get(1));
    }
}
