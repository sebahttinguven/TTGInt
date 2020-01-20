package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		//Create SessionFactory
SessionFactory factory=new Configuration()
					        .configure("hibernate.cfg.xml")
					        .addAnnotatedClass(Student.class)
					        .buildSessionFactory();

//create session
Session session=factory.getCurrentSession();

try {
int studentId=1;
	
	// now get a new session and start tarnsaction
	session=factory.getCurrentSession();
	session.beginTransaction();
	
	//retrieve student based on the id: primary key
	Student myStudent= session.get(Student.class,studentId);
	myStudent.setFirstName("hattin");
	
	//commit the transaction
	session.getTransaction().commit();
	
	session=factory.getCurrentSession();
	session.beginTransaction();
	
	//update email for all students
	System.out.println("Updating email for all students");
	session.createQuery("update Student s set  s.email='foo@gmail.com'").executeUpdate();
	
	session.getTransaction().commit();
	
	System.out.println("Kayıt işlemi başarılı"+myStudent);
	
} finally {
	factory.close();	
}

	}

}
