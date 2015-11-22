package uo.ri.amp.ui.admin;

import uo.ri.amp.common.util.BetterMenu;

public class MainMenu extends BetterMenu {

    public MainMenu() {
        menuOptions = new Object[][] {
                { "Administrador", null },
                { "Gestión de cursos", 			    GradeMenu.class },
                { "Gestión de asistencia",          AttendanceMenu.class},
                { "Gestión de certificados", 		CertificateMenu.class },
                { "Listados",               	    ListMenu.class },
        };
    }

    public static void main(String[] args) {
        new MainMenu().execute();
    }

}
