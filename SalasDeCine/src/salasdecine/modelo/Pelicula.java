package salasdecine.modelo;

public class Pelicula {
	private String titulo;
	private double duracion;
	private String genero;
	private int clasificacionedad;
	public Pelicula(String titulo, double duracion, String genero, int clasificacionedad) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
		this.clasificacionedad = clasificacionedad;
	}
	public Pelicula() {
		super();
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
	public int getClasificacionedad() {
		return clasificacionedad;
	}

	}
	

