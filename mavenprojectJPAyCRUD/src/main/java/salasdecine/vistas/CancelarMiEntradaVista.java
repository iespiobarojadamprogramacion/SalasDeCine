package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class CancelarMiEntradaVista extends JPanel {
	private JTextField txtIDCliente;
	public CancelarMiEntradaVista() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CANCELAR MI ENTRADA (OPCION CLIENTE)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(150, 11, 397, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Introduce tu ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(48, 50, 117, 14);
		add(lblNewLabel_1);
		
		txtIDCliente = new JTextField();
		txtIDCliente.setBounds(48, 75, 86, 20);
		add(txtIDCliente);
		txtIDCliente.setColumns(10);
	}
}
