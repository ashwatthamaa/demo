package com.pankaj.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pankaj.demo.model.Address;
import com.pankaj.demo.model.Employee;
import com.pankaj.demo.model.Project;
import com.pankaj.demo.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoApplicationTests {

	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	EmployeeService employeeService;
	
	private MockMvc mvc;
	
	@Before
	public void setMockMvc(){
		this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void saveEmployeeTest() throws JsonProcessingException, Exception {
		Employee employee = new Employee();
		employee.setEmployeeName("EName06026");
		Address address1 = new Address();
		address1.setAddressText("Address106026");
		Address address2 = new Address();
		address2.setAddressText("Address206026");
		Project project1 = new Project();
		project1.setProjectName("Project106026");
		Project project2 = new Project();
		project2.setProjectName("Project206026");
		employee.getProjects().add(project1);
		employee.getProjects().add(project2);
		project1.getEmployees().add(employee);
		project1.getEmployees().add(employee);
		project2.getEmployees().add(employee);
		employee.getAddresses().add(address1);
		employee.getAddresses().add(address2);
		address1.setEmployee(employee);
		address2.setEmployee(employee);
		employeeService.createEmployee(employee);
		ResultActions actions = this.mvc.perform(post("/employeeV1/employees").content(new ObjectMapper().writeValueAsString(employee)));
	}
}
