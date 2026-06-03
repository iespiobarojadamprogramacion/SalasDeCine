package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.modelo.APICine;
import salasdecine.vistas.ConsultarEntradasClientesVista;

public class ConsultarEntradasClientesControlador implements ActionListener{
	private ConsultarEntradasClientesVista vista;
	private APICine api = APICine.getInstance();
	
	public ConsultarEntradasClientesControlador(ConsultarEntradasClientesVista vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("HAS SELECCIONADO MOSTRAR ENTRADAS DE CLIENTES");
		String [][] ListaClientes;
		String []resultadoNumeroClientes;
		if(e.getSource()==vista.getBotonCargarClientes()) {
			try {
				ListaClientes=api.entradaCliente();
				vista.setClientes(ListaClientes);
				resultadoNumeroClientes=api.numerosClienteLista();
				vista.numerosDeClientesComboBox(resultadoNumeroClientes);
				
			}catch (NullPointerException e1 ) {
				System.out.println("no hay resultados");
				vista.setError("No hay clientes registrados!");
			}
		}else if(e.getSource()==vista.getBotonConsultarEntradas()){
		    try {
		        int indiceCliente = vista.getClienteSeleccionado();
		        String[][] entradasCliente =api.consultarEntradasCliente(indiceCliente);
		        vista.setEntradas(entradasCliente);
		    } catch (NullPointerException npe) {
		        vista.setError("El cliente no tiene entradas");

		    }
		}
		
	}

}
