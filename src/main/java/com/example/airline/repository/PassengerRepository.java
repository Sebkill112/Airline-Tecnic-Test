package com.example.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
