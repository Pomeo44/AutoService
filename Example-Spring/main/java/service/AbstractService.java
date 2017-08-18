package service;

import dao.api.Dao;
import model.BaseEntity;
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

    @Transactional(readOnly = true)
    @Override
    public T findById(Integer id) {
        return (T) getDao().findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> getAll() {
        return getDao().getAll();
    }

    @Transactional
    @Override
    public void save(T entity) {
        getDao().saveOrUpdate(entity);
    }

    @Transactional
    @Override
    public void update(T entity) throws NonExistObject {
        checkExistEntity(entity);
        getDao().merge(entity);
    }

    @Transactional
    @Override
    public Integer add(T entity) throws NonUniqueObject {

        entity.setIsDelete(false);
        return getDao().add(entity);
    }

    @Transactional
    @Override
    public void delete(T entity) throws NonExistObject {
        entity = checkExistEntity(entity);
        entity.setIsDelete(true);
        getDao().merge(entity);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) throws NonExistObject {
        T entity = checkExistEntity(id);
        entity.setIsDelete(true);
        getDao().merge(entity);
    }

//    private T checkUniqueEntityByName(T entity) throws NonExistObject {
//        return checkUniqueEntityByName(entity.getName());
//    }
//
//    private T checkUniqueEntityByName(Integer id) throws NonExistObject {
////        if (getDao().findByName(entity.getName()) != null) {
////            throw  new NonUniqueObject("Такая " + T.ENTITY_TYPE + " уже есть");
////        }
//    }

    private T checkExistEntity(T entity) throws NonExistObject {
        return checkExistEntity(entity.getId());
    }

    private T checkExistEntity(Integer id) throws NonExistObject {
        T entity = findById(id);
        if (entity == null) throw new NonExistObject(String.format(T.ENTITY_TYPE + " с id = %s не существует!", id));
        return entity;
    }

    abstract protected Dao getDao();
}
