package nur.p3.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocketServer {
    public static void main(String[] args) throws IOException {

        ServerSocket srv = new ServerSocket(7889);

        Socket clt = srv.accept();

        BufferedReader lector = new BufferedReader(new InputStreamReader(clt.getInputStream()));
        PrintWriter escitor = new PrintWriter(clt.getOutputStream());

        String entrada = lector.readLine();
        System.out.println("<<< " + entrada);

        escitor.println("Hola " + entrada);
        escitor.flush();
        System.out.println(">>> Hola " + entrada);

        escitor.close();
        lector.close();
        clt.close();
        srv.close();
    }
}
