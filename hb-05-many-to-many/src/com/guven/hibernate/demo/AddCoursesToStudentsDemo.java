package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Course;
import com.guven.hibernate.demo.entity.Instructor;
import com.guven.hibernate.demo.entity.InstructorDetail;
import com.guven.hibernate.demo.entity.Review;
import com.guven.hibernate.demo.entity.Student;

public class AddCoursesToStudentsDemo {

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
		    Course tempCourse1=new Course("Hibernate");
		    Course tempCourse2=new Course("Jenkins");
		    //Add studebt to courses
		    tempCourse1.addStudent(tempStudent);
		    tempCourse2.addStudent(tempStudent);
		    tempStudent.addCourses(tempCourse1);
		    tempStudent.addCourses(tempCourse2);
		    //saved the Courses
		    System.out.println("Saving the student the Courses");
		    session.save(tempCourse1);
		    session.save(tempCourse2);
		    
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}

	}

}
