package org.pomeo44.controller;

import org.pomeo44.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.pomeo44.service.api.ServiceApi;
import org.pomeo44.service.api.WorkService;

/**
 * Created by Pomeo on 08.01.2017.
 */
@RestController
@RequestMapping(value = "/org/pomeo44/service/work")
public class WorkController extends AbstractRestController<Work>{

    @Autowired
    private WorkService workService;

    @Override
    protected ServiceApi getService() {
        return workService;
    }
}