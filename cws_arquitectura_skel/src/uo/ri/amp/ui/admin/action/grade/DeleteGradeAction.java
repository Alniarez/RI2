package uo.ri.amp.ui.admin.action.grade;

import static alb.util.console.Console.println;
import static uo.ri.amp.util.Lector.leerCadena;

import alb.util.menu.Action;
import uo.ri.amp.common.BusinessException;

public class DeleteGradeAction  implements Action {

    @Override
    public void execute() throws BusinessException {

        // Pedir datos
        String codigo = leerCadena("Código de curso");


        // Mostrar resultado
        println("Se ha eliminado el curso.");
    }
}