package dao;

import model.AutoMarka;
import model.AutoModel;
import model.AutoType;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

/**
 * Created by aantipin on 16/08/2017.
 */
@Stateless
public class TestService {

    private EntityManagerFactory factory;
//    @PersistenceUnit (unitName = "MainDB")
//    private EntityManager em;

    public AutoMarka add(AutoMarka autoMarka){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        autoMarka= new AutoMarka();
        //autoMarka.setId(7);
        autoMarka.setName("sdfsdf");
        autoMarka.setIsDelete(false);
        autoMarka = em.merge(autoMarka);
        em.getTransaction().commit();
        em.close();
        factory.close();
        return autoMarka;
    }

    public AutoMarka get(Integer id){
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

    private EntityManager getEntityManager() {
        factory = Persistence.createEntityManagerFactory("MainDB");
        EntityManager em = factory.createEntityManager();
        return em;
    }
}
