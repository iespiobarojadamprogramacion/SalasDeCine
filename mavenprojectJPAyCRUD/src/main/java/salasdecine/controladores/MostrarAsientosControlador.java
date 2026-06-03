package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.modelo.APICine;
import salasdecine.modelo.Funcion;
import salasdecine.vistas.MostrarAsientosVista;

public class MostrarAsientosControlador implements ActionListener {
	private MostrarAsientosVista vista;
	private APICine api=APICine.getInstance();
	
	public MostrarAsientosControlador(MostrarAsientosVista vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("HAS ELEGIDO MOSTRAR MAPAS ASIENTOS");
		String [][] ListaFunciones;
		String [] resultadoNumeroFuncionesComboBox;
		
		if(e.getSource()==vista.getBotonCargarFunciones()) {
			try{
				ListaFunciones=api.funcioneslista();
				vista.setFunciones(ListaFunciones);
				resultadoNumeroFuncionesComboBox=api.numerosFuncionesLista();
				vista.numerosDeFuncionesComboBox(resultadoNumeroFuncionesComboBox);			
			}catch(NullPointerException e1 ) {
				System.out.println("no hay resultados");
				vista.setError("No hay funciones disponibles!");
			}
		}else if(e.getSource()==vista.getBotonRadio16() ||e.getSource()==vista.getBotonRadio19() || e.getSource()==vista.getBotonRadio22() ) {		
			int indiceFuncion=vista.getFuncionSeleccionada();
			Funcion funcionSeleccionada=api.getFuncionPorIndiceLista(indiceFuncion);
			//funcionSeleccionada.mostrarAsientos(vista.getHora()); 
			if (funcionSeleccionada!=null) {
				String mapa = funcionSeleccionada.mostrarAsientos(vista.getHora()); //<--tengo que poner la hora que tengo en el radiobutton 
				vista.setMapaAsientos(mapa);
			}		
			
		}
		
	}

}
