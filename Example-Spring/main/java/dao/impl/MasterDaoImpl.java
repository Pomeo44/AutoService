package dao.impl;

import org.springframework.stereotype.Repository;
import dao.AbstractHibernateDao;
import repository.api.MasterDao;
import model.Master;

/**
 * Created by Pomeo on 19.10.2016.
 */
@Repository
public class MasterDaoImpl extends AbstractHibernateDao<Master> implements MasterDao {
}
