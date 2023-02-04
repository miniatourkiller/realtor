package com.realtor.charges;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Charges {
	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private Date date;
private int houseNo;
private int cleaningCharges;
private int garbageCharges;
private int electricalCharges;
private int plumbingCharges;
private int otherCharges;
private String othersDesc;
private int chargesTotal;
private String status;
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getHouseNo() {
	return houseNo;
}
public void setHouseNo(int houseNo) {
	this.houseNo = houseNo;
}
public int getCleaningCharges() {
	return cleaningCharges;
}
public void setCleaningCharges(int cleaningCharges) {
	this.cleaningCharges = cleaningCharges;
}
public int getGarbageCharges() {
	return garbageCharges;
}
public void setGarbageCharges(int garbageCharges) {
	this.garbageCharges = garbageCharges;
}
public int getElectricalCharges() {
	return electricalCharges;
}
public void setElectricalCharges(int electricalCharges) {
	this.electricalCharges = electricalCharges;
}
public int getPlumbingCharges() {
	return plumbingCharges;
}
public void setPlumbingCharges(int plumbingCharges) {
	this.plumbingCharges = plumbingCharges;
}
public int getOtherCharges() {
	return otherCharges;
}
public void setOtherCharges(int otherCharges) {
	this.otherCharges = otherCharges;
}
public String getOthersDesc() {
	return othersDesc;
}
public void setOthersDesc(String othersDesc) {
	this.othersDesc = othersDesc;
}
public int getChargesTotal() {
	return chargesTotal;
}
public void setChargesTotal(int chargesTotal) {
	this.chargesTotal = chargesTotal;
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
