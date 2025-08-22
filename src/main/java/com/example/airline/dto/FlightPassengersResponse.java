package com.example.airline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightPassengersResponse {
	
	 private Integer code;
	    private FlightPassengersData data;

}
