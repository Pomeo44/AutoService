package org.pomeo44.controller;

import org.pomeo44.model.AutoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.pomeo44.service.api.AutoTypeService;
import org.pomeo44.service.api.ServiceApi;

/**
 * Created by aantipin on 15/11/2016.
 */
@RestController
@RequestMapping(value = "/org/pomeo44/service/autoType")
public class AutoTypeController extends AbstractRestController<AutoType>{

    @Autowired
    private AutoTypeService autoTypeService;

    @Override
    protected ServiceApi getService() {
        return autoTypeService;
    }
}
