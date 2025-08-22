package com.example.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.airline.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

	@Query("SELECT s FROM Seat s WHERE s.airplaneId = :airplaneId "
			+ "AND s.seatId NOT IN (SELECT bp.seatId FROM BoardingPass bp WHERE bp.flightId = :flightId AND bp.seatId IS NOT NULL)")
	List<Seat> findAvailableSeatsByAirplaneId(@Param("airplaneId") Long airplaneId, @Param("flightId") Long flightId);


}
