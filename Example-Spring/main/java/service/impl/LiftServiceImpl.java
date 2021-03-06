package service.impl;

import repository.api.Dao;
import repository.api.LiftDao;
import model.Lift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.LiftService;

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
