package com.realtor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceProviderRepo {
@Autowired
ServiceProvidersDao SPD;

public String save(ServiceProviders sp) {
	SPD.save(sp);
	return "done";
}
public ServiceProviders checkServiceProvider(String email) {
	return SPD.checkByEmail(email);
}

}
