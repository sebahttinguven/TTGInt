package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creatin 3 students..");
			Student student1= new Student("John","Doe","aa@a.com"); 
			Student student2= new Student("Mary","Public","bb@a.com"); 
			Student student3= new Student("Bonita","Appll","cc@a.com"); 
			
		   session.beginTransaction();
		   
		   session.save(student1);
		   session.save(student2);
		   session.save(student3);
		   
		   session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
