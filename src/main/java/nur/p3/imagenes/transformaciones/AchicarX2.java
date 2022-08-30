package nur.p3.imagenes.transformaciones;

import nur.p3.imagenes.modelo.Imagen;

public class AchicarX2 implements ITransformacion{

    @Override
    public Imagen transformar(Imagen img) {
        Imagen original = new Imagen(img);

        int anchoD2 = original.getAncho() / 2 + 1;
        int altoD2 = original.getAlto() / 2 + 1;
        int[][] pixelesNuevos = new int[anchoD2][altoD2];

        for (int i = 0; i < img.getAncho(); i+=2) {
            for (int j = 0; j < img.getAlto(); j+=2) {
                pixelesNuevos[i/2][j/2] = img.get(i,j);
            }
        }

        img.setPixeles(pixelesNuevos, anchoD2, altoD2);

        return img;
    }
}
