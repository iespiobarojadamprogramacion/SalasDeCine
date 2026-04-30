package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import salasdecine.controladores.DarAltaPeliculaControlador;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class DarAltaPeliculaVista extends JPanel{
	private DarAltaPeliculaControlador Controlador;
	private JTextField Textitulo;
	private JTextField Textduraccion;
	private JTextField Textgenero;
	private ButtonGroup buttomclasificacion;
	private JRadioButton radiosiete;
	private JRadioButton radiodoce;
	private JRadioButton radiodieciseis;
	private JRadioButton radiodieciocho;
	public DarAltaPeliculaVista() {
		Controlador=new DarAltaPeliculaControlador(this);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dar alta pelicula");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(143, 22, 136, 24);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(35, 63, 76, 12);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Duraccion");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(35, 96, 119, 12);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Genero");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(35, 133, 104, 12);
		add(lblNewLabel_3);
		
		JLabel labelclas = new JLabel("Clasificacion");
		labelclas.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelclas.setBounds(35, 168, 119, 12);
		add(labelclas);
		
		Textitulo = new JTextField();
		Textitulo.setBounds(131, 62, 159, 18);
		add(Textitulo);
		Textitulo.setColumns(10);
		
		Textduraccion = new JTextField();
		Textduraccion.setBounds(131, 95, 159, 18);
		add(Textduraccion);
		Textduraccion.setColumns(10);
		
		Textgenero = new JTextField();
		Textgenero.setBounds(131, 132, 159, 18);
		add(Textgenero);
		Textgenero.setColumns(10);
		
		JButton btnNewButton = new JButton("DarAlta");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(145, 219, 145, 20);
		add(btnNewButton);
		btnNewButton.addActionListener(Controlador);
		buttomclasificacion=new ButtonGroup ();
		radiosiete= new JRadioButton("SIETE");
		radiosiete.setBounds(132, 166, 62, 20);
		add(radiosiete);
		buttomclasificacion.add(radiosiete);
		radiosiete.setSelected(true);
		 radiodoce = new JRadioButton("DOCE");
		radiodoce.setBounds(196, 166, 76, 20);
		add(radiodoce);
		buttomclasificacion.add(radiodoce);
		 radiodieciseis = new JRadioButton("DIECISESIS");
		radiodieciseis.setBounds(274, 166, 87, 20);
		add(radiodieciseis);
		buttomclasificacion.add(radiodieciseis);
		 radiodieciocho = new JRadioButton("DIECIOCHO");
		radiodieciocho.setBounds(361, 166, 102, 20);
		add(radiodieciocho);
		buttomclasificacion.add(radiodieciocho);
	}
	public String getTitulo() {
		return Textitulo.getText();
	}
	public String getDuraccion () {
		return Textduraccion.getText();
	}
	public String getgenero() {
		return Textgenero.getText();
	}
	public String getClasificacion() {
		String Clasificacion=null;
		
		if(radiosiete.isSelected()) {
			Clasificacion="SIETE";
		}else if (radiodoce.isSelected()){
			Clasificacion="DOCE";
			
		}else if (radiodieciseis.isSelected()) {
			Clasificacion="DIECISEIS";
		}else if (radiodieciocho.isSelected()) {
			Clasificacion="DIECIOCHO";
		}
		
		return Clasificacion;
	}
	public void setError(String mensaje) {
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
	}
}
