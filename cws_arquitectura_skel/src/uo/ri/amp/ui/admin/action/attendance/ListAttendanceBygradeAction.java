package uo.ri.amp.ui.admin.action.attendance;

import static alb.util.console.Console.println;
import static uo.ri.amp.common.util.Lector.leerCadena;

import alb.util.menu.Action;
import uo.ri.amp.common.dto.AsistenciaDTO;
import uo.ri.amp.common.dto.CursoDTO;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.persistence.model.Asistencia;

/**
 * Created by Jorge.
 */
public class ListAttendanceByGradeAction implements Action {
    @Override
    public void execute() throws Exception {

        // Pedir datos
        String codigoCurso = leerCadena("Código del curso");

        // Generar modelo
        AsistenciaDTO asistenciaDTO = AsistenciaDTO.create()
                .setCurso(CursoDTO.create().setCodigo(codigoCurso));

        // Procesar y mostrar resultados
        println(ServiceFactory.getAdminService().listAttendance(asistenciaDTO));
    }
}