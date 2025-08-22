package com.example.airline.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightPassengersData {
	
	private Long flightId;
    private Long takeoffDateTime;
    private String takeoffAirport;
    private Long landingDateTime;
    private String landingAirport;
    private Long airplaneId;
    private List<PassengerInfo> passengers;
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
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
	public List<PassengerInfo> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<PassengerInfo> passengers) {
		this.passengers = passengers;
	}
    
 
}
