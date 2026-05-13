package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.modelo.APICine;
import salasdecine.modelo.Funcion;
import salasdecine.vistas.AgregarEntradaFuncionVista;

public class AgregarEntradaFuncionControlador implements ActionListener {
	
	private AgregarEntradaFuncionVista vista;
	private APICine api = APICine.getInstance();
	
	public AgregarEntradaFuncionControlador(AgregarEntradaFuncionVista vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("SE HA PULSADO AGREGAR ENTRADA A LA FUNCION");
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
		else if(e.getSource()==vista.getAgregarEntrada()) {
			try {
				int fila=Integer.parseInt(vista.getFila());
				int columna=Integer.parseInt(vista.getColumna());
				int indiceFuncion=vista.getFuncionSeleccionada();
				Funcion funcionSeleccionada=api.getFuncionPorIndiceLista(indiceFuncion);//FUNCION SELECCIONADA POR EL INDICE DEL JCOMBOBOX
				int idFuncionSeleccionada=funcionSeleccionada.getIdFuncion(); //TENDRIA EL ID DE LA FUNCION SELECCIONADA
				String hora=vista.getHora();
				/*boolean disponible= funcionSeleccionada.consultarDisponibilidad(fila, columna, hora);
				vista.respuestaOK(disponible?"FUNCION DISPONIBLE": "¡FUNCION NO DISPONIBLE!");*/
				boolean entradaAgregada=api.agregarEntradaAFuncion(fila, columna, hora, funcionSeleccionada);
				if(entradaAgregada) {
					vista.respuestaOK("Entrada agregada correctamente");
					String mapa= funcionSeleccionada.mostrarAsientos(hora);
					vista.setMapaAsientos(mapa);
				}else {
					vista.setError("Este asiento ya esta ocupado");
				}
				
				
				
			}catch(NumberFormatException nfe) {
				System.out.println("LA FILA O LA COLUMNA TIENEN QUE SER NUMEROS");
				vista.setError("Fila o columna invalida");
				
			}catch(NullPointerException npe) {
				System.err.println("NO HAS ELEGIDO NINGUNA FUNCION");
				vista.setError("No has seleccionado ninguna funcion");
			}
		}
		
		
	}

}
