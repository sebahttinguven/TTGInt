package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Instructor;
import com.guven.hibernate.demo.entity.InstructorDetail;
import com.guven.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		//Create SessionFactory
SessionFactory factory=new Configuration()
					        .configure("hibernate.cfg.xml")
					        .addAnnotatedClass(Instructor.class)
					        .addAnnotatedClass(InstructorDetail.class)
					        .buildSessionFactory();

//create session
Session session=factory.getCurrentSession();

try {
	//Create the Object
	Instructor tempInstructor=new Instructor("Madhu","Patel","madhu@gmail.com");
	
	//associate object
	InstructorDetail tempInstructorDetail=new InstructorDetail("yyy@youtube", "Guitar");
	
	tempInstructor.setInstructorDetail(tempInstructorDetail);
	
	session.beginTransaction();

	session.save(tempInstructor);
	
	session.getTransaction().commit();
	System.out.println("Kayıt işlemi başarılı");
	
} finally {
	factory.close();	
}

	}

}
