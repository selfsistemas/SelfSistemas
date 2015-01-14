package com.selfsistemas.self01.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {

private static final SessionFactory sessionFactory;
	
	static{
		
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable t){
			Exception exception = new Exception("Falha ao criar sessionFactory",t);
			throw new ExceptionInInitializerError(exception);
		}
	}
	
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
	
    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
    public static void commitTransaction(Transaction transaction){
    	if (transaction != null && !transaction.wasCommitted() && !transaction.wasRolledBack()) {
            transaction.commit();
        }
    }
    
    public static void rollbackTransaction(Transaction transaction) {
        if (transaction != null && !transaction.wasCommitted() && !transaction.wasRolledBack()) {
            transaction.rollback();
        }
    }
	
}
