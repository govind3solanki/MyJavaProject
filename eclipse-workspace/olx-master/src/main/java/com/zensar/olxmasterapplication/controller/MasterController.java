package com.zensar.olxmasterapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxmasterapplication.entity.Category;
import com.zensar.olxmasterapplication.entity.Status;

@RestController
@RequestMapping("/advertise")
public class MasterController {

	static List<Category> categorys = new ArrayList<>();
	static {
		categorys.add(new Category(1, "Furniture"));
		categorys.add(new Category(2, "Cars"));
		categorys.add(new Category(3, "Mobiles"));
		categorys.add(new Category(4, "RealEstate"));
		categorys.add(new Category(5, "Sports"));
	}

	static List<Status> statusList = new ArrayList<>();
	static {
		statusList.add(new Status(1, "OPEN"));
		statusList.add(new Status(2, "CLOSE"));
	}

	// request 5
	@GetMapping(value="/category", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<Category> getAllCategory() {
		return categorys;
	}

	// request 6
	@GetMapping(value="/status", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<Status> getAllStatus() {
		return statusList;
	}
}
