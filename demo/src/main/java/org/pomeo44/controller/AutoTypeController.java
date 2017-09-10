package org.pomeo44.controller;

import org.pomeo44.model.AutoType;
import org.pomeo44.service.api.AutoTypeService;
import org.pomeo44.service.api.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aantipin on 15/11/2016.
 */
@RestController
@RequestMapping(value = "/service/autoType")
public class AutoTypeController extends AbstractRestController<AutoType>{

    @Autowired
    private AutoTypeService autoTypeService;

    @Override
    protected ServiceApi getService() {
        return autoTypeService;
    }
}
