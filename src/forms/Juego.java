
package forms;
import javax.swing.*;

public class Juego {

    public static void main(String[] args) {
        //Dar la bienvenida a los jugadores
        JOptionPane.showMessageDialog(null, "Bienvenido al Juego de el Tres en Raya");
        //hacer que salte una ventana que pregunte a los jugadores sus nombres para registrarlos en la partida
        String nombreJugador1 = JOptionPane.showInputDialog("Ingrese el nombre del jugador 1 ");
        String nombreJugador2 = JOptionPane.showInputDialog("Ingrese el nombre del jugador 2 ");

        //dar los valores de que el jugador 1 siempre sera "X" y el 2 siempre "O"
        String simboloJugador1 = "X";
        String simboloJugador2 = "Y";

        //mostrar mensaje de que el jugador con su nombre tiene un simbolo y el otro jugador el otro
        JOptionPane.showMessageDialog(null, nombreJugador1 + " jugara con: " + simboloJugador1 + " y " +  nombreJugador2 + " jugara con: " + simboloJugador2);

        //mostrar la ventana emergente del juego
        JFrame frame = new JFrame("Juego tres en raya");
        frame.setContentPane(new PaneldelJuego(true, nombreJugador1, nombreJugador2).panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(500, 100);
        frame.setSize(800, 600);
    }
}