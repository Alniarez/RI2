package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.grade.AddGradeAction;
import uo.ri.amp.ui.admin.action.grade.DeleteGradeAction;
import uo.ri.amp.ui.admin.action.grade.ListGradesAction;
import uo.ri.amp.ui.admin.action.grade.UpdateGradeAction;
import uo.ri.amp.common.util.BetterMenu;

class GradeMenu extends BetterMenu {

    public GradeMenu() {
        menuOptions = new Object[][] {
                { "Administrador > Gestión de cursos", null },
                { "Añadir curso", 				    AddGradeAction.class },
                { "Modificar datos de cursos", 	    UpdateGradeAction.class },
                { "Eliminar curso", 				DeleteGradeAction.class },
                { "Listar cursos", 				    ListGradesAction.class },
        };
    }

    public static void main(String[] args) {
        new MainMenu().execute();
    }

}
