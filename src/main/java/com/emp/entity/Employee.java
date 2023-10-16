package com.emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull()
	@Size(min=4, message = "Your name must be 4 character")
	private String name;
	
	@NotBlank(message = "your address should not blank")
	private String address;
	
	@Size(min = 10, max = 10, message = "Your number should be 10 digits")
	//@Pattern(regexp = "^(\\+?\\d{1,4}[\\s-])?(?!0+\\s+,?$)\\d{10}\\s*,?$\r\n"+ "", message = "Your Number should not follow the Number property")
	@Column(unique = true)
	private String mob;
	
	@Email(message = "Email Format not valid")
	@Column(unique = true)
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	
	
	
	public Employee(Long id, @NotNull @Size(min = 4, message = "Your name must be 4 character") String name,
			@NotBlank(message = "your address should not blank") String address,
			@Size(min = 10, max = 10, message = "Your number should be 10 digits") String mob,
			@Email(message = "Email Format not valid") String email) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mob = mob;
		this.email = email;
	}
	public Employee() {
		super();
	}
	
	
}
