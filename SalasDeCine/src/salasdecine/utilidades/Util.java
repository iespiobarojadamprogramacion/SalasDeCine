package salasdecine.utilidades;

//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;

public class Util {

	public static void validarFecha(String fecha)  throws FechaInvalidaException{
		// LA FECHA TENDRA LONGITUD ESTABLECIDA 30/12/1992 O 01/01/1992 == EN TOTAL SON
		// 10 CARACTERES
		if (fecha == null || fecha.length() != 10) {
			throw new FechaInvalidaException();
		}
		//comprobar posicion de las barras
		if (fecha.charAt(2) != '/' || fecha.charAt(5) != '/') {
			throw new FechaInvalidaException();
		}
		try {
			int dia= Integer.parseInt(fecha.substring(0, 2));
			int mes= Integer.parseInt(fecha.substring(3, 5));
			int anio= Integer.parseInt(fecha.substring(6,10));
			
			if(mes <1 || mes>12) {
				throw new FechaInvalidaException();
			}
			if(dia<1 || dia> 31) {
				throw new FechaInvalidaException();
			}
			//dia segun el mes
			int [] diasMes= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			//año bisiesto
			if((anio%4==0 && anio%100!=0) || (anio%400==0)) {
				diasMes[1]=29; //si se da la condicion del año bisiesto cambio que mes febrero tenga 29 dias
			}
			//validar dia segun el mes
			//si el dia es mayor que el diaMes [se pone menos uno porque recordar que se empieza de 0
			if(dia>diasMes[mes-1]) {
				throw new FechaInvalidaException();
			}
			
			
		}catch(NumberFormatException e) {
			throw new FechaInvalidaException();
		}
		
		// BUSQUE EL VALIDADOR DE FECHA, YA QUE HACERLO CON STRING PUEDE SER QUE ME VAYA
		// A DAR FALLOS, PERO QUEDO CON IF JAJAA POR ESO ESTA USANDO LA CLASE
		
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			LocalDate.parse(fecha, formatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}*/

	}

}
