package com.example.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline.entity.SeatType;

public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {


}
