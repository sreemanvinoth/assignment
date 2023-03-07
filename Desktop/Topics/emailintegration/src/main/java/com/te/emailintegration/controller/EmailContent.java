package com.te.emailintegration.controller;

import jakarta.mail.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailContent {
	
	private String subject;
	
	private String body;
	
	private String[] toEmail;
	
	

}
