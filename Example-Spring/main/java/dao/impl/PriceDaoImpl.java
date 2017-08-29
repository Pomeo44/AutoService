package dao.impl;

import dao.AbstractHibernateDao;
import repository.api.PriceDao;
import model.Price;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Repository
public class PriceDaoImpl extends AbstractHibernateDao<Price> implements PriceDao {

    public Price findByName(String name) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Price)criteria.uniqueResult();
    }
}
