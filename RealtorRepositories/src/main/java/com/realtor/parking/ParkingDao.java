package com.realtor.parking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParkingDao extends JpaRepository<Parking, Integer>{
@Query("FROM Parking WHERE parkingNo = ?1")
Parking findByParkingNo(int ParkingNo);

@Query("FROM Parking p WHERE p.residentName = ?1")
List<Parking> findByName(String name);
}
