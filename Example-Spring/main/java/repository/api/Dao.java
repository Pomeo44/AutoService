package repository.api;

import model.BaseEntity;

import java.util.List;

/**
 * Created by Pomeo on 19.10.2016.
 */
public interface Dao<T extends BaseEntity> {

    T findById(Integer id);
    T findByName(String name);
    List<T> getAll();
    void saveOrUpdate(T entity);
    T merge(T entity);
    Integer add(T entity);
    void delete(T entity);
    void deleteById(Integer id);
    void flush();
    void evict(T entity);
    void clear();
}
