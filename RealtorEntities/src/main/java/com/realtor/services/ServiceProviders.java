package com.realtor.services;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class ServiceProviders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String email;
private String password;
private String serverName;
private String serviceProvided;
private String contact;
private String profilePath;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getServerName() {
	return serverName;
}
public void setServerName(String serverName) {
	this.serverName = serverName;
}
public String getServiceProvided() {
	return serviceProvided;
}
public void setServiceProvided(String serviceProvided) {
	this.serviceProvided = serviceProvided;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public int getId() {
	return id;
}
public String getProfilePath() {
	return profilePath;
}
public void setProfilePath(String profilePath) {
	this.profilePath = profilePath;
}


}
