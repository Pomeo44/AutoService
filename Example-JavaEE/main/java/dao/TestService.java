package dao;

import model.AutoMarka;
import model.AutoModel;
import model.AutoType;
import service.ServiceApi;
import service.exception.NonExistObject;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

/**
 * Created by aantipin on 16/08/2017.
 */
@Stateless
public class TestService implements ServiceApi<AutoMarka> {

    private EntityManagerFactory factory;
//    @PersistenceUnit (unitName = "MainDB")
//    private EntityManager em;

    public Integer add(AutoMarka autoMarka){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        autoMarka = em.merge(autoMarka);
        em.getTransaction().commit();
        em.close();
        factory.close();
        return autoMarka.getId();
    }

    @Override
    public void deleteById(Integer id) throws NonExistObject {

    }

    @Override
    public void delete(AutoMarka entity) throws NonExistObject {

    }

    public AutoMarka get(Integer id){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        AutoMarka autoMarka = em.find(AutoMarka.class, id);
        em.close();
        factory.close();
        return autoMarka;
    }

    @Override
    public AutoMarka findById(Integer id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        AutoMarka autoMarka = em.find(AutoMarka.class, id);
        em.close();
        factory.close();
        return autoMarka;
    }

    public List<AutoMarka> getAll(){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        TypedQuery<AutoMarka> autoMarkaTypedQuery = em.createNamedQuery("AutoMarka.getAll", AutoMarka.class);
        List<AutoMarka> autoMarkas = autoMarkaTypedQuery.getResultList();

        TypedQuery<AutoModel> autoModelTypedQuery = em.createNamedQuery("AutoModel.getAll", AutoModel.class);
        List<AutoModel> autoModels = autoModelTypedQuery.getResultList();

        TypedQuery<AutoType> autoTypeTypedQuery = em.createNamedQuery("AutoType.getAll", AutoType.class);
        List<AutoType> autoTypes = autoTypeTypedQuery.getResultList();

        System.out.println("" + autoMarkas + autoModels + autoTypes);

        em.close();
        factory.close();
        return autoMarkas;
    }

    @Override
    public void update(AutoMarka entity) throws NonExistObject {

    }

    @Override
    public void save(AutoMarka entity) {

    }

    private EntityManager getEntityManager() {
        factory = Persistence.createEntityManagerFactory("MainDB");
        EntityManager em = factory.createEntityManager();
        return em;
    }
}
