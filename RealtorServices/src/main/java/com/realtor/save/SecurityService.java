package com.realtor.save;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realtor.login.SessionUtil;
import com.realtor.management.Security;
import com.realtor.management.SecurityRepo;

@Service
public class SecurityService {
@Autowired
SecurityRepo securityRepo;

@Autowired
HashPassword hashp;

@Autowired
SessionUtil sessionUtil;

public String saveSecurity(Security security, HttpSession session) {
	if(session == null) {
		return "login";
	}
	if(sessionUtil.getArr(session)[1].equals("admin")) {
		if(securityRepo.findByEmail(security.getEmail()) != null) {
			return "email exists";
		}
		String Password = security.getPassword();
		security.setPassword(hashp.givePassword(Password));
		return securityRepo.save(security);
	}
	
	return "unauthorized";
}
}
