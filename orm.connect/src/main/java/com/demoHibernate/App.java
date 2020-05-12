package com.demoHibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.demoHibernate.model.Allian;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args )
    {
        	Allian raj = new Allian();
        	/*raj.setId(107402);
        	raj.setaName("Kavi");
        	raj.setColor("Ranu");*/
        	
        	AllienName nameData = new AllienName();
        	nameData.setfName("Narendra");
        	nameData.setMName("Damaodar");
        	nameData.setLName("Modi");
        	
        	Allian modi = new Allian();
        	modi.setId(100);
        	modi.setColor("Light Brown");
        	modi.setaName(nameData);
        	
        	Configuration configuration = new Configuration().configure().addAnnotatedClass(Allian.class);
        	
        	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	Session session = sessionFactory.openSession();
        	Transaction transaction = session.beginTransaction();
        	session.save(modi);
        	
        	/*
        	 * Fetch data from db
        	 * 
        	
        	raj = (Allian) session.get(Allian.class, 1001);
        	System.out.println(raj);
        	
        	*/
        	transaction.commit();
    }
}
