package nur.p3.imagenes.vista;

import nur.p3.imagenes.modelo.Circulo;
import nur.p3.imagenes.modelo.Cuadrado;
import nur.p3.imagenes.modelo.Escena;
import nur.p3.imagenes.modelo.Imagen;
import nur.p3.imagenes.transformaciones.AchicarX2;
import nur.p3.imagenes.transformaciones.ITransformacion;
import nur.p3.imagenes.transformaciones.TonosDeGris;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Constructor;

public class VentanaImagen extends JFrame {

    private Escena modelo;
    private PanelImagen panel;

    public VentanaImagen() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarImagen();

        initMenu();

        panel = new PanelImagen(modelo);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    private void initMenu() {
        JMenuBar menubar = new JMenuBar();

        JMenu menu = new JMenu("Archivo");
        //-------------------------------------------------
        JMenuItem menuitem = new JMenuItem("Abrir");
        menuitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meuArchivo_Abrir();
            }
        });
        menu.add(menuitem);

        menubar.add(menu);

        // Menu Ver
        menu = new JMenu("Ver");
        //-------------------------------------------------
        menuitem = new JMenuItem("Histograma");
        menuitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuVer_Histograma();
            }
        });
        menu.add(menuitem);

        menubar.add(menu);

        // transformacion
        menu = new JMenu("Transofmracion");
        //-------------------------------------------
        menuitem = new JMenuItem("Achivcar");
        menuitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuTranformacion_X("AchicarX2");
            }
        });
        menu.add(menuitem);

        menuitem = new JMenuItem("Tonos de Gris");
        menuitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuTranformacion_X("TonosDeGris");
            }
        });
        menu.add(menuitem);

        menubar.add(menu);

        // objetos
        menu = new JMenu("Objetos");

        menuitem = new JMenuItem("Cuadrado");
        menuitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuObjetos_Cuadrado();
            }
        });
        menu.add(menuitem);

        menuitem = new JMenuItem("Circulo");
        menuitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuObjetos_Circulo();
            }
        });
        menu.add(menuitem);

        menubar.add(menu);

        this.setJMenuBar(menubar);
    }

    private void mnuObjetos_Circulo() {
        Circulo c = new Circulo(50,50,100);
        c.addListener(panel);
        modelo.addFigura(c);
    }

    private void mnuVer_Histograma() {
        Imagen img = modelo.getImagen();
        int[] histogramaR = new int[256];
        int[] histogramaG = new int[256];
        int[] histogramaB = new int[256];

        for (int i = 0; i < img.getAncho(); i++) {
            for (int j = 0; j < img.getAlto(); j++) {
                int color = img.get(i,j);

                // xxxx xxxx | rrrr rrrr | gggg gggg | bbbb bbbb
                int b = color & 0x000000ff;
                int g = (color & 0x0000ff00) >> 8;
                int r = (color & 0x00ff0000) >> 16;

                histogramaB[b]++;
                histogramaR[r]++;
                histogramaG[g]++;
            }
        }
    }

    private void mnuTranformacion_X(String transformacion) {
        ITransformacion objTransofrmacion = null;
        try {
            Class c = Class.forName("nur.p3.imagenes.transformaciones." + transformacion);
            Constructor constructor = c.getDeclaredConstructor();
            objTransofrmacion = (ITransformacion)constructor.newInstance();
            objTransofrmacion.transformar(modelo.getImagen());
        }
        catch(Exception q) {

        }
    }
/*
    private void meuTranformacion_TonosDeGris() {
        ITransformacion gris = new TonosDeGris();
        gris.transformar(modelo.getImagen());
    }

    private void meuTranformacion_Achicar() {
        ITransformacion achicar = new AchicarX2();
        achicar.transformar(modelo.getImagen());
    }
*/
    private void mnuObjetos_Cuadrado() {
        Cuadrado c = new Cuadrado(50,50,100);
        c.addListener(panel);
        modelo.addFigura(c);
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
        modelo.getImagen().cargarImagen(archivoConImagen);
    }

    private void inicializarImagen() {
        modelo = new Escena();

        for (int i = 0; i < 300; i++) {
            modelo.getImagen().setColor(i, 100, 255,0,0);
        }
    }

    public static void main(String[] args) {
        VentanaImagen v = new VentanaImagen();
    }
}
