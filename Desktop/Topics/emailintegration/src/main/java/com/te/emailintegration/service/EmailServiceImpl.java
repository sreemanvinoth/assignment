package com.te.emailintegration.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.te.emailintegration.controller.EmailContent;

import jakarta.mail.Address;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public EmailContent sendMail(EmailContent content) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("shrimanvinoth@gmail.com");
		mailMessage.setTo(content.getToEmail());
		mailMessage.setText(content.getBody());
		mailMessage.setSubject(content.getSubject());

		mailSender.send(mailMessage);

		return content;
	}

	@Override
	public Boolean sendFile(EmailContent content) throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setSubject(content.getSubject());
		helper.setFrom("shrimanvinoth@gmail.com");
		helper.setTo(content.getToEmail());

		helper.setText(content.getBody());

		FileSystemResource resource = new FileSystemResource(new File("./src/main/webapp/images/3D Hd Watch man wallpaper.png"));

		helper.addAttachment("Image001", resource);
		if (message != null) {
			mailSender.send(message);
			return true;
		} else {
			return false;
		}

	}


}
