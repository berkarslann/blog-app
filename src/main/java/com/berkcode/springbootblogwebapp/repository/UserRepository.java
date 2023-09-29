package com.berkcode.springbootblogwebapp.repository;

import com.berkcode.springbootblogwebapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

