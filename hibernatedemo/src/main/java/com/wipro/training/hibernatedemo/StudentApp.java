package com.wipro.training.hibernatedemo;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//hibernate application to save product object in db
//using annotation configuration

public class StudentApp {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml"); // configures hibernate with DB
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();  // physical connection with db is established

		Transaction t=session.beginTransaction();

		// // object in  transient state i.e not associated
		// with any session
		Student s1=new Student();

		s1.setName("Daman");
		s1.setBranch("IT");
		s1.setMarks(75);

		session.save(s1);  // object in persistent state
		t.commit();
		System.out.println("Student Details successfully Saved to DB");
		session.close();  // object in detached state
		sf.close();

	}

}
