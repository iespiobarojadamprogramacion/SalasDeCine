package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;


import javax.swing.JTable;
import javax.swing.border.LineBorder;

import salasdecine.controladores.DatosClienteControlador;
import salasdecine.controladores.RegistrarClienteControlador;

public class DatosClienteVista extends JPanel {
	private JTextField txtIdCliente;
	private DatosClienteControlador controlador; //CREAR UN CONTROLADOR ASI SE RELACIONES VISTAS Y CONTROLADOR
	private JTable table;
	 // TENEMOS QUE MOSTRAR EL RESULTADO id cliente, NOMBRE, EMAIL FECHA NACIMIENTO.
	private final String[] cabeceraTabla= {"ID CLIENTE", "NOMBRE", "EMAIL", "FECHA NACIMIENTO"};
	private String [][] datosTabla= new String [1][4]; //IRAN LOS DATOS DE LAA TABLA
	
	
	public DatosClienteVista() {
		setLayout(null);
		// UNO ESTA VISTA CON EL CONSTRUCTOR DEL CONTROLADOR
		controlador = new DatosClienteControlador(this);

		JLabel lblNewLabel = new JLabel("VER DATOS CLIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(140, 22, 201, 14);
		add(lblNewLabel);

		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(77, 77, 86, 20);
		add(txtIdCliente);
		txtIdCliente.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID CLIENTE:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 80, 69, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Dame el siguiente dato del cliente");
		lblNewLabel_2.setBounds(10, 52, 211, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Los datos del cliente son:");
		lblNewLabel_2_1.setBounds(10, 146, 176, 14);
		add(lblNewLabel_2_1);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(new Color(192, 192, 192));
		btnConsultar.setBounds(187, 109, 89, 23);
		add(btnConsultar);
		// EVENTO QUE ESCUCHARA AL PULSAR EL BOTON Y CUANDO PASE ESTO EJECUTARA EL
		// CONTROLADOR
		btnConsultar.addActionListener(controlador); //CUANDO PULSE EL BOTON COGERA LOS VALORES RELLENARA LA TABLA
		
		// TENEMOS QUE MOSTRAR EL RESULTADO id cliente, NOMBRE, EMAIL FECHA NACIMIENTO.
		
		table = new JTable(datosTabla, cabeceraTabla); //<--- PASAMOS PRIMERO LOS DATOS DE LA TABLA Y LA CABECERA DE LA TABLA
		
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		//table.setBounds(107, 195, 244, 49); //ANCHO ALTO
		table.setGridColor(Color.BLACK); //<--EL COLOR
		table.setBackground(new Color(255, 255, 255)); //<-- MAS COLOR
		JScrollPane scrollTabla = new JScrollPane(table); //<--SCROLL POR SI FUERA NECESARIO 
		scrollTabla.setBounds(34, 181, 480, 60);
		//add(table);
		add(scrollTabla);
		//creamos un atributo para la cabecera ARRIBAS CREADAS STRING DE LOS TITULOS Y DE LOS DATOS
		

		
	}

	public String getIdCliente() {
		return txtIdCliente.getText();
	}
	public void setCliente (String [][] cliente) {
		System.out.println(cliente[0][0]);
		System.out.println(cliente[0][1]);
		System.out.println(cliente[0][2]);
		System.out.println(cliente[0][3]);
		table.setModel((new javax.swing.table.DefaultTableModel(cliente, cabeceraTabla)));
		//datosTabla=cliente; //EL CLIENTE QUE TENEMOS LO GUARDAMOS EN LA TABLA
	}

	// MENSAJE PARA UNA ALERTA, SE HARA UNA ALERTA CON ESE MENSAJE
	public void setError(String mensaje) {
		// PARA QUE HAGA LA ALERTA
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
		// CUANDO LO USEMOS ESTO EN EL CONTROLADOR HABRIA QUE LLAMARLO POR EJEMPLO:
		// vista.setError("ERROR QUE QUIERAS DECIR");
	}
	
}
