package salasdecine.modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorCine {
    
    // Listas internas
    private List<Sala> salas = new ArrayList<>(); //podemos quitar el new arraylist y ponerlo en el constructor+
    private List<Pelicula> peliculas ;
    private List<Funcion> funciones ; 
    private List<Cliente> clientes ;
    private List<Factura> facturas ;
    private double precio;

    public GestorCine() {
    	
    	salas = new ArrayList<>();
    	peliculas = new ArrayList<>();
    	funciones = new ArrayList<>();
    	clientes = new ArrayList<>();
    	facturas = new ArrayList<>();
    	
 	
    }
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
    public void registrarPelicula(Pelicula pelicula) {
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
    //Mostrar el catalogo de Peliculas
    public void mostrarCatalogoPeliculas() {
    	for (int i=0; i<peliculas.size(); i++) {
    		System.out.println((i+1)+" "+peliculas.get(i).getTitulo());
    	}
    }
    // Mostrar el Catalogo De Salas
    public void mostrarCatalogoSalas() {
    	for (int i=0; i<salas.size(); i++) {
    		System.out.println((i+1)+" "+salas.get(i).getNombre());
    	}
    }

    // --- FUNCIONES ---
    public void registrarFuncion(Funcion funcion) {
        this.funciones.add(funcion);
    }
    public void mostrarCatalogoFunciones() {
    	for (int i=0; i<funciones.size();i++) {
    		System.out.println("----------------------------------------------------");
    		System.out.println(funciones.get(i).getIdFuncion()); //System.out.println((i+1)+ " "+funciones.get(i).getIdFuncion());
    		System.out.println("\t"+funciones.get(i).getSala().getNombre());
    		System.out.println("\t"+funciones.get(i).getPelicula().getTitulo());
    		System.out.println("----------------------------------------------------");
    	}
    }

    public void modificarFuncion(int idFuncion, String nuevaFecha, String nuevaHora) {
        Funcion f = consultarFuncion(idFuncion);
        if (f != null) {
            f.setFechaInicio(nuevaFecha);
            f.setFechaFin(nuevaHora);
        }
    }

    public Funcion consultarFuncion(int idFuncion) {
        for (Funcion f : funciones) {
            if (f.getIdFuncion() == idFuncion) {
                return f;
            }
        }
        return null;
    }

    // --- CLIENTES ---
    public void registrarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Cliente consultarCliente(int idCliente) {
        for (Cliente c : clientes) {
            if (c.getId_Cliente() == idCliente) {
                return c;
            }
        }
        return null;
    }

    // --- VENTAS ---
    public Factura venderEntrada(int idFuncion, int idCliente, int fila, int columna,String hora, MetodoDePago metodoPago) {
    	Funcion funcion = consultarFuncion(idFuncion);
    	if (funcion ==null) {
    		System.out.println("Funcion no se encontro o No existe");
    		return null;
    		}
    	if(!funcion.horarioValido(hora)) {
    		return null;
    		}
    	if(!funcion.asientoValido(fila, columna)) {
    		return null;
    	}
    	//comprobar disponibilidad
    	if(!funcion.consultarDisponibilidad(fila, columna, hora)) {
    		return null;
    		}
    		Entrada entrada = new Entrada (10.50, fila, columna, hora);

    		funcion.agregarEntrada(entrada);

    		Factura factura = new Factura("FECHA ACTUAL", entrada.getPrecio(), metodoPago);
    	
    
    		facturas.add(factura);
    	
    		return factura;
    }
    	

    	
    	
    	

    public boolean cancelarEntrada(int idEntrada) {
        
        
    	return true; 
    }

   public boolean consultarDisponibilidad(int idFuncion, int fila, int columna,String hora) {
	   Funcion fun= consultarFuncion(idFuncion);
        if (fun != null) {
            return fun.consultarDisponibilidad(fila, columna,hora);
        }
        return false;
    }
    
    public Factura[] consultarVentas() {
        return facturas.toArray(new Factura[0]);
    }
}