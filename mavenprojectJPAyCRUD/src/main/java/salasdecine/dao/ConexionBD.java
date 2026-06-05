package salasdecine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * CLASE PARA CONECTAR A LA BBDD POR CRUD
 */
public class ConexionBD {
	
	//VARIABLES DE LOS DATOS DE LA BBDD
	private static final String URL="jdbc:mariadb://localhost:3306/salacine";
	private static final String user="clientes";
	private static final String password="12345678";
	
	public static Connection getConexion() throws SQLException {
		
		return DriverManager.getConnection(URL, user, password);
		
	}

}
