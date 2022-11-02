package com.assesment.pricesapi.airlinemodel;

public class Petition {
	Integer airline;
	byte luggage;
	double distance;
	byte layover;
	String date_selected;
	byte age_of_passenger;

	public Petition() {
	}

	public Petition(Integer airline, byte luggage, double distance,
			byte layover, String date_selected,
			byte age_of_passenger) {
		super();
		this.airline = airline;
		this.luggage = luggage;
		this.distance = distance;
		this.layover = layover;
		this.date_selected = date_selected;
		this.age_of_passenger = age_of_passenger;
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
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

	@Override
	public String toString() {
		return "Petition [airline=" + airline + ", luggage=" + luggage
				+ ", distance=" + distance + ", layover=" + layover
				+ ", date_selected=" + date_selected
				+ ", age_of_passenger=" + age_of_passenger + "]";
	}

}
