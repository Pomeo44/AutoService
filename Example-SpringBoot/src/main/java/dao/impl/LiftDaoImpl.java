package dao.impl;

import dao.AbstractHibernateDao;
import dao.api.LiftDao;
import model.Lift;
import org.springframework.stereotype.Repository;

/**
 * Created by Pomeo on 11.12.2016.
 */
@Repository
public class LiftDaoImpl extends AbstractHibernateDao<Lift> implements LiftDao {
}
