package com.realtor.automobiles;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realtor.automobile.Automobile;

public interface AutomobileDao extends JpaRepository<Automobile, Integer>{

}
