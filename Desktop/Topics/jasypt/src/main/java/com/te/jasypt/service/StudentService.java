package com.te.jasypt.service;

import java.util.List;

import com.te.jasypt.entity.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> displayAll();

}
