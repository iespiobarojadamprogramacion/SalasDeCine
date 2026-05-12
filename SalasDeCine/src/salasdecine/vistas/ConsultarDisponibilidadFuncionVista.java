package salasdecine.vistas;

import javax.swing.JPanel;

import salasdecine.controladores.ConsultarDisponibilidadFuncionControlador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class ConsultarDisponibilidadFuncionVista extends JPanel {

	private ConsultarDisponibilidadFuncionControlador controlador;
	private JTable tablaFunciones;
	private JTextField txtFila;
	private JTextField txtColumna;
	private JComboBox comboBoxFunciones;
	private JButton btnCargarFunciones;
	private JRadioButton rdb16;
	private JRadioButton rdb19;
	private JRadioButton rdb22;
	private JButton btnConsultar;
	private ButtonGroup grupoHora;
	private final String[] cabeceraTabla = { "Nº", "Titulo", "Sala" };
	private String[][] datosTabla = new String[20][3];

	public ConsultarDisponibilidadFuncionVista() {
		controlador = new ConsultarDisponibilidadFuncionControlador(this);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("CONSULTAR DISPONIBILIDAD FUNCION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(114, 11, 390, 14);
		add(lblNewLabel);

		tablaFunciones = new JTable(datosTabla, cabeceraTabla);
		//tablaFunciones.setBounds(20, 104, 154, 83);
		JScrollPane scrollFuncion = new JScrollPane(tablaFunciones);
		scrollFuncion.setBounds(20, 104, 154, 83);
		add(scrollFuncion);

		comboBoxFunciones = new JComboBox();
		comboBoxFunciones.setBounds(186, 104, 46, 22);
		add(comboBoxFunciones);

		btnCargarFunciones = new JButton("Cargar Funciones");
		btnCargarFunciones.setBounds(20, 209, 145, 23);
		add(btnCargarFunciones);
		btnCargarFunciones.addActionListener(controlador);

		JLabel lblNewLabel_1 = new JLabel("Selecciona una funcion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 67, 170, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Fila: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(273, 103, 46, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Columna:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(273, 128, 75, 14);
		add(lblNewLabel_2_1);

		txtFila = new JTextField();
		txtFila.setBounds(347, 101, 35, 20);
		add(txtFila);
		txtFila.setColumns(10);

		txtColumna = new JTextField();
		txtColumna.setColumns(10);
		txtColumna.setBounds(347, 127, 35, 20);
		add(txtColumna);

		JLabel lblNewLabel_1_1 = new JLabel("Selecciona");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(262, 67, 154, 14);
		add(lblNewLabel_1_1);

		grupoHora = new ButtonGroup();

		rdb16 = new JRadioButton("16:00");
		rdb16.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdb16.setBounds(427, 100, 109, 23);
		add(rdb16);
		grupoHora.add(rdb16);
		rdb16.setSelected(true);

		rdb19 = new JRadioButton("19:00");
		rdb19.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdb19.setBounds(427, 126, 109, 23);
		add(rdb19);
		grupoHora.add(rdb19);

		rdb22 = new JRadioButton("22:00");
		rdb22.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdb22.setBounds(427, 152, 109, 23);
		add(rdb22);
		grupoHora.add(rdb22);

		JLabel lblNewLabel_3 = new JLabel("Selecciona Hora");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(425, 67, 129, 14);
		add(lblNewLabel_3);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(247, 286, 89, 23);
		add(btnConsultar);
		btnConsultar.addActionListener(controlador);
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
			hora = "22.00";
		}
		return hora;
	}
	public int getFuncionSeleccionada() {
		return comboBoxFunciones.getSelectedIndex(); //RETORNO EL VALOR DONDE ESTA EL JCOMBO SELECCIONADO
	}

	public JButton getBotonCargarFunciones() {
		return btnCargarFunciones;
	}

	public JButton getConsultar() {
		return btnConsultar;
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
