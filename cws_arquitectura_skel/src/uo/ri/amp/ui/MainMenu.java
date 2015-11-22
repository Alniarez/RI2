package uo.ri.amp.ui;

import uo.ri.amp.common.util.BetterMenu;

/**
 * Created by Jorge.
 */
class MainMenu extends BetterMenu {

    public MainMenu() {
        menuOptions = new Object[][] {
                { "Taller", null },
                { "Administrador",      uo.ri.amp.ui.admin.MainMenu.class },
                { "Jefe de taller", 	uo.ri.amp.ui.foreman.MainMenu.class },
        };
    }

    public static void main(String[] args) {
        new MainMenu().execute();
    }

}
