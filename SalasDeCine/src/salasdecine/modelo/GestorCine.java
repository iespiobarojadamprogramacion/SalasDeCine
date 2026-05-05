package salasdecine.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorCine {
	
	// Listas internas
	private List<Sala> salas ; // podemos quitar el new arraylist y ponerlo en el constructor+ = new ArrayList<>()
	private List<Pelicula> peliculas;
	private List<Funcion> funciones;
	private List<Cliente> clientes;
	private List<Factura> facturas;
	private double precio;
	

	public GestorCine() {

		salas = new ArrayList<>();
		peliculas = new ArrayList<>();
		funciones = new ArrayList<>();
		clientes = new ArrayList<>();
		facturas = new ArrayList<>();
		salas.add(new Sala("iSense", 5, 6));
		salas.add(new Sala("IMax", 5, 6));
		salas.add(new Sala("LUXE", 5, 6));
		salas.add(new Sala("Dolby Atmos", 5, 6));
		salas.add(new Sala("MaxScreen", 5, 6));
		salas.add(new Sala("4K-Vision", 5, 6));
		salas.add(new Sala("Immersive Room", 5, 6));

	}
	/*.registrarSala(new Sala("iSense", 5, 6));
	CineTresAguas.registrarSala(new Sala("IMax", 5, 6));
	CineTresAguas.registrarSala(new Sala("LUXE", 5, 6));
	CineTresAguas.registrarSala(new Sala("Dolby Atmos", 5, 6));
	CineTresAguas.registrarSala(new Sala("MaxScreen", 5, 6));
	CineTresAguas.registrarSala(new Sala("4K-Vision", 5, 6));
	CineTresAguas.registrarSala(new Sala("Immersive Room", 5, 6));*/
	
	
	
	// PRECIO
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	// --- SALAS ---
	public void registrarSala(Sala sala) {
		this.salas.add(sala);
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public List<Funcion> getFunciones() {
		return funciones;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public Sala consultarSala(String Nombresala) {
		for (Sala s : salas) {
			if (s.getNombre().equalsIgnoreCase(Nombresala)) {
				return s;
			}
		}
		return null;
	}

	// --- PELICULAS ---
	/*public void registrarPelicula(Pelicula pelicula) {
		this.peliculas.add(pelicula);
	}*/
	
	//METODO registrarPelicula QUE USARE PARA LA INTERFAZ
	public void registrarPelicula(String titulo, int duracion, String genero, ClasificacionEdad clasificacionEdad) {
		Pelicula pelicula = new Pelicula(titulo, duracion, genero, clasificacionEdad);
		this.peliculas.add(pelicula);
	}

	public Pelicula consultarPelicula(String titulo) {
		for (Pelicula p : peliculas) {
			if (p.getTitulo().equalsIgnoreCase(titulo)) {
				return p;
			}
		}
		return null;
	}

	// Mostrar el catalogo de Peliculas
	public void mostrarCatalogoPeliculas() {
		for (int i = 0; i < peliculas.size(); i++) {
			System.out.println((i + 1) + " " + peliculas.get(i).getTitulo());
		}
	}

	// Mostrar el Catalogo De Salas
	public void mostrarCatalogoSalas() {
		for (int i = 0; i < salas.size(); i++) {
			System.out.println((i + 1) + " " + salas.get(i).getNombre());
		}
	}

	// --- FUNCIONES ---
	/*public void registrarFuncion(Funcion funcion) {
		this.funciones.add(funcion);
	}*/
	//FUNCION PARA LA INTERFAZ, Y QUIZAS TOCARA MODIFICAR EL MAIN PARA QUE LA USE
	public void registrarFuncion(String fechaInicio, String fechaFin, Sala sala, Pelicula pelicula) {
		Funcion funcion= new Funcion (fechaInicio, fechaFin, sala, pelicula);
		this.funciones.add(funcion);
		
	}

	public void mostrarCatalogoFunciones() {
		for (int i = 0; i < funciones.size(); i++) {
			System.out.println("----------------------------------------------------");
			System.out.println(funciones.get(i).getIdFuncion()); // System.out.println((i+1)+ "
																	// "+funciones.get(i).getIdFuncion());
			System.out.println("\t" + funciones.get(i).getSala().getNombre());
			System.out.println("\t" + funciones.get(i).getPelicula().getTitulo());
			System.out.println("----------------------------------------------------");
		}
	}
	//quitar 
	/*public void modificarFuncion(int idFuncion, String nuevaFecha, String nuevaHora) {
		Funcion f = consultarFuncion(idFuncion);
		if (f != null) {
			f.setFechaInicio(nuevaFecha);
			f.setFechaFin(nuevaHora);
		}
	}*/

	public Funcion consultarFuncion(int idFuncion) {
		for (Funcion f : funciones) {
			if (f.getIdFuncion() == idFuncion) {
				return f;
			}
		}
		return null;
	}
	//para comprobar que la funcion existe y con ello mostrar las entradas que tiene registrada, 
	//simple comprobacion para usarla en principal
	public void mostrarEntradasDeFuncion(int idFuncion) {
		Funcion funcion= consultarFuncion(idFuncion);
		if (funcion == null) {
			System.out.println("Función no encontrada.");
			return;        
	    } else {
	    	funcion.mostrarEntradas();      
	    }

	}

	// --- CLIENTES ---
	public void registroCliente(String nombre, String email, String fechaNacimiento) {
		Cliente cliente = new Cliente(nombre, email, fechaNacimiento);
		this.clientes.add(cliente);
		System.out.println(cliente);
		System.out.println();
		//System.out.println(cliente.getId_Cliente());
	} //HASTA AQUI

	
	/*public void registrarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}*/ //<--- YA NO SE USA, LO USABAMOS PARA DECLARAR DIRECTAMENTE EL CLIENTE EN PRINCIPAL, 
	//PERO CREE UN METODO AQUI ARRIBA PARA REGISTRAR EL CLIENTE CON LOS PARAMETROS DARLE DE ALTA COMO CLIENTE Y AÑADIRLO
	//AHORA EL PRINCIPAL YA NO LO HACE SOLO LLAMA AL METODO REGISTROCLIENTE 
	
	//consulto un cliente con id cliente, y me regresa ese cliente
	public Cliente consultarCliente(int idCliente) {
		for (Cliente c : clientes) {
			if (c.getId_Cliente() == idCliente) {
				return c;
			}
		}
		return null;
	}
	//METODO PARA INTERFACEGRAFICA, DESPUES DE IMPLEMENTARLO ME DI CUENTA QUE EL METODO DE ARRIBA PODIA HABERLO USADO
	//PARA ESTO, YA QUE DIRECTAMENTE ME DEVOLVIA EL CLIENTE Y DE AHI ESOS VALORES LOS GUARDABA EN UN STRING [][]
	public ArrayList <Cliente> clienteSoloArray(int idCliente){
		ArrayList<Cliente> cliente= new ArrayList<Cliente>();
		for(int i=0; i<clientes.size();i++) {
			if(clientes.get(i).getId_Cliente()==idCliente) {
				cliente.add(clientes.get(i));
			}
		}
		return cliente;
		
	}

	// recorro la lista de clientes para mostrarla
	public void mostrarClientes() {
		for (Cliente c : clientes) {
			System.out.println("----------------------");
			System.out.println(c);
			System.out.println("----------------------");
		}
	}

	// MOSTRARA EL CLIENTE SI ESTA EN LA LISTA
	public void mostarCliente(Cliente cliente) {
		if (cliente == null) {
			System.out.println("No existe cliente con ese ID");
		} else {
			System.out.println(cliente);
		}
	}
	//muestro la entradas de los clientes
	public void mostrarEntradasClientes(int idCliente) {
		boolean tieneEntradas=false;
		//creo el cliente para comprobar de ahi
		Cliente cliente = consultarCliente(idCliente);
		//si el cliente es nulo no existe
		if (cliente==null) {
			System.out.println("Cliente no encontrado");
			return;
		}
		//muestro los datos del cliente
		System.out.println("Entradas del cliente: "+cliente.getNombre() + " con ID Cliente: "+ cliente.getId_Cliente());
		for(Funcion aux: funciones) {
			List<Entrada> entradaClientes = aux.listaEntradasClientes(idCliente);
			//en teoria el isEMpty es para ver si esta vacia la lista, en este caso anulamos eso es decir decimos que eso sea false
			//por lo tanto si entradasCLientes no esta vacia
			if(!entradaClientes.isEmpty()) {
				tieneEntradas=true; //pasamos a true asi usamos el ultimo if para comprobar si el false entonces no tiene entradas
				System.out.println("Funcion: "+aux.getPelicula().getTitulo()+ "\nSala: "+aux.getSala().getNombre());
				for(Entrada auxEntrada: entradaClientes) {
					System.out.println(auxEntrada);
				}
			}
		}
		if(tieneEntradas==false) {
			System.out.println("Este cliente no tiene entradas agregadas");
		}
	}

	// --- VENTAS ---
	public Factura venderEntrada(int idFuncion, int idCliente, int fila, int columna, String hora,
			MetodoDePago metodoPago) {
		//// consulto que la funcion existe
		Funcion funcion = consultarFuncion(idFuncion);
		if (funcion == null) {
			System.out.println("Funcion no se encontro o No existe");
			return null;
		}
		// consulto que cliente exista
		Cliente cliente = consultarCliente(idCliente);
		if (cliente == null) {
			System.out.println("El cliente no existe.");
			return null;
		}
		// valido que el horario sea el valido
		if (!funcion.horarioValido(hora)) {
			return null;
		}
		// valido que el asiento sea el valido
		if (!funcion.asientoValido(fila, columna)) {
			return null;
		}
		// comprobar disponibilidad
		if (!funcion.consultarDisponibilidad(fila, columna, hora)) {
			System.out.println("Asiento no disponible");
			return null;
		}
		
		Entrada entrada = new Entrada(precio, fila, columna, hora);

		// Asignar cliente
		entrada.asignarCliente(cliente);

		// ASIGNAR FUNCIÓN <--- OGLIGATORIAAA YA QUE SE EDITO ENTRADA Y AHORA NECESITA RECIBIR UNA FUNCION 
		entrada.asignarFuncion(funcion);

		// Registrar entrada en la función
		funcion.agregarEntrada(entrada);
		
		/*
		 * ANTIGUO CODIGO, COMO CORREGIMOS LA ENTRADA PARA QUE TENGA UNA FUNCION Y UNA ENTRADA TENEMOS QUE LLAMAR AL METODO PARA ASGINAR LA FUNCION A LA ENTRADA
		 * 
		 * Entrada entrada = new Entrada(precio, fila, columna, hora);
		// como el constructor de entrada tiene cliente nulo, aqui le asigno ese cliente
		// a la entrada
		entrada.asignarCliente(cliente);
		funcion.agregarEntrada(entrada);*/
		

		Factura factura = new Factura(precio, metodoPago, cliente, entrada);
		facturas.add(factura);
		System.out.println("Entrada vendida correctamente:");
		System.out.println(entrada);
		System.out.println("Factura generada:");
		//ver el codigo que me genere bien la factura.
		System.out.println(factura);

		return factura;
	}

	//Metodo para cancelar la entrada de la funcion.
	public boolean cancelarEntrada(int idFuncion, int fila, int columna, String hora) {
		Funcion funcion = consultarFuncion(idFuncion);
		boolean repuesta=false;
		//si funcion es nula, funcion no encontrada 
		if(funcion==null) {
			System.out.println("Funcion no encontrada");
			repuesta=false;
		//la funcion existe
		}else {
			//creamos un booleando que almacenara true o false de si esa entrada esta cancelada o no
			boolean cancelado = funcion.cancelarEntrada(fila, columna, hora);
			//si cancelado es true
			if(cancelado) {
				repuesta=true;
			}else {
				System.out.println("No existe una entrada con esos datos");
				repuesta=false;
			}
		}
		//regresa si fue o no fue cancelada, pero internamente este metodo llama al metodo de funcion que lo va a cancelar.
		return repuesta;
	}

	public boolean consultarDisponibilidad(int idFuncion, int fila, int columna, String hora) {
		Funcion fun = consultarFuncion(idFuncion);
		if (fun != null) {
			return fun.consultarDisponibilidad(fila, columna, hora);
		}
		return false;
	}
	
	//borrar
	/*public Factura[] consultarVentas() {
		return facturas.toArray(new Factura[0]);
	}*/

	// FUNCIONES QUE TENIA EN EL MAIN
	public void agregarEntrada(int fila, int columna, String hora, Funcion funcionAux) {

		if (!funcionAux.consultarDisponibilidad(fila, columna, hora)) {
			System.out.println("Ese asiento no esta disponible");
		} else {
			Entrada e = new Entrada(10.50, fila, columna, hora);
			funcionAux.agregarEntrada(e);
			System.out.println("Entrada registrada correctamente");
		}
	}

	// USADO PARA VALIDAR LAS OPCIONES CORRECTAS DE LOS CATALOGOS
	public int validarCatalogo(Scanner sc, int tamanoCatalogo) {
		int opcion;
		do {
			System.out.println("Elige una opción:");
			opcion = sc.nextInt();
			if (opcion < 1 || opcion > tamanoCatalogo) {
				System.out.println("Opción incorrecta. Inténtalo de nuevo.");
			}
		} while (opcion < 1 || opcion > tamanoCatalogo);

		return opcion;

	}

	// recibo el scanner por parametro para commprobar que la clasificacion que va a
	// introducir de la clasificacion sea correcta, ya que como se eeuqivoque
	// se rompera el codigo
	public String comprobarClasificacionEdad(Scanner sc) {
		String clasificacionEdad;

		System.out.println("SIETE - DOCE - DIECISEIS - DIECIOCHO");
		clasificacionEdad = sc.next().toUpperCase();
		while (!clasificacionEdad.equals("SIETE") && !clasificacionEdad.equals("DOCE")
				&& !clasificacionEdad.equals("DIECISEIS") && !clasificacionEdad.equals("DIECIOCHO")) {
			System.out.println("Clasificación incorrecta. Inténtalo de nuevo:");
			System.out.println("SIETE - DOCE - DIECISEIS - DIECIOCHO");
			clasificacionEdad = sc.next().toUpperCase();
		}

		return clasificacionEdad;
	}

	// metodo para saber si una sala ya tiene una funcion registrada a la hora que
	// estamos comprobando
	public boolean salaOcupadaEnHorario(Sala sala, String hora) {
		for (Funcion f : funciones) {
			if (f.getSala().equals(sala) && f.horarioValido(hora)) {
				return true; // La sala ya tiene una función en ese horario
			}
		}
		return false;
	}

	// VERIFICAR QUE LA SALA YA ESTA REGISTRADA A OTRA FUNCION, PARA PODER SACARLA Y
	// NO LA MUESTRE
	public boolean salaYaAsignada(Sala sala) {
		for (Funcion f : funciones) {
			if (f.getSala().equals(sala)) {
				return true; // La sala ya tiene una función asignada
			}
		}
		return false;
	}
	//opcion para usar en principal para que el cliente pueda cancelar sus entradas
	public void mostrarClienteCancelarEntradaLista(int idCliente) {
		//CREO UN CLIENTE CON EL ID CLIENTE, ASI CONSIGO ESE CLIENTE
		Cliente clienteAux = consultarCliente(idCliente);
		//SI EL CLIENTE ES NULO REVUELVO QUE NO EXXISTE
		if(clienteAux==null) {
			System.out.println("No existe cliente con ese ID");
			return;
		}
		//CREO UNA LISTA DE ENTRADA NUEVA Y VACIA
		List<Entrada> entradasCliente = new ArrayList <>();
		
		//RECORRO LAS FUNCIONES
	    for (Funcion f : funciones) {
	    	//BUSCADO, AÑADE TODAS LAS ENTRADAS DEL CLIENTE CON ESE ID EN EL NUEVO ARRAY QUE CONTENDRA TODAS LAS ENTRADAS DE UN CLIENTE ESPECIFICO
	        entradasCliente.addAll(f.listaEntradasClientes(idCliente));
	    }
	    //COMPROBACION SI LA LISTA ESTA VACIA
	    if (entradasCliente.isEmpty()) {
	        System.out.println("El cliente no tiene entradas registradas.");
	        return;
	    }
	    //recorrer la lista de los cliente
	    for (int i=0; i<entradasCliente.size(); i++) {
	    	System.out.println((i+1)+ " - " + entradasCliente.get(i));
	    }

	}
	public boolean cancelarEntradaClienteOpcionElegida(int opcion, int idCliente) {
		//creo un cliente
		
		//CREO UNA LISTA DE ENTRADA NUEVA Y VACIA
		List<Entrada> entradasCliente = new ArrayList <>();
		//RECORRO LAS FUNCIONES
	    for (Funcion f : funciones) {
	    	//BUSCADO, AÑADE TODAS LAS ENTRADAS DEL CLIENTE CON ESE ID EN EL NUEVO ARRAY QUE CONTENDRA TODAS LAS ENTRADAS DE UN CLIENTE ESPECIFICO
	        entradasCliente.addAll(f.listaEntradasClientes(idCliente));
	    }
		if(opcion<1 || opcion>entradasCliente.size()) {
			System.out.println("Funcion mal elegida");
			return false;
		}
		Entrada entrada = entradasCliente.get(opcion-1);
		//hacemos un booleando para asignar cancelarENtrada con todos los datos de la entrada, usamos el metodo que esta mas arriba
		boolean cancelada = cancelarEntrada(entrada.getFuncion().getIdFuncion(),entrada.getFila(),entrada.getColumna(),entrada.getHora());
		//si cancelada es true sale que se cancelo
	    if (cancelada) {
	        System.out.println("Entrada cancelada correctamente.");
	        return true;
	        //si no
	    } else {
	        System.out.println("No se pudo cancelar la entrada.");
	        return false;
	    }

	}
 
}