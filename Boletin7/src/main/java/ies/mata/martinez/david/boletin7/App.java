package ies.mata.martinez.david.boletin7;

import java.awt.EventQueue;

import ies.mata.martinez.david.vista.Login;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
