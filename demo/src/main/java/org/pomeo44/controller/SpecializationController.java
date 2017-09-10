package org.pomeo44.controller;

import org.pomeo44.model.Specialization;
import org.pomeo44.service.api.ServiceApi;
import org.pomeo44.service.api.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pomeo on 08.01.2017.
 */
@RestController
@RequestMapping(value = "/service/specialization")
public class SpecializationController extends AbstractRestController<Specialization>{

    @Autowired
    private SpecializationService specializationService;

    @Override
    protected ServiceApi getService() {
        return specializationService;
    }
}
