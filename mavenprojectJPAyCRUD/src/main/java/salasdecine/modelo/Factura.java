package salasdecine.modelo;


public class Factura {
	private  int idFactura;
	private  static int indicador=1;
	private String fecha;
	private double total;
	private MetodoDePago metodoPago;
	private Cliente cliente;
	private Entrada entrada;


	public Factura(double total, MetodoDePago metodoPago, Cliente cliente, Entrada entrada) {
	idFactura = ++indicador;
	this.fecha = "FECHA HOY";//corregir
	this.total = total;
	this.metodoPago = metodoPago;
	this.cliente=cliente;
	this.entrada=entrada;
	
	}

	public int getIdFactura() {
	return idFactura;
	}

	public String getFecha() {
	return fecha;
	}

	public double getTotal() {
	return total;
	}

	public MetodoDePago getMetodoPago() {
		return metodoPago;
	}

	public void setFecha(String fecha) {
	this.fecha = fecha;
	}

	public void setTotal(double total) {
	this.total = total;
	}

	public void setMetodoPago(MetodoDePago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}
	
	//no usado
	public double calcularTotal() {
	return total;
	
	}	 
	public String toString() {
		return "-------Factura n#: "+idFactura+
				"--------\nFecha: "+fecha+
				"\nCliente: "+ cliente.getNombre()+
				"\nPelicula: "+entrada.getFuncion().getPelicula().getTitulo()+
				"\nSala: "+entrada.getFuncion().getSala().getNombre()+
				"\nEntrada: "+entrada.getHora()+
				"\nAsiento fila: "+(entrada.getFila()+1)+" Columna: " +(entrada.getColumna()+1)+
				"\nImporte: "+total+"€"+
				"\nMetodo de pago: "+metodoPago
				;
		
	}

 
}
