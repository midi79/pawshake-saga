package com.anderson.pawshake.sitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.pawshake.sitter.domain.Sitter;
import com.anderson.pawshake.sitter.domain.SitterDto;
import com.anderson.pawshake.sitter.service.SitterService;


@RestController
@RequestMapping("/api/v1/sitter")
public class SitterController {

	@Autowired
	private SitterService sitterService;
	
	@PostMapping("/create")
	public ResponseEntity<Long> createSitter(@RequestBody final SitterDto sitter) {

		Sitter createSitter = sitterService.createSitter(sitter);
		
		return ResponseEntity.ok(createSitter.getId());
	}	
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Sitter> getSitter(@PathVariable final Long id) {

		Sitter sitter = sitterService.findById(id);
		
		return ResponseEntity.ok(sitter);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Sitter>> getAllSitter() {

		return ResponseEntity.ok(sitterService.getAllSitter());
	}
	
	@PutMapping("/update/{id}/{status}")
	public ResponseEntity<Sitter> updateSitterStatus(@PathVariable final Long id, @PathVariable final String status) {

		Sitter updateSitter = sitterService.updateStatus(id, status) ;
		
		return ResponseEntity.ok(updateSitter);
	}	

	
}
