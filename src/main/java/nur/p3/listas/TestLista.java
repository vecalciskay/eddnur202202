package nur.p3.listas;

public class TestLista {
    public static void main(String[] args) {
        Lista<String> l = new Lista();

        System.out.println(l);

        l.insertar("Hugo");
        l.insertar("Paco");
        l.insertar("Luis");

        System.out.println(l);
        System.out.println(l.getTamano());

        System.out.println("POsiscion 1: " + l.get(1));
    }
}
