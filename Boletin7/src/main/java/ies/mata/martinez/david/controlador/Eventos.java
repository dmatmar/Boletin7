package ies.mata.martinez.david.controlador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.sound.sampled.Clip;
import javax.swing.JMenu;
import javax.swing.JTextArea;

public class Eventos {
	
	//metodo para el inicio del evento y limpiar la pantalla
	public static void manejarInicioEvento(JMenu inicio, JTextArea areaTexto, boolean haReproducido, ReproductorDeSonido reproductor, Clip clip) {
        inicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == inicio) {
                    Limpiar.limpiarPantalla(areaTexto, haReproducido, reproductor);
                }
            }
        });
    }	
	
}
