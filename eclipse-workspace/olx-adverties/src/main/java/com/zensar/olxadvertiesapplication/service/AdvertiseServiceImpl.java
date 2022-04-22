package com.zensar.olxadvertiesapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.zensar.olxadvertiesapplication.entity.Advertise;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	static List<Advertise> advertiseList = new ArrayList<>();
	static {
		advertiseList.add(new Advertise(1, "laptop", 54000, "Electronics Goods", "Intel Core 3 Sony Vaio", "anand",
				"xxx", "xxx", "OPEN"));
		advertiseList.add(new Advertise(2, "Computer", 59000, "Computer Goods", "Intel Core 9 Razor Gaming", "anand",
				"xxx", "xxx", "OPEN"));
	}

	@Override
	public Advertise addAdvertise(Advertise advertise1, String token) {
		if (token.equals("gs66548")) {
			Advertise advertise = new Advertise(0, null, 0, "Electronic goods", null, "anand", "xxx", "xxx", "OPEN");
			advertise.setCategoryId(advertise1.getCategoryId());
			advertise.setTitle(advertise1.getTitle());
			advertise.setPrice(advertise1.getPrice());
			advertise.setDescription(advertise1.getDescription());
			advertiseList.add(advertise);
			return advertise;
		} else
			return null;
	}

	@Override
	public Advertise updateAdvertise(int id, Advertise advertise2, String token2) {
		if (token2.equals("gs66548")) {
			Optional<Advertise> findAny = advertiseList.stream().filter(advertise -> advertise.getCategoryId() == id)
					.findAny();
			if (findAny.isPresent()) {
				Advertise adv = findAny.get();
				adv.setTitle(advertise2.getTitle());
				adv.setPrice(advertise2.getPrice());
				adv.setCategoryId(advertise2.getCategoryId());
				adv.setDescription(advertise2.getDescription());
				return adv;
			} else 
				return findAny.orElseGet(() -> new Advertise());
		} else
			return null;
	}

	@Override
	public List<Advertise> getAllAdvertise(String token3) {
		if (token3.equals("gs66548"))
			return advertiseList;
		else
			return null;
	}

	@Override
	public Advertise getSpecificAdvertise(int id, String token4) {
		if (token4.equals("gs66548")) {
			Optional<Advertise> findAny = advertiseList.stream().filter(advertise -> advertise.getCategoryId() == id)
					.findAny();

			if (findAny.isPresent())
				return findAny.get();
			else
				return findAny.orElseGet(() -> new Advertise());
		} else
			return null;
	}

	@Override
	public boolean deleteSpecificAdvertise(int id, String token5) {
		if (token5.equals("gs66548")) {
			Optional<Advertise> findAny = advertiseList.stream().filter(advertise -> advertise.getCategoryId() == id)
					.findAny();

			if (findAny.isPresent()) {
				Advertise advertise = findAny.get();
				advertiseList.remove(advertise);
				return true;
			} else
				return false;
		} else
			return false;
	}

	@Override
	public List<Advertise> getFilteredAdvertise(String filterCriteria) {
		if (filterCriteria.equals("status"))
			return advertiseList;
		else
			return null;
	}

	@Override
	public List<Advertise> getAdvertiseByText(String search) {
		if (search.equals("categoryId"))
			return advertiseList;
		else
			return null;

	}

	@Override
	public Advertise getAdvertiseById(int postId, String token6) {
		if (token6.equals("gs66548")) {
			Optional<Advertise> findAny = advertiseList.stream()
					.filter(advertise -> advertise.getCategoryId() == postId).findAny();

			if (findAny.isPresent())
				return findAny.get();
			else
				return findAny.orElseGet(() -> new Advertise());
		} else
			return null;
	}

}
