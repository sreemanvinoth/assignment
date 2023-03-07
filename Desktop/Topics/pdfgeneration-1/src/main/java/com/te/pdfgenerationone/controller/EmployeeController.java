package com.te.pdfgenerationone.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.te.pdfgenerationone.response.SuccessResponse;
import com.te.pdfgenerationone.service.EmployeeService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/getDetails", produces = "application/pdf")
	public ResponseEntity<SuccessResponse> getEmpPdf(HttpServletResponse response) {
		response.setContentType("application/pdf");
//		List<Employee> employees = employeeService.getEmployees();

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=pdf_emp.pdf";

		response.setHeader(headerKey, headerValue);

		Document exportEmpl = employeeService.exportEmpl(response);

		if (exportEmpl.isOpen()) {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(exportEmpl).message(headerValue).build(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessResponse>(
					SuccessResponse.builder().data(exportEmpl).message(headerValue).build(),
					HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/pdf/generate")
	public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");

		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";

		response.setHeader(headerKey, headerValue);

		employeeService.export(response);
	}
}
