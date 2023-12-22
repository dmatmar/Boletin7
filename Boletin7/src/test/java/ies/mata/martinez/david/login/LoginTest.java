package ies.mata.martinez.david.login;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import ies.mata.martinez.david.controlador.EntrarButtonListener;
import ies.mata.martinez.david.vista.Login;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class LoginTest extends TestCase
	{
	    
	private Login login;

    @Before
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testConstructor() {
        assertNotNull(login); //verifico que la instancia login no es nula
    }

    @Test
    public void testGetTextField() {
        assertNotNull(login.getTextField()); //verifico que no devuelve un objeto nulo
    }

    @Test
    public void testGetPasswordField() {
        assertNotNull(login.getPasswordField()); //verifico que la contrasena tampoco devuelve un objeto nulo
    }

    @Test
    public void testActionPerformed_CredencialesCorrectas() {
        // Configuración del entorno de prueba
        Login login = new Login();
        JTextField textField = login.getTextField();
        JPasswordField passwordField = login.getPasswordField();

        //credenciales
        textField.setText("javi");
        passwordField.setText("123");

        // Crear el ActionListener y ejecutar actionPerformed
        EntrarButtonListener entrarButtonListener = new EntrarButtonListener(login);
        entrarButtonListener.actionPerformed(null);

        //Verificar que la nueva ventana está visible y la ventana de login está cerrada
        assertFalse(login.isVisible()); // La ventana de login debería estar cerrada

    }

	    



	    
	    
	    
	    
	    
	

}
