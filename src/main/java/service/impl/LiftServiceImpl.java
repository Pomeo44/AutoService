package service.impl;

import dao.api.LiftDao;
import model.Lift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.api.LiftService;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class LiftServiceImpl implements LiftService {

    @Autowired
    private LiftDao liftDao;

    @Override
    public Lift findById(Integer id) {
        return liftDao.findById(id);
    }

    @Override
    public List<Lift> getAll() {
        return liftDao.getAll();
    }

    @Override
    public void save(Lift entity) {
        liftDao.saveOrUpdate(entity);
    }

    @Override
    public void update(Lift entity) throws NonExistObject {
        if (findById(entity.getId()) == null) throw new NonExistObject(String.format("Подъемника с id = %s не существует!", entity.getId()));
        liftDao.merge(entity);
    }

    @Override
    public Integer add(Lift entity) throws NonUniqueObject {
        if (liftDao.findByNumber(entity.getNumber()) != null) {
            throw  new NonUniqueObject("Такой подъемник уже есть");
        }
        entity.setIsDelete(false);
        return liftDao.add(entity);
    }

    @Override
    public void delete(Lift entity) throws NonExistObject {
        if (findById(entity.getId()) == null) throw new NonExistObject(String.format("Подъемник с id = %s не существует!", entity.getId()));
        entity.setIsDelete(true);
        save(entity);
    }

    @Override
    public void deleteById(Integer id) throws NonExistObject {
        Lift entity = findById(id);
        if (entity == null) throw new NonExistObject(String.format("Подъемник с id = %s не существует!", id));
        entity.setIsDelete(true);
        save(entity);
    }
}
