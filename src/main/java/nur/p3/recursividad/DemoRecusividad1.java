package nur.p3.recursividad;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoRecusividad1 {
    private static Logger logger = LogManager.getLogger(DemoRecusividad1.class);
    public static void main(String[] args) {
        System.out.println(m(10));

        System.out.println(mm(10));

        System.out.println(suma(10));

        int a = 376;
        int b = 296;
        System.out.println("El mcd de " + a + ", " + b + " es " + mcd(a,b));
    }

    public static int m(int a) {
        if (a == 0)
            return 0;
        System.out.println("[m] >>> arg: a=" + a);
        return m(a-1);
    }

    public static String mm(int a) {
        if (a == 0)
            return "0";
        return String.valueOf(a) + mm(a -1);
    }

    public static int suma(int s) {
        if (s == 0)
            return 0;
        return s + suma(s-1);
    }

    public static int mcd(int a, int b) {
        int r = a % b;
        logger.debug(a + " | " + b + " = ? ... " + r);
        if (r == 0)
            return b;
        return mcd(b, r);
    }
}
