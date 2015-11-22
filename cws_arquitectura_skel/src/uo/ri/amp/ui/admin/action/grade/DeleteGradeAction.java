package uo.ri.amp.ui.admin.action.grade;

import static alb.util.console.Console.println;
import static uo.ri.amp.common.util.Lector.leerCadena;

import alb.util.menu.Action;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.common.dto.CursoDTO;
import uo.ri.amp.conf.ServiceFactory;

import java.util.zip.CRC32;

public class DeleteGradeAction  implements Action {

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigo = leerCadena("Código de curso");

        // Generar modelo
        CursoDTO curso = CursoDTO.create().setCodigo(codigo);

        // Procesar
        ServiceFactory.getAdminService().deleteGrade(curso);

        // Mostrar resultado
        println("Se ha eliminado el curso.");
    }
}