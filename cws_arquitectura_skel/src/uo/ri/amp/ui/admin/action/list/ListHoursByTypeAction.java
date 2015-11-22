package uo.ri.amp.ui.admin.action.list;

import static alb.util.console.Console.print;

import alb.util.menu.Action;
import uo.ri.amp.conf.ServiceFactory;

public class ListHoursByTypeAction implements Action {

    @Override
    public void execute() throws Exception {
             print(ServiceFactory.getAdminService().listHoursByType());
    }
}