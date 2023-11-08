package com.anderson.pawshake.sitter.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.pawshake.sitter.repository.SitterRepository;
import com.anderson.pawshake.sitter.domain.Sitter;
import com.anderson.pawshake.sitter.domain.SitterDto;

@Service
public class SitterService {

	@Autowired
	private SitterRepository sitterRepository;

	/*
	 * Create Sitter
	 */
	public Sitter createSitter(SitterDto sitter) {		
		
		Sitter newSitter = Sitter.createSitter(sitter);		
		
		return sitterRepository.save(newSitter);
	}

	/*
	 * Modify Sitter information
	 */
	public Sitter updateSitter(SitterDto sitter) {
		Sitter originSitter = sitterRepository.findById(sitter.getId()).orElseThrow();
		
		originSitter.setName(sitter.getName());
		originSitter.setAddress(sitter.getAddress());
		originSitter.setEmail(sitter.getEmail());
		originSitter.setPhone(sitter.getPhone());
		originSitter.setServiceType(sitter.getServiceType());
		originSitter.setPrice(sitter.getPrice());
		originSitter.setAvailableTime(sitter.getAvailableTime());
		originSitter.setIntroduce(sitter.getIntroduce());
		originSitter.setExperience(sitter.getExperience());
		originSitter.setLanguage(sitter.getLanguage());
		
		return sitterRepository.save(originSitter);
	}

	
	/*
	 * Update Sitter status information
	 */
	public Sitter updateStatus(Long id, String status) {
		Sitter originSitter = sitterRepository.findById(id).orElseThrow();
		
		originSitter.setStatus(status);
		
		return sitterRepository.save(originSitter);
	}
	
	/*
	 * Search Sitter
	 */		
	public Sitter findById(Long id) {
		return sitterRepository.findById(id).orElseThrow();
	}
	
	/*
	 *  Get all Sitter
	 */	
	public List<Sitter> getAllSitter() {
		return sitterRepository.findAll();
	}

}
