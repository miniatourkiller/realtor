package com.realtor.save;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realtor.login.SessionUtil;
import com.realtor.parking.Parking;
import com.realtor.parking.ParkingRepo;

@Service
public class ResidentParking {
@Autowired
SessionUtil sessionUtil;
@Autowired
ParkingRepo parkingRepo;
	public String assignParking(Parking p, HttpSession session) {
		if(sessionUtil.check(session).equals("no session set")) {
			return "login";
		}
		if(sessionUtil.getArr(session)[1].equals("admin") ||sessionUtil.getArr(session)[1].equals("security")) {
			if(!parkingRepo.existense(p.getParkingNo())) {
				return "inexistent";
			}else if(!parkingRepo.isActive(p.getParkingNo())) {
				return "inactive";
			}else if(!parkingRepo.isAvailable(p.getParkingNo())) {
				return "unavailable";
			}else {
				parkingRepo.setParking(p);
				return "done";
			}
		}
		return "unauthorized";
	}
	public String updateParking(Parking p, HttpSession session) {
		if(sessionUtil.check(session).equals("no session set")) {
			return "login";
		}
		if(sessionUtil.getArr(session)[1].equals("admin") ||sessionUtil.getArr(session)[1].equals("security")) {
			parkingRepo.setParking(p);
			return "done";
		}
		return "unauthorized";
	}
}
