package com.guven.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.guven.springdemo.dao.CustomerDAO;
import com.guven.springdemo.entity.Customer;
import com.guven.springdemo.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject the customer Service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {

		// get customer from CustomerSeervice
		List<Customer> theCustomers = customerService.getCustomers();

		// Add customer to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showForAdd(Model theModel){
		//create model attribute to bind form data
		Customer theCustomer= new Customer();
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		
		customerService.saveCustomer(theCustomer);
		
		return"redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
			Model theModel){
		
		Customer theCustomer=customerService.getCustomer(theId);
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId){
		
		customerService.deleteCustomer(theId);	
		
		return"redirect:/customer/list";
		
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("theSearchName") String theSearchName, Model model){
		
		List<Customer> customers=customerService.searchCustomers(theSearchName);
		model.addAttribute("customers",customers);
		
		return "list-customers";
	}
	
}
