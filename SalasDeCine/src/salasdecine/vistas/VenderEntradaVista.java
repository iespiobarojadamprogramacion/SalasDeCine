package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import salasdecine.controladores.VenderEntradaControlador;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
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
	private JRadioButton radio19 ;
	private JRadioButton radio22 ;
	private JRadioButton radiotarjeta;
	private JRadioButton  RadioEfectivo;
	 private JButton botonclientes;
	 private JButton caragarfunciones;
	 private JButton venderentradaboton;
	private VenderEntradaControlador controlador;
	private final String [] cabeceraTabla={"Titulo","Sala"};
	private String [][] datosTabla=new String[20] [2];
	private final String [] cabeceraTablac={"id","Nombre"};
	private String [][] datosTablac=new String[20] [2];
	public VenderEntradaVista() {
		setLayout(null);
		controlador=new VenderEntradaControlador(this);
		JLabel lblNewLabel = new JLabel("Vender Entrada");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(168, 10, 142, 35);
		add(lblNewLabel);
		
		Funciontabla = new JTable(datosTabla,cabeceraTabla);
		//Funciontabla.setBounds(10, 82, 111, 63);
		JScrollPane Scrollfuncion=new JScrollPane(Funciontabla);
		Scrollfuncion.setBounds(10,82,98,63);
		//add(Funciontabla);
		add(Scrollfuncion);
		JLabel lblNewLabel_1 = new JLabel("Funcion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(24, 51, 69, 12);
		add(lblNewLabel_1);
		bottonhora=new ButtonGroup();
		
		JRadioButton radiobutonhora = new JRadioButton("16:00");
		radiobutonhora.setBounds(6, 185, 102, 20);
		add(radiobutonhora);
		bottonhora.add(radiobutonhora);
		radiobutonhora.setSelected(true);
		JRadioButton radio19 = new JRadioButton("19:00");
		radio19.setBounds(6, 207, 102, 20);
		add(radio19);
		bottonhora.add(radio19);
		
		JRadioButton radio22 = new JRadioButton("22:00");
		radio22.setBounds(6, 229, 102, 20);
		add(radio22);
		bottonhora.add(radio22);
		
		JLabel lblNewLabel_2 = new JLabel("Selecciona Hora");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 155, 123, 12);
		add(lblNewLabel_2);
		
		JTextArea Mapaasientos = new JTextArea();
		Mapaasientos.setBounds(156, 77, 123, 75);
		add(Mapaasientos);
		
		JLabel lblNewLabel_3 = new JLabel("Selecciona el asiento");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(156, 51, 142, 12);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fila");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(156, 156, 44, 12);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Columna");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(156, 189, 69, 12);
		add(lblNewLabel_5);
		
		Columna = new JTextField();
		Columna.setBounds(221, 189, 32, 12);
		add(Columna);
		Columna.setColumns(10);
		
		textFila = new JTextField();
		textFila.setBounds(198, 155, 55, 16);
		add(textFila);
		textFila.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Selecciona Cliente");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(295, 47, 116, 20);
		add(lblNewLabel_6);
		
		ClienteTabla = new JTable(datosTablac,cabeceraTablac);
		//ClienteTabla.setBounds(305, 77, 106, 68);
		JScrollPane Scrollclliente=new JScrollPane(ClienteTabla);
		Scrollclliente.setBounds(305,77,106,68);
		//add(ClienteTabla);
		add(Scrollclliente);
		
		JLabel lblNewLabel_7 = new JLabel("Seleccionar Metodo de pago");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(273, 155, 167, 12);
		add(lblNewLabel_7);
		bottonpago=new ButtonGroup();
		
		JRadioButton radiotarjeta = new JRadioButton("Tarjeta");
		radiotarjeta.setBounds(287, 185, 102, 20);
		add(radiotarjeta);
		bottonpago.add(radiotarjeta);
		radiotarjeta.setSelected(true);
		
		JRadioButton RadioEfectivo = new JRadioButton("Efectivo");
		RadioEfectivo.setBounds(287, 218, 102, 20);
		add(RadioEfectivo);
		bottonpago.add(RadioEfectivo);
		JButton venderentradaboton = new JButton("Vender entrada");
		venderentradaboton.setBounds(169, 249, 110, 20);
		add(venderentradaboton);
		
		 botonclientes = new JButton("cargar clientes");
		botonclientes.addActionListener(controlador);
		botonclientes.setBounds(401, 80, 84, 20);
		add(botonclientes);
		
		 caragarfunciones = new JButton("cargar funciones");
		caragarfunciones.addActionListener(controlador);
		caragarfunciones.setBounds(105, 80, 44, 20);
		add(caragarfunciones);
		venderentradaboton.addActionListener(controlador);
		
	}
	public void setFunciones(String [][] listafunciones) {
		for(int i=0; i<listafunciones.length; i++) {
			
			System.out.println(listafunciones[i][0]);
			System.out.println(listafunciones[i][1]);
		}
		Funciontabla.setModel((new javax.swing.table.DefaultTableModel(listafunciones, cabeceraTabla)));
	}
	public void setClientes(String [][] listaclientes) {
		for(int i=0; i<listaclientes.length; i++) {
			System.out.println(listaclientes[i][0]);
			System.out.println(listaclientes[i][1]);
			
		}
		ClienteTabla.setModel((new javax.swing.table.DefaultTableModel(listaclientes, cabeceraTablac)));
	}
	public JButton getBotonclientes() {
		return botonclientes;
	}
	public JButton getBotonfunciones() {
		return  caragarfunciones;
	}
	public JButton getvender() {
		return venderentradaboton ;
	}
	
}
