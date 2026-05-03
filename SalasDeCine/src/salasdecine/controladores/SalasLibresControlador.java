package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import salasdecine.modelo.APICine;
import salasdecine.vistas.SalasLibresVista;

public class SalasLibresControlador implements ActionListener {
	
	private SalasLibresVista vista;
	private APICine api =APICine.getInstance();

	public SalasLibresControlador (SalasLibresVista vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("HAS ELEGIDO MOSTRAR SALAS LIBRES");
		String [][]salasLibres;
		try {
			salasLibres=api.salasLibres();
			vista.setSalasLibres(salasLibres);
		}catch(NullPointerException npe) {
			System.out.println("Lista Vacia");
			vista.setError("La lista de las salas libres esta vacia");
		}
		
	}

}
