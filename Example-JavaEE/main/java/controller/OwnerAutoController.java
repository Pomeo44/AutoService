package controller;

import model.OwnerAuto;
import service.api.OwnerAutoService;
import service.api.ServiceApi;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * Created by Pomeo on 08.01.2017.
 */
@Path(value = "/service/ownerAuto")
public class OwnerAutoController extends AbstractRestController<OwnerAuto>{

    @EJB
    private OwnerAutoService ownerAutoService;

    @Override
    protected ServiceApi getService() {
        return ownerAutoService;
    }
}
