package dao.impl;

import org.springframework.stereotype.Repository;
import dao.AbstractHibernateDao;
import dao.api.AutoModelDao;
import model.AutoModel;

/**
 * Created by Pomeo on 19.10.2016.
 */
@Repository
public class AutoModelDaoImpl extends AbstractHibernateDao<AutoModel> implements AutoModelDao {
}
