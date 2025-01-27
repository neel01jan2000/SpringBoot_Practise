package com.employee.controller;

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

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.util.ResponseStructure;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	

	@GetMapping("/hi")
	public String printhHi() {
		return "Hi SDE Neel Avinash";
	}
	
//	save Employee
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee emp){
		return service.saveEmployee(emp);
	}
	
//	get Employee by id
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseStructure<Employee>> getEmployeeByid(@PathVariable("id") int id){
		return service.getEmployeeById(id);
	}
	
//	delete Employee by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@PathVariable("id") int id){
		return service.deleteEmployeeById(id);
	}
	
//	update Employee by id
	@PutMapping("/employee")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam("id") int id){
		return service.updateEmployeeById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
