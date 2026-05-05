package salasdecine.vistas;

import javax.swing.JPanel;

import salasdecine.controladores.DarAltaFuncionControlador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class DarAltaFuncionVista extends JPanel {
	
	private DarAltaFuncionControlador controlador;
	private JTable table;
	private ButtonGroup buttomSala;
	private JRadioButton rdbtniSense;
	private JRadioButton rdbtnImax;
	private JRadioButton rdbtnLUXE;
	private JRadioButton rdbtnDolbyAtmos;
	private JRadioButton rdbtnMaxScreen;
	private JRadioButton rdbtnVision;
	private JRadioButton rdbtnImmersiveRoom;
	private final String[] cabeceraTabla= {"Nº", "NOMBRE"};
	private String [][] datosTabla= new String [20][2]; //IRAN LOS DATOS DE LAA TABLA
	private JButton btnAltaFuncion;
	private JButton btnVerPeliculas;
	private JComboBox comboBox;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	
	public DarAltaFuncionVista() {
		controlador = new DarAltaFuncionControlador(this);
		setLayout(null);
		buttomSala = new ButtonGroup();
		
		JLabel lblNewLabel = new JLabel("DAR ALTA FUNCION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(133, 11, 214, 14);
		add(lblNewLabel);
		
		btnAltaFuncion = new JButton("Alta Funcion");
		btnAltaFuncion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAltaFuncion.setBounds(227, 374, 154, 23);
		add(btnAltaFuncion);
		btnAltaFuncion.addActionListener(controlador);
		
		rdbtniSense = new JRadioButton("iSense");
		rdbtniSense.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtniSense.setBounds(6, 68, 109, 23);
		add(rdbtniSense);
		buttomSala.add(rdbtniSense);
		rdbtniSense.setSelected(true);
		
		rdbtnImax = new JRadioButton("IMax");
		rdbtnImax.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnImax.setBounds(6, 94, 109, 23);
		add(rdbtnImax);
		buttomSala.add(rdbtnImax);
		
		rdbtnLUXE = new JRadioButton("LUXE");
		rdbtnLUXE.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnLUXE.setBounds(6, 120, 109, 23);
		add(rdbtnLUXE);
		buttomSala.add(rdbtnLUXE);
		
		rdbtnDolbyAtmos = new JRadioButton("Dolby Atmos");
		rdbtnDolbyAtmos.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnDolbyAtmos.setBounds(6, 146, 109, 23);
		add(rdbtnDolbyAtmos);
		buttomSala.add(rdbtnDolbyAtmos);
		
		rdbtnMaxScreen = new JRadioButton("Max Screen");
		rdbtnMaxScreen.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnMaxScreen.setBounds(6, 172, 109, 23);
		add(rdbtnMaxScreen);
		buttomSala.add(rdbtnMaxScreen);
		
		rdbtnVision = new JRadioButton("4k-Vision");
		rdbtnVision.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnVision.setBounds(6, 198, 109, 23);
		add(rdbtnVision);
		buttomSala.add(rdbtnVision);
		
		rdbtnImmersiveRoom = new JRadioButton("Immersive Room");
		rdbtnImmersiveRoom.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnImmersiveRoom.setBounds(6, 224, 143, 23);
		add(rdbtnImmersiveRoom);
		buttomSala.add(rdbtnImmersiveRoom);
		
		JLabel lblNewLabel_1 = new JLabel("Elige una sala");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(6, 45, 128, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Elige una pelicula del catalogo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(193, 45, 214, 14);
		add(lblNewLabel_1_1);
		
		table = new JTable(datosTabla, cabeceraTabla); // <--- PASAMOS PRIMERO LOS DATOS DE LA TABLA Y LA CABECERA DE LA												// TABLA
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		// table.setBounds(107, 195, 244, 49); //ANCHO ALTO
		table.setGridColor(Color.BLACK); // <--EL COLOR
		table.setBackground(new Color(255, 255, 255)); // <-- MAS COLOR
		JScrollPane scrollTabla = new JScrollPane(table); // <--SCROLL POR SI FUERA NECESARIO
		scrollTabla.setBounds(215, 71, 150, 150);
		// add(table);
		add(scrollTabla);
		
		//probando solo para luego intentar usar 
		/*comboBox = new JComboBox();
		comboBox.setBounds(375, 120, 60, 22);
		add(comboBox);*/
		

		btnVerPeliculas = new JButton("Ver peliculas");
		btnVerPeliculas.addActionListener(controlador);//ESTE TENGO QUE EDITAR SOLO PARA QUE MUESTRE LAS PELICULAS
		btnVerPeliculas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerPeliculas.setBounds(370, 82, 109, 23);
		add(btnVerPeliculas);
		
		JLabel lblNewLabel_1_2 = new JLabel("Elige una fecha inicio");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(6, 274, 166, 14);
		add(lblNewLabel_1_2);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setText("--/--/----");
		txtFechaInicio.setBounds(29, 297, 86, 20);
		add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Elige una fecha fin");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(259, 275, 166, 14);
		add(lblNewLabel_1_2_1);
		
		txtFechaFin = new JTextField();
		txtFechaFin.setText("30/12/2026");
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(279, 297, 86, 20);
		add(txtFechaFin);
	}
	//DEVOLVER EL STRING DEL RADIOBUTTON
	public String getSala() {
		String salaElegida=null;
		
		if(rdbtniSense.isSelected()) {
			salaElegida="iSense";
		}else if (rdbtnImax.isSelected()){
			salaElegida="IMax";
		}else if (rdbtnLUXE.isSelected()) {
			salaElegida="LUXE";
		}else if (rdbtnDolbyAtmos.isSelected()) {
			salaElegida="Dolby Atmos";
		}else if (rdbtnMaxScreen.isSelected()) {
			salaElegida="Max Screen";
		}else if (rdbtnVision.isSelected()) {
			salaElegida="4k-Vision";
		}else if (rdbtnImmersiveRoom.isSelected()) {
			salaElegida="Immersive Room";
		}
		
		return salaElegida;
	}
	//DEVOLVERA EL STRING DEL JCOMBOBOX
	public String getPeliculaSeleccionada() {
		
		String peliculaSeleccionada= (String)comboBox.getSelectedItem();
		System.out.println("PELICULA SELECCIONADA Nª " + peliculaSeleccionada);
		return peliculaSeleccionada;
		
	}
	public String getFechaInicio() {
		return txtFechaInicio.getText();
	}
	public String getFechaFin() {
		return txtFechaFin.getText();
	}
	//SOLO MUESTRA VALOR
	public void setPeliculas(String [][] peliculas) {
		int i=0;
		for(;i<peliculas.length; i++) {
			System.out.println(peliculas[i][0]);
			System.out.println(peliculas[i][1]);
		}
		System.out.println(i); //valor que usare
		table.setModel((new javax.swing.table.DefaultTableModel(peliculas, cabeceraTabla)));
		//datosTabla=cliente; //EL CLIENTE QUE TENEMOS LO GUARDAMOS EN LA TABLA
		
	}
	//LO HICE PARA QUE CUANDO LA LLAME DESDE EL CONTROLADOR ME MONTE EN JComboBox SEGUN LA CANTIDAD DE PELICULAS QUE HAY EN LA LISTA,
	//COMO ESE VALOR LO GUARDE EN UN STRING CON LOS NUMEROS
	public void numerosDePeliculas(String [] resultadoNumeroPeliculas) {
		comboBox = new JComboBox();
		comboBox.setBounds(375, 120, 60, 22);
		add(comboBox);
		for(int i=0; i<resultadoNumeroPeliculas.length; i++ ) {
			comboBox.addItem(resultadoNumeroPeliculas[i]);
		}
		//QUIZAS AQUI PUEDA RETORNAR EL VALOR Y QUITO EL METODO DE ARRIBA

	}
	
	public JButton getBtnVerPeliculas() {
	    return btnVerPeliculas; //para poder ver el listado de las peliculas
	}
	public JButton getBtnAltaFuncion() {
	    return btnAltaFuncion;
	}
	
	public void setError(String mensaje) {
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
	}
	public void respuestaOK(String mensaje) {
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
	}
}
