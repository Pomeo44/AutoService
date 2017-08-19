package service.impl;

import dao.api.AutoTypeDao;
import dao.api.Dao;
import dao.api.LiftDao;
import model.AutoType;
import model.Lift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.AutoTypeService;
import service.api.LiftService;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class LiftServiceImpl extends AbstractService<Lift, LiftDao> implements LiftService {

    @Autowired
    private LiftDao liftDao;

    @Override
    protected Dao getDao() {
        return liftDao;
    }
}