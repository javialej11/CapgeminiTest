package com.javialej.MyBankBackend.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="customer") // Mala practica, los nombres de tabla para base de datos son en plural
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 11)
	@ApiModelProperty(notes = "The database auto-generated customer ID")
	private Long id;
	
	@NotEmpty
	@Size(min=1, max=100)
	@Column(nullable=false, length = 100)
	@ApiModelProperty(notes = "Customer Name")
	private String name;
	
	@NotEmpty
	@Size(min=1, max=100)
	@Column(nullable=false, length = 100)
	@ApiModelProperty(notes = "Customer Surname")
	private String surname;
	
	@NotEmpty
	@Size(min=1, max=15)
	@Column(name = "customer_id", nullable=false, unique=true, length = 15)
	@ApiModelProperty(notes = "customer_id as username for Login Authentication")
	private String customerId;
	
	@NotEmpty
	@Email
	@Column(nullable=false, unique=true, length = 50)
	@ApiModelProperty(notes = "Customer Email")
	private String email;
	
	@NotEmpty
	@Column(length = 15)
	@ApiModelProperty(notes = "Customer Mobile number")
	private String mobile;
	
	@Column(length = 15)
	@ApiModelProperty(notes = "Customer Phone number")
	private String phone;
	
	@NotEmpty
	@Size(min=1, max=100)
	@Column(length = 100)
	@ApiModelProperty(notes = "password for Login Authentication")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name="customer_roles", 
		joinColumns = @JoinColumn(name="customer_id"), 
		inverseJoinColumns = @JoinColumn(name="roles_id"),
		uniqueConstraints = {@UniqueConstraint(columnNames = {"customer_id", "roles_id" })})
	@ApiModelProperty(notes = "roles of Customer for Login Authentication")
	private List<Role> roles;
	
	private Boolean enabled;


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

	public void setCustomerId(String customerId) {
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
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
