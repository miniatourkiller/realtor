package com.realtor.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.realtor.management.Administrators;
import com.realtor.management.AdministratorsRepo;
import com.realtor.management.Security;
import com.realtor.management.SecurityRepo;
import com.realtor.resident.Resident;
import com.realtor.residents.ResidentsRepo;
import com.realtor.save.HashPassword;
import com.realtor.services.ServiceProviderRepo;
import com.realtor.services.ServiceProviders;

@Service
public class LoginService {
	@Autowired
	ResidentsRepo residentRepo;
	@Autowired
	AdministratorsRepo adminRepo;
	@Autowired
	SecurityRepo securityRepo;
	@Autowired
	ServiceProviderRepo serverRepo;
	@Autowired
	HashPassword hashp;
	public Model residentExistent(String email, String password, Model model) {
		Resident resident = new Resident();
		resident = residentRepo.findResidentByEmail(email);
		if(resident == null) {
			model.addAttribute("exist", "false");
			return model;
		}
		String hashed = resident.getPassword();
		if(hashp.checkPassword(password, hashed)) {
			model.addAttribute("exist", "true");
			model.addAttribute("priority", "resident");
			model.addAttribute("email", email);
			return model;
		}
		model.addAttribute("exist", "false");
		return model;
	}
	public Model administratorExistent(String email, String password, Model model) {
		Administrators admin = new Administrators();
		admin = adminRepo.findByEmail(email);
		if(admin == null) {
			model.addAttribute("exist", "false");
			return model;
		}
		String hashed = admin.getPassword();
		if(hashp.checkPassword(password, hashed)) {
			model.addAttribute("exist", "true");
			model.addAttribute("priority", "admin");
			model.addAttribute("email", email);
			return model;
		}
		model.addAttribute("exist", "false");
		return model;
	}
	public Model securityExistent(String email, String password, Model model) {
		Security security = new Security();
		security = securityRepo.findByEmail(email);
		if(security == null) {
			model.addAttribute("exist", "false");
			return model;
		}
		String hashed = security.getPassword();
		if(hashp.checkPassword(password, hashed)) {
			model.addAttribute("exist", "true");
			model.addAttribute("priority", "security");
			model.addAttribute("email", email);
			return model;
		}
		model.addAttribute("exist", "false");
		return model;
	}
	public Model serverExistent(String email, String password, Model model) {
	ServiceProviders server = new ServiceProviders();
	server = serverRepo.checkServiceProvider(email);
	if(server == null) {
		model.addAttribute("exist", "false");
		return model;
	}
		String hashed = server.getPassword();
		if(hashp.checkPassword(password, hashed)) {
			model.addAttribute("exist", "true");
			model.addAttribute("priority", "server");
			model.addAttribute("email", email);
			return model;
		}
		model.addAttribute("exist", "false");
		return model;
	}
	public Model confirmLogin(String email, String password, Model model) {
		model = administratorExistent(email, password, model);
		if(model.getAttribute("exist") == "true") {
			return model;
		}else {
			model = securityExistent(email, password, model);
		}
		if(model.getAttribute("exist") == "true") {
			return model;
		}else {
			model = serverExistent(email, password, model);
		}
		if(model.getAttribute("exist") == "true") {
			return model;
		}else {
			model = residentExistent(email, password, model);
		}
		return model;
	}
	
	
	public Resident getResidentProfile(String email) {
		return residentRepo.findResidentByEmail(email);
	}
	public Administrators getAdminProfile(String email) {
		return adminRepo.findByEmail(email);
	}
	
	@Autowired
	SessionUtil sessionUtil;
	public Object getProfile(HttpSession session, Model model) {
		if(session == null) {
			model.addAttribute("error", "login");
		}
		if(sessionUtil.getArr(session)[1].equals("resident")) {
			return getResidentProfile(sessionUtil.getArr(session)[2]);
		}else if(sessionUtil.getArr(session)[1].equals("admin")) {
			return getAdminProfile(sessionUtil.getArr(session)[2]);
		}
		
		return model;
	}
}