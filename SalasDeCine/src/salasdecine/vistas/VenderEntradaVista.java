package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import salasdecine.controladores.VenderEntradaControlador;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VenderEntradaVista extends JPanel {
	private JTable Funciontabla;
	private JTextField Columna;
	private JTextField textFila;
	private JTable ClienteTabla;
	private ButtonGroup bottonhora;
	private ButtonGroup bottonpago;
	private JRadioButton radiobutonhora;
	private JRadioButton radio19;
	private JRadioButton radio22;
	private JRadioButton radiotarjeta;
	private JRadioButton RadioEfectivo;
	private JButton botonclientes;
	private JButton caragarfunciones;
	private JButton venderentradaboton;
	private VenderEntradaControlador controlador;
	private final String[] cabeceraTabla = { "Titulo", "Sala" };
	private String[][] datosTabla = new String[20][2];
	private final String[] cabeceraTablac = { "id", "Nombre" };
	private String[][] datosTablac = new String[20][2];

	private JComboBox comboBoxFuncion;
	private JComboBox comboBoxCliente;
	private JTextArea Mapaasientos;

	public VenderEntradaVista() {
		setLayout(null);
		controlador = new VenderEntradaControlador(this);
		JLabel lblNewLabel = new JLabel("Vender Entrada");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(168, 10, 142, 35);
		add(lblNewLabel);

		Funciontabla = new JTable(datosTabla, cabeceraTabla);
		// Funciontabla.setBounds(10, 82, 111, 63);
		JScrollPane Scrollfuncion = new JScrollPane(Funciontabla);
		Scrollfuncion.setBounds(10, 74, 130, 117);
		// add(Funciontabla);
		add(Scrollfuncion);
		
		JLabel lblNewLabel_1 = new JLabel("Funcion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(24, 51, 69, 12);
		add(lblNewLabel_1);
		bottonhora = new ButtonGroup();

		radiobutonhora = new JRadioButton("16:00");
		radiobutonhora.setBounds(10, 313, 102, 20);
		add(radiobutonhora);
		bottonhora.add(radiobutonhora);
		radiobutonhora.setSelected(true);
		radiobutonhora.addActionListener(controlador);
		
		radio19 = new JRadioButton("19:00");
		radio19.setBounds(10, 336, 102, 20);
		add(radio19);
		bottonhora.add(radio19);
		radio19.addActionListener(controlador);
		

		radio22 = new JRadioButton("22:00");
		radio22.setBounds(10, 359, 102, 20);
		add(radio22);
		bottonhora.add(radio22);
		radio22.addActionListener(controlador);

		JLabel lblNewLabel_2 = new JLabel("Selecciona Hora");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 294, 123, 12);
		add(lblNewLabel_2);

		Mapaasientos = new JTextArea();
		Mapaasientos.setEditable(false);
		Mapaasientos.setFont(new Font("Monospaced", Font.BOLD, 14)); //PROANDO
		Mapaasientos.setBounds(202, 86, 221, 117);
		add(Mapaasientos);
		

		JLabel lblNewLabel_3 = new JLabel("Selecciona el asiento");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(237, 56, 142, 12);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Fila");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(228, 214, 44, 12);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Columna");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(225, 236, 69, 12);
		add(lblNewLabel_5);

		Columna = new JTextField();
		Columna.setBounds(304, 235, 55, 16);
		add(Columna);
		Columna.setColumns(10);

		textFila = new JTextField();
		textFila.setBounds(304, 213, 55, 16);
		add(textFila);
		textFila.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Selecciona Cliente");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(441, 47, 116, 20);
		add(lblNewLabel_6);

		ClienteTabla = new JTable(datosTablac, cabeceraTablac);
		// ClienteTabla.setBounds(305, 77, 106, 68);
		JScrollPane Scrollclliente = new JScrollPane(ClienteTabla);
		Scrollclliente.setBounds(433, 74, 130, 109);
		// add(ClienteTabla);
		add(Scrollclliente);

		JLabel lblNewLabel_7 = new JLabel("Seleccionar Metodo de pago");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(404, 294, 167, 12);
		add(lblNewLabel_7);
		bottonpago = new ButtonGroup();

		radiotarjeta = new JRadioButton("Tarjeta");
		radiotarjeta.setBounds(404, 313, 102, 20);
		add(radiotarjeta);
		bottonpago.add(radiotarjeta);
		radiotarjeta.setSelected(true);

		RadioEfectivo = new JRadioButton("Efectivo");
		RadioEfectivo.setBounds(404, 336, 102, 20);
		add(RadioEfectivo);
		bottonpago.add(RadioEfectivo);
		venderentradaboton = new JButton("Vender entrada");
		venderentradaboton.setBounds(276, 383, 124, 20);
		add(venderentradaboton);
		venderentradaboton.addActionListener(controlador);

		botonclientes = new JButton("cargar clientes");
		botonclientes.addActionListener(controlador);
		botonclientes.setBounds(429, 202, 128, 20);
		add(botonclientes);

		caragarfunciones = new JButton("cargar funciones");
		caragarfunciones.addActionListener(controlador);
		caragarfunciones.setBounds(10, 202, 130, 20);
		add(caragarfunciones);

		comboBoxFuncion = new JComboBox();
		comboBoxFuncion.setBounds(150, 71, 42, 22);
		add(comboBoxFuncion);

		comboBoxCliente = new JComboBox();
		comboBoxCliente.setBounds(583, 71, 42, 22);
		add(comboBoxCliente);
		

	}
	public String getHora() {
		String hora=null;
		if(radiobutonhora.isSelected()) {
			hora="16:00";
		}else if(radio19.isSelected()) {
			hora="19:00";
		}else if(radio22.isSelected()) {
			hora="22:00";
		}
		return hora;
	}

	public void setFunciones(String[][] listafunciones) {
		for (int i = 0; i < listafunciones.length; i++) {

			System.out.println(listafunciones[i][0]);
			System.out.println(listafunciones[i][1]);
		}
		Funciontabla.setModel((new javax.swing.table.DefaultTableModel(listafunciones, cabeceraTabla)));
	}

	public void setClientes(String[][] listaclientes) {
		for (int i = 0; i < listaclientes.length; i++) {
			System.out.println(listaclientes[i][0]);
			System.out.println(listaclientes[i][1]);

		}
		ClienteTabla.setModel((new javax.swing.table.DefaultTableModel(listaclientes, cabeceraTablac)));
	}

	public JButton getBotonclientes() {
		return botonclientes;
	}

	public JButton getBotonfunciones() {
		return caragarfunciones;
	}

	public JButton getvender() {
		return venderentradaboton; //BOTON DE VENDER ENTRADA
	}
	public JRadioButton getRadio16 () {
		return radiobutonhora;
	}
	public JRadioButton getRadio19 () {
		return radio19;
	}
	public JRadioButton getRadio22 () {
		return radio22;
	}
	
	//CREADOR DEL JCOMBOBOX 
	public void numerosDeFuncionesComboBox(String[] resultadoNumeroFunciones) {
		comboBoxFuncion.removeAllItems();
		for (int i = 0; i < resultadoNumeroFunciones.length; i++) {
			comboBoxFuncion.addItem(resultadoNumeroFunciones[i]);
		}
		// COMO ANTES LO CREABA, LO CREE EN EL CONSTRUCTOR Y AQUI ASIGNO LOS VALORES

	}
	//CREADOR DEL JCOMBOBOX DEPENDIENDO DE LA LISTA DE CLIENTES (REVISR API CINE)
	public void numerosDeClientesComboBox(String []resultadoNumeroClientes) {
		comboBoxCliente.removeAllItems();
		for (int i=0; i<resultadoNumeroClientes.length; i++) {
			comboBoxCliente.addItem(resultadoNumeroClientes[i]);
		}
	}
	public void setError(String mensaje) {
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
	}
	public void respuestaOK(String mensaje) {
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
	}
	
	//METODO PARA USAR EL JTEXTAREA PARA IMPRIMIR LOS ASIENTOS AHI
	public void setMapaAsientos(String mapaAsientos) {
		Mapaasientos.setText(mapaAsientos);
	}
	//RETORNA LA FUNCION SELECCIONADA EN EL JCOMBO
	public int getFuncionSeleccionada() {
		return comboBoxFuncion.getSelectedIndex(); //RETORNO EL VALOR DONDE ESTA EL JCOMBO SELECCIONADO
	}
	//RETORNA LA FILA EN ENTERO
	public int getFila(){
		
		return Integer.parseInt(textFila.getText());
	}
	//RETORNA LA COLUMA EN ENTERO
	public int getColumna() {
		return Integer.parseInt(Columna.getText());
	}
	//RETORNA EL CLIENTE SELECCIONADO EN ELJCOMBO
	public int getClienteSeleccionado() {
		return comboBoxCliente.getSelectedIndex();
	}
	//RECOGE EL VALOR DEL METODO DE PAGO
	public String getMetodoPago() {
		if(radiotarjeta.isSelected()) {
			return "TARJETA";
		}else {
			return"EFECTIVO";
		}
	}
	

		
}
