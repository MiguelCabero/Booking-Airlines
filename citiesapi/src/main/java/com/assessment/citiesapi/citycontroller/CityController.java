package com.assessment.citiesapi.citycontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.citiesapi.citiymodel.City;
import com.assessment.citiesapi.cityservice.CityService;

@CrossOrigin
@RestController
public class CityController {

	@Autowired
	CityService cityService;

	@GetMapping(path = "/api/cities")
	public ResponseEntity<List<City>> getAllCities() {
		final List<City> cities = cityService.getAll();

		return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
	}

}
