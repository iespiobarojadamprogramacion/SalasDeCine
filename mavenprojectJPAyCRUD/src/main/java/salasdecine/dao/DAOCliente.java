package salasdecine.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import salasdecine.modelo.Cliente;

public class DAOCliente {

	public void guardar(Cliente cliente) {

		// CON ESTE OBJETO MOVEREMOS NUESTROS OBJETOS, COMO LO SEPARAMOS USAMOS LA CLASE
		// HIBERNATEUTIL con su valor RETORNADO DE GETEMG, DE AHI COMO NO ENSEÑARON
		// CREAMOS ENTITY MANAGER

		// CADA CLASE TENDRIA QUE TENER ESTO, ES DECIR CADA CLASE COMO FUNCIONES,
		// PELICULAS ETC
		EntityManager em = HibernateUtil.getEmf().createEntityManager();
		EntityTransaction et = em.getTransaction();// SOLO LO USAMOS SI CREAMOS COSAS, SI ES CONSULTA NO

		// PARA RECIBIR EL CLIENTE Y PODER GUARDARLO EN LA BBDD
		et.begin();
		em.persist(cliente);
		et.commit();
		em.close(); // CERAMOS
	}

	public Cliente buscarPorID(int id) {
		EntityManager em = HibernateUtil.getEmf().createEntityManager();
		Cliente cliente = em.find(Cliente.class, id);
		em.close();
		return cliente; //REGRESAMOS EL CLIENTE DE LA CONSULTA
	}
	
    public List<Cliente> listaDeClientes() {

        EntityManager em = HibernateUtil.getEmf().createEntityManager();
        List<Cliente> clientes =em.createQuery("FROM Cliente", Cliente.class).getResultList();
        em.close();
        return clientes;
    }

}
