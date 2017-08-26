package dao.impl;

import dao.AbstractHibernateDao;
import dao.api.WorkDao;
import model.Work;
import org.springframework.stereotype.Repository;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Repository
public class WorkDaoImpl extends AbstractHibernateDao<Work> implements WorkDao {
    @Override
    public Work findByName(String name) {
        return findById(Integer.parseInt(name));
    }
}
