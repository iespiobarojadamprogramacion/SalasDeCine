package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.modelo.APICine;
import salasdecine.modelo.Funcion;
import salasdecine.modelo.MetodoDePago;
import salasdecine.vistas.VenderEntradaVista;

public class VenderEntradaControlador implements ActionListener{
	private VenderEntradaVista vista;
	private APICine api=APICine.getInstance();
	
	public VenderEntradaControlador(VenderEntradaVista vista) {
		this.vista=vista;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("HAS ELEGIDO VENDER ENTRADA");
		String [][] Listafunciones;
		String [][] ListaClientes;
		String []resultadoNumeroFunciones;
		String []resultadoNumeroClientes;
		String [][] mapaAsientos;
		
		
		if(e.getSource()==vista.getBotonclientes()) {
			try {
				ListaClientes=api.entradaCliente();
				vista.setClientes(ListaClientes);
				resultadoNumeroClientes=api.numerosClienteLista();
				vista.numerosDeClientesComboBox(resultadoNumeroClientes);
				
			}catch (NullPointerException e1 ) {
				System.out.println("no hay resultados");
				vista.setError("No hay clientes registrados!");
			}
		}else if (e.getSource()==vista.getBotonfunciones()){
			
			try {
				Listafunciones=api.funcioneslista();
				vista.setFunciones(Listafunciones);
				resultadoNumeroFunciones=api.numerosFuncionesLista();
				vista.numerosDeFuncionesComboBox(resultadoNumeroFunciones);
				
				
			}catch (NullPointerException e1 ) {
				System.out.println("no hay resultados");
				vista.setError("No hay funciones disponibles!");
				
			}
			
			//nuevo añadido
		}else if(e.getSource()==vista.getRadio16() ||e.getSource()==vista.getRadio19() || e.getSource()==vista.getRadio22() ) {		
			int indiceFuncion=vista.getFuncionSeleccionada();
			Funcion funcionSeleccionada=api.getFuncionPorIndiceLista(indiceFuncion);
			//funcionSeleccionada.mostrarAsientos(vista.getHora()); 
			if (funcionSeleccionada!=null) {
				String mapa = funcionSeleccionada.mostrarAsientos(vista.getHora()); //<--tengo que poner la hora que tengo en el radiobutton 
				vista.setMapaAsientos(mapa);
			}		
			
		}else if (e.getSource()==vista.getvender()) {
			//TERMINAR ESTO
			//System.out.println(funcionSeleccionada.getPelicula().getTitulo());
			try{
				int indiceFuncion=vista.getFuncionSeleccionada();
				Funcion funcionSeleccionada=api.getFuncionPorIndiceLista(indiceFuncion);
				int idFuncionSeleccionada=funcionSeleccionada.getIdFuncion();
				int indiceCliente=vista.getClienteSeleccionado();
				int idClienteSeleccionado=indiceCliente+1; //PORQUE EL COMBOBOX EMPIEZA DE 0 Y + 1 TENDRIAMOS EL ID DEL CLIENTE
				int filaSeleccionada=vista.getFila();
				int colummnaSeleccionada=vista.getColumna();
				String horaSeleccionada=vista.getHora();
				String metodoPagoSeleccionado=vista.getMetodoPago();
				MetodoDePago metodoPago;
				if(metodoPagoSeleccionado=="TARJETA") {
					metodoPago=MetodoDePago.TARJETA;
				}else {
					metodoPago=MetodoDePago.EFECTIVO;
				}
				if(funcionSeleccionada.consultarDisponibilidad(filaSeleccionada, colummnaSeleccionada, horaSeleccionada)) {
					api.venderEntrada(idFuncionSeleccionada, idClienteSeleccionado, filaSeleccionada, colummnaSeleccionada, horaSeleccionada, metodoPago);
					vista.respuestaOK("Entrada Vendida");
					System.out.println("Entrada Vendida");
				}else {
					vista.setError("Asiento ocupado");
				}

				
			}catch(Exception ex) {
				vista.setError("Error al vender la entrada");
				
			}
			
		}
		
			
		
	}

}
