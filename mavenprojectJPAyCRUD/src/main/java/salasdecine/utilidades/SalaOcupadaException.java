package salasdecine.utilidades;

public class SalaOcupadaException extends Exception {
	public SalaOcupadaException() {
		super("ERROR: Esa sala ya tiene una función asignada.");
	}

}
