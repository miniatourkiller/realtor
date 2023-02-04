package com.realtor.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityRepo {
	@Autowired
	SecurityDao sd;

	 public Security findByEmail(String email) {
		 return sd.findByEmail(email);
	 }
	 
	 public String save(Security s) {
		 sd.save(s);
		 return "done";
	 }
}
