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
public class AddBreakdownAction implements Action{

    @Override
    public void execute() throws Exception {

        // Pedir datos
        String matricula = leerCadena("Matricula del coche");
        String descripcion = leerCadena("Descripción de la avería");
        Date fechaEntrada = leerFecha("Fecha de entrada (dd/mm/yyyy)");

        // Generar modelo
        AveriaDTO dto = AveriaDTO.create().setMatricula(matricula)
                .setDescripcion(descripcion)
                .setFechaEntrada(fechaEntrada);

        //Procesar
        ServiceFactory.getForemanService().addBreakdown(dto);

        //Mostrar resultado
        println("Se ha generado la avería correctamente.");

    }
}
