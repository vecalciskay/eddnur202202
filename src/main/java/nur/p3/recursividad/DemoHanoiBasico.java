package nur.p3.recursividad;

public class DemoHanoiBasico {

    public void hanoi(int de, int a, int pp, int n) {
        if (n == 1) {
            System.out.println(de + " -> " + a);
            return;
        }

        hanoi(de, pp, a, n-1);
        hanoi(de, a, pp, 1);
        hanoi(pp, a, de, n-1);
    }

    public static void main(String[] args) {
        DemoHanoiBasico h = new DemoHanoiBasico();
        h.hanoi(1,3,2,3);
    }
}
