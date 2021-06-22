package com.student.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.entity.Student;
import com.student.management.exceptions.ResourceNotFoundException;
import com.student.management.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}


	
		
	}


