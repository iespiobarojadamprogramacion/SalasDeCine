package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import salasdecine.controladores.AgregarEntradaFuncionControlador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AgregarEntradaFuncionVista extends JPanel {

	private AgregarEntradaFuncionControlador controlador;
	private JTable tablaFunciones;
	private JRadioButton rdb16;
	private JRadioButton rdb19;
	private JRadioButton rdb22;
	private JButton btnAgregarEntrada;
	private final String[] cabeceraTabla = { "Nº", "Titulo", "Sala" };
	private String[][] datosTabla = new String[20][3];
	private JComboBox comboBoxFunciones;
	private ButtonGroup grupoHora;
	private JButton btnCargarFunciones;
	private JTextField txtFila;
	private JTextField txtColumna;
	private JTextArea mapaAsientos;

	public AgregarEntradaFuncionVista() {
		controlador = new AgregarEntradaFuncionControlador (this);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("AGREGAR ENTRADA A UNA FUNCION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(205, 11, 397, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Fila: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(362, 245, 46, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Columna:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(362, 270, 75, 14);
		add(lblNewLabel_2_1);

		JLabel lblNewLabel_1 = new JLabel("Selecciona una funcion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(24, 84, 170, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Selecciona Hora");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(526, 84, 129, 14);
		add(lblNewLabel_3);

		btnAgregarEntrada = new JButton("Agregar Entrada");
		btnAgregarEntrada.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregarEntrada.setBounds(295, 351, 168, 23);
		add(btnAgregarEntrada);
		btnAgregarEntrada.addActionListener(controlador);

		tablaFunciones = new JTable(datosTabla, cabeceraTabla);
		tablaFunciones.getTableHeader().setReorderingAllowed(false);
		// tablaFunciones.setBounds(20, 104, 154, 83);
		JScrollPane scrollFuncion = new JScrollPane(tablaFunciones);
		scrollFuncion.setBounds(24, 109, 194, 129);
		add(scrollFuncion);

		comboBoxFunciones = new JComboBox();
		comboBoxFunciones.setBounds(228, 117, 46, 22);
		add(comboBoxFunciones);

		btnCargarFunciones = new JButton("Cargar Funciones");
		btnCargarFunciones.setBounds(31, 299, 145, 23);
		add(btnCargarFunciones);
		btnCargarFunciones.addActionListener(controlador);

		grupoHora = new ButtonGroup();

		rdb16 = new JRadioButton("16:00");
		rdb16.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdb16.setBounds(536, 106, 109, 23);
		add(rdb16);
		grupoHora.add(rdb16);
		rdb16.setSelected(true);
		rdb16.addActionListener(controlador);

		rdb19 = new JRadioButton("19:00");
		rdb19.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdb19.setBounds(536, 130, 109, 23);
		add(rdb19);
		grupoHora.add(rdb19);
		rdb19.addActionListener(controlador);

		rdb22 = new JRadioButton("22:00");
		rdb22.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdb22.setBounds(536, 156, 109, 23);
		add(rdb22);
		grupoHora.add(rdb22);
		rdb22.addActionListener(controlador);

		txtFila = new JTextField();
		txtFila.setBounds(465, 243, 35, 20);
		add(txtFila);
		txtFila.setColumns(10);

		txtColumna = new JTextField();
		txtColumna.setColumns(10);
		txtColumna.setBounds(465, 268, 35, 20);
		add(txtColumna);

		mapaAsientos = new JTextArea();
		mapaAsientos.setEditable(false);
		mapaAsientos.setFont(new Font("Monospaced", Font.BOLD, 14)); // PROANDO
		mapaAsientos.setBounds(295, 104, 221, 117);
		add(mapaAsientos);

	}

	// METODO PARA USAR EL JTEXTAREA PARA IMPRIMIR LOS ASIENTOS AHI
	public void setMapaAsientos(String mapaAsientos) {
		this.mapaAsientos.setText(mapaAsientos);
	}

	public String getFila() {
		return txtFila.getText();
	}

	public String getColumna() {
		return txtColumna.getText();
	}

	public String getHora() {
		String hora = null;
		if (rdb16.isSelected()) {
			hora = "16:00";
		} else if (rdb19.isSelected()) {
			hora = "19:00";
		} else {
			hora = "22:00";
		}
		return hora;
	}

	public int getFuncionSeleccionada() {
		return comboBoxFunciones.getSelectedIndex(); // RETORNO EL VALOR DONDE ESTA EL JCOMBO SELECCIONADO
	}

	public JButton getBotonCargarFunciones() {
		return btnCargarFunciones;
	}

	public JButton getAgregarEntrada() {
		return btnAgregarEntrada;
	}
	public JRadioButton getBotonRadio16() {
		return rdb16;
	}
	public JRadioButton getBotonRadio19() {
		return rdb19;
	}
	public JRadioButton getBotonRadio22() {
		return rdb22;
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

	public void setError(String mensaje) {
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
	}

	public void respuestaOK(String mensaje) {
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
	}

}
