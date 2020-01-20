package com.guven.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//Create SessionFactory
SessionFactory factory=new Configuration()
					        .configure("hibernate.cfg.xml")
					        .addAnnotatedClass(Student.class)
					        .buildSessionFactory();

//create session
Session session=factory.getCurrentSession();

try {
	
	//start a tarnsaction
	session.beginTransaction();
	
	//query Students
	List<Student> theStudent=session.createQuery("from Student").list();

	//display the students
	
	displayStudents(theStudent);
	
	
//query students last name=doe
	
	theStudent=session.createQuery("from Student s where s.lastName='Doe'").list();
	
	displayStudents(theStudent);
	
	theStudent=session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").list();
	displayStudents(theStudent);
	//Commit Transaction
	session.getTransaction().commit();
	
} finally {
	factory.close();	
}

	}

	private static void displayStudents(List<Student> theStudent) {
		for (Student tempStudent : theStudent) {
			
			System.out.println(tempStudent);

		}
	}

}
