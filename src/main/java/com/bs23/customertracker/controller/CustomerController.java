package com.bs23.customertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bs23.customertracker.dao.CustomerDao;
import com.bs23.customertracker.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	@RequestMapping("/list")
	public String listCustomer(Model model) {
		
		List<Customer> customer = customerDao.getCustomers();
		
		model.addAttribute("customer",customer);
		
		return "list-customers";
	}
}
