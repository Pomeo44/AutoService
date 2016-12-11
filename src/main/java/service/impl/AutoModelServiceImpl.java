package service.impl;

import dao.api.AutoModelDao;
import model.AutoMarka;
import model.AutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.api.AutoMarkaService;
import service.api.AutoModelService;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class AutoModelServiceImpl implements AutoModelService {

    @Autowired
    private AutoModelDao autoModelDao;

    @Override
    public AutoModel findById(Integer id) {
        return autoModelDao.findById(id);
    }

    @Override
    public List<AutoModel> getAll() {
        return autoModelDao.getAll();
    }

    @Override
    public void save(AutoModel entity) {
        autoModelDao.saveOrUpdate(entity);
    }

    @Override
    public void update(AutoModel entity) throws NonExistObject {
        if (findById(entity.getAutoModelId()) == null) throw new NonExistObject(String.format("Модели машины с id = %s не существует!", entity.getAutoModelId()));
        autoModelDao.merge(entity);
    }

    @Override
    public Integer add(AutoModel entity) throws NonUniqueObject {
        if (autoModelDao.findByName(entity.getName()) != null) {
            throw  new NonUniqueObject("Такая модель машины уже есть");
        }
        entity.setIsDelete(false);
        return autoModelDao.add(entity);
    }

    @Override
    public void delete(AutoModel entity) throws NonExistObject {
        if (findById(entity.getAutoModelId()) == null) throw new NonExistObject(String.format("Модель машины с id = %s не существует!", entity.getAutoModelId()));
        entity.setIsDelete(true);
        save(entity);
    }

    @Override
    public void deleteById(Integer id) throws NonExistObject {
        AutoModel entity = findById(id);
        if (entity == null) throw new NonExistObject(String.format("Модель машины с id = %s не существует!", id));
        entity.setIsDelete(true);
        save(entity);
    }
}
