package com.task.alchemy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.alchemy.entity.Employee;
import com.task.alchemy.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findaAall();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee employee = employeeService.findbyId(id);
		if(employee == null) {
			throw new RuntimeException("Employee with id: " + id + " was not found.");
		}
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee newEmployee) {
		newEmployee.setId(0);
		employeeService.add(newEmployee);
		return newEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmploye(@RequestBody Employee employee) {
		employeeService.add(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		Employee employee = employeeService.findbyId(id);
		if(employee == null) {
			throw new RuntimeException("Employee with id: " + id + " could not be deleted");
		}
		employeeService.deleteById(id);
		return "Employee deleted \nid: "
			+ employee.getId() + "\nname: " + employee.getFirstName() + " " + employee.getLastName(); 
	}
	
}