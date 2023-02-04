package com.realtor.residents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.realtor.resident.Resident;

public interface ResidentsDao extends JpaRepository<Resident , Integer>{
@Query("FROM Resident r WHERE r.email = ?1")
public Resident findByEmail(String email);
}