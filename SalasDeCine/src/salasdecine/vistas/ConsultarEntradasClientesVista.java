package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import salasdecine.controladores.ConsultarEntradasClientesControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ConsultarEntradasClientesVista extends JPanel {

	private JButton btnConsultar;
	private ConsultarEntradasClientesControlador controlador;
	private JTable ClienteTabla;
	private JTable tablaEntradas;
	private final String[] cabeceraTablac = { "id", "Nombre" };
	private String[][] datosTablac = new String[20][2];
	private JComboBox comboBoxCliente;
	private JButton btnCargarClientes;
	private final String[] cabeceraTablaEntradas = { "Pelicula", "Sala", "Hora", "Asiento", "Cliente", "Precio" };
	private String[][] datosTablaEntradas = new String[90][6];
	private JLabel lblNewLabel_2;

	public ConsultarEntradasClientesVista() {
		controlador = new ConsultarEntradasClientesControlador(this);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("CONSULTAR ENTRADAS CLIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(201, 11, 347, 14);
		add(lblNewLabel);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(317, 359, 89, 23);
		add(btnConsultar);
		btnConsultar.addActionListener(controlador);

		ClienteTabla = new JTable(datosTablac, cabeceraTablac);
		ClienteTabla.getTableHeader().setReorderingAllowed(false);
		// ClienteTabla.setBounds(305, 77, 106, 68);
		JScrollPane Scrollclliente = new JScrollPane(ClienteTabla);
		Scrollclliente.setBounds(36, 74, 155, 151);
		// add(ClienteTabla);
		add(Scrollclliente);

		comboBoxCliente = new JComboBox();
		comboBoxCliente.setBounds(201, 81, 42, 22);
		add(comboBoxCliente);
		
		btnCargarClientes = new JButton("Cargar Clientes");
		btnCargarClientes.setBounds(45, 236, 145, 23);
		add(btnCargarClientes);
		btnCargarClientes.addActionListener(controlador);
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona el cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(36, 45, 138, 14);
		add(lblNewLabel_1);
		
		tablaEntradas = new JTable(datosTablaEntradas, cabeceraTablaEntradas);
		tablaEntradas.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollEntradas = new JScrollPane(tablaEntradas);
		scrollEntradas.setBounds(261, 74, 431, 178);
		add(scrollEntradas);
		
		lblNewLabel_2 = new JLabel("Entradas del cliente");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(409, 45, 139, 14);
		add(lblNewLabel_2);
	}

	public void setClientes(String[][] listaclientes) {
		for (int i = 0; i < listaclientes.length; i++) {
			System.out.println(listaclientes[i][0]);
			System.out.println(listaclientes[i][1]);

		}
		ClienteTabla.setModel((new javax.swing.table.DefaultTableModel(listaclientes, cabeceraTablac)));
	}
	public void setEntradas(String[][] listaEntradas) {
		for (int i = 0; i < listaEntradas.length; i++) {

			System.out.println(listaEntradas[i][0]);
			System.out.println(listaEntradas[i][1]);
			System.out.println(listaEntradas[i][2]);
			System.out.println(listaEntradas[i][3]);
			System.out.println(listaEntradas[i][4]);
			System.out.println(listaEntradas[i][5]);
		}
		tablaEntradas.setModel((new javax.swing.table.DefaultTableModel(listaEntradas, cabeceraTablaEntradas)));
	}
	

	// CREADOR DEL JCOMBOBOX DEPENDIENDO DE LA LISTA DE CLIENTES (REVISR API CINE)
	public void numerosDeClientesComboBox(String[] resultadoNumeroClientes) {
		comboBoxCliente.removeAllItems();
		for (int i = 0; i < resultadoNumeroClientes.length; i++) {
			comboBoxCliente.addItem(resultadoNumeroClientes[i]);
		}
	}
	public int getClienteSeleccionado() {
		return comboBoxCliente.getSelectedIndex(); // RETORNO EL VALOR DONDE ESTA EL JCOMBO SELECCIONADO
	}
	
	public JButton getBotonConsultarEntradas() {
		return btnConsultar;
	}
	public JButton getBotonCargarClientes() {
		return btnCargarClientes;
	}

	public void setError(String mensaje) {
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
	}

	public void respuestaOK(String mensaje) {
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
	}
}
