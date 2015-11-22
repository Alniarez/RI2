package uo.ri.amp.conf;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.business.ForemanService;
import uo.ri.amp.business.impl.AdminServiceImpl;
import uo.ri.amp.business.impl.ForemanServiceImpl;

/**
 * Created by Jorge.
 */
public class ServiceFactory {

    static public AdminService getAdminService(){
        return new AdminServiceImpl();
    }

    public static ForemanService getForemanService() {
        return new ForemanServiceImpl();
    }
}
