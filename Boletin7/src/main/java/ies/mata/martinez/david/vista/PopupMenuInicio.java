package ies.mata.martinez.david.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import ies.mata.martinez.david.controlador.Controlador_Items;
import ies.mata.martinez.david.controlador.Eventos;
import ies.mata.martinez.david.controlador.Limpiar;
import ies.mata.martinez.david.controlador.ReproductorDeSonido;
import ies.mata.martinez.david.controlador.Metodos;
import ies.mata.martinez.utiles.Utiles;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class PopupMenuInicio extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String informacionAplicacion="";
	private JMenu acercade, inicio, jmSuperacionPersonal, jmProgramacion;
	private JMenuItem aplicacion, jmiHabitos, jmiDespertandoGigante, jmiCleanCode, jmiNoHagasPensar;
	private JTextArea areaTexto;
	private Clip clip;
	private JLabel btnReproducir, btnDetener;
	private ReproductorDeSonido reproductor;
	private JPanel panel;
	private JScrollPane scrollPane;
	private Boolean haReproducido = false;

	/**
	 * Create the frame.
	 */
	public PopupMenuInicio() {
		setResizable(false);
		setTitle("Menu Principal");
		informacionAplicacion="Esta es una aplicacion sobre resúmenes de libros \n";
		informacionAplicacion+="Puedes reproducir el sonido del texto en el botón del sonido\n";
		informacionAplicacion+="y pausarlo en el botón de pausar\n";
		informacionAplicacion+="Espero que le guste el proyecto. \n";
		informacionAplicacion+="Realizado por David Mata Martínez. \n";

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 889, 664);
		
		//Creación y configuración de la barra de menú
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//llamo al stilo del JmenuBar
		Utiles.stylizeMenuBar(menuBar);
		
	    //Menús y submenús
		inicio = new JMenu("Inicio");
		menuBar.add(inicio);
		
		jmSuperacionPersonal = new JMenu("Superación Personal");
		menuBar.add(jmSuperacionPersonal);
		
		jmiHabitos = new JMenuItem("Los 7 hábitos de la gente altamente efectiva");
		jmSuperacionPersonal.add(jmiHabitos);
		
		jmiDespertandoGigante = new JMenuItem("Despertando el gigante que llevas dentro");
		jmSuperacionPersonal.add(jmiDespertandoGigante);
		
		jmProgramacion = new JMenu("Programación");
		menuBar.add(jmProgramacion);
		
		jmiCleanCode = new JMenuItem("Clean Code");
		jmProgramacion.add(jmiCleanCode);
		
		jmiNoHagasPensar = new JMenuItem("No me hagas pensar");
		jmProgramacion.add(jmiNoHagasPensar);
		
		acercade = new JMenu("Acerca de");
		menuBar.add(acercade);
		
		  
		aplicacion = new JMenuItem("Aplicacion");
		acercade.add(aplicacion);
	    aplicacion.addActionListener(this);
	    
	    //Configuración del panel principal
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Configuración del panel secundario
		panel = new JPanel();
        panel.setBounds(0, 0, 875, 605);
        contentPane.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#FEFEDF")); // Púrpura oscuro
        
        // Boton de reproducción del sonido
		btnReproducir = new JLabel("");
		URL url = Login.class.getResource("/img/sonido1.png");
		btnReproducir.setIcon(new ImageIcon(url));
		btnReproducir.setBounds(796, 22, 57, 63);
		panel.add(btnReproducir);
	
		// Llama al método para personalizar el menú
		Utiles.stylizeJMenu(inicio); 
		Utiles.stylizeJMenu(acercade); 
		Utiles.stylizeJMenu(jmSuperacionPersonal); 
		Utiles.stylizeJMenu(jmProgramacion); 
		
		//doy estilo a los items
		Controlador_Items.habitos(jmiHabitos);
		Controlador_Items.gigante(jmiDespertandoGigante);
		Controlador_Items.cleanCode(jmiCleanCode);
		Controlador_Items.noHagasPensar(jmiNoHagasPensar);
		
		// Creación del reproductor de sonido
		reproductor = new ReproductorDeSonido();

		//Area de texto para mostrar los resúmenes
		areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setBackground(Color.decode("#00C9A7")); // Lila claro

        //Estilización de los elementos de la interfaz
        Utiles.stylizeItem(aplicacion);
        Utiles.stylizeItem(jmiHabitos);
        Utiles.stylizeItem(jmiHabitos);
        Utiles.stylizeItem(jmiDespertandoGigante);
        Utiles.stylizeItem(jmiCleanCode);
        Utiles.stylizeItem(jmiNoHagasPensar);
        
        //Manejo de eventos del ratón para los menús
		agregarMouseListenerAJMenu(inicio);
		agregarMouseListenerAJMenu(jmSuperacionPersonal);
		agregarMouseListenerAJMenu(jmProgramacion);
		
		//Atajos de teclado para los resúmenes
		jmiHabitos.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		jmiDespertandoGigante.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		jmiCleanCode.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		jmiNoHagasPensar.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		
		// Establecer el formato del texto
		Font font = new Font("Arial", Font.BOLD, 16);
		
		// Boton de detencion del sonido
		btnDetener = new JLabel("");
		URL url2 = Login.class.getResource("/img/detener1.png");
		btnDetener.setIcon(new ImageIcon(url2));
		btnDetener.setBounds(796, 94, 62, 55);
		panel.add(btnDetener);
		areaTexto.setFont(font);

		scrollPane = new JScrollPane(areaTexto);
		// Establecer la política de la barra de desplazamiento vertical
		scrollPane.setBounds(10, 10, 751, 529);
		panel.add(scrollPane);
		
		
		// Agrega el ActionListener para el botón "Inicio"
		Eventos.manejarInicioEvento(inicio, areaTexto, haReproducido, reproductor, clip);
		
		btnDetener.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
	        	if (haReproducido) {
	                reproductor.detener();
	            } else {
	            	mostrarMensaje("No se ha reproducido ninguna canción para detener.");
	            }
		    }
		});
		
		// Agregar accion al boton visualizar habitos
		jmiHabitos.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			// Crear instancia de VentanaDialogo

		    // Verifica si el evento proviene del JMenuItem "Hábitos"
		    if (e.getSource() == jmiHabitos) {
					// Establecer el formato del texto
					areaTexto.setForeground(Color.BLACK);
					
				// Muestra el resumen desde el archivo "habitos.txt"
		    	  mostrarResumenDesdeArchivo("resumenes/habitos.txt");
		    	  
		    	  btnReproducir.addMouseListener(new MouseAdapter() {
		    		    @Override
		    		    public void mouseClicked(MouseEvent e) {
		    		    	// Verifica si ya hay un sonido en reproducción
		    	            if (clip != null) {
		    	            	// Cierra el sonido
		    	                clip.close();
		    	            }else {
		    	            	 // Carga el sonido desde el archivo "repro_habitos.wav"
		    		             reproductor.cargarSonido("sounds/repro_habitos.wav");
		    		             // Reproduce el sonido
		    		             reproductor.reproducir();
		    		             // Marca que se ha reproducido un sonido
		    		             haReproducido = true;
		    		         }
		    		    }
		    		});
		    	}
			}
		});
		
		// Agregar accion al boton volver
		jmiDespertandoGigante.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			// Crear instancia de VentanaDialogo

			if (e.getSource() == jmiDespertandoGigante) {
					areaTexto.setForeground(Color.RED);
			     mostrarResumenDesdeArchivo("resumenes/gigante.txt");
			     
			     
			     btnReproducir.addMouseListener(new MouseAdapter() {
		    		    @Override
		    		    public void mouseClicked(MouseEvent e) {
		    	            if (clip != null) {
		    	                clip.close();
		    	            }else {
		    		             reproductor.cargarSonido("sounds/repro_despierta.wav");
		    		             reproductor.reproducir();
		    		             haReproducido = true;
		    		         }
		    		    }
		    		});
		    	}
			}
		});
		
		// Agregar acci n al boton volver
		jmiCleanCode.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			// Crear instancia de VentanaDialogo

			if (e.getSource() == jmiCleanCode) {
				areaTexto.setForeground(Color.DARK_GRAY);
			     mostrarResumenDesdeArchivo("resumenes/cleanCode.txt");
			     
			     btnReproducir.addMouseListener(new MouseAdapter() {
		    		    @Override
		    		    public void mouseClicked(MouseEvent e) {
		    	            if (clip != null) {
		    	                clip.close();
		    	            }else {
		    		             reproductor.cargarSonido("sounds/repro_cleancode.wav");
		    		             reproductor.reproducir();
		    		             haReproducido = true;
		    		         }
		    		    }
		    		});
		    	}
			}
		});
		

		// Agregar acci n al boton volver
		jmiNoHagasPensar.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			// Crear instancia de VentanaDialogo

			if (e.getSource() == jmiNoHagasPensar) {
				areaTexto.setForeground(Color.BLACK);
			     mostrarResumenDesdeArchivo("resumenes/noHagasPensar.txt");
			     
			     btnReproducir.addMouseListener(new MouseAdapter() {
		    		    @Override
		    		    public void mouseClicked(MouseEvent e) {
		    	            if (clip != null) {
		    	                clip.close();
		    	            }else {
		    		             reproductor.cargarSonido("sounds/repro_pensar.wav");
		    		             reproductor.reproducir();
		    		             haReproducido = true;
		    		         }
		    		    }
		    		});
		    	}
			}
		});
		
		 addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                confirmarSalida();
	            }
	        });
		
		inicializarMenuContextual();
		setLocationRelativeTo(null);
	}
	
	private void agregarMouseListenerAJMenu(JMenu menu) {
	    menu.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseEntered(MouseEvent e) {
	            // Desencadena el evento de clic cuando el ratón entra en el JMenu
	            menu.doClick();
	        }
	    });
	}
	
	//accion al evento de acercaDe
	public void actionPerformed(ActionEvent evento) {
		
	 if (evento.getSource() == aplicacion) {
	        JOptionPane.showMessageDialog(null, informacionAplicacion, "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
	   	}
		
	}
	
	public void mostrarResumenDesdeArchivo(String rutaArchivo) {
	    String resumen = Metodos.leerResumenDesdeArchivo(rutaArchivo);
	    areaTexto.setText(resumen);
	    // Establecer la posición del cursor al principio
	    areaTexto.setCaretPosition(0);
	
	}

	//menu contextual si hago click derecho
	private void inicializarMenuContextual() {
	    JPopupMenu menuContextual = new JPopupMenu();

	    JMenuItem detenerSonido = new JMenuItem("Detener Sonido");
	    detenerSonido.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	//controlo si es true y detiene el sonido
	        	if (haReproducido == true) {
	                reproductor.detener();
	            } else {
	                mostrarMensaje("No se ha reproducido ninguna canción para detener.");
	            }
	      
	        }
	    });
	    JMenuItem reproducirSonido = new JMenuItem("Reproducir Sonido");
	    reproducirSonido.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	//si se ha reproducido un sonido anterior se podrá reproducir cuando se detenga
	        	if (haReproducido == true) {
	                reproductor.reproducir();
	        	}else {
	        		 mostrarMensaje("No se ha reproducido ninguna canción para volver a reproducir.");
	        	}
	        }
	    });
	    
	    JMenuItem limpiarPantalla = new JMenuItem("Limpiar Pantalla");
	    limpiarPantalla.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	//llamo al metodo limpiar pantalla
	        	Limpiar.limpiarPantalla(areaTexto, haReproducido, reproductor);
	        }
	    });

	    menuContextual.add(detenerSonido);
	    menuContextual.add(reproducirSonido);
	    menuContextual.add(limpiarPantalla);

	    // Añadir el menú contextual a tu panel principal
	    Metodos.addPopup(areaTexto, menuContextual);
	}
	
	//metodo para mensajes de informacion al usuario
	private void mostrarMensaje(String mensaje) {
	    JOptionPane.showMessageDialog(this, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
	}
	
	 // Método para mostrar un cuadro de diálogo de confirmación antes de salir
    private void confirmarSalida() {
        int resultado = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que quieres salir?",
                "Confirmar Salida",
                JOptionPane.YES_NO_OPTION
        );

        if (resultado == JOptionPane.YES_OPTION) {
            // Si el usuario elige "Sí", cierra la aplicación
            dispose();
        }else {
        	// Si el usuario elige "No", cancela el cierre de la ventana
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
	
}
