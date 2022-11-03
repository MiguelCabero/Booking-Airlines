package com.assesment.pricesapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	Integer ID;
	@Column(name = "CITY_ONE")
	Integer cityOne;
	@Column(name = "CITY_TWO")
	Integer cityTwo;
	@Column
	Integer airline;
	@Column
	String airlineName;
	@Column
	byte luggage = 0;
	@Column
	int layover = 0;
	@Column
	String date_selected;
	@Column
	byte age_of_passenger = 2;
	@Column
	double price;

	@ManyToOne(fetch = FetchType.EAGER)

	City origin;
	@ManyToOne(fetch = FetchType.EAGER)

	City destination;

	public Flight() {
	}

	public Flight(Integer cityOne, Integer cityTwo,
			String date_selected, Integer airline, City origin,
			City destination) {
		this.cityOne = cityOne;
		this.cityTwo = cityTwo;
		this.date_selected = date_selected;
		this.airline = airline;
		this.origin = origin;
		this.destination = destination;
	}

	public Flight(Integer cityOne, Integer cityTwo, Integer airline,
			byte luggage, byte layover, String date_selected,
			byte age_of_passenger) {
		super();
		this.cityOne = cityOne;
		this.cityTwo = cityTwo;
		this.airline = airline;
		this.luggage = luggage;
		this.layover = layover;
		this.date_selected = date_selected;
		this.age_of_passenger = age_of_passenger;
	}

	public Integer getCityOne() {
		return cityOne;
	}

	public void setCityOne(Integer cityOne) {
		this.cityOne = cityOne;
	}

	public Integer getCityTwo() {
		return cityTwo;
	}

	public void setCityTwo(Integer cityTwo) {
		this.cityTwo = cityTwo;
	}

	public Integer getAirline() {
		return airline;
	}

	public void setAirline(Integer airline) {
		this.airline = airline;
	}

	public byte getLuggage() {
		return luggage;
	}

	public void setLuggage(byte luggage) {
		this.luggage = luggage;
	}

	public int getLayover() {
		return layover;
	}

	public void setLayover(int i) {
		this.layover = i;
	}

	public String getDate_selected() {
		return date_selected;
	}

	public void setDate_selected(String date_selected) {
		this.date_selected = date_selected;
	}

	public byte getAge_of_passenger() {
		return age_of_passenger;
	}

	public void setAge_of_passenger(byte age_of_passenger) {
		this.age_of_passenger = age_of_passenger;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public City getOrigin() {
		return origin;
	}

	public void setOrigin(City origin) {
		this.origin = origin;
	}

	public City getDestination() {
		return destination;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	@Override
	public String toString() {
		return "Flight [cityOne=" + cityOne + ", cityTwo=" + cityTwo
				+ ", airline=" + airline + ", luggage=" + luggage
				+ ", layover=" + layover + ", date_selected="
				+ date_selected + ", age_of_passenger="
				+ age_of_passenger + "]";
	}

}
