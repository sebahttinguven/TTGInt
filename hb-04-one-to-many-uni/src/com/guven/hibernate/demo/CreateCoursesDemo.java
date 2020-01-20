package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Course;
import com.guven.hibernate.demo.entity.Instructor;
import com.guven.hibernate.demo.entity.InstructorDetail;
import com.guven.hibernate.demo.entity.Review;
import com.guven.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		//Create SessionFactory
SessionFactory factory=new Configuration()
					        .configure("hibernate.cfg.xml")
					        .addAnnotatedClass(Instructor.class)
					        .addAnnotatedClass(InstructorDetail.class)
					        .addAnnotatedClass(Course.class)
					        .addAnnotatedClass(Review.class)
					        .buildSessionFactory();

//create session
Session session=factory.getCurrentSession();

try {
	//Create the Object
	
	session.beginTransaction();
//get instructor from db
	
	int theId=1;
	
	Instructor tempInstructor= session.get(Instructor.class, theId);
  //create some courses
	Course tempCourse1=new Course("Air Guitar");
	Course tempCourse2=new Course("The pinball Masterclass");
	
	//add courses to Instructor
	tempInstructor.add(tempCourse1);
	tempInstructor.add(tempCourse2);
	
	session.save(tempCourse1);
	session.save(tempCourse2);
	
	session.getTransaction().commit();
	System.out.println("Kayıt işlemi başarılı");
	
} finally {
	session.close();
	factory.close();	
}

	}

}
