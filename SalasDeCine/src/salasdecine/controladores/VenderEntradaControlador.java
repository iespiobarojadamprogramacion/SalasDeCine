package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.modelo.APICine;
import salasdecine.vistas.VenderEntradaVista;

public class VenderEntradaControlador implements ActionListener{
	private VenderEntradaVista vista;
	private APICine api=APICine.getInstance();
	
	public VenderEntradaControlador(VenderEntradaVista vista) {
		this.vista=vista;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("HAS ELEGIDO VENDER ENTRADA");
		String [][] Listafunciones=api.funcioneslista();
		String [][] ListaClientes=api.entradaCliente();
		if(e.getSource()==vista.getBotonclientes()) {
			try {
				ListaClientes=api.entradaCliente();
				vista.setClientes(ListaClientes);
				
			}catch (NullPointerException e1 ) {
				System.out.println("no hay resultados");
			}
		}else if (e.getSource()==vista.getBotonfunciones()){
			try {
				vista.setFunciones(Listafunciones);
			}catch (NullPointerException e1 ) {
				System.out.println("no hay resultados");
			}
			
		}
		
			
		
	}

}
