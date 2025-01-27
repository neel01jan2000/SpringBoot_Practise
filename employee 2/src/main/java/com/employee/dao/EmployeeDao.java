package com.employee.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.entity.Employee;
import com.employee.repo.EmployeeRepo;

@Component
public class EmployeeDao {

	@Autowired
	private EmployeeRepo repo;
	
//	save employee
	public Employee saveEmployee(Employee emp) {
		return repo.save(emp);
	}
	
//	find Employee by id
	public Employee getEmployeeById(int id) {
		Optional<Employee> op = repo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
	}
	
//	delete Employee
	public void deleteEmployee(int id) {
		repo.delete(getEmployeeById(id));
	}
	
//	update Employee
	
	public Employee updateEmployee(int id,Employee updateEmp) {
		Optional<Employee> op = repo.findById(id);
		if(op.isPresent()) {
			updateEmp.setId(id);
			return repo.save(updateEmp);
		}
		else {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
