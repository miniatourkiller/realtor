package com.realtor.parking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class Parking {
	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private int residentId;
private String residentName;
private String residentVehicle;
private int parkingNo;
private String Status;
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
public String getResidentVehicle() {
	return residentVehicle;
}
public void setResidentVehicle(String residentVehicle) {
	this.residentVehicle = residentVehicle;
}
public int getParkingNo() {
	return parkingNo;
}
public void setParkingNo(int parkingNo) {
	this.parkingNo = parkingNo;
}

public int getId() {
	return id;
}

public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
@Override
public String toString() {
	return "Parking [id=" + id + ", residentId=" + residentId + ", residentName=" + residentName + ", residentVehicle="
			+ residentVehicle + ", parkingNo=" + parkingNo + ", Status=" + Status + "]";
}
}
