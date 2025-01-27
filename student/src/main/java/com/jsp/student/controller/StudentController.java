package com.jsp.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.student.dao.StudentDao;
import com.jsp.student.entity.Student;
import com.jsp.student.service.StudentService;
import com.jsp.student.util.ResponseStructure;

@RestController
public class StudentController {

	
	@Autowired
	private StudentService service;
	
	@GetMapping("/hello")
	public void print() {
		System.out.println("hi Everyone");
	}
	
	@GetMapping("/hi")
	public String printhHi() {
		return "Hello Neel Avinash";
	}
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student stud) {
//		return dao.saveStudent(stud);
		return service.saveStudent(stud);
	}
	
	@GetMapping("/get")
	public ResponseEntity<ResponseStructure<Student>> getStudentByid(@RequestParam("id")int id){
		return service.getStudentById(id);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseStructure<Student>> getStudent(@PathVariable int id) {
		return service.getStudentById(id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@RequestParam("id")int id) {
		return service.deleteStudentById(id);
	}
	
	@PutMapping("/student")
		public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestParam("id") int id) {
			return service.updateStudentById(id);
		}
	
	
}
