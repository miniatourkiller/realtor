package com.realtor.save;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realtor.login.SessionUtil;
import com.realtor.resident.Resident;
import com.realtor.residents.ResidentsRepo;

@Service

public class Register {
	@Autowired
	ResidentsRepo Rr;
	@Autowired
	HashPassword hp;
	@Autowired
	SessionUtil sessionUtil;
	@Autowired
	HashPassword hashp;
	
	Resident resident = new Resident();
	public String reg(Resident R, HttpSession session) {
		if(session == null) {
			return "login";
		}
		if(sessionUtil.getArr(session)[1].equals("admin")) {
			resident = Rr.findResidentByEmail(R.getEmail());
			if(resident == null) {
			String pass = R.getPassword();
			R.setPassword(hashp.givePassword(pass));
			return Rr.saveResident(R);	
			}
			return "email exists";
		}
		return "unauthorized";
	}
	
}
