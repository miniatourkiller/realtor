package com.realtor.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdministratorsRepo {
@Autowired
AdministratorsDao Ad;


 public Administrators findByEmail(String email) {
	 return Ad.findByEmail(email);
 }
 
 public String save(Administrators A) {
	 Ad.save(A);
	 return "done";
 }
}
