package Dao;

import Entity.Master;
import org.hibernate.Session;

/**
 * Created by aantipin on 15/10/2015.
 */
public class MasterDao {

    public Integer addMaster(Master master){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Integer result = (Integer) session.save(master);
        session.getTransaction().commit();
        return result;
    }
}
