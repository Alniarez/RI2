package uo.ri.amp.ui.foreman.action;

import static alb.util.console.Console.println;
import static uo.ri.amp.common.util.Lector.leerCadena;
import static uo.ri.amp.common.util.Lector.leerFecha;
import static uo.ri.amp.common.util.Lector.leerLong;

import java.util.Date;

import alb.util.menu.Action;
import uo.ri.amp.common.dto.AveriaDTO;
import uo.ri.amp.common.dto.VehiculoDTO;
import uo.ri.amp.conf.ServiceFactory;
/**
 * Created by Jorge.
 */
public class AssignBreakdownAction implements Action {

    @Override
    public void execute() throws Exception {

        // Pedir datos
        String matricula = leerCadena("Matricula del coche");
        Date fechaEntrada = leerFecha("Fecha de entrada (dd/mm/yyyy)");

        VehiculoDTO vehiculoDTO = VehiculoDTO.create().setMatricula(matricula);

        if(leerCadena("¿Desea ver la lista de mecánicos? (s/n)").equalsIgnoreCase("s"))
        	println(ServiceFactory.getForemanService().listCompetentMechanics(vehiculoDTO));
        long idMecanico = leerLong("ID de mecánico");

        // Generar modelo
        AveriaDTO dto = AveriaDTO.create().setFechaEntrada(fechaEntrada).setMatricula(matricula)
                .setIdMecanico(idMecanico);

        //Procesar
        ServiceFactory.getForemanService().assignBreakdown(dto);

        //Mostrar resultado
        println("Se ha asignado la avería correctamente.");
    }
}