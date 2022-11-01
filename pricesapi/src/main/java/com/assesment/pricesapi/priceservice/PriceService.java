package com.assesment.pricesapi.priceservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assesment.pricesapi.airlinemodel.Airline;
import com.assesment.pricesapi.pricerepository.PriceRepository;

@Component
public class PriceService {

	@Autowired
	PriceRepository priceRepository;

	Optional<Airline> getById(Integer id) {
		return priceRepository.findById(id);
	}

	public double getPrice(Integer id, byte luggage, Double distance,
			byte layover, int days_left, byte age_of_passenger) {

		double distanceFactor = 1;
		final double stopsFactor = 1;
		final double luggageFactor = 1 + (luggage * 1.3);
		double daysLeftFactor = 1;
		double ageFactor = 0;

		final Airline retrievedAirline = getById(id).get();
		if (retrievedAirline == null) {
			return 0;
		}

		if (distance > 2300) {
			distanceFactor = 1.7;
		}

		switch (age_of_passenger) {
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

		if (days_left < 15) {
			daysLeftFactor = daysLeftFactor
					+ ((15 - days_left) * 0.1);
		}

		final double finalPrice = retrievedAirline.getBasePrice()
				* luggageFactor * distanceFactor * stopsFactor
				* daysLeftFactor * ageFactor;

		return finalPrice;

	}

}
