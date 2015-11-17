package uo.ri.amp.ui.foreman.action;

import static alb.util.console.Console.println;
import static uo.ri.amp.util.Lector.leerCadena;
import static uo.ri.amp.util.Lector.leerFecha;
import static uo.ri.amp.util.Lector.leerLong;

import java.util.Date;

import alb.util.menu.Action;

/**
 * Created by Jorge.
 */
public class AssignBreakdownAction implements Action {

    @Override
    public void execute() throws Exception {

        // Pedir datos
        String matricula = leerCadena("Matricula del coche");
        Date fechaEntrada = leerFecha("Fecha de entrada (dd/mm/yyyy)");



        if(leerCadena("¿Desea ver la lista de mecánicos? (y/n)").equalsIgnoreCase("y"))
        	;
 
        long idMecanico = leerLong("ID de mecánico");

        // Generar modelo


        //Procesar


        //Mostrar resultado
        println("Se ha asignado la avería correctamente.");
    }
}