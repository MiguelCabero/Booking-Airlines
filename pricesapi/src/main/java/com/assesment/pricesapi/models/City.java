package com.assesment.pricesapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@JsonIgnore
	private Integer ID;
	@Column
	private String name;
	@Column
	private String country;
	@Column
	@JsonIgnore
	private Integer airline;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JsonIgnore private Airline airline2;
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityOne")
	 * 
	 * @Column private List<Flight> flights;
	 * 
	 * @OneToMany(mappedBy = "cityTwo", fetch = FetchType.EAGER)
	 * 
	 * @Column
	 * 
	 * @JsonIgnore private List<Flight> flights2;
	 */

	public City() {
	}

	public City(Integer iD, String name, String country,
			Integer airline) {
		super();
		ID = iD;
		this.name = name;
		this.country = country;
		this.airline = airline;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
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
		return "City [ID=" + ID + ", name=" + name + ", country="
				+ country + ", airline=" + airline + "]";
	}

	/*
	 * public Airline getAirline2() { return airline2; }
	 * 
	 * public void setAirline2(Airline airline2) { this.airline2 = airline2; }
	 * 
	 * public List<Flight> getFlights() { return flights; }
	 * 
	 * public void setFlights(List<Flight> flights) { this.flights = flights; }
	 * 
	 * public List<Flight> getFlights2() { return flights2; }
	 * 
	 * public void setFlights2(List<Flight> flights2) { this.flights2 = flights2; }
	 */

}
