package com.realtor.login;

import javax.servlet.http.HttpSession;


public class SessionUtil {
	
public String check(HttpSession session) {
	String Sattrs = (String) session.getAttribute("message");
	if(Sattrs == null) {
		return "no session set";
	}
	return Sattrs;
}
public String[] getArr(HttpSession session) {
	String attributes= (String)session.getAttribute("message");
	return attributes.split(":", 3);
}
}
