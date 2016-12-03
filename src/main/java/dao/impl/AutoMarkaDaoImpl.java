package dao.impl;

import org.springframework.stereotype.Repository;
import dao.AbstractHibernateDao;
import dao.api.AutoMarkaDao;
import model.AutoMarka;

/**
 * Created by Pomeo on 19.10.2016.
 */
@Repository
public class AutoMarkaDaoImpl extends AbstractHibernateDao<AutoMarka> implements AutoMarkaDao {
}
