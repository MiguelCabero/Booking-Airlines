package com.assesment.pricesapi.models;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "distances")
public class Distance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	int ID;
	@Column
	int cityone;
	@Column
	int citytwo;
	@Column
	int distance;
	@Column
	LocalTime duration;

	public Distance() {
	}

	public Distance(int iD, int cityone, int citytwo, int distance,
			LocalTime duration) {
		super();
		ID = iD;
		this.cityone = cityone;
		this.citytwo = citytwo;
		this.distance = distance;
		this.duration = duration;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getCityone() {
		return cityone;
	}

	public void setCityone(int cityone) {
		this.cityone = cityone;
	}

	public int getCitytwo() {
		return citytwo;
	}

	public void setCitytwo(int citytwo) {
		this.citytwo = citytwo;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Distance [ID=" + ID + ", cityone=" + cityone
				+ ", citytwo=" + citytwo + ", distance=" + distance
				+ ", duration=" + duration + "]";
	}

}
