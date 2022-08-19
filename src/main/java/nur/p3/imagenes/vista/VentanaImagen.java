package nur.p3.imagenes.vista;

import nur.p3.imagenes.modelo.Imagen;

import javax.swing.*;
import java.awt.*;

public class VentanaImagen extends JFrame {

    private Imagen modelo;

    public VentanaImagen() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarImagen();

        PanelImagen panel = new PanelImagen(modelo);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    private void inicializarImagen() {
        modelo = new Imagen(300,300);

        for (int i = 0; i < 300; i++) {
            modelo.setColor(i, 100, 255,0,0);
        }
    }

    public static void main(String[] args) {
        VentanaImagen v = new VentanaImagen();
    }
}
