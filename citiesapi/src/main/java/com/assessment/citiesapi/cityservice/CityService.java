package com.assessment.citiesapi.cityservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assessment.citiesapi.citiymodel.City;
import com.assessment.citiesapi.cityrepository.CityRepository;

@Component
public class CityService {

	@Autowired
	CityRepository cityRepository;

	public List<City> getAll() {
		return cityRepository.findAll();
	}

}
