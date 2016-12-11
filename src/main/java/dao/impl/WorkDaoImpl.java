package dao.impl;

import dao.AbstractHibernateDao;
import dao.api.PriceDao;
import dao.api.WorkDao;
import model.Price;
import model.Work;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Repository
public class WorkDaoImpl extends AbstractHibernateDao<Work> implements WorkDao {
}
