package salasdecine;

import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import salasdecine.modelo.Cliente;
import salasdecine.modelo.GestorCine;

public class PrincipalHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// podemos hacer menu para ir probando
		String menu = "1- Alta cliente\n2- Consulta Cliente\n3- Modificar Cliente\n4- Borrado Cliente\n";
		int opcion;
		GestorCine prueba= new GestorCine();
		Scanner sc = new Scanner(System.in);
		//LO QUE HACE COMO UNIDAD DE PERSISTENCIA USAMOS EL QUE PUSIMOS EN EL ARCHIVO PERSISTENCE.XML
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("salacineUP");
		//CON ESTE OBJETO MOVEREMOS NUESTROS OBJETOS
		EntityManager em=emf.createEntityManager();//LO USAMOS PARA TODO CREAR, CONSULTAR.. ETC
		EntityTransaction et=em.getTransaction();

		//DATOS PARA ALTA CLIENTE
		int id_Cliente;
		String Nombre;
		String Email;
		String fecha_nacimiento;
		
		do {
			System.out.println(menu);
			System.out.println("Elige opcion");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Alta Cliente");
				System.out.println("Dame nombre");
				Nombre=sc.next();
				System.out.println("Dame Email");
				Email=sc.next();
				System.out.println("Dame fecha nacimiento dia/mes/año");
				fecha_nacimiento=sc.next();
				Cliente cliente = new Cliente(Nombre, Email, fecha_nacimiento);
				et.begin();
				em.persist(cliente);
				et.commit();
				break;
				
			case 2:
				System.out.println("Dame un ID");
				id_Cliente=sc.nextInt();
				Cliente cli;
				cli=em.find(Cliente.class, id_Cliente);
				System.out.println(cli);
				break;
			case -1:
				System.out.println("Adios");
				break;
			default:
				System.out.println("Opcion incorrecta");

			}
		} while (opcion != -1);

	}

}
