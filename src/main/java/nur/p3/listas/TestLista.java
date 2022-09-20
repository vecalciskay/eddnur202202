package nur.p3.listas;

import java.util.Iterator;

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

        Iterator<String> i = l.iterator();
        while(i.hasNext()) {
            String c = i.next();
            System.out.println("objeto en lista: " + c);
        }

        for (String c:
             l) {
            System.out.println("Foreach:" + c);
        }
    }
}
