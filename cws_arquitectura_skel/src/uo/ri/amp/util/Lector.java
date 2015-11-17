package uo.ri.amp.util;

import static alb.util.console.Console.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lector {

	public static Date leerFecha(String mensaje) {
		String fecha = readString(mensaje);
		return parseDate(fecha);
	}

	private static Date parseDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date d = sdf.parse(date);
			return d;
		} catch (ParseException e) {
			System.out.println("Fecha en formato inválido.");
			return leerFecha("Vuelva a introducir la fecha (DD/MM/AAAA)");
		}
	}

	public static String leerCadena(String mensaje){
		return readString(mensaje);
	}

	public static int leerEntero(String mensaje){
		String entero = readString(mensaje);
		return parseInt(entero);
	}

	private static int parseInt(String enteroS) {
		int enteto = 0;
		try{
		enteto = Integer.parseInt(enteroS);
		} catch (NumberFormatException e){
			return leerEntero("Error al introducir un número. Vuelva a intentalo");
		}
		return enteto;
	}
	
	public static long leerLong(String m){
		String longS = readString(m);
		return parseLong(longS);
	}

	private static long parseLong(String longS) {
		long lon = 0;
		try{
			lon = Long.parseLong(longS);
		} catch (NumberFormatException e){
			return leerEntero("Error al introducir un número. Vuelva a intentalo");
		}
		return lon;
	}
}
