package com.java.csc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.csc.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
	

}
