package com.eduit.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduit.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
