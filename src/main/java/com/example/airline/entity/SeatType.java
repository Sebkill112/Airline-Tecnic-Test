package com.example.airline.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "seat_type")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SeatType {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_type_id")
    private Long seatTypeId;
    
    @Column(name = "name")
    private String name;

	public Long getSeatTypeId() {
		return seatTypeId;
	}

	public void setSeatTypeId(Long seatTypeId) {
		this.seatTypeId = seatTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
	
}
