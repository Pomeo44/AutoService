package dao.impl;

import dao.AbstractHibernateDao;
import dao.api.AutoTypeDao;
import dao.api.LiftDao;
import model.AutoType;
import model.Lift;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Repository
public class LiftDaoImpl extends AbstractHibernateDao<Lift> implements LiftDao {

    public Lift findByName(String name) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Lift)criteria.uniqueResult();
    }
}
