package com.realtor.resident;

import javax.persistence.*;


@Entity
public class Resident {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	private String name;
	private String email;
	private String vkey;
	private String password;
	private int houseNo;
	private String profilePath;
	private float rentingBills;
	private float serviceBills;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVkey() {
		return vkey;
	}
	public void setVkey(String vkey) {
		this.vkey = vkey;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getProfilePath() {
		return profilePath;
	}
	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}
	public float getRentingBills() {
		return rentingBills;
	}
	public void setRentingBills(int rentingBills) {
		this.rentingBills = rentingBills;
	}
	public float getServiceBills() {
		return serviceBills;
	}
	public void setServiceBills(int serviceBills) {
		this.serviceBills = serviceBills;
	}
	
	public int getId() {
		return id;
	}
}
