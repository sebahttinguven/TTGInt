package com.guven.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.guven.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
	
	//delete the student
	System.out.println("Deleting Student" +myStudent);
	//session.delete(myStudent);
	
	//delete student with query
	session.createQuery("Delete from Student where id=2").executeUpdate();
	
	//commit the transaction
	session.getTransaction().commit();
	
	
	
	System.out.println("Kayıt işlemi başarılı"+myStudent);
	
} finally {
	factory.close();	
}

	}

}
