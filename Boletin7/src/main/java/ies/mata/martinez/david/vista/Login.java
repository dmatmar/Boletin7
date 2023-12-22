package ies.mata.martinez.david.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import ies.mata.martinez.david.controlador.EntrarButtonListener;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel imagenPrincipal;
	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JButton btnEntrar;

	/**
	 * Create the frame.
	 */
	public Login() {
		// Configura la ventana
		setResizable(false);
        setTitle("Sign Up"); //titulo para la pagina
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 889, 664);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Crea un panel para la interfaz
        panel = new JPanel();
        panel.setBackground(new Color(30, 30, 30));
        panel.setBounds(0, 0, 875, 605);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(413, 193, 101, 30); // Aumenta el tama o del JLabel
        Font font = new Font("Arial", Font.BOLD, 18); // Crea una fuente con negrita y tamanioo 18
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Establece la fuente en el JLabel
        lblNewLabel.setForeground(Color.WHITE); // Cambia el color de la letra
        panel.add(lblNewLabel);
        
        lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
        lblPassword.setBounds(399, 312, 125, 30);
        panel.add(lblPassword);
        
        btnEntrar = new JButton("ENTRAR");
        btnEntrar.setForeground(Color.WHITE); //letra en blanco
        btnEntrar.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14)); //tipo de letra en negrita y tamanio
        btnEntrar.setBackground(Color.decode("#845EC2")); //color
        btnEntrar.setBounds(342, 437, 201, 67);
        panel.add(btnEntrar);
        
        textField = new JTextField();
        textField.setBounds(290, 234, 300, 50); // Aumenta el tama o del JTextField
        Font font2 = new Font("Arial", Font.BOLD, 18); // Crea una fuente con negrita y tamanioo 18
        textField.setFont(font2); // Establece la fuente en el JTextField
        textField.setForeground(Color.BLACK); // Cambia el color del texto
        panel.add(textField);
        textField.setColumns(10); //caracteres que se pueden mostrar
        
        passwordField = new JPasswordField();
        passwordField.setBounds(290, 353, 300, 50);
        passwordField.setFont(font2); // Establece la fuente en el JTextField
        passwordField.setForeground(Color.BLACK); // Cambia el color del texto
        panel.add(passwordField);
        passwordField.setColumns(10); //caracteres que se pueden mostrar
        
        //Muestra una imagen en la ventana
        imagenPrincipal = new JLabel();
        URL url = Login.class.getResource("/img/login1.png"); //he tenido que hacer esto porque no pillaba la imagen el jar runnable
        imagenPrincipal.setIcon(new ImageIcon(url));
        imagenPrincipal.setBounds(0, -30, 875, 663);
        panel.add(imagenPrincipal);
        
        //dar accion al boton de entrar
        btnEntrar.addActionListener(new EntrarButtonListener(this));

        setLocationRelativeTo(null);
        
        
        
	}
	
	// Métodos getter para acceder a los campos de texto y contraseña
    public JTextField getTextField() {
        return textField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

	public JButton getBtnEntrar() {
		// TODO Auto-generated method stub
		return btnEntrar;
	}
}