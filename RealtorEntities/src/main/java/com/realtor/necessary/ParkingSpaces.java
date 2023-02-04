package com.realtor.necessary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class ParkingSpaces {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private int parkingNo;
private String status;
public int getParkingNo() {
	return parkingNo;
}
public void setParkingNo(int parkingNo) {
	this.parkingNo = parkingNo;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getId() {
	return id;
}

}
