package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Course;
import com.guven.hibernate.demo.entity.Instructor;
import com.guven.hibernate.demo.entity.InstructorDetail;
import com.guven.hibernate.demo.entity.Review;
import com.guven.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			session.beginTransaction();
			Course tempCourse= new Course("Pacman How To Score One Million");

			System.out.println("\nSaving the course...");
			session.save(tempCourse);
			System.out.println("Saved the course...");
			
			Student tempStudent1 = new Student("Hallly", "delly", "ass@a.com");
			Student tempStudent2 = new Student("John", "dep", "dep@a.com");
			Student tempStudent3 = new Student("Marry", "public", "marry@a.com");
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			tempCourse.addStudent(tempStudent3);
			
			System.out.println("\nSaving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			System.out.println("Saved the students...");
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
