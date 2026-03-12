package salasdecine.modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorCine {
    
    // Listas internas
    private List<Sala> salas = new ArrayList<>();
    private List<Pelicula> peliculas = new ArrayList<>();
    private List<Funcion> funciones = new ArrayList<>(); 
    private List<Cliente> clientes = new ArrayList<>();
    private List<Factura> facturas = new ArrayList<>();

    public GestorCine() {
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
            if (c.getIdCliente() == idCliente) {
                return c;
            }
        }
        return null;
    }

    // --- VENTAS ---
    public Factura venderEntrada(int idFuncion, int idCliente, int fila, int columna, MetodoDePago metodoPago) {
        if (consultarDisponibilidad(idFuncion, fila, columna)) {
            
            Funcion f = consultarFuncion(idFuncion);
            f.ocuparAsientoSala(fila, columna); // Marcamos el asiento como ocupado
            
            // Creamos la factura usando el constructor corregido
            Factura nuevaFactura = new Factura("Fecha Actual", 10.50, metodoPago); 
            this.facturas.add(nuevaFactura);
            return nuevaFactura;
        }
        return null; // Si no hay disponibilidad, no se vende
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