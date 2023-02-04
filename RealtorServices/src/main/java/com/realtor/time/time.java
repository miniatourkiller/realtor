package com.realtor.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

@Component
public class time implements TimeService{
	public LocalDateTime timeNow() {
		return LocalDateTime.now();
	}
	
	public LocalDateTime expireTime(int minutes) {
		return timeNow().plus(minutes, ChronoUnit.MINUTES);
	}
	
}
