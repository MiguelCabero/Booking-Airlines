package com.assesment.pricesapi.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.pricesapi.models.Flight;
import com.assesment.pricesapi.services.PriceService;

@CrossOrigin
@RestController
public class PriceController {
	@Autowired
	PriceService priceService;

	@PostMapping(path = "/api/prices")
	public ResponseEntity<Flight> getFinalPrice(@RequestBody Flight flight)
			throws ParseException, ClassNotFoundException {

		final Flight flightWithPrice = priceService.getFlightWithPrice(flight);

		return new ResponseEntity<Flight>(flightWithPrice, HttpStatus.OK);
	}

	@GetMapping(path = "api/prices/{origin}/{destination}/{date}")
	public ResponseEntity<List<Flight>> generateFlights(@PathVariable(name = "origin") Integer origin,
			@PathVariable(name = "destination") Integer destination, @PathVariable(name = "date") String date)
			throws ClassNotFoundException, ParseException {

		final List<Flight> flights = priceService.generateFlights(origin, destination, date);

		System.out.println(flights);
		return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);

	}

}
