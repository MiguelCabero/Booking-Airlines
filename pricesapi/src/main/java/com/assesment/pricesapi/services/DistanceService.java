package com.assesment.pricesapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assesment.pricesapi.models.Distance;
import com.assesment.pricesapi.repositories.DistanceRepository;

@Component
public class DistanceService {

	@Autowired
	DistanceRepository distanceRepository;

	Distance findDistanceBetweenCities(int cityOne, int cityTwo) {
		Distance distance = distanceRepository
				.findByCityoneAndCitytwo(cityOne, cityTwo);
		if (distance == null) {
			distance = distanceRepository
					.findByCityoneAndCitytwo(cityTwo, cityOne);
		}

		return distance;
	}
}
