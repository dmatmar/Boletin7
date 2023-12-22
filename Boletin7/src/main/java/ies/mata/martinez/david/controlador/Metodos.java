package ies.mata.martinez.david.controlador;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPopupMenu;

public class Metodos {

	 // Método para agregar un menú emergente a un componente
    public static void addPopup(Component component, final JPopupMenu popup) {
    	
        // Se agrega un MouseListener al componente
        component.addMouseListener(new MouseAdapter() {
            // Método que se ejecuta cuando se presiona el botón del ratón
            public void mousePressed(MouseEvent e) {
                // Verifica si el evento es un desencadenante para un menú emergente
                if (e.isPopupTrigger()) {
                    showMenu(e); // Muestra el menú en las coordenadas del evento
                }
            }

            // Método que se ejecuta cuando se libera el botón del ratón
            public void mouseReleased(MouseEvent e) {
                // Verifica si el evento es un desencadenante para un menú emergente
                if (e.isPopupTrigger()) {
                    showMenu(e); // Muestra el menú en las coordenadas del evento
                }
            }

            // Método para mostrar el menú en las coordenadas del evento
            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
    
    //metodo para leer el resumen del archivo
	public static String leerResumenDesdeArchivo(String rutaArchivo) {
	    //StringBuilder se utiliza para construir cadenas de caracteres de manera eficiente
	    StringBuilder contenido = new StringBuilder();
	    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
	    	 // Lee cada línea del archivo y la agrega al StringBuilder
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            contenido.append(linea).append("\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    // Convierte el contenido del StringBuilder a una cadena y la retorna
	    return contenido.toString();
	}
}