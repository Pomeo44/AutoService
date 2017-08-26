package dao.impl;

import dao.AbstractHibernateDao;
import dao.api.WorkTypeDao;
import model.WorkType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Repository
public class WorkTypeDaoImpl extends AbstractHibernateDao<WorkType> implements WorkTypeDao {

    public WorkType findByName(String name) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (WorkType)criteria.uniqueResult();
    }
}
