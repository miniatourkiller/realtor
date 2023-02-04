package com.realtor.save;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.json.async.NonBlockingJsonParserBase;

@Component

public class EmailUtil {
	ArrayList<Object> list = new ArrayList<>();
public String getEntity(String url, String apikey, String email) {
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
	HttpEntity<String> requestEntity = new HttpEntity<>(headers);
	
	RestTemplate rest = new RestTemplate();
	
	ResponseEntity<String> responseEntity = rest.exchange(""+url+""+apikey+"&email="+email+"",HttpMethod.GET,requestEntity, String.class);
return String.valueOf(responseEntity.getBody());
}


public boolean realEmail(String url, String apiKey, String email){
String arr = getEntity(url,apiKey,email);
	String[] obj = arr.split(",", 11);
	String[] del = obj[2].split(":",2);
	
	System.out.println(del[1]);
	String text = (String)del[1];
if(text.equals("\"DELIVERABLE\"") ) {
	return true;
     }
  return false;
 }

	}

