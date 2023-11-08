package com.anderson.pawshake.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anderson.pawshake.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

