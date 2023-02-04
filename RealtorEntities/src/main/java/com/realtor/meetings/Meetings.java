package com.realtor.meetings;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Meetings {
	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private Date date;
private String subject;
private String venue;
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getVenue() {
	return venue;
}
public void setVenue(String venue) {
	this.venue = venue;
}
public int getId() {
	return id;
}
}
