package salasdecine.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//USADO PARA ACCEDER A LA BASE DE DATOS
public class HibernateUtil {

	// LO QUE HACE COMO UNIDAD DE PERSISTENCIA USAMOS EL QUE PUSIMOS EN EL ARCHIVO
	// PERSISTENCE.XML
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("salacineUP");
	
	//PODER TOMAR EL VALOR DE EMF cuando lo usemos en cada DAOCLIENTE.. DAOFUNCION ETC
	
	public static EntityManagerFactory getEmf() {
		return emf;
	}
	
	
}

