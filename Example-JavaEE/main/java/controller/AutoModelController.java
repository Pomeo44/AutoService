package controller;

import model.AutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import service.api.AutoModelService;
import service.api.ServiceApi;

/**
 * Created by aantipin on 11/12/2016.
 */
@RestController
@RequestMapping(value = "/service/autoModel")
public class AutoModelController extends AbstractRestController<AutoModel> {

    @Autowired
    private AutoModelService autoModelService;

    @Override
    protected ServiceApi getService() {
        return autoModelService;
    }
}
