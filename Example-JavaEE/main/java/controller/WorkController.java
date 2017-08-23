package controller;

import model.Work;
import service.api.ServiceApi;
import service.api.WorkService;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * Created by Pomeo on 08.01.2017.
 */
@Path(value = "/service/work")
public class WorkController extends AbstractRestController<Work>{

    @EJB
    private WorkService workService;

    @Override
    protected ServiceApi getService() {
        return workService;
    }
}
