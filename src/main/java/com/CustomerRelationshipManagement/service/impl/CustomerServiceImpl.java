package com.CustomerRelationshipManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.repository.CustomerRepository;
import com.CustomerRelationshipManagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAllCustomer() {
		return customerRepository.findAll();
	}

}
