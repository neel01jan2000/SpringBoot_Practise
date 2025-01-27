package com.jsp.student.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.student.entity.Student;
import com.jsp.student.repo.StudentRepo;

@Component
public class StudentDao {

	@Autowired
	private StudentRepo repo;
	
	public Student saveStudent(Student stud) {
		return repo.save(stud);
	}
//	findById
	public Student getStudentById(int id) {
		Optional<Student> op=repo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
	}
//	delete Student
	public void deleteStudent(int id) {
		repo.delete(getStudentById(id));
	}
	
//	update Student
	public Student updateStudent(int id,Student updateStd) {
		Optional<Student> op=repo.findById(id);
		if(op.isPresent()) {
			updateStd.setId(id);
			return repo.save(updateStd);
		}
		else {
			return null;
		}
	}
	
}
