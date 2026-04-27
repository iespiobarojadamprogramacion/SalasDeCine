package salasdecine.vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class ListaClienteVista extends JPanel{
	public ListaClienteVista() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LISTA DE LOS CLIENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(117, 11, 230, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("La lista de los clientes es:");
		lblNewLabel_1.setBounds(34, 43, 179, 14);
		add(lblNewLabel_1);
	}
	

}
