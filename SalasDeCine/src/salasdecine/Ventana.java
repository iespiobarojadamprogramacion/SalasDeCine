package salasdecine;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ventana extends JFrame {
	//VARIABLES PARA ITEM DEL JMENU
	private JMenuItem gestionPeliculaAltaPeliJMenuItem;
	
	////VARIABLES PARA ITEM DEL JMENU
	private JMenuItem gestionSalaMostrarSalasJMenuItem;
	private JMenuItem gestionSalaSalasLibresJMenuItem;
	private JMenuItem gestionSalaMostrarSalasOcupadasJMenuItem;
	
	//VARIABLES DE JMENUITEM PARA EL MENU
	private JMenuItem gestionFuncionDarAltaJMenuItem;
	private JMenuItem gestionFuncionConsultarDispFuncion;
	private JMenuItem gestionFuncionAgregarEntradaFuncion;
	private JMenuItem gestionFuncionMostrarAsientos;
	
	//VARIABLES DE JMENUITEM PARA EL MENU DE GESTION CLIENTE
	private JMenuItem gestionClienteRegistrarClienteJMenuItem;
	private JMenuItem gestionClienteDatosClienteJMenuItem;
	private JMenuItem gestionClienteListaClienteJMenuItem;
	
	//VARIABLES DE JMENUITEM PARA EL MENU DE GESTION ENTRADAS
	private JMenuItem gestionEntradaVenderEntradaJMenuItem;
	private JMenuItem gestionEntradaMostrarEntradasFuncionJMenuItem;
	private JMenuItem gestionEntradaCancelarEntradaJMenuItem;
	private JMenuItem gestionEntradaConsultarEntradaClienteJMenuItem;
	private JMenuItem gestionEntradaCancelarMiEntradaJMenuItem;
	

	
	public Ventana() {
		super("Sala de cine");
		//X Y Y EL TAMAÑO 
		setBounds (100, 100,600, 500);
		setVisible(true);
		//TENEMOS QUE CREAR EL MENU EN ESTA VENTANA
		//PARA CREAR UN MENU SIEMPRE TENEMOS QUE CREAR UN OBJETO LLAMADO MENU BAR, ESE OBJETO MENUBAR
		//HAY QUE ASOCIARLA AL FRAME
		//CUANDO ME CREE UN MENU BAR VA A COLGAR DE UN JMENU QUE SE LLAMARA X POR EJEMPLO Y SERA UNA OPCION
		//DEL MENU
		//CUANDO CREAS UN MENU BAR TIENES QUE ASOCIAR AL JFRAME CON UN METODO QUE TIENE
		//Y ESE MENU ITEM SE ASOCIA AL MENU
		//
		//CREAR MENU BARRA
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//Y LO ASOCIO ESTA OPCION AL MENUBAR (SON OPCIONES QUE IRAN APARECIENDO ARRIBA)
		
		/*"1 GESTION PELICULA\n" + "2 GESTION SALA\n" + "3 GESTION FUNCION\n"
		+ "4 GESTION CLIENTE\n 5 GESTION ENTRADAS\n"*/
		
		//CREAR OPCIONES DEL MENUBARRA
		JMenu cineJMenuPelicula = new JMenu ("Gestion Pelicula");
		menuBar.add(cineJMenuPelicula);		
		JMenu cineJMenuSala = new JMenu ("Gestion Sala");
		menuBar.add(cineJMenuSala);
		JMenu cineJMenuFuncion = new JMenu ("Gestion Funcion");
		menuBar.add(cineJMenuFuncion);
		JMenu cineJMenuCliente = new JMenu ("Gestion Cliente");
		menuBar.add(cineJMenuCliente);
		JMenu cineJMenuEntrada = new JMenu ("Gestion Entrada");
		menuBar.add(cineJMenuEntrada);
		
		//DECLARAMOS LOS JMenuItem PARA CADA OPCIONES QUE TIENE EL JMenu
		//LAS VARIABLES ESTAN ARRIBA Y AQUI LA INSTANCIAMOS
		gestionPeliculaAltaPeliJMenuItem= new JMenuItem("Dar de alta pelicula");
		cineJMenuPelicula.add(gestionPeliculaAltaPeliJMenuItem);
		gestionSalaMostrarSalasJMenuItem= new JMenuItem ("Mostrar todas las salas");
		cineJMenuSala.add(gestionSalaMostrarSalasJMenuItem);
		gestionSalaSalasLibresJMenuItem= new JMenuItem("Salas Libres");
		cineJMenuSala.add(gestionSalaSalasLibresJMenuItem);
		gestionSalaMostrarSalasOcupadasJMenuItem= new JMenuItem("Mostrar salas ocupadas");
		cineJMenuSala.add(gestionSalaMostrarSalasOcupadasJMenuItem);
		
		gestionFuncionDarAltaJMenuItem = new JMenuItem("Dar de alta funcion");
		cineJMenuFuncion.add(gestionFuncionDarAltaJMenuItem);
		gestionFuncionConsultarDispFuncion = new JMenuItem("Consultar disponibilidad de la funcion");
		cineJMenuFuncion.add(gestionFuncionConsultarDispFuncion);
		gestionFuncionAgregarEntradaFuncion = new JMenuItem("Agregar Entrada a una funcion");
		cineJMenuFuncion.add(gestionFuncionAgregarEntradaFuncion);
		gestionFuncionMostrarAsientos = new JMenuItem("Mostrar Asientos");
		cineJMenuFuncion.add(gestionFuncionMostrarAsientos);
		
		gestionClienteRegistrarClienteJMenuItem = new JMenuItem("Registrar cliente");
		cineJMenuCliente.add(gestionClienteRegistrarClienteJMenuItem);
		gestionClienteDatosClienteJMenuItem = new JMenuItem("Ver datos cliente");
		cineJMenuCliente.add(gestionClienteDatosClienteJMenuItem);
		gestionClienteListaClienteJMenuItem = new JMenuItem("Ver lista clientes");
		cineJMenuCliente.add(gestionClienteListaClienteJMenuItem);
		
		gestionEntradaVenderEntradaJMenuItem = new JMenuItem ("Vender entrada");
		cineJMenuEntrada.add(gestionEntradaVenderEntradaJMenuItem);
		gestionEntradaMostrarEntradasFuncionJMenuItem = new JMenuItem("Mostrar entradas funcion");
		cineJMenuEntrada.add(gestionEntradaMostrarEntradasFuncionJMenuItem);
		gestionEntradaCancelarEntradaJMenuItem = new JMenuItem ("Cancelar Entradas");
		cineJMenuEntrada.add(gestionEntradaCancelarEntradaJMenuItem);
		gestionEntradaConsultarEntradaClienteJMenuItem = new JMenuItem ("Consultar entrada cliente");
		cineJMenuEntrada.add(gestionEntradaConsultarEntradaClienteJMenuItem);
		gestionEntradaCancelarMiEntradaJMenuItem = new JMenuItem("Cancelar mi entrada");
		cineJMenuEntrada.add(gestionEntradaCancelarMiEntradaJMenuItem);
			
	}

}
