package com.assesment.bookingapi.bookingModel;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;

@Entity(name = "bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "airline_id")
	private Integer airlineId;

	@Future
	@Column(name = "date")
	private LocalDateTime localDateTime;

	private int origin;
	private int destination;
	private boolean luggage;
	private double price;

	@Column(name = "passengers_number")
	private int passengersNumber;

	public Booking(Integer id, Integer userId, Integer airlineId,
			LocalDateTime localDateTime, int origin, int destination,
			boolean luggage, double price, int passengersNumber) {
		this.id = id;
		this.userId = userId;
		this.airlineId = airlineId;
		this.localDateTime = localDateTime;
		this.origin = origin;
		this.destination = destination;
		this.luggage = luggage;
		this.price = price;
		this.passengersNumber = passengersNumber;
	}

	// Getters and setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public int getOrigin() {
		return origin;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public boolean isLuggage() {
		return luggage;
	}

	public void setLuggage(boolean luggage) {
		this.luggage = luggage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPassengersNumber() {
		return passengersNumber;
	}

	public void setPassengersNumber(int passengersNumber) {
		this.passengersNumber = passengersNumber;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", userId=" + userId
				+ ", airlineId=" + airlineId + ", localDateTime="
				+ localDateTime + ", origin=" + origin
				+ ", destination=" + destination + ", luggage="
				+ luggage + ", price=" + price + ", passengersNumber="
				+ passengersNumber + "]";
	}

}
