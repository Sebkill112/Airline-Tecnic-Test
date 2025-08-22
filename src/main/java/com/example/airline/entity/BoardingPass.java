package com.example.airline.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "boarding_pass")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BoardingPass {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boarding_pass_id")
    private Long boardingPassId;
    
    @Column(name = "purchase_id")
    private Long purchaseId;
    
    @Column(name = "passenger_id")
    private Long passengerId;
    
    @Column(name = "seat_type_id")
    private Long seatTypeId;
    
    @Column(name = "seat_id")
    private Long seatId;
    
    @Column(name = "flight_id")
    private Long flightId;
    
    @OneToOne
	  @JoinColumn(name = "passenger_id", referencedColumnName = "passenger_id", insertable = false,
	      updatable = false)
	  private Passenger passenger;
    
    @OneToOne
	  @JoinColumn(name = "seat_id", referencedColumnName = "seat_id", insertable = false,
	      updatable = false)
	  private Seat seat;
    
    @OneToOne
    @JoinColumn(name = "seat_type_id", insertable = false, updatable = false)
    private SeatType seatType;
    
    @OneToOne
    @JoinColumn(name = "flight_id", insertable = false, updatable = false)
    private Flight flight;

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

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
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

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
    
}
