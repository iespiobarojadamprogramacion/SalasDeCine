package salasdecine.modelo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");

		// variables para peliculas
		String tituloPelicula;
		int duracion;
		String genero;
		String clasificacionEdad;

		// variables para sala
		int fila, columna, opcionNombreSala;

		// Creamos un gestor de cine
		GestorCine CineTresAguas = new GestorCine();
		// GUARDO EN UN ARRAY DE STRING LOS NOMBRES QUE IRE USANDO PARA LAS SALAS
		String[] nombreSalasCine = new String[] { "iSense ", "IMAX ", "LUXE ", "Dolby Atmos ", "4K-Vision",
				"Immersive Room", "Surround Experience", "MaxScreen" };

		// CREAMOS LA SALA
		// LAS SALAS DEFINIRLAS DIRECTAMENTE 5 - 10 SALAS CREADAS YA Y PONERLAS ARRAY
		// NORMAL- listo
		// LA SALA PODEMOS QUITARLE UN IDENTIFICADOR Y DEJARLA CON UN NOMBRE- listo
		// DAR DE ALTA FUNCION, PELICULA Y SALA
		// HORAS DE PROYECCION EN FUNCIONES PARA SIMPLIFICAR LAS SALAS
		// UNA FUNCION TIENE QUE TENER FECHA DE ESTRENO Y FECHA DE FIN
		// AÑADIR ARRAY DE HORAS EN FUNCION ARRAY DE STRING PARA LAS HORAS DE FUNCION
		// CON LA FECHA Y HORAS
		// CUANDO EL CLIENTE PIDA UNA FUNCION LE SALDRAN LAS QUE ESTAN ENTRE LA FECHA
		// FIN Y FECHA ESTRENO
		// EN ENTRADA SE IMPLEMENTARIA ESTA LOGICA.
		// HACER FUNCION QUE TIENE SALA, PELICULA, PASES .. (ESCUCHAR AUDIO MINUTO 27)
		// PASES EN FUNCION 4-7-8 HORAS
		// funciones salas y peliculas

		String menu = "1-PELICULA\n" + "2-SALA\n" + "3-CREAR FUNCION\n" + "4-ENTRADAS\n";
		String submenuFuncion = "1-DAR DE ALTA FUNCION\n" + "2-CONSULTAR DISPONIBILIDAD DE LA FUNCION\n"
				+ "3-AGREGAR ENTRADA A UNA FUNCION\n" + "4-MOSTRAR ASIENTOS\n" + "-1 VOLVER";
		int opcion;

		do {
			System.out.println(menu);
			System.out.println("DAME UNA OPCION");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:

				sc.nextLine();
				System.out.println("----MENU--PELICULA----");
				System.out.println("\n-DAR DE ALTA PELICULA-");
				System.out.println("Dame titulo");
				tituloPelicula = sc.nextLine();
				System.out.println("Dame la duracion en minutos de la pelicula");
				duracion = sc.nextInt();
				sc.nextLine();
				System.out.println("Dame el genero de la pelicula");
				genero = sc.nextLine();
				System.out.println("Dame la clasificacion de edad: \n ");
				clasificacionEdad = comprobarClasificacionEdad(sc);
				Pelicula pelicula = new Pelicula(tituloPelicula, duracion, genero, ClasificacionEdad.valueOf(clasificacionEdad));
				System.out.println("---------PELICULA REGISTRADA: ");
				System.out.println(pelicula);
				CineTresAguas.registrarPelicula(pelicula);
				break;

			case 2:
				
				sc.nextLine();
				System.out.println("----MENU--SALA---");
				System.out.println("\n-DAR DE ALTA SALA-");
				System.out.println("Elige el nombre de la sala: ");
				//asigno UN NOMBRE DE SALA VALIDO, VERIFICADO 
				opcionNombreSala = pedirSalaValida(sc, nombreSalasCine);
				
				System.out.println("Dame el numero de filas que tiene la sala");
				fila = sc.nextInt();
				System.out.println("Dame el numero de columnas que tiene la sala");
				columna = sc.nextInt();
				Sala sala = new Sala(nombreSalasCine[opcionNombreSala - 1], fila, columna);
				System.out.println("----------SALA REGISTRADA");
				System.out.println(sala);
				CineTresAguas.registrarSala(sala);
				break;
				
			case 3:
				
				int opcionSubmenuFuncion;
				String fechaInicio, fechaFin;
				int opcionesCatalogoPeliculas, opcionesCatalogoSala;
				sc.nextLine();
				
				System.out.println("----MENU--FUNCION---");
				do {
					
					System.out.println(submenuFuncion);
					System.out.println("Elige una opcion");
					opcionSubmenuFuncion = sc.nextInt();
					
					// SWITCH PARA EL SUBMENU DE FUNCIONES
					switch (opcionSubmenuFuncion) {
					case 1:
						
	
						System.out.println("-DAR-DE-ALTA-FUNCION-");
						CineTresAguas.mostrarCatalogoPeliculas(); //MUESTRA EL CATALOGO DE PELICULAS
						
						System.out.println("Elige una pelicula del catalogo");
						//AQUI LO QUE HAGO ES QUE SE GUARDARA LA OPCION QUE SEA VALIDA, ES DECIR VERIFICANDO QUE ESTRA EN EL RANGO DE LA LISTA DE PELICULAS
						opcionesCatalogoPeliculas = validarCatalogo(sc, CineTresAguas.getPeliculas().size());
						CineTresAguas.mostrarCatalogoSalas();//MUESTRO EL CATALOGO DE SALAS

						System.out.println("Elige una sala del catalogo");
						//AQUI LO QUE HAGO ES QUE SE GUARDARA LA OPCION QUE SEA VALIDA, ES DECIR VERIFICANDO QUE ESTRA EN EL RANGO DE LA LISTA DE SALAS
						opcionesCatalogoSala = validarCatalogo(sc, CineTresAguas.getSalas().size());

						System.out.println("Elige fecha de inicio de la funcion");
						fechaInicio = sc.next();
						System.out.println("Elige fecha de fin de la funcion");
						fechaFin = sc.next();
						//CREO LA FUNCION CON LOS DATOS
						Funcion funcion = new Funcion(fechaInicio, fechaFin,
								CineTresAguas.getSalas().get(opcionesCatalogoSala - 1),
								CineTresAguas.getPeliculas().get(opcionesCatalogoPeliculas - 1));
						System.out.println("---------FUNCION REGISTRADA");
						//IMPRIMO LA FUNCION
						System.out.println(funcion);
						//AÑADO LA FUNCION 
						CineTresAguas.registrarFuncion(funcion);

						break;
					case 2:
						sc.nextLine();
						System.out.println("-CONSULTAR-DISPONIBILIDAD-DE-LA-FUNCION");
						// MUESTRO EL CATALOGO DE LAS FUNCIONES
						CineTresAguas.mostrarCatalogoFunciones();
						//CONFIRMO CON EL METODO QUE ESA FUNCION ES VALIDA Y ESTA DENTRO DEL RANGO
						int opcFuncion = validarCatalogo(sc, CineTresAguas.getFunciones().size());			
						// CREO VARIABLE AUX DE FUNCION PARA GUARDAR LA ELEGIDA
						Funcion funcionElegida = CineTresAguas.getFunciones().get(opcFuncion - 1);
						System.out.println("Introduce fila:");
						fila = sc.nextInt();
						System.out.println("Introduce columna:");
						columna = sc.nextInt();
						System.out.println("Introduce hora (16:00 / 19:00 / 22:00):");
						String hora = sc.next();
						// GUARDO EN EL BOOLEANO SI ESTA DISPONIBLE LA FUNCION
						boolean disponible = funcionElegida.consultarDisponibilidad(fila, columna, hora);

						System.out.println("¿Disponible? " + disponible);
						break;

					case 3:
						
						System.out.println("-AGREGAR-ENTRADA-");
						CineTresAguas.mostrarCatalogoFunciones();
						System.out.println("Elige una funcion");
						opcFuncion = validarCatalogo(sc, CineTresAguas.getFunciones().size());
						Funcion funcionAux = CineTresAguas.getFunciones().get(opcFuncion - 1);
						System.out.println("Fila");
						fila = sc.nextInt();
						System.out.println("Columna");
						columna = sc.nextInt();
						System.out.println("Hora");
						hora = sc.next();
						// se hizo metodo aparte para verificar que en una funcion
						// esta disponible un asiento y si lo es agrege entrada
						agregarEntrada(fila, columna, hora, funcionAux);
						break;
					case 4:
						System.out.println("----MOSTRAR-ASIENTOS----");

						CineTresAguas.mostrarCatalogoFunciones();
						System.out.println("Elige una función:");
						opcFuncion = sc.nextInt();

						Funcion fu = CineTresAguas.getFunciones().get(opcFuncion - 1);

						System.out.println("Elige hora (16:00 / 19:00 / 22:00):");
						hora = sc.next();

						System.out.println(fu.mostrarAsientos(hora));
						break;

					case -1:
						System.out.println("ADIOS!!");
						break;
					default:
						System.out.println("OPCION INCORRECTA");
						break;
					}
				} while (opcionSubmenuFuncion != -1);

				break;
			case 4:
				System.out.println("EN CONSTRUCCION");
				break;
			case -1:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opcion incorrecta...");
				break;
			}

		} while (opcion != -1);

	}

	public static void agregarEntrada(int fila, int columna, String hora, Funcion funcionAux) {
		if (!funcionAux.consultarDisponibilidad(fila, columna, hora)) {
			System.out.println("Ese asiento no esta disponible");
		} else {
			Entrada e = new Entrada(10.50, fila, columna, hora);
			funcionAux.agregarEntrada(e);
			System.out.println("Entrada registrada correctamente");
		}
	}

	// recibo el scanner por parametro para commprobar que la clasificacion que va a
	// introducir de la clasificacion sea correcta, ya que como se eeuqivoque
	// se rompera el codigo
	public static String comprobarClasificacionEdad(Scanner sc) {
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

	// USADO PARA CUANDO CREES SALA Y APAREZCA LOS NOMBRES DE LAS SALAS QUE PUEDE
	// HABER, APAREZCA EL NUMEROO ALADO
	public static void mostrarSalasConNumeros(String[] salas) {
		for (int i = 0; i < salas.length; i++) {
			System.out.println((i + 1) + ". " + salas[i]);
		}
	}
	//USADO PARA VALIDAR LAS SALAS VALIDAS, ES DECIR QUE CUANDO SE CREA Y SE PONE EL NOMBRE ESTE ENTRE EL RANGO DEL ARRAY DE SALAS
	//METEMOS TAMBIEN LA FUNCION DE MOSTRARSALASCONNUMEROS PARA VER EL NOMBRE DE LAS SALAS
	public static int pedirSalaValida(Scanner sc, String[] salas) {
	    int opcion;
	    do {
	        System.out.println("Elige una sala:");
	        mostrarSalasConNumeros(salas);
	        opcion = sc.nextInt();

	        if (opcion < 1 || opcion > salas.length) {
	            System.out.println("Opción incorrecta. Inténtalo de nuevo.");
	        }

	    } while (opcion < 1 || opcion > salas.length);

	    return opcion;
	}
	//USADO PARA VALIDAR LAS OPCIONES CORRECTAS DE LOS CATALOGOS
	public static int validarCatalogo(Scanner sc, int tamanoCatalogo) {
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

}
