package uo.ri.amp.ui.foreman.action;

import alb.util.menu.Action;
import uo.ri.amp.model.Averia;
import uo.ri.amp.model.Vehiculo;
import java.util.Date;

import static alb.util.console.Console.println;
import static uo.ri.amp.util.Lector.*;

/**
 * Created by Jorge.
 */
public class AddBreakdownAction implements Action{

    @Override
    public void execute() throws Exception {

        // Pedir datos
        String matricula = leerCadena("Matricula del coche");
        String descripcion = leerCadena("Descripci�n de la aver�a");
        Date fechaEntrada = leerFecha("Fecha de entrada (dd/mm/yyyy)");

        // Generar modelo
       

        //Procesar


        //Mostrar resultado
        println("Se ha generado la avería correctamente.");

    }
}
