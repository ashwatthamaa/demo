package com.pankaj.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "EMPLOYEE")
@JsonIgnoreProperties
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;

	@Column(name = "NAME")
	private String employeeName;

	@Column(name = "AGE", nullable = true)
	private Integer age;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EMPLOYEE_PORJECT", joinColumns = { @JoinColumn(name = "EMPLOYEE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PROJECT_ID") })
	@JsonBackReference
	private List<Project> projects = new ArrayList<>();
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Address> addresses = new ArrayList<>();

	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String employeeName, Integer age, List<Project> projects,
			List<Address> addresses) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.age = age;
		this.projects = projects;
		this.addresses = addresses;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", age=" + age + ", projects="
				+ projects + ", addresses=" + addresses + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		return true;
	}
	
	
}
