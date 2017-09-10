package org.pomeo44.service.impl;

import org.pomeo44.model.Specialization;
import org.pomeo44.service.AbstractService;
import org.pomeo44.service.api.SpecializationService;
import org.pomeo44.service.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class SpecializationServiceImpl extends AbstractService<Specialization, SpecializationRepository> implements SpecializationService{

    @Autowired
    private SpecializationRepository specializationRepository;

    @Override
    protected SpecializationRepository getRepository() {
        return specializationRepository;
    }
}
