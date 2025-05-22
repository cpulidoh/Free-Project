package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego {

    private JPanel panelPrincipal;

    public Juego(){
        panelPrincipal.setPreferredSize(new Dimension(800, 800));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Juego tres en raya");
        frame.setContentPane(new Juego().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(500, 100);
    }
}