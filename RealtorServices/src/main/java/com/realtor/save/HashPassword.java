package com.realtor.save;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;


public class HashPassword {
public String givePassword(String password) {
	return BCrypt.hashpw(password, BCrypt.gensalt());
}
public boolean checkPassword(String password, String hashed) {
	return BCrypt.checkpw(password, hashed);
}
}
