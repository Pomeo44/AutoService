package dao.impl;

import dao.AbstractHibernateDao;
import dao.api.SpecializationDao;
import model.Specialization;
import org.springframework.stereotype.Repository;

/**
 * Created by Pomeo on 19.10.2016.
 */
@Repository
public class SpecializationDaoImpl extends AbstractHibernateDao<Specialization> implements SpecializationDao {
}
