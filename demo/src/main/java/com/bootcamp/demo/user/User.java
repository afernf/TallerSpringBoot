package com.bootcamp.demo.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	@NotNull(message = "El nombre de usuario es obligatorio")
	private String name;
	
	@Column(name="birthdate")
	//@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "La fecha de nacimiento de usuario es obligatorio")
	private LocalDate birthDate;
	
	public User() {
		
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
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	

}
