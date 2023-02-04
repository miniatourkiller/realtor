package com.realtor.files;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.realtor.login.SessionUtil;
import com.realtor.resident.Resident;
import com.realtor.residents.ResidentsRepo;

@Service
public class FileServices {
	@Autowired
	SessionUtil sessionUtil;
	@Autowired
	ResidentsRepo residentsRepo;
public String updatePic(MultipartFile file, HttpSession session) throws IllegalStateException, IOException {
	if(session == null) {
		return "login";
	}
	if(sessionUtil.getArr(session)[1].equals("admin")||sessionUtil.getArr(session)[1].equals("resident")) {
		if(file == null) {
			return "nofile";
		}
		file.transferTo(new File("C:\\Users\\User\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\realtor-dreams\\RealtorMain\\src\\main\\resources\\public\\images\\residents\\"+file.getOriginalFilename()));
		System.out.println(file.getOriginalFilename());
		String[] arr = sessionUtil.getArr(session);
		Resident resident = new Resident();
		resident = residentsRepo.findResidentByEmail(arr[2]);
		if(resident == null) {
			return "something went wrong";
		}
		resident.setProfilePath(file.getOriginalFilename());
		residentsRepo.saveResident(resident);
		return "done";
	}
	return "unauthorized";
}
public String uploadFiles(MultipartFile[] files,HttpSession session) throws IllegalStateException, IOException {
	if(session == null) {
		return "login";
	}
	if(!sessionUtil.getArr(session)[1].equals("admin")||!sessionUtil.getArr(session)[1].equals("resident")) {
		return "unauthorized";
	}
	if(files == null) {
		return "nofile";
	}
	for(MultipartFile file: files) {
		file.transferTo(new File("C:\\Users\\User\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\realtor-dreams\\RealtorMain\\src\\main\\resources\\public\\images\\houses\\"));
	}
	return "done";
}
}
