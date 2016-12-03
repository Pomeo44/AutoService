package dao;

import org.hibernate.*;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import dao.api.Dao;
import model.BaseEntity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Created by Pomeo on 19.10.2016.
 */
@Component
public abstract class AbstractHibernateDao<T extends BaseEntity> implements Dao<T> {

    @Autowired
    private SessionFactory sessionFactory;
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
        T t = (T) getSession().get(getPersistentClass(), id);
        return t;
    }

    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public Long add(T entity) {
        return (Long) getSession().save(entity);
    }

    public final void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public final void deleteById(Long id) {
        Session session = getSession();
        Object o = session.get(getPersistentClass(), id);
        if (o != null) {
            session.delete(o);
        }
    }

    @Override
    public T merge(T entity) {
        return (T) getSession().merge(entity);
    }

    @Override
    public void evict(T entity) {
        getSession().evict(entity);
    }

    public Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        if (session instanceof SessionImplementor) {
            ((SessionImplementor)session).setAutoClear(true);
        }
        return session;
    }

    public Session openSession() {
        Session session = sessionFactory.openSession();
        return session;
    }

    public void closeSession(Session session) {
        session.close();
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }
}