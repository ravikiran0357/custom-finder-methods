package com.sparity.api.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department_details")
public class Department {
	@Id
	
	@Column(name = "dept_id")
	private Integer id;
	@Column(name = "dept_name")
	private String userName;
	@Column(name = "dept_address")
	private String address;
	@Column(name = "dept_mail")
	private String email;

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
		return "Department [id=" + id + ", userName=" + userName + ", address=" + address + ", email=" + email + "]";
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(Integer id, String userName, String address, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.address = address;
		this.email = email;
	}

}
