package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.modelo.APICine;
import salasdecine.utilidades.NotFoundClienteException;
import salasdecine.vistas.DatosClienteVista;
import salasdecine.vistas.ListaClienteVista;

public class ListaClienteControlador implements ActionListener {
	
	private ListaClienteVista vista;
	private APICine api = APICine.getInstance(); // <-- TODOS LOS CONTROLADORES TIENEN QUE TENERLO PARA COMUNICARSE CON LA SUBMAIN
	
	public ListaClienteControlador (ListaClienteVista vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("SE HA PULSADO VER LISTA DE CLIENTE");
		String [][]resultadoListaCliente;
		
		try {
			
			resultadoListaCliente=api.listaCliente(); //OBTENEMOS DEL API Y GUARDAMOS EL CLIENTE 
			vista.setClientes(resultadoListaCliente); //EL DATO QUE HEMOS OBTENIDO DE RESULTADOCLIENTE DE LA API (TENDRIAMOS EL CLIENTE CON ESE ID EN LA TABLA)			
		} catch (NullPointerException npe) {
			System.out.println("Lista Vacia");
			vista.setError("La lista de los clientes esta vacia");
		} 
		
		
		
	}

}
