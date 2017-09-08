package org.pomeo44.controller;

import org.pomeo44.model.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.pomeo44.service.api.ServiceApi;
import org.pomeo44.service.api.WorkTypeService;

/**
 * Created by Pomeo on 08.01.2017.
 */
@RestController
@RequestMapping(value = "/org/pomeo44/service/workType")
public class WorkTypeController extends AbstractRestController<WorkType>{

    @Autowired
    private WorkTypeService workTypeService;

    @Override
    protected ServiceApi getService() {
        return workTypeService;
    }
}
