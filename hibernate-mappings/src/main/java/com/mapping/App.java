package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.mapping.model.Laptop;
import com.mapping.model.Student;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		/**
		 * Case 1: Below are the commented code for OneToOne Mapping Laptop
		 * laptop = new Laptop(); laptop.setlId(8989); laptop.setlName("DELL -
		 * Inspironi5");
		 * 
		 * Student ram = new Student(); ram.setsId(011); ram.setsName("DELL");
		 * ram.setLaptop(laptop); Configuration configuration = new
		 * Configuration().configure().addAnnotatedClass(Laptop.class)
		 * .addAnnotatedClass(Student.class);
		 * 
		 * ServiceRegistry serviceRegistry = new
		 * ServiceRegistryBuilder().applySettings(configuration.getProperties())
		 * .buildServiceRegistry(); SessionFactory sessionFactory =
		 * configuration.buildSessionFactory(serviceRegistry); Session session =
		 * sessionFactory.openSession(); Transaction transaction =
		 * session.beginTransaction();
		 * 
		 * session.save(ram); session.save(laptop); transaction.commit();
		 */
		// CASE 2:

		
		/* * Laptop laptop = new Laptop();
		 * laptop.setlId(15);
		 * laptop.setlName("DELL xs");
		 * 
		 * Student student = new Student(); student.setsId(34);
		 * student.setsName("R K"); student.getLaptop().add(laptop);
		 * laptop.setStudent(student);
		 * 
		 * Configuration configuration = new
		 * Configuration().configure().addAnnotatedClass(Laptop.class)
		 * .addAnnotatedClass(Student.class);
		 * 
		 * ServiceRegistry serviceRegistry = new
		 * ServiceRegistryBuilder().applySettings(configuration.getProperties())
		 * .buildServiceRegistry(); SessionFactory sessionFactory =
		 * configuration.buildSessionFactory(serviceRegistry); Session session =
		 * sessionFactory.openSession(); Transaction transaction =
		 * session.beginTransaction();
		 * 
		 * session.save(student); session.save(laptop); transaction.commit();
		 * 
		*/ 
		
		  Laptop laptop = new Laptop();
		  laptop.setlId(15);
		  laptop.setlName("DELL xs");
		  
		  Student student = new Student(); 
		  student.setsId(34);
		  student.setsName("R K");
		  student.getLaptop().add(laptop);
		  laptop.getStudent().add(student);
		  
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(Student.class);

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(student);
		session.save(laptop);
		transaction.commit();
	}
}
