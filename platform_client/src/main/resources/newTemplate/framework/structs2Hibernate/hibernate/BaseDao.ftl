package ${packageName}.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
*  Created by ${userId} on ${createTime}.
*/
public class BaseDao {
private static final SessionFactory sessionFactory=bulidSessionFactory();

private static SessionFactory bulidSessionFactory(){
try {
Configuration cfg= new Configuration();
SessionFactory factory =  cfg.configure().buildSessionFactory();
return factory;
} catch (Throwable ex) {
throw new ExceptionInInitializerError(ex);
}
}

public static SessionFactory getSessionFactory(){
return sessionFactory;
}

public static Session getSession(){
Session session =  getSessionFactory().openSession();
return session;
}

}
