package com.bs23.customertracker.dao;

import java.util.List;

import com.bs23.customertracker.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
