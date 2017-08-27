package dao;

import dao.api.Dao;
import model.BaseEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * Created by Pomeo on 19.10.2016.
 */
public abstract class AbstractHibernateDao<T extends BaseEntity> implements Dao<T> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> persistentClass;

    public AbstractHibernateDao() {
        for (Type type = getClass().getGenericSuperclass(); type != null; ) {
            if (type instanceof ParameterizedType) {
                Object parameter = ((ParameterizedType) type).getActualTypeArguments()[0];

                if (parameter instanceof Class) {
                    persistentClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
                } else {
                    persistentClass = (Class<T>) ((ParameterizedType) ((TypeVariable<?>) parameter).getBounds()[0]).getRawType();
                }

                break;
            } else if (type instanceof Class) {
                type = ((Class<?>) type).getGenericSuperclass();
            }
        }
    }

    @Override
    public T findById(Integer id) {
        T t = entityManager.find(getPersistentClass(), id);
        return t;
    }

    @Override
    public T findByName(String name) {
//        Criteria criteria = getSession().createCriteria(getPersistentClass());
//        criteria.add(Restrictions.eq("name", name));
        return null;//(T) criteria.uniqueResult();
    }

    @Override
    public List<T> getAll() {
        TypedQuery<T> autoMarkaTypedQuery = entityManager.createNamedQuery(getPersistentClass().getName().replace("model.", "") + ".getAll", getPersistentClass());
        return autoMarkaTypedQuery.getResultList();
    }

    public void saveOrUpdate(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public Integer add(T entity) {
        return entityManager.merge(entity).getId();
    }

    public final void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public final void deleteById(Integer id) {
        T entity = entityManager.find(getPersistentClass(), id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public T merge(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void flush() {
        entityManager.flush();
    }

    @Override
    public void evict(T entity) {
    }

    @Override
    public void clear() {
        entityManager.clear();
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

}
