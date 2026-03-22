package salasdecine.modelo;

import java.util.ArrayList;
import java.util.List;

public class Funcion {
	private static int indicador=0;
	private int idFuncion;
	private String fechaInicio;
	private String fechaFin;

	private String [] horarios;
	private boolean [][] mapaAsientos;
	private Sala sala;
	private Pelicula pelicula;
//	private Entrada [] entradas;//podemos poner array list? quizas sera mas comodo
	private List<Entrada> entradas;//guardar entradas en arraylist
	
	public Funcion (String fechaInicio, String fechaFin, Sala sala, Pelicula pelicula) {
		
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.sala=sala;
		this.pelicula=pelicula;
		inicializarMapaAsientos();
		idFuncion=++indicador;
		this.entradas=new ArrayList<>();//agrego una lista para cada funcion
		
	}
	
	public String getFechaInicio() {
		return fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public int getIdFuncion() {
		return idFuncion;
	}
	
	
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String[] getHorarios() {
		return horarios;
	}

	public void inicializarMapaAsientos() {
		int filas=sala.getFila();
		int columnas=sala.getColumna();
		mapaAsientos= new boolean [filas][columnas];
	}
	
	public boolean consultarDisponibilidadAsientos(int fila, int columna) {
		/*NECESITAMOS DEVOLVER SI EL ASIENTO ESTA DISPONIBLE, SI ES FALSE ESTA LIBRE*/
		if (asientoValido(fila, columna)==true) {
			//si el mapa esta en false significa que esta libre
			if (mapaAsientos[fila][columna]==false) {
				return true;//esta libre
			}else {
				return false;//asiento valido pero internamente esta true por lo tanto no disponible
			}		
		}else {
			return false; //fuera de rango 
		}
		
	}
	public void ocuparAsientoSala(int fila, int columna) {
		/*DEL MAPA DE ASIENTOS OCUPAR UN ASIENTO*/
		this.mapaAsientos[fila][columna]=true;
	}
	public void desocuparAsientoSala(int fila, int columna) {
		this.mapaAsientos[fila][columna]=false;
	}
	public String getMapaAsientoSala() {
		/*DEVOLVER ASIENTOS VISUALMENTE*/
		String mapaVisual="";
		for (int i=0; i<mapaAsientos.length; i++) {
			for (int j=0; j<mapaAsientos[i].length; j++) {
				/*ASIGNO CON UN TERNARIO SI ES TRUE PONGO X Y SI ES FALSE ESPACIO*/
				mapaVisual+=mapaAsientos[i][j] ? "[X]\t": "[ ]\t";
			}
			//LE DAMOS ESPACIO Y LO RETORNAMOS
			mapaVisual+="\n";
		}
		return mapaVisual;
		
	}
	//agrego las entradas a la funcion se usara cuando se venda una entrada
	public void agregarEntrada(Entrada entrada) {
		entradas.add(entrada);
	}
	public boolean asientoValido(int fila, int columna) {
		if (fila>=0 && fila< mapaAsientos.length && columna>=0 && columna<mapaAsientos[0].length) {
			return true; //asiento dentro del rango
		}else {
			return false; //asiento fuera del rango
		}
	}
	
	//revisar si esos metodos los necesito
	/*public boolean getDisponibilidadSala(Sala sala) {
		
	}
	public void setDisponibilidadSala(boolean disponible) {
		
	}*/
	
	

}
