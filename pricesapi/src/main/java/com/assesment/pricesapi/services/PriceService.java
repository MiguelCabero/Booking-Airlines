package com.assesment.pricesapi.services;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assesment.pricesapi.models.Airline;
import com.assesment.pricesapi.models.Distance;
import com.assesment.pricesapi.models.Flight;
import com.assesment.pricesapi.repositories.PriceRepository;

@Component
public class PriceService {

	@Autowired
	PriceRepository priceRepository;

	@Autowired
	DistanceService distanceService;

	Optional<Airline> getById(Integer id) {
		return priceRepository.findById(id);
	}

	public Flight getFlightWithPrice(Flight flight)
			throws ParseException, ClassNotFoundException {

		double distanceFactor = 1;
		final double stopsFactor = 1;
		final double luggageFactor = 1 + (flight.getLuggage() * 1.3);
		double daysLeftFactor = 1;
		double ageFactor = 0;

		final Distance distance = distanceService
				.findDistanceBetweenCities(flight.getCityOne(),
						flight.getCityTwo());

		final Airline retrievedAirline = getById(flight.getAirline())
				.get();
		if (retrievedAirline == null) {
			throw new ClassNotFoundException();
		}

		if (distance.getDistance() > 2300) {
			distanceFactor = 1.7;
		}

		switch (flight.getAge_of_passenger()) {
		case 1: {
			ageFactor = 1.3;
			break;
		}
		case 2: {
			ageFactor = 1.7;
			break;
		}
		default:
			ageFactor = 0;
		}

		final long diff = DateUtilities
				.getDaysDifference(flight.getDate_selected());

		if (diff < 15) {
			daysLeftFactor = daysLeftFactor + ((15 - diff) * 0.1);
		}

		final double finalPrice = retrievedAirline.getBasePrice()
				* luggageFactor * distanceFactor * stopsFactor
				* daysLeftFactor * ageFactor;

		flight.setPrice(finalPrice);

		return flight;

	}

}
