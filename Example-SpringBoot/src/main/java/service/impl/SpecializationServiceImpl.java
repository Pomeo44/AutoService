package service.impl;

import dao.api.Dao;
import dao.api.SpecializationDao;
import model.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.SpecializationService;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class SpecializationServiceImpl extends AbstractService<Specialization, SpecializationDao> implements SpecializationService {

    @Autowired
    private SpecializationDao specializationDao;

    @Override
    protected Dao getDao() {
        return specializationDao;
    }
}
