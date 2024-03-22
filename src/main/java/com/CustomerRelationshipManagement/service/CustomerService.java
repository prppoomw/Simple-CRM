package com.CustomerRelationshipManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.entity.Customer;

@Service
public interface CustomerService {

	List<Customer> findAllCustomer();

	void save(Customer customer);

	Customer findCustomerById(Integer id);

	void deleteById(Integer id);
	
}
