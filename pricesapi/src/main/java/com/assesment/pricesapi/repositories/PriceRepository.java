package com.assesment.pricesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.assesment.pricesapi.models.Airline;

@Component
public interface PriceRepository
		extends JpaRepository<Airline, Integer> {

}
