package salasdecine.modelo;

import java.util.ArrayList;

import salasdecine.utilidades.NotFoundClienteException;

public class APICine {
	
	private static APICine api;
	private GestorCine cine; //CLASE DE TU SUBMAIN
	private APICine () {
		cine = new GestorCine();
		
	}
	//CON ESTO SE IRAN CREANDO LAS APIS SI ES QUE NO LA HAY, 
	//ESTE METODO ES PARA PODER COMUNICARNOS LOS CONTROLADORES CON LOS CASOS DE USO
	public static APICine getInstance() {
		if(api==null) {
			api=new APICine();
		}
		return api;
	}
	//AQUI VENDRAN TODOS LOS METODOS QUE NECESITO PARA CADA UNO DE LOS CASOS DE USO.
	//EN TODOS LOS CONTROLADORES TENGO QUE IMPLEMENTAR EL API
	public void registrarCliente (String nombre, String email, String fechaNacimiento) {
		cine.registroCliente(nombre, email, fechaNacimiento);
	}
	//METODO CONSULTAR CLIENTE
	public String [][] consultaCliente (int idCliente) throws NotFoundClienteException{
		ArrayList<Cliente> cliente=cine.clienteSoloArray(idCliente);	
		if(cliente.size()==0) {
			throw new NotFoundClienteException();
		}
		String [][] resultadoConsultaCliente = new String [cliente.size()][4];	
		int fila=0;
		for(Cliente v: cliente) {
			resultadoConsultaCliente[fila][0]=String.valueOf(v.getId_Cliente()); //FILA COLUMNA STRING PORQUE ES ARRAY DE STRING
			resultadoConsultaCliente[fila][1]=v.getNombre();
			resultadoConsultaCliente[fila][2]=v.getEmail();
			resultadoConsultaCliente[fila][3]=v.getFecha_nacimiento();
		}
		return resultadoConsultaCliente;	
	}
	public String [][] listaCliente (){
		ArrayList <Cliente> listaClientes = (ArrayList<Cliente>) cine.getClientes();
		String [][] resultadoListaClientes = new String [listaClientes.size()][4];
		if(listaClientes.size()==0) {		
			throw new NullPointerException();
		}		
		int fila=0;
		for(Cliente v: listaClientes) {
			resultadoListaClientes[fila][0]=String.valueOf(v.getId_Cliente());
			resultadoListaClientes[fila][1]=v.getNombre();
			resultadoListaClientes[fila][2]=v.getEmail();
			resultadoListaClientes[fila][3]=v.getFecha_nacimiento();
			fila++;
		}
		return resultadoListaClientes;
	}
	public void registrarPelicula (String titulo, int duracion, String genero, ClasificacionEdad clasificacionEdad) {
		cine.registrarPelicula(titulo, duracion, genero, clasificacionEdad);
	}

}
