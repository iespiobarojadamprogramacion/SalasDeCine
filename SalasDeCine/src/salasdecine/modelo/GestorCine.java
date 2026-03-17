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
    

    public GestorCine() {
    	
    	salas = new ArrayList<>();
    	peliculas = new ArrayList<>();
    	funciones = new ArrayList<>();
    	clientes = new ArrayList<>();
    	facturas = new ArrayList<>();
    	
 	
    }

    // --- SALAS ---
    public void registrarSala(Sala sala) {
        this.salas.add(sala);
    }

    public Sala consultarSala(int codigoSala) {
        for (Sala s : salas) {
            if (s.getCodigoSala() == codigoSala) {
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

    // --- FUNCIONES ---
    public void registrarFuncion(Funcion funcion) {
        this.funciones.add(funcion);
    }

    public void modificarFuncion(int idFuncion, String nuevaFecha, String nuevaHora) {
        Funcion f = consultarFuncion(idFuncion);
        if (f != null) {
            f.setFecha(nuevaFecha);
            f.setHoraProyeccion(nuevaHora);
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
    public Factura venderEntrada(int idFuncion, int idCliente, int fila, int columna, MetodoDePago metodoPago) {
    	Funcion f = consultarFuncion(idFuncion);
    	//verificamos que la funcion sea distinta de null, que esa funcion este disponible el asiento
    	//si es el caso
    	if (f!=null && f.consultarDisponibilidadAsientos(fila, columna)==true) {
    		//generamos una entrada, el precio hay que ver como cambiarle el valor, o si le mantenemos
    		//con esa funcion ocupamos el asiento, agregamos la entrada y generamos la factura. 
    		Entrada entrada= new Entrada(10.50, fila, columna);
    		f.ocuparAsientoSala(fila, columna);
    		f.agregarEntrada(entrada);
    		//LA FECHA hay que ir cambiandola dia a dia.
    		Factura nuevaFactura= new Factura("Fecha Actual", entrada.getPrecio(), metodoPago);
    		facturas.add(nuevaFactura);//añadimos la factura al ArrayList de facturas
    		return nuevaFactura;
    		
    	}
    	return null;
    	/*if (consultarDisponibilidad(idFuncion, fila, columna)) {
            
            
            f.ocuparAsientoSala(fila, columna); // Marcamos el asiento como ocupado
            
            // Creamos la factura usando el constructor corregido
            Factura nuevaFactura = new Factura("Fecha Actual", 10.50, metodoPago); 
            this.facturas.add(nuevaFactura);
            return nuevaFactura;
        }
        return null; // Si no hay disponibilidad, no se vende*/
    }

    public boolean cancelarEntrada(int idEntrada) {
        // Aquí iría la lógica para buscar la entrada, liberar el asiento en la Función y anularla
        
    	return true; 
    }

    public boolean consultarDisponibilidad(int idFuncion, int fila, int columna) {
        Funcion f = consultarFuncion(idFuncion);
        if (f != null) {
            return f.consultarDisponibilidadAsientos(fila, columna);
        }
        return false;
    }

    public Factura[] consultarVentas() {
        return facturas.toArray(new Factura[0]);
    }
}