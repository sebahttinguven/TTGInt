package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		//Create SessionFactory
SessionFactory factory=new Configuration()
					        .configure("hibernate.cfg.xml")
					        .addAnnotatedClass(Student.class)
					        .buildSessionFactory();

//create session
Session session=factory.getCurrentSession();

try {
	Student tempStuden= new Student("Paul","Wall","aa@a.com");
	
	session.beginTransaction();

	session.save(tempStuden);
	
	session.getTransaction().commit();
	System.out.println("KAyıt işlemi başarılı");
	
} finally {
	factory.close();	
}

	}

}
