package com.guven.springdemo.dao;

import java.util.List;

import com.guven.springdemo.entity.Customer;

public interface CustomerDAO {

	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomerd(String theSearchName);
}
