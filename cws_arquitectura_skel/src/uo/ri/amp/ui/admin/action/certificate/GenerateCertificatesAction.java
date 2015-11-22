package uo.ri.amp.ui.admin.action.certificate;

import static alb.util.console.Console.println;

import alb.util.menu.Action;
import uo.ri.amp.common.BusinessException;
import uo.ri.amp.conf.ServiceFactory;

/**
 * Created by Jorge.
 */
public class GenerateCertificatesAction implements Action{

    @Override
    public void execute() throws BusinessException {

        // Procesar y mostrar resultados
        println(ServiceFactory.getAdminService().generateCertificates());

        //Mostrar resultados
        println("Proceso de generación de certificados finalizado.");


    }
}
