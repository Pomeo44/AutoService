package service.impl;

import repository.api.Dao;
import repository.api.OwnerAutoDao;
import model.OwnerAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.OwnerAutoService;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class OwnerAutoServiceImpl extends AbstractService<OwnerAuto, OwnerAutoDao> implements OwnerAutoService {

    @Autowired
    private OwnerAutoDao ownerAutoDao;

    @Override
    protected Dao getDao() {
        return ownerAutoDao;
    }
}
