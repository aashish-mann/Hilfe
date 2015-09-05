package com.springapp.mvc.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springapp.mvc.entity.Consumer;
import com.springapp.mvc.entity.Login;
import com.springapp.mvc.entity.Producer;
import com.springapp.mvc.entity.User;

/**
 * Created by aashish on 3/6/15.
 */
@Repository
public class HilfeDaoImpl implements IHilfeDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getdetails() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from User where id=1");
        return (User) query.uniqueResult();

    }

    @Override
    public Login validateLogin(String username, String password) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Login.class);
        cr.add(Restrictions.like("username", username));
        cr.add(Restrictions.like("password", password));
        if(cr.list()==null)
            return null;
        else {
            return (Login)cr.uniqueResult();
        }
    }
    
	@Override
	public String validateUser(String username, String password) {
		System.out.println(password);
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from User where userId= :userId and password= :password");
		q.setParameter("userId", username);
		q.setParameter("password", password);
		User user = (User) q.uniqueResult();
		if (user == null)
			return null;
		else {
			Long userId = user.getId();
			Query q1 = sessionFactory.getCurrentSession().createQuery(
					"from Consumer where userId= :userId");
			q1.setParameter("userId", userId);
			Consumer consumer = (Consumer) q1.uniqueResult();
			if (consumer != null)
				return "consumer";
			else {
				Query q2 = sessionFactory.getCurrentSession().createQuery(
						"from Producer where userId= :userId");
				q2.setParameter("userId", userId);
				Producer producer = (Producer) q2.uniqueResult();
				if (producer != null)
					return "producer";
			}
		}

		return null;
	}
}
