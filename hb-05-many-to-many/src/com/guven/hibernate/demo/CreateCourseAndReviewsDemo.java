package com.guven.hibernate.demo;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Course;
import com.guven.hibernate.demo.entity.Instructor;
import com.guven.hibernate.demo.entity.InstructorDetail;
import com.guven.hibernate.demo.entity.Review;
import com.guven.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

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
//Create the Course
	Course tempCourse=new Course("Pacman How To Score");

	//add review to Course
	//Review tempreview1= new Review("Great Course");
	tempCourse.addReview(new Review("Great Course"));
	tempCourse.addReview(new Review("Cool Course"));
	tempCourse.addReview(new Review("What a dump Course"));
	System.out.println("Saving the Course");
	session.save(tempCourse);
	
	System.out.println(tempCourse);
	System.out.println(tempCourse.getReviews());
	session.getTransaction().commit();
	
	System.out.println("Kayıt işlemi başarılı");
	
}catch(Exception e){
	e.printStackTrace();
}


finally {
	session.close();
	factory.close();	
}

	}

}
