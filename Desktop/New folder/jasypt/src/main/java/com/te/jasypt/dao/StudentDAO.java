package com.te.jasypt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.jasypt.entity.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {

}
