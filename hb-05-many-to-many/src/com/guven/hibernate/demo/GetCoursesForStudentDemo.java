package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Course;
import com.guven.hibernate.demo.entity.Instructor;
import com.guven.hibernate.demo.entity.InstructorDetail;
import com.guven.hibernate.demo.entity.Review;
import com.guven.hibernate.demo.entity.Student;

public class GetCoursesForStudentDemo {

	public static void main(String[] args) {

		// Create SessionFactory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			int theId=3;
			session.beginTransaction();
			
			//get Student from database
		    Student tempStudent= session.get(Student.class, theId);
			//Create Courses
		   System.out.println("Courses:"+ tempStudent.getCourses());
	
		    
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}

	}

}
