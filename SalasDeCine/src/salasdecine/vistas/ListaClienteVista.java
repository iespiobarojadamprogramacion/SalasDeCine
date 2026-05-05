package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import salasdecine.controladores.ListaClienteControlador;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaClienteVista extends JPanel {
	private JTable table;
	private ListaClienteControlador controlador;

	private final String[] cabeceraTabla = { "ID CLIENTE", "NOMBRE", "EMAIL", "FECHA NACIMIENTO" };
	private String[][] datosTabla = new String[20][4]; // IRAN LOS DATOS DE LAA TABLA

	public ListaClienteVista() {

		controlador = new ListaClienteControlador(this);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("LISTA DE LOS CLIENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(117, 11, 230, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Los datos del cliente son:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(34, 104, 220, 14);
		add(lblNewLabel_1);

		JButton btnConsultar = new JButton("Consultar Lista");
		btnConsultar.setBounds(153, 66, 145, 23);
		add(btnConsultar);
		btnConsultar.addActionListener(controlador);

		table = new JTable(datosTabla, cabeceraTabla); // <--- PASAMOS PRIMERO LOS DATOS DE LA TABLA Y LA CABECERA DE LA
														// // TABLA
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		// table.setBounds(107, 195, 244, 49); //ANCHO ALTO
		table.setGridColor(Color.BLACK); // <--EL COLOR
		table.setBackground(new Color(255, 255, 255)); // <-- MAS COLOR
		JScrollPane scrollTabla = new JScrollPane(table); // <--SCROLL POR SI FUERA NECESARIO
		scrollTabla.setBounds(34, 159, 480, 150);
		// add(table);
		add(scrollTabla);

	}

	public void setClientes(String[][] clientes) {
		for (int i = 0; i < clientes.length; i++) {
			System.out.println(clientes[i][0]);
			System.out.println(clientes[i][1]);
			System.out.println(clientes[i][2]);
			System.out.println(clientes[i][3]);
		}

		table.setModel((new javax.swing.table.DefaultTableModel(clientes, cabeceraTabla)));
		// datosTabla=cliente; //EL CLIENTE QUE TENEMOS LO GUARDAMOS EN LA TABLA
	}

	// MENSAJE PARA UNA ALERTA, SE HARA UNA ALERTA CON ESE MENSAJE
	public void setError(String mensaje) {
		// PARA QUE HAGA LA ALERTA
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
		// CUANDO LO USEMOS ESTO EN EL CONTROLADOR HABRIA QUE LLAMARLO POR EJEMPLO:
		// vista.setError("ERROR QUE QUIERAS DECIR");
	}
}