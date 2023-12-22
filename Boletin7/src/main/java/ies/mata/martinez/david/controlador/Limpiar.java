package ies.mata.martinez.david.controlador;


import javax.swing.JTextArea;

public class Limpiar {

	// Método para limpiar la pantalla
	public static void limpiarPantalla(JTextArea areaTexto, Boolean haReproducido, ReproductorDeSonido reproductor) {
	  	areaTexto.setText(""); // Establece el contenido del área de texto como vacío
	    haReproducido = false; // Restablece el estado de reproducción
	    reproductor.detener(); // Detén la reproducción si está ocurriendo
	}
}
