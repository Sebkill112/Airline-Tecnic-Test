package com.example.airline.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.airline.dto.FlightPassengersData;
import com.example.airline.dto.PassengerInfo;
import com.example.airline.dto.PassengerMapper;
import com.example.airline.entity.BoardingPass;
import com.example.airline.entity.Flight;
import com.example.airline.entity.Seat;
import com.example.airline.repository.BoardingPassRepository;
import com.example.airline.repository.FlightRepository;
import com.example.airline.repository.SeatRepository;

@Service
public class FlightService {
	
	@Autowired
    private FlightRepository flightRepository;
    
    @Autowired
    private BoardingPassRepository boardingPassRepository;
    
    @Autowired
    private SeatRepository seatRepository;
    
    @Autowired
    private SeatAssignmentService seatAssignmentService;
    
    @Autowired
    private PassengerMapper passengerMapper; 

    @Transactional(readOnly = true)
    public Optional<FlightPassengersData> getFlightPassengers(Long flightId) {
    	
        Optional<Flight> flightOpt = flightRepository.findById(flightId);
        if (flightOpt.isEmpty()) {
            return Optional.empty();
        }

        Flight flight = flightOpt.get();

        List<BoardingPass> passes = boardingPassRepository.findByFlightId(flightId);
        
        if (passes.isEmpty()) {
            return Optional.of(buildEmptyResponse(flight));
        }

        List<Seat> availableSeats = seatRepository.findAvailableSeatsByAirplaneId(flight.getAirplaneId(), flightId);

        seatAssignmentService.assignSeats(passes, availableSeats);

        List<PassengerInfo> passengers = passes.stream()
                .map(passengerMapper::toPassengerInfo)
                .collect(Collectors.toList());

        FlightPassengersData dto = new FlightPassengersData();
        dto.setFlightId(flight.getFligthId());
        dto.setTakeoffDateTime(flight.getTakeoffDateTime());
        dto.setTakeoffAirport(flight.getTakeoffAirport());
        dto.setLandingDateTime(flight.getLandingDateTime());
        dto.setLandingAirport(flight.getLandingAirport());
        dto.setAirplaneId(flight.getAirplaneId());
        dto.setPassengers(passengers);

        return Optional.of(dto);
    }
    
    private FlightPassengersData buildEmptyResponse(Flight flight) {
        FlightPassengersData dto = new FlightPassengersData();
        dto.setFlightId(flight.getFligthId());
        dto.setTakeoffDateTime(flight.getTakeoffDateTime());
        dto.setTakeoffAirport(flight.getTakeoffAirport());
        dto.setLandingDateTime(flight.getLandingDateTime());
        dto.setLandingAirport(flight.getLandingAirport());
        dto.setAirplaneId(flight.getAirplaneId());
        dto.setPassengers(new ArrayList<>()); 
        return dto;
    }
}
