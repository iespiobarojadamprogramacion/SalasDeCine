package salasdecine.utilidades;

public class NotFoundClienteException extends Exception {
	public NotFoundClienteException () {
		super("Cliente no encontrado con esa ID");
	}

}
