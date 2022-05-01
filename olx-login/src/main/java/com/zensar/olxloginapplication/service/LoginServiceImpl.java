package com.zensar.olxloginapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zensar.olxloginapplication.entity.Token;
import com.zensar.olxloginapplication.entity.User;

@Service
public class LoginServiceImpl implements LoginService{

	Token token = new Token("auth-token", "gs66548");
	List<User> userList = new ArrayList<>();

	@Override
	public Token userAuthentication(User user) {
		if (user.getUserName().equals("anand") && user.getPassword().equals("anand123")) {
			// token=new Token("auth-token","gs66548");
			return token;
		}
		return null;
	}

	@Override
	public boolean logoutUser(String token1) {
		if (token1.equalsIgnoreCase("gs66548")) {
			token.setKye(null);
			token.setValue(null);
			return true;
		} else
			return false;
	}

	@Override
	public String ResisterUser(User user) {
		if (token.getKye().equals("auth-token") && token.getValue().equals("gs66548")) {
			userList.add(user);
			return "User resister succesfully";
		} else
			return "User not resister succesfully";
	}

	@Override
	public User getUserInfo(int id, String token2) {
		if (token.getValue().equals(token2)) {
			Optional<User> findAny = userList.stream().filter(user -> user.getId() == id).findAny();
			if (findAny.isPresent())
				return findAny.get();
			else
				return findAny.orElseGet(() -> new User());
		} else
			return null;
	}

}
