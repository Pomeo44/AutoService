package service.impl;

import repository.api.WorkRepository;
import model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.WorkService;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class WorkServiceImpl extends AbstractService<Work, WorkRepository> implements WorkService {
    @Autowired
    private WorkRepository workRepository;

    @Override
    protected WorkRepository getRepository() {
        return workRepository;
    }
}
