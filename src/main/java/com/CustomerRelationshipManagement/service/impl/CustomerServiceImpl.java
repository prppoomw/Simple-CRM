package com.CustomerRelationshipManagement.service.impl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public Customer findCustomerById(Integer id) {
		Optional<Customer> customer = customerRepository.findById(id);
		Customer temp = null;
		if(customer.isPresent()) {
			temp = customer.get();
		}
		else {
			throw new RuntimeException("Customer not found");
		}
		return temp;
	}

	@Override
	public void deleteById(Integer id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow();
			customerRepository.deleteById(id);
	}

}
