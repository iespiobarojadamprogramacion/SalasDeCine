package salasdecine.modelo;

public class Sala {
	
    private static int contador = 1;

    private int codigoSala;
    private int capacidad;
    private int filas;
    private int columnas;


    public Sala(int filas, int columnas) {
        this.codigoSala = contador++; 
        capacidad = filas * columnas;
        this.filas = filas;
        this.columnas = columnas;
    }

    
    public int getCapacidad() {
        return capacidad;
    }

    public int getCodigoSala() {
        return codigoSala;
    }


    public int getFila() {
        return filas;
    }

    public int getColumna() {
        return columnas;
    }

}
