package com.te.emailintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.emailintegration.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/sendMail")
	public String sendEmail(@RequestBody EmailContent content) {
		EmailContent sendMail = emailService.sendMail(content);

		if (sendMail != null) {
			return "Mail Sent Successfully";
		} else {
			return "Mail Sent Successfully";
		}
	}

	@PostMapping("/sendFiles")
	public String sendAttachment(@RequestBody EmailContent content) throws MessagingException {
		Boolean sendFile = emailService.sendFile(content);
		if (sendFile) {
			return "Mail sent";
		} else {
			return "Mail Not sent";
		}

	}
	


}
