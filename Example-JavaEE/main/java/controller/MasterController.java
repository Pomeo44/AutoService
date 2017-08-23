package controller;

import model.Master;
import service.api.MasterService;
import service.api.ServiceApi;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * Created by Pomeo on 08.01.2017.
 */
@Path(value = "/service/master")
public class MasterController extends AbstractRestController<Master>{

    @EJB
    private MasterService masterServiceService;

    @Override
    protected ServiceApi getService() {
        return masterServiceService;
    }
}
