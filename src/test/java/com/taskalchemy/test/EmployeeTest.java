package com.taskalchemy.test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.task.alchemy.dao.EmployeeDAOimpl;
import com.task.alchemy.entity.Employee;
import com.task.alchemy.service.EmployeeServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeTest {
	
	@Mock
	private EmployeeDAOimpl employeeDAOimpl;
	
	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findAllEmployees( ) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("john", "lundstram", "lordlundi@gmail.com", "defender"));
		employeeList.add(new Employee("pep", "guardiola", "baldfraud@gmail.com", "manager"));
		when(employeeDAOimpl.findAll()).thenReturn(employeeList);
		
		List<Employee> result = employeeServiceImpl.findaAall();
		assertEquals(2, result.size());
	}
	
	@Test
	public void findById() {
		Employee e = new Employee("john", "lundstram", "lordlundi@gmail.com", "defender");
		when(employeeDAOimpl.findById(1)).thenReturn(e);
		Employee eRes = employeeServiceImpl.findbyId(1);
		assertEquals(1, eRes.getId());
		assertEquals("john", eRes.getFirstName());
		
	}
}
