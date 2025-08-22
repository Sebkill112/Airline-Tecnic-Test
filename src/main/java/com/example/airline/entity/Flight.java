package com.example.airline.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "flight")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Flight {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flight_id")
    private Long fligthId;
	
	@Column(name = "takeoff_date_time")
	private Long takeoffDateTime;
	
	@Column(name = "takeoff_airport")
    private String takeoffAirport;
	
	@Column(name = "landing_date_time")
    private Long landingDateTime;
	
	@Column(name = "landing_airport")
    private String landingAirport;
	
	@Column(name = "airplane_id")
	private Long airplaneId;
	
	@OneToOne
	  @JoinColumn(name = "airplane_id", referencedColumnName = "airplane_id", insertable = false,
	      updatable = false)
	  private Airplane airplane;

	public Long getFligthId() {
		return fligthId;
	}

	public void setFligthId(Long fligthId) {
		this.fligthId = fligthId;
	}

	public Long getTakeoffDateTime() {
		return takeoffDateTime;
	}

	public void setTakeoffDateTime(Long takeoffDateTime) {
		this.takeoffDateTime = takeoffDateTime;
	}

	public String getTakeoffAirport() {
		return takeoffAirport;
	}

	public void setTakeoffAirport(String takeoffAirport) {
		this.takeoffAirport = takeoffAirport;
	}

	public Long getLandingDateTime() {
		return landingDateTime;
	}

	public void setLandingDateTime(Long landingDateTime) {
		this.landingDateTime = landingDateTime;
	}

	public String getLandingAirport() {
		return landingAirport;
	}

	public void setLandingAirport(String landingAirport) {
		this.landingAirport = landingAirport;
	}

	public Long getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(Long airplaneId) {
		this.airplaneId = airplaneId;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	
}
