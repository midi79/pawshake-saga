package com.anderson.pawshake.sitter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anderson.pawshake.sitter.domain.Sitter;

@Repository
public interface SitterRepository extends JpaRepository<Sitter, Long> {
}

