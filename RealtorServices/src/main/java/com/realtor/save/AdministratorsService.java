package com.realtor.save;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realtor.login.SessionUtil;
import com.realtor.management.Administrators;
import com.realtor.management.AdministratorsRepo;

@Service
public class AdministratorsService {
@Autowired
AdministratorsRepo adminrepo;
@Autowired
HashPassword hashp;
@Autowired
SessionUtil sessionUtil;
public String saveAdmin(Administrators admin, HttpSession session) {
	if(session == null) {
		return "login";
	}
	if(sessionUtil.getArr(session)[1].equals("admin")) {
		if(adminrepo.findByEmail(admin.getEmail()) != null) {
			return "email exists";
		}
		String pass = admin.getPassword();
		String hashed = hashp.givePassword(pass);
		admin.setPassword(hashed);
		return adminrepo.save(admin);
	}
	return "unauthorized";
}

}
