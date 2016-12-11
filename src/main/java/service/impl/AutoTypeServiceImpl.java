package service.impl;

import dao.api.AutoTypeDao;
import model.AutoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.api.AutoTypeService;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by Pomeo on 04.12.2016.
 */
@Service
public class AutoTypeServiceImpl implements AutoTypeService {

    @Autowired
    private AutoTypeDao autoTypeDao;

    @Override
    @Transactional
    public AutoType findById(Integer id) {
        return autoTypeDao.findById(id);
    }

    @Override
    @Transactional
    public List<AutoType> getAll() {
        return autoTypeDao.getAll();
    }

    @Override
    @Transactional
    public void save(AutoType entity) {
        autoTypeDao.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void update(AutoType entity) throws NonExistObject {
        if (findById(entity.getAutoTypeId()) == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", entity.getAutoTypeId()));
        autoTypeDao.merge(entity);
    }

    @Override
    @Transactional
    public Integer add(AutoType entity) throws NonUniqueObject {
        if (autoTypeDao.findByName(entity.getName()) != null) {
            throw  new NonUniqueObject("Такой тип машины уже есть");
        }
        entity.setIsDelete(false);
        return autoTypeDao.add(entity);
    }

    @Override
    public void delete(AutoType entity) throws NonExistObject {
        if (findById(entity.getAutoTypeId()) == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", entity.getAutoTypeId()));
        entity.setIsDelete(true);
        save(entity);
    }

    @Override
    public void deleteById(Integer id) throws NonExistObject {
        AutoType entity = findById(id);
        if (entity == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", id));
        entity.setIsDelete(true);
        save(entity);
    }
}
