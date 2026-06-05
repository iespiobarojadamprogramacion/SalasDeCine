package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.modelo.APICine;
import salasdecine.vistas.SalasOcupadasVista;

public class SalasOcupadasControlador implements ActionListener {
	
	private SalasOcupadasVista vista;
	private APICine api =APICine.getInstance();
	
	public SalasOcupadasControlador(SalasOcupadasVista vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("HAS ELEGIDO MOSTRAR SALAS OCUPADAS");
		String [][]salasOcupadas;
		try {
			salasOcupadas=api.salasOcupadas();
			vista.setSalasLibres(salasOcupadas);
		}catch(NullPointerException npe) {
			System.out.println("Lista Vacia");
			vista.setError("La lista de las salas ocupadas esta vacia");
		}
		
		
	}

}
