package com.te.jasypt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.jasypt.dao.StudentDAO;
import com.te.jasypt.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public Student saveStudent(Student student) {

		Student save = studentDAO.save(student);
		
		return save;
	}

	@Override
	public List<Student> displayAll() {

		List<Student> findAll = studentDAO.findAll();
		
		return findAll;
	}

	
	
}
