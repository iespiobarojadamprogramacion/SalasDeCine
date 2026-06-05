package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.modelo.APICine;
import salasdecine.vistas.MostrarSalasVista;

public class MostrarSalasControlador implements ActionListener {

	private MostrarSalasVista vista;
	private APICine api = APICine.getInstance(); // <-- TODO CONTROLADOR LO NECESITA PARA COMUNICARSE CON LA SUBMAIN

	public MostrarSalasControlador(MostrarSalasVista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("HAS ELEGIDO MOSTRAR TODAS LAS SALAS");
		String[][] resultadoListaSalas;
		try {
			resultadoListaSalas = api.mostrarTodasLasSalas(); // OBTENEMOS DEL API Y GUARDAMOS EL CLIENTE
			vista.setClientes(resultadoListaSalas); // EL DATO QUE HEMOS OBTENIDO DE RESULTADOCLIENTE DE LA API
														// (TENDRIAMOS EL CLIENTE CON ESE ID EN LA TABLA)
		} catch (NullPointerException npe) {
			System.out.println("Lista Vacia");
			vista.setError("La lista de las salas esta vacia");
		}

	}

}
