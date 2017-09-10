package org.pomeo44.service.impl;

import org.pomeo44.model.WorkType;
import org.pomeo44.service.AbstractService;
import org.pomeo44.service.api.WorkTypeService;
import org.pomeo44.service.repository.WorkTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class WorkTypeServiceImpl extends AbstractService<WorkType, WorkTypeRepository> implements WorkTypeService {

    @Autowired
    private WorkTypeRepository workTypeRepository;

    @Override
    protected WorkTypeRepository getRepository() {
        return workTypeRepository;
    }
}
