package com.java.csc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.csc.entity.Employee;
import com.java.csc.exception.ResourceNotFoundException;
import com.java.csc.repository.EmployeeRepository;
import com.java.csc.service.EmployeeService;

//implement method
@Service
public class EmployeeServiceImpl implements EmployeeService
{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository)
	{
		super();
		this.employeeRepository = employeeRepository;
	}




	@Override
	public Employee saveEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}




	@Override
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}




	@Override
	public Employee getEmployeeById(long id) 
	{
		// TODO Auto-generated method stub
		Optional<Employee> employee=employeeRepository.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}else
		{
			throw new ResourceNotFoundException("Employee","Id",id);
		}
	}




	@Override
	public Employee updateEmployee(Employee employee, long id) 
	{
		// we need to check whether employee with given id is exist in Database or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//save existing employee database
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	
	}




	@Override
	public void deleteEmployee(long id) 
	{
		//check whether employee exist or not
		employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
		
	   employeeRepository.deleteById(id);
		
	}
	

}
