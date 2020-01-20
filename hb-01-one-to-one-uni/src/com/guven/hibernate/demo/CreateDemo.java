package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Instructor;
import com.guven.hibernate.demo.entity.InstructorDetail;
import com.guven.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// Create SessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int theId = 1;
			session.beginTransaction();
			Instructor theInstructor = session.get(Instructor.class, theId);
			
			if (theInstructor != null) {

				session.delete(theInstructor);
			}

			session.getTransaction().commit();
			System.out.println("Silme işlemi başarılı");

		} finally {
			factory.close();
		}

	}

}
