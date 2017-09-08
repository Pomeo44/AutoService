package org.pomeo44.controller;

import org.pomeo44.model.AutoMarka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.pomeo44.service.api.AutoMarkaService;
import org.pomeo44.service.api.ServiceApi;

/**
 * Created by aantipin on 11/12/2016.
 */
@RestController
@RequestMapping(value = "/org/pomeo44/service/autoMarka")
public class AutoMarkaController extends AbstractRestController<AutoMarka> {

    @Autowired
    private AutoMarkaService autoMarkaService;

    @Override
    protected ServiceApi getService() {
        return autoMarkaService;
    }
}
