package service.impl;

import repository.api.SpecializationRepository;
import model.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.ServiceApi;
import service.api.SpecializationService;

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
