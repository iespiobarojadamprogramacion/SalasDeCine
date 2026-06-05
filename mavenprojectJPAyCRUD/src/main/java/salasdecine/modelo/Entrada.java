package salasdecine.modelo;


public class Entrada {

	private double precio;
	private int fila;
	private int columna;
	private String hora;
	private Cliente cliente;
	private Funcion funcion;
	
	public Entrada(double precio, int fila, int columna, String hora) {
		this.precio=precio;
		this.fila=fila;
		this.columna=columna;
		this.hora=hora;
		this.cliente=null;
		this.funcion=null;
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
	
	//metodo para asignar El cliente a la entrada
	public void asignarCliente(Cliente cliente) {
		this.cliente=cliente;
	}
	//regreso el cliente de la entrada
	public Cliente getCliente() {
        return cliente;
    }
	public void asignarFuncion(Funcion funcion) {
		this.funcion=funcion;
	}
	public Funcion getFuncion() {
		return funcion;
	}


	/*@Override
	 public String toString() {
        return "Entrada [fila: " + fila + ", columna: " + columna + ", hora: " + hora +" ]\n"+
               "Cliente: " + (cliente != null ? cliente.getNombre() : "SIN ASIGNAR");
    }*/
	public String toString() {
		//NOMBRE DEL CLIENTE SI NO ES NULO TOMARA NOMBRE DEL CLIENTE, SI ES NULO SE PONDRA SIN ASIGNAR
		String nombreCliente = (cliente != null) ? cliente.getNombre() : "SIN ASIGNAR";
		//TITULO PELICULA SI NO ES NULO TOMARA EL NOMBRE DE ESA FUNCION, PELICULA Y TOMARA EL TITULO, SI NO PONDRA SIN FUNCION
        String tituloPelicula = (funcion != null) ? funcion.getPelicula().getTitulo() : "SIN FUNCIÓN";
        //SALA SI FUNCION NO ES NULA TOMARA EL NOMBRE QUE TIENE LA SALA, EN OTRO CASO NO LA PONDRA
        String sala = (funcion != null) ? String.valueOf(funcion.getSala().getNombre()) : "-";

		return "Entrada:" +
				//	"\n Pelicula: "+ ((cliente !=null) ? cliente.getNombre() : "SIN ASIGNAR") +
			      "\n  Película: " + tituloPelicula +
			      "\n  Sala: " + sala +
			      "\n  Hora: " + hora +
			      "\n  Asiento: Fila " + (fila + 1) + ", Columna " + (columna + 1) +
			      "\n  Cliente: " + nombreCliente +
			      "\n  Precio: " + precio + "€";
	}
	  


	
}
