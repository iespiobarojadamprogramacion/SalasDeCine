package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.modelo.APICine;
import salasdecine.modelo.Pelicula;
import salasdecine.modelo.Sala;
import salasdecine.utilidades.FechaInvalidaException;
import salasdecine.utilidades.SalaOcupadaException;
import salasdecine.utilidades.Util;
import salasdecine.vistas.DarAltaFuncionVista;

public class DarAltaFuncionControlador implements ActionListener {

	private DarAltaFuncionVista vista;
	private APICine api = APICine.getInstance();

	public DarAltaFuncionControlador(DarAltaFuncionVista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		System.out.println("HAS ELEGIDO DAR DE ALTA FUNCION");
		String sala = vista.getSala();
		String [][] resultadoPeliculas;
		String [] resultadoNumeroPeliculas;
		
		
		//PRIMERA OPCION SOLO PARA CARGAR LA LISTA
		if(e.getSource()==vista.getBtnVerPeliculas()) {
			System.out.println("SE PULSO PARA CARGAR EL LISTADO DE PELICULAS");
			
			try {
				/*
				 * USABA DEL API listaPeliculas PERO ERA CON DATOS QUE NO ESTAN EN UNA BASE DE DATOS
				resultadoPeliculas = api.listaPeliculas(); // OBTENEMOS DEL API Y GUARDAMOS LAS PELICULAS
				*/
				//AHORA USAMOS EL NUEVO METODO QUE CONSULTARA DE LA BASE
				resultadoPeliculas=api.listaPeliculasJDBC();	
				
				vista.setPeliculas(resultadoPeliculas); // EL DATO QUE HEMOS OBTENIDO DE RESULTADOCLIENTE DE LA API
				/*
				 * FUNCION QUE USABAMOS ANTES DE IMPLANTAR JDBC
				resultadoNumeroPeliculas=api.numerosDePeliculas(); //aqui tengo la cantidad de peliculas en un array 
				*/
				//NUEVA FUNCION Y METODO QUE SE USA PARA JDBC
				resultadoNumeroPeliculas=api.numerosDePeliculasJDBC();
				vista.numerosDePeliculas(resultadoNumeroPeliculas);
										
			} catch (NullPointerException npe) {
				System.out.println("Lista Vacia");
				vista.setError("La lista de las peliculas esta vacia");
			}
			
		//AQUI YA LO USAMOS PARA DAR DE ALTA LA FUNCION
		}else if(e.getSource()==vista.getBtnAltaFuncion()) {
			System.out.println("SE PULSO PARA DAR DE ALTA FUNCION");
			String fechaInicio=vista.getFechaInicio();
			String fechaFin=vista.getFechaFin();
	
			try {
				
				String seleccion=vista.getPeliculaSeleccionada(); //PASO A ENTERO EL VALOR QUE TIENE EL JCOMOB
				if(seleccion==null) {
					throw new IllegalStateException("No tienes peliculas dadas de alta");
					
				}
				
				int indice =Integer.parseInt(seleccion)-1;
				
				/*USADO EN EL ANTERIOR MODO
				String[][] peliculas=api.listaPeliculas();	
				String nombrePelicula=peliculas[indice][1];
				*/
				//NUEVO CON EL JDBC
				String nombreSala=vista.getSala();	
				Sala salaClase =api.getSalaPorNombre(nombreSala);
				
				if(sala==null) {
					vista.setError("Sala no encontrada");
				}
				/* USADO CON EL QUE ESTA COMENTADO MAS ARRIBA
				Pelicula pelicula= api.getPeliculaPorIndice(indice);
				*/
				//NUEVO CON EL JDBC
				Pelicula pelicula = api.getPeliculaPorIndiceJDBC(indice);
				
				if(pelicula==null) {
					vista.setError("Pelicula no valida");
				}
				
				Util.validarFecha(fechaInicio);
				System.out.println(fechaInicio);
				Util.validarFecha(fechaFin);
				System.out.println(fechaFin);
				
				api.darAltaFuncion(fechaInicio, fechaFin, salaClase, pelicula);
				System.out.println("¡Funcion Registrada!");
				vista.respuestaOK("¡Funcion Registrada!");
				
				
			}catch(FechaInvalidaException fie){
				//mando el mensaje que esta en la clase fechaInvalidaException
				vista.setError(fie.getMessage());		
			}catch (IllegalStateException ie) {
				vista.setError(ie.getMessage());
				
			}catch(SalaOcupadaException soe) {
				vista.setError(soe.getMessage());
			}
		}
		
	}

}
