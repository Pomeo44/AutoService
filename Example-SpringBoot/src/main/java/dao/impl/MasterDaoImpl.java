package dao.impl;

import dao.AbstractHibernateDao;
import dao.api.MasterDao;
import model.Master;
import org.springframework.stereotype.Repository;

/**
 * Created by Pomeo on 19.10.2016.
 */
@Repository
public class MasterDaoImpl extends AbstractHibernateDao<Master> implements MasterDao {
}
