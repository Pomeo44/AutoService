package service.impl;

import repository.api.AutoModelRepository;
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
public class AutoModelServiceImpl extends AbstractService<AutoModel, AutoModelRepository> implements AutoModelService {

    @Autowired
    private AutoModelRepository autoModelRepository;

    @Override
    protected AutoModelRepository getRepository() {
        return autoModelRepository;
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
