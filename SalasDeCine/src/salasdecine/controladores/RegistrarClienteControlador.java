package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import salasdecine.modelo.APICine;
import salasdecine.utilidades.FechaInvalidaException;
import salasdecine.utilidades.Util;
import salasdecine.vistas.RegistrarClienteVista;

public class RegistrarClienteControlador implements ActionListener {

	// COMO LA VISTA TENEMOS QUE DETECTAR PUES TENEMOS QUE CREAR SU ATRIBUTO
	private RegistrarClienteVista vista;
	
	//PARA PODER COMUNICARNOS CON EL MODELO USAMOS EL APICine, POR LO TANTO TENEMOS QUE CREAR EL ATRIBUTO
	private APICine api= APICine.getInstance(); //<-- TODOS LOS CONTROLADORES TIENEN QUE TENERLO

	public RegistrarClienteControlador(RegistrarClienteVista vista) {
		this.vista = vista;
	}

	// CUANDO PULSEMOS EL CONTROL DE VISTAS REGISTRARCLIENTEVISTA LLAMARA A ESTE
	// CONTROLADOR
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("SE HA PULSADO EL BOTON DE REGISTRAR CLIENTE");

		// UNA VEZ IMPLEMENTADO EN LA CLASE RegistrarClienteVista TODOS LOS METODOS QUE
		// NOS RETORNEN EN VALOR DE CADA CAMPO DE TEXTO.
		// TENEMOS QUE IR CREANDO CADA VARIABLE PARA GUARDAR ESOS VALORES, SIEMPRE
		// RETORNA STRING
		String nombre = vista.getNombre();
		String email = vista.getEmail();
		String fechaNacimiento = vista.getFechaNacimiento();

		System.out.println("Nombre: " + nombre);
		System.out.println("Email: " + email);
		System.out.println("Fecha Nacimiento: " + fechaNacimiento);
		//INTENTARE CREAR UNA EXCEPCION PARA PODER OBLIGAR LAS FECHAS DE NACIMIENTO CON UN FORMATO
		//HPODEMOS CREAR UNA PAQUETE DE UTILIDADES PARA PODER TENER VALIDACIONES
		try {
			Util.validarFecha(fechaNacimiento);
			//AQUI COMO CREAMOS EL API PODEMOS RECOGER LOS METODOS DE APICine
			api.registrarCliente(nombre, email, fechaNacimiento);
			vista.respuestaOK("¡Cliente Registrado!");
			System.out.println();
			
		}catch(FechaInvalidaException fie) {
			//mando el mensaje que esta en la clase fechaInvalidaException
			vista.setError(fie.getMessage());
		}
		

	}



}
