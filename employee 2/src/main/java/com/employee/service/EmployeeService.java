package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
//	save Employee
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee emp) {
		
		ResponseStructure<Employee> rs = new ResponseStructure<Employee>();
		rs.setData(dao.saveEmployee(emp));
		rs.setMessage("Employee saved");
		rs.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Employee>>(HttpStatus.CREATED);
	}
	
//	To get Student
	public ResponseEntity<ResponseStructure<Employee>> getEmployeeById(int id){
		ResponseStructure<Employee> rs = new ResponseStructure<Employee>();
		Employee e = dao.getEmployeeById(id);
		if(e!=null) {
			rs.setData(e);
			rs.setMessage("Sucess");
			rs.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(rs,HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	
//	delete Employee
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(int id){
		ResponseStructure<Employee> rs = new ResponseStructure<Employee>();
		Employee e = dao.getEmployeeById(id);
		dao.deleteEmployee(id);
		rs.setData(e);
		rs.setMessage("Record deleted");
		rs.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Employee>>(rs,HttpStatus.OK);
		
	}
	

//	update Employee
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(int id) {
		ResponseStructure<Employee> rs = new ResponseStructure<Employee>();
		Employee e = dao.getEmployeeById(id);
		rs.setData(dao.updateEmployee(id, e));
		rs.setMessage("Employee Record updated");
		rs.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Employee>>(rs,HttpStatus.OK);
		
	}
	
	

}
