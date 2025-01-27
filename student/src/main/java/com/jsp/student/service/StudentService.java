package com.jsp.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.student.dao.StudentDao;
import com.jsp.student.entity.Student;
import com.jsp.student.exception.IdNotFoundException;
import com.jsp.student.util.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;
	
//	to save student
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student){
		
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		responseStructure.setData(dao.saveStudent(student));
		responseStructure.setMessage("Student saved");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Student>>(HttpStatus.CREATED);
	}
	
//	to getStudent
	public ResponseEntity<ResponseStructure<Student>> getStudentById(int id){
		ResponseStructure<Student> rs = new ResponseStructure<Student>();
		Student s= dao.getStudentById(id);
		if(s!=null) {
			rs.setData(s);
			rs.setMessage("Success");
			rs.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Student>>(rs,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Id not found "+id);
		}
	}
	
//	delete student
	public ResponseEntity<ResponseStructure<Student>> deleteStudentById(int id){
		ResponseStructure<Student> rs= new ResponseStructure<Student>();
		Student s= dao.getStudentById(id);
		dao.deleteStudent(id);
		rs.setData(s);
		rs.setMessage("Record Deleted");
		rs.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Student>>(rs,HttpStatus.OK);
	}
	
//	Update Student
	public ResponseEntity<ResponseStructure<Student>> updateStudentById(int id){
		ResponseStructure<Student> rs= new ResponseStructure<Student>();
		Student s= dao.getStudentById(id);
				
		rs.setData(dao.updateStudent(id,s));
		rs.setMessage("Student Record updated");
		rs.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Student>>(rs, HttpStatus.OK);
				
	}
	
}
