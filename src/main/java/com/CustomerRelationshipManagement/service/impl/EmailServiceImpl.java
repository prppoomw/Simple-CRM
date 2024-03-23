package com.CustomerRelationshipManagement.service.impl;

import java.io.File;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.CustomerRelationshipManagement.service.EmailService;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService{
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private TemplateEngine templateEngine;
	

	public EmailServiceImpl(JavaMailSender mailSender, TemplateEngine templateEngine) {
		super();
		this.mailSender = mailSender;
		this.templateEngine = templateEngine;
	}


	@Override
	public void sendMail(String email, String firstName, String lastName) {
		try {
			Context context = new Context();
			context.setVariable("name", "Hi " + firstName + " " + lastName);
			context.setVariable("date", LocalDate.now());
			
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setSubject("Test Mail Service");
            message.setTo(email);
            
            FileSystemResource file = new FileSystemResource(new File("C:\\mailpic.png"));
            message.addAttachment(file.getFilename(), file);
            
            String content = templateEngine.process("mail-to-send.html", context);
            
            message.setText(content, true);
            mailSender.send(mimeMessage);
		}catch (Exception e) {
			System.out.printf("Error: " + e +"\n");
        }
	}
	
	
}
