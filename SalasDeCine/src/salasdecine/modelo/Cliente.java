package salasdecine.modelo;

public class Cliente {
	private static int contador=0;
	private int id_Cliente;
	private String Nombre;
	private String Email;
	private String fecha_nacimiento;
	
	public Cliente () {
		
	}
	
	public Cliente(String nombre, String email, String fecha_nacimiento) {
		this.id_Cliente=++contador;
		Nombre = nombre;
		Email = email;
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public int getId_Cliente() {
		return id_Cliente;
	}
	public void setId_Cliente(int id_Cliente) {
		this.id_Cliente = id_Cliente;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String toString() {
		return "Cliente id: "+id_Cliente+
				"\nNombre: "+Nombre+
				"\nEmail: "+Email+
				"\nFecha Nacimiento: "+fecha_nacimiento + "\n";
	}
	
}
