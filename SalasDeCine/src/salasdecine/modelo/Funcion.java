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
	private Sala sala;
	private Pelicula pelicula;
//	private Entrada [] entradas;//podemos poner array list? quizas sera mas comodo
	private List<Entrada> entradas;//guardar entradas en arraylist
	
	public Funcion (String fechaInicio, String fechaFin, Sala sala, Pelicula pelicula) {
		
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.sala=sala;
		this.pelicula=pelicula;
		horarios= new String [] {"16:00","19:00","22:00"};
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
			return false;
		}
		if (!horarioValido(hora)) {
			return false;
			
		}
		if (!asientoOcupadoEnHora(fila, columna, hora)) {
			return true;
		}
		return true;
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
	public void mostrarEntradas() {
		//si entradas esta vacio mostrar que no hay entradas registrada
		if(entradas.isEmpty()) {
			System.out.println("No hay entradas registrada");
			return;
		//en otro caso es que si hay, por lo tanto recorrera la lista de entradas y me ira mostrando cada entrada
		}else {
			
			for(Entrada aux: entradas) {
				System.out.println(aux);
			}
		}
	
	}
	//metodos para poder cancelar la entrada
	//lo que haremos es buscarEntrada con su fila, columna y hora
	public Entrada buscarEntrada(int fila, int columna, String hora) {
	    for (Entrada aux : entradas) {
	        if (aux.getFila() == fila && aux.getColumna() == columna && aux.getHora().equals(hora)) {
	            return aux; //regreso la entrada
	        }
	    }
	    return null;
	}
	//cuando la busque podemos usar este otro metodo para cancelarla. (metodo que usa gestor cine para cancelarla)
	public boolean cancelarEntrada(int fila, int columna, String hora) {
		Entrada aux = buscarEntrada(fila, columna, hora);
		if(aux!=null) {
			//si la entrada es distinta a null, es decir hay una entrada la quitara
			entradas.remove(aux); //quito la entrada
			return true; //regreso que true, que esta eliminada
		}
		return false; //no eliminada
	}
	//METODO PARA GUARDAR UNA LISTA DE LAS ENTRADAS DE LOS CLIENTES 
	public List<Entrada> listaEntradasClientes(int idCliente){
		List<Entrada> lista = new ArrayList<>();
		for (Entrada aux: entradas) {
			//si en la entrada aux el cliente es disntito a null (es decir existe) y su id es como el idCliente pasado entonces..
			if(aux.getCliente()!=null && aux.getCliente().getId_Cliente()==idCliente) {
				lista.add(aux);	
			}
		}
		return lista; //regreso la lista que se ha ido haciendo del cliente con ese idCLiente
		
		
	}

	@Override
	public String toString() {
		return "Funcion con idFuncion: " + idFuncion 
				+ "\nfecha Inicio: " + fechaInicio 
				+ "\nfechaFin: " + fechaFin
				+ "\nhorarios: " + Arrays.toString(horarios) + ", sala: " + sala + ", pelicula: " + pelicula
				+ "\nentradas: " + entradas + "]";
	}
	


	
	
	
	

}
