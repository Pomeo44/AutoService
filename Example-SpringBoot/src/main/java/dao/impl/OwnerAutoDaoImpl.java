package dao.impl;

import dao.AbstractHibernateDao;
import dao.api.OwnerAutoDao;
import model.OwnerAuto;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Repository
public class OwnerAutoDaoImpl extends AbstractHibernateDao<OwnerAuto> implements OwnerAutoDao {

    public OwnerAuto findByName(String name) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (OwnerAuto)criteria.uniqueResult();
    }
}
