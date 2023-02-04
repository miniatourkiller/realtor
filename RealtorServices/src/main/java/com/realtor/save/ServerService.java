package com.realtor.save;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realtor.login.SessionUtil;
import com.realtor.services.ServiceProviderRepo;
import com.realtor.services.ServiceProviders;

@Service
public class ServerService {
@Autowired
ServiceProviderRepo serverRepo;
@Autowired
SessionUtil sessionUtil;

@Autowired
HashPassword hashp;

public String addServiceProvider(ServiceProviders server, HttpSession session) {
	if(session == null) {
		return "login";
	}
	if(sessionUtil.getArr(session)[1].equals("admin")) {
		if(serverRepo.checkServiceProvider(server.getEmail()) != null) {
			return "email exists";
		}
		String password = server.getPassword();
		server.setPassword(hashp.givePassword(password));
		return serverRepo.save(server);
	}
	return "unauthorized";
}
}
