package com.realtor.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.realtor.login.SessionUtil;
import com.realtor.save.HashPassword;

@Configuration
public class classConfig {
@Bean
SessionUtil sessionUtil() {
	return new SessionUtil();
}
@Bean
HashPassword setHashPassword() {
	return new HashPassword();
}
}
