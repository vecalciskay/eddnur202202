package nur.p3.net;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class LeerPaginaWeb {
    public static void main(String[] args) throws IOException {
        String url = "https://es.wikipedia.org/wiki/Autonom%C3%ADa";
        URL objUrl = new URL(url);

        String server = objUrl.getHost();
        String pagina = objUrl.getPath();
        if (objUrl.getQuery() != null)
            pagina += "?" + objUrl.getQuery();
        String cmd = "GET " + pagina;
        String scheme = objUrl.getProtocol();

        System.out.println("Protocole: " + scheme);
        System.out.println("Server: " + server);
        System.out.println("PAgina: " + pagina);
        System.out.println("Comando HTTP: " + cmd);

        Scanner sc = new Scanner(objUrl.openStream());
        //Instantiating the StringBuffer class to hold the result
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()) {
            sb.append(sc.next());
            //System.out.println(sc.next());
        }
        //Retrieving the String from the String Buffer object
        String result = sb.toString();
        System.out.println(result);
    }
}
