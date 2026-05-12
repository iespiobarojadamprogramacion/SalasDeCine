package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.modelo.APICine;
import salasdecine.modelo.Funcion;
import salasdecine.vistas.ConsultarDisponibilidadFuncionVista;

public class ConsultarDisponibilidadFuncionControlador implements ActionListener {
	
	private ConsultarDisponibilidadFuncionVista vista;
	private APICine api = APICine.getInstance();
	
	public ConsultarDisponibilidadFuncionControlador(ConsultarDisponibilidadFuncionVista vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("SE HA PULSADO CONSULTAR DISPONIBILIDAD FUNCION");
		String [][] ListaFunciones;
		String [] resultadoNumeroFuncionesComboBox;
		
		if(e.getSource()==vista.getBotonCargarFunciones()) {
			try {
				ListaFunciones =api.funcioneslista();
				vista.setFunciones(ListaFunciones);
				resultadoNumeroFuncionesComboBox=api.numerosFuncionesLista();
				vista.numerosDeFuncionesComboBox(resultadoNumeroFuncionesComboBox);
				
			}catch(NullPointerException e1 ) {
				System.out.println("no hay resultados");
				vista.setError("No hay funciones disponibles!");
			}
		}else if(e.getSource()==vista.getConsultar()) {
			try {
				int fila=Integer.parseInt(vista.getFila());
				int columna=Integer.parseInt(vista.getColumna());
				int indiceFuncion=vista.getFuncionSeleccionada();
				Funcion funcionSeleccionada=api.getFuncionPorIndiceLista(indiceFuncion);//FUNCION SELECCIONADA POR EL INDICE DEL JCOMBOBOX
				int idFuncionSeleccionada=funcionSeleccionada.getIdFuncion(); //TENDRIA EL ID DE LA FUNCION SELECCIONADA
				String hora=vista.getHora();
				boolean disponible= funcionSeleccionada.consultarDisponibilidad(fila, columna, hora);
				vista.respuestaOK(disponible?"FUNCION DISPONIBLE": "¡FUNCION NO DISPONIBLE!");
				
			}catch(NumberFormatException nfe) {
				System.out.println("LA FILA O LA COLUMNA TIENEN QUE SER NUMEROS");
				vista.setError("Fila o columna invalida");
				
			}
		}
		
	}

}
