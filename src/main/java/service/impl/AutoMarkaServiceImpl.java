package service.impl;

import dao.api.AutoMarkaDao;
import model.AutoMarka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AbstractService;
import service.api.AutoMarkaService;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Service
@Transactional
public class AutoMarkaServiceImpl extends AbstractService<AutoMarka, AutoMarkaDao> implements AutoMarkaService {

    @Autowired
    private AutoMarkaDao autoMarkaDao;

    @Override
    public AutoMarka findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<AutoMarka> getAll() {
        return autoMarkaDao.getAll();
    }

    @Override
    public void save(AutoMarka entity) {
        autoMarkaDao.saveOrUpdate(entity);
    }

    @Override
    public void update(AutoMarka entity) throws NonExistObject {
        if (findById(entity.getId()) == null) throw new NonExistObject(String.format("Марки машины с id = %s не существует!", entity.getId()));
        autoMarkaDao.merge(entity);
    }

    @Override
    public Integer add(AutoMarka entity) throws NonUniqueObject {
        if (autoMarkaDao.findByName(entity.getName()) != null) {
            throw  new NonUniqueObject("Такая марка машины уже есть");
        }
        entity.setIsDelete(false);
        return autoMarkaDao.add(entity);
    }

    @Override
    public void delete(AutoMarka entity) throws NonExistObject {
        if (findById(entity.getId()) == null) throw new NonExistObject(String.format("Марки машины с id = %s не существует!", entity.getId()));
        entity.setIsDelete(true);
        save(entity);
    }

    @Override
    public void deleteById(Integer id) throws NonExistObject {
        AutoMarka entity = findById(id);
        if (entity == null) throw new NonExistObject(String.format("Марки машины с id = %s не существует!", id));
        entity.setIsDelete(true);
        save(entity);
    }
}
