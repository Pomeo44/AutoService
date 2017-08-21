package service;

import model.BaseEntity;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Pomeo on 04.12.2016.
 */
@Local
public interface ServiceApi<T extends BaseEntity> {

    T findById(Integer id);
    List<T> getAll();
    void save(T entity);
    void update(T entity) throws NonExistObject;
    Integer add(T entity) throws NonUniqueObject;
    void delete(T entity) throws NonExistObject;
    void deleteById(Integer id) throws NonExistObject;
}
