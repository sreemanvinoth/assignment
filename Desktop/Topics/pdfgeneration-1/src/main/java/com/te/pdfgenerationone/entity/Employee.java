package com.te.pdfgenerationone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "details")
public class Employee {

	@Id
	private Integer employeeId;

	private String employeeName;

	private String password;

	private Integer age;

}
