package controller;

import model.AutoType;
import service.api.AutoTypeService;
import service.api.ServiceApi;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * Created by aantipin on 15/11/2016.
 */
@Path(value = "/service/autoType")
public class AutoTypeController extends AbstractRestController<AutoType>{

    @EJB
    private AutoTypeService autoTypeService;

    @Override
    protected ServiceApi getService() {
        return autoTypeService;
    }
}
