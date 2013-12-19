package net.jadfreex.commons.dao;

/**
 * Truco de inyección para DAO generico.
 * 
 * @author José Antonio Díaz Castro
 * @created 10-Dic-2013
 * @version 1.0
 */

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateDAOUtil extends HibernateDaoSupport {

    @Autowired
    private void inject(SessionFactory sessionFactory) {
	this.setSessionFactory(sessionFactory);
    }

}
