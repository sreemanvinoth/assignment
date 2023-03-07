package com.te.emailintegration.service;

import com.te.emailintegration.controller.EmailContent;

import jakarta.mail.MessagingException;

public interface EmailService {

	EmailContent sendMail(EmailContent content);

	Boolean sendFile(EmailContent content) throws MessagingException;

	

}
