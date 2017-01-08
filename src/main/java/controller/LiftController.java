package controller;

import model.Lift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.api.LiftService;
import service.api.ServiceApi;

/**
 * Created by Pomeo on 08.01.2017.
 */
@RestController
@RequestMapping(value = "/service/lift")
public class LiftController extends AbstractRestController<Lift>{

    @Autowired
    private LiftService liftService;

    @Override
    protected ServiceApi getService() {
        return liftService;
    }
}
