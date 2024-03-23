package com.CustomerRelationshipManagement.service;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.entity.Customer;

@Service
public interface ProducerService {
	void sendMessage(String topic, Customer customer);
}
