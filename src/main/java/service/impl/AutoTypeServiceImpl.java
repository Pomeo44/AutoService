package service.impl;

import dao.api.AutoTypeDao;
import dao.api.Dao;
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
public class AutoTypeServiceImpl extends AbstractService<AutoType, AutoTypeDao> implements AutoTypeService {

    @Autowired
    private AutoTypeDao autoTypeDao;

    @Override
    protected Dao getDao() {
        return autoTypeDao;
    }
}
