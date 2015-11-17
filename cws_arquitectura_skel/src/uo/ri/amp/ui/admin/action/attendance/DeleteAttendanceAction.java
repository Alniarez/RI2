package uo.ri.amp.ui.admin.action.attendance;

import static alb.util.console.Console.println;
import static uo.ri.amp.util.Lector.leerCadena;
import static uo.ri.amp.util.Lector.leerLong;

import alb.util.menu.Action;
import uo.ri.amp.common.BusinessException;

/**
 * Created by Jorge.
 */
public class DeleteAttendanceAction implements Action {
    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigoCurso = leerCadena("Código del curso");
        long codigoMecanico = leerLong("Código del mecnánico");

        // Generar modelo
        

        // Mostrar resultados
        println("Asistencia eliminada con éxito.");

    }
}