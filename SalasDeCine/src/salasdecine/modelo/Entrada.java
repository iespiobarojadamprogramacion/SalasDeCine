package salasdecine.modelo;

public class Entrada {
	private static int indicador=0;
	private int codigo;
	private double precio;
	private int fila;
	private int columna;
	private String hora;
	
	public Entrada(double precio, int fila, int columna,String hora) {
		this.precio=precio;
		this.fila=fila;
		this.columna=columna;
		this.hora=hora;
		codigo=++indicador;
		
	}
	
	

	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}

	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio=precio;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getCodigo() {
		return codigo;
	}
	
	

}
