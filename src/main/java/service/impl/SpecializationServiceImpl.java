package service.impl;

import dao.api.SpecializationDao;
import model.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.api.SpecializationService;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class SpecializationServiceImpl implements SpecializationService {

    @Autowired
    private SpecializationDao specializationDao;

    @Override
    public Specialization findById(Integer id) {
        return specializationDao.findById(id);
    }

    @Override
    public List<Specialization> getAll() {
        return specializationDao.getAll();
    }

    @Override
    public void save(Specialization entity) {
        specializationDao.saveOrUpdate(entity);
    }

    @Override
    public void update(Specialization entity) throws NonExistObject {
        if (findById(entity.getId()) == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", entity.getId()));
        specializationDao.merge(entity);
    }

    @Override
    public Integer add(Specialization entity) throws NonUniqueObject {
        if (specializationDao.findByName(entity.getName()) != null) {
            throw  new NonUniqueObject("Такой тип машины уже есть");
        }
        entity.setIsDelete(false);
        return specializationDao.add(entity);
    }

    @Override
    public void delete(Specialization entity) throws NonExistObject {
        if (findById(entity.getId()) == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", entity.getId()));
        entity.setIsDelete(true);
        save(entity);
    }

    @Override
    public void deleteById(Integer id) throws NonExistObject {
        Specialization entity = findById(id);
        if (entity == null) throw new NonExistObject(String.format("Типа машины с id = %s не существует!", id));
        entity.setIsDelete(true);
        save(entity);
    }
}
