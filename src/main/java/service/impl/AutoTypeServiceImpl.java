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
@Transactional
public class AutoTypeServiceImpl implements AutoTypeService {

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
    public void saveOrUpdate(AutoType entity) {
        autoTypeDao.saveOrUpdate(entity);
    }

    @Override
    public void update(AutoType entity) throws NonExistObject {
        if (autoTypeDao.findById(entity.getAutoTypeId()) == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", entity.getAutoTypeId()));
        autoTypeDao.saveOrUpdate(entity);
    }

    @Override
    public Integer add(AutoType entity) throws NonUniqueObject {
        if (autoTypeDao.findByName(entity.getName()) != null) {
            //System.out.println("A User with name " + user.getUsername() + " already exist");
            throw  new NonUniqueObject("Такой тип машины уже есть");
        }
        return autoTypeDao.add(entity);
    }

    @Override
    public void delete(AutoType entity) throws NonExistObject {
        if (autoTypeDao.findById(entity.getAutoTypeId()) == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", entity.getAutoTypeId()));
        autoTypeDao.delete(entity);
    }

    @Override
    public void deleteById(Integer id) throws NonExistObject {
        if (autoTypeDao.findById(id) == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", id));
        autoTypeDao.deleteById(id);
    }
}
