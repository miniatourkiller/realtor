package com.realtor.parking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.realtor.necessary.ParkingSpaces;

@Service
public class ParkingRepo {
	

@Autowired
private ParkingDao Pd;
@Autowired
private ParkingSpacesDao Psd;


private ParkingSpaces Ps = new ParkingSpaces();

//checks if the parking space is there
public boolean existense(int ParkingNo) {
	Ps = Psd.findByParkingNo(ParkingNo);
	if(Ps==null) {
		return false;
	}
	return true;
}

public void setParking(Parking P) {
Pd.save(P);	
}

private Parking P= new Parking();


//checks if the parking is available
public boolean isAvailable(int parkingNo) {
	
this.P = Pd.findByParkingNo(parkingNo);

if(P==null) {
	return true;
}
return false;
}



public void Save(ParkingSpaces Ps) {
	Psd.save(Ps);
}

//checks if a parking is usable
public boolean isActive(int parkingNo) {
	Ps = Psd.findByParkingNo(parkingNo);
	System.out.println(Ps.getStatus());
	if(Ps.getStatus().equals("active")) {
		return true;
	}
	return false;
}

public List<Parking> checkMySpots(String name){
	List<Parking> spots = new ArrayList<Parking>();
	spots = Pd.findByName(name);
	return spots;
}

}
