package controller;

import model.AutoMarka;
import org.springframework.beans.factory.annotation.Autowired;
import service.api.AutoMarkaService;
import service.api.ServiceApi;

/**
 * Created by aantipin on 11/12/2016.
 */
@RestController
@RequestMapping(value = "/service/autoMarka")
public class AutoMarkaController extends AbstractRestController<AutoMarka> {

    @Autowired
    private AutoMarkaService autoMarkaService;

    @Override
    protected ServiceApi getService() {
        return autoMarkaService;
    }
}
