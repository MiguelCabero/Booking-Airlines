package com.assesment.pricesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.assesment.pricesapi.models.Distance;

@Component
public interface DistanceRepository
		extends JpaRepository<Distance, Integer> {

	Distance findByCityoneAndCitytwo(int cityOne, int cityTwo);

}
