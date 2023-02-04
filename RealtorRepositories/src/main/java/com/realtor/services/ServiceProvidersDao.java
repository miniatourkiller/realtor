package com.realtor.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ServiceProvidersDao extends JpaRepository<ServiceProviders, Integer>{
@Query("FROM ServiceProviders sp WHERE sp.email = ?1")
public ServiceProviders checkByEmail(String email);
}
