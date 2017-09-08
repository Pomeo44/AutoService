package org.pomeo44.controller;

import org.pomeo44.model.OwnerAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.pomeo44.service.api.OwnerAutoService;
import org.pomeo44.service.api.ServiceApi;

/**
 * Created by Pomeo on 08.01.2017.
 */
@RestController
@RequestMapping(value = "/org/pomeo44/service/ownerAuto")
public class OwnerAutoController extends AbstractRestController<OwnerAuto>{

    @Autowired
    private OwnerAutoService ownerAutoService;

    @Override
    protected ServiceApi getService() {
        return ownerAutoService;
    }
}
