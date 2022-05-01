package com.zensar.olxloginapplication.service;

import com.zensar.olxloginapplication.entity.Token;
import com.zensar.olxloginapplication.entity.User;

public interface LoginService {

	Token userAuthentication(User user);

	boolean logoutUser(String token1);

	String ResisterUser(User user);

	User getUserInfo(int id, String token2);
}
