package com.zensar.olxadvertiesapplication.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.zensar.olxadvertiesapplication.entity.Advertise;

public interface AdvertiseService {

	 Advertise addAdvertise( Advertise advertise1,String token);
	 
	 Advertise updateAdvertise(int id,Advertise advertise2,String token2);
	 
	 List<Advertise> getAllAdvertise(String token3);
	 
	 Advertise getSpecificAdvertise(int id, String token4);
	 
	 boolean deleteSpecificAdvertise(int id,String token5);
	 
	 List<Advertise> getFilteredAdvertise(String filterCriteria);
	 
	 List<Advertise> getAdvertiseByText(String search);
	 
	 Advertise getAdvertiseById(int postId,String token6);
	 
	 
	 
}
