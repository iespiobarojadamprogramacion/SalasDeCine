package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import salasdecine.controladores.SalasLibresControlador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class SalasLibresVista extends JPanel {

	private SalasLibresControlador controlador;
	private JTable table;
	private final String[] cabeceraTabla = { "NOMBRE", "FILA", "COLUMNA", "ASIENTOS TOTALES" };
	private String[][] datosTabla = new String[7][4]; // IRAN LOS DATOS DE LAA TABLA

	public SalasLibresVista() {
		controlador = new SalasLibresControlador(this);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("SALAS LIBRES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(131, 11, 219, 14);
		add(lblNewLabel);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(131, 61, 157, 23);
		add(btnConsultar);
		btnConsultar.addActionListener(controlador);

		JLabel lblNewLabel_1 = new JLabel("Estan son las salas libres:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(23, 94, 205, 14);
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
	public void setSalasLibres(String[][] salasLibres) {
		for (int i = 0; i < salasLibres.length; i++) {
			System.out.println(salasLibres[i][0]);
			System.out.println(salasLibres[i][1]);
			System.out.println(salasLibres[i][2]);
			System.out.println(salasLibres[i][3]);
		}

		table.setModel((new javax.swing.table.DefaultTableModel(salasLibres, cabeceraTabla)));
		
	}
	// MENSAJE PARA UNA ALERTA, SE HARA UNA ALERTA CON ESE MENSAJE
		public void setError(String mensaje) {
			// PARA QUE HAGA LA ALERTA
			JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
			// CUANDO LO USEMOS ESTO EN EL CONTROLADOR HABRIA QUE LLAMARLO POR EJEMPLO:
			// vista.setError("ERROR QUE QUIERAS DECIR");
		}

}
