package com.ocs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Admin {
	@Id
	private int adminId;
	private String email;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Admin(int adminId, String email) {
		super();
		this.adminId = adminId;
		this.email = email;
	}
}
