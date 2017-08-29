package service.impl;

import repository.api.WorkTypeRepository;
import model.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.WorkTypeService;

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
