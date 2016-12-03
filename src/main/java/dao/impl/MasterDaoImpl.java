package dao.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import dao.AbstractHibernateDao;
import dao.api.MasterDao;
import model.Master;

import java.util.List;

/**
 * Created by Pomeo on 19.10.2016.
 */
@Repository
public class MasterDaoImpl extends AbstractHibernateDao<Master> implements MasterDao {

    @Override
    public List<Master> getAllMaster() {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        return criteria.list();
    }
}
