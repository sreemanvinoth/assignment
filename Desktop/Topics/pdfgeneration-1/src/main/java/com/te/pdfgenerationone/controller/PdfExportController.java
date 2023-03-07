package com.te.pdfgenerationone.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.te.pdfgenerationone.service.EmployeeService;

import jakarta.servlet.http.HttpServletResponse;


public class PdfExportController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/pdf/generate")
	public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=pdf_"+currentDateTime+".pdf";
		
		response.setHeader(headerKey, headerValue);
		
		employeeService.export(response);
	}
	

}
