package dao.impl;

import org.springframework.stereotype.Repository;
import dao.AbstractHibernateDao;
import dao.api.SpecializationDao;
import model.Specialization;

/**
 * Created by Pomeo on 19.10.2016.
 */
@Repository
public class SpecializationDaoImpl extends AbstractHibernateDao<Specialization> implements SpecializationDao {
}
