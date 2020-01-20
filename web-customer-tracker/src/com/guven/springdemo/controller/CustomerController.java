package com.guven.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guven.springdemo.dao.CustomerDAO;
import com.guven.springdemo.entity.Customer;
import com.guven.springdemo.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject the customer DAO
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {

		// get customer from DAO
		List<Customer> theCustomers = customerService.getCustomers();

		// Add customer to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

}
