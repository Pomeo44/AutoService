package dao.api;

import model.BaseEntity;
import model.Master;

import java.util.List;

/**
 * Created by Pomeo on 19.10.2016.
 */
public interface Dao<T extends BaseEntity> {

    T findById(Integer id);
    List<T> getAll();
    void saveOrUpdate(T entity);
    T merge(T entity);
    Integer add(T entity);
    void delete(T entity);
    void deleteById(Integer id);
    void evict(T entity);
}
