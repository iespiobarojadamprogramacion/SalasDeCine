package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.vistas.DarAltaPeliculaVista;

public class DarAltaPeliculaControlador implements ActionListener {
	private DarAltaPeliculaVista vista;
	public DarAltaPeliculaControlador( DarAltaPeliculaVista vista) {
		this.vista=vista;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Dar de alta pelicula");
		String Titulo=vista.getTitulo();
		String Duraccion=vista.getDuraccion();
		String genero=vista.getgenero();
		String clasificacion=vista.getClasificacion();
		try {
			int duraccion=Integer.parseInt(Duraccion);
			
			System.out.println(Titulo+" "+duraccion+" "+genero+" "+clasificacion);
		}catch(NumberFormatException enf) {
			System.out.println("no has introducido un numero valido");
			vista.setError("Has introducido valor no numerico");
		}
		
		
	}

}
