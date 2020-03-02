package com.pankaj.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.demo.model.Employee;
import com.pankaj.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
}
