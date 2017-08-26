package service.impl;

import dao.api.AutoMarkaDao;
import dao.api.Dao;
import model.AutoMarka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.AutoMarkaService;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class AutoMarkaServiceImpl extends AbstractService<AutoMarka, AutoMarkaDao> implements AutoMarkaService {

    @Autowired
    private AutoMarkaDao autoMarkaDao;

    @Override
    protected Dao getDao() {
        return autoMarkaDao;
    }
}
