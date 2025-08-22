package com.example.airline.entity;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "airplane")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Airplane {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "airplane_id")
    private Long airplaneId;
	
	@Column(name = "name")
    private String name;
	
	 @Fetch(FetchMode.SELECT)
	  @OneToMany
	  @JoinColumn(name = "airplane_id", referencedColumnName = "airplane_id", insertable = false, updatable = false)
	  private List<Seat> seats;

	 public Long getAirplaneId() {
		 return airplaneId;
	 }

	 public void setAirplaneId(Long airplaneId) {
		 this.airplaneId = airplaneId;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public List<Seat> getSeats() {
		 return seats;
	 }

	 public void setSeats(List<Seat> seats) {
		 this.seats = seats;
	 }
	 
}
