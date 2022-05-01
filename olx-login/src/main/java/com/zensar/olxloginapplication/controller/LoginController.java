package com.zensar.olxloginapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxloginapplication.entity.Token;
import com.zensar.olxloginapplication.entity.User;
import com.zensar.olxloginapplication.service.LoginService;

@RestController
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private LoginService loginService;

	// request 1
	@PostMapping(value = "/authenticate", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Token userAuthentication(@RequestBody User user) {
		return loginService.userAuthentication(user);
	}

	// request 2
	@DeleteMapping("/logout")
	public boolean logoutUser(@RequestHeader("auth-token") String token1) {
		return loginService.logoutUser(token1);
	}

	// request 3
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> ResisterUser(@RequestBody User user) {
		String resisterUser = loginService.ResisterUser(user);
		return new ResponseEntity<String>(resisterUser, HttpStatus.CREATED);
	}

	// request 4
	@GetMapping(value = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public User getUserInfo(@PathVariable("userId") int id, @RequestHeader("auth-token") String token2) {
		return loginService.getUserInfo(id, token2);
	}

}
