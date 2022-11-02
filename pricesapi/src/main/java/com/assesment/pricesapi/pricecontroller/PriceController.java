package com.assesment.pricesapi.pricecontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.pricesapi.airlinemodel.Petition;
import com.assesment.pricesapi.priceservice.PriceService;

@CrossOrigin
@RestController
public class PriceController {
	@Autowired
	PriceService priceService;

	@PostMapping(path = "/api/prices")
	public ResponseEntity<Object> getFinalPrice(
			@RequestBody Petition petition) {

		final double finalprice = priceService.getPrice(
				petition.getAirline(), petition.getLuggage(),
				petition.getDistance(), petition.getLayover(),
				petition.getDays_left(),
				petition.getAge_of_passenger());

		final Map<String, Double> responseMap = new HashMap<String, Double>();
		responseMap.put("price", finalprice);
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
	}

}
