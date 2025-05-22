package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaneldelJuego extends Juego {
    JPanel panelPrincipal;
    private JButton[] botones;
    private boolean turnoX;
    private String nombrejugador1;
    private String nombrejugador2;

    // Constructor modificado para recibir los nombres de los jugadores
    public PaneldelJuego(boolean esTurnoX, String jugador1, String jugador2) {
        this.turnoX = esTurnoX; // Inicia el turno según lo que haya elegido el jugador
        this.nombrejugador1 = jugador1; // Asignación correcta de nombres
        this.nombrejugador2 = jugador2;
        //crea el panel de las dimensiones de 3x3
        panelPrincipal = new JPanel(new GridLayout(3, 3));
        //crea 9 botones para el panel
        botones = new JButton[9];

        //bucle que crea los botones desde la posicion 0 hasta 9 que los asigna a la i para que se creen y los añade al panelPrincipal
        for (int i = 0; i < 9; i++) {
            botones[i] = crearBoton();
            panelPrincipal.add(botones[i]);
        }
    }


    private JButton crearBoton() {
        JButton boton = new JButton();
        boton.setFont(new Font("Arial", Font.BOLD, 80));
        //ajustas las dimensiones de los botones
        boton.setPreferredSize(new Dimension(200, 200));
        // MouseListener es para interactuar en el panel con el Raton
        boton.addMouseListener(new MouseAdapter() {
            @Override
            //esto detecta cunado el user clica y lo pasa como un parametro
            public void mouseClicked(MouseEvent e) {
                // esto verifica que el boton no tine texto y no esta persionado, en caso de que si, no dejaria presionarlo
                if (boton.getText().equals("")) {
                    //esto añade dependiendo del turno del jugador la x o la o
                    boton.setText(turnoX ? "X" : "O");

                    if (verificarGanador()) {
                        String ganador = turnoX ? nombrejugador1 : nombrejugador2;
                        JOptionPane.showMessageDialog(panelPrincipal, "El ganador es: " + ganador);
                        reiniciarJuego();
                    }
                    turnoX = !turnoX;
                }
            }
        });
        return boton;
    }

    private boolean verificarGanador() {
        // Combinaciones ganadoras
        int[][] combinacionesGanadoras = {
                {0, 1, 2}, // Fila 1
                {3, 4, 5}, // Fila 2
                {6, 7, 8}, // Fila 3
                {0, 3, 6}, // Columna 1
                {1, 4, 7}, // Columna 2
                {2, 5, 8}, // Columna 3
                {0, 4, 8}, // Diagonal \
                {2, 4, 6}  // Diagonal /
        };

        for (int[] combinacion : combinacionesGanadoras) {
            //esto verifica que el boton esta presionado
            if (!botones[combinacion[0]].getText().equals("") &&
                    //aqui se verifica que el boton 0 tiene el mismo simbolo que el 1
                    botones[combinacion[0]].getText().equals(botones[combinacion[1]].getText()) &&
                    botones[combinacion[0]].getText().equals(botones[combinacion[2]].getText())) {
                return true; // Hay un ganador
            }
        }
        return false; // No hay ganador
    }

    private void reiniciarJuego() {
        for (JButton boton : botones) {
            boton.setText(""); // Limpia el texto de todos los botones
        }
        turnoX = true; // Reinicia el turno a X
    }
}
