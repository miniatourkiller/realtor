package com.realtor.parking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.realtor.necessary.ParkingSpaces;

public interface ParkingSpacesDao extends JpaRepository<ParkingSpaces, Integer>{
@Query("FROM ParkingSpaces p where p.parkingNo = ?1")
public ParkingSpaces findByParkingNo(int ParkingNo);
}