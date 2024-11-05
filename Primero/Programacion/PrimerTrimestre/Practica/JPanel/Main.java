package Primero.Programacion.PrimerTrimestre.Practica.JPanel;

import javax.swing.*;

@SuppressWarnings("SpellCheckingInspection")
public class Main {
    /*
    hola, esto es una prueba xd
     */

    public static void main(String[] args) {
        String text = JOptionPane.showInputDialog("Nombre");
        String number = JOptionPane.showInputDialog("Numero");
        int flag = JOptionPane.showConfirmDialog(null, "Flag", "flag?", JOptionPane.YES_NO_OPTION);

        JOptionPane.showMessageDialog(null, "Datos: " + text + ", " + number + ", " + flag);



        /*showWindow(400, 200, 3, false);
        showWindow(800, 200, 3, false);
        showWindow(800, 0, 3, false);
        showWindow(1000, 400, 3, false);
        showWindow(0, 0, 3, false);
        showWindow(20, 300, 10, false);
        showWindow(400, 400, 50, false);
        showWindow(400, 200, 3, true);*/
    }

    public static void showWindow(int offsetX, int offsetY, int speed, boolean size) {
        JOptionPane optionPane = new JOptionPane("Mensaje", JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(null, "Titulo");

        int defaultSize = 300;

        Thread thread = new Thread(() -> {
            dialog.setLocation(400, 300);
            dialog.setSize(defaultSize, defaultSize);
            dialog.setVisible(true);
        });
        thread.start();

        long startTime = System.currentTimeMillis();

        Thread thread2 = new Thread(() -> {
            while (true) {
                float time = ((System.currentTimeMillis() - startTime) / 1000.0f) * speed;

                int animatedX = (int) (Math.sin(time) * 100) + offsetX;
                int animatedY = (int) (Math.cos(time) * 100) + offsetY;

                if (size) {
                    dialog.setSize(defaultSize + animatedX, defaultSize + animatedY);
                }

                if (Math.random() < 0.1f) {
                    dialog.toFront();
                }

                dialog.setLocation(animatedX, animatedY);
            }
        });
        thread2.start();
    }
}
