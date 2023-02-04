package com.realtor.necessary;

import org.springframework.stereotype.Component;
@Component
public class SessionHelper {
	private String residentPassword;
private String residentEmail;

public String getResidentPassword() {
	return residentPassword;
}
public void setResidentPassword(String residentPassword) {
	this.residentPassword = residentPassword;
}
public String getResidentEmail() {
	return residentEmail;
}
public void setResidentEmail(String residentEmail) {
	this.residentEmail = residentEmail;
}

}
