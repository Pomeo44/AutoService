package dao.impl;

import model.security.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import dao.AbstractHibernateDao;
import repository.api.UserDao;

@Repository
public class UserDaoImpl extends AbstractHibernateDao<User> implements UserDao {

	public User findBySSO(String sso) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Restrictions.eq("ssoId", sso));
		return (User) criteria.uniqueResult();
	}
}
