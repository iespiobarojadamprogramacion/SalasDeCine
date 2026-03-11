package salasdecine.modelo;

public class Funcion {
	private static int indicador=0;
	private int idFuncion;
	private String fecha;
	private String horaProyeccion;
	private boolean [][] mapaAsientos;
	
	public Funcion (String fecha, String horaProyeccion) {
		this.fecha=fecha;
		this.horaProyeccion=horaProyeccion;
		idFuncion=++indicador;
	}
	public String getFecha() {
		return fecha;
	}
	public String getHoraProyeccion() {
		return horaProyeccion;
	}
	public int getIdFuncion() {
		return idFuncion;
	}
	public void setFecha(String fecha) {
		this.fecha=fecha;
	}
	public void setHoraProyeccion(String horaProyeccion) {
		this.horaProyeccion=horaProyeccion;
	}
	
	/*public void inicializarMapaAsientos() {
		
	}*/
	
	public boolean consultarDisponibilidadAsientos(int fila, int columna) {
		/*NECESITAMOS DEVOLVER SI EL ASIENTO ESTA DISPONIBLE*/
		boolean disponibilidad=false;
		return disponibilidad;
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
				mapaVisual+=mapaAsientos[i][j] ? "X": "[ ]" + "\t";
			}
			//LE DAMOS ESPACIO Y LO RETORNAMOS
			mapaVisual+="\n";
		}
		return mapaVisual;
		
	}
	/*public boolean getDisponibilidadSala() {
		
	}
	public void setDisponibilidadSala(boolean disponible) {
		
	}*/
	
	

}
