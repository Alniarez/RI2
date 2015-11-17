package uo.ri.amp.ui.admin.action.attendance;

import static alb.util.console.Console.println;
import static uo.ri.amp.util.Lector.leerCadena;
import static uo.ri.amp.util.Lector.leerEntero;
import static uo.ri.amp.util.Lector.leerFecha;
import static uo.ri.amp.util.Lector.leerLong;

import java.util.Date;

import alb.util.menu.Action;
import uo.ri.amp.common.BusinessException;
/**
 * Created by Jorge.
 */
public class AddAttendanceAction  implements Action {

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigoCurso = leerCadena("Código del curso");
        long codigoMecanico = leerLong("Código del mecnánico");
        Date dateIn = leerFecha("Fecha de comienzo (DD/MM/YYYY)");
        Date dateOut = leerFecha("Fecha de finalización (DD/MM/YYYY)");
        int porcentajeAsistencia = leerEntero("Porcentaje de asistencia");
        String apto = leerCadena("¿Resultada apto? (s/n)");

        // Generar modelo
       

        // Mostrar resultado
        println("Se ha añadido la asistencia.");
    }


}