package com.zensar.olxadvertiesapplication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

@RestController
public class AdvertiesController {

	List<Advertise> advertiseList = new ArrayList<>();

	// request 7
	@PostMapping(value="/advertise", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Advertise addAdvertise(@RequestBody Advertise advertise1, @RequestHeader("auth-token") String token) {
		if (token.equals("gs66548")) {
			Advertise advertise = new Advertise(0, null, 0, "Electronic goods", null, "anand", "xxx", "xxx", "OPEN");
			advertise.setId(advertise1.getId());
			advertise.setTitle(advertise1.getTitle());
			advertise.setPrice(advertise1.getPrice());
			advertise.setDescription(advertise1.getDescription());
			advertiseList.add(advertise);
			return advertise;
		} else
			return null;
	}

	// request 8
	@PutMapping(value="/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Advertise updateAdvertise(@PathVariable int id, @RequestBody Advertise advertise2,
			@RequestHeader("auth-token") String token2) {
		if (token2.equals("gs66548")) {
			Optional<Advertise> findAny = advertiseList.stream().filter(advertise -> advertise.getId() == id).findAny();

			if (findAny.isPresent()) {
				Advertise adv = findAny.get();
				adv.setTitle(advertise2.getTitle());
				adv.setPrice(advertise2.getPrice());
				adv.setId(advertise2.getId());
				adv.setDescription(advertise2.getDescription());
				return adv;
			} else {
				return findAny.orElseGet(() -> new Advertise());
			}
		} else
			return null;
	}

	// request 9
	@GetMapping(value="/user/advertise", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<Advertise> getAllAdvertise(@RequestHeader("auth-token") String token3) {
		if (token3.equals("gs66548"))
			return advertiseList;
		else
			return null;
	}

	// request 10
	@GetMapping(value="/user/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public Advertise getSpecificAdvertise(@PathVariable int id, @RequestHeader("auth-token") String token4) {
		if (token4.equals("gs66548")) {
			Optional<Advertise> findAny = advertiseList.stream().filter(advertise -> advertise.getId() == id).findAny();

			if (findAny.isPresent()) {
				return findAny.get();
			} else {
				return findAny.orElseGet(() -> new Advertise());
			}
		} else
			return null;
	}

	// request 11
	@DeleteMapping("/user/advertise/{id}")
	public boolean deleteSpecificAdvertise(@PathVariable int id, @RequestHeader("auth-token") String token5) {
		if (token5.equals("gs66548")) {
			Optional<Advertise> findAny = advertiseList.stream().filter(advertise -> advertise.getId() == id).findAny();

			if (findAny.isPresent()) {
				Advertise advertise = findAny.get();
				advertiseList.remove(advertise);
				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

	// request 12
	@GetMapping(value="/advertise/search/filtercriteria", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<Advertise> getFilteredAdvertise(@RequestHeader("searchText") String filterCriteria) {
		if (filterCriteria.equals("status")) {
			List<Advertise> collect = advertiseList.stream().sorted().collect(Collectors.toList());
			if (collect.isEmpty()) {
				return null;
			} else {
				return collect;
			}
		}
		return null;
	}

	// request 13
	@GetMapping(value="/advertise/search", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<Advertise> getAdvertiseByText(@RequestHeader("searchText") String search) {
		if (search.equals("id")) {
			List<Advertise> collect = advertiseList.stream().sorted().collect(Collectors.toList());
			if (collect.isEmpty()) {
				return null;
			} else {
				return collect;
			}
		}
		return null;
	}

	// request 14
	@GetMapping(value="/advertise/{postId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public Advertise getAdvertiseById(@PathVariable int postId, @RequestHeader("auth-token") String token6) {
		if (token6.equals("gs66548")) {
			Optional<Advertise> findAny = advertiseList.stream().filter(advertise -> advertise.getId() == postId)
					.findAny();

			if (findAny.isPresent()) {
				return findAny.get();
			} else {
				return findAny.orElseGet(() -> new Advertise());
			}
		} else
			return null;
	}

}
