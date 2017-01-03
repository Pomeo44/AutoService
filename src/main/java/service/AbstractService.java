package service;

import dao.api.Dao;
import model.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import service.api.ServiceApi;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by Pomeo on 24.12.2016.
 */
@Transactional
public abstract class AbstractService<T extends BaseEntity, K extends Dao<T>> implements ServiceApi<T> {

    @Autowired
    protected K dao;

    @Override
    public T findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    public void save(T entity) {
        dao.saveOrUpdate(entity);
    }

    @Override
    public void update(T entity) throws NonExistObject {
        checkUniqueEntity(entity);
        dao.merge(entity);
    }

    @Override
    public Integer add(T entity) throws NonUniqueObject {
        if (dao.findByName(entity.getName()) != null) {
            throw  new NonUniqueObject("Такая " + T.ENTITY_TYPE + " уже есть");
        }
        entity.setIsDelete(false);
        return dao.add(entity);
    }

    @Override
    public void delete(T entity) throws NonExistObject {
        checkUniqueEntity(entity);
        entity.setIsDelete(true);
        save(entity);
    }

    @Override
    public void deleteById(Integer id) throws NonExistObject {
        T entity = checkUniqueEntity(id);
        entity.setIsDelete(true);
        save(entity);
    }

    private T checkUniqueEntity(T entity) throws NonExistObject {
        return checkUniqueEntity(entity.getId());
    }

    private T checkUniqueEntity(Integer id) throws NonExistObject {
        T entity = findById(id);
        if (entity == null) throw new NonExistObject(String.format(T.ENTITY_TYPE + " с id = %s не существует!", id));
        return entity;
    }

}
