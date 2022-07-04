package com.sparity.api.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	private Integer id;
	private String userName;
	private String address;
	private String email;

	public Employee() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", userName=" + userName + ", address=" + address + ", email=" + email + "]";
	}

	public Employee(Integer id, String userName, String address, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.address = address;
		this.email = email;
	}

}
