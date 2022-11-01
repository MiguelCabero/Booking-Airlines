package com.assesment.pricesapi.pricerepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.assesment.pricesapi.airlinemodel.Airline;

@Component
public interface PriceRepository
		extends JpaRepository<Airline, Integer> {

}
