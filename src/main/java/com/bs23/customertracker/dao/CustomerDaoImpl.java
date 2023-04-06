package com.bs23.customertracker.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bs23.customertracker.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// get the current session
		Session currSession = sessionFactory.getCurrentSession();
		
		// getting the customer
		Query<Customer> theQuery = 
				currSession.createQuery("from customer", Customer.class);
		
		// execute query and get the result list
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
		
		
	}

}
