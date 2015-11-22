package uo.ri.amp.ui.foreman.action;

import alb.util.menu.Action;
import javafx.animation.SequentialTransition;
import uo.ri.amp.common.dto.AveriaDTO;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.persistence.model.Averia;

import java.util.Date;

import static alb.util.console.Console.println;
import static uo.ri.amp.common.util.Lector.*;

/**
 * Created by Jorge.
 */
public class DeleteBreakdownAction implements Action {

    @Override
    public void execute() throws Exception {

        // Pedir datos
        String matricula = leerCadena("Matricula");
        Date fecha = leerFecha("Fecha de entrada (dd/mm/yyyy)");

       //Generar modelo
        AveriaDTO dto = AveriaDTO.create().setMatricula(matricula).setFechaEntrada(fecha);

        //Procesar
        ServiceFactory.getForemanService().removeBreakdown(dto);

        //Mostrar resultado
        println("Se ha eliminado la avería correctamente.");
    }
}