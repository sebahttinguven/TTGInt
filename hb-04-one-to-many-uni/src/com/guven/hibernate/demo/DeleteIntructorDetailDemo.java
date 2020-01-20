package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Instructor;
import com.guven.hibernate.demo.entity.InstructorDetail;
import com.guven.hibernate.demo.entity.Student;

public class DeleteIntructorDetailDemo {

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

	session.beginTransaction();

	int theId=2;
	InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class,theId);

	System.out.println("tempInstructorDetail:"+tempInstructorDetail);
	
	System.out.println("associated instructor:"+tempInstructorDetail.getInstructor());
	
	//Delete InsrructorDetail 
	System.out.println("Deleting InsrructorDetail");
	
	session.delete(tempInstructorDetail);
	
	session.getTransaction().commit();
//	System.out.println("Kayıt işlemi başarılı");
	
} 
catch (Exception e) {
	e.printStackTrace();
}

finally {
	session.close();
	factory.close();	
}

	}

}
