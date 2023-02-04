package com.realtor.management;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SecurityDao extends JpaRepository<Security, Integer>{
@Query("FROM Security s WHERE s.email = ?1")
public Security findByEmail(String email);
}
