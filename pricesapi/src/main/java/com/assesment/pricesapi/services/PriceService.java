package com.assesment.pricesapi.services;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assesment.pricesapi.models.Airline;
import com.assesment.pricesapi.models.City;
import com.assesment.pricesapi.models.Distance;
import com.assesment.pricesapi.models.Flight;
import com.assesment.pricesapi.repositories.PriceRepository;

@Component
public class PriceService {

	@Autowired
	PriceRepository priceRepository;

	@Autowired
	DistanceService distanceService;

	@Autowired
	CityService cityService;

	Optional<Airline> getById(Integer id) {
		return priceRepository.findById(id);
	}

	public Flight getFlightWithPrice(Flight flight)
			throws ParseException, ClassNotFoundException {

		double distanceFactor = 1;
		double stopsFactor = 1;
		double daysLeftFactor = 1;
		double ageFactor = 0;

		final Distance distance = distanceService
				.findDistanceBetweenCities(flight.getCityOne(),
						flight.getCityTwo());

		final String duration = distance.getDuration().toString();

		final Airline retrievedAirline = getById(flight.getAirline())
				.get();
		flight.setLuggage(retrievedAirline.isIncludedLuggage());
		final double luggageFactor = 1 + (flight.getLuggage() * 1.3);

		if (retrievedAirline == null) {
			throw new ClassNotFoundException();
		}

		if (distance.getDistance() > 2300) {
			distanceFactor = 1.7;
			flight.setLayover(1);
			stopsFactor = stopsFactor + (flight.getLayover() / 5);
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
		flight.setAirlineName(retrievedAirline.getName());
		flight.setDuration(duration);

		return flight;

	}

	public List<Flight> generateFlights(int origin, int destination,
			String dateSelected)
			throws ParseException, ClassNotFoundException {
		final List<LocalDate> dateList = DateUtilities
				.generateDates(dateSelected);
		final List<Flight> flightList = new ArrayList<>();

		for (final LocalDate date : dateList) {
			final City cityOrigin = cityService.getCity(origin).get();
			final City cityDestination = cityService
					.getCity(destination).get();

			if (date.getDayOfMonth() % 2 != 0) {
				flightList.add(getFlightWithPrice(new Flight(origin,
						destination, date.toString(),
						cityOrigin.getAirline(), cityOrigin,
						cityDestination)));

			} else {
				flightList.add(getFlightWithPrice(new Flight(origin,
						destination, date.toString(),
						cityDestination.getAirline(), cityOrigin,
						cityDestination)));

			}

		}

		return flightList;
	}

}
