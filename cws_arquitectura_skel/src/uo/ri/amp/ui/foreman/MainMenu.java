package uo.ri.amp.ui.foreman;

import uo.ri.amp.ui.foreman.action.*;
import uo.ri.amp.common.util.BetterMenu;

/**
 * Created by Jorge.
 */
public class MainMenu extends BetterMenu {

    public MainMenu() {
        menuOptions = new Object[][] {
                { "Jefe de Taller", null },
                { "Registrar avería",           AddBreakdownAction.class },
                { "Modificar datos de averías", UpdateBreakdownAction.class },
                { "Eliminar avería",            DeleteBreakdownAction.class },
                { "Ver historial de averías",   ListBreakdownAction.class },
                { "Asignar avería a mecánico",  AssignBreakdownAction.class },
        };
    }

    public static void main(String[] args) {
        new MainMenu().execute();
    }

}
