package com.realtor.services;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Services {
	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String serviceName;

public String getServiceName() {
	return serviceName;
}
public void setServiceName(String serviceName) {
	this.serviceName = serviceName;
}
}
