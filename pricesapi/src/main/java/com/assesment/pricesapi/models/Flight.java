package com.assesment.pricesapi.models;

public class Flight {
	Integer cityOne;
	Integer cityTwo;
	Integer airline;
	byte luggage;
	byte layover;
	String date_selected;
	byte age_of_passenger;

	double price;

	public Flight() {
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

	public byte getLayover() {
		return layover;
	}

	public void setLayover(byte layover) {
		this.layover = layover;
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

	@Override
	public String toString() {
		return "Flight [cityOne=" + cityOne + ", cityTwo=" + cityTwo
				+ ", airline=" + airline + ", luggage=" + luggage
				+ ", layover=" + layover + ", date_selected="
				+ date_selected + ", age_of_passenger="
				+ age_of_passenger + "]";
	}

}
