package dao.api;

import model.BaseEntity;

/**
 * Created by Pomeo on 19.10.2016.
 */
public interface Dao<T extends BaseEntity> {

    T findById(Integer id);
    void saveOrUpdate(T entity);
    T merge(T entity);
    Long add(T entity);
    void delete(T entity);
    void deleteById(Long id);
    void evict(T entity);
}
