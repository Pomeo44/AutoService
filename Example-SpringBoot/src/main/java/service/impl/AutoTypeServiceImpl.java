package service.impl;

import service.repository.AutoTypeRepository;
import model.AutoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.AutoTypeService;

/**
 * Created by Pomeo on 04.12.2016.
 */
@Service
@Transactional
public class AutoTypeServiceImpl extends AbstractService<AutoType, AutoTypeRepository> implements AutoTypeService {

    @Autowired
    private AutoTypeRepository autoTypeRepository;

    @Override
    protected AutoTypeRepository getRepository() {
        return autoTypeRepository;
    }
}
