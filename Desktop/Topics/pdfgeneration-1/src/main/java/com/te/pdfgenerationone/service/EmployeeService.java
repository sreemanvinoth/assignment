package com.te.pdfgenerationone.service;

import java.io.IOException;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.te.pdfgenerationone.entity.Employee;

import jakarta.servlet.http.HttpServletResponse;

public interface EmployeeService {

	public List<Employee> getEmployees();
	
	public void export(HttpServletResponse response) throws DocumentException, IOException;

	public Document exportEmpl(HttpServletResponse response);
}
