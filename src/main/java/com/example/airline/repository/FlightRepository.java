package com.example.airline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	 Optional<Flight> findByFligthId(Long flightId);

}
