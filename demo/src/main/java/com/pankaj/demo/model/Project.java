package com.pankaj.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PROJECT")
@JsonIgnoreProperties
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECT_ID")
	private Integer projectId;
	
	@Column(name = "PROJECT_NAME", nullable = true)
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	@JsonManagedReference
	private List<Employee> employees = new ArrayList<>();

	public Project() {
		super();
	}

	public Project(Integer projectId, String projectName, List<Employee> employees) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.employees = employees;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", employees=" + employees + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
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
		Project other = (Project) obj;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		return true;
	}
	
	
}
