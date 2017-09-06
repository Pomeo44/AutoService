package org.pomeo44.service.api;

import org.pomeo44.model.BaseEntity;
import org.pomeo44.service.exception.NonExistObject;
import org.pomeo44.service.exception.NonUniqueObject;

import java.util.List;

/**
 * Created by Pomeo on 04.12.2016.
 */
public interface ServiceApi<T extends BaseEntity> {

    T findById(Integer id);
    List<T> getAll();
    void update(T entity) throws NonExistObject;
    Integer add(T entity) throws NonUniqueObject;
    void delete(T entity) throws NonExistObject;
    void deleteById(Integer id) throws NonExistObject;
}
