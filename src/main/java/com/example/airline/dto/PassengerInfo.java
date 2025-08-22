package com.example.airline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerInfo {
	
	private Long passengerId;
    private String dni;
    private String name;
    private Integer age;
    private String country;
    private Long boardingPassId;
    private Long purchaseId;
    private Long seatTypeId;
    private Long seatId;
	public Long getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getBoardingPassId() {
		return boardingPassId;
	}
	public void setBoardingPassId(Long boardingPassId) {
		this.boardingPassId = boardingPassId;
	}
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Long getSeatTypeId() {
		return seatTypeId;
	}
	public void setSeatTypeId(Long seatTypeId) {
		this.seatTypeId = seatTypeId;
	}
	public Long getSeatId() {
		return seatId;
	}
	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}
    
}
