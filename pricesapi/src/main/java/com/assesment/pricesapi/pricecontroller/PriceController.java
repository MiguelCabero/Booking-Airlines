package com.assesment.pricesapi.pricecontroller;

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
	public ResponseEntity<String> getFinalPrice(
			@RequestBody Petition petition) {

		final Float finalprice = priceService.getPrice(
				petition.getAirline(), petition.getLuggage(),
				petition.getDistance(), petition.getLayover(),
				petition.getDays_left(),
				petition.getAge_of_passenger());
		final String priceString = String.valueOf(finalprice);

		System.out.println(priceString);

		final String responseMessage = "{\r\n" + "  \"price\":"
				+ priceString + "\r\n" + "}";

		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}

}
