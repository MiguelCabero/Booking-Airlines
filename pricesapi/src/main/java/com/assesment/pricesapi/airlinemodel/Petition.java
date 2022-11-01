package com.assesment.pricesapi.airlinemodel;

public class Petition {
	Integer airline;
	byte luggage;
	double distance;
	byte layover;
	int days_left;
	byte age_of_passenger;

	public Petition() {
	}

	public Petition(Integer airline, byte luggage, double distance,
			byte layover, int days_left, byte age_of_passenger) {
		super();
		this.airline = airline;
		this.luggage = luggage;
		this.distance = distance;
		this.layover = layover;
		this.days_left = days_left;
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

	public int getDays_left() {
		return days_left;
	}

	public void setDays_left(int days_left) {
		this.days_left = days_left;
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
				+ ", days_left=" + days_left + ", age_of_passenger="
				+ age_of_passenger + "]";
	}

}
