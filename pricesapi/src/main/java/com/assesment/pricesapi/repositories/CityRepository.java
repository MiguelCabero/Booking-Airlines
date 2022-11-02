package com.assesment.pricesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.assesment.pricesapi.models.City;

@Component
public interface CityRepository extends JpaRepository<City, Integer> {

}
