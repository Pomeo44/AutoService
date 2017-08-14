package service.impl;

import dao.api.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.api.MasterDao;
import model.Master;
import service.AbstractService;
import service.api.MasterService;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Service
public class MasterServiceImpl extends AbstractService<Master, MasterDao> implements MasterService{
    @Autowired
    private MasterDao masterDao;

    @Override
    protected Dao getDao() {
        return masterDao;
    }
}
