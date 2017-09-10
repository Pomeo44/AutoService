package org.pomeo44.controller;

import org.pomeo44.model.OwnerAuto;
import org.pomeo44.service.api.OwnerAutoService;
import org.pomeo44.service.api.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pomeo on 08.01.2017.
 */
@RestController
@RequestMapping(value = "/service/ownerAuto")
public class OwnerAutoController extends AbstractRestController<OwnerAuto>{

    @Autowired
    private OwnerAutoService ownerAutoService;

    @Override
    protected ServiceApi getService() {
        return ownerAutoService;
    }
}
