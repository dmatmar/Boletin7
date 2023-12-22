package ies.mata.martinez.utiles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Utiles {

	//estilo para un JMenuBar
	public static void stylizeMenuBar(JMenuBar menuBar) {
        menuBar.setBackground(Color.decode("#845EC2")); // Púrpura oscuro
        menuBar.setForeground(Color.WHITE);
        menuBar.setFont(new Font("Arial", Font.BOLD, 14));
    }
	
	//estilo para un JMenuItem
	public static void stylizeItem(JMenuItem menu) {
        menu.setBackground(Color.decode("#F3C5FF")); // Púrpura oscuro
        menu.setForeground(Color.BLACK);
        menu.setFont(new Font("Arial", Font.BOLD, 14));
    }
	
	//estilo para un JMenu
	public static void stylizeJMenu(JMenu menu) {
	    menu.setBackground(Color.decode("#F3C5FF")); // Color de fondo púrpura claro
	    menu.setForeground(Color.WHITE); // Color del texto negro
	    menu.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente en negrita y tamaño 14
	}

}
