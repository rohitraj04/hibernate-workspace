package com.hibernate.hql;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.hql.model.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure()

				.addAnnotatedClass(Student.class);

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session sessionQ = sessionFactory.openSession();
        sessionQ.beginTransaction();
		Random random = new Random();
//		 for(int i= 0;i<=50; i++){
//		Student student = new Student();
//		student.setsId(i);
//		student.setsName("Name" + i);
//		student.setsMarks(random.nextInt(100));
//		sessionQ.save(student);
//		 }
//        
		Query query = sessionQ.createQuery("from Student where smarks<50");
		Query query1 = sessionQ.createQuery("from Student where sId=7");
		
		Query qry= sessionQ.createQuery("from Student where smarks>40");
		
		//Object[] lst=qry.list();
		
		List<Student> studentList= query.list();
		Student stu= (Student)query1.uniqueResult();
        System.out.println("Unque: " +stu);
		for(Student students : studentList){
			
			System.out.println(students);
		}
//		
		sessionQ.getTransaction().commit();
		sessionQ.close();

		// Query query = sessionQ.createQuery("from Allien_cache where aId=13");
		// query.setCacheable(true);
	}
}
