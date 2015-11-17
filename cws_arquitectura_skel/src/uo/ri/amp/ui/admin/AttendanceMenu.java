package uo.ri.amp.ui.admin;


import uo.ri.amp.ui.admin.action.attendance.AddAttendanceAction;
import uo.ri.amp.ui.admin.action.attendance.DeleteAttendanceAction;
import uo.ri.amp.ui.admin.action.attendance.UpdateAttendanceAction;
import uo.ri.amp.ui.admin.action.attendance.ListAttendanceBygradeAction;
import uo.ri.amp.util.BetterMenu;

/**
 * Created by Jorge.
 */
public class AttendanceMenu extends BetterMenu {

    public AttendanceMenu() {
        menuOptions = new Object[][] {
                { "Administrador > Gestión de asistencia", null },
                { "Dar de alta una asistencia", 	AddAttendanceAction.class },
                { "Modificar datos de asistencias", UpdateAttendanceAction.class },
                { "Eliminar asistencia", 			DeleteAttendanceAction.class },
                { "Listar asistencias a un curso", 	ListAttendanceBygradeAction.class },
        };
    }

    public static void main(String[] args) {
        new MainMenu().execute();
    }

}
