package com.example.demojwt.Entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="user")
public class Manager {

	@Id
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	public Manager() {
	}

	public Manager(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
