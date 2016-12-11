package service.impl;

import dao.api.OwnerAutoDao;
import model.OwnerAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.api.OwnerAutoService;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class OwnerAutoServiceImpl implements OwnerAutoService {

    @Autowired
    private OwnerAutoDao ownerAutoDao;

    @Override
    public OwnerAuto findById(Integer id) {
        return ownerAutoDao.findById(id);
    }

    @Override
    public List<OwnerAuto> getAll() {
        return ownerAutoDao.getAll();
    }

    @Override
    public void save(OwnerAuto entity) {
        ownerAutoDao.saveOrUpdate(entity);
    }

    @Override
    public void update(OwnerAuto entity) throws NonExistObject {
        if (findById(entity.getOwnerAutoId()) == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", entity.getOwnerAutoId()));
        ownerAutoDao.merge(entity);
    }

    @Override
    public Integer add(OwnerAuto entity) throws NonUniqueObject {
        if (ownerAutoDao.findByName(entity.getName()) != null) {
            throw  new NonUniqueObject("Такой тип машины уже есть");
        }
        entity.setIsDelete(false);
        return ownerAutoDao.add(entity);
    }

    @Override
    public void delete(OwnerAuto entity) throws NonExistObject {
        if (findById(entity.getOwnerAutoId()) == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", entity.getOwnerAutoId()));
        entity.setIsDelete(true);
        save(entity);
    }

    @Override
    public void deleteById(Integer id) throws NonExistObject {
        OwnerAuto entity = findById(id);
        if (entity == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", id));
        entity.setIsDelete(true);
        save(entity);
    }
}
