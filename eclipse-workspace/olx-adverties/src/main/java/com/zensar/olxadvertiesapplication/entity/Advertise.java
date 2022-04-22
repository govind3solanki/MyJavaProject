package com.zensar.olxadvertiesapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advertise {

	private int categoryId;
	private String title;
	private int price;
	private String category;
	private String description;
	private String username;
	private String createdDate;
	private String modifiedDate;
	private String status;

}

