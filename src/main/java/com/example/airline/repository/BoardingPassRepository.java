package com.example.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline.entity.BoardingPass;

public interface BoardingPassRepository extends JpaRepository<BoardingPass, Long> {

	List<BoardingPass> findByFlightId(Long flightId);


}
