package org.pomeo44.service.impl;

import org.pomeo44.service.repository.WorkRepository;
import org.pomeo44.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.pomeo44.service.AbstractService;
import org.pomeo44.service.api.WorkService;

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
