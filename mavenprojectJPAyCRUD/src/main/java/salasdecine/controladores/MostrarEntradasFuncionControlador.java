package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.modelo.APICine;
import salasdecine.modelo.Funcion;
import salasdecine.vistas.MostrarEntradasFuncionVista;

public class MostrarEntradasFuncionControlador implements ActionListener {
	private MostrarEntradasFuncionVista vista;
	private APICine api= APICine.getInstance();
	
	public MostrarEntradasFuncionControlador(MostrarEntradasFuncionVista vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("SE HA PULSADO MOSTRAR ENTRADAS FUNCION");
		String [][] ListaFunciones;
		String [] resultadoNumeroFuncionesComboBox;
		String [][] listaEntradas;
		
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
		}else if (e.getSource()==vista.getBotonConsultarEntradas()) {
			
			try {
				int indiceFuncion=vista.getFuncionSeleccionada();
				Funcion funcionSeleccionada=api.getFuncionPorIndiceLista(indiceFuncion);//FUNCION SELECCIONADA POR EL INDICE DEL JCOMBOBOX
				int idFuncionSeleccionada=funcionSeleccionada.getIdFuncion(); //TENDRIA EL ID DE LA FUNCION SELECCIONADA
			    listaEntradas = api.entradasPorFuncion(funcionSeleccionada);
			    vista.setEntradas(listaEntradas);

			} catch (NullPointerException ex) {
			    vista.setError("La función no tiene entradas");

			}
		}
		
	}

}
