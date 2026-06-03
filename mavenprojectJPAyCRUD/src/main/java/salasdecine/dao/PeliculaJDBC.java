package salasdecine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import salasdecine.modelo.ClasificacionEdad;
import salasdecine.modelo.Pelicula;

public class PeliculaJDBC {

	public void altaPelicula(String titulo, int duracion, String genero, ClasificacionEdad clasificacionEdad) {
		String insert = "INSERT INTO pelicula(titulo, duracion, genero, clasificacionEdad) " + "value (?,?,?,?)";
		try {
			/*
			 * COMO HICIMOS UNA CLASE QUE CONTIENE EL CONNECTION CUANDO SE DECLARA CON LOS
			 * DATOS DE LA BASE DE DATOS, AQUI RETORNAMOS ESE VALOR CREAMOS EL OBJETO Y LE
			 * ASIGNAMOS ESE VALOR
			 */
			Connection conn = ConexionBD.getConexion();
			PreparedStatement psmt = conn.prepareStatement(insert);
			// LOS VALORES TIENEN QUE COINCIDIR CON LA TABLA, ESTA ES PARTE DE LA QUERY
			psmt.setString(1, titulo);
			psmt.setInt(2, duracion);
			psmt.setString(3, genero);
			psmt.setString(4, clasificacionEdad.name()); // PARA INSERTAR UN ENUM SE USA .NAME()
			psmt.executeUpdate();
			System.out.println("Pelicula insertada");
			psmt.close(); // LO CERRAMOS

		} catch (SQLException e) {
			System.out.println("Error al insertar cliente");
		}
	}

	// METODO PARA UNA PELICULAS ESPECIFICA
	public String[][] consulta(String titulo) {
		String query = "SELECT titulo, duracion, genero, clasificacionEdad " + "FROM pelicula WHERE titulo=?";
		String[][] resultado = new String[1][4];
		try {
			Connection conn = ConexionBD.getConexion();
			// PREPARAMOS PARA HACER LAS CONSULTA
			PreparedStatement psmt = conn.prepareStatement(query);
			// USAMOS EL VALOR TITULO QUE SERA LA PK
			psmt.setString(1, titulo);
			// OBTENGO EL RESULTADO DE LA QUERY , EN ESTE CASO SERA UN SOLO ELEMENTO, PORQUE
			// NO SE PODRA REPTIR
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				resultado[0][0] = rs.getString(1);
				resultado[0][1] = rs.getString(2);
				resultado[0][2] = rs.getString(3);
				resultado[0][3] = rs.getString(4);
			} else {
				System.out.println("No existe esa pelicula");
			}

			/*
			 * USO MEJOR EL IF PARA EVALUARLO while(rs.next()) {
			 * System.out.println("Titulo: "+rs.getString(1));
			 * System.out.println("Duracion: "+rs.getString("duracion"));
			 * 
			 * }
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error consulta");
			e.printStackTrace();
		}
		return resultado;
	}

	public String[][] listaPeliculas() {
		String query = "SELECT titulo, duracion, genero, clasificacionEdad " + "FROM pelicula ";
		List<String[]> peliculas = new ArrayList<>();
		try {
			Connection conn = ConexionBD.getConexion();
			// PREPARAMOS PARA HACER LAS CONSULTA
			PreparedStatement psmt = conn.prepareStatement(query);

			// OBTENGO EL RESULTADO DE LA QUERY , EN ESTE CASO SERA UN SOLO ELEMENTO, PORQUE
			// NO SE PODRA REPTIR
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				peliculas.add(new String[] { rs.getString(1), String.valueOf(rs.getString(2)), rs.getString(3),
						rs.getString(4)

				});
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error consulta");
			e.printStackTrace();
		}
		return peliculas.toArray(new String[0][4]);
	}

	public Pelicula buscarPorTitulo(String titulo) {
		String query = "SELECT titulo, duracion, genero, clasificacionEdad " + "FROM pelicula WHERE titulo=?";
		String[][] resultado = new String[1][4];
		Pelicula peliculaEncontrada=null;
		ClasificacionEdad clasificacionEdad = null;

		;
		try {
			Connection conn = ConexionBD.getConexion();
			// PREPARAMOS PARA HACER LAS CONSULTA
			PreparedStatement psmt = conn.prepareStatement(query);
			// USAMOS EL VALOR TITULO QUE SERA LA PK
			psmt.setString(1, titulo);
			// OBTENGO EL RESULTADO DE LA QUERY , EN ESTE CASO SERA UN SOLO ELEMENTO, PORQUE
			// NO SE PODRA REPTIR
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				/* NO HACE FALTA YA QUE NO DEVUELVO ESO, SI NO QUE DOY DE ALTA A LA PELICULA DIRECTAMENTE
				resultado[0][0] = rs.getString(1);
				resultado[0][1] = rs.getString(2);
				resultado[0][2] = rs.getString(3);
				resultado[0][3] = rs.getString(4);
				*/
				if (rs.getString(4).equalsIgnoreCase("SIETE")) {
					clasificacionEdad = ClasificacionEdad.SIETE;
				} else if (rs.getString(4).equalsIgnoreCase("DOCE")) {
					clasificacionEdad = ClasificacionEdad.DOCE;
				} else if (rs.getString(4).equalsIgnoreCase("DIECISEIS")) {
					clasificacionEdad = ClasificacionEdad.DIECISEIS;
				} else if (rs.getString(4).equalsIgnoreCase("DIECIOCHO")) {
					clasificacionEdad = ClasificacionEdad.DIECIOCHO;
				} else {
					System.out.println("Clasificacion edad mal elegida");
				}
				peliculaEncontrada = new Pelicula(rs.getString(1), rs.getInt(2), rs.getString(3), clasificacionEdad);
			} else {
				System.out.println("No existe esa pelicula");
			}

			/*
			 * USO MEJOR EL IF PARA EVALUARLO while(rs.next()) {
			 * System.out.println("Titulo: "+rs.getString(1));
			 * System.out.println("Duracion: "+rs.getString("duracion"));
			 * 
			 * }
			 */

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error consulta");
			e.printStackTrace();
		}

		return peliculaEncontrada;
	}

}
