package com.realtor.main;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.realtor.files.FileServices;
import com.realtor.login.LoginService;
import com.realtor.login.SessionUtil;
import com.realtor.management.Administrators;
import com.realtor.management.Security;
import com.realtor.necessary.ParkingSpaces;
import com.realtor.necessary.SessionHelper;
import com.realtor.parking.Parking;
import com.realtor.resident.Resident;
import com.realtor.save.AdministratorsService;
import com.realtor.save.EmailUtil;
import com.realtor.save.ParkingSpacesServices;
import com.realtor.save.Register;
import com.realtor.save.ResidentParking;
import com.realtor.save.SecurityService;
import com.realtor.save.ServerService;
import com.realtor.services.ServiceProviders;

@RestController
public class RealtorController {

	@Value("${api.key}")
	private String apikey;


@Autowired
LoginService loginService;

@Autowired
SessionUtil sessionUtil;


@RequestMapping ("/")
public String indexTypo(HttpSession session) {
	
	return sessionUtil.check(session);
}

@Autowired
AdministratorsService adminServices;

@RequestMapping(value = "/addAdmin", method = RequestMethod.POST, consumes = "application/json")
public String addAdmin(@RequestBody Administrators admin, HttpServletRequest req) {
 return adminServices.saveAdmin(admin, req.getSession());
}

@Autowired
SecurityService securityService;

@RequestMapping(value = "/addSecurity", method = RequestMethod.POST)
public String addSecurity(@RequestBody Security security, HttpServletRequest req){
return securityService.saveSecurity(security, req.getSession());
}
@Autowired
ServerService serverService;
@RequestMapping(value = "/addServer", method = RequestMethod.POST)
public String addServer(ServiceProviders sp, HttpServletRequest req) {
	return serverService.addServiceProvider(sp, req.getSession());
}

@RequestMapping(value = "login", method = RequestMethod.POST)
public String login(@RequestBody SessionHelper Sh, HttpServletRequest req, Model model) {
	model = loginService.confirmLogin(Sh.getResidentEmail(), Sh.getResidentPassword(), model);
	if(model.getAttribute("exist") == "false") {
		return "invalid details";
	}
	req.getSession().setAttribute("message", ""+model.getAttribute("exist")+":"+model.getAttribute("priority")+":"+model.getAttribute("email"));
return "done: "+model.getAttribute("exist");
}

@RequestMapping("simple")
public String welcome(HttpServletResponse res, HttpServletRequest req) {
	if(indexTypo(req.getSession()) == "no session set") {
		return "invalid";
	}
	
	return "<h1>Hello "+sessionUtil.getArr(req.getSession())[1]+"</h1>";
}
@Autowired
Register register;

@RequestMapping(value="residentSave", method= RequestMethod.POST, consumes = "application/json")
public String saveResident(@RequestBody Resident R, HttpSession session) {
	return register.reg(R, session);
}
@Autowired 
ResidentParking residentParking;
@RequestMapping(value = "/assignParking", method = RequestMethod.POST)
public String assignParking(@RequestBody Parking p, HttpServletRequest req) {
	return residentParking.assignParking(p, req.getSession());
}

ParkingSpaces ps = new ParkingSpaces();
@Autowired
ParkingSpacesServices pss;

@PostMapping("setparkingspace")
public String setParkingSpace(@RequestBody ParkingSpaces parkingSpaces, HttpServletRequest req) {
	return pss.addSpot(parkingSpaces, req.getSession());
}

@Autowired
FileServices fileServices;

@PostMapping("testfile")
public String updateProfilePic(@RequestParam("file") MultipartFile file, HttpServletRequest req) throws IllegalStateException, IOException {
	
	return fileServices.updatePic(file, req.getSession());
}
@RequestMapping(value = "profile", method = RequestMethod.GET)
public Object getProfile(HttpServletRequest req, Model model) {
	return loginService.getProfile(req.getSession(), model);
}
@Value("${api.url}")
String url;

@Autowired
EmailUtil emailUtil;
@RequestMapping(value ="getapi/{email}", method = RequestMethod.GET)
public void returnApi(@PathVariable("email") String email) throws IOException {
	System.out.println(email);
	
	System.out.println(emailUtil.realEmail(url, apikey, email));
}
}
