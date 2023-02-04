package com.realtor.residents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.realtor.resident.Resident;

@Component
public class ResidentsRepo {
Resident resident  = new Resident();
private ResidentsDao RD;
@Autowired
public void setDao(ResidentsDao RD) {
	this.RD = RD;
}
public String saveResident(Resident R) {
	RD.save(R);
	return "done";
}
public Resident findResidentByEmail(String email) {
	this.resident =  RD.findByEmail(email);
	return resident;
}

}
