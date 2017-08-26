package service;

import model.BaseEntity;
import service.api.ServiceApi;
import service.exception.NonExistObject;
import service.exception.NonUniqueObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * Created by Pomeo on 24.12.2016.
 */
public abstract class AbstractService<T extends BaseEntity> implements ServiceApi<T> {

    private EntityManagerFactory factory;
    private Class<T> persistentClass;
//    @PersistenceUnit (unitName = "MainDB")
//    private EntityManager em;

    public AbstractService() {
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
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        T entity = em.find(getPersistentClass(), id);

        em.close();
        factory.close();

        return entity;
    }

    @Override
    public List<T> getAll() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        TypedQuery<T> autoMarkaTypedQuery = em.createNamedQuery(getPersistentClass().getName().replace("model.", "") + ".getAll", getPersistentClass());
        List<T> entities = autoMarkaTypedQuery.getResultList();

        em.close();
        factory.close();

        return entities;
    }

    @Override
    public void save(T entity) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.merge(entity);

        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    @Override
    public void update(T entity) throws NonExistObject {
        checkExistEntity(entity);

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.merge(entity);

        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    @Override
    public Integer add(T entity) throws NonUniqueObject {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        entity = em.merge(entity);

        em.getTransaction().commit();
        em.close();
        factory.close();
        return entity.getId();
    }

    @Override
    public void delete(T entity) throws NonExistObject {
        entity = checkExistEntity(entity);
        entity.setIsDelete(true);
        update(entity);
    }

    @Override
    public void deleteById(Integer id) throws NonExistObject {
        T entity = checkExistEntity(id);
        entity.setIsDelete(true);
        update(entity);
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

    private EntityManager getEntityManager() {
        factory = factory != null ? factory : Persistence.createEntityManagerFactory("MainDB");
        EntityManager em = factory.createEntityManager();
        return em;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }
}
