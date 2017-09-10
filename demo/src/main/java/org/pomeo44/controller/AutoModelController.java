package org.pomeo44.controller;

import org.pomeo44.model.AutoModel;
import org.pomeo44.service.api.AutoModelService;
import org.pomeo44.service.api.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
