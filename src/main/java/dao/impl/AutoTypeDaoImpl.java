package dao.impl;

import dao.AbstractHibernateDao;
import dao.api.AutoTypeDao;
import model.AutoType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Pomeo on 19.10.2016.
 */
@Repository
public class AutoTypeDaoImpl extends AbstractHibernateDao<AutoType> implements AutoTypeDao {

    public AutoType findByName(String name) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (AutoType)criteria.uniqueResult();
    }
}
