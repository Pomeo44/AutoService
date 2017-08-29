package dao.impl;

import dao.AbstractHibernateDao;
import repository.api.AutoModelDao;
import model.AutoModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Pomeo on 19.10.2016.
 */
@Repository
public class AutoModelDaoImpl extends AbstractHibernateDao<AutoModel> implements AutoModelDao {
    public AutoModel findByName(String name) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (AutoModel)criteria.uniqueResult();
    }
}
