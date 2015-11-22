package uo.ri.amp.ui.admin.action.list;


import alb.util.menu.Action;
import uo.ri.amp.common.dto.HorasMecanicoTipoDTO;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.persistence.Finder;
import uo.ri.amp.persistence.model.Mecanico;
import uo.ri.amp.persistence.model.TipoVehiculo;


import java.util.List;
import java.util.Map;

import static alb.util.console.Console.print;

public class ListHoursByTypeAction implements Action {

    @Override
    public void execute() throws Exception {
             print(ServiceFactory.getAdminService().listHoursByType());
    }
}