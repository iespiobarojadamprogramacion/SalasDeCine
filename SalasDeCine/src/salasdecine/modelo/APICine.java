package salasdecine.modelo;

import java.util.ArrayList;

import java.util.List;

import salasdecine.utilidades.NotFoundClienteException;
import salasdecine.utilidades.SalaOcupadaException;

/**
 * AQUI VENDRAN TODOS LOS METODOS QUE NECESITO PARA CADA UNO DE LOS CASOS DE
 * USO. ESTE METODO ES PARA PODER COMUNICARNOS LOS CONTROLADORES CON LOS CASOS
 * DE USO EN TODOS LOS CONTROLADORES TENGO QUE IMPLEMENTAR EL API
 */
public class APICine {

	private static APICine api;
	private GestorCine cine; // CLASE DE TU SUBMAIN

	private APICine() {
		cine = new GestorCine();

	}

	/**
	 * CON ESTO SE IRAN CREANDO LAS APIS SI ES QUE NO LA HAY
	 * 
	 * @return
	 */
	public static APICine getInstance() {
		if (api == null) {
			api = new APICine();
		}
		return api;
	}

	/**
	 * METODO PARA REGISTRAR CLIENTE
	 * 
	 * @param nombre
	 * @param email
	 * @param fechaNacimiento
	 */
	public void registrarCliente(String nombre, String email, String fechaNacimiento) {
		cine.registroCliente(nombre, email, fechaNacimiento);
	}

	/**
	 * METODO CONSULTAR CLIENTE
	 * 
	 * @param idCliente
	 * @return
	 * @throws NotFoundClienteException
	 */
	public String[][] consultaCliente(int idCliente) throws NotFoundClienteException {
		ArrayList<Cliente> cliente = cine.clienteSoloArray(idCliente);
		if (cliente.size() == 0) {
			throw new NotFoundClienteException();
		}
		String[][] resultadoConsultaCliente = new String[cliente.size()][4];
		int fila = 0;
		for (Cliente v : cliente) {
			resultadoConsultaCliente[fila][0] = String.valueOf(v.getId_Cliente()); // FILA COLUMNA STRING PORQUE ES
																					// ARRAY DE STRING
			resultadoConsultaCliente[fila][1] = v.getNombre();
			resultadoConsultaCliente[fila][2] = v.getEmail();
			resultadoConsultaCliente[fila][3] = v.getFecha_nacimiento();
		}
		return resultadoConsultaCliente;
	}

	/**
	 * METODO PARA GUARDAR LA LISTA DE CLIENTES EN UN ARRAY BIDEMENSIONAL
	 * 
	 * @return
	 */
	public String[][] listaCliente() {
		ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) cine.getClientes();
		String[][] resultadoListaClientes = new String[listaClientes.size()][4];
		if (listaClientes.size() == 0) {
			throw new NullPointerException();
		}
		int fila = 0;
		for (Cliente v : listaClientes) {
			resultadoListaClientes[fila][0] = String.valueOf(v.getId_Cliente());
			resultadoListaClientes[fila][1] = v.getNombre();
			resultadoListaClientes[fila][2] = v.getEmail();
			resultadoListaClientes[fila][3] = v.getFecha_nacimiento();
			fila++;
		}
		return resultadoListaClientes;
	}

	/**
	 * METODO PARA REGISTRAR UNA PELICULA
	 * 
	 * @param titulo
	 * @param duracion
	 * @param genero
	 * @param clasificacionEdad
	 */
	public void registrarPelicula(String titulo, int duracion, String genero, ClasificacionEdad clasificacionEdad) {
		cine.registrarPelicula(titulo, duracion, genero, clasificacionEdad);
	}

	/**
	 * METODO PARA MOSTRAR TODAS LAS SALAS
	 * 
	 * @return
	 */
	public String[][] mostrarTodasLasSalas() {
		List<Sala> listaSalas = cine.getSalas();
		String[][] resultadoListaSalas = new String[listaSalas.size()][4];
		if (listaSalas.size() == 0) {
			throw new NullPointerException();
		}
		int fila = 0;
		for (Sala s : listaSalas) {
			resultadoListaSalas[fila][0] = s.getNombre();
			resultadoListaSalas[fila][1] = String.valueOf(s.getFila());
			resultadoListaSalas[fila][2] = String.valueOf(s.getColumna());
			resultadoListaSalas[fila][3] = String.valueOf(s.getCapacidad());
			fila++;

		}
		return resultadoListaSalas;
	}

	/**
	 * MOSTRAR SALAS LIBRES
	 * 
	 * @return
	 */
	public String[][] salasLibres() {
		// CREO UN ARRAY LIST QUE TENDRA LA TABLA ENTERA DE LAS SALAS
		List<Sala> listaSalas = cine.getSalas();
		// CREO OTRO ARRAYLIST QUE TENDRA LAS SALAS LIBRES
		List<Sala> salasLibres = new ArrayList<>();
		// SI LISTASALAS ES 0 POR LO TANTO ESTA VACIA
		if (listaSalas.size() == 0) {
			throw new NullPointerException();
		}
		// RECORRO LA LISTASALAS Y SI ESA SALA NO ESTA ASIGNADA ENTONCES ESTA LIBRE Y LA
		// GUARDO EN EL ARRAY DE SALAS LIBRES
		for (Sala s : listaSalas) {
			if (!cine.salaYaAsignada(s)) {
				salasLibres.add(s);
			}
		}
		// AHORA RECORRERE ESE ARRAY DE SALAS LIBRES Y LO GUARDO EN UN ARRAY
		// BIDEMENSIONAL LOS VALORES DE NOMBRE, FILA, COLUMNA Y CAPACIDAD
		int fila = 0;
		String[][] resultadoSalasLibres = new String[salasLibres.size()][4];
		for (Sala s : salasLibres) {
			resultadoSalasLibres[fila][0] = s.getNombre();
			resultadoSalasLibres[fila][1] = String.valueOf(s.getFila());
			resultadoSalasLibres[fila][2] = String.valueOf(s.getColumna());
			resultadoSalasLibres[fila][3] = String.valueOf(s.getCapacidad());
			fila++;
		}
		return resultadoSalasLibres;
	}

	/**
	 * MOSTRAR SALAS OCUPADAS, EL MISMO METODO DE ARRIBA PERO MODIFICANDO EL IF
	 * 
	 * @return
	 */
	public String[][] salasOcupadas() {
		// CREO UN ARRAY LIST QUE TENDRA LA TABLA ENTERA DE LAS SALAS
		List<Sala> listaSalas = cine.getSalas();
		// CREO OTRO ARRAYLIST QUE TENDRA LAS SALAS OCUPADAS
		List<Sala> salasOcupadas = new ArrayList<>();
		// SI LISTASALAS ES 0 POR LO TANTO ESTA VACIA
		if (listaSalas.size() == 0) {
			throw new NullPointerException();
		}
		// RECORRO LA LISTASALAS Y SI ESA SALA ESTA ASIGNADA ENTONCES ESTA OCUPADA Y LA
		// GUARDO EN EL ARRAY DE SALAS PCUPADAS
		for (Sala s : listaSalas) {
			if (cine.salaYaAsignada(s)) {
				salasOcupadas.add(s);
			}
		}
		// AHORA RECORRERE ESE ARRAY DE SALAS OCUPADAS Y LO GUARDO EN UN ARRAY
		// BIDEMENSIONAL LOS VALORES DE NOMBRE, FILA, COLUMNA Y CAPACIDAD
		int fila = 0;
		String[][] resultadoSalasOcupadas = new String[salasOcupadas.size()][4];
		for (Sala s : salasOcupadas) {
			resultadoSalasOcupadas[fila][0] = s.getNombre();
			resultadoSalasOcupadas[fila][1] = String.valueOf(s.getFila());
			resultadoSalasOcupadas[fila][2] = String.valueOf(s.getColumna());
			resultadoSalasOcupadas[fila][3] = String.valueOf(s.getCapacidad());
			fila++;
		}
		return resultadoSalasOcupadas;
	}

	/**
	 * METODO PARA QUE ME DEVUELVA UN STRING BIDEMENSIONAL DE LA LISTAPELICULAS
	 * 
	 * @return
	 */
	public String[][] listaPeliculas() {

		List<Pelicula> listaPeliculas = cine.getPeliculas();
		String[][] resultadoPeliculas = new String[listaPeliculas.size()][2];
		if (listaPeliculas.size() == 0) {
			throw new NullPointerException();
		}
		int fila = 0;
		for (Pelicula p : listaPeliculas) {
			resultadoPeliculas[fila][0] = String.valueOf(fila + 1);
			resultadoPeliculas[fila][1] = p.getTitulo();
			fila++;
		}
		return resultadoPeliculas;
	}

	/**
	 * METODO PARA USAR EN EL JCOMBOBOX PARA QUE ME DE LA CANTIDAD DE PELICULAS EN
	 * UN ARRAY DE STRING
	 * 
	 * @return
	 */
	public String[] numerosDePeliculas() {
		List<Pelicula> listaPeliculas = cine.getPeliculas();
		String[] letrasCantidadPelis = new String[listaPeliculas.size()];
		if (listaPeliculas.size() == 0) {
			throw new NullPointerException();
		}
		int fila = 0;
		for (Pelicula p : listaPeliculas) {
			letrasCantidadPelis[fila] = String.valueOf(fila + 1);
			fila++;
		}
		return letrasCantidadPelis; // retorno en letras lo de 1, 2 , 3 .. etc
	}

	/**
	 * METODO PARA DAR DE ALTA FUNCION
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @param sala
	 * @param pelicula
	 * @throws SalaOcupadaException
	 */
	public void darAltaFuncion(String fechaInicio, String fechaFin, Sala sala, Pelicula pelicula)
			throws SalaOcupadaException {
		// USO EL METODO DE GESTOR DE CINE PARA COMPROBAR SI UNA SALA ESTA DISPONIBLE
		if (cine.salaYaAsignada(sala)) {
			System.out.println("ERROR: Esa sala ya tiene una función asignada.");
			throw new SalaOcupadaException();
		}
		cine.registrarFuncion(fechaInicio, fechaFin, sala, pelicula);
	}

	/**
	 * METODO USADO PARA QUE ME RETOME LA PELICULA POR INDICE
	 * 
	 * @param indice
	 * @return
	 */
	public Pelicula getPeliculaPorIndice(int indice) {
		List<Pelicula> listaPeliculas = cine.getPeliculas();
		// AÑADO ESTE PARA VALIDAR LA LISTA DE PELICULAS
		if (indice < 0 || indice >= listaPeliculas.size()) {
			return null;
		}
		return listaPeliculas.get(indice);
	}

	/**
	 * METODO USADO EN FUNCION, PORQUE TENIA EL NOMBRE DE LA SALA EN STRING
	 * 
	 * @param nombre
	 * @return
	 */
	public Sala getSalaPorNombre(String nombre) {
		List<Sala> salas = cine.getSalas();
		for (Sala s : salas) {
			if (s.getNombre().equals(nombre)) {
				return s;
			}
		}
		return null;
	}

	/**
	 * METODO PARA QUE ME DEVUELVA UN STRING BIDEMENSIONAL CON LAS LISTA DE LAS
	 * FUNCIONES
	 * 
	 * @return
	 */
	public String[][] funcioneslista() {
		List<Funcion> listafunciones = cine.getFunciones();
		if (listafunciones.size() == 0) {
			throw new NullPointerException();
		}
		int filas = 0;
		String[][] listafuncionesString = new String[listafunciones.size()][3];
		for (Funcion f : listafunciones) {
			listafuncionesString[filas][0] = String.valueOf(filas + 1);
			listafuncionesString[filas][1] = f.getPelicula().getTitulo();
			listafuncionesString[filas][2] = f.getSala().getNombre();
			filas++;

		}
		return listafuncionesString;
	}

	/**
	 * METODO PARA USAR EN EL JCOMBOBOX CON LAS FUNCIONES LISTA SE IRA ACTTUALIZANDO
	 * SEGUN LA CANTIDAD DE FUNCIONES
	 * 
	 * @return
	 */
	public String[] numerosFuncionesLista() {
		List<Funcion> listaFunciones = cine.getFunciones();
		String[] letrasCantidadFunciones = new String[listaFunciones.size()];
		if (listaFunciones.size() == 0) {
			throw new NullPointerException();
		}
		int fila = 0;
		for (Funcion f : listaFunciones) {
			letrasCantidadFunciones[fila] = String.valueOf(fila + 1);
			fila++;
		}
		return letrasCantidadFunciones; // retorno en letras lo de 1, 2 , 3 .. etc
		// LO QUE RETORNO ES UN STRING CON LA CANTIDAD DE FUNCIONES QUE HAY Y ESO LO
		// DEVUELVO COMO STRING EN UN ARRAY 1, 2 ..3 ETC
	}

	/**
	 * FUNCION PARA QUE ME DEVUELVA UN STRING BIDEMENSIONAL CON LOS DATOS DEL
	 * CLIENTE
	 * 
	 * @return
	 */
	public String[][] entradaCliente() {
		List<Cliente> listaclientes = cine.getClientes();
		if (listaclientes.size() == 0) {
			throw new NullPointerException();
		}
		int flias2 = 0;
		String[][] listaclientesString = new String[listaclientes.size()][2];
		for (Cliente c : listaclientes) {
			listaclientesString[flias2][0] = String.valueOf(c.getId_Cliente());
			listaclientesString[flias2][1] = c.getNombre();
			flias2++;
		}
		return listaclientesString;

	}

	/**
	 * METODO PARA USAR EN EL JCOMBOBOX CON LAS FUNCIONES LISTA SE IRA ACTTUALIZANDO
	 * SEGUN LA CANTIDAD DE CLIENTES
	 * 
	 * @return
	 */
	public String[] numerosClienteLista() {
		List<Cliente> listaClientes = cine.getClientes();
		String[] letrasCantidadClientes = new String[listaClientes.size()];
		if (listaClientes.size() == 0) {
			throw new NullPointerException();
		}
		int fila = 0;
		for (Cliente c : listaClientes) {
			letrasCantidadClientes[fila] = String.valueOf(fila + 1);
			fila++;
		}
		return letrasCantidadClientes; // retorno en letras lo de 1, 2 , 3 .. etc
		// LO QUE RETORNO ES UN STRING CON LA CANTIDAD DE CLIENTES QUE HAY Y ESO LO
		// DEVUELVO COMO STRING EN UN ARRAY 1, 2 ..3 ETC
	}

	/**
	 * FUNCION PARA SACAR LA FUNCION DEL INDICE DE JCOMBOBOX
	 * 
	 * @param indice
	 * @return
	 */
	public Funcion getFuncionPorIndiceLista(int indice) {
		List<Funcion> listasFunciones = cine.getFunciones(); // TENGO LAS FUNCIONES
		if (indice < 0 || indice >= listasFunciones.size()) {
			return null;
		}
		return listasFunciones.get(indice);

	}

	/**
	 * METODO PARA VENDER UNA ENTRADA A UN USUARIO REGISTRADO
	 * 
	 * @param idFuncion
	 * @param idCliente
	 * @param fila
	 * @param columna
	 * @param hora
	 * @param metodoPago
	 */
	public void venderEntrada(int idFuncion, int idCliente, int fila, int columna, String hora,
			MetodoDePago metodoPago) {
		cine.venderEntrada(idFuncion, idCliente, fila, columna, hora, metodoPago);
	}

	/**
	 * METODO PARA AGREGAR ENTRADA SIN UN USUARIO REGISTRADO, RETORNA UN BOOLEAN
	 * 
	 * @param fila
	 * @param columna
	 * @param hora
	 * @param funcionElegida
	 * @return
	 */
	public boolean agregarEntradaAFuncion(int fila, int columna, String hora, Funcion funcionElegida) {
		return cine.agregarEntrada(fila, columna, hora, funcionElegida); // retorna true o false dependiendo del metodo
																			// del gestorcine
	}

	/**
	 * METODO PARA CANCELAR ENTRADA
	 * 
	 * @param idFuncion
	 * @param fila
	 * @param columna
	 * @param hora
	 * @return
	 */
	public boolean cancelarEntrada(int idFuncion, int fila, int columna, String hora) {
		return cine.cancelarEntrada(idFuncion, fila, columna, hora);
	}

	/**
	 * METODO QUE A TRAVES DE UNA FUNCION CREO UNA LISTA DE ENTRADAS DE ESA FUNCION
	 * GUARDO ESA LISTA EN UN STRING BIDEMENSIONAL EN LA QUE GUARDARA LA PELICULA,
	 * NOMBRE DE LA SALA, HORARIO, ASIENTOS, CLIENTE Y PRECIO
	 * 
	 * @param funcion
	 * @return
	 */
	public String[][] entradasPorFuncion(Funcion funcion) {
		List<Entrada> entradas = funcion.getEntradas();
		if (entradas.size() == 0) {
			throw new NullPointerException();
		}
		String[][] entradasPorFuncion = new String[entradas.size()][6];
		int fila = 0;
		for (Entrada e : entradas) {
			entradasPorFuncion[fila][0] = e.getFuncion().getPelicula().getTitulo();
			entradasPorFuncion[fila][1] = e.getFuncion().getSala().getNombre();
			entradasPorFuncion[fila][2] = e.getHora();
			entradasPorFuncion[fila][3] = "Fila: " + (e.getFila() + 1) + "Columna: " + (e.getColumna() + 1);
			if (e.getCliente() != null) {
				entradasPorFuncion[fila][4] = e.getCliente().getNombre();
			} else {
				entradasPorFuncion[fila][4] = "SIN ASIGNAR";
			}
			entradasPorFuncion[fila][5] = String.valueOf(e.getPrecio());
			fila++;

		}
		return entradasPorFuncion;
	}

	/**
	 * METODO QUE CREAR EL ARRAY LIST CLIENTE Y LUEGO CON ESE CLIENTE COMPRUEBA LAS ENTRADAS QUE TIENE Y LAS VA GUARDANDO
	 * @param indiceCliente
	 * @return
	 */
	public String[][] consultarEntradasCliente(int indiceCliente) {
		List<Cliente> clientes = cine.getClientes();//TENGO TODOS LOS CLIENTES
		
		if (indiceCliente < 0 || indiceCliente >= clientes.size()) {
			return null;
		}
		//SELECCIONO EL CLIENTE EN CUESTION CON SU ID
		Cliente cliente = clientes.get(indiceCliente);
		//CREO LA LISTA DE ENTRADAS
		List<Entrada> entradasCliente = new ArrayList<>();
		//AÑADO TODOS LAS ENTRADAS QUE TIENEN ESE ID DE CLIENTE
		for (Funcion f : cine.getFunciones()) {
			entradasCliente.addAll(f.listaEntradasClientes(cliente.getId_Cliente()));
		}
		//SI ESTA VACIA MANDO EXCEPCION
		if (entradasCliente.size() == 0) {
			throw new NullPointerException();
		}
		//CREO EL STRING QUE TENDRA LA LISTA DE ENTRADAS DE ESE CLIENTE
		String[][] resultado = new String[entradasCliente.size()][6];

		for (int i = 0; i < entradasCliente.size(); i++) {
			Entrada e = entradasCliente.get(i);
			resultado[i][0] = e.getFuncion().getPelicula().getTitulo();
			resultado[i][1] = e.getFuncion().getSala().getNombre();
			resultado[i][2] = e.getHora();
			resultado[i][3] = "Fila " + (e.getFila() + 1) + " Columna " + (e.getColumna() + 1);
			resultado[i][4] = e.getCliente().getNombre();
			resultado[i][5] = String.valueOf(e.getPrecio());
		}
		
		return resultado;
	}

}
