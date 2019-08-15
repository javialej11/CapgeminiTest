package com.javialej.MyBankBackend.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer") // Mala practica, los nombres de tabla para base de datos son en plural
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 11)
	private Long id;
	
	@NotEmpty
	@Size(min=1, max=100)
	@Column(nullable=false, length = 100)
	private String name;
	
	@NotEmpty
	@Size(min=1, max=100)
	@Column(nullable=false, length = 100)
	private String surname;
	
	@NotEmpty
	@Size(min=1, max=15)
	@Column(name = "customer_id", nullable=false, length = 15)
	private String customerId;
	
	@NotEmpty
	@Email
	@Column(nullable=false, unique=true, length = 50)
	private String email;
	
	@NotEmpty
	@Column(length = 15)
	private String mobile;
	
	@Column(length = 15)
	private String phone;
	
	@NotEmpty
	@Size(min=1, max=100)
	@Column(length = 100)
	private String password;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomer_id(String customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
