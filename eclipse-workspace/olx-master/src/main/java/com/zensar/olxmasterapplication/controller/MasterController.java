package com.zensar.olxmasterapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxmasterapplication.entity.Category;
import com.zensar.olxmasterapplication.entity.Status;
import com.zensar.olxmasterapplication.service.MasterService;

@RestController
@RequestMapping("/advertise")
public class MasterController {

	@Autowired
	private MasterService masterService;

	// request 5
	@GetMapping(value = "/category", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Category> getAllCategory() {
		List<Category> allCategory = masterService.getAllCategory();
		return allCategory;
	}

	// request 6
	@GetMapping(value = "/status", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Status> getAllStatus() {
		List<Status> allStatus = masterService.getAllStatus();
		return allStatus;
	}
}
