package salasdecine.modelo;

public class Entrada {
	private static int indicador=0;
	private int codigo;
	private double precio;
	private int fila;
	private int columna;
	
	public Entrada(double precio, int fila, int columna) {
		this.precio=precio;
		this.fila=fila;
		this.columna=columna;
		codigo=++indicador;
		
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
