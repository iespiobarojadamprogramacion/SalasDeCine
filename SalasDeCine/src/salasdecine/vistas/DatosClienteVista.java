package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class DatosClienteVista extends JPanel {
	private JTextField textField;
	public DatosClienteVista() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VER DATOS CLIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(140, 22, 201, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(77, 77, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID CLIENTE:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 80, 69, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dame el siguiente dato del cliente");
		lblNewLabel_2.setBounds(10, 52, 211, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Los datos del cliente son:");
		lblNewLabel_2_1.setBounds(10, 119, 176, 14);
		add(lblNewLabel_2_1);
	}
}
