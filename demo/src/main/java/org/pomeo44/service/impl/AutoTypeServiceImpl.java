package org.pomeo44.service.impl;

import org.pomeo44.model.AutoType;
import org.pomeo44.service.AbstractService;
import org.pomeo44.service.api.AutoTypeService;
import org.pomeo44.service.repository.AutoTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
