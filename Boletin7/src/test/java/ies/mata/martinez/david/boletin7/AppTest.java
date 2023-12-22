package ies.mata.martinez.david.boletin7;

import org.junit.Before;
import org.junit.Test;

import ies.mata.martinez.david.controlador.Metodos;
import ies.mata.martinez.david.vista.PopupMenuInicio;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private PopupMenuInicio popupMenuInicio;

    @Before
    public void setUp() {
        popupMenuInicio = new PopupMenuInicio();
    }

    @Test
    public void testConstructor() {
        assertNotNull(popupMenuInicio);
    }

    @Test
    public void testLeerResumenDesdeArchivo() {
        // Ruta del archivo de prueba
        String rutaArchivo = "resumenes/noHagasPensar.txt";

        // Llamar al método a probar
        String contenidoActual = Metodos.leerResumenDesdeArchivo(rutaArchivo);
        String comparo = Metodos.leerResumenDesdeArchivo(rutaArchivo);

        // Verificar que el contenido leído sea el esperado
        assertNotNull(contenidoActual); //no es nulo
        assertEquals(comparo, contenidoActual); //lo compara
    }

    
    
    
    
    
}
