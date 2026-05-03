package salasdecine.vistas;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import salasdecine.controladores.RegistrarClienteControlador;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class RegistrarClienteVista extends JPanel{
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtFechaNacimiento;
	private RegistrarClienteControlador controlador;
	public RegistrarClienteVista() {
		setLayout(null);
		
		//CREAMOS EL OBJETO CONTROLADOR 
		controlador=new RegistrarClienteControlador(this);
		
		JLabel lblNewLabel = new JLabel("REGISTRAR CLIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(145, 11, 175, 27);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 51, 74, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("EMAIL:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 82, 74, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("FECHA NACIMIENTO:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 112, 161, 14);
		add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(180, 171, 106, 23);
		add(btnNewButton);
		//EVENTO QUE ESCUCHARA AL PULSAR EL BOTON Y CUANDO PASE ESTO EJECUTARA EL CONTROLADOR 
		//RegistrarClienteControlador.(LO QUE ESTE EN EL METODO DE ESA CLASE)
		btnNewButton.addActionListener(controlador);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(85, 49, 201, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(69, 81, 217, 20);
		add(txtEmail);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(169, 111, 183, 20);
		add(txtFechaNacimiento);
	}
	public String getNombre() {
		return txtNombre.getText();
	}
	public String getEmail() {
		return txtEmail.getText();
	}
	public String getFechaNacimiento() {
		return txtFechaNacimiento.getText();
	}
	//MENSAJE PARA UNA ALERTA, SE HARA UNA ALERTA CON ESE MENSAJE
	public void setError(String mensaje) {
		//PARA QUE HAGA LA ALERTA
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
		//CUANDO LO USEMOS ESTO EN EL CONTROLADOR HABRIA QUE LLAMARLO POR EJEMPLO:
		//vista.setError("ERROR QUE QUIERAS DECIR");
	}
	public void respuestaOK(String mensaje) {
		JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(this), mensaje);
	}
}
