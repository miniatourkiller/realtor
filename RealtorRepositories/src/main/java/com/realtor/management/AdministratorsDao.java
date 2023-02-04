package com.realtor.management;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdministratorsDao extends JpaRepository<Administrators, Integer>{

@Query("FROM Administrators a WHERE a.email = ?1")
public Administrators findByEmail(String email);
}
