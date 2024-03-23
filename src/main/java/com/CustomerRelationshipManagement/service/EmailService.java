package com.CustomerRelationshipManagement.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {

	void sendMail(String email, String firstName, String lastName);

}
