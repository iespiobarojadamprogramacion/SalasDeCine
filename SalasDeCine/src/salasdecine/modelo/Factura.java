package salasdecine.modelo;

public class Factura {

	private  int idFactura;
	private  static int indicador=0;
	private String fechaHora;
	private double total;
	private MetodoDePago metodoPago;


	public Factura(String fechaHora, double total, MetodoDePago metodoPago) {
	idFactura = ++indicador;
	this.fechaHora = fechaHora;
	this.total = total;
	this.metodoPago = metodoPago;
	
	}

	public int getIdFactura() {
	return idFactura;
	}

	public String getFechaHora() {
	return fechaHora;
	}

	public double getTotal() {
	return total;
	}

	public MetodoDePago getMetodoPago() {
		return metodoPago;
	}

	public void setFechaHora(String fechaHora) {
	this.fechaHora = fechaHora;
	}

	public void setTotal(double total) {
	this.total = total;
	}

	public void setMetodoPago(MetodoDePago metodoPago) {
		this.metodoPago = metodoPago;
	}


	public double calcularTotal() {
	return total;
	
	}	 
}
