package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Course;
import com.guven.hibernate.demo.entity.Instructor;
import com.guven.hibernate.demo.entity.InstructorDetail;
import com.guven.hibernate.demo.entity.Student;

public class DeleteCoursesDemo {

	public static void main(String[] args) {

		// Create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			

			session.beginTransaction();
			
			// get a course
			int theId=10;
			
			Course tempCourse= session.get(Course.class,theId);

			System.out.println("Deleting Course"+tempCourse);
			session.delete(tempCourse);
			session.getTransaction().commit();
			System.out.println("Kayıt işlemi başarılı");

		} finally {
			session.close();
			factory.close();
		}

	}

}
