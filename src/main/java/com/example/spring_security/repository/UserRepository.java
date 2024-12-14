package com.example.spring_security.repository;

import com.example.spring_security.entity.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Registered
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
