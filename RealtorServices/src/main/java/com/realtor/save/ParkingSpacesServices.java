package com.realtor.save;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realtor.login.SessionUtil;
import com.realtor.necessary.ParkingSpaces;
import com.realtor.parking.ParkingRepo;

@Service
public class ParkingSpacesServices {
@Autowired
ParkingRepo parkingRepo;
@Autowired
SessionUtil sessionUtil;

public String addSpot(ParkingSpaces ps, HttpSession session) {
	if(session == null) {
		return "login";
	}
	if(sessionUtil.getArr(session)[1].equals("admin")||sessionUtil.getArr(session)[1].equals("security")) {
		if(parkingRepo.existense(ps.getParkingNo())) {
			return "exists";
		}else {
			parkingRepo.Save(ps);
			return "done";
		}
	}
	return "unauthorized";
}

public String updateSpot(ParkingSpaces ps, HttpSession session) {
	if(session == null) {
		return "login";
	}
	if(sessionUtil.getArr(session)[1].equals("admin")||sessionUtil.getArr(session)[1].equals("security")) {
		if(!parkingRepo.existense(ps.getParkingNo())) {
			return "inexistant";
		}else {
			parkingRepo.Save(ps);
			return "done";
		}
	}
	return "unauthorized";
}
}
