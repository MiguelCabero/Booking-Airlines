package com.assesment.pricesapi.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "airlines")
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	@Column(name = "included_luggage")
	private boolean includedLuggage;
	@Column(name = "base_price")
	private double basePrice;

	@OneToMany(mappedBy = "airline", fetch = FetchType.LAZY)
	@Column
	@JsonIgnore
	private List<City> cities;

	public Airline() {
	}

	public Airline(Integer id, String name, boolean includedLuggage,
			double basePrice) {
		super();
		this.id = id;
		this.name = name;
		this.includedLuggage = includedLuggage;
		this.basePrice = basePrice;
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

	public boolean isIncludedLuggage() {
		return includedLuggage;
	}

	public void setIncludedLuggage(boolean includedLuggage) {
		this.includedLuggage = includedLuggage;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "Airline [id=" + id + ", name=" + name
				+ ", includedLuggage=" + includedLuggage
				+ ", basePrice=" + basePrice + ", cities=" + cities
				+ "]";
	}

}
