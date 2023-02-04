package com.realtor.facilities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Facilities {
	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
private String facilityName;
private String status;
private String news;
public String getFacilityName() {
	return facilityName;
}
public void setFacilityName(String facilityName) {
	this.facilityName = facilityName;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getNews() {
	return news;
}
public void setNews(String news) {
	this.news = news;
}
public int getId() {
	return id;
}
}
