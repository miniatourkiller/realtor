package com.realtor.chrages;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realtor.charges.Charges;

public interface ChargesDao extends JpaRepository<Charges, Integer>{

}
