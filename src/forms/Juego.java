package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego {
    private JPanel panelPrincipal;
    private JButton[][] botones = new JButton[3][3];
    private char turno;
    private boolean juegoTerminado = false;
    private JFrame frame;

public Juego(JFrame frame, char jugadorInicial) {
    this.frame = frame;
    this.turno = jugadorInicial;
    panelPrincipal = new JPanel(new GridLayout(3, 3));
    inicializarTablero();
}


private void inicializarTablero() {

    Font fuente = new Font("Arial", Font.BOLD, 60);

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            botones[i][j] = new JButton("");
            botones[i][j].setFont(fuente);
            botones[i][j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (juegoTerminado) return;

                    JButton boton = (JButton) e.getSource();
                    if (boton.getText().equals("")) {
                        boton.setText(String.valueOf(turno));
                        if (hayGanador()) {
                            JOptionPane.showMessageDialog(panelPrincipal, "¡Jugador " + turno + " gana!");
                            juegoTerminado = true;
                            preguntarNuevaPartida();
                        } else if (tableroLleno()) {
                            JOptionPane.showMessageDialog(panelPrincipal, "¡Empate!");
                            juegoTerminado = true;
                            preguntarNuevaPartida();
                        } else {
                            turno = (turno == 'X') ? 'O' : 'X';
                        }
                    }
                }
            });
            panelPrincipal.add(botones[i][j]);
        }
    }
}

    private boolean hayGanador() {
        for (int i = 0; i < 3; i++) {
            if (compara(botones[i][0], botones[i][1], botones[i][2])) return true;
            if (compara(botones[0][i], botones[1][i], botones[2][i])) return true;
        }

        if (compara(botones[0][0], botones[1][1], botones[2][2])) return true;
        if (compara(botones[0][2], botones[1][1], botones[2][0])) return true;

        return false;
    }

    private boolean compara(JButton b1, JButton b2, JButton b3) {
        String t1 = b1.getText();
        return !t1.equals("") && t1.equals(b2.getText()) && t1.equals(b3.getText());
    }

    private boolean tableroLleno() {
        for (JButton[] fila : botones) {
            for (JButton b : fila) {
                if (b.getText().equals("")) return false;
            }
        }
        return true;
    }

    public JPanel getPanel() {
        return panelPrincipal;
    }

    private void preguntarNuevaPartida() {
        int opcion = JOptionPane.showConfirmDialog(
                panelPrincipal,
                "¿Quieres jugar otra partida?",
                "Fin del juego",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            elegirNuevoJugadorYReiniciar();
        } else {
            frame.dispose(); // Cierra la ventana
        }
    }

    private void elegirNuevoJugadorYReiniciar() {
        String[] opciones = {"X", "O"};
        String seleccion = (String) JOptionPane.showInputDialog(
                frame,
                "Elige tu símbolo para la nueva partida:",
                "Nuevo Juego",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                "X"
        );

        if (seleccion == null) {
            frame.dispose();
            return;
        }

        turno = seleccion.charAt(0);
        reiniciarJuego();
    }

    private void reiniciarJuego() {
        for (JButton[] fila : botones) {
            for (JButton b : fila) {
                b.setText("");
            }
        }
        juegoTerminado = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] opciones = {"X", "O"};
            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "Elige tu símbolo para empezar:",
                    "Seleccionar Jugador",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    "X"
            );

            if (seleccion == null) {
                System.exit(0);
            }

            char jugadorInicial = seleccion.charAt(0);
            JFrame frame = new JFrame("Tres en Raya - Jugador " + jugadorInicial);
            Juego juego = new Juego(frame, jugadorInicial);
            frame.setContentPane(juego.getPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}