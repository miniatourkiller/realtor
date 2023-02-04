package com.realtor.complaints;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class ComplaintsRegards {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
	private String residentName;
	private int residentId;
	private String residentEmail;
	private String complaintRegard;
	public String getResidentName() {
		return residentName;
	}
	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}
	public int getResidentId() {
		return residentId;
	}
	public void setResidentId(int residentId) {
		this.residentId = residentId;
	}
	public String getResidentEmail() {
		return residentEmail;
	}
	public void setResidentEmail(String residentEmail) {
		this.residentEmail = residentEmail;
	}
	public String getComplaintRegard() {
		return complaintRegard;
	}
	public void setComplaintRegard(String complaintRegard) {
		this.complaintRegard = complaintRegard;
	}
	public int getId() {
		return id;
	}
}
