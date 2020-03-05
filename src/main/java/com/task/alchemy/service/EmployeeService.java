package com.task.alchemy.service;

import java.util.List;

import com.task.alchemy.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findbyId(int id);
	
	public void add(Employee newEmployee);
	
	public void deleteById(int id);
	
	public List<Employee> findEmployeesWithSameRole(String role);
	
}
