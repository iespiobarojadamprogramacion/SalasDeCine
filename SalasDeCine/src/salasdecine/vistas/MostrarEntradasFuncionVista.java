package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

import salasdecine.controladores.MostrarEntradasFuncionControlador;
import javax.swing.table.DefaultTableModel;

public class MostrarEntradasFuncionVista extends JPanel {
	private JTable tablaEntradas;
	private JTable tablaFunciones;
	private MostrarEntradasFuncionControlador controlador;
	private JButton btnConsultarEntradas;
	private final String[] cabeceraTabla = { "Nº", "Titulo", "Sala" };
	private String[][] datosTabla = new String[20][3];
	private final String[] cabeceraTablaEntradas = { "Pelicula", "Sala", "Hora", "Asiento", "Cliente", "Precio" };
	private String[][] datosTablaEntradas = new String[90][6];
	private JComboBox comboBoxFunciones;
	private JButton btnCargarFunciones;

	public MostrarEntradasFuncionVista() {
		controlador = new MostrarEntradasFuncionControlador(this);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("MOSTRAR ENTRADAS DE UNA FUNCION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(137, 11, 411, 14);
		add(lblNewLabel);

		btnConsultarEntradas = new JButton("Consultar Entradas");
		btnConsultarEntradas.setBounds(288, 337, 165, 23);
		add(btnConsultarEntradas);
		btnConsultarEntradas.addActionListener(controlador);

		tablaEntradas = new JTable(datosTablaEntradas, cabeceraTablaEntradas);
		tablaEntradas.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollEntradas = new JScrollPane(tablaEntradas);
		scrollEntradas.setBounds(261, 74, 431, 178);
		add(scrollEntradas);

		tablaFunciones = new JTable(datosTabla, cabeceraTabla);
		tablaFunciones.getTableHeader().setReorderingAllowed(false);
		// tablaFunciones.setBounds(20, 104, 154, 83);
		JScrollPane scrollFuncion = new JScrollPane(tablaFunciones);
		scrollFuncion.setBounds(20, 74, 191, 107);
		add(scrollFuncion);

		btnCargarFunciones = new JButton("Cargar Funciones");
		btnCargarFunciones.setBounds(10, 186, 145, 23);
		add(btnCargarFunciones);
		btnCargarFunciones.addActionListener(controlador);

		comboBoxFunciones = new JComboBox();
		comboBoxFunciones.setBounds(165, 186, 46, 22);
		add(comboBoxFunciones);
	}

	public int getFuncionSeleccionada() {
		return comboBoxFunciones.getSelectedIndex(); // RETORNO EL VALOR DONDE ESTA EL JCOMBO SELECCIONADO
	}

	public JButton getBotonCargarFunciones() {
		return btnCargarFunciones;
	}

	public JButton getBotonConsultarEntradas() {
		return btnConsultarEntradas;
	}

	// CREADOR DEL JCOMBOBOX
	public void numerosDeFuncionesComboBox(String[] resultadoNumeroFunciones) {
		comboBoxFunciones.removeAllItems();
		for (int i = 0; i < resultadoNumeroFunciones.length; i++) {
			comboBoxFunciones.addItem(resultadoNumeroFunciones[i]);
		}
		// COMO ANTES LO CREABA, LO CREE EN EL CONSTRUCTOR Y AQUI ASIGNO LOS VALORES

	}

	public void setFunciones(String[][] listafunciones) {
		for (int i = 0; i < listafunciones.length; i++) {

			System.out.println(listafunciones[i][0]);
			System.out.println(listafunciones[i][1]);
			System.out.println(listafunciones[i][2]);
		}
		tablaFunciones.setModel((new javax.swing.table.DefaultTableModel(listafunciones, cabeceraTabla)));
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
	
	public void setError(String mensaje) {
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
	}

	public void respuestaOK(String mensaje) {
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
	}

}
