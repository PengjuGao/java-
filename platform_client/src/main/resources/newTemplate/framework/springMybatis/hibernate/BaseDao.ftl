package ${packageName}.base;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
*Created by ${userId} on ${createTime}.
*/
@Component
public class BaseDao{
@Autowired
private SessionFactory sessionFactory;
@Autowired
private HibernateTemplate hibernateTemplate;

public HibernateTemplate getHibernateTemplate() {
return hibernateTemplate;
}

public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
this.hibernateTemplate = hibernateTemplate;
}

public SessionFactory getSessionFactory() {
return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
this.sessionFactory = sessionFactory;
}
}
