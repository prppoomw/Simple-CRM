package com.CustomerRelationshipManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService{
	@Autowired
    private KafkaTemplate<String, Customer> kafkaTemplate;

	@Override
	public void sendMessage(String topic, Customer customer) {
		kafkaTemplate.send(topic, customer);
	}

}
