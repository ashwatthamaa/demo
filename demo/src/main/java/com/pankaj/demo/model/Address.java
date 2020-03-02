package com.pankaj.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ADDRESS")
@JsonIgnoreProperties
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
	private Integer addressId;
	
	@Column(name = "ADDRESS_TEXT", nullable = false)
	private String addressText;
	
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	@JsonBackReference
	private Employee employee;

	public Address() {
		super();
	}

	public Address(Integer addressId, String addressText, Employee employee) {
		super();
		this.addressId = addressId;
		this.addressText = addressText;
		this.employee = employee;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressText() {
		return addressText;
	}

	public void setAddressText(String addressText) {
		this.addressText = addressText;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressText == null) ? 0 : addressText.hashCode());
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
		Address other = (Address) obj;
		if (addressText == null) {
			if (other.addressText != null)
				return false;
		} else if (!addressText.equals(other.addressText))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressText=" + addressText + ", employee=" + employee + "]";
	}
}
