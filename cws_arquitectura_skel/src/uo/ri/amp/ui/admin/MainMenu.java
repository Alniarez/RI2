package uo.ri.amp.ui.admin;

import uo.ri.amp.common.util.BetterMenu;

public class MainMenu extends BetterMenu {

    public MainMenu() {
        menuOptions = new Object[][] {
                { "Administrador", null },
                { "Gesti�n de cursos", 			    GradeMenu.class },
                { "Gesti�n de asistencia",          AttendanceMenu.class},
                { "Gesti�n de certificados", 		CertificateMenu.class },
                { "Listados",               	    ListMenu.class },
        };
    }

    public static void main(String[] args) {
        new MainMenu().execute();
    }

}
