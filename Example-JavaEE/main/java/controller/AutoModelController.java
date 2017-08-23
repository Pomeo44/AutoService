package controller;

import model.AutoModel;
import service.api.AutoModelService;
import service.api.ServiceApi;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * Created by aantipin on 11/12/2016.
 */
@Path(value = "/service/autoModel")
public class AutoModelController extends AbstractRestController<AutoModel> {

    @EJB
    private AutoModelService autoModelService;

    @Override
    protected ServiceApi getService() {
        return autoModelService;
    }
}
