package com.anderson.pawshake.payment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anderson.pawshake.payment.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	List<Payment> findAllPaymentByUserId(Long userId);
	List<Payment> findAllPaymentBySitterId(Long sitterId);
}