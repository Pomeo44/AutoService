package service.impl;

import repository.api.AutoModelDao;
import repository.api.Dao;
import model.AutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.AutoModelService;
import service.exception.NonExistObject;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class AutoModelServiceImpl extends AbstractService<AutoModel, AutoModelDao> implements AutoModelService {

    @Autowired
    private AutoModelDao autoModelDao;

    @Override
    protected Dao getDao() {
        return autoModelDao;
    }

    @Override
    public void update(AutoModel entity) throws NonExistObject {
//        if (entity.getAutoMarkaId() == null && entity.getAutoMarka() != null) {
//            entity.setAutoMarkaId(entity.getAutoMarka().getId());
//        } else if (entity.getAutoMarka() == null && entity.getAutoMarkaId() != null) {
//            AutoMarka autoMarka = new AutoMarka();
//            autoMarka.setId(entity.getAutoMarkaId());
//            entity.setAutoMarka(autoMarka);
//        }
        super.update(entity);
    }
}
