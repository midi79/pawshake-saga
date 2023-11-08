package com.anderson.pawshake.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.pawshake.payment.domain.Payment;
import com.anderson.pawshake.payment.domain.PaymentDto;
import com.anderson.pawshake.payment.service.PaymentService;


@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/create")
	public ResponseEntity<Long> createPayment(@RequestBody final PaymentDto payment) {

		Payment newPayment = paymentService.createPayment(payment);
		
		return ResponseEntity.ok(newPayment.getId());
	}	
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable final Long id) {

		Payment payment = paymentService.findById(id);
		
		return ResponseEntity.ok(payment);
	}

	
	@GetMapping("/all")
	public ResponseEntity<List<Payment>> getAllPayment() {

		return ResponseEntity.ok(paymentService.getAllPayment());
	}
	
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Payment>> getAllPaymentByUser(@PathVariable final Long userId) {

		return ResponseEntity.ok(paymentService.getPaymentByUserId(userId));
	}

	
	@GetMapping("/sitter/{sitterId}")
	public ResponseEntity<List<Payment>> getAllPaymentBySitter(@PathVariable final Long sitterId) {

		return ResponseEntity.ok(paymentService.getPaymentBySitterId(sitterId));
	}

	
}
