package com.java.csc.service;

import java.util.List;

import com.java.csc.entity.Employee;


//declare method
public interface EmployeeService
{
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee employee, long id);
	
	void deleteEmployee(long id);

}
