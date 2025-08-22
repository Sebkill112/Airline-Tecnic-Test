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
@Table(name = "purchase")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Purchase {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_id")
	private Long purchaseId;

	@Column(name = "purchase_date")
	private Long purchaseDate;
	
	 @Fetch(FetchMode.SELECT)
	  @OneToMany
	  @JoinColumn(name = "purchase_id", referencedColumnName = "purchase_id", insertable = false, updatable = false)
	  private List<BoardingPass> boardingPasses;

	 public Long getPurchaseId() {
		 return purchaseId;
	 }

	 public void setPurchaseId(Long purchaseId) {
		 this.purchaseId = purchaseId;
	 }

	 public Long getPurchaseDate() {
		 return purchaseDate;
	 }

	 public void setPurchaseDate(Long purchaseDate) {
		 this.purchaseDate = purchaseDate;
	 }

	 public List<BoardingPass> getBoardingPasses() {
		 return boardingPasses;
	 }

	 public void setBoardingPasses(List<BoardingPass> boardingPasses) {
		 this.boardingPasses = boardingPasses;
	 }
	 

}
