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
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class WorkTypeServiceImpl implements AutoTypeService {

    @Autowired
    private AutoTypeDao autoTypeDao;

    @Override
    public AutoType findById(Integer id) {
        return autoTypeDao.findById(id);
    }

    @Override
    public List<AutoType> getAll() {
        return autoTypeDao.getAll();
    }

    @Override
    public void save(AutoType entity) {
        autoTypeDao.saveOrUpdate(entity);
    }

    @Override
    public void update(AutoType entity) throws NonExistObject {
        if (findById(entity.getId()) == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", entity.getId()));
        autoTypeDao.merge(entity);
    }

    @Override
    public Integer add(AutoType entity) throws NonUniqueObject {
        if (autoTypeDao.findByName(entity.getName()) != null) {
            throw  new NonUniqueObject("Такой тип машины уже есть");
        }
        entity.setIsDelete(false);
        return autoTypeDao.add(entity);
    }

    @Override
    public void delete(AutoType entity) throws NonExistObject {
        if (findById(entity.getId()) == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", entity.getId()));
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
