package com.student.management.service;

import java.util.List;

import com.student.management.entity.Student;

public interface StudentService {

	public List<Student> getAllStudent();

	public Student createStudent(Student student);

}
