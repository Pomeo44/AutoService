package org.pomeo44.controller;

import org.pomeo44.model.AutoMarka;
import org.pomeo44.service.api.AutoMarkaService;
import org.pomeo44.service.api.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
