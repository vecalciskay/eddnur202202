package nur.p3.observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaFractal extends JFrame {
    private static final long serialVersionUID = 1L;

    public PanelFractal panel;
    private Fractal modelo;

    public static void main(String[] args) {
        VentanaFractal win = new VentanaFractal();
        win.setVisible(true);
    }

    public VentanaFractal() {
        super("Fractales");

        modelo = new Fractal(Fractal.SIERPINSKY, 3);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.init();
        pack();
    }

    private void init() {
        // Crear barra menu
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        // Crear menu Fractales
        JMenu m1 = new JMenu("Fractales");
        mb.add(m1);
        JMenuItem mi = new JMenuItem("Von Koch");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cmd_vonkoch();
            }
        });
        m1.add(mi);
        mi = new JMenuItem("Sierpinsky");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cmd_sierpinsky();
            }
        });
        m1.add(mi);

        m1.addSeparator();

        mi = new JMenuItem("Salir");
        mi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });
        m1.add(mi);
        // PanelDibujo
        panel = new PanelFractal(modelo);
        getContentPane().add(panel);
    }

    public void cmd_vonkoch() {
        System.out.println("Escogio Von Koch");
        String pr = JOptionPane.showInputDialog("Que profundidad?");

        modelo.setTipo(Fractal.VONKOCH);
        modelo.setProfundidad(Integer.parseInt(pr));
        modelo.cambio();
    }

    public void cmd_sierpinsky() {
        System.out.println("Escogio Sierpinsky");
        String pr = JOptionPane.showInputDialog("Que profundidad?");
        modelo.setTipo(Fractal.SIERPINSKY);
        modelo.setProfundidad(Integer.parseInt(pr));
        modelo.cambio();
    }

    public void salir() {
        dispose();
        System.exit(0);
    }
}
