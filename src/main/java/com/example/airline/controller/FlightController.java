package com.example.airline.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airline.dto.FlightPassengersData;
import com.example.airline.service.FlightService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	private FlightService flightService;

	@GetMapping("/{id}/passengers")
	public Mono<Map<String, Object>> getFlightPassengers(@PathVariable Long id) {
		return Mono.fromCallable(() -> {
			Map<String, Object> response = new HashMap<>();
			try {
				Optional<FlightPassengersData> result = flightService.getFlightPassengers(id);

				if (result.isEmpty()) {
					response.put("code", 404);
					response.put("data", new HashMap<>());
				} else {
					response.put("code", 200);
					response.put("data", result.get());
				}
			} catch (Exception e) {
				response.put("code", 400);

				if (e.getMessage() != null && (e.getMessage().toLowerCase().contains("connect")
						|| e.getMessage().toLowerCase().contains("connection")
						|| e.getMessage().toLowerCase().contains("timeout"))) {

					response.put("errors", "could not connect to db");
				} else {
					response.put("errors", e.getMessage());
				}
			}
			return response;
		});
	}

}
