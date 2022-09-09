package nur.p3.mandelbrot.objetos;

public class Mandelbrot {

    public static int ANCHO_PLANO_REAL = 600;

    private Imagen imagen;
    private double r0;
    private double rf;
    private double img0;
    private double imgf;

    public Mandelbrot() {

        imagen = new Imagen(ANCHO_PLANO_REAL, ANCHO_PLANO_REAL);

        reset();
    }

    public void reset() {
        r0 = -1.5;
        rf = 0.5;
        img0 = 1.0;
        imgf = -1.0;
    }

    public void zoomEnPlanoReal(int x, int y) {
        double a = r0 + (double)x * (rf - r0)/ANCHO_PLANO_REAL;
        double b = img0 + (double)y * (imgf - img0)/ANCHO_PLANO_REAL;

        zoom(a,b);
    }

    /**
     * El punto r,i es el punto superior izquierdo de un cuadrado que es 4 veces mas chico
     * que el cuadrado formado por r0,rf, img0,imgf
     * @param r
     * @param i
     */
    public void zoom(double r, double i) {

        double nuevor0 = r;
        double nuevorf = r + (rf - r0) / 4.0 ;
        double nuevoimg0 = i;
        double nuevoimgf = i + (imgf - img0) / 4.0;

        r0 = nuevor0;
        rf = nuevorf;
        imgf = nuevoimgf;
        img0 = nuevoimg0;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void calcularImagen() {
        for (int i = 0; i < ANCHO_PLANO_REAL; i++) {
            for (int j = 0; j < ANCHO_PLANO_REAL; j++) {
                // El punto i,j en el plano real,
                // a que punto Z (a + bi) del plano complejo corresponde
                double a = r0 + (double)i * (rf - r0)/ANCHO_PLANO_REAL;
                double b = img0 + (double)j * (imgf - img0)/ANCHO_PLANO_REAL;

                int n = calcularMandelbrot(a,b);

                this.imagen.setColor(i,j, n,n,n);
            }
        }
        this.imagen.cambiosRelizados();
    }

    private int calcularMandelbrot(double a, double b) {
        Complejo z0 = new Complejo(a,b);
        Complejo zn = new Complejo(a,b);
        int n = 0;
        while(zn.abs() < 2) {
            n++;
            if (n > 255)
                break;

            Complejo zn1 = zn.mult(zn).add(z0);
            zn = zn1;
        }

        return n;
    }
}
