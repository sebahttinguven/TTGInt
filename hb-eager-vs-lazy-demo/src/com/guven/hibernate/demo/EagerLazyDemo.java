package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Course;
import com.guven.hibernate.demo.entity.Instructor;
import com.guven.hibernate.demo.entity.InstructorDetail;
import com.guven.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// Create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// Create the Object

			session.beginTransaction();
			// get instructor from db

			int theId = 1;

			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("instroctur:" + tempInstructor);

			// get courses for the intructor

			System.out.println("Courses:" + tempInstructor.getCourses());

			session.getTransaction().commit();
			System.out.println("Kayıt işlemi başarılı");

		} finally {
			session.close();
			factory.close();
		}

	}

}
