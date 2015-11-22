package uo.ri.amp.ui.foreman.action;

import alb.util.menu.Action;
import uo.ri.amp.common.dto.VehiculoDTO;
import uo.ri.amp.conf.ServiceFactory;

import static alb.util.console.Console.println;
import static uo.ri.amp.common.util.Lector.*;

/**
 * Created by Jorge.
 */
public class ListBreakdownAction implements Action {

    @Override
    public void execute() throws Exception {

        // Pedir datos y Generar modelo
        VehiculoDTO dto = VehiculoDTO.create().setMatricula(leerCadena("Matriula del vehículo"));

        // Procesar y mostrar resultados
        println(ServiceFactory.getForemanService().listBreakdownHistory(dto));
    }
}
