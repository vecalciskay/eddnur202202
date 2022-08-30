package nur.p3.imagenes.vista;

import nur.p3.imagenes.modelo.Imagen;
import nur.p3.imagenes.transformaciones.AchicarX2;
import nur.p3.imagenes.transformaciones.ITransformacion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class VentanaImagen extends JFrame {

    private Imagen modelo;

    public VentanaImagen() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarImagen();

        initMenu();

        PanelImagen panel = new PanelImagen(modelo);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    private void initMenu() {
        JMenuBar menubar = new JMenuBar();

        JMenu menu = new JMenu("Archivo");

        JMenuItem menuitem = new JMenuItem("Abrir");

        menuitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meuArchivo_Abrir();
            }
        });

        menu.add(menuitem);

        menubar.add(menu);


        // transformacion
        menu = new JMenu("Transofmracion");

        menuitem = new JMenuItem("Achivcar");

        menuitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meuTranformacion_Achicar();
            }
        });

        menu.add(menuitem);

        menubar.add(menu);

        this.setJMenuBar(menubar);
    }

    private void meuTranformacion_Achicar() {
        ITransformacion achicar = new AchicarX2();
        achicar.transformar(modelo);
    }

    private void meuArchivo_Abrir() {
        String lastDir = "C:\\Users\\Docente-302\\IdeaProjects\\eddnur202202\\imagenes";
        JFileChooser inputFile = new JFileChooser();
        if (!lastDir.equals(""))
            inputFile.setCurrentDirectory(new File(lastDir));

        inputFile.showOpenDialog(this);

        if (inputFile.getSelectedFile() == null) {
            JOptionPane.showMessageDialog(this, "You must choose an image");
            return;
        }


        File archivoConImagen = inputFile.getSelectedFile();
        modelo.cargarImagen(archivoConImagen);
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
