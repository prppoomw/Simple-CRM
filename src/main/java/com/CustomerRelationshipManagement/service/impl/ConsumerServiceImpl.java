package com.CustomerRelationshipManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.constant.CRMConstant;
import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.repository.CustomerRepository;
import com.CustomerRelationshipManagement.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	@KafkaListener(topics = CRMConstant.TOPIC_NAME, groupId = CRMConstant.GROUP_ID)
	public void consumeMessage(Customer customer) {
		customerRepository.save(customer);
	}

}
