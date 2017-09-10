package org.pomeo44.controller;

import org.pomeo44.model.Master;
import org.pomeo44.service.api.MasterService;
import org.pomeo44.service.api.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pomeo on 08.01.2017.
 */
@RestController
@RequestMapping(value = "/service/master")
public class MasterController extends AbstractRestController<Master>{

    @Autowired
    private MasterService masterServiceService;

    @Override
    protected ServiceApi getService() {
        return masterServiceService;
    }
}
