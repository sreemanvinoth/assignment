package com.te.jasypt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.jasypt.entity.Student;
import com.te.jasypt.response.StudentResponse;
import com.te.jasypt.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/saveStudent")
	public ResponseEntity<StudentResponse> addStudent(@RequestBody Student student) {
		Student saveStudent = studentService.saveStudent(student);

		if (saveStudent != null) {
			return new ResponseEntity<StudentResponse>(
					StudentResponse.builder().data(saveStudent).error(false).msg("added student").build(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentResponse>(
					StudentResponse.builder().data(saveStudent).error(true).msg("added not student").build(),
					HttpStatus.BAD_GATEWAY);
		}
	}

	@GetMapping("/displayAll")
	public ResponseEntity<StudentResponse> viewAll() {
		List<Student> displayAll = studentService.displayAll();
		if (!displayAll.isEmpty()) {
			return new ResponseEntity<StudentResponse>(
					StudentResponse.builder().data(displayAll).error(false).msg("Success").build(), HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentResponse>(
					StudentResponse.builder().data(displayAll).error(true).msg("student not found").build(),
					HttpStatus.BAD_GATEWAY);
		}
	}

}
