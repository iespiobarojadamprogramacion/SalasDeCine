package salasdecine.modelo;


public class Pelicula {
	private String titulo;
	private int duracion;
	private String genero;
	private ClasificacionEdad clasificacionEdad;

	public Pelicula(String titulo, int duracion, String genero, ClasificacionEdad clasificacionEdad) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
		this.clasificacionEdad = clasificacionEdad;
	}

	public Pelicula() {

	}

	public String getTitulo() {
		return titulo;
	}

	public double getDuracion() {
		return duracion;
	}

	public String getGenero() {
		return genero;
	}

	public ClasificacionEdad getClasificacionedad() {
		return clasificacionEdad;
	}

	@Override
	public String toString() {
		return "-Pelicula-\n" + "titulo: " + getTitulo() + "\nduracion: " + duracion + "\ngenero: " + genero
				+ "\nclasificacion Edad: " + clasificacionEdad + "\n";
	}


}
