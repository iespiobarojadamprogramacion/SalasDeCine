package salasdecine.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cliente {
	
	// YA NO SE USA ESTE ATRIBUTO, YA QUE SE GENERA POR LA BBDD private static int contador=0;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Cliente;
	
	@Column (nullable=false) //puede decir que no sea nulo
	private String Nombre;
	
	@Column (nullable=false)
	private String Email;
	
	@Column (nullable=false)
	private String fecha_nacimiento;
	
	public Cliente () {
		
	}
	
	
	public Cliente(String nombre, String email, String fecha_nacimiento) {
		//SE QUITO EL this.id_Cliente=++contador; YA QUE ES LA BBDD QUE SE ENCARGARA
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
