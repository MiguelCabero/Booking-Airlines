package com.assessment.citiesapi.cityrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.assessment.citiesapi.citiymodel.City;

@Component
public interface CityRepository extends JpaRepository<City, Integer> {

}
