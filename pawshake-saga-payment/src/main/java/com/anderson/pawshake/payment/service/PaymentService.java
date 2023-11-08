package com.anderson.pawshake.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.pawshake.payment.domain.Payment;
import com.anderson.pawshake.payment.domain.PaymentDto;
import com.anderson.pawshake.payment.repository.PaymentRepository;
import com.anderson.pawshake.payment.saga.PaymentFailedException;


@Service
public class PaymentService {
	
	private final String PAY_CANCEL = "PAY_CANCEL";
	private final String PAY_APPROVE = "PAY_APPROVE";
	
	@Autowired
	private PaymentRepository paymentRepository;

	/*
	 * Create payment
	 */
	public Payment createPayment(PaymentDto payment) {				
		Payment newPayment = Payment.createPayment(payment);		
		
		return paymentRepository.save(newPayment);
	}

	/*
	 * Modify payment information
	 */
	public Payment updatePayment(PaymentDto payment) {
		Payment originPayment = paymentRepository.findById(payment.getId()).orElseThrow();
				
		originPayment.setStatus(payment.getStatus());
		originPayment.setReservationId(payment.getReservationId());
		originPayment.setUserId(payment.getUserId());
		originPayment.setSitterId(payment.getSitterId());
		originPayment.setPetId(payment.getPetId());
		originPayment.setPrice(payment.getPrice());
		
		return paymentRepository.save(originPayment);
	}

	/*
	 * Search payment
	 */		
	public Payment findById(Long id) {
		return paymentRepository.findById(id).orElse(null);
	}
	
	/*
	 *  Get all payment
	 */	
	public List<Payment> getAllPayment() {
		return paymentRepository.findAll();
	}
	
	/*
	 *  Get payment by userId
	 */
	public List<Payment> getPaymentByUserId(Long userId) {
		return paymentRepository.findAllPaymentByUserId(userId);
	}
	
	/*
	 *  Get payment by sitterId
	 */
	public List<Payment> getPaymentBySitterId(Long sitterId) {
		return paymentRepository.findAllPaymentBySitterId(sitterId);
	}
	
	/*
	 * Payment saga process 
	 */
	public void paymentProcess(Long reservationId, Long userId, Long sitterId, Long petId, Long price) {
		String status = null;
		
		// Temporary logic for project test
		if (price > 150) {
			status = PAY_CANCEL;
		} else {
			status = PAY_APPROVE;
		}		
				
		PaymentDto payment = new PaymentDto(status, reservationId, userId, sitterId, petId, price);
		paymentRepository.save(Payment.createPayment(payment));
		
		if(status.equals(PAY_CANCEL)) {
			throw new PaymentFailedException();
		}		
	}
	
	/*
	 * Payment choreography saga process
	 */
	public Payment paymentChoreographyProcess(Long reservationId, Long userId, Long sitterId, Long petId, Long price) {
		String status = null;
		
		
		// Temporary logic for project test
		if (price > 150) {
			status = PAY_CANCEL;
		} else {
			status = PAY_APPROVE;
		}		
				
		PaymentDto payment = new PaymentDto(status, reservationId, userId, sitterId, petId, price);
		Payment savedPayment = paymentRepository.save(Payment.createPayment(payment));
		
		return savedPayment;
	}
	
}
