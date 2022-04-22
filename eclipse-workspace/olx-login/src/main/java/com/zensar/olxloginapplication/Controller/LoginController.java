package com.zensar.olxloginapplication.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping("/user")
public class LoginController {

	Token token = new Token("auth-token", "gs66548");
	List<User> userList = new ArrayList<>();

	// request 1
	@PostMapping(value="/authenticate", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Token userAuthentication(@RequestBody User user) {
		if (user.getUserName().equals("anand") && user.getPassword().equals("anand123")) {
			// token=new Token("auth-token","gs66548");
			return token;
		}
		return null;
	}

	// request 2
	@DeleteMapping("/logout")
	public boolean logoutUser(@RequestHeader("auth-token") String token1) {
		if (token1.equalsIgnoreCase("gs66548")) {
			token.setKye(null);
			token.setValue(null);
			return true;
		} else
			return false;
	}

	// request 3
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> ResisterUser(@RequestBody User user) {
		if (token.getKye().equals("auth-token") && token.getValue().equals("gs66548")) {
			userList.add(user);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} else
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	// request 4
	@GetMapping(value="/{userId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public User getUserInfo(@PathVariable("userId") int id, @RequestHeader("auth-token") String token2) {
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
