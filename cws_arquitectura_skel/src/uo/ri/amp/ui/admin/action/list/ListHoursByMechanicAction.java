package uo.ri.amp.ui.admin.action.list;


import alb.util.menu.Action;
import uo.ri.amp.common.dto.MecanicoDTO;
import uo.ri.amp.conf.ServiceFactory;
import uo.ri.amp.persistence.model.Mecanico;

import static alb.util.console.Console.println;
import static uo.ri.amp.common.util.Lector.*;

public class ListHoursByMechanicAction implements Action {

    @Override
    public void execute() throws Exception {

        long idMecanico = leerEntero("ID de mecánico");

        MecanicoDTO dto = MecanicoDTO.create().setId(idMecanico);

        println(ServiceFactory.getAdminService().listHoursByMechanic(dto));




    }
}
