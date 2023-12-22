package ies.mata.martinez.david.controlador;

import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ReproductorDeSonido {

	private Clip clip;
	
	public void cargarSonido(String ruta) {
		try {
			 // Crear un objeto File con la ruta del archivo de sonido
            File archivoSonido = new File(ruta);
            // Obtener un flujo de entrada de audio desde el archivo
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivoSonido);

            // Verificar si ya hay un clip cargado y cerrarlo antes de abrir uno nuevo
            if (clip != null) {
                clip.close();
            }

            // Obtener un objeto Clip y abrir el flujo de entrada de audio
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	// Método para reproducir el sonido cargado en el clip
	public void reproducir() {
		if (clip != null) {
			clip.setFramePosition(0);
			clip.start();
		}
	}
	
	// Método para detener la reproducción del sonido y reiniciar la posición del clip
	public void detener() {
		   // Verificar si el clip está en ejecución
	    if (clip != null && clip.isRunning()) {
	    	// Detener la reproducción y reiniciar la posición del frame a 0
	        clip.stop();
	        clip.setFramePosition(0); // Reinicia la posición del clip
	    }
	}
	
	
}

