package com.example.musique.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.musique.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}