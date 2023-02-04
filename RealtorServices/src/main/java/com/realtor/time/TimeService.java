package com.realtor.time;


import java.time.LocalDateTime;


public interface TimeService {

	LocalDateTime expireTime(int minutes);
}
