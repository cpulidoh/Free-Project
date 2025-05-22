package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego {

    private JPanel panelPrincipal;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    public Juego(){
        panelPrincipal.setPreferredSize(new Dimension(800, 800));
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido al Juego de el Tres en Raya");
        int seleccion = JOptionPane.showOptionDialog(null, "Elige una opción:", "Opciones",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new Object[]{"X", "O"}, null);

        String opcionElegida = (seleccion == 0) ? "X" : "O";
        JOptionPane.showMessageDialog(null, "Has elegido " + opcionElegida);

        JFrame frame = new JFrame("Juego tres en raya");
        frame.setContentPane(new Juego().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(500, 100);

    }




}