package salasdecine.modelo;

public class Sala {
	
	private String nombre;
    private int capacidad;
    private int filas;
    private int columnas;


    public Sala(String nombre,int filas, int columnas) {
        this.nombre=nombre;
        capacidad = filas * columnas;
        this.filas = filas;
        this.columnas = columnas;
    }

    
    public int getCapacidad() {
        return capacidad;
    }

    

    public String getNombre() {
		return nombre;
	}


	public int getFila() {
        return filas;
    }

    public int getColumna() {
        return columnas;
    }


	@Override
	public String toString() {
		return "Sala [nombre=" + nombre + ", capacidad=" + capacidad + ", filas=" + filas + ", columnas=" + columnas
				+ "]";
	}
    

}
