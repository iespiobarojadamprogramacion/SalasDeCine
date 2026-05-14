package salasdecine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import salasdecine.vistas.AgregarEntradaFuncionVista;
import salasdecine.vistas.CancelarEntradaVista;
import salasdecine.vistas.ConsultarDisponibilidadFuncionVista;
import salasdecine.vistas.ConsultarEntradasClientesVista;
import salasdecine.vistas.DarAltaFuncionVista;
import salasdecine.vistas.DarAltaPeliculaVista;
import salasdecine.vistas.DatosClienteVista;
import salasdecine.vistas.ListaClienteVista;
import salasdecine.vistas.MostrarAsientosVista;
import salasdecine.vistas.MostrarEntradasFuncionVista;
import salasdecine.vistas.MostrarSalasVista;
import salasdecine.vistas.RegistrarClienteVista;
import salasdecine.vistas.SalasLibresVista;
import salasdecine.vistas.SalasOcupadasVista;
import salasdecine.vistas.VenderEntradaVista;

/**
 * VENTANA PRINCIPAL DE LA APLICACION DE SALAS DE CINE CREAMOS UNA INTERFAZ
 * GRAFICA CON VARIAS OPCIONES DEL MENU Y DENTRO MAS OPCIONES
 */
public class Ventana extends JFrame implements ActionListener {
	/** VARIABLES PARA ITEM DEL JMENU */
	private JMenuItem gestionPeliculaAltaPeliJMenuItem;

	/**
	 * VARIABLES PARA ITEM DEL JMENU SALA
	 */
	private JMenuItem gestionSalaMostrarSalasJMenuItem;
	private JMenuItem gestionSalaSalasLibresJMenuItem;
	private JMenuItem gestionSalaMostrarSalasOcupadasJMenuItem;

	/**
	 * VARIABLES DE JMENUITEM PARA EL MENU DE GESTION FUNCION
	 */
	private JMenuItem gestionFuncionDarAltaJMenuItem;
	private JMenuItem gestionFuncionConsultarDispFuncion;
	private JMenuItem gestionFuncionAgregarEntradaFuncion;
	private JMenuItem gestionFuncionMostrarAsientos;

	/**
	 * VARIABLES DE JMENUITEM PARA EL MENU DE GESTION CLIENTE
	 */
	private JMenuItem gestionClienteRegistrarClienteJMenuItem;
	private JMenuItem gestionClienteDatosClienteJMenuItem;
	private JMenuItem gestionClienteListaClienteJMenuItem;

	/**
	 * VARIABLES DE JMENUITEM PARA EL MENU DE GESTION ENTRADAS
	 */
	private JMenuItem gestionEntradaVenderEntradaJMenuItem;
	private JMenuItem gestionEntradaMostrarEntradasFuncionJMenuItem;
	private JMenuItem gestionEntradaCancelarEntradaJMenuItem;
	private JMenuItem gestionEntradaConsultarEntradaClienteJMenuItem;
	private JMenuItem gestionEntradaCancelarMiEntradaJMenuItem;
	
	/**
	 * CONSTRUCOR DE LA CLASE VENTANA
	 * CONFIGURO COMO SERA LA VENTANA
	 * AÑADO LAS JMENU Y JMENUITEM
	 */
	public Ventana() {
		super("Sala de cine");
		// X Y Y EL TAMAÑO
		setBounds(100, 100, 750, 600);
		setVisible(true);
		// TENEMOS QUE CREAR EL MENU EN ESTA VENTANA
		// PARA CREAR UN MENU SIEMPRE TENEMOS QUE CREAR UN OBJETO LLAMADO MENU BAR, ESE
		// OBJETO MENUBAR
		// HAY QUE ASOCIARLA AL FRAME
		// CUANDO ME CREE UN MENU BAR VA A COLGAR DE UN JMENU QUE SE LLAMARA X POR
		// EJEMPLO Y SERA UNA OPCION
		// DEL MENU
		// CUANDO CREAS UN MENU BAR TIENES QUE ASOCIAR AL JFRAME CON UN METODO QUE TIENE
		// Y ESE MENU ITEM SE ASOCIA AL MENU
		//
		// CREAR MENU BARRA
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		// Y LO ASOCIO ESTA OPCION AL MENUBAR (SON OPCIONES QUE IRAN APARECIENDO ARRIBA)

		/**
		 * CREAR OPCIONES DEL MENUBARRA
		 */
		JMenu cineJMenuPelicula = new JMenu("Gestion Pelicula");
		menuBar.add(cineJMenuPelicula);
		JMenu cineJMenuSala = new JMenu("Gestion Sala");
		menuBar.add(cineJMenuSala);
		JMenu cineJMenuFuncion = new JMenu("Gestion Funcion");
		menuBar.add(cineJMenuFuncion);
		JMenu cineJMenuCliente = new JMenu("Gestion Cliente");
		menuBar.add(cineJMenuCliente);
		JMenu cineJMenuEntrada = new JMenu("Gestion Entrada");
		menuBar.add(cineJMenuEntrada);

		// DECLARAMOS LOS JMenuItem PARA CADA OPCIONES QUE TIENE EL JMenu
		/**
		 * LAS VARIABLES ESTAN ARRIBA Y AQUI LA INSTANCIAMOS
		 */
		gestionPeliculaAltaPeliJMenuItem = new JMenuItem("Dar de alta pelicula");
		cineJMenuPelicula.add(gestionPeliculaAltaPeliJMenuItem);
		gestionPeliculaAltaPeliJMenuItem.addActionListener(this);
		/**
		 * OPCIONES DEL MENU DE SALA
		 */
		gestionSalaMostrarSalasJMenuItem = new JMenuItem("Mostrar todas las salas");
		cineJMenuSala.add(gestionSalaMostrarSalasJMenuItem);
		gestionSalaMostrarSalasJMenuItem.addActionListener(this); // recoge el evento este, ESTA ASOCIADO A CUANDO SE
																	// PULSA TENGA ESE EVENTO

		gestionSalaSalasLibresJMenuItem = new JMenuItem("Salas Libres");
		cineJMenuSala.add(gestionSalaSalasLibresJMenuItem);
		gestionSalaSalasLibresJMenuItem.addActionListener(this); // EVENTO

		gestionSalaMostrarSalasOcupadasJMenuItem = new JMenuItem("Mostrar salas ocupadas");
		cineJMenuSala.add(gestionSalaMostrarSalasOcupadasJMenuItem);
		gestionSalaMostrarSalasOcupadasJMenuItem.addActionListener(this);// EVENTO

		/**
		 * OPCIONES DEL MENU DE FUNCION
		 */
		gestionFuncionDarAltaJMenuItem = new JMenuItem("Dar de alta funcion");
		cineJMenuFuncion.add(gestionFuncionDarAltaJMenuItem);
		gestionFuncionDarAltaJMenuItem.addActionListener(this);

		gestionFuncionConsultarDispFuncion = new JMenuItem("Consultar disponibilidad de la funcion");
		cineJMenuFuncion.add(gestionFuncionConsultarDispFuncion);
		gestionFuncionConsultarDispFuncion.addActionListener(this);

		gestionFuncionAgregarEntradaFuncion = new JMenuItem("Agregar Entrada a una funcion");
		cineJMenuFuncion.add(gestionFuncionAgregarEntradaFuncion);
		gestionFuncionAgregarEntradaFuncion.addActionListener(this);

		gestionFuncionMostrarAsientos = new JMenuItem("Mostrar Asientos");
		cineJMenuFuncion.add(gestionFuncionMostrarAsientos);
		gestionFuncionMostrarAsientos.addActionListener(this);

		/**
		 * OPCIONES DEL MENU DE CLIENTE
		 */
		gestionClienteRegistrarClienteJMenuItem = new JMenuItem("Registrar cliente");
		cineJMenuCliente.add(gestionClienteRegistrarClienteJMenuItem);
		gestionClienteRegistrarClienteJMenuItem.addActionListener(this);

		gestionClienteDatosClienteJMenuItem = new JMenuItem("Ver datos cliente");
		cineJMenuCliente.add(gestionClienteDatosClienteJMenuItem);
		gestionClienteDatosClienteJMenuItem.addActionListener(this);

		gestionClienteListaClienteJMenuItem = new JMenuItem("Ver lista clientes");
		cineJMenuCliente.add(gestionClienteListaClienteJMenuItem);
		gestionClienteListaClienteJMenuItem.addActionListener(this);

		/**
		 * OPCIONES DEL MENU DE ENTRADA
		 */
		gestionEntradaVenderEntradaJMenuItem = new JMenuItem("Vender entrada");
		cineJMenuEntrada.add(gestionEntradaVenderEntradaJMenuItem);
		gestionEntradaVenderEntradaJMenuItem.addActionListener(this);

		gestionEntradaMostrarEntradasFuncionJMenuItem = new JMenuItem("Mostrar entradas funcion");
		cineJMenuEntrada.add(gestionEntradaMostrarEntradasFuncionJMenuItem);
		gestionEntradaMostrarEntradasFuncionJMenuItem.addActionListener(this);
		
		gestionEntradaCancelarEntradaJMenuItem = new JMenuItem("Cancelar Entradas");
		cineJMenuEntrada.add(gestionEntradaCancelarEntradaJMenuItem);
		gestionEntradaCancelarEntradaJMenuItem.addActionListener(this);
		
		gestionEntradaConsultarEntradaClienteJMenuItem = new JMenuItem("Consultar entrada cliente");
		cineJMenuEntrada.add(gestionEntradaConsultarEntradaClienteJMenuItem);
		gestionEntradaConsultarEntradaClienteJMenuItem.addActionListener(this);
		
		gestionEntradaCancelarMiEntradaJMenuItem = new JMenuItem("Cancelar mi entrada");
		cineJMenuEntrada.add(gestionEntradaCancelarMiEntradaJMenuItem);

	}

	/**
	 * METODO QUE SE AGREGA AL IMPLEMENTAR ACTIONLISTENER, RECOGERA LOS ELEMENTOS DE MI PAGINA
	 * REACCIONARA SEGUN EL ELEMENTO QUE SELECCIONE
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// SOLO NO HARIA NADA, YA QUE TIENES QUE DECIR QUE ELEMENTO DE LA VENTANA HACE
		// ESTE EVENTO
		System.out.println("RECOGIENDO EVENTOS");

		if (e.getSource() == gestionSalaMostrarSalasJMenuItem) {
			System.out.println("HAS ELEGIDO VER LISTA DE SALAS");
			MostrarSalasVista mostrarSalasVista = new MostrarSalasVista();
			setContentPane(mostrarSalasVista);
		} else if (e.getSource() == gestionSalaSalasLibresJMenuItem) {
			System.out.println("HAS ELEGIDO SALAS LIBRES");
			SalasLibresVista salasLibresVista = new SalasLibresVista();
			setContentPane(salasLibresVista);
		} else if (e.getSource() == gestionSalaMostrarSalasOcupadasJMenuItem) {
			System.out.println("HAS ELEGIDO MOSTRAR SALAS OCUPADAS");
			SalasOcupadasVista salasOcupadasVista = new SalasOcupadasVista();
			setContentPane(salasOcupadasVista);
		} else if (e.getSource() == gestionClienteRegistrarClienteJMenuItem) {
			System.out.println("HAS ELEGIDO REGISTRAR CLIENTE");
			RegistrarClienteVista registrarClienteVista = new RegistrarClienteVista();
			setContentPane(registrarClienteVista); // ASOCIO ESA CLASE AL EVENTO DE LAS OPCIONES DEL MENU
		} else if (e.getSource() == gestionClienteDatosClienteJMenuItem) {
			System.out.println("HAS ELEGIDO VER DATOS CLIENTE");
			DatosClienteVista datosClienteVista = new DatosClienteVista();
			setContentPane(datosClienteVista);
		} else if (e.getSource() == gestionClienteListaClienteJMenuItem) {
			System.out.println("HAS ELEGIDO VER LISTA DE CLIENTES");
			ListaClienteVista listaClienteVista = new ListaClienteVista();
			setContentPane(listaClienteVista);
		} else if (e.getSource() == gestionPeliculaAltaPeliJMenuItem) {
			System.out.println("HAS ELEGIDO ALTA PELICULA");
			DarAltaPeliculaVista darAltaPeliculaVista = new DarAltaPeliculaVista();
			setContentPane(darAltaPeliculaVista);
		} else if (e.getSource() == gestionFuncionDarAltaJMenuItem) {
			System.out.println("HAS ELEGIDO DAR DE ALTA FUNCION");
			DarAltaFuncionVista darAltaFuncionVista = new DarAltaFuncionVista();
			setContentPane(darAltaFuncionVista);

		} else if (e.getSource() == gestionEntradaVenderEntradaJMenuItem) {
			System.out.println("HAS ELEGIDO VENDER ENTRADA");
			VenderEntradaVista dardealtaentradavista = new VenderEntradaVista();
			setContentPane(dardealtaentradavista);
		} else if (e.getSource() == gestionFuncionConsultarDispFuncion) {
			System.out.println("HAS ELEGIDO CONSULTAR FUNCION");
			ConsultarDisponibilidadFuncionVista consultarDisponibilidadFuncionVista = new ConsultarDisponibilidadFuncionVista();
			setContentPane(consultarDisponibilidadFuncionVista);
		} else if (e.getSource() == gestionFuncionAgregarEntradaFuncion) {
			System.out.println("HAS ELEGIDO AGREGAR ENTRADA A FUNCION");
			AgregarEntradaFuncionVista agregarEntradaFuncionVista = new AgregarEntradaFuncionVista();
			setContentPane(agregarEntradaFuncionVista);

		} else if (e.getSource() == gestionFuncionMostrarAsientos) {
			System.out.println("HAS ELEGIDO MOSTRAR MAPA ASIENTOS");
			MostrarAsientosVista mostrarAsientosVista = new MostrarAsientosVista();
			setContentPane(mostrarAsientosVista);
		}else if (e.getSource()==gestionEntradaCancelarEntradaJMenuItem) {
			System.out.println("HAS ELEGIDO CANCELAR ENTRADA");
			CancelarEntradaVista cancelarEntradaVista= new CancelarEntradaVista();
			setContentPane(cancelarEntradaVista);
		}else if(e.getSource()==gestionEntradaMostrarEntradasFuncionJMenuItem) {
			System.out.println("HAS ELEGIDO MOSTRAR ENTRADAS DE UNA FUNCION");
			MostrarEntradasFuncionVista mostrarEntradasFuncionVista= new MostrarEntradasFuncionVista();
			setContentPane(mostrarEntradasFuncionVista);
		}else if(e.getSource()==gestionEntradaConsultarEntradaClienteJMenuItem) {
			System.out.println("HAS ELEGIDO MOSTRAR ENTRADAS DE LOS CLIENTES");
			ConsultarEntradasClientesVista consultarEntradasClientesVista = new ConsultarEntradasClientesVista();
			setContentPane(consultarEntradasClientesVista);
		}
		
		setVisible(true); // para refrescar

	}

}
