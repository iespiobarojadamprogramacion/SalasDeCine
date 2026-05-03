package salasdecine.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import salasdecine.modelo.APICine;
import salasdecine.utilidades.NotFoundClienteException;
import salasdecine.vistas.DatosClienteVista;

public class DatosClienteControlador implements ActionListener {
	// TIENES QUE CREAR EL OBJETO VISTA PAPRA QUE SE RELACIONE
	private DatosClienteVista vista;
	// PARA PODER COMUNICARNOS CON EL MODELO USAMOS EL APICine, POR LO TANTO TENEMOS
	// QUE CREAR EL ATRIBUTO
	private APICine api = APICine.getInstance(); // <-- TODOS LOS CONTROLADORES TIENEN QUE TENERLO

	public DatosClienteControlador(DatosClienteVista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("SE HA PULSADO VER DATOS DEL CLIENTE");
		// GUARDO EN LA VARIABLE idCliente el dato QUE ME RETORNO EL METODO DE
		// vista.getIdCliente y como es STRING USO INTENGER PARSEINT
		String [][]resultadoCliente;
		try {
			// TENEMOS EL VALOR DEL ID CLIENTE
			int idCliente = Integer.parseInt(vista.getIdCliente());
			System.out.println(idCliente);
			resultadoCliente=api.consultaCliente(idCliente); //OBTENEMOS DEL API Y GUARDAMOS EL CLIENTE 
			vista.setCliente(resultadoCliente); //EL DATO QUE HEMOS OBTENIDO DE RESULTADOCLIENTE DE LA API (TENDRIAMOS EL CLIENTE CON ESE ID EN LA TABLA)
			
		} catch (NumberFormatException nfe) {
			System.out.println("No has introducido un numero valido");
			vista.setError("No has introducido un numero de id valido");
		} catch(NotFoundClienteException nfce) {
			vista.setError(nfce.getMessage());
			System.out.println(nfce.getMessage());
		}

	}

}
