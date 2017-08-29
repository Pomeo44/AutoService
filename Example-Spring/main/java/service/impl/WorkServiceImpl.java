package service.impl;

import repository.api.Dao;
import repository.api.WorkDao;
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
public class WorkServiceImpl extends AbstractService<Work, WorkDao> implements WorkService {
    @Autowired
    private WorkDao workDao;

    @Override
    protected Dao getDao() {
        return workDao;
    }
}
