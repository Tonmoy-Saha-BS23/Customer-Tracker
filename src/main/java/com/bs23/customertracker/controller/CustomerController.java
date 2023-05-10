package com.bs23.customertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bs23.customertracker.dao.CustomerDao;
import com.bs23.customertracker.entity.Customer;
import com.bs23.customertracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject customer service
	@Autowired
	private CustomerService customerService;
	@GetMapping("/list")
	public String listCustomer(Model model) {
		
		List<Customer> customer = customerService.getCustomers();
		
		
		model.addAttribute("customer",customer);
		
		return "list-customers";
	}
	
	@GetMapping("/CustomerForm")
	public String CustomerForm(Model theModel) {
		Customer customer = new Customer();
		
		theModel.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateForm")
	public String updateForm(@ModelAttribute("customerId") int Id, 
							Model theModel) {
		// getting the customer
		Customer theCustomer = customerService.getCustomer(Id);
		
		// binding the customer with the model
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@ModelAttribute("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
}
