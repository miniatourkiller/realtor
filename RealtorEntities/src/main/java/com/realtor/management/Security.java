package com.realtor.management;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Security {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long idNumber;
	private String name;
	private String email;
	private String password; 
	private String profilePath;
	public long getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfilePath() {
		return profilePath;
	}
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

}
