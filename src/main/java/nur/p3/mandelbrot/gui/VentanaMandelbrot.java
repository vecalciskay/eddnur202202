package nur.p3.mandelbrot.gui;

import nur.p3.mandelbrot.objetos.Mandelbrot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMandelbrot extends JFrame {

    private PanelMandelbrot panel;
    private Mandelbrot modelo;

    public VentanaMandelbrot() {
        init();
    }

    private void init() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Mandelbrot();
        panel = new PanelMandelbrot(modelo);

        this.getContentPane().add(panel, BorderLayout.CENTER );

        JButton btn = new JButton("Calcular");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular_clicked();
            }
        });
        this.getContentPane().add(btn, BorderLayout.SOUTH);

        btn = new JButton("Reset");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnReset_clicked();
            }
        });
        this.getContentPane().add(btn, BorderLayout.NORTH);

        this.pack();
        this.setVisible(true);
    }

    private void btnReset_clicked() {
        modelo.reset();
        modelo.calcularImagen();
    }

    private void btnCalcular_clicked() {
        modelo.calcularImagen();
    }
}
