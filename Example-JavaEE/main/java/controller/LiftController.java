package controller;

import model.Lift;
import service.api.LiftService;
import service.api.ServiceApi;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * Created by Pomeo on 08.01.2017.
 */
@Path(value = "/service/lift")
public class LiftController extends AbstractRestController<Lift>{

    @EJB
    private LiftService liftService;

    @Override
    protected ServiceApi getService() {
        return liftService;
    }
}
