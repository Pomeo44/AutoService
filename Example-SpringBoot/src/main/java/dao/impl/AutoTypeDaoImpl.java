package dao.impl;

import dao.AbstractHibernateDao;
import dao.api.AutoTypeDao;
import model.AutoType;
import org.springframework.stereotype.Repository;

/**
 * Created by Pomeo on 19.10.2016.
 */
@Repository
public class AutoTypeDaoImpl extends AbstractHibernateDao<AutoType> implements AutoTypeDao {
}
