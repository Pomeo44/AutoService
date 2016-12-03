package dao.impl;

import org.springframework.stereotype.Repository;
import dao.AbstractHibernateDao;
import dao.api.AutoTypeDao;
import model.AutoType;

/**
 * Created by Pomeo on 19.10.2016.
 */
@Repository
public class AutoTypeDaoImpl extends AbstractHibernateDao<AutoType> implements AutoTypeDao {
}
