package com.hibernate.cache;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.cache.model.Allien;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		
		Allien allien = new Allien();
		allien.setaId(13);
		allien.setaName("Sonali");
		allien.setaColor("Light Brown");
		
		Configuration configuration = new Configuration().configure()

				.addAnnotatedClass(Allien.class);

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();

//		allien = (Allien) session.get(Allien.class, 13);
//		System.out.println("session :" +allien);
////		allien = (Allien) session.get(Allien.class, 12);
////		System.out.println(allien);
//		//session.save(allien);
//		transaction.commit();
//		session.close();
//		Session session1 = sessionFactory.openSession();
//		Transaction transaction1 = session1.beginTransaction();
//
//		allien = (Allien) session1.get(Allien.class, 13);
//		System.out.println("session 1" +allien);
//		transaction1.commit();
	
		//Hibernate caching Level 2 with Query
		
		Session sessionQ = sessionFactory.openSession();
		sessionQ.beginTransaction();
		Query query = sessionQ.createQuery("from Allien_cache where aId=13");
		query.setCacheable(true);
		
		allien =(Allien) query.uniqueResult();
		System.out.println(allien);
		sessionQ.getTransaction().commit();
		sessionQ.close();
		
		Session sessionQ1 = sessionFactory.openSession();
		sessionQ1.beginTransaction();
		Query query1 = sessionQ1.createQuery("from Allien_cache where aId=13");
		query1.setCacheable(true);
		
		allien =(Allien) query1.uniqueResult();
		System.out.println(allien);
		sessionQ1.getTransaction().commit();
		sessionQ1.close();
		
		
		
	}
}
