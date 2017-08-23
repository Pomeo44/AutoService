package controller;

import model.WorkType;
import service.api.ServiceApi;
import service.api.WorkTypeService;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * Created by Pomeo on 08.01.2017.
 */
@Path(value = "/service/workType")
public class WorkTypeController extends AbstractRestController<WorkType>{

    @EJB
    private WorkTypeService workTypeService;

    @Override
    protected ServiceApi getService() {
        return workTypeService;
    }
}
