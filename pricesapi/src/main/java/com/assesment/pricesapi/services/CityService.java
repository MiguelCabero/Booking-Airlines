package com.assesment.pricesapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assesment.pricesapi.models.City;
import com.assesment.pricesapi.repositories.CityRepository;

@Component
public class CityService {

	@Autowired
	CityRepository cityRepository;

	Optional<City> getCity(Integer id) {
		return cityRepository.findById(id);
	}

}
