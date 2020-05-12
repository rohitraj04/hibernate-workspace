package com.fetch.eager.hibernate_fetch_eager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.fetch.eager.hibernate_fetch_eager.model.Allien;
import com.fetch.eager.hibernate_fetch_eager.model.Laptop;
import com.mysql.cj.xdevapi.Collection;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// Laptop laptop = new Laptop();
		// laptop.setlId(55);
		// laptop.setlName("Lenevo -9xp");
		//
		Allien allien = new Allien();
		// allien.setaId(466);
		// allien.setaName("BaTMan");
		// allien.getLaptop().add(laptop);
		//
		// laptop.setAllien(allien);

		Configuration configuration = new Configuration().configure()
				.addAnnotatedClass(com.fetch.eager.hibernate_fetch_eager.model.Laptop.class)
				.addAnnotatedClass(Allien.class);

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		allien = (Allien) session.get(Allien.class, 76);

		java.util.Collection<Laptop> collection = allien.getLaptop();

		System.out.println("NAME : " + allien.getaName());
		for (Laptop l : collection) {
			System.out.println(l);
		}

		System.out.println(allien);

		// session.save(allien);
		// session.save(laptop);
		transaction.commit();
	}
}
