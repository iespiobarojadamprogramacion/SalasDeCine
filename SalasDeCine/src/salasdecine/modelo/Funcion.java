package salasdecine.modelo;

import java.util.ArrayList;
import java.util.Arrays;
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
		horarios= new String [] {"16:00","19;00","22:00"};
		idFuncion=++indicador;
		this.entradas=new ArrayList<>();//agrego una lista para cada funcion
		
	}
	
	public Pelicula getPelicula() {
		return pelicula;
	}

	
	public Sala getSala() {
		return sala;
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

	public List<Entrada> getEntradas() {
		return entradas;
	}
	public boolean horarioValido(String hora) {
		for(String aux : horarios) {
			if(aux.equalsIgnoreCase(hora)) {
				return true;
			}
		}
		return false;
	}
	public void inicializarMapaAsientos() {
		int filas=sala.getFila();
		int columnas=sala.getColumna();
		mapaAsientos= new boolean [filas][columnas];
	}
	public boolean asientoValido(int fila, int columna) {
		if(fila>=0 && fila<sala.getFila() && columna>=0 && columna<sala.getColumna()) {
			return true;
		}
		return false;
	}
	public boolean asientoOcupadoEnHora(int fila, int columna, String hora) {
		for (Entrada aux: entradas) {
			if(aux.getFila()==fila && aux.getColumna()==columna && aux.getHora().equalsIgnoreCase(hora)) {
				return true;
			}
		}
		return false;
	}

	public boolean consultarDisponibilidad(int fila, int columna, String hora) {
		/*NECESITAMOS DEVOLVER SI EL ASIENTO ESTA DISPONIBLE, SI ES FALSE ESTA LIBRE*/
		if (!asientoValido(fila, columna)) {
			return true;
		}
		if (!horarioValido(hora)) {
			return true;
			
		}
		if (!asientoOcupadoEnHora(fila, columna, hora)) {
			return true;
		}
		return false;
				
			
		
		
	}
	public void ocuparAsientoSala(int fila, int columna) {
		/*DEL MAPA DE ASIENTOS OCUPAR UN ASIENTO*/
		this.mapaAsientos[fila][columna]=true;
	}
	public void desocuparAsientoSala(int fila, int columna) {
		this.mapaAsientos[fila][columna]=false;
	}
	public void agregarEntrada(Entrada entrada) {
		entradas.add(entrada);
	}
	public String mostrarAsientos(String hora) {
		String mapa="";
		for (int i=0; i<sala.getFila(); i++) {
			for(int j=0;j<sala.getColumna(); j++) {
				if (asientoOcupadoEnHora(i, j, hora)) {
					mapa+= "[X]\t";
				}else {
					mapa+= "[ ]\t";
				}
			}
			mapa+=" \n";
		}
		return mapa;
	}
	public void mostrarHorarios() {
		for (String aux: horarios) {
			System.out.println(aux);
		}
	}

	@Override
	public String toString() {
		return "Funcion [idFuncion=" + idFuncion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", horarios=" + Arrays.toString(horarios) + ", sala=" + sala + ", pelicula=" + pelicula
				+ ", entradas=" + entradas + "]";
	}


	//agrego las entradas a la funcion se usara cuando se venda una entrada
	
	
	
	//revisar si esos metodos los necesito
	/*public boolean getDisponibilidadSala(Sala sala) {
		
	}
	public void setDisponibilidadSala(boolean disponible) {
		
	}*/
	
	

}
