package ies.mata.martinez.david.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ies.mata.martinez.david.vista.Login;
import ies.mata.martinez.david.vista.PopupMenuInicio;

public class EntrarButtonListener implements ActionListener {

    private Login login;

    public EntrarButtonListener(Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	//si coincide con el usuario y contraseña
        if (login.getTextField().getText().equals("javi") && new String(login.getPasswordField().getPassword()).equals("123")) {
            PopupMenuInicio ventana = new PopupMenuInicio();
            ventana.setVisible(true);
            login.dispose();
        } else {
            // Si son incorrectos, muestra un mensaje de error
            JOptionPane.showMessageDialog(login, "Nombre de usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            login.getTextField().setText(""); // Borra el contenido del campo de usuario
            login.getPasswordField().setText(""); // Borra el contenido del campo de contraseña
        }
    }
}
