package com.assessment.citiesapi.citiymodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String country;
	@Column(name = "airline")
	private int airlineId;

	public City(Integer id, String name, String country, int airlineId) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.airlineId = airlineId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", country=" + country + ", airlineId=" + airlineId + "]";
	}

}
