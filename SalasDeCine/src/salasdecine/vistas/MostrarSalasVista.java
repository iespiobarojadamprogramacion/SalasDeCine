package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import salasdecine.controladores.MostrarSalasControlador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class MostrarSalasVista extends JPanel {
	private MostrarSalasControlador controlador;
	private JTable table;
	private final String[] cabeceraTabla = { "NOMBRE", "FILA", "COLUMNA", "ASIENTOS TOTALES" };
	private String[][] datosTabla = new String[7][4]; // IRAN LOS DATOS DE LAA TABLA

	public MostrarSalasVista() {
		controlador = new MostrarSalasControlador(this);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("MOSTRAR SALAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(158, 11, 242, 14);
		add(lblNewLabel);

		JButton btnConsultar = new JButton("Consultar Salas");
		btnConsultar.setBounds(158, 58, 127, 23);
		add(btnConsultar);
		btnConsultar.addActionListener(controlador); // <-- AÑADO LA ACCION QUE SE HARA AL PULSAR EN BOTON

		JLabel lblNewLabel_1 = new JLabel("Esta son las listas de las salas:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 90, 242, 14);
		add(lblNewLabel_1);

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

	public void setClientes(String[][] salas) {
		for (int i = 0; i < salas.length; i++) {
			System.out.println(salas[i][0]);
			System.out.println(salas[i][1]);
			System.out.println(salas[i][2]);
			System.out.println(salas[i][3]);
		}

		table.setModel((new javax.swing.table.DefaultTableModel(salas, cabeceraTabla)));
		
	}

	// MENSAJE PARA UNA ALERTA, SE HARA UNA ALERTA CON ESE MENSAJE
	public void setError(String mensaje) {
		// PARA QUE HAGA LA ALERTA
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
		// CUANDO LO USEMOS ESTO EN EL CONTROLADOR HABRIA QUE LLAMARLO POR EJEMPLO:
		// vista.setError("ERROR QUE QUIERAS DECIR");
	}
}
