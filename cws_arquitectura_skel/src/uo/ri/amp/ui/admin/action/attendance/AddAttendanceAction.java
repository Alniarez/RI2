package uo.ri.amp.ui.admin.action.attendance;

import static alb.util.console.Console.println;
import static uo.ri.amp.common.util.Lector.leerCadena;
import static uo.ri.amp.common.util.Lector.leerEntero;
import static uo.ri.amp.common.util.Lector.leerFecha;
import static uo.ri.amp.common.util.Lector.leerLong;

import java.util.Date;

import alb.util.menu.Action;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.common.dto.AsistenciaDTO;
import uo.ri.amp.common.dto.CursoDTO;
import uo.ri.amp.common.dto.MecanicoDTO;

/**
 * Created by Jorge.
 */
public class AddAttendanceAction  implements Action {

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigoCurso = leerCadena("Código del curso");
        long idMecanico = leerLong("Id del mecnánico");
        Date dateIn = leerFecha("Fecha de comienzo (DD/MM/YYYY)");
        Date dateOut = leerFecha("Fecha de finalización (DD/MM/YYYY)");
        int porcentajeAsistencia = leerEntero("Porcentaje de asistencia");
        boolean apto = leerCadena("¿Resulta apto? (s/n)").equalsIgnoreCase("s");

        // Generar modelo
        AsistenciaDTO asistencia = AsistenciaDTO.create()
                .setApto(apto).setPorcentaje(porcentajeAsistencia)
                .setFechaOut(dateOut).setFechaIn(dateIn)
                .setMecanico(MecanicoDTO.create().setId(idMecanico))
                .setCurso(CursoDTO.create().setCodigo(codigoCurso));

        //Guardar en la base de datos
        ServiceFactory.getAdminService().addAttendance(asistencia);

        // Mostrar resultado
        println("Se ha añadido la asistencia.");
    }


}