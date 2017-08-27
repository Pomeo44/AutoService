package dao.impl;

import dao.AbstractHibernateDao;
import dao.api.AutoMarkaDao;
import model.AutoMarka;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Pomeo on 19.10.2016.
 */
@Repository
public class AutoMarkaDaoImpl extends AbstractHibernateDao<AutoMarka> implements AutoMarkaDao {
    public AutoMarka findByName(String name) {
//        Criteria criteria = getCriteria();
//        criteria.add(Restrictions.eq("name", name));
//        return (AutoMarka)criteria.uniqueResult();
        return null;
    }
}
