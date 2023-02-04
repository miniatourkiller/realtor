package com.realtor.automobile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Automobile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
	private int residentId;
	private String residentName;
	private String plateNo;
	private String details;
	public int getResidentId() {
		return residentId;
	}
	public void setResidentId(int residentId) {
		this.residentId = residentId;
	}
	public String getResidentName() {
		return residentName;
	}
	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}
	public String getPlateNo() {
		return plateNo;
	}
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public int getId() {
		return id;
	}
}
