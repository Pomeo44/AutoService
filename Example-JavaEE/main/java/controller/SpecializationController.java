package controller;

import model.Specialization;
import service.api.ServiceApi;
import service.api.SpecializationService;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * Created by Pomeo on 08.01.2017.
 */
@Path(value = "/service/specialization")
public class SpecializationController extends AbstractRestController<Specialization>{

    @EJB
    private SpecializationService specializationService;

    @Override
    protected ServiceApi getService() {
        return specializationService;
    }
}
