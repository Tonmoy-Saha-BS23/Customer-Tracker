package com.bs23.customertracker.service;

import java.util.List;

import com.bs23.customertracker.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
