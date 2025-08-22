package com.example.airline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

	Optional<Purchase> findByPurchaseId(Long purchaseId);



}
