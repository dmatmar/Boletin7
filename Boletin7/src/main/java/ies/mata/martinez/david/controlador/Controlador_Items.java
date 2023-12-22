package ies.mata.martinez.david.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

public class Controlador_Items {

	
	public static void habitos(JMenuItem jm) {
		
		// Agregar MouseListener a los elementos del menú
		jm.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            	jm.setToolTipText("Autor: Stephen Covey");
            }

            public void mouseExited(MouseEvent e) {
            	jm.setToolTipText("Haga clic para obtener información sobre Los 7 hábitos de la gente altamente efectiva");
            }
        });
		
	}
	
	public static void gigante(JMenuItem jmGigante) {
		
		// Agregar MouseListener a los elementos del menú
		jmGigante.addMouseListener(new MouseAdapter() {
	        public void mouseEntered(MouseEvent e) {
	        	jmGigante.setToolTipText("Autor: Tony Robbins");
	        }

	        public void mouseExited(MouseEvent e) {
	        	jmGigante.setToolTipText("Haga clic para obtener información sobre Despertando el gigante que llevas dentro");
	        }
	    });
		
	}
	
	public static void cleanCode(JMenuItem jmCleanCode) {
	    jmCleanCode.addMouseListener(new MouseAdapter() {
	        public void mouseEntered(MouseEvent e) {
	            jmCleanCode.setToolTipText("Autor: Robert C. Martin");
	        }

	        public void mouseExited(MouseEvent e) {
	            jmCleanCode.setToolTipText("Haga clic para obtener información sobre Clean Code");
	        }
	    });
	}

	public static void noHagasPensar(JMenuItem jmNoHagasPensar) {
	    jmNoHagasPensar.addMouseListener(new MouseAdapter() {
	        public void mouseEntered(MouseEvent e) {
	            jmNoHagasPensar.setToolTipText("Autor: Steve Krug");
	        }

	        public void mouseExited(MouseEvent e) {
	            jmNoHagasPensar.setToolTipText("Haga clic para obtener información sobre No me hagas pensar");
	        }
	    });
	}
	
	
	

	
	
	
	
	
}
