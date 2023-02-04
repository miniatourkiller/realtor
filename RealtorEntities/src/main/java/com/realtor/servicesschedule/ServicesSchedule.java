package com.realtor.servicesschedule;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class ServicesSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private Date date;
private String cleaningServices;
private String garbageServices;
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getCleaningServices() {
	return cleaningServices;
}
public void setCleaningServices(String cleaningServices) {
	this.cleaningServices = cleaningServices;
}
public String getGarbageServices() {
	return garbageServices;
}
public void setGarbageServices(String garbageServices) {
	this.garbageServices = garbageServices;
}
public int getId() {
	return id;
}

}
