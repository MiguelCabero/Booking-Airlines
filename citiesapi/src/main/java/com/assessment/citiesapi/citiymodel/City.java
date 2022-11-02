package com.assessment.citiesapi.citiymodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "cities")
public class City {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String name;

	@Column
	private String country;
	@Column
	private Integer airline;

	public City() {
	}

	public City(Integer id, String name, String country,
			Integer airline) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.airline = airline;
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

	public Integer getAirline() {
		return airline;
	}

	public void setAirline(Integer airline) {
		this.airline = airline;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", country="
				+ country + ", airline=" + airline + "]";
	}

}
