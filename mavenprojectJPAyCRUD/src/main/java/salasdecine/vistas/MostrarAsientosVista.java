package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import salasdecine.controladores.MostrarAsientosControlador;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class MostrarAsientosVista extends JPanel {

	private JTable tablaFunciones;
	private MostrarAsientosControlador controlador;
	private JRadioButton rdb16;
	private JRadioButton rdb19;
	private JRadioButton rdb22;
	private ButtonGroup grupoHora;
	private JButton btnCargarFunciones;
	private JComboBox comboBoxFunciones;
	private JTextArea mapaAsientos;
	private final String[] cabeceraTabla = { "Nº", "Titulo", "Sala" };
	private String[][] datosTabla = new String[20][3];
	private JLabel lblNewLabel_2;

	public MostrarAsientosVista() {
		controlador = new MostrarAsientosControlador(this);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("MOSTRAR ASIENTOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(201, 11, 241, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Selecciona una funcion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(27, 56, 170, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Selecciona Hora");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(368, 56, 129, 14);
		add(lblNewLabel_3);

		tablaFunciones = new JTable(datosTabla, cabeceraTabla);
		tablaFunciones.getTableHeader().setReorderingAllowed(false);
		// tablaFunciones.setBounds(20, 104, 154, 83);
		JScrollPane scrollFuncion = new JScrollPane(tablaFunciones);
		scrollFuncion.setBounds(24, 81, 194, 129);
		add(scrollFuncion);

		comboBoxFunciones = new JComboBox();
		comboBoxFunciones.setBounds(228, 81, 46, 22);
		add(comboBoxFunciones);

		btnCargarFunciones = new JButton("Cargar Funciones");
		btnCargarFunciones.setBounds(27, 221, 145, 23);
		add(btnCargarFunciones);
		btnCargarFunciones.addActionListener(controlador);

		grupoHora = new ButtonGroup();

		rdb16 = new JRadioButton("16:00");
		rdb16.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdb16.setBounds(368, 81, 109, 23);
		add(rdb16);
		grupoHora.add(rdb16);
		rdb16.setSelected(true);
		rdb16.addActionListener(controlador);

		rdb19 = new JRadioButton("19:00");
		rdb19.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdb19.setBounds(368, 107, 109, 23);
		add(rdb19);
		grupoHora.add(rdb19);
		rdb19.addActionListener(controlador);

		rdb22 = new JRadioButton("22:00");
		rdb22.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdb22.setBounds(368, 133, 109, 23);
		add(rdb22);
		grupoHora.add(rdb22);
		rdb22.addActionListener(controlador);

		mapaAsientos = new JTextArea();
		mapaAsientos.setEditable(false);
		mapaAsientos.setFont(new Font("Monospaced", Font.BOLD, 14)); // PROANDO
		mapaAsientos.setBounds(265, 204, 278, 173);
		add(mapaAsientos);

		lblNewLabel_2 = new JLabel("Mapa asientos:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(348, 179, 129, 14);
		add(lblNewLabel_2);

	}

	// METODO PARA USAR EL JTEXTAREA PARA IMPRIMIR LOS ASIENTOS AHI
	public void setMapaAsientos(String mapaAsientos) {
		this.mapaAsientos.setText(mapaAsientos);
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
