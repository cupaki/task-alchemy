package com.task.alchemy.dao;

import java.util.List;

import com.task.alchemy.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void add(Employee newEmployee);
	
	public void deleteById(int id);
	
	public List<Employee> findEmployeesWithSameRole(String role);
	
	
}
