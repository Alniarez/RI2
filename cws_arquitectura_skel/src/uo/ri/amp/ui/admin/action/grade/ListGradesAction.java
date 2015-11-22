package uo.ri.amp.ui.admin.action.grade;


import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;

import static alb.util.console.Console.println;

public class ListGradesAction implements Action{

    @Override
    public void execute() throws Exception {

        // Procesar y mostrar resultados
        System.out.print(ServiceFactory.getAdminService().listGrades());

    }
}
