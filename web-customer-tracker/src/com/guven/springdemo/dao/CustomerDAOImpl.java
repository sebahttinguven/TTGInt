package com.guven.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.guven.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional//transaction open-close and commit auto
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the result
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		
		Customer customer=currentSession.get(Customer.class,theId);
		
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {

Session currentSession=sessionFactory.getCurrentSession();
Query theQuery=currentSession.createQuery("delete from Customer where id=:customerId");
theQuery.setParameter("customerId", theId);

theQuery.executeUpdate();
	}

	@Override
	@Transactional
	public List<Customer> searchCustomerd(String theSearchName) {

Session currentSession=sessionFactory.getCurrentSession();
Query<Customer> theQuery=null;
if (theSearchName != null && theSearchName.trim().length() > 0) {
theQuery=currentSession.createQuery("from Customer where lower(firstName) like:theSearchName or lower(lastName) like:theSearchName", Customer.class);
	
theQuery.setParameter("theSearchName","%"+ theSearchName.toLowerCase()+"%");
}
else{
    theQuery =currentSession.createQuery("from Customer", Customer.class);  
}

List<Customer> customers=theQuery.getResultList();
		return customers;
	}

}
