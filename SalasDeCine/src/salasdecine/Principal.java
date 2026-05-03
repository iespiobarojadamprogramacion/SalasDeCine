package salasdecine;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import salasdecine.modelo.ClasificacionEdad;
import salasdecine.modelo.Cliente;
import salasdecine.modelo.Factura;
import salasdecine.modelo.Funcion;
import salasdecine.modelo.GestorCine;
import salasdecine.modelo.MetodoDePago;
import salasdecine.modelo.Pelicula;
import salasdecine.modelo.Sala;

public class Principal {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);


		// variables para peliculas
		String tituloPelicula;
		int duracion;
		String genero;
		String clasificacionEdad;

		// variables para sala
		int fila, columna, opcionNombreSala;

		// Creamos un gestor de cine
		GestorCine CineTresAguas = new GestorCine();
		// SE CREAN LAS SALAS PARA EL CINE
		CineTresAguas.registrarSala(new Sala("iSense", 5, 6));
		CineTresAguas.registrarSala(new Sala("IMax", 5, 6));
		CineTresAguas.registrarSala(new Sala("LUXE", 5, 6));
		CineTresAguas.registrarSala(new Sala("Dolby Atmos", 5, 6));
		CineTresAguas.registrarSala(new Sala("MaxScreen", 5, 6));
		CineTresAguas.registrarSala(new Sala("4K-Vision", 5, 6));
		CineTresAguas.registrarSala(new Sala("Immersive Room", 5, 6));
		// tengo que añadir un set para asignar el precio que tendra la entrada
		double precioEntrada = 10.50;
		CineTresAguas.setPrecio(precioEntrada);

		// GUARDO EN UN ARRAY DE STRING LOS NOMBRES QUE IRE USANDO PARA LAS SALAS
		String menu = "1 GESTION PELICULA\n" + "2 GESTION SALA\n" + "3 GESTION FUNCION\n"
				+ "4 GESTION CLIENTE\n5 GESTION ENTRADAS\n";
		String submenuFuncion = "1-DAR DE ALTA FUNCION\n" + "2-CONSULTAR DISPONIBILIDAD DE LA FUNCION\n"
				+ "3-AGREGAR ENTRADA A UNA FUNCION\n" + "4-MOSTRAR ASIENTOS\n" + "-1 VOLVER";

		String menuSala = "1 MOSTRAR TODAS LAS SALAS \n2 SALAS LIBRES\n3 MOSTRAR SALAS OCUPADAS\n-1 ATRAS\n";
		String menuCliente = "1 REGISTRAR CLIENTE \n2 VER DATOS CLIENTE \n3 VER LISTA CLIENTES \n-1 ATRAS";
		String menuEntradas = "1 VENDER ENTRADA\n2 MOSTRAR ENTRADAS FUNCION\n3 CANCELAR ENTRADAS\n4 CONSULTAR ENTRADA CLIENTE\n5 CANCELAR MI ENTRADA\n-1 ATRAS";

		int opcion;

		do {
			System.out.println(menu);
			System.out.println("DAME UNA OPCION");
			opcion = sc.nextInt();

			switch (opcion) {
			//OPCION MENU PRINCIPAL GESTION PELICULA
			case 1:

				sc.nextLine();
				System.out.println("----MENU--PELICULA----");
				System.out.println("\n-DAR DE ALTA PELICULA-");
				System.out.println("Dame titulo");
				tituloPelicula = sc.nextLine().toUpperCase();
				System.out.println("Dame la duracion en minutos de la pelicula");
				duracion = sc.nextInt();
				sc.nextLine();
				System.out.println("Dame el genero de la pelicula");
				genero = sc.nextLine().toUpperCase();
				System.out.println("Dame la clasificacion de edad: \n ");
				clasificacionEdad = CineTresAguas.comprobarClasificacionEdad(sc);
				/*Pelicula pelicula = new Pelicula(tituloPelicula, duracion, genero,
						ClasificacionEdad.valueOf(clasificacionEdad));*/
				System.out.println("¡PELICULA REGISTRADA! ");
				CineTresAguas.registrarPelicula(tituloPelicula, duracion, genero,
						ClasificacionEdad.valueOf(clasificacionEdad));
				break;
				
			//OPCION MENU PRINCIPAL GESTION SALA
			case 2:

				sc.nextLine();
				// COMO LAS SALAS YA LAS CREO IMPLEMENTAREMOS EN SALA UN CATALOGO PARA VERIFICAR
				// VARIAS COSAS DE SALAS.

				int opcionSalaMenu;
				do {
					System.out.println("\n----MENU--SALA---");
					System.out.println(menuSala);
					System.out.println("Elige una opcion");
					opcionSalaMenu = sc.nextInt();
					switch (opcionSalaMenu) {
					case 1:
						// MOSTRAMOS LAS SALAS QUE HAY HECHAS
						System.out.println("Todas las salas");
						CineTresAguas.mostrarCatalogoSalas();
						break;
					case 2:
						// MOSTRARA SOLO LAS SALAS LIBRES, ES DECIR USAMOS EL METODO DE SALAYAASIGNADA
						// SI ES FALSE, ENTONCES ESTA OCUPADA
						System.out.println("Salas libres");
						for (Sala salas : CineTresAguas.getSalas()) {
							if (!CineTresAguas.salaYaAsignada(salas)) {
								System.out.println(salas);
							}
						}
						break;
					case 3:
						// PARA VER LAS SALAS OCUPADAS, LO MISMO DEL ANTERIOR PERO SIN LA NEGACION, POR
						// LO TANTO SI RECORRO LAS LISTAS DE SALAS ,
						// CON EL METODO SALAYAASIGNADA NOS DARA LAS OCUPADAS
						System.out.println("Salas ocupadas");
						for (Sala salas : CineTresAguas.getSalas()) {
							if (CineTresAguas.salaYaAsignada(salas)) {
								System.out.println(salas);
							}
						}
						break;
					case -1:
						System.out.println("VOLVIENDO ATRAS");
						break;
					default:
						System.out.println("OPCION DEL MENU SALA INCORRECTA");
						break;

					}

				} while (opcionSalaMenu != -1);

				break;
			//OPCION MENU PRINCIPAL GESTION FUNCION
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
						// MOSTRARA CATALOGO DE LAS PELICULAS
						CineTresAguas.mostrarCatalogoPeliculas(); // MUESTRA EL CATALOGO DE PELICULAS
						System.out.println("Elige una pelicula del catalogo");
						// AQUI LO QUE HAGO ES QUE SE GUARDARA LA OPCION QUE SEA VALIDA, ES DECIR
						// VERIFICANDO QUE ESTRA EN EL RANGO DE LA LISTA DE PELICULAS
						opcionesCatalogoPeliculas = CineTresAguas.validarCatalogo(sc,
								CineTresAguas.getPeliculas().size());

						// MOSTRARA CATALOGO DE LAS SALAS
						CineTresAguas.mostrarCatalogoSalas();// MUESTRO EL CATALOGO DE SALAS
						System.out.println("Elige una sala del catalogo");
						// MOSTRARA SOLO SALAS DISPONIBLES
						System.out.println("Elige una sala:");
						int opcSala = CineTresAguas.validarCatalogo(sc, CineTresAguas.getSalas().size());

						Sala salaElegida = CineTresAguas.getSalas().get(opcSala - 1);

						// COMPROBACIÓN IMPORTANTE
						// AQUI LO QUE HAGO ES QUE SE GUARDARA LA OPCION QUE SEA VALIDA, ES DECIR
						// VERIFICANDO QUE ESTRA EN EL RANGO DE LA LISTA DE SALAS
						if (CineTresAguas.salaYaAsignada(salaElegida)) {
							System.out.println("ERROR: Esa sala ya tiene una función asignada.");
							break;
						}

						// PIDO FECHAS DE INICIO DE LA FUNCION A LARGO PLAZO
						System.out.println("Elige fecha de inicio de la funcion");
						fechaInicio = sc.next();
						// PIDO FECHAS DE FIN DE LA FUNCION A LARGO PLAZO
						System.out.println("Elige fecha de fin de la funcion");
						fechaFin = sc.next();

						// CREO LA FUNCION CON LOS DATOS

						Funcion funcion = new Funcion(fechaInicio, fechaFin, salaElegida,
								CineTresAguas.getPeliculas().get(opcionesCatalogoPeliculas - 1));
						System.out.println("---------FUNCION REGISTRADA");
						// IMPRIMO LA FUNCION
						System.out.println(funcion);
						// AÑADO LA FUNCION
						CineTresAguas.registrarFuncion(funcion);
						break;

					case 2:
						sc.nextLine();
						System.out.println("-CONSULTAR-DISPONIBILIDAD-DE-LA-FUNCION");
						// MUESTRO EL CATALOGO DE LAS FUNCIONES
						CineTresAguas.mostrarCatalogoFunciones();
						// CONFIRMO CON EL METODO QUE ESA FUNCION ES VALIDA Y ESTA DENTRO DEL RANGO
						int opcFuncion = CineTresAguas.validarCatalogo(sc, CineTresAguas.getFunciones().size());
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
						opcFuncion = CineTresAguas.validarCatalogo(sc, CineTresAguas.getFunciones().size());
						Funcion funcionAux = CineTresAguas.getFunciones().get(opcFuncion - 1);
						System.out.println("Fila");
						fila = sc.nextInt();
						System.out.println("Columna");
						columna = sc.nextInt();
						System.out.println("Hora");
						hora = sc.next();
						// se hizo metodo aparte para verificar que en una funcion
						// esta disponible un asiento y si lo es agrege entrada
						CineTresAguas.agregarEntrada(fila, columna, hora, funcionAux);
						break;
					case 4:
						
					
						System.out.println("----MOSTRAR-ASIENTOS----");
						CineTresAguas.mostrarCatalogoFunciones();
						System.out.println("Elige una función:");
						opcFuncion = sc.nextInt();
						Funcion fu = CineTresAguas.getFunciones().get(opcFuncion - 1);
						System.out.println("Elige Hora \n1 - 16:00 \n2 - 19:00 \n3 - 22:00");
						int opcionHora = sc.nextInt();
						hora = (opcionHora == 1) ? "16:00" :
						              (opcionHora == 2) ? "19:00" : "22:00";    
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
			//OPCION MENU PRINCIPAL GESTION CLIENTES
			case 4:
				System.out.println("------MENU-CLIENTES------");
				int opcionMenuClientes;
				String nombre;
				String email;
				String fechaNacimiento;
				int idCliente;

				do {
					System.out.println(menuCliente);
					System.out.println("Elige una opcion");
					opcionMenuClientes = sc.nextInt();
					switch (opcionMenuClientes) {
					case 1:
						sc.nextLine();
						System.out.println("Registrar Cliente");
						System.out.println("Dame el nombre del cliente");
						nombre = sc.nextLine();
						System.out.println("Dame el email del cliente");
						email = sc.nextLine();
						System.out.println("Dame la fecha de nacimiento del cliente");
						fechaNacimiento = sc.nextLine();
						CineTresAguas.registroCliente(nombre, email, fechaNacimiento); 
						//LO EDITE POR EL MOTIVO DE LA INTERFAZ
						//Cliente cliente = new Cliente(nombre, email, fechaNacimiento);
						//CineTresAguas.registrarCliente(cliente);
						System.out.println("¡Cliente registrado!");
						//System.out.println(cliente);
						break;
					case 2:

						System.out.println("Ver datos del cliente");
						System.out.println("Dame el id cliente");
						idCliente = sc.nextInt();
						// devuelve un cliente
						Cliente aux = CineTresAguas.consultarCliente(idCliente);
						CineTresAguas.mostarCliente(aux);
						break;
					case 3:
						System.out.println("Ver lista Clientes");
						CineTresAguas.mostrarClientes();
						break;
					case -1:
						System.out.println("MENU PRINCIPAL");
						break;
					default:
						System.out.println("OPCION INCORRECTA");
						break;
					}
				} while (opcionMenuClientes != -1);
				break;
			//OPCION MENU PRINCIPAL GESTION ENTRADAS
			case 5:
				System.out.println("-----MENU-GESTION-ENTRADAS------");
				int opcionMenuEntradas;

				do {
					System.out.println(menuEntradas);
					// "1 VENDER ENTRADA\n 2 MOSTRAR ENTRADAS FUNCION\n 3 CANCELAR ENTRADAS\n 4
					// CONSULTAR ENTRADA CLIENTE"
					System.out.println("Dame una opcion");
					opcionMenuEntradas = sc.nextInt();
					switch (opcionMenuEntradas) {
					case 1:
						sc.nextLine();
						System.out.println("Vender entrada");
						CineTresAguas.mostrarCatalogoFunciones();
						int opcionFuncionElegida;
						System.out.println("Elige una funcion");
						opcionFuncionElegida = sc.nextInt();
						//convertimos la hora en menu numerico para evitar errores
						System.out.println("Elige Hora \n1 - 16:00 \n2 - 19:00 \n3 - 22:00");
						String hora="";
						String opcionHora = sc.next();
						if(opcionHora.equals("16:00")) {
							hora="16:00";
						}else if(opcionHora.equals("19:00")) {
							hora="19:00";
						}else if(opcionHora.equals("22:00")) {
							hora="22:00";
						}else {
							if(opcionHora.equals("1") || opcionHora.equals("2")|| opcionHora.equals("3")) {
								 hora = (opcionHora == "1") ? "16:00" :
						              (opcionHora == "2") ? "19:00" :
						            	  (opcionHora =="3")?"22:00":"error" ;
							}
						}
						    
						
					
						
						 
						//mostrare los asientos para que eliga que fila y columna quieren
						//posible mejora con un if para evitar crasheos
						Funcion fu = CineTresAguas.getFunciones().get(opcionFuncionElegida - 1);
						System.out.println("Mapa de asientos para la hora " + hora + ":");
						System.out.println();
						System.out.println(fu.mostrarAsientos(hora));
						System.out.println("Fila:");
		                fila = sc.nextInt()-1; //le puse menos uno porque el cliente entiene de fila 1 columna 1 no columna 0 como en los arrays
		                System.out.println("Columna:");
		                columna = sc.nextInt()-1;
		                System.out.println("Elige un cliente:");	                   
		                CineTresAguas.mostrarClientes();
		                idCliente = sc.nextInt();
		                //posible mejora cuando muestre los clientes que eliga una opcion correcta, un if para evitar errores
		                System.out.println("Método de pago [1-Tarjeta, 2-Efectivo]:");
		                //CORREGIR ESTA PARTE
		                int metodoPago = sc.nextInt();
		                MetodoDePago metodo = (metodoPago == 1) ? MetodoDePago.TARJETA : MetodoDePago.EFECTIVO;
		                //HASTA AQUI, EL ERROR ESTA EN QUE CUANDO VAS A ELEGIR EL METODO DE PAGO SI PONES 1 NO SE ASIGNA
		                
		                Factura factura = CineTresAguas.venderEntrada(opcionFuncionElegida, idCliente, fila, columna, hora, metodo);
		                if (factura != null) {
		                    System.out.println("Venta realizada con éxito.");
		                    System.out.println(factura);
		                } else {
		                    System.out.println("No se pudo completar la venta.");
		                }
		                break;

					case 2:
						sc.nextLine();
						System.out.println("Mostrar entradas");
						CineTresAguas.mostrarCatalogoFunciones();
						int opcionIdFuncion= sc.nextInt();
						CineTresAguas.mostrarEntradasDeFuncion(opcionIdFuncion);
						
						break;
					case 3:
						sc.nextLine();
						System.out.println("Cancelar entradas");
						CineTresAguas.mostrarCatalogoFunciones();
						System.out.println("Elige una funcion");
						int opcionFuncionElegidaCancelar = sc.nextInt();
					    System.out.println("Elige hora de tu funcion a cancelar: \n1 - 16:00 \n2 - 19:00 \n3 - 22:00");
					    int opcionHoraCancelar = sc.nextInt();
					    String horaCancelar = (opcionHoraCancelar == 1) ? "16:00" :
					                        (opcionHoraCancelar == 2) ? "19:00" : "22:00";
					    Funcion funcionACancelar = CineTresAguas.consultarFuncion(opcionFuncionElegidaCancelar);
					    System.out.println("Asientos ocupadas en esa hora que has elegido");
					    funcionACancelar.mostrarAsientos(horaCancelar);
					    System.out.println("Fila:");
					    int filaCancelar = sc.nextInt() - 1;
					    System.out.println("Columna:");
					    int columnaCancelar = sc.nextInt() - 1;
					    CineTresAguas.cancelarEntrada(opcionFuncionElegidaCancelar, filaCancelar, columnaCancelar, horaCancelar);
					    System.out.println("Entrada cancelada");
					    funcionACancelar.mostrarAsientos(horaCancelar);
					
						break;
					case 4:
						System.out.println("Consultar Entrada de cliente");
						//MUESTRA LA LISTA DE LOS CLIENTES
						CineTresAguas.mostrarClientes();
						System.out.println("Elige un cliente");
						int opcionIdCliente=sc.nextInt();
						//consultamos las entradas individual que tiene cada cliente
						CineTresAguas.mostrarEntradasClientes(opcionIdCliente);
						//quizas habria que añadir para que el propio cliente vea sus entradas
						break;
					case 5:
					    System.out.println("Cancelar mi entrada (cliente)");
					    System.out.println("Dame tu numero de id");
					    int idUsuarioElegido=sc.nextInt();
					    CineTresAguas.mostrarClienteCancelarEntradaLista(idUsuarioElegido);
					    System.out.println("¿Que funcion quieres cancelar?");
					    int opcionCancelar=sc.nextInt();
					    CineTresAguas.cancelarEntradaClienteOpcionElegida(opcionCancelar, idUsuarioElegido);
					    break;


					case -1:
						System.out.println("MENU PRINCIPAL");
						break;
					default:
						System.out.println("OPCION INCORRECTA");
						break;

					}

				} while (opcionMenuEntradas != -1);
				break;
			//OPCION MENU PRINCIPAL PARA SALIR DEL MENU PRINCIPAL
			case -1:
				System.out.println("Saliendo del programa...");
				break;
			//OPCION MENU PRINCIPAL SI LA OPCION ES INCORRECTA
			default:
				System.out.println("Opcion incorrecta...");
				break;
			}

		} while (opcion != -1);

	}

}