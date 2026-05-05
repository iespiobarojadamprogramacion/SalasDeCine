package salasdecine.modelo;

import java.util.ArrayList;
import java.util.List;

import salasdecine.utilidades.NotFoundClienteException;
import salasdecine.utilidades.SalaOcupadaException;

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
	
	public String[][] mostrarTodasLasSalas() {
		List<Sala> listaSalas = cine.getSalas();
		String[][] resultadoListaSalas = new String [listaSalas.size()][4];
		if(listaSalas.size()==0) {
			throw new NullPointerException();
		}
		int fila =0;
		for(Sala s: listaSalas) {
			resultadoListaSalas[fila][0]=s.getNombre();
			resultadoListaSalas[fila][1]=String.valueOf(s.getFila());
			resultadoListaSalas[fila][2]=String.valueOf(s.getColumna());
			resultadoListaSalas[fila][3]=String.valueOf(s.getCapacidad());
			fila++;
			
		}
		return resultadoListaSalas;
	}
	//MOSTRAR SALAS LIBRES 
	public String [][] salasLibres (){
		//CREO UN ARRAY LIST QUE TENDRA LA TABLA ENTERA DE LAS SALAS
		List<Sala> listaSalas = cine.getSalas();
		//CREO OTRO ARRAYLIST QUE TENDRA LAS SALAS LIBRES
		List <Sala> salasLibres= new ArrayList <>();
		//SI LISTASALAS ES 0 POR LO TANTO ESTA VACIA
		if (listaSalas.size()==0) {
			throw new NullPointerException();
		}
		//RECORRO LA LISTASALAS Y SI ESA SALA NO ESTA ASIGNADA ENTONCES ESTA LIBRE Y LA GUARDO EN EL ARRAY DE SALAS LIBRES
		for(Sala s: listaSalas) {
			if(!cine.salaYaAsignada(s)) {
				salasLibres.add(s);
			}
		}
		//AHORA RECORRERE ESE ARRAY DE SALAS LIBRES Y LO GUARDO EN UN ARRAY BIDEMENSIONAL LOS VALORES DE NOMBRE, FILA, COLUMNA Y CAPACIDAD
		int fila=0;
		String [][] resultadoSalasLibres = new String [salasLibres.size()][4];
		for(Sala s: salasLibres) {
			resultadoSalasLibres[fila][0]=s.getNombre();
			resultadoSalasLibres[fila][1]=String.valueOf(s.getFila());
			resultadoSalasLibres[fila][2]=String.valueOf(s.getColumna());
			resultadoSalasLibres[fila][3]=String.valueOf(s.getCapacidad());
			fila++;
		}
		return resultadoSalasLibres;
	}
	//MOSTRAR SALAS OCUPADAS, EL MISMO METODO DE ARRIBA PERO MODIFICANDO EL IF
	public String [][] salasOcupadas (){
		//CREO UN ARRAY LIST QUE TENDRA LA TABLA ENTERA DE LAS SALAS
		List<Sala> listaSalas = cine.getSalas();
		//CREO OTRO ARRAYLIST QUE TENDRA LAS SALAS OCUPADAS
		List <Sala> salasOcupadas= new ArrayList <>();
		//SI LISTASALAS ES 0 POR LO TANTO ESTA VACIA
		if (listaSalas.size()==0) {
			throw new NullPointerException();
		}
		//RECORRO LA LISTASALAS Y SI ESA SALA  ESTA ASIGNADA ENTONCES ESTA OCUPADA Y LA GUARDO EN EL ARRAY DE SALAS PCUPADAS
		for(Sala s: listaSalas) {
			if(cine.salaYaAsignada(s)) {
				salasOcupadas.add(s);
			}
		}
		//AHORA RECORRERE ESE ARRAY DE SALAS OCUPADAS Y LO GUARDO EN UN ARRAY BIDEMENSIONAL LOS VALORES DE NOMBRE, FILA, COLUMNA Y CAPACIDAD
		int fila=0;
		String [][] resultadoSalasOcupadas = new String [salasOcupadas.size()][4];
		for(Sala s: salasOcupadas) {
			resultadoSalasOcupadas[fila][0]=s.getNombre();
			resultadoSalasOcupadas[fila][1]=String.valueOf(s.getFila());
			resultadoSalasOcupadas[fila][2]=String.valueOf(s.getColumna());
			resultadoSalasOcupadas[fila][3]=String.valueOf(s.getCapacidad());
			fila++;
		}
		return resultadoSalasOcupadas;
	}
	public String [][] listaPeliculas(){
		
		List<Pelicula> listaPeliculas = cine.getPeliculas();
		String [][] resultadoPeliculas = new String [listaPeliculas.size()][2];
		if(listaPeliculas.size()==0) {
			throw new NullPointerException();
		}
		int fila=0;
		for (Pelicula p: listaPeliculas) {
			resultadoPeliculas[fila][0]=String.valueOf(fila+1);
			resultadoPeliculas[fila][1]=p.getTitulo();
			fila++;		
		}
		return resultadoPeliculas;
	}
	//METODO PARA USAR EN EL JCOMBOBOX
	public String [] numerosDePeliculas() {
		List <Pelicula> listaPeliculas=cine.getPeliculas();
		String [] letrasCantidadPelis = new String [listaPeliculas.size()];
		if(listaPeliculas.size()==0) {
			throw new NullPointerException();
		}
		int fila=0;
		for (Pelicula p: listaPeliculas) {
			letrasCantidadPelis[fila]=String.valueOf(fila+1);
			fila++;		
		}
		return letrasCantidadPelis; //retorno en letras lo de 1, 2 , 3 .. etc 
	}
	//METODO PARA DAR DE ALTA FUNCION
	public void darAltaFuncion(String fechaInicio, String fechaFin, Sala sala, Pelicula pelicula) throws SalaOcupadaException {
		//USO EL METODO DE GESTOR DE CINE PARA COMPROBAR SI UNA SALA ESTA DISPONIBLE
		if (cine.salaYaAsignada(sala)) {
			System.out.println("ERROR: Esa sala ya tiene una función asignada.");	
			throw new SalaOcupadaException();
		}
		cine.registrarFuncion(fechaInicio, fechaFin, sala, pelicula);
	}
	//METODO USADO PARA QUE ME RETOME LA PELICULA POR INDICE
	public Pelicula getPeliculaPorIndice(int indice) {
		List<Pelicula> listaPeliculas=cine.getPeliculas();
		//AÑADO ESTE PARA VALIDAR LA LISTA DE PELICULAS 
		if(indice < 0 || indice >= listaPeliculas.size()) {
	        return null;
	    }
		return listaPeliculas.get(indice);
	}
	//METODO USADO EN FUNCION, PORQUE TENIA EL NOMBRE DE LA SALA EN STRING
	public Sala getSalaPorNombre(String nombre) {
		List<Sala> salas =cine.getSalas();
		for (Sala s: salas) {
			if(s.getNombre().equals(nombre)) {
				return s;
			}
		}
		return null;
	}
	

}
