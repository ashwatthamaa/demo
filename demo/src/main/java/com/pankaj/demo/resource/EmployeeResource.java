package com.pankaj.demo.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pankaj.demo.model.Employee;
import com.pankaj.demo.service.EmployeeService;

@Controller
@RequestMapping(value = "/")
public class EmployeeResource {
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "employeeV1/employees", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> createEmployee(HttpServletRequest request, @RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
