package nur.p3.imagenes.transformaciones;

import nur.p3.imagenes.modelo.Imagen;

public class TonosDeGris implements ITransformacion {
    @Override
    public Imagen transformar(Imagen img) {

        for (int i = 0; i < img.getAncho(); i++) {
            for (int j = 0; j < img.getAlto(); j++) {
                int color = img.get(i,j);

                // xxxx xxxx | rrrr rrrr | gggg gggg | bbbb bbbb
                int b = color & 0x000000ff;
                int g = (color & 0x0000ff00) >> 8;
                int r = (color & 0x00ff0000) >> 16;
                // 68, 154, 98
                // Transformar a gris:
                // mayor
                int gris = (b > g && b > r) ? b : (g > b && g > r) ? g : r;
                // menor
                // NO int gris = (b < g && b < r) ? b : (g < b && g < r) ? g : r;
                // promedio
                // +- int gris = (r+g+b) / 3;
                img.setColor(i,j, gris, gris, gris);
            }
        }
        img.cambiosRelizados();
        return img;
    }
}
