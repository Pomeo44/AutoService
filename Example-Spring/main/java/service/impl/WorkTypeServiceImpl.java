package service.impl;

import dao.api.Dao;
import dao.api.WorkTypeDao;
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
public class WorkTypeServiceImpl extends AbstractService<WorkType, WorkTypeDao> implements WorkTypeService {

    @Autowired
    private WorkTypeDao workTypeDao;

    @Override
    protected Dao getDao() {
        return workTypeDao;
    }
}
