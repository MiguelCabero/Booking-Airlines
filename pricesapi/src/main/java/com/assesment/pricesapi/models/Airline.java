package com.assesment.pricesapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

	public Airline() {
	}

	public Airline(Integer id, String name, boolean includedLuggage,
			double basePrice) {
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

	@Override
	public String toString() {
		return "Airline [id=" + id + ", name=" + name
				+ ", includedLuggage=" + includedLuggage
				+ ", basePrice=" + basePrice + "]";
	}
}
