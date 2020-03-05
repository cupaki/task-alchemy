package com.task.alchemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.alchemy.dao.EmployeeDAO;
import com.task.alchemy.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeDAO = employeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findbyId(int id) {
		return employeDAO.findById(id);
	}

	@Override
	@Transactional
	public void add(Employee newEmployee) {
		employeDAO.add(newEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeDAO.deleteById(id);
	}

	@Override
	@Transactional
	public List<Employee> findEmployeesWithSameRole(String role) {
		return employeDAO.findEmployeesWithSameRole(role);
	}
	

}
