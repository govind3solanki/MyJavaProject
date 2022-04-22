package com.zensar.olxadvertiesapplication.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxadvertiesapplication.entity.Advertise;
import com.zensar.olxadvertiesapplication.service.AdvertiseService;

@RestController
public class AdvertiesController {

	@Autowired
	private AdvertiseService advertiseService;
	
	
	// request 7
	@PostMapping(value="/advertise", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Advertise addAdvertise(@RequestBody Advertise advertise1, @RequestHeader("auth-token") String token) {
			 return advertiseService.addAdvertise(advertise1, token);
	}

	// request 8
	@PutMapping(value="/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Advertise updateAdvertise(@PathVariable int id, @RequestBody Advertise advertise2,
			@RequestHeader("auth-token") String token2) {
		return advertiseService.updateAdvertise(id, advertise2, token2);
	}

	// request 9
	@GetMapping(value="/user/advertise", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<Advertise> getAllAdvertise(@RequestHeader("auth-token") String token3) {
			return advertiseService.getAllAdvertise(token3);
	}

	// request 10
	@GetMapping(value="/user/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public Advertise getSpecificAdvertise(@PathVariable int id, @RequestHeader("auth-token") String token4) {
		return advertiseService.getSpecificAdvertise(id, token4);
	}

	// request 11
	@DeleteMapping("/user/advertise/{id}")
	public boolean deleteSpecificAdvertise(@PathVariable int id, @RequestHeader("auth-token") String token5) {
		return advertiseService.deleteSpecificAdvertise(id, token5);
	}

	// request 12
	@GetMapping(value="/advertise/search/filtercriteria", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<Advertise> getFilteredAdvertise(@RequestHeader("searchText") String filterCriteria) {
		return advertiseService.getFilteredAdvertise(filterCriteria);
	}

	// request 13
	@GetMapping(value="/advertise/search", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<Advertise> getAdvertiseByText(@RequestHeader("searchText") String search) {
		 return advertiseService.getAdvertiseByText(search);
	}

	// request 14
	@GetMapping(value="/advertise/{postId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public Advertise getAdvertiseById(@PathVariable int postId, @RequestHeader("auth-token") String token6) {
		return advertiseService.getAdvertiseById(postId, token6);
	}

}
