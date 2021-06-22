package com.student.management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.entity.Student;
import com.student.management.exceptions.ResourceNotFoundException;
import com.student.management.repository.StudentRepository;
import com.student.management.service.StudentService;

@RestController
@CrossOrigin(origins = "*") // , allowedHeaders = "*")
@RequestMapping("/ap1/v1")
public class StudentController {

	@Autowired
	StudentService studentService;

	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/students")
	public List<Student> getRecords() {
		return studentService.getAllStudent();
	}

	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	// get employee byID Rest api

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable int  id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student not exist for id :" + id));
		return ResponseEntity.ok(student);
	}
	
	//Public update rest API
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudentBy(@PathVariable int  id ,@RequestBody Student studentDetails){
	    
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student not exist for id :" + id));
		 
		   student.setFirstName(studentDetails.getFirstName()) ;
		   student.setLastName(studentDetails.getLastName());
		   student.setEmail(studentDetails.getEmail());
		   
		   Student updateStudent = studentRepository.save(student);
		   return ResponseEntity.ok(updateStudent);
	}
	
	
	
	//delete Employee rest api
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStudentById(@PathVariable int id){
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student not exist for id :" + id));
		studentRepository.delete(student);
		Map<String ,Boolean> responce = new HashMap<>();
		responce.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(responce);
		
		
	}

}