package org.pomeo44.controller;

import org.pomeo44.model.Lift;
import org.pomeo44.service.api.LiftService;
import org.pomeo44.service.api.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
