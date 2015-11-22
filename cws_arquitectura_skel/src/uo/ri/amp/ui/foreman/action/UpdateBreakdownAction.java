package uo.ri.amp.ui.foreman.action;

import alb.util.menu.Action;
import uo.ri.amp.common.dto.AveriaDTO;
import uo.ri.amp.conf.ServiceFactory;

import java.util.Date;

import static alb.util.console.Console.println;
import static uo.ri.amp.common.util.Lector.*;

/**
 * Created by Jorge.
 */
public class UpdateBreakdownAction implements Action {

    @Override
    public void execute() throws Exception {

        // Pedir datos
        String matricula = leerCadena("Matricula del coche");
        String descripcion = leerCadena("Descripción de la avería");
        Date fecha = leerFecha("Fecha de entrada (dd/mm/yyyy)");

        // Generar modelo
        AveriaDTO dto = AveriaDTO.create()
                .setMatricula(matricula)
                .setDescripcion(descripcion)
                .setFechaEntrada(fecha);

        //Procesar
        ServiceFactory.getForemanService().updateBreakdown(dto);

        //Mostrar resultado
        println("Se ha modificado la avería correctamente.");
    }

}