package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		//Create SessionFactory
SessionFactory factory=new Configuration()
					        .configure("hibernate.cfg.xml")
					        .addAnnotatedClass(Student.class)
					        .buildSessionFactory();

//create session
Session session=factory.getCurrentSession();

try {
	Student tempStuden= new Student("Daffy","Duck","cc@a.com");
	
	session.beginTransaction();

	session.save(tempStuden);
	
	session.getTransaction().commit();
	
	// find out the student's id:primary key
	System.out.println("SAved Student generated id:"+ tempStuden.getId());
	
	// now get a new session and start tarnsaction
	session=factory.getCurrentSession();
	session.beginTransaction();
	
	//retrieve student based on the id: primary key
	Student getStudent= session.get(Student.class,tempStuden.getId());
	//commit the transaction
	session.getTransaction().commit();
	System.out.println("Kayıt işlemi başarılı"+getStudent);
	
} finally {
	factory.close();	
}

	}

}
