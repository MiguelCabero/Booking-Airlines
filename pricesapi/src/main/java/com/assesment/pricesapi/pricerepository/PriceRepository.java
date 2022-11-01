package com.assesment.pricesapi.pricerepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assesment.pricesapi.airlinemodel.Airline;

public interface PriceRepository extends JpaRepository<Airline, Integer> {

}
