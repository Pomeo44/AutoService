package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.api.MasterDao;
import model.Master;
import service.api.MasterService;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by Pomeo on 20.10.2016.
 */
@Service
public class MasterServiceImpl implements MasterService{
    @Autowired
    private MasterDao masterDao;

    @Override
    public Master findById(Integer id) {
        return masterDao.findById(id);
    }

    @Override
    public List<Master> getAll() {
        return masterDao.getAll();
    }

    @Override
    public void save(Master entity) {
        masterDao.saveOrUpdate(entity);
    }

    @Override
    public void update(Master entity) throws NonExistObject {
        if (findById(entity.getId()) == null) throw new NonExistObject(String.format("Мастер с id = %s не существует!", entity.getId()));
        masterDao.merge(entity);
    }

    @Override
    public Integer add(Master entity) throws NonUniqueObject {
        if (masterDao.findByName(entity.getName()) != null) {
            throw  new NonUniqueObject("Такой Мастер уже есть");
        }
        entity.setIsDelete(false);
        return masterDao.add(entity);
    }

    @Override
    public void delete(Master entity) throws NonExistObject {
        if (findById(entity.getId()) == null) throw new NonExistObject(String.format("Мастер с id = %s не существует!", entity.getId()));
        entity.setIsDelete(true);
        save(entity);
    }

    @Override
    public void deleteById(Integer id) throws NonExistObject {
        Master entity = findById(id);
        if (entity == null) throw new NonExistObject(String.format("Мастер с id = %s не существует!", id));
        entity.setIsDelete(true);
        save(entity);
    }
}
