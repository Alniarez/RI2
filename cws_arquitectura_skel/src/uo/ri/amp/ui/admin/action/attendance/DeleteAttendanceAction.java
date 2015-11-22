package uo.ri.amp.ui.admin.action.attendance;

import alb.util.menu.Action;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.AsistenciaDTO;
import uo.ri.amp.common.dto.CursoDTO;
import uo.ri.amp.common.dto.MecanicoDTO;
import uo.ri.amp.conf.ServiceFactory;

import static alb.util.console.Console.println;
import static uo.ri.amp.common.util.Lector.leerCadena;
import static uo.ri.amp.common.util.Lector.leerLong;

/**
 * Created by Jorge.
 */
public class DeleteAttendanceAction implements Action {

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigoCurso = leerCadena("Código del curso");
        long idMecanico = leerLong("Código del mecnánico");

        //Crear modelo
        AsistenciaDTO asistenciaDTO = AsistenciaDTO.create()
                .setMecanico(MecanicoDTO.create().setId(idMecanico))
                .setCurso(CursoDTO.create().setCodigo(codigoCurso));

        // Procesar
        ServiceFactory.getAdminService().deleteAttendance(asistenciaDTO);

        // Mostrar resultados
        println("Asistencia eliminada con éxito.");

    }
}