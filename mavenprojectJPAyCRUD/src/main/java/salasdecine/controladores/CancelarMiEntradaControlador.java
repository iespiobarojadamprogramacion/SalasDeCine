package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.modelo.APICine;
import salasdecine.vistas.CancelarMiEntradaVista;

public class CancelarMiEntradaControlador implements ActionListener {
	private CancelarMiEntradaVista vista;
	private APICine api = APICine.getInstance();
	
	public CancelarMiEntradaControlador(CancelarMiEntradaVista vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
