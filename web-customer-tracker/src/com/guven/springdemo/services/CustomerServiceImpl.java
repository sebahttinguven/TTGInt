package com.guven.springdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guven.springdemo.dao.CustomerDAO;
import com.guven.springdemo.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		return customerDao.getCustomers();
	}

}